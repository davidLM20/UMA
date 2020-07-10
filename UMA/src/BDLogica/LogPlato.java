/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.IllegalOrphanException;
import BDLogica.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Menu;
import Entidades.Plato;
import java.util.ArrayList;
import java.util.Collection;
import Entidades.Platopedido;
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
        if (plato.getMenuCollection() == null) {
            plato.setMenuCollection(new ArrayList<Menu>());
        }
        if (plato.getPlatopedidoCollection() == null) {
            plato.setPlatopedidoCollection(new ArrayList<Platopedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Menu> attachedMenuCollection = new ArrayList<Menu>();
            for (Menu menuCollectionMenuToAttach : plato.getMenuCollection()) {
                menuCollectionMenuToAttach = em.getReference(menuCollectionMenuToAttach.getClass(), menuCollectionMenuToAttach.getIdMenu());
                attachedMenuCollection.add(menuCollectionMenuToAttach);
            }
            plato.setMenuCollection(attachedMenuCollection);
            Collection<Platopedido> attachedPlatopedidoCollection = new ArrayList<Platopedido>();
            for (Platopedido platopedidoCollectionPlatopedidoToAttach : plato.getPlatopedidoCollection()) {
                platopedidoCollectionPlatopedidoToAttach = em.getReference(platopedidoCollectionPlatopedidoToAttach.getClass(), platopedidoCollectionPlatopedidoToAttach.getIdPlatoPedido());
                attachedPlatopedidoCollection.add(platopedidoCollectionPlatopedidoToAttach);
            }
            plato.setPlatopedidoCollection(attachedPlatopedidoCollection);
            em.persist(plato);
            for (Menu menuCollectionMenu : plato.getMenuCollection()) {
                menuCollectionMenu.getPlatoCollection().add(plato);
                menuCollectionMenu = em.merge(menuCollectionMenu);
            }
            for (Platopedido platopedidoCollectionPlatopedido : plato.getPlatopedidoCollection()) {
                Plato oldIdPlatoOfPlatopedidoCollectionPlatopedido = platopedidoCollectionPlatopedido.getIdPlato();
                platopedidoCollectionPlatopedido.setIdPlato(plato);
                platopedidoCollectionPlatopedido = em.merge(platopedidoCollectionPlatopedido);
                if (oldIdPlatoOfPlatopedidoCollectionPlatopedido != null) {
                    oldIdPlatoOfPlatopedidoCollectionPlatopedido.getPlatopedidoCollection().remove(platopedidoCollectionPlatopedido);
                    oldIdPlatoOfPlatopedidoCollectionPlatopedido = em.merge(oldIdPlatoOfPlatopedidoCollectionPlatopedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Plato plato) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Plato persistentPlato = em.find(Plato.class, plato.getIdPlato());
            Collection<Menu> menuCollectionOld = persistentPlato.getMenuCollection();
            Collection<Menu> menuCollectionNew = plato.getMenuCollection();
            Collection<Platopedido> platopedidoCollectionOld = persistentPlato.getPlatopedidoCollection();
            Collection<Platopedido> platopedidoCollectionNew = plato.getPlatopedidoCollection();
            List<String> illegalOrphanMessages = null;
            for (Platopedido platopedidoCollectionOldPlatopedido : platopedidoCollectionOld) {
                if (!platopedidoCollectionNew.contains(platopedidoCollectionOldPlatopedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Platopedido " + platopedidoCollectionOldPlatopedido + " since its idPlato field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Menu> attachedMenuCollectionNew = new ArrayList<Menu>();
            for (Menu menuCollectionNewMenuToAttach : menuCollectionNew) {
                menuCollectionNewMenuToAttach = em.getReference(menuCollectionNewMenuToAttach.getClass(), menuCollectionNewMenuToAttach.getIdMenu());
                attachedMenuCollectionNew.add(menuCollectionNewMenuToAttach);
            }
            menuCollectionNew = attachedMenuCollectionNew;
            plato.setMenuCollection(menuCollectionNew);
            Collection<Platopedido> attachedPlatopedidoCollectionNew = new ArrayList<Platopedido>();
            for (Platopedido platopedidoCollectionNewPlatopedidoToAttach : platopedidoCollectionNew) {
                platopedidoCollectionNewPlatopedidoToAttach = em.getReference(platopedidoCollectionNewPlatopedidoToAttach.getClass(), platopedidoCollectionNewPlatopedidoToAttach.getIdPlatoPedido());
                attachedPlatopedidoCollectionNew.add(platopedidoCollectionNewPlatopedidoToAttach);
            }
            platopedidoCollectionNew = attachedPlatopedidoCollectionNew;
            plato.setPlatopedidoCollection(platopedidoCollectionNew);
            plato = em.merge(plato);
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
            for (Platopedido platopedidoCollectionNewPlatopedido : platopedidoCollectionNew) {
                if (!platopedidoCollectionOld.contains(platopedidoCollectionNewPlatopedido)) {
                    Plato oldIdPlatoOfPlatopedidoCollectionNewPlatopedido = platopedidoCollectionNewPlatopedido.getIdPlato();
                    platopedidoCollectionNewPlatopedido.setIdPlato(plato);
                    platopedidoCollectionNewPlatopedido = em.merge(platopedidoCollectionNewPlatopedido);
                    if (oldIdPlatoOfPlatopedidoCollectionNewPlatopedido != null && !oldIdPlatoOfPlatopedidoCollectionNewPlatopedido.equals(plato)) {
                        oldIdPlatoOfPlatopedidoCollectionNewPlatopedido.getPlatopedidoCollection().remove(platopedidoCollectionNewPlatopedido);
                        oldIdPlatoOfPlatopedidoCollectionNewPlatopedido = em.merge(oldIdPlatoOfPlatopedidoCollectionNewPlatopedido);
                    }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            Collection<Platopedido> platopedidoCollectionOrphanCheck = plato.getPlatopedidoCollection();
            for (Platopedido platopedidoCollectionOrphanCheckPlatopedido : platopedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Plato (" + plato + ") cannot be destroyed since the Platopedido " + platopedidoCollectionOrphanCheckPlatopedido + " in its platopedidoCollection field has a non-nullable idPlato field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
