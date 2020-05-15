/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CLases.Plato;
import Data.DataPlato;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class LogPlato {

     static DataPlato objDataPlato = new DataPlato();
    
    public ArrayList<Plato> importarPlatos(ArrayList<Plato> listaPlatos){
        objDataPlato.ImportarPlatos(listaPlatos);
        return listaPlatos;
    }
    
    public Plato CrearPlato (String nombre, String descripcion, double costo, double tiempo){
        Plato objPlato = new Plato(nombre, descripcion, costo, tiempo);
        return objPlato;
    }
    
    public void EliminarPlato(ArrayList<Plato> listaPlatos, Plato plato) throws IOException{
        listaPlatos.remove(plato);
        objDataPlato.GuardarArchivoPlatos(listaPlatos);
    }
    
    public void GuardarPlato(Plato plato) throws IOException{
        DataPlato objImpArchivosPlato = new DataPlato();
        objDataPlato.AgregarArchivoPlatos(plato);
    }
    
}
