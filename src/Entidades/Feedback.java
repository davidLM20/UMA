/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
    , @NamedQuery(name = "Feedback.findByIdFeedBack", query = "SELECT f FROM Feedback f WHERE f.idFeedBack = :idFeedBack")
    , @NamedQuery(name = "Feedback.findByCalificacion", query = "SELECT f FROM Feedback f WHERE f.calificacion = :calificacion")
    , @NamedQuery(name = "Feedback.findByObservacion", query = "SELECT f FROM Feedback f WHERE f.observacion = :observacion")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFeedBack")
    private Integer idFeedBack;
    @Basic(optional = false)
    @Column(name = "calificacion")
    private String calificacion;
    @Basic(optional = false)
    @Column(name = "observacion")
    private String observacion;
    @OneToMany(mappedBy = "idFeedBack")
    private Collection<Factura> facturaCollection;

    public Feedback() {
    }

    public Feedback(Integer idFeedBack) {
        this.idFeedBack = idFeedBack;
    }

    public Feedback(Integer idFeedBack, String calificacion, String observacion) {
        this.idFeedBack = idFeedBack;
        this.calificacion = calificacion;
        this.observacion = observacion;
    }

    public Integer getIdFeedBack() {
        return idFeedBack;
    }

    public void setIdFeedBack(Integer idFeedBack) {
        this.idFeedBack = idFeedBack;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFeedBack != null ? idFeedBack.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.idFeedBack == null && other.idFeedBack != null) || (this.idFeedBack != null && !this.idFeedBack.equals(other.idFeedBack))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Feedback[ idFeedBack=" + idFeedBack + " ]";
    }
    
}
