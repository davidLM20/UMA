package CLases;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : Persona.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//




public class Persona {
	public String cedula;
	public String nombre;
	public String apellido;
	public String direccion;
	public String celular;

    public Persona() {
    }

    public Persona(String cedula, String nombre, String apellido, String direccion, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.celular = celular;
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
        return "Persona{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", celular=" + celular + '}';
    }
        
}
