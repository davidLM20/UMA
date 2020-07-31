/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author accel
 */
public class LogEmpleado {
    
    static String fichero = "Archivos/Empleados.dat";
    
    public static void LeerEmpleados(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos, fichero);
    }
    public static boolean Existe(){
        return Archivo.ExisteFichero(fichero);
    }
    
}
