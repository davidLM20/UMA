/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.NonexistentEntityException;
import Entidades.Cocinero;
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
public class CocineroJpaController implements Serializable {

    public CocineroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cocinero cocinero) {
        if (cocinero.getPedidoCollection() == null) {
            cocinero.setPedidoCollection(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : cocinero.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getIdPedido());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            cocinero.setPedidoCollection(attachedPedidoCollection);
            em.persist(cocinero);
            for (Pedido pedidoCollectionPedido : cocinero.getPedidoCollection()) {
                Cocinero oldIdCocineroOfPedidoCollectionPedido = pedidoCollectionPedido.getIdCocinero();
                pedidoCollectionPedido.setIdCocinero(cocinero);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldIdCocineroOfPedidoCollectionPedido != null) {
                    oldIdCocineroOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldIdCocineroOfPedidoCollectionPedido = em.merge(oldIdCocineroOfPedidoCollectionPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cocinero cocinero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cocinero persistentCocinero = em.find(Cocinero.class, cocinero.getIdCocinero());
            Collection<Pedido> pedidoCollectionOld = persistentCocinero.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = cocinero.getPedidoCollection();
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getIdPedido());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            cocinero.setPedidoCollection(pedidoCollectionNew);
            cocinero = em.merge(cocinero);
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setIdCocinero(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Cocinero oldIdCocineroOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getIdCocinero();
                    pedidoCollectionNewPedido.setIdCocinero(cocinero);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldIdCocineroOfPedidoCollectionNewPedido != null && !oldIdCocineroOfPedidoCollectionNewPedido.equals(cocinero)) {
                        oldIdCocineroOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldIdCocineroOfPedidoCollectionNewPedido = em.merge(oldIdCocineroOfPedidoCollectionNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cocinero.getIdCocinero();
                if (findCocinero(id) == null) {
                    throw new NonexistentEntityException("The cocinero with id " + id + " no longer exists.");
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
            Cocinero cocinero;
            try {
                cocinero = em.getReference(Cocinero.class, id);
                cocinero.getIdCocinero();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cocinero with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedido> pedidoCollection = cocinero.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setIdCocinero(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            em.remove(cocinero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cocinero> findCocineroEntities() {
        return findCocineroEntities(true, -1, -1);
    }

    public List<Cocinero> findCocineroEntities(int maxResults, int firstResult) {
        return findCocineroEntities(false, maxResults, firstResult);
    }

    private List<Cocinero> findCocineroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cocinero.class));
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

    public Cocinero findCocinero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cocinero.class, id);
        } finally {
            em.close();
        }
    }

    public int getCocineroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cocinero> rt = cq.from(Cocinero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
