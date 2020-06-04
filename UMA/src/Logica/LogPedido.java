/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;

import CLases.Mesero;
import CLases.Pedido;
import CLases.Plato;
import CLases.PlatoPedido;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class LogPedido {

    static String fichero = "Archivos/Pedido.dat";
    static Pedido objPedido;

    public static Pedido CrearPedido(Mesero mesero) {
        objPedido = new Pedido();
        objPedido.setMesero(mesero);
        return objPedido;
    }

    public static void agregarPlatoPedido(Pedido pedido, Plato plato, int cantidad, int estado, String observacion) {
        pedido.agregarAdicional(cantidad, estado, plato, observacion);
    }

    public static void calcularTiempoAprox(Pedido pedido) {
        double tiempoTotal = calcularTiempoTotal(pedido);
        double sumatoria = 0.00;
        int n = 0;
        for (PlatoPedido objPlatoPedido : pedido.listaPlatoPedido) {
            Plato plato = objPlatoPedido.getPlato();
            double peso = calcularPesoPlato(plato, tiempoTotal);
            
            System.out.println(peso);
            
           sumatoria += ((plato.getTiempo() + ((2 * objPlatoPedido.getCantidad())-2)) * peso);
            n += 1;
            
            System.out.println(sumatoria);

        }
        pedido.setTiempoAproximado((sumatoria + calcularTiempoTotal(pedido)) / n);

    }

    public static double calcularTiempoTotal(Pedido pedido) {
        double tiempoTotal = 0.00;
        for (PlatoPedido platoPedido : pedido.listaPlatoPedido) {
            tiempoTotal += platoPedido.getPlato().getTiempo();
        }
        return tiempoTotal;
    }

    public static double calcularPesoPlato(Plato plato, double tiempoTotal) {
        double peso = plato.tiempo / tiempoTotal;
        return peso;
    }

    public static boolean Existe() {

        return Archivo.ExisteFichero(fichero);
    }

    //************************
    public static void EscribirPedido(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos, fichero);
    }

    public static void LeerPedido(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos, fichero);
    }

    public static void InsertarPedido(ArrayList ArrayObjetos) throws IOException {
        Archivo.anhadeFichero(ArrayObjetos, fichero);
    }
}
