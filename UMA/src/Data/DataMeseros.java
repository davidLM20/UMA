/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import CLases.Mesero;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class DataMeseros {

    public void GuardarArrayMeseros(ArrayList<Mesero> ArrayMeseros) throws IOException {

        File f = new File("Archivos/Meseros.txt");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Mesero objMesero : ArrayMeseros) {
            bw.write("\n");
            bw.write(objMesero.getCodigo() + ",");
            bw.write(objMesero.getNombre() + ",");
            bw.write(objMesero.getApellido() + ",");
            bw.write(objMesero.getDireccion() + ",");
            bw.write(objMesero.getCedula() + ",");
            bw.write(objMesero.getCelular() + ",");
            bw.write(objMesero.getHorario() + ",");
            bw.write(objMesero.getMesasAtendidas() + ",");
            bw.write(objMesero.getSueldo() + ",");
        }
        bw.close();
        fw.close();
    }

    public void GuardarMesero(Mesero objMesero) throws IOException {
        File f = new File("Archivos/Meseros.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("\n");
        bw.write(objMesero.getCodigo() + ",");
        bw.write(objMesero.getNombre() + ",");
        bw.write(objMesero.getApellido() + ",");
        bw.write(objMesero.getDireccion() + ",");
        bw.write(objMesero.getCedula() + ",");
        bw.write(objMesero.getCelular() + ",");
        bw.write(objMesero.getHorario() + ",");
        bw.write(objMesero.getMesasAtendidas() + ",");
        bw.write(objMesero.getSueldo() + ",");

        bw.close();
        fw.close();
    }
}
