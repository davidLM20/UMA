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
import Entidades.Pedido;
import Entidades.Plato;
import Entidades.PlatoPedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class LogPlatopedido implements Serializable {

    public LogPlatopedido() {
        this.emf = Persistence.createEntityManagerFactory("UMAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PlatoPedido platopedido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido idPedido = platopedido.getIdPedido();
            if (idPedido != null) {
                idPedido = em.getReference(idPedido.getClass(), idPedido.getIdPedido());
                platopedido.setIdPedido(idPedido);
            }
            Plato idPlato = platopedido.getIdPlato();
            if (idPlato != null) {
                idPlato = em.getReference(idPlato.getClass(), idPlato.getIdPlato());
                platopedido.setIdPlato(idPlato);
            }
            em.persist(platopedido);
            if (idPedido != null) {
                idPedido.getPlatopedidoCollection().add(platopedido);
                idPedido = em.merge(idPedido);
            }
            if (idPlato != null) {
                idPlato.getPlatopedidoCollection().add(platopedido);
                idPlato = em.merge(idPlato);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PlatoPedido platopedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PlatoPedido persistentPlatopedido = em.find(PlatoPedido.class, platopedido.getIdPlatoPedido());
            Pedido idPedidoOld = persistentPlatopedido.getIdPedido();
            Pedido idPedidoNew = platopedido.getIdPedido();
            Plato idPlatoOld = persistentPlatopedido.getIdPlato();
            Plato idPlatoNew = platopedido.getIdPlato();
            if (idPedidoNew != null) {
                idPedidoNew = em.getReference(idPedidoNew.getClass(), idPedidoNew.getIdPedido());
                platopedido.setIdPedido(idPedidoNew);
            }
            if (idPlatoNew != null) {
                idPlatoNew = em.getReference(idPlatoNew.getClass(), idPlatoNew.getIdPlato());
                platopedido.setIdPlato(idPlatoNew);
            }
            platopedido = em.merge(platopedido);
            if (idPedidoOld != null && !idPedidoOld.equals(idPedidoNew)) {
                idPedidoOld.getPlatopedidoCollection().remove(platopedido);
                idPedidoOld = em.merge(idPedidoOld);
            }
            if (idPedidoNew != null && !idPedidoNew.equals(idPedidoOld)) {
                idPedidoNew.getPlatopedidoCollection().add(platopedido);
                idPedidoNew = em.merge(idPedidoNew);
            }
            if (idPlatoOld != null && !idPlatoOld.equals(idPlatoNew)) {
                idPlatoOld.getPlatopedidoCollection().remove(platopedido);
                idPlatoOld = em.merge(idPlatoOld);
            }
            if (idPlatoNew != null && !idPlatoNew.equals(idPlatoOld)) {
                idPlatoNew.getPlatopedidoCollection().add(platopedido);
                idPlatoNew = em.merge(idPlatoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = platopedido.getIdPlatoPedido();
                if (findPlatopedido(id) == null) {
                    throw new NonexistentEntityException("The platopedido with id " + id + " no longer exists.");
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
            PlatoPedido platopedido;
            try {
                platopedido = em.getReference(PlatoPedido.class, id);
                platopedido.getIdPlatoPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The platopedido with id " + id + " no longer exists.", enfe);
            }
            Pedido idPedido = platopedido.getIdPedido();
            if (idPedido != null) {
                idPedido.getPlatopedidoCollection().remove(platopedido);
                idPedido = em.merge(idPedido);
            }
            Plato idPlato = platopedido.getIdPlato();
            if (idPlato != null) {
                idPlato.getPlatopedidoCollection().remove(platopedido);
                idPlato = em.merge(idPlato);
            }
            em.remove(platopedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PlatoPedido> findPlatopedidoEntities() {
        return findPlatopedidoEntities(true, -1, -1);
    }

    public List<PlatoPedido> findPlatopedidoEntities(int maxResults, int firstResult) {
        return findPlatopedidoEntities(false, maxResults, firstResult);
    }

    private List<PlatoPedido> findPlatopedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PlatoPedido.class));
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

    public PlatoPedido findPlatopedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PlatoPedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlatopedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PlatoPedido> rt = cq.from(PlatoPedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
