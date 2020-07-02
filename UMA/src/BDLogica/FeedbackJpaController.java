/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Factura;
import Entidades.Feedback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class FeedbackJpaController implements Serializable {

    public FeedbackJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Feedback feedback) {
        if (feedback.getFacturaCollection() == null) {
            feedback.setFacturaCollection(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Factura> attachedFacturaCollection = new ArrayList<Factura>();
            for (Factura facturaCollectionFacturaToAttach : feedback.getFacturaCollection()) {
                facturaCollectionFacturaToAttach = em.getReference(facturaCollectionFacturaToAttach.getClass(), facturaCollectionFacturaToAttach.getIdFactura());
                attachedFacturaCollection.add(facturaCollectionFacturaToAttach);
            }
            feedback.setFacturaCollection(attachedFacturaCollection);
            em.persist(feedback);
            for (Factura facturaCollectionFactura : feedback.getFacturaCollection()) {
                Feedback oldIdFeedBackOfFacturaCollectionFactura = facturaCollectionFactura.getIdFeedBack();
                facturaCollectionFactura.setIdFeedBack(feedback);
                facturaCollectionFactura = em.merge(facturaCollectionFactura);
                if (oldIdFeedBackOfFacturaCollectionFactura != null) {
                    oldIdFeedBackOfFacturaCollectionFactura.getFacturaCollection().remove(facturaCollectionFactura);
                    oldIdFeedBackOfFacturaCollectionFactura = em.merge(oldIdFeedBackOfFacturaCollectionFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Feedback feedback) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Feedback persistentFeedback = em.find(Feedback.class, feedback.getIdFeedBack());
            Collection<Factura> facturaCollectionOld = persistentFeedback.getFacturaCollection();
            Collection<Factura> facturaCollectionNew = feedback.getFacturaCollection();
            Collection<Factura> attachedFacturaCollectionNew = new ArrayList<Factura>();
            for (Factura facturaCollectionNewFacturaToAttach : facturaCollectionNew) {
                facturaCollectionNewFacturaToAttach = em.getReference(facturaCollectionNewFacturaToAttach.getClass(), facturaCollectionNewFacturaToAttach.getIdFactura());
                attachedFacturaCollectionNew.add(facturaCollectionNewFacturaToAttach);
            }
            facturaCollectionNew = attachedFacturaCollectionNew;
            feedback.setFacturaCollection(facturaCollectionNew);
            feedback = em.merge(feedback);
            for (Factura facturaCollectionOldFactura : facturaCollectionOld) {
                if (!facturaCollectionNew.contains(facturaCollectionOldFactura)) {
                    facturaCollectionOldFactura.setIdFeedBack(null);
                    facturaCollectionOldFactura = em.merge(facturaCollectionOldFactura);
                }
            }
            for (Factura facturaCollectionNewFactura : facturaCollectionNew) {
                if (!facturaCollectionOld.contains(facturaCollectionNewFactura)) {
                    Feedback oldIdFeedBackOfFacturaCollectionNewFactura = facturaCollectionNewFactura.getIdFeedBack();
                    facturaCollectionNewFactura.setIdFeedBack(feedback);
                    facturaCollectionNewFactura = em.merge(facturaCollectionNewFactura);
                    if (oldIdFeedBackOfFacturaCollectionNewFactura != null && !oldIdFeedBackOfFacturaCollectionNewFactura.equals(feedback)) {
                        oldIdFeedBackOfFacturaCollectionNewFactura.getFacturaCollection().remove(facturaCollectionNewFactura);
                        oldIdFeedBackOfFacturaCollectionNewFactura = em.merge(oldIdFeedBackOfFacturaCollectionNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = feedback.getIdFeedBack();
                if (findFeedback(id) == null) {
                    throw new NonexistentEntityException("The feedback with id " + id + " no longer exists.");
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
            Feedback feedback;
            try {
                feedback = em.getReference(Feedback.class, id);
                feedback.getIdFeedBack();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The feedback with id " + id + " no longer exists.", enfe);
            }
            Collection<Factura> facturaCollection = feedback.getFacturaCollection();
            for (Factura facturaCollectionFactura : facturaCollection) {
                facturaCollectionFactura.setIdFeedBack(null);
                facturaCollectionFactura = em.merge(facturaCollectionFactura);
            }
            em.remove(feedback);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Feedback> findFeedbackEntities() {
        return findFeedbackEntities(true, -1, -1);
    }

    public List<Feedback> findFeedbackEntities(int maxResults, int firstResult) {
        return findFeedbackEntities(false, maxResults, firstResult);
    }

    private List<Feedback> findFeedbackEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Feedback.class));
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

    public Feedback findFeedback(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Feedback.class, id);
        } finally {
            em.close();
        }
    }

    public int getFeedbackCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Feedback> rt = cq.from(Feedback.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
