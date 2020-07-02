/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedido.findByNumeroPedido", query = "SELECT p FROM Pedido p WHERE p.numeroPedido = :numeroPedido")
    , @NamedQuery(name = "Pedido.findByTiempoAproximado", query = "SELECT p FROM Pedido p WHERE p.tiempoAproximado = :tiempoAproximado")
    , @NamedQuery(name = "Pedido.findByEstado", query = "SELECT p FROM Pedido p WHERE p.estado = :estado")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPedido")
    private Integer idPedido;
    @Basic(optional = false)
    @Column(name = "numeroPedido")
    private int numeroPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tiempoAproximado")
    private Double tiempoAproximado;
    @Column(name = "estado")
    private Integer estado;
    @JoinTable(name = "pedido_has_plato", joinColumns = {
        @JoinColumn(name = "Pedido_idPedido", referencedColumnName = "idPedido")}, inverseJoinColumns = {
        @JoinColumn(name = "Plato_idPlato", referencedColumnName = "idPlato")})
    @ManyToMany
    private Collection<Plato> platoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPedido")
    private Collection<Factura> facturaCollection;
    @JoinColumn(name = "idCajero", referencedColumnName = "idCajero")
    @ManyToOne
    private Cajero idCajero;
    @JoinColumn(name = "idCocinero", referencedColumnName = "idCocinero")
    @ManyToOne
    private Cocinero idCocinero;
    @JoinColumn(name = "idMesero", referencedColumnName = "idMesero")
    @ManyToOne
    private Mesero idMesero;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Pedido(Integer idPedido, int numeroPedido) {
        this.idPedido = idPedido;
        this.numeroPedido = numeroPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Double getTiempoAproximado() {
        return tiempoAproximado;
    }

    public void setTiempoAproximado(Double tiempoAproximado) {
        this.tiempoAproximado = tiempoAproximado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Plato> getPlatoCollection() {
        return platoCollection;
    }

    public void setPlatoCollection(Collection<Plato> platoCollection) {
        this.platoCollection = platoCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    public Cajero getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Cajero idCajero) {
        this.idCajero = idCajero;
    }

    public Cocinero getIdCocinero() {
        return idCocinero;
    }

    public void setIdCocinero(Cocinero idCocinero) {
        this.idCocinero = idCocinero;
    }

    public Mesero getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Mesero idMesero) {
        this.idMesero = idMesero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ idPedido=" + idPedido + " ]";
    }
    
}
