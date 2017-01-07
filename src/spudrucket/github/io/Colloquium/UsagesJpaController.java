/*
 * Copyright (C) 2016 Mark_K
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package spudrucket.github.io.Colloquium;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import spudrucket.github.io.Colloquium.exceptions.NonexistentEntityException;

/**
 *
 * @author spudrucket
 */
public class UsagesJpaController implements Serializable {

    public UsagesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usages usages) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paragraphs paragraph = usages.getParagraph();
            if (paragraph != null) {
                paragraph = em.getReference(paragraph.getClass(), paragraph.getId());
                usages.setParagraph(paragraph);
            }
            Terms term = usages.getTerm();
            if (term != null) {
                term = em.getReference(term.getClass(), term.getId());
                usages.setTerm(term);
            }
            em.persist(usages);
            if (paragraph != null) {
                paragraph.getUsagesCollection().add(usages);
                paragraph = em.merge(paragraph);
            }
            if (term != null) {
                term.getUsagesCollection().add(usages);
                term = em.merge(term);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usages usages) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usages persistentUsages = em.find(Usages.class, usages.getId());
            Paragraphs paragraphOld = persistentUsages.getParagraph();
            Paragraphs paragraphNew = usages.getParagraph();
            Terms termOld = persistentUsages.getTerm();
            Terms termNew = usages.getTerm();
            if (paragraphNew != null) {
                paragraphNew = em.getReference(paragraphNew.getClass(), paragraphNew.getId());
                usages.setParagraph(paragraphNew);
            }
            if (termNew != null) {
                termNew = em.getReference(termNew.getClass(), termNew.getId());
                usages.setTerm(termNew);
            }
            usages = em.merge(usages);
            if (paragraphOld != null && !paragraphOld.equals(paragraphNew)) {
                paragraphOld.getUsagesCollection().remove(usages);
                paragraphOld = em.merge(paragraphOld);
            }
            if (paragraphNew != null && !paragraphNew.equals(paragraphOld)) {
                paragraphNew.getUsagesCollection().add(usages);
                paragraphNew = em.merge(paragraphNew);
            }
            if (termOld != null && !termOld.equals(termNew)) {
                termOld.getUsagesCollection().remove(usages);
                termOld = em.merge(termOld);
            }
            if (termNew != null && !termNew.equals(termOld)) {
                termNew.getUsagesCollection().add(usages);
                termNew = em.merge(termNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usages.getId();
                if (findUsages(id) == null) {
                    throw new NonexistentEntityException("The usages with id " + id + " no longer exists.");
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
            Usages usages;
            try {
                usages = em.getReference(Usages.class, id);
                usages.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usages with id " + id + " no longer exists.", enfe);
            }
            Paragraphs paragraph = usages.getParagraph();
            if (paragraph != null) {
                paragraph.getUsagesCollection().remove(usages);
                paragraph = em.merge(paragraph);
            }
            Terms term = usages.getTerm();
            if (term != null) {
                term.getUsagesCollection().remove(usages);
                term = em.merge(term);
            }
            em.remove(usages);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usages> findUsagesEntities() {
        return findUsagesEntities(true, -1, -1);
    }

    public List<Usages> findUsagesEntities(int maxResults, int firstResult) {
        return findUsagesEntities(false, maxResults, firstResult);
    }

    private List<Usages> findUsagesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usages.class));
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

    public Usages findUsages(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usages.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsagesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usages> rt = cq.from(Usages.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
