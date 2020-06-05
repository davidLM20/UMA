/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Cocinero;
import Data.DataCocinero;
import static Logica.LogEmpleado.fichero;
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
    public static ArrayList CargarCocinero() throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList<Cocinero> listaCocineros = new ArrayList<Cocinero>();
        ArrayList<String> resultado = new ArrayList<String>();
        Archivo.leer(listaCocineros, fichero);
        String cadena = "";
        for(Cocinero aux: listaCocineros){
            cadena = aux.getNombre() + " " + aux.getApellido();
            resultado.add(cadena);
        }
        return resultado;
    } 
    public static boolean Existe(){
        return Archivo.ExisteFichero(fichero);
    }
    

    //************************
    
    public static void EscribirCocinero(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos,fichero );
    }

    public static void LeerCocinero(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos,fichero);
    }
//    public static void InsertarCajero(ArrayList ArrayObjetos) throws IOException {
//        Archivo.anhadeFichero(ArrayObjetos,fichero);
//    }
}
