/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import CLases.Cajero;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author accel
 */
public class DataCajero {
    public void GuardaArchivoCajero(Cajero objCajero) throws FileNotFoundException, IOException{
        
        // SE DEBE MANTENER LA MISMA ESTRUCTURA DEL ARCHIVO DE ENTRADA PARA QUE FUNCIONE
        // LO DEBEN COMPLETAR UDS.
        
        File f = new File("Archivos/CajerosGuardados.txt");
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
         //int pedidosDespachados, String codigo, String horario, double sueldo, String cedula, String nombre, String apellido, String direccion, String celular
        //RECORRER EL ARRAY LIST Y GRABAR POR CADA OBJETO
            bw.write(objCajero.getPedidosDespachados()+",");
            bw.write(objCajero.getCodigo()+",");
            bw.write(objCajero.getHorario()+",");
            bw.write(objCajero.getSueldo()+",");
            bw.write(objCajero.getCedula()+",");
            bw.write(objCajero.getNombre()+",");
            bw.write(objCajero.getApellido()+",");
            bw.write(objCajero.getDireccion()+",");
            bw.write(objCajero.getCelular()+",");
            
        
        bw.close();
        fw.close();
        
    }
}
