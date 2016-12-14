/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spudrucket.github.io.Colloquium;

import colloquium.exceptions.IllegalOrphanException;
import colloquium.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Mark_K
 */
public class InterviewsJpaController implements Serializable {

    public InterviewsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Interviews interviews) {
        if (interviews.getParagraphsCollection() == null) {
            interviews.setParagraphsCollection(new ArrayList<Paragraphs>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Informants informant = interviews.getInformant();
            if (informant != null) {
                informant = em.getReference(informant.getClass(), informant.getId());
                interviews.setInformant(informant);
            }
            Collection<Paragraphs> attachedParagraphsCollection = new ArrayList<Paragraphs>();
            for (Paragraphs paragraphsCollectionParagraphsToAttach : interviews.getParagraphsCollection()) {
                paragraphsCollectionParagraphsToAttach = em.getReference(paragraphsCollectionParagraphsToAttach.getClass(), paragraphsCollectionParagraphsToAttach.getId());
                attachedParagraphsCollection.add(paragraphsCollectionParagraphsToAttach);
            }
            interviews.setParagraphsCollection(attachedParagraphsCollection);
            em.persist(interviews);
            if (informant != null) {
                informant.getInterviewsCollection().add(interviews);
                informant = em.merge(informant);
            }
            for (Paragraphs paragraphsCollectionParagraphs : interviews.getParagraphsCollection()) {
                Interviews oldInterviewnumberOfParagraphsCollectionParagraphs = paragraphsCollectionParagraphs.getInterviewnumber();
                paragraphsCollectionParagraphs.setInterviewnumber(interviews);
                paragraphsCollectionParagraphs = em.merge(paragraphsCollectionParagraphs);
                if (oldInterviewnumberOfParagraphsCollectionParagraphs != null) {
                    oldInterviewnumberOfParagraphsCollectionParagraphs.getParagraphsCollection().remove(paragraphsCollectionParagraphs);
                    oldInterviewnumberOfParagraphsCollectionParagraphs = em.merge(oldInterviewnumberOfParagraphsCollectionParagraphs);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Interviews interviews) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Interviews persistentInterviews = em.find(Interviews.class, interviews.getId());
            Informants informantOld = persistentInterviews.getInformant();
            Informants informantNew = interviews.getInformant();
            Collection<Paragraphs> paragraphsCollectionOld = persistentInterviews.getParagraphsCollection();
            Collection<Paragraphs> paragraphsCollectionNew = interviews.getParagraphsCollection();
            List<String> illegalOrphanMessages = null;
            for (Paragraphs paragraphsCollectionOldParagraphs : paragraphsCollectionOld) {
                if (!paragraphsCollectionNew.contains(paragraphsCollectionOldParagraphs)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Paragraphs " + paragraphsCollectionOldParagraphs + " since its interviewnumber field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (informantNew != null) {
                informantNew = em.getReference(informantNew.getClass(), informantNew.getId());
                interviews.setInformant(informantNew);
            }
            Collection<Paragraphs> attachedParagraphsCollectionNew = new ArrayList<Paragraphs>();
            for (Paragraphs paragraphsCollectionNewParagraphsToAttach : paragraphsCollectionNew) {
                paragraphsCollectionNewParagraphsToAttach = em.getReference(paragraphsCollectionNewParagraphsToAttach.getClass(), paragraphsCollectionNewParagraphsToAttach.getId());
                attachedParagraphsCollectionNew.add(paragraphsCollectionNewParagraphsToAttach);
            }
            paragraphsCollectionNew = attachedParagraphsCollectionNew;
            interviews.setParagraphsCollection(paragraphsCollectionNew);
            interviews = em.merge(interviews);
            if (informantOld != null && !informantOld.equals(informantNew)) {
                informantOld.getInterviewsCollection().remove(interviews);
                informantOld = em.merge(informantOld);
            }
            if (informantNew != null && !informantNew.equals(informantOld)) {
                informantNew.getInterviewsCollection().add(interviews);
                informantNew = em.merge(informantNew);
            }
            for (Paragraphs paragraphsCollectionNewParagraphs : paragraphsCollectionNew) {
                if (!paragraphsCollectionOld.contains(paragraphsCollectionNewParagraphs)) {
                    Interviews oldInterviewnumberOfParagraphsCollectionNewParagraphs = paragraphsCollectionNewParagraphs.getInterviewnumber();
                    paragraphsCollectionNewParagraphs.setInterviewnumber(interviews);
                    paragraphsCollectionNewParagraphs = em.merge(paragraphsCollectionNewParagraphs);
                    if (oldInterviewnumberOfParagraphsCollectionNewParagraphs != null && !oldInterviewnumberOfParagraphsCollectionNewParagraphs.equals(interviews)) {
                        oldInterviewnumberOfParagraphsCollectionNewParagraphs.getParagraphsCollection().remove(paragraphsCollectionNewParagraphs);
                        oldInterviewnumberOfParagraphsCollectionNewParagraphs = em.merge(oldInterviewnumberOfParagraphsCollectionNewParagraphs);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = interviews.getId();
                if (findInterviews(id) == null) {
                    throw new NonexistentEntityException("The interviews with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Interviews interviews;
            try {
                interviews = em.getReference(Interviews.class, id);
                interviews.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The interviews with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Paragraphs> paragraphsCollectionOrphanCheck = interviews.getParagraphsCollection();
            for (Paragraphs paragraphsCollectionOrphanCheckParagraphs : paragraphsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Interviews (" + interviews + ") cannot be destroyed since the Paragraphs " + paragraphsCollectionOrphanCheckParagraphs + " in its paragraphsCollection field has a non-nullable interviewnumber field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Informants informant = interviews.getInformant();
            if (informant != null) {
                informant.getInterviewsCollection().remove(interviews);
                informant = em.merge(informant);
            }
            em.remove(interviews);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Interviews> findInterviewsEntities() {
        return findInterviewsEntities(true, -1, -1);
    }

    public List<Interviews> findInterviewsEntities(int maxResults, int firstResult) {
        return findInterviewsEntities(false, maxResults, firstResult);
    }

    private List<Interviews> findInterviewsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Interviews.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Interviews findInterviews(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Interviews.class, id);
        } finally {
            em.close();
        }
    }

    public int getInterviewsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Interviews> rt = cq.from(Interviews.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
