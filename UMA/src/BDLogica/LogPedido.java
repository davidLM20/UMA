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
import Entidades.Factura;
import Entidades.Pedido;
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
public class LogPedido implements Serializable {

    public LogPedido() {
        this.emf = Persistence.createEntityManagerFactory("UMAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getFacturaCollection() == null) {
            pedido.setFacturaCollection(new ArrayList<Factura>());
        }
        if (pedido.getPlatopedidoCollection() == null) {
            pedido.setPlatopedidoCollection(new ArrayList<Platopedido>());
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
            Collection<Factura> attachedFacturaCollection = new ArrayList<Factura>();
            for (Factura facturaCollectionFacturaToAttach : pedido.getFacturaCollection()) {
                facturaCollectionFacturaToAttach = em.getReference(facturaCollectionFacturaToAttach.getClass(), facturaCollectionFacturaToAttach.getIdFactura());
                attachedFacturaCollection.add(facturaCollectionFacturaToAttach);
            }
            pedido.setFacturaCollection(attachedFacturaCollection);
            Collection<Platopedido> attachedPlatopedidoCollection = new ArrayList<Platopedido>();
            for (Platopedido platopedidoCollectionPlatopedidoToAttach : pedido.getPlatopedidoCollection()) {
                platopedidoCollectionPlatopedidoToAttach = em.getReference(platopedidoCollectionPlatopedidoToAttach.getClass(), platopedidoCollectionPlatopedidoToAttach.getIdPlatoPedido());
                attachedPlatopedidoCollection.add(platopedidoCollectionPlatopedidoToAttach);
            }
            pedido.setPlatopedidoCollection(attachedPlatopedidoCollection);
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
            for (Factura facturaCollectionFactura : pedido.getFacturaCollection()) {
                Pedido oldIdPedidoOfFacturaCollectionFactura = facturaCollectionFactura.getIdPedido();
                facturaCollectionFactura.setIdPedido(pedido);
                facturaCollectionFactura = em.merge(facturaCollectionFactura);
                if (oldIdPedidoOfFacturaCollectionFactura != null) {
                    oldIdPedidoOfFacturaCollectionFactura.getFacturaCollection().remove(facturaCollectionFactura);
                    oldIdPedidoOfFacturaCollectionFactura = em.merge(oldIdPedidoOfFacturaCollectionFactura);
                }
            }
            for (Platopedido platopedidoCollectionPlatopedido : pedido.getPlatopedidoCollection()) {
                Pedido oldIdPedidoOfPlatopedidoCollectionPlatopedido = platopedidoCollectionPlatopedido.getIdPedido();
                platopedidoCollectionPlatopedido.setIdPedido(pedido);
                platopedidoCollectionPlatopedido = em.merge(platopedidoCollectionPlatopedido);
                if (oldIdPedidoOfPlatopedidoCollectionPlatopedido != null) {
                    oldIdPedidoOfPlatopedidoCollectionPlatopedido.getPlatopedidoCollection().remove(platopedidoCollectionPlatopedido);
                    oldIdPedidoOfPlatopedidoCollectionPlatopedido = em.merge(oldIdPedidoOfPlatopedidoCollectionPlatopedido);
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
            Collection<Factura> facturaCollectionOld = persistentPedido.getFacturaCollection();
            Collection<Factura> facturaCollectionNew = pedido.getFacturaCollection();
            Collection<Platopedido> platopedidoCollectionOld = persistentPedido.getPlatopedidoCollection();
            Collection<Platopedido> platopedidoCollectionNew = pedido.getPlatopedidoCollection();
            List<String> illegalOrphanMessages = null;
            for (Factura facturaCollectionOldFactura : facturaCollectionOld) {
                if (!facturaCollectionNew.contains(facturaCollectionOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaCollectionOldFactura + " since its idPedido field is not nullable.");
                }
            }
            for (Platopedido platopedidoCollectionOldPlatopedido : platopedidoCollectionOld) {
                if (!platopedidoCollectionNew.contains(platopedidoCollectionOldPlatopedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Platopedido " + platopedidoCollectionOldPlatopedido + " since its idPedido field is not nullable.");
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
            Collection<Factura> attachedFacturaCollectionNew = new ArrayList<Factura>();
            for (Factura facturaCollectionNewFacturaToAttach : facturaCollectionNew) {
                facturaCollectionNewFacturaToAttach = em.getReference(facturaCollectionNewFacturaToAttach.getClass(), facturaCollectionNewFacturaToAttach.getIdFactura());
                attachedFacturaCollectionNew.add(facturaCollectionNewFacturaToAttach);
            }
            facturaCollectionNew = attachedFacturaCollectionNew;
            pedido.setFacturaCollection(facturaCollectionNew);
            Collection<Platopedido> attachedPlatopedidoCollectionNew = new ArrayList<Platopedido>();
            for (Platopedido platopedidoCollectionNewPlatopedidoToAttach : platopedidoCollectionNew) {
                platopedidoCollectionNewPlatopedidoToAttach = em.getReference(platopedidoCollectionNewPlatopedidoToAttach.getClass(), platopedidoCollectionNewPlatopedidoToAttach.getIdPlatoPedido());
                attachedPlatopedidoCollectionNew.add(platopedidoCollectionNewPlatopedidoToAttach);
            }
            platopedidoCollectionNew = attachedPlatopedidoCollectionNew;
            pedido.setPlatopedidoCollection(platopedidoCollectionNew);
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
            for (Platopedido platopedidoCollectionNewPlatopedido : platopedidoCollectionNew) {
                if (!platopedidoCollectionOld.contains(platopedidoCollectionNewPlatopedido)) {
                    Pedido oldIdPedidoOfPlatopedidoCollectionNewPlatopedido = platopedidoCollectionNewPlatopedido.getIdPedido();
                    platopedidoCollectionNewPlatopedido.setIdPedido(pedido);
                    platopedidoCollectionNewPlatopedido = em.merge(platopedidoCollectionNewPlatopedido);
                    if (oldIdPedidoOfPlatopedidoCollectionNewPlatopedido != null && !oldIdPedidoOfPlatopedidoCollectionNewPlatopedido.equals(pedido)) {
                        oldIdPedidoOfPlatopedidoCollectionNewPlatopedido.getPlatopedidoCollection().remove(platopedidoCollectionNewPlatopedido);
                        oldIdPedidoOfPlatopedidoCollectionNewPlatopedido = em.merge(oldIdPedidoOfPlatopedidoCollectionNewPlatopedido);
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
            Collection<Platopedido> platopedidoCollectionOrphanCheck = pedido.getPlatopedidoCollection();
            for (Platopedido platopedidoCollectionOrphanCheckPlatopedido : platopedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the Platopedido " + platopedidoCollectionOrphanCheckPlatopedido + " in its platopedidoCollection field has a non-nullable idPedido field.");
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
    
    public Pedido BuscarPedido(int numPedido) {
        List<Pedido> listaPedidos = findPedidoEntities();
        Pedido result = null;
        for(Pedido aux:listaPedidos){
            if(aux.getNumeroPedido()==numPedido){
                result = aux;
            }
        }
        return result;
    }
    
    public static void calcularTiempoAprox(Pedido pedido) {
        
        double tiempoTotal = calcularTiempoTotal(pedido);
        double sumatoria = 0.00;
        int n = 0;
        for (Platopedido objPlatoPedido : pedido.getPlatopedidoCollection()) {
            Plato plato = objPlatoPedido.getIdPlato();

            double peso = calcularPesoPlato(objPlatoPedido, tiempoTotal);
            sumatoria += ((plato.getTiempo() + ((2 * objPlatoPedido.getCantidad()) - 2)) * peso);
            n += 1;

        }
        pedido.setTiempoAproximado((sumatoria+tiempoTotal)/2);

    }

    public static double calcularTiempoTotal(Pedido pedido) {
        double tiempoTotal = 0.00;
        for (Platopedido platoPedido : pedido.getPlatopedidoCollection()) {
            tiempoTotal += platoPedido.getIdPlato().getTiempo()+ ((2 * platoPedido.getCantidad()) - 2);
        }
        return tiempoTotal;
    }

    public static double calcularPesoPlato(Platopedido platoPedido, double tiempoTotal) {
        double peso = (platoPedido.getIdPlato().getTiempo() + ((2 * platoPedido.getCantidad()) - 2)) / tiempoTotal;
        return peso;
    }
}
