/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.NonexistentEntityException;
import Entidades.Mesero;
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
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class LogMesero implements Serializable {

    public LogMesero() {
        this.emf = Persistence.createEntityManagerFactory("UMAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mesero mesero) {
        if (mesero.getPedidoCollection() == null) {
            mesero.setPedidoCollection(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : mesero.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getIdPedido());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            mesero.setPedidoCollection(attachedPedidoCollection);
            em.persist(mesero);
            for (Pedido pedidoCollectionPedido : mesero.getPedidoCollection()) {
                Mesero oldIdMeseroOfPedidoCollectionPedido = pedidoCollectionPedido.getIdMesero();
                pedidoCollectionPedido.setIdMesero(mesero);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldIdMeseroOfPedidoCollectionPedido != null) {
                    oldIdMeseroOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldIdMeseroOfPedidoCollectionPedido = em.merge(oldIdMeseroOfPedidoCollectionPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mesero mesero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mesero persistentMesero = em.find(Mesero.class, mesero.getIdMesero());
            Collection<Pedido> pedidoCollectionOld = persistentMesero.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = mesero.getPedidoCollection();
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getIdPedido());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            mesero.setPedidoCollection(pedidoCollectionNew);
            mesero = em.merge(mesero);
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setIdMesero(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Mesero oldIdMeseroOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getIdMesero();
                    pedidoCollectionNewPedido.setIdMesero(mesero);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldIdMeseroOfPedidoCollectionNewPedido != null && !oldIdMeseroOfPedidoCollectionNewPedido.equals(mesero)) {
                        oldIdMeseroOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldIdMeseroOfPedidoCollectionNewPedido = em.merge(oldIdMeseroOfPedidoCollectionNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mesero.getIdMesero();
                if (findMesero(id) == null) {
                    throw new NonexistentEntityException("The mesero with id " + id + " no longer exists.");
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
            Mesero mesero;
            try {
                mesero = em.getReference(Mesero.class, id);
                mesero.getIdMesero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mesero with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedido> pedidoCollection = mesero.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setIdMesero(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            em.remove(mesero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mesero> findMeseroEntities() {
        return findMeseroEntities(true, -1, -1);
    }

    public List<Mesero> findMeseroEntities(int maxResults, int firstResult) {
        return findMeseroEntities(false, maxResults, firstResult);
    }

    private List<Mesero> findMeseroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mesero.class));
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

    public Mesero findMesero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mesero.class, id);
        } finally {
            em.close();
        }
    }

    public int getMeseroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mesero> rt = cq.from(Mesero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
