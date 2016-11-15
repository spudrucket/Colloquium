/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

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
public class InformantsJpaController implements Serializable {

    public InformantsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Informants informants) {
        if (informants.getInterviewsCollection() == null) {
            informants.setInterviewsCollection(new ArrayList<Interviews>());
        }
        if (informants.getParagraphsCollection() == null) {
            informants.setParagraphsCollection(new ArrayList<Paragraphs>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Interviews> attachedInterviewsCollection = new ArrayList<Interviews>();
            for (Interviews interviewsCollectionInterviewsToAttach : informants.getInterviewsCollection()) {
                interviewsCollectionInterviewsToAttach = em.getReference(interviewsCollectionInterviewsToAttach.getClass(), interviewsCollectionInterviewsToAttach.getId());
                attachedInterviewsCollection.add(interviewsCollectionInterviewsToAttach);
            }
            informants.setInterviewsCollection(attachedInterviewsCollection);
            Collection<Paragraphs> attachedParagraphsCollection = new ArrayList<Paragraphs>();
            for (Paragraphs paragraphsCollectionParagraphsToAttach : informants.getParagraphsCollection()) {
                paragraphsCollectionParagraphsToAttach = em.getReference(paragraphsCollectionParagraphsToAttach.getClass(), paragraphsCollectionParagraphsToAttach.getId());
                attachedParagraphsCollection.add(paragraphsCollectionParagraphsToAttach);
            }
            informants.setParagraphsCollection(attachedParagraphsCollection);
            em.persist(informants);
            for (Interviews interviewsCollectionInterviews : informants.getInterviewsCollection()) {
                Informants oldInformantOfInterviewsCollectionInterviews = interviewsCollectionInterviews.getInformant();
                interviewsCollectionInterviews.setInformant(informants);
                interviewsCollectionInterviews = em.merge(interviewsCollectionInterviews);
                if (oldInformantOfInterviewsCollectionInterviews != null) {
                    oldInformantOfInterviewsCollectionInterviews.getInterviewsCollection().remove(interviewsCollectionInterviews);
                    oldInformantOfInterviewsCollectionInterviews = em.merge(oldInformantOfInterviewsCollectionInterviews);
                }
            }
            for (Paragraphs paragraphsCollectionParagraphs : informants.getParagraphsCollection()) {
                Informants oldInformantOfParagraphsCollectionParagraphs = paragraphsCollectionParagraphs.getInformant();
                paragraphsCollectionParagraphs.setInformant(informants);
                paragraphsCollectionParagraphs = em.merge(paragraphsCollectionParagraphs);
                if (oldInformantOfParagraphsCollectionParagraphs != null) {
                    oldInformantOfParagraphsCollectionParagraphs.getParagraphsCollection().remove(paragraphsCollectionParagraphs);
                    oldInformantOfParagraphsCollectionParagraphs = em.merge(oldInformantOfParagraphsCollectionParagraphs);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Informants informants) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Informants persistentInformants = em.find(Informants.class, informants.getId());
            Collection<Interviews> interviewsCollectionOld = persistentInformants.getInterviewsCollection();
            Collection<Interviews> interviewsCollectionNew = informants.getInterviewsCollection();
            Collection<Paragraphs> paragraphsCollectionOld = persistentInformants.getParagraphsCollection();
            Collection<Paragraphs> paragraphsCollectionNew = informants.getParagraphsCollection();
            List<String> illegalOrphanMessages = null;
            for (Interviews interviewsCollectionOldInterviews : interviewsCollectionOld) {
                if (!interviewsCollectionNew.contains(interviewsCollectionOldInterviews)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Interviews " + interviewsCollectionOldInterviews + " since its informant field is not nullable.");
                }
            }
            for (Paragraphs paragraphsCollectionOldParagraphs : paragraphsCollectionOld) {
                if (!paragraphsCollectionNew.contains(paragraphsCollectionOldParagraphs)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Paragraphs " + paragraphsCollectionOldParagraphs + " since its informant field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Interviews> attachedInterviewsCollectionNew = new ArrayList<Interviews>();
            for (Interviews interviewsCollectionNewInterviewsToAttach : interviewsCollectionNew) {
                interviewsCollectionNewInterviewsToAttach = em.getReference(interviewsCollectionNewInterviewsToAttach.getClass(), interviewsCollectionNewInterviewsToAttach.getId());
                attachedInterviewsCollectionNew.add(interviewsCollectionNewInterviewsToAttach);
            }
            interviewsCollectionNew = attachedInterviewsCollectionNew;
            informants.setInterviewsCollection(interviewsCollectionNew);
            Collection<Paragraphs> attachedParagraphsCollectionNew = new ArrayList<Paragraphs>();
            for (Paragraphs paragraphsCollectionNewParagraphsToAttach : paragraphsCollectionNew) {
                paragraphsCollectionNewParagraphsToAttach = em.getReference(paragraphsCollectionNewParagraphsToAttach.getClass(), paragraphsCollectionNewParagraphsToAttach.getId());
                attachedParagraphsCollectionNew.add(paragraphsCollectionNewParagraphsToAttach);
            }
            paragraphsCollectionNew = attachedParagraphsCollectionNew;
            informants.setParagraphsCollection(paragraphsCollectionNew);
            informants = em.merge(informants);
            for (Interviews interviewsCollectionNewInterviews : interviewsCollectionNew) {
                if (!interviewsCollectionOld.contains(interviewsCollectionNewInterviews)) {
                    Informants oldInformantOfInterviewsCollectionNewInterviews = interviewsCollectionNewInterviews.getInformant();
                    interviewsCollectionNewInterviews.setInformant(informants);
                    interviewsCollectionNewInterviews = em.merge(interviewsCollectionNewInterviews);
                    if (oldInformantOfInterviewsCollectionNewInterviews != null && !oldInformantOfInterviewsCollectionNewInterviews.equals(informants)) {
                        oldInformantOfInterviewsCollectionNewInterviews.getInterviewsCollection().remove(interviewsCollectionNewInterviews);
                        oldInformantOfInterviewsCollectionNewInterviews = em.merge(oldInformantOfInterviewsCollectionNewInterviews);
                    }
                }
            }
            for (Paragraphs paragraphsCollectionNewParagraphs : paragraphsCollectionNew) {
                if (!paragraphsCollectionOld.contains(paragraphsCollectionNewParagraphs)) {
                    Informants oldInformantOfParagraphsCollectionNewParagraphs = paragraphsCollectionNewParagraphs.getInformant();
                    paragraphsCollectionNewParagraphs.setInformant(informants);
                    paragraphsCollectionNewParagraphs = em.merge(paragraphsCollectionNewParagraphs);
                    if (oldInformantOfParagraphsCollectionNewParagraphs != null && !oldInformantOfParagraphsCollectionNewParagraphs.equals(informants)) {
                        oldInformantOfParagraphsCollectionNewParagraphs.getParagraphsCollection().remove(paragraphsCollectionNewParagraphs);
                        oldInformantOfParagraphsCollectionNewParagraphs = em.merge(oldInformantOfParagraphsCollectionNewParagraphs);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = informants.getId();
                if (findInformants(id) == null) {
                    throw new NonexistentEntityException("The informants with id " + id + " no longer exists.");
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
            Informants informants;
            try {
                informants = em.getReference(Informants.class, id);
                informants.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The informants with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Interviews> interviewsCollectionOrphanCheck = informants.getInterviewsCollection();
            for (Interviews interviewsCollectionOrphanCheckInterviews : interviewsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Informants (" + informants + ") cannot be destroyed since the Interviews " + interviewsCollectionOrphanCheckInterviews + " in its interviewsCollection field has a non-nullable informant field.");
            }
            Collection<Paragraphs> paragraphsCollectionOrphanCheck = informants.getParagraphsCollection();
            for (Paragraphs paragraphsCollectionOrphanCheckParagraphs : paragraphsCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Informants (" + informants + ") cannot be destroyed since the Paragraphs " + paragraphsCollectionOrphanCheckParagraphs + " in its paragraphsCollection field has a non-nullable informant field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(informants);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Informants> findInformantsEntities() {
        return findInformantsEntities(true, -1, -1);
    }

    public List<Informants> findInformantsEntities(int maxResults, int firstResult) {
        return findInformantsEntities(false, maxResults, firstResult);
    }

    private List<Informants> findInformantsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Informants.class));
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

    public Informants findInformants(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Informants.class, id);
        } finally {
            em.close();
        }
    }

    public int getInformantsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Informants> rt = cq.from(Informants.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
