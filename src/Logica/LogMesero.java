/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Mesero;

import Data.DataMeseros;
import static Logica.LogEmpleado.fichero;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class LogMesero {

    static DataMeseros objDataMesero = new DataMeseros();

    static String fichero = "Archivos/Mesero.dat";

    public ArrayList<Mesero> importarMeseros(ArrayList<Mesero> ArrayMeseros) {
        objDataMesero.ImportarMeseros(ArrayMeseros);
        return ArrayMeseros;
    }

    public Mesero CrearMesero(int mesasAtendidas, String codigo, String horario,
            double sueldo, String cedula, String nombre, String apellido, String direccion, String celular) {

        Mesero objJug = new Mesero(codigo, nombre, apellido, direccion, cedula, celular, horario, mesasAtendidas, sueldo);
        return objJug;
    }

    public void EliminarMesero(ArrayList<Mesero> ArrayMesero, Mesero objMesero) throws IOException {
        ArrayMesero.remove(objMesero);
        objDataMesero.GuardarMesero(objMesero);
    }

    public void GuardarMesero(Mesero objMesero) throws IOException {
        DataMeseros objDataMeseros = new DataMeseros();
        objDataMeseros.GuardarMesero(objMesero);
    }
    public static boolean Existe(){
        return Archivo.ExisteFichero(fichero);
    }

    //************************
    
    public static void EscribirMesero(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos,fichero );
    }

    public static void LeerMesero(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos,fichero);
    }
    public static void InsertarMesero(ArrayList ArrayObjetos) throws IOException {
        Archivo.anhadeFichero(ArrayObjetos,fichero);
    }
    
}
