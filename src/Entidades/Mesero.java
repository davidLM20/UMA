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
@Table(name = "mesero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesero.findAll", query = "SELECT m FROM Mesero m")
    , @NamedQuery(name = "Mesero.findByIdMesero", query = "SELECT m FROM Mesero m WHERE m.idMesero = :idMesero")
    , @NamedQuery(name = "Mesero.findByCedula", query = "SELECT m FROM Mesero m WHERE m.cedula = :cedula")
    , @NamedQuery(name = "Mesero.findByNombre", query = "SELECT m FROM Mesero m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Mesero.findByApellido", query = "SELECT m FROM Mesero m WHERE m.apellido = :apellido")
    , @NamedQuery(name = "Mesero.findByDireccion", query = "SELECT m FROM Mesero m WHERE m.direccion = :direccion")
    , @NamedQuery(name = "Mesero.findByCelular", query = "SELECT m FROM Mesero m WHERE m.celular = :celular")
    , @NamedQuery(name = "Mesero.findByCodigo", query = "SELECT m FROM Mesero m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Mesero.findByHorario", query = "SELECT m FROM Mesero m WHERE m.horario = :horario")
    , @NamedQuery(name = "Mesero.findBySueldo", query = "SELECT m FROM Mesero m WHERE m.sueldo = :sueldo")})
public class Mesero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMesero")
    private Integer idMesero;
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
    @OneToMany(mappedBy = "idMesero")
    private Collection<Pedido> pedidoCollection;

    public Mesero() {
    }

    public Mesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public Mesero(Integer idMesero, String cedula, String nombre, String apellido, String direccion, String celular, String codigo, String horario, double sueldo) {
        this.idMesero = idMesero;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
        this.codigo = codigo;
        this.horario = horario;
        this.sueldo = sueldo;
    }

    public Integer getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Integer idMesero) {
        this.idMesero = idMesero;
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
        hash += (idMesero != null ? idMesero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesero)) {
            return false;
        }
        Mesero other = (Mesero) object;
        if ((this.idMesero == null && other.idMesero != null) || (this.idMesero != null && !this.idMesero.equals(other.idMesero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Mesero[ idMesero=" + idMesero + " ]";
    }
    
}
