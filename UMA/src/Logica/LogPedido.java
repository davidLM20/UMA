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
        System.out.println("skdfjlsdkj");
        double tiempoTotal = calcularTiempoTotal(pedido);
        double sumatoria = 0.00;
        int n = 0;
        for (PlatoPedido objPlatoPedido : pedido.listaPlatoPedido) {
            Plato plato = objPlatoPedido.getPlato();

            double peso = calcularPesoPlato(objPlatoPedido, tiempoTotal);


            System.out.println(peso);

            sumatoria += ((plato.getTiempo() + ((2 * objPlatoPedido.getCantidad()) - 2)) * peso);
            n += 1;

            System.out.println(sumatoria);

        }
        pedido.setTiempoAproximado((sumatoria+tiempoTotal)/2);

    }

    public static double calcularTiempoTotal(Pedido pedido) {
        double tiempoTotal = 0.00;
        for (PlatoPedido platoPedido : pedido.listaPlatoPedido) {
            tiempoTotal += platoPedido.getPlato().getTiempo()+ ((2 * platoPedido.getCantidad()) - 2);
        }
        return tiempoTotal;
    }

    public static double calcularPesoPlato(PlatoPedido platoPedido, double tiempoTotal) {
        double peso = (platoPedido.getPlato().getTiempo() + ((2 * platoPedido.getCantidad()) - 2)) / tiempoTotal;
        return peso;
    }

    public static boolean Existe() {

        return Archivo.ExisteFichero(fichero);
    }

    
    //**********************
    
    public Pedido BuscarPedido(ArrayList<Pedido> ArrayPedidos, Pedido objPedidoNumeroPedido) {
        Pedido objAux = new Pedido(); 
// 
        for (Pedido objPedidoNumPedido : ArrayPedidos) {
            int intNum = objPedidoNumPedido.getNumeroPedido();
            System.out.println(intNum);
            if (intNum == objPedidoNumeroPedido.getNumeroPedido()) {
                objAux = objPedidoNumPedido;
                System.out.println("////");
                System.out.println(objAux);
                break;
            }
        }

        return objAux;
    }
    
    public boolean CompararPedido(Pedido objPriemerPedido, Pedido objSegundoPedido) {
        if (objPriemerPedido.getNumeroPedido()== objSegundoPedido.getNumeroPedido()) {
            return true;
        }
        return false;
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
