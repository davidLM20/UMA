/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Cliente;
import CLases.Factura;
import CLases.Pedido;
import CLases.PlatoPedido;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David Lopez
 */
public class LogFactura {

    static String fichero = "Archivos/Factura.dat";
    //
    public static double calcularTotalpagar(Pedido pedido) {
        double totalPagar = 0.00;
        for (PlatoPedido platoPedido : pedido.listaPlatoPedido) {
            totalPagar += (platoPedido.getCantidad() * platoPedido.getPlato().getCosto());
            
        }
        
        return totalPagar;
    }
    
    
    public Factura CrearFactura( int numeroFactura,Date fechaFactura,double valor, Cliente cliente, Pedido pedido) {
        Factura objFactura = new Factura(numeroFactura, fechaFactura, valor, cliente, pedido);
        return objFactura;
    }
    
    
    //
    public static void EscribirFactura(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos, fichero);
    }

    public static void LeerFactura(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos, fichero);
    }

    public static void InsertarFactura(ArrayList ArrayObjetos) throws IOException {
        Archivo.anhadeFichero(ArrayObjetos, fichero);
    }

    public static boolean Existe() {
        return Archivo.ExisteFichero(fichero);
    }

}
