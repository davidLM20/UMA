/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "platopedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platopedido.findAll", query = "SELECT p FROM Platopedido p")
    , @NamedQuery(name = "Platopedido.findByIdPlatoPedido", query = "SELECT p FROM Platopedido p WHERE p.idPlatoPedido = :idPlatoPedido")
    , @NamedQuery(name = "Platopedido.findByCantidad", query = "SELECT p FROM Platopedido p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Platopedido.findByEstado", query = "SELECT p FROM Platopedido p WHERE p.estado = :estado")
    , @NamedQuery(name = "Platopedido.findByObservacion", query = "SELECT p FROM Platopedido p WHERE p.observacion = :observacion")})
public class PlatoPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlatoPedido")
    private Integer idPlatoPedido;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "idPedido", referencedColumnName = "idPedido")
    @ManyToOne(optional = false)
    private Pedido idPedido;
    @JoinColumn(name = "idPlato", referencedColumnName = "idPlato")
    @ManyToOne(optional = false)
    private Plato idPlato;

    public PlatoPedido() {
    }

    public PlatoPedido(Integer idPlatoPedido) {
        this.idPlatoPedido = idPlatoPedido;
    }

    public PlatoPedido(Integer idPlatoPedido, int cantidad, int estado, String observacion) {
        this.idPlatoPedido = idPlatoPedido;
        this.cantidad = cantidad;
        this.estado = estado;
        this.observacion = observacion;
    }

    public Integer getIdPlatoPedido() {
        return idPlatoPedido;
    }

    public void setIdPlatoPedido(Integer idPlatoPedido) {
        this.idPlatoPedido = idPlatoPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Plato getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Plato idPlato) {
        this.idPlato = idPlato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlatoPedido != null ? idPlatoPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlatoPedido)) {
            return false;
        }
        PlatoPedido other = (PlatoPedido) object;
        if ((this.idPlatoPedido == null && other.idPlatoPedido != null) || (this.idPlatoPedido != null && !this.idPlatoPedido.equals(other.idPlatoPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Platopedido[ idPlatoPedido=" + idPlatoPedido + " ]";
    }
    
}
