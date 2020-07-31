package CLases;

//

import java.io.Serializable;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : Cajero.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//
public class Cajero extends Empleado implements Serializable{

    public int pedidosDespachados;

    public Cajero() {
    }

    public Cajero(int pedidosDespachados, String codigo, String horario, double sueldo, String cedula, String nombre, String apellido, String direccion, String celular) {
        super(codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        this.pedidosDespachados = pedidosDespachados;
    }

    public int getPedidosDespachados() {
        return pedidosDespachados;
    }

    public void setPedidosDespachados(int pedidosDespachados) {
        this.pedidosDespachados = pedidosDespachados;
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

    @Override
    public String toString() {
        return "Cajero{" + "pedidosDespachados=" + pedidosDespachados + '}';
    }

}
