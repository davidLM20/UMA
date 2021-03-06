package CLases;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : Plato.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//




public class Plato {
	public String nombre;
	public double costo;
	public String descripcion;
	public double tiempo;

    public Plato() {
    }

    public Plato(String nombre, double costo, String descripcion, double tiempo) {
        this.nombre = nombre;
        this.costo = costo;
        this.descripcion = descripcion;
        this.tiempo = tiempo;
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

    @Override
    public String toString() {
        return "Plato{" + "nombre=" + nombre + ", costo=" + costo + ", descripcion=" + descripcion + ", tiempo=" + tiempo + '}';
    }
        
}
