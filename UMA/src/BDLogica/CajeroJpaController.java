/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.NonexistentEntityException;
import Entidades.Cajero;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Pedido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class CajeroJpaController implements Serializable {

    public CajeroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cajero cajero) {
        if (cajero.getPedidoCollection() == null) {
            cajero.setPedidoCollection(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : cajero.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getIdPedido());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            cajero.setPedidoCollection(attachedPedidoCollection);
            em.persist(cajero);
            for (Pedido pedidoCollectionPedido : cajero.getPedidoCollection()) {
                Cajero oldIdCajeroOfPedidoCollectionPedido = pedidoCollectionPedido.getIdCajero();
                pedidoCollectionPedido.setIdCajero(cajero);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldIdCajeroOfPedidoCollectionPedido != null) {
                    oldIdCajeroOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldIdCajeroOfPedidoCollectionPedido = em.merge(oldIdCajeroOfPedidoCollectionPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cajero cajero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cajero persistentCajero = em.find(Cajero.class, cajero.getIdCajero());
            Collection<Pedido> pedidoCollectionOld = persistentCajero.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = cajero.getPedidoCollection();
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getIdPedido());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            cajero.setPedidoCollection(pedidoCollectionNew);
            cajero = em.merge(cajero);
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setIdCajero(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Cajero oldIdCajeroOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getIdCajero();
                    pedidoCollectionNewPedido.setIdCajero(cajero);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldIdCajeroOfPedidoCollectionNewPedido != null && !oldIdCajeroOfPedidoCollectionNewPedido.equals(cajero)) {
                        oldIdCajeroOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldIdCajeroOfPedidoCollectionNewPedido = em.merge(oldIdCajeroOfPedidoCollectionNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cajero.getIdCajero();
                if (findCajero(id) == null) {
                    throw new NonexistentEntityException("The cajero with id " + id + " no longer exists.");
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
            Cajero cajero;
            try {
                cajero = em.getReference(Cajero.class, id);
                cajero.getIdCajero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cajero with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedido> pedidoCollection = cajero.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setIdCajero(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            em.remove(cajero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cajero> findCajeroEntities() {
        return findCajeroEntities(true, -1, -1);
    }

    public List<Cajero> findCajeroEntities(int maxResults, int firstResult) {
        return findCajeroEntities(false, maxResults, firstResult);
    }

    private List<Cajero> findCajeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cajero.class));
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

    public Cajero findCajero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cajero.class, id);
        } finally {
            em.close();
        }
    }

    public int getCajeroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cajero> rt = cq.from(Cajero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
