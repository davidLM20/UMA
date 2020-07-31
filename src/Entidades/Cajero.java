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
@Table(name = "cajero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cajero.findAll", query = "SELECT c FROM Cajero c")
    , @NamedQuery(name = "Cajero.findByIdCajero", query = "SELECT c FROM Cajero c WHERE c.idCajero = :idCajero")
    , @NamedQuery(name = "Cajero.findByCedula", query = "SELECT c FROM Cajero c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Cajero.findByNombre", query = "SELECT c FROM Cajero c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cajero.findByApellido", query = "SELECT c FROM Cajero c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cajero.findByDireccion", query = "SELECT c FROM Cajero c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cajero.findByCelular", query = "SELECT c FROM Cajero c WHERE c.celular = :celular")
    , @NamedQuery(name = "Cajero.findByCodigo", query = "SELECT c FROM Cajero c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cajero.findByHorario", query = "SELECT c FROM Cajero c WHERE c.horario = :horario")
    , @NamedQuery(name = "Cajero.findBySueldo", query = "SELECT c FROM Cajero c WHERE c.sueldo = :sueldo")})
public class Cajero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCajero")
    private Integer idCajero;
    @Basic(optional = false)
    @Column(name = "cedula")
    private String cedula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @Column(name = "sueldo")
    private double sueldo;
    @OneToMany(mappedBy = "idCajero")
    private Collection<Pedido> pedidoCollection;

    public Cajero() {
    }

    public Cajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public Cajero(Integer idCajero, String cedula, String nombre, String apellido, String direccion, String celular, String codigo, String horario, double sueldo) {
        this.idCajero = idCajero;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
        this.codigo = codigo;
        this.horario = horario;
        this.sueldo = sueldo;
    }

    public Integer getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(Integer idCajero) {
        this.idCajero = idCajero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCajero != null ? idCajero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cajero)) {
            return false;
        }
        Cajero other = (Cajero) object;
        if ((this.idCajero == null && other.idCajero != null) || (this.idCajero != null && !this.idCajero.equals(other.idCajero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cajero[ idCajero=" + idCajero + " ]";
    }
    
}
