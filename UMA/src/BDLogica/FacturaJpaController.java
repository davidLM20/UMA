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
import Entidades.Cliente;
import Entidades.Factura;
import Entidades.Feedback;
import Entidades.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author USUARIO
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = factura.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                factura.setIdCliente(idCliente);
            }
            Feedback idFeedBack = factura.getIdFeedBack();
            if (idFeedBack != null) {
                idFeedBack = em.getReference(idFeedBack.getClass(), idFeedBack.getIdFeedBack());
                factura.setIdFeedBack(idFeedBack);
            }
            Pedido idPedido = factura.getIdPedido();
            if (idPedido != null) {
                idPedido = em.getReference(idPedido.getClass(), idPedido.getIdPedido());
                factura.setIdPedido(idPedido);
            }
            em.persist(factura);
            if (idCliente != null) {
                idCliente.getFacturaCollection().add(factura);
                idCliente = em.merge(idCliente);
            }
            if (idFeedBack != null) {
                idFeedBack.getFacturaCollection().add(factura);
                idFeedBack = em.merge(idFeedBack);
            }
            if (idPedido != null) {
                idPedido.getFacturaCollection().add(factura);
                idPedido = em.merge(idPedido);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Factura factura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Factura persistentFactura = em.find(Factura.class, factura.getIdFactura());
            Cliente idClienteOld = persistentFactura.getIdCliente();
            Cliente idClienteNew = factura.getIdCliente();
            Feedback idFeedBackOld = persistentFactura.getIdFeedBack();
            Feedback idFeedBackNew = factura.getIdFeedBack();
            Pedido idPedidoOld = persistentFactura.getIdPedido();
            Pedido idPedidoNew = factura.getIdPedido();
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                factura.setIdCliente(idClienteNew);
            }
            if (idFeedBackNew != null) {
                idFeedBackNew = em.getReference(idFeedBackNew.getClass(), idFeedBackNew.getIdFeedBack());
                factura.setIdFeedBack(idFeedBackNew);
            }
            if (idPedidoNew != null) {
                idPedidoNew = em.getReference(idPedidoNew.getClass(), idPedidoNew.getIdPedido());
                factura.setIdPedido(idPedidoNew);
            }
            factura = em.merge(factura);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getFacturaCollection().remove(factura);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getFacturaCollection().add(factura);
                idClienteNew = em.merge(idClienteNew);
            }
            if (idFeedBackOld != null && !idFeedBackOld.equals(idFeedBackNew)) {
                idFeedBackOld.getFacturaCollection().remove(factura);
                idFeedBackOld = em.merge(idFeedBackOld);
            }
            if (idFeedBackNew != null && !idFeedBackNew.equals(idFeedBackOld)) {
                idFeedBackNew.getFacturaCollection().add(factura);
                idFeedBackNew = em.merge(idFeedBackNew);
            }
            if (idPedidoOld != null && !idPedidoOld.equals(idPedidoNew)) {
                idPedidoOld.getFacturaCollection().remove(factura);
                idPedidoOld = em.merge(idPedidoOld);
            }
            if (idPedidoNew != null && !idPedidoNew.equals(idPedidoOld)) {
                idPedidoNew.getFacturaCollection().add(factura);
                idPedidoNew = em.merge(idPedidoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = factura.getIdFactura();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            Cliente idCliente = factura.getIdCliente();
            if (idCliente != null) {
                idCliente.getFacturaCollection().remove(factura);
                idCliente = em.merge(idCliente);
            }
            Feedback idFeedBack = factura.getIdFeedBack();
            if (idFeedBack != null) {
                idFeedBack.getFacturaCollection().remove(factura);
                idFeedBack = em.merge(idFeedBack);
            }
            Pedido idPedido = factura.getIdPedido();
            if (idPedido != null) {
                idPedido.getFacturaCollection().remove(factura);
                idPedido = em.merge(idPedido);
            }
            em.remove(factura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
