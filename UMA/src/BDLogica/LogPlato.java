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
import java.util.ArrayList;
import java.util.Collection;
import Entidades.Menu;
import Entidades.Plato;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class LogPlato implements Serializable {

    public LogPlato() {
        this.emf = Persistence.createEntityManagerFactory("UMAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Plato plato) {
        if (plato.getPedidoCollection() == null) {
            plato.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (plato.getMenuCollection() == null) {
            plato.setMenuCollection(new ArrayList<Menu>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : plato.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getIdPedido());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            plato.setPedidoCollection(attachedPedidoCollection);
            Collection<Menu> attachedMenuCollection = new ArrayList<Menu>();
            for (Menu menuCollectionMenuToAttach : plato.getMenuCollection()) {
                menuCollectionMenuToAttach = em.getReference(menuCollectionMenuToAttach.getClass(), menuCollectionMenuToAttach.getIdMenu());
                attachedMenuCollection.add(menuCollectionMenuToAttach);
            }
            plato.setMenuCollection(attachedMenuCollection);
            em.persist(plato);
            for (Pedido pedidoCollectionPedido : plato.getPedidoCollection()) {
                pedidoCollectionPedido.getPlatoCollection().add(plato);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            for (Menu menuCollectionMenu : plato.getMenuCollection()) {
                menuCollectionMenu.getPlatoCollection().add(plato);
                menuCollectionMenu = em.merge(menuCollectionMenu);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Plato plato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Plato persistentPlato = em.find(Plato.class, plato.getIdPlato());
            Collection<Pedido> pedidoCollectionOld = persistentPlato.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = plato.getPedidoCollection();
            Collection<Menu> menuCollectionOld = persistentPlato.getMenuCollection();
            Collection<Menu> menuCollectionNew = plato.getMenuCollection();
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getIdPedido());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            plato.setPedidoCollection(pedidoCollectionNew);
            Collection<Menu> attachedMenuCollectionNew = new ArrayList<Menu>();
            for (Menu menuCollectionNewMenuToAttach : menuCollectionNew) {
                menuCollectionNewMenuToAttach = em.getReference(menuCollectionNewMenuToAttach.getClass(), menuCollectionNewMenuToAttach.getIdMenu());
                attachedMenuCollectionNew.add(menuCollectionNewMenuToAttach);
            }
            menuCollectionNew = attachedMenuCollectionNew;
            plato.setMenuCollection(menuCollectionNew);
            plato = em.merge(plato);
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.getPlatoCollection().remove(plato);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    pedidoCollectionNewPedido.getPlatoCollection().add(plato);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                }
            }
            for (Menu menuCollectionOldMenu : menuCollectionOld) {
                if (!menuCollectionNew.contains(menuCollectionOldMenu)) {
                    menuCollectionOldMenu.getPlatoCollection().remove(plato);
                    menuCollectionOldMenu = em.merge(menuCollectionOldMenu);
                }
            }
            for (Menu menuCollectionNewMenu : menuCollectionNew) {
                if (!menuCollectionOld.contains(menuCollectionNewMenu)) {
                    menuCollectionNewMenu.getPlatoCollection().add(plato);
                    menuCollectionNewMenu = em.merge(menuCollectionNewMenu);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = plato.getIdPlato();
                if (findPlato(id) == null) {
                    throw new NonexistentEntityException("The plato with id " + id + " no longer exists.");
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
            Plato plato;
            try {
                plato = em.getReference(Plato.class, id);
                plato.getIdPlato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The plato with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedido> pedidoCollection = plato.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.getPlatoCollection().remove(plato);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            Collection<Menu> menuCollection = plato.getMenuCollection();
            for (Menu menuCollectionMenu : menuCollection) {
                menuCollectionMenu.getPlatoCollection().remove(plato);
                menuCollectionMenu = em.merge(menuCollectionMenu);
            }
            em.remove(plato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Plato> findPlatoEntities() {
        return findPlatoEntities(true, -1, -1);
    }

    public List<Plato> findPlatoEntities(int maxResults, int firstResult) {
        return findPlatoEntities(false, maxResults, firstResult);
    }

    private List<Plato> findPlatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Plato.class));
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

    public Plato findPlato(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Plato.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Plato> rt = cq.from(Plato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
