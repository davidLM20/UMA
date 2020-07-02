/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.NonexistentEntityException;
import BDLogica.exceptions.PreexistingEntityException;
import Entidades.Colapedido;
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
 * @author USUARIO
 */
public class ColapedidoJpaController implements Serializable {

    public ColapedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Colapedido colapedido) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(colapedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findColapedido(colapedido.getIdcolaPedido()) != null) {
                throw new PreexistingEntityException("Colapedido " + colapedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Colapedido colapedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            colapedido = em.merge(colapedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = colapedido.getIdcolaPedido();
                if (findColapedido(id) == null) {
                    throw new NonexistentEntityException("The colapedido with id " + id + " no longer exists.");
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
            Colapedido colapedido;
            try {
                colapedido = em.getReference(Colapedido.class, id);
                colapedido.getIdcolaPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The colapedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(colapedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Colapedido> findColapedidoEntities() {
        return findColapedidoEntities(true, -1, -1);
    }

    public List<Colapedido> findColapedidoEntities(int maxResults, int firstResult) {
        return findColapedidoEntities(false, maxResults, firstResult);
    }

    private List<Colapedido> findColapedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Colapedido.class));
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

    public Colapedido findColapedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Colapedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getColapedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Colapedido> rt = cq.from(Colapedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
