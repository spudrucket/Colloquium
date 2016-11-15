/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colloquium;

import colloquium.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Mark_K
 */
public class ParagraphsJpaController implements Serializable {

    public ParagraphsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paragraphs paragraphs) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Informants informant = paragraphs.getInformant();
            if (informant != null) {
                informant = em.getReference(informant.getClass(), informant.getId());
                paragraphs.setInformant(informant);
            }
            Interviews interviewnumber = paragraphs.getInterviewnumber();
            if (interviewnumber != null) {
                interviewnumber = em.getReference(interviewnumber.getClass(), interviewnumber.getId());
                paragraphs.setInterviewnumber(interviewnumber);
            }
            em.persist(paragraphs);
            if (informant != null) {
                informant.getParagraphsCollection().add(paragraphs);
                informant = em.merge(informant);
            }
            if (interviewnumber != null) {
                interviewnumber.getParagraphsCollection().add(paragraphs);
                interviewnumber = em.merge(interviewnumber);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paragraphs paragraphs) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paragraphs persistentParagraphs = em.find(Paragraphs.class, paragraphs.getId());
            Informants informantOld = persistentParagraphs.getInformant();
            Informants informantNew = paragraphs.getInformant();
            Interviews interviewnumberOld = persistentParagraphs.getInterviewnumber();
            Interviews interviewnumberNew = paragraphs.getInterviewnumber();
            if (informantNew != null) {
                informantNew = em.getReference(informantNew.getClass(), informantNew.getId());
                paragraphs.setInformant(informantNew);
            }
            if (interviewnumberNew != null) {
                interviewnumberNew = em.getReference(interviewnumberNew.getClass(), interviewnumberNew.getId());
                paragraphs.setInterviewnumber(interviewnumberNew);
            }
            paragraphs = em.merge(paragraphs);
            if (informantOld != null && !informantOld.equals(informantNew)) {
                informantOld.getParagraphsCollection().remove(paragraphs);
                informantOld = em.merge(informantOld);
            }
            if (informantNew != null && !informantNew.equals(informantOld)) {
                informantNew.getParagraphsCollection().add(paragraphs);
                informantNew = em.merge(informantNew);
            }
            if (interviewnumberOld != null && !interviewnumberOld.equals(interviewnumberNew)) {
                interviewnumberOld.getParagraphsCollection().remove(paragraphs);
                interviewnumberOld = em.merge(interviewnumberOld);
            }
            if (interviewnumberNew != null && !interviewnumberNew.equals(interviewnumberOld)) {
                interviewnumberNew.getParagraphsCollection().add(paragraphs);
                interviewnumberNew = em.merge(interviewnumberNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paragraphs.getId();
                if (findParagraphs(id) == null) {
                    throw new NonexistentEntityException("The paragraphs with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paragraphs paragraphs;
            try {
                paragraphs = em.getReference(Paragraphs.class, id);
                paragraphs.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paragraphs with id " + id + " no longer exists.", enfe);
            }
            Informants informant = paragraphs.getInformant();
            if (informant != null) {
                informant.getParagraphsCollection().remove(paragraphs);
                informant = em.merge(informant);
            }
            Interviews interviewnumber = paragraphs.getInterviewnumber();
            if (interviewnumber != null) {
                interviewnumber.getParagraphsCollection().remove(paragraphs);
                interviewnumber = em.merge(interviewnumber);
            }
            em.remove(paragraphs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Paragraphs> findParagraphsEntities() {
        return findParagraphsEntities(true, -1, -1);
    }

    public List<Paragraphs> findParagraphsEntities(int maxResults, int firstResult) {
        return findParagraphsEntities(false, maxResults, firstResult);
    }

    private List<Paragraphs> findParagraphsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paragraphs.class));
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

    public Paragraphs findParagraphs(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paragraphs.class, id);
        } finally {
            em.close();
        }
    }

    public int getParagraphsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paragraphs> rt = cq.from(Paragraphs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
