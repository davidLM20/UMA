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
import Entidades.Cajero;
import Entidades.Cocinero;
import Entidades.Mesero;
import Entidades.Plato;
import java.util.ArrayList;
import java.util.Collection;
import Entidades.Factura;
import Entidades.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class LogPedido implements Serializable {

    public LogPedido() {
        this.emf = Persistence.createEntityManagerFactory("UMAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getPlatoCollection() == null) {
            pedido.setPlatoCollection(new ArrayList<Plato>());
        }
        if (pedido.getFacturaCollection() == null) {
            pedido.setFacturaCollection(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cajero idCajero = pedido.getIdCajero();
            if (idCajero != null) {
                idCajero = em.getReference(idCajero.getClass(), idCajero.getIdCajero());
                pedido.setIdCajero(idCajero);
            }
            Cocinero idCocinero = pedido.getIdCocinero();
            if (idCocinero != null) {
                idCocinero = em.getReference(idCocinero.getClass(), idCocinero.getIdCocinero());
                pedido.setIdCocinero(idCocinero);
            }
            Mesero idMesero = pedido.getIdMesero();
            if (idMesero != null) {
                idMesero = em.getReference(idMesero.getClass(), idMesero.getIdMesero());
                pedido.setIdMesero(idMesero);
            }
            Collection<Plato> attachedPlatoCollection = new ArrayList<Plato>();
            for (Plato platoCollectionPlatoToAttach : pedido.getPlatoCollection()) {
                platoCollectionPlatoToAttach = em.getReference(platoCollectionPlatoToAttach.getClass(), platoCollectionPlatoToAttach.getIdPlato());
                attachedPlatoCollection.add(platoCollectionPlatoToAttach);
            }
            pedido.setPlatoCollection(attachedPlatoCollection);
            Collection<Factura> attachedFacturaCollection = new ArrayList<Factura>();
            for (Factura facturaCollectionFacturaToAttach : pedido.getFacturaCollection()) {
                facturaCollectionFacturaToAttach = em.getReference(facturaCollectionFacturaToAttach.getClass(), facturaCollectionFacturaToAttach.getIdFactura());
                attachedFacturaCollection.add(facturaCollectionFacturaToAttach);
            }
            pedido.setFacturaCollection(attachedFacturaCollection);
            em.persist(pedido);
            if (idCajero != null) {
                idCajero.getPedidoCollection().add(pedido);
                idCajero = em.merge(idCajero);
            }
            if (idCocinero != null) {
                idCocinero.getPedidoCollection().add(pedido);
                idCocinero = em.merge(idCocinero);
            }
            if (idMesero != null) {
                idMesero.getPedidoCollection().add(pedido);
                idMesero = em.merge(idMesero);
            }
            for (Plato platoCollectionPlato : pedido.getPlatoCollection()) {
                platoCollectionPlato.getPedidoCollection().add(pedido);
                platoCollectionPlato = em.merge(platoCollectionPlato);
            }
            for (Factura facturaCollectionFactura : pedido.getFacturaCollection()) {
                Pedido oldIdPedidoOfFacturaCollectionFactura = facturaCollectionFactura.getIdPedido();
                facturaCollectionFactura.setIdPedido(pedido);
                facturaCollectionFactura = em.merge(facturaCollectionFactura);
                if (oldIdPedidoOfFacturaCollectionFactura != null) {
                    oldIdPedidoOfFacturaCollectionFactura.getFacturaCollection().remove(facturaCollectionFactura);
                    oldIdPedidoOfFacturaCollectionFactura = em.merge(oldIdPedidoOfFacturaCollectionFactura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Cajero idCajeroOld = persistentPedido.getIdCajero();
            Cajero idCajeroNew = pedido.getIdCajero();
            Cocinero idCocineroOld = persistentPedido.getIdCocinero();
            Cocinero idCocineroNew = pedido.getIdCocinero();
            Mesero idMeseroOld = persistentPedido.getIdMesero();
            Mesero idMeseroNew = pedido.getIdMesero();
            Collection<Plato> platoCollectionOld = persistentPedido.getPlatoCollection();
            Collection<Plato> platoCollectionNew = pedido.getPlatoCollection();
            Collection<Factura> facturaCollectionOld = persistentPedido.getFacturaCollection();
            Collection<Factura> facturaCollectionNew = pedido.getFacturaCollection();
            List<String> illegalOrphanMessages = null;
            for (Factura facturaCollectionOldFactura : facturaCollectionOld) {
                if (!facturaCollectionNew.contains(facturaCollectionOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaCollectionOldFactura + " since its idPedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idCajeroNew != null) {
                idCajeroNew = em.getReference(idCajeroNew.getClass(), idCajeroNew.getIdCajero());
                pedido.setIdCajero(idCajeroNew);
            }
            if (idCocineroNew != null) {
                idCocineroNew = em.getReference(idCocineroNew.getClass(), idCocineroNew.getIdCocinero());
                pedido.setIdCocinero(idCocineroNew);
            }
            if (idMeseroNew != null) {
                idMeseroNew = em.getReference(idMeseroNew.getClass(), idMeseroNew.getIdMesero());
                pedido.setIdMesero(idMeseroNew);
            }
            Collection<Plato> attachedPlatoCollectionNew = new ArrayList<Plato>();
            for (Plato platoCollectionNewPlatoToAttach : platoCollectionNew) {
                platoCollectionNewPlatoToAttach = em.getReference(platoCollectionNewPlatoToAttach.getClass(), platoCollectionNewPlatoToAttach.getIdPlato());
                attachedPlatoCollectionNew.add(platoCollectionNewPlatoToAttach);
            }
            platoCollectionNew = attachedPlatoCollectionNew;
            pedido.setPlatoCollection(platoCollectionNew);
            Collection<Factura> attachedFacturaCollectionNew = new ArrayList<Factura>();
            for (Factura facturaCollectionNewFacturaToAttach : facturaCollectionNew) {
                facturaCollectionNewFacturaToAttach = em.getReference(facturaCollectionNewFacturaToAttach.getClass(), facturaCollectionNewFacturaToAttach.getIdFactura());
                attachedFacturaCollectionNew.add(facturaCollectionNewFacturaToAttach);
            }
            facturaCollectionNew = attachedFacturaCollectionNew;
            pedido.setFacturaCollection(facturaCollectionNew);
            pedido = em.merge(pedido);
            if (idCajeroOld != null && !idCajeroOld.equals(idCajeroNew)) {
                idCajeroOld.getPedidoCollection().remove(pedido);
                idCajeroOld = em.merge(idCajeroOld);
            }
            if (idCajeroNew != null && !idCajeroNew.equals(idCajeroOld)) {
                idCajeroNew.getPedidoCollection().add(pedido);
                idCajeroNew = em.merge(idCajeroNew);
            }
            if (idCocineroOld != null && !idCocineroOld.equals(idCocineroNew)) {
                idCocineroOld.getPedidoCollection().remove(pedido);
                idCocineroOld = em.merge(idCocineroOld);
            }
            if (idCocineroNew != null && !idCocineroNew.equals(idCocineroOld)) {
                idCocineroNew.getPedidoCollection().add(pedido);
                idCocineroNew = em.merge(idCocineroNew);
            }
            if (idMeseroOld != null && !idMeseroOld.equals(idMeseroNew)) {
                idMeseroOld.getPedidoCollection().remove(pedido);
                idMeseroOld = em.merge(idMeseroOld);
            }
            if (idMeseroNew != null && !idMeseroNew.equals(idMeseroOld)) {
                idMeseroNew.getPedidoCollection().add(pedido);
                idMeseroNew = em.merge(idMeseroNew);
            }
            for (Plato platoCollectionOldPlato : platoCollectionOld) {
                if (!platoCollectionNew.contains(platoCollectionOldPlato)) {
                    platoCollectionOldPlato.getPedidoCollection().remove(pedido);
                    platoCollectionOldPlato = em.merge(platoCollectionOldPlato);
                }
            }
            for (Plato platoCollectionNewPlato : platoCollectionNew) {
                if (!platoCollectionOld.contains(platoCollectionNewPlato)) {
                    platoCollectionNewPlato.getPedidoCollection().add(pedido);
                    platoCollectionNewPlato = em.merge(platoCollectionNewPlato);
                }
            }
            for (Factura facturaCollectionNewFactura : facturaCollectionNew) {
                if (!facturaCollectionOld.contains(facturaCollectionNewFactura)) {
                    Pedido oldIdPedidoOfFacturaCollectionNewFactura = facturaCollectionNewFactura.getIdPedido();
                    facturaCollectionNewFactura.setIdPedido(pedido);
                    facturaCollectionNewFactura = em.merge(facturaCollectionNewFactura);
                    if (oldIdPedidoOfFacturaCollectionNewFactura != null && !oldIdPedidoOfFacturaCollectionNewFactura.equals(pedido)) {
                        oldIdPedidoOfFacturaCollectionNewFactura.getFacturaCollection().remove(facturaCollectionNewFactura);
                        oldIdPedidoOfFacturaCollectionNewFactura = em.merge(oldIdPedidoOfFacturaCollectionNewFactura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Factura> facturaCollectionOrphanCheck = pedido.getFacturaCollection();
            for (Factura facturaCollectionOrphanCheckFactura : facturaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the Factura " + facturaCollectionOrphanCheckFactura + " in its facturaCollection field has a non-nullable idPedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cajero idCajero = pedido.getIdCajero();
            if (idCajero != null) {
                idCajero.getPedidoCollection().remove(pedido);
                idCajero = em.merge(idCajero);
            }
            Cocinero idCocinero = pedido.getIdCocinero();
            if (idCocinero != null) {
                idCocinero.getPedidoCollection().remove(pedido);
                idCocinero = em.merge(idCocinero);
            }
            Mesero idMesero = pedido.getIdMesero();
            if (idMesero != null) {
                idMesero.getPedidoCollection().remove(pedido);
                idMesero = em.merge(idMesero);
            }
            Collection<Plato> platoCollection = pedido.getPlatoCollection();
            for (Plato platoCollectionPlato : platoCollection) {
                platoCollectionPlato.getPedidoCollection().remove(pedido);
                platoCollectionPlato = em.merge(platoCollectionPlato);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
