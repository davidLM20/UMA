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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USUARIO
 */
@Entity
@Table(name = "colapedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colapedido.findAll", query = "SELECT c FROM Colapedido c")
    , @NamedQuery(name = "Colapedido.findByIdcolaPedido", query = "SELECT c FROM Colapedido c WHERE c.idcolaPedido = :idcolaPedido")})
public class Colapedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idcolaPedido")
    private Integer idcolaPedido;

    public Colapedido() {
    }

    public Colapedido(Integer idcolaPedido) {
        this.idcolaPedido = idcolaPedido;
    }

    public Integer getIdcolaPedido() {
        return idcolaPedido;
    }

    public void setIdcolaPedido(Integer idcolaPedido) {
        this.idcolaPedido = idcolaPedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcolaPedido != null ? idcolaPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colapedido)) {
            return false;
        }
        Colapedido other = (Colapedido) object;
        if ((this.idcolaPedido == null && other.idcolaPedido != null) || (this.idcolaPedido != null && !this.idcolaPedido.equals(other.idcolaPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Colapedido[ idcolaPedido=" + idcolaPedido + " ]";
    }
    
}
