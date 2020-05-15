/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CLases.Mesero;

/**
 *
 * @author David Lopez
 */
public class LogMesero {

    public Mesero CrearMesero(int mesasAtendidas, String codigo, String horario, 
            double sueldo, String cedula, String nombre, String apellido, String direccion, String celular) {
        
        Mesero objJug = new Mesero(mesasAtendidas, codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        return objJug;
    }

}
