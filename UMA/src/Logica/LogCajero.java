/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CLases.Cajero;
import Data.DataCajero;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author accel
 */
public class LogCajero {
    static DataCajero objDataCajero = new DataCajero();
    public Cajero CrearCajero(int pedidosDespachados, String codigo, String horario, double sueldo, String cedula, 
            String nombre, String apellido, String direccion, String celular){
        Cajero objCajero = new Cajero(pedidosDespachados, codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        return objCajero;
    }
    public void GuardarCajero(Cajero objCajero) throws IOException{
        
        objDataCajero.GuardaArchivoCajero(objCajero);
        
    }
}
