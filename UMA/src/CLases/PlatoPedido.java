package CLases;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : PlatoPedido.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//
public class PlatoPedido {

    public int cantidad;
    public int estado;
    public Plato plato;
    public String observacion;
    
    public PlatoPedido() {
    }

    public PlatoPedido(int cantidad, int estado, Plato plato, String observacion) {
        this.cantidad = cantidad;
        this.estado = estado;
        this.plato = plato;        
        this.observacion = observacion;
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

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "PlatoPedido{" + "cantidad=" + cantidad + ", estado=" + estado + ", plato=" + plato +  ", observacion=" + observacion + '}';
    }

    

}
