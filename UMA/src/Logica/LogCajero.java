/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Cajero;
import Data.DataCajero;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author accel
 */
public class LogCajero {

    static DataCajero objDataCajero = new DataCajero();
    
    static String fichero = "Archivos/Cajero.dat";

    public ArrayList<Cajero> importarCajero(ArrayList<Cajero> ArrayCajeros) {
        objDataCajero.ImportarCajero(ArrayCajeros);
        return ArrayCajeros;
    }

    public Cajero CrearCajero(int pedidosDespachados, String codigo, String horario, double sueldo, String cedula,
            String nombre, String apellido, String direccion, String celular) {
        Cajero objCajero = new Cajero(pedidosDespachados, codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        return objCajero;
    }

    public void EliminarCajero(ArrayList<Cajero> ArrayCajeros, Cajero cajero) throws IOException {
        ArrayCajeros.remove(cajero);
        objDataCajero.GuardarArchivoCajeros(ArrayCajeros);
    }

    public void GuardarCajero(Cajero objCajero) throws IOException {

        objDataCajero.GuardaArchivoCajero(objCajero);

    }

    
    //////// Metodos para archivos dat
    public static void EscribirCajero(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos,fichero );
    }

    public static void LeerCajero(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos,fichero);
    }
    public static void InsertarCajero(ArrayList ArrayObjetos) throws IOException {
        Archivo.anhadeFichero(ArrayObjetos,fichero);
    }
    
}
