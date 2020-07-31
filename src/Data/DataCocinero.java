/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import CLases.Cajero;
import CLases.Cocinero;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author David Lopez
 */
public class DataCocinero {

    public void ImportarCocineros(ArrayList<Cocinero> ArrayPlatos) {

        // PREFERIBLE SEPARAR POR CLASES
        File f = new File("Archivos/Cocineros.txt");
        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    Cocinero objTmpPlato = new Cocinero(Integer.parseInt(st.nextToken()), 
                            st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken());
                    ArrayPlatos.add(objTmpPlato);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
    }

    public void GuardarArchivoCocinero(ArrayList<Cocinero> ArrayCocinero) throws IOException {
        File f = new File("Archivos/Cocineros.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Cocinero objCocinero : ArrayCocinero) {
            bw.write("\n");
            bw.write(objCocinero.getPlatosRealizados()+ ",");
            bw.write(objCocinero.getCodigo() + ",");
            bw.write(objCocinero.getHorario() + ",");
            bw.write(objCocinero.getSueldo() + ",");
            bw.write(objCocinero.getCedula() + ",");
            bw.write(objCocinero.getNombre() + ",");
            bw.write(objCocinero.getApellido() + ",");
            bw.write(objCocinero.getDireccion() + ",");
            bw.write(objCocinero.getCelular() + ",");

        }
        bw.close();
        fw.close();
    }

    public void GuardarArchivosCocinero(Cocinero objCocinero) throws IOException{
        File f = new File("Archivos/Cocineros.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
      
            bw.write("\n");
            bw.write(objCocinero.getPlatosRealizados()+ ",");
            bw.write(objCocinero.getCodigo() + ",");
            bw.write(objCocinero.getHorario() + ",");
            bw.write(objCocinero.getSueldo() + ",");
            bw.write(objCocinero.getCedula() + ",");
            bw.write(objCocinero.getNombre() + ",");
            bw.write(objCocinero.getApellido() + ",");
            bw.write(objCocinero.getDireccion() + ",");
            bw.write(objCocinero.getCelular() + ",");

  
        bw.close();
        fw.close();
    }
}
