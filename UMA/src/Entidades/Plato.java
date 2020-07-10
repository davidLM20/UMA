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
import javax.persistence.ManyToMany;
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
@Table(name = "plato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plato.findAll", query = "SELECT p FROM Plato p")
    , @NamedQuery(name = "Plato.findByIdPlato", query = "SELECT p FROM Plato p WHERE p.idPlato = :idPlato")
    , @NamedQuery(name = "Plato.findByNombre", query = "SELECT p FROM Plato p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Plato.findByCosto", query = "SELECT p FROM Plato p WHERE p.costo = :costo")
    , @NamedQuery(name = "Plato.findByDescripcion", query = "SELECT p FROM Plato p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Plato.findByTiempo", query = "SELECT p FROM Plato p WHERE p.tiempo = :tiempo")})
public class Plato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlato")
    private Integer idPlato;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tiempo")
    private double tiempo;
    @ManyToMany(mappedBy = "platoCollection")
    private Collection<Menu> menuCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPlato")
    private Collection<PlatoPedido> platopedidoCollection;

    public Plato() {
    }

    public Plato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Plato(Integer idPlato, String nombre, double costo, String descripcion, double tiempo) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    @XmlTransient
    public Collection<Menu> getMenuCollection() {
        return menuCollection;
    }

    public void setMenuCollection(Collection<Menu> menuCollection) {
        this.menuCollection = menuCollection;
    }

    @XmlTransient
    public Collection<PlatoPedido> getPlatopedidoCollection() {
        return platopedidoCollection;
    }

    public void setPlatopedidoCollection(Collection<PlatoPedido> platopedidoCollection) {
        this.platopedidoCollection = platopedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlato != null ? idPlato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plato)) {
            return false;
        }
        Plato other = (Plato) object;
        if ((this.idPlato == null && other.idPlato != null) || (this.idPlato != null && !this.idPlato.equals(other.idPlato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Plato[ idPlato=" + idPlato + " ]";
    }
    
}
