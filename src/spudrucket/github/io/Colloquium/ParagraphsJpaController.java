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
public class ParagraphsJpaController implements Serializable {

    public ParagraphsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paragraphs paragraphs) {
        if (paragraphs.getUsagesCollection() == null) {
            paragraphs.setUsagesCollection(new ArrayList<Usages>());
        }
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
            Collection<Usages> attachedUsagesCollection = new ArrayList<Usages>();
            for (Usages usagesCollectionUsagesToAttach : paragraphs.getUsagesCollection()) {
                usagesCollectionUsagesToAttach = em.getReference(usagesCollectionUsagesToAttach.getClass(), usagesCollectionUsagesToAttach.getId());
                attachedUsagesCollection.add(usagesCollectionUsagesToAttach);
            }
            paragraphs.setUsagesCollection(attachedUsagesCollection);
            em.persist(paragraphs);
            if (informant != null) {
                informant.getParagraphsCollection().add(paragraphs);
                informant = em.merge(informant);
            }
            if (interviewnumber != null) {
                interviewnumber.getParagraphsCollection().add(paragraphs);
                interviewnumber = em.merge(interviewnumber);
            }
            for (Usages usagesCollectionUsages : paragraphs.getUsagesCollection()) {
                Paragraphs oldParagraphOfUsagesCollectionUsages = usagesCollectionUsages.getParagraph();
                usagesCollectionUsages.setParagraph(paragraphs);
                usagesCollectionUsages = em.merge(usagesCollectionUsages);
                if (oldParagraphOfUsagesCollectionUsages != null) {
                    oldParagraphOfUsagesCollectionUsages.getUsagesCollection().remove(usagesCollectionUsages);
                    oldParagraphOfUsagesCollectionUsages = em.merge(oldParagraphOfUsagesCollectionUsages);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paragraphs paragraphs) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paragraphs persistentParagraphs = em.find(Paragraphs.class, paragraphs.getId());
            Informants informantOld = persistentParagraphs.getInformant();
            Informants informantNew = paragraphs.getInformant();
            Interviews interviewnumberOld = persistentParagraphs.getInterviewnumber();
            Interviews interviewnumberNew = paragraphs.getInterviewnumber();
            Collection<Usages> usagesCollectionOld = persistentParagraphs.getUsagesCollection();
            Collection<Usages> usagesCollectionNew = paragraphs.getUsagesCollection();
            List<String> illegalOrphanMessages = null;
            for (Usages usagesCollectionOldUsages : usagesCollectionOld) {
                if (!usagesCollectionNew.contains(usagesCollectionOldUsages)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usages " + usagesCollectionOldUsages + " since its paragraph field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (informantNew != null) {
                informantNew = em.getReference(informantNew.getClass(), informantNew.getId());
                paragraphs.setInformant(informantNew);
            }
            if (interviewnumberNew != null) {
                interviewnumberNew = em.getReference(interviewnumberNew.getClass(), interviewnumberNew.getId());
                paragraphs.setInterviewnumber(interviewnumberNew);
            }
            Collection<Usages> attachedUsagesCollectionNew = new ArrayList<Usages>();
            for (Usages usagesCollectionNewUsagesToAttach : usagesCollectionNew) {
                usagesCollectionNewUsagesToAttach = em.getReference(usagesCollectionNewUsagesToAttach.getClass(), usagesCollectionNewUsagesToAttach.getId());
                attachedUsagesCollectionNew.add(usagesCollectionNewUsagesToAttach);
            }
            usagesCollectionNew = attachedUsagesCollectionNew;
            paragraphs.setUsagesCollection(usagesCollectionNew);
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
            for (Usages usagesCollectionNewUsages : usagesCollectionNew) {
                if (!usagesCollectionOld.contains(usagesCollectionNewUsages)) {
                    Paragraphs oldParagraphOfUsagesCollectionNewUsages = usagesCollectionNewUsages.getParagraph();
                    usagesCollectionNewUsages.setParagraph(paragraphs);
                    usagesCollectionNewUsages = em.merge(usagesCollectionNewUsages);
                    if (oldParagraphOfUsagesCollectionNewUsages != null && !oldParagraphOfUsagesCollectionNewUsages.equals(paragraphs)) {
                        oldParagraphOfUsagesCollectionNewUsages.getUsagesCollection().remove(usagesCollectionNewUsages);
                        oldParagraphOfUsagesCollectionNewUsages = em.merge(oldParagraphOfUsagesCollectionNewUsages);
                    }
                }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Usages> usagesCollectionOrphanCheck = paragraphs.getUsagesCollection();
            for (Usages usagesCollectionOrphanCheckUsages : usagesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paragraphs (" + paragraphs + ") cannot be destroyed since the Usages " + usagesCollectionOrphanCheckUsages + " in its usagesCollection field has a non-nullable paragraph field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
