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
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import spudrucket.github.io.Colloquium.exceptions.IllegalOrphanException;
import spudrucket.github.io.Colloquium.exceptions.NonexistentEntityException;

/**
 *
 * @author spudrucket
 */
public class TermsJpaController implements Serializable {

    public TermsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Terms terms) {
        if (terms.getUsagesCollection() == null) {
            terms.setUsagesCollection(new ArrayList<Usages>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Usages> attachedUsagesCollection = new ArrayList<Usages>();
            for (Usages usagesCollectionUsagesToAttach : terms.getUsagesCollection()) {
                usagesCollectionUsagesToAttach = em.getReference(usagesCollectionUsagesToAttach.getClass(), usagesCollectionUsagesToAttach.getId());
                attachedUsagesCollection.add(usagesCollectionUsagesToAttach);
            }
            terms.setUsagesCollection(attachedUsagesCollection);
            em.persist(terms);
            for (Usages usagesCollectionUsages : terms.getUsagesCollection()) {
                Terms oldTermOfUsagesCollectionUsages = usagesCollectionUsages.getTerm();
                usagesCollectionUsages.setTerm(terms);
                usagesCollectionUsages = em.merge(usagesCollectionUsages);
                if (oldTermOfUsagesCollectionUsages != null) {
                    oldTermOfUsagesCollectionUsages.getUsagesCollection().remove(usagesCollectionUsages);
                    oldTermOfUsagesCollectionUsages = em.merge(oldTermOfUsagesCollectionUsages);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Terms terms) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Terms persistentTerms = em.find(Terms.class, terms.getId());
            Collection<Usages> usagesCollectionOld = persistentTerms.getUsagesCollection();
            Collection<Usages> usagesCollectionNew = terms.getUsagesCollection();
            List<String> illegalOrphanMessages = null;
            for (Usages usagesCollectionOldUsages : usagesCollectionOld) {
                if (!usagesCollectionNew.contains(usagesCollectionOldUsages)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usages " + usagesCollectionOldUsages + " since its term field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Usages> attachedUsagesCollectionNew = new ArrayList<Usages>();
            for (Usages usagesCollectionNewUsagesToAttach : usagesCollectionNew) {
                usagesCollectionNewUsagesToAttach = em.getReference(usagesCollectionNewUsagesToAttach.getClass(), usagesCollectionNewUsagesToAttach.getId());
                attachedUsagesCollectionNew.add(usagesCollectionNewUsagesToAttach);
            }
            usagesCollectionNew = attachedUsagesCollectionNew;
            terms.setUsagesCollection(usagesCollectionNew);
            terms = em.merge(terms);
            for (Usages usagesCollectionNewUsages : usagesCollectionNew) {
                if (!usagesCollectionOld.contains(usagesCollectionNewUsages)) {
                    Terms oldTermOfUsagesCollectionNewUsages = usagesCollectionNewUsages.getTerm();
                    usagesCollectionNewUsages.setTerm(terms);
                    usagesCollectionNewUsages = em.merge(usagesCollectionNewUsages);
                    if (oldTermOfUsagesCollectionNewUsages != null && !oldTermOfUsagesCollectionNewUsages.equals(terms)) {
                        oldTermOfUsagesCollectionNewUsages.getUsagesCollection().remove(usagesCollectionNewUsages);
                        oldTermOfUsagesCollectionNewUsages = em.merge(oldTermOfUsagesCollectionNewUsages);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = terms.getId();
                if (findTerms(id) == null) {
                    throw new NonexistentEntityException("The terms with id " + id + " no longer exists.");
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
            Terms terms;
            try {
                terms = em.getReference(Terms.class, id);
                terms.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The terms with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Usages> usagesCollectionOrphanCheck = terms.getUsagesCollection();
            for (Usages usagesCollectionOrphanCheckUsages : usagesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Terms (" + terms + ") cannot be destroyed since the Usages " + usagesCollectionOrphanCheckUsages + " in its usagesCollection field has a non-nullable term field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(terms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Terms> findTermsEntities() {
        return findTermsEntities(true, -1, -1);
    }

    public List<Terms> findTermsEntities(int maxResults, int firstResult) {
        return findTermsEntities(false, maxResults, firstResult);
    }

    private List<Terms> findTermsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Terms.class));
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

    public Terms findTerms(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Terms.class, id);
        } finally {
            em.close();
        }
    }

    public int getTermsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Terms> rt = cq.from(Terms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
