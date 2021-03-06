package CLases;

//
import java.util.ArrayList;

//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : UMA
//  @ File Name : Pedido.java
//  @ Date : 14/5/2020
//  @ Author : UMA_TEAM
//
//
public class Pedido {

    public int numeroPedido;
    public double tiempoAproximado;
    public int estado;
    public Mesero mesero;
    public Cajero cajero;
    public Cocinero cocinero;
    public ArrayList<PlatoPedido> listaPlatoPedido = new ArrayList<PlatoPedido>();

    public Pedido() {
    }

    public Pedido(int numeroPedido, double tiempoAproximado, int estado, Mesero mesero, Cajero cajero, Cocinero cocinero, Plato plato) {
        this.numeroPedido = numeroPedido;
        this.tiempoAproximado = tiempoAproximado;
        this.estado = estado;
        this.mesero = mesero;
        this.cajero = cajero;
        this.cocinero = cocinero;
        this.listaPlatoPedido.add(new PlatoPedido(1, plato));
    }

    public Pedido(int numeroPedido, double tiempoAproximado, int estado, Mesero mesero, Cajero cajero, Cocinero cocinero) {
        this.numeroPedido = numeroPedido;
        this.tiempoAproximado = tiempoAproximado;
        this.estado = estado;
        this.mesero = mesero;
        this.cajero = cajero;
        this.cocinero = cocinero;
    }

    public void agregarAdicional(Plato plato) {
        this.listaPlatoPedido.add(new PlatoPedido(1, plato));
    }

    public void despacharPedido() {
        for (PlatoPedido plato: this.listaPlatoPedido){
            plato.setEstado(3);
        }
        this.estado=3;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public double getTiempoAproximado() {
        return tiempoAproximado;
    }

    public void setTiempoAproximado(double tiempoAproximado) {
        this.tiempoAproximado = tiempoAproximado;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Cocinero getCocinero() {
        return cocinero;
    }

    public void setCocinero(Cocinero cocinero) {
        this.cocinero = cocinero;
    }

    public ArrayList<PlatoPedido> getListaPlatoPedido() {
        return listaPlatoPedido;
    }

    public void setListaPlatoPedido(ArrayList<PlatoPedido> listaPlatoPedido) {
        this.listaPlatoPedido = listaPlatoPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numeroPedido=" + numeroPedido + ", tiempoAproximado=" + tiempoAproximado + ", estado=" + estado + ", mesero=" + mesero + ", cajero=" + cajero + ", cocinero=" + cocinero + ", listaPlatoPedido=" + listaPlatoPedido + '}';
    }

}
