package CLases;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : Mesero.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//




public class Mesero extends Empleado {
	public int mesasAtendidas;

    public Mesero() {
    }

    public Mesero(int mesasAtendidas, String codigo, String horario, double sueldo, String cedula, String nombre, String apellido, String direccion, String celular) {
        super(codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        this.mesasAtendidas = mesasAtendidas;
    }

    public int getMesasAtendidas() {
        return mesasAtendidas;
    }

    public void setMesasAtendidas(int mesasAtendidas) {
        this.mesasAtendidas = mesasAtendidas;
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
        return "Mesero{" + super.toString() + "mesasAtendidas=" + mesasAtendidas + '}';
    }
        
}
