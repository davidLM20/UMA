/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Cajero;
import CLases.Cliente;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class LogCliente {
    
    static String fichero = "Archivos/Cliente.dat";
    
    public Cliente CrearCliente( String cedula, String nombre, String apellido, String direccion, String celular) {
        Cliente objCliente = new Cliente(cedula, nombre, apellido, direccion, celular);
        return objCliente;
    }
    
    public static void EscribirCliente(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos, fichero);
    }

    public static void LeerCliente(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos, fichero);
    }

    public static void InsertarCliente(ArrayList ArrayObjetos) throws IOException {
        Archivo.anhadeFichero(ArrayObjetos, fichero);
    }
    
    public static boolean Existe(){
        return Archivo.ExisteFichero(fichero);
    }
}
