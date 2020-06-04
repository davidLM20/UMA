/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Cocinero;
import Data.DataCocinero;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class LogCocinero {
    
    static DataCocinero objDataCocinero = new DataCocinero();
    
    static String fichero = "Archivos/Cocinero.dat";
    
    public ArrayList<Cocinero> importarCocinero(ArrayList<Cocinero>ArrayCocineros){
        objDataCocinero.ImportarCocineros(ArrayCocineros);
        return ArrayCocineros;
    }
  
    public Cocinero CrearCocinero(int platosRealizados, String codigo, String horario, double sueldo, String cedula, String nombre, String apellido, String direccion, String celular) {
        Cocinero objCocinero = new Cocinero(platosRealizados, codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        return objCocinero;
    }

    public void EliminarCocinero(ArrayList<Cocinero> ArrayCocinero, Cocinero cocinero) throws IOException {
        ArrayCocinero.remove(cocinero);
        objDataCocinero.GuardarArchivoCocinero(ArrayCocinero);
    }

    public void GuardarCocinero(Cocinero objCocinero) throws IOException {

        objDataCocinero.GuardarArchivosCocinero(objCocinero);

    }

    //************************
    
//    public static void EscribirCajero(ArrayList ArrayObjetos) throws IOException {
//        Archivo.escribir(ArrayObjetos,fichero );
//    }
//
//    public static void LeerCajero(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
//        Archivo.leer(ArrayObjetos,fichero);
//    }
//    public static void InsertarCajero(ArrayList ArrayObjetos) throws IOException {
//        Archivo.anhadeFichero(ArrayObjetos,fichero);
//    }
}
