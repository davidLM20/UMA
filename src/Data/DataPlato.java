/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import CLases.Plato;
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
public class DataPlato {

    public void ImportarPlatos(ArrayList<Plato> ArrayPlatos) {
        // PARA CARGAR LOS ARRAYS DE PAQUETES Y CLIENTES DESDE UN ARCHIVO TEXTO,
        // PARA ESTE EJEMPLO TENEMOS UN SOLO ARCHIVO, SE PUEDE TENER LOS QUE UDS. QUIERAN
        // PREFERIBLE SEPARAR POR CLASES
        File f = new File("Archivos/Platos.txt");
        StringTokenizer st;
        Scanner entrada = null;
        String sCadena;
        try {
            entrada = new Scanner(f);
            while (entrada.hasNext()) {
                sCadena = entrada.nextLine();
                st = new StringTokenizer(sCadena, ",");
                while (st.hasMoreTokens()) {
                    Plato objTmpPlato = new Plato(st.nextToken(), st.nextToken(), Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
                    ArrayPlatos.add(objTmpPlato);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            entrada.close();
        }
    }

    public void GuardarArchivoPlatos(ArrayList<Plato> arrayPlato) throws FileNotFoundException, IOException {
        //
        File f = new File("Archivos/Platos.txt");
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Plato objPlato : arrayPlato) {
            bw.write(objPlato.getNombre() + ",");
            bw.write(objPlato.getDescripcion() + ",");
            bw.write(objPlato.getCosto() + ",");
            bw.write(objPlato.getTiempo() + "\n");
        }
        bw.close();
        fw.close();
    }

    public void AgregarArchivoPlatos(Plato objPlato) throws FileNotFoundException, IOException {
        //
        File f = new File("Archivos/Platos.txt");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(objPlato.getNombre() + ",");
        bw.write(objPlato.getDescripcion() + ",");
        bw.write(objPlato.getCosto() + ",");
        bw.write(objPlato.getTiempo() + "\n");
        bw.close();

        fw.close();
    }

}
