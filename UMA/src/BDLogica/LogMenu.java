/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BDLogica;

import BDLogica.exceptions.NonexistentEntityException;
import Entidades.Menu;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entidades.Plato;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class LogMenu implements Serializable {

    public LogMenu() {
        this.emf = Persistence.createEntityManagerFactory("UMAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Menu menu) {
        if (menu.getPlatoCollection() == null) {
            menu.setPlatoCollection(new ArrayList<Plato>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Plato> attachedPlatoCollection = new ArrayList<Plato>();
            for (Plato platoCollectionPlatoToAttach : menu.getPlatoCollection()) {
                platoCollectionPlatoToAttach = em.getReference(platoCollectionPlatoToAttach.getClass(), platoCollectionPlatoToAttach.getIdPlato());
                attachedPlatoCollection.add(platoCollectionPlatoToAttach);
            }
            menu.setPlatoCollection(attachedPlatoCollection);
            em.persist(menu);
            for (Plato platoCollectionPlato : menu.getPlatoCollection()) {
                platoCollectionPlato.getMenuCollection().add(menu);
                platoCollectionPlato = em.merge(platoCollectionPlato);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menu menu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menu persistentMenu = em.find(Menu.class, menu.getIdMenu());
            Collection<Plato> platoCollectionOld = persistentMenu.getPlatoCollection();
            Collection<Plato> platoCollectionNew = menu.getPlatoCollection();
            Collection<Plato> attachedPlatoCollectionNew = new ArrayList<Plato>();
            for (Plato platoCollectionNewPlatoToAttach : platoCollectionNew) {
                platoCollectionNewPlatoToAttach = em.getReference(platoCollectionNewPlatoToAttach.getClass(), platoCollectionNewPlatoToAttach.getIdPlato());
                attachedPlatoCollectionNew.add(platoCollectionNewPlatoToAttach);
            }
            platoCollectionNew = attachedPlatoCollectionNew;
            menu.setPlatoCollection(platoCollectionNew);
            menu = em.merge(menu);
            for (Plato platoCollectionOldPlato : platoCollectionOld) {
                if (!platoCollectionNew.contains(platoCollectionOldPlato)) {
                    platoCollectionOldPlato.getMenuCollection().remove(menu);
                    platoCollectionOldPlato = em.merge(platoCollectionOldPlato);
                }
            }
            for (Plato platoCollectionNewPlato : platoCollectionNew) {
                if (!platoCollectionOld.contains(platoCollectionNewPlato)) {
                    platoCollectionNewPlato.getMenuCollection().add(menu);
                    platoCollectionNewPlato = em.merge(platoCollectionNewPlato);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = menu.getIdMenu();
                if (findMenu(id) == null) {
                    throw new NonexistentEntityException("The menu with id " + id + " no longer exists.");
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
            Menu menu;
            try {
                menu = em.getReference(Menu.class, id);
                menu.getIdMenu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menu with id " + id + " no longer exists.", enfe);
            }
            Collection<Plato> platoCollection = menu.getPlatoCollection();
            for (Plato platoCollectionPlato : platoCollection) {
                platoCollectionPlato.getMenuCollection().remove(menu);
                platoCollectionPlato = em.merge(platoCollectionPlato);
            }
            em.remove(menu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menu> findMenuEntities() {
        return findMenuEntities(true, -1, -1);
    }

    public List<Menu> findMenuEntities(int maxResults, int firstResult) {
        return findMenuEntities(false, maxResults, firstResult);
    }

    private List<Menu> findMenuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menu.class));
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

    public Menu findMenu(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menu.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menu> rt = cq.from(Menu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public Menu MenuActivo() throws IOException, FileNotFoundException, ClassNotFoundException {
        Date fecha = new Date();
        SimpleDateFormat format_dia = new SimpleDateFormat("E");
        SimpleDateFormat format_mes = new SimpleDateFormat("MMM");
        String dia = format_dia.format(fecha);
        String mes = format_mes.format(fecha);
        List<Menu> ArrayMenus = findMenuEntities();

        for (Menu objMenu : ArrayMenus) {
            String aux = objMenu.getDias().substring(0, objMenu.getDias().length() - 1);
            String[] dias = aux.split("\\|");
            String aux2 = objMenu.getMeses().substring(0, objMenu.getMeses().length() - 1);
            String[] meses = aux2.split("\\|");

            for (String auxMes : meses) {
                auxMes.toLowerCase();

                if (auxMes.toLowerCase().equals(mes)) {
                    for (String auxDia : dias) {
                        auxDia.toLowerCase();

                        if (auxDia.toLowerCase().equals(dia)) {

                            return objMenu;

                        }
                    }
                }
            }

        }
        return null;
    }
    
}
