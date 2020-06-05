/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Archivos.Archivo;
import CLases.Menu;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author David Lopez
 */
public class LogMenu {

    static String fichero = "Archivos/Menu.dat";

    //************************
    public static void EscribirMenu(ArrayList ArrayObjetos) throws IOException {
        Archivo.escribir(ArrayObjetos, fichero);
    }

    public static void LeerMenu(ArrayList ArrayObjetos) throws IOException, FileNotFoundException, ClassNotFoundException {
        Archivo.leer(ArrayObjetos, fichero);
    }

    public static void InsertarMenu(ArrayList ArrayObjetos) throws IOException {
        Archivo.anhadeFichero(ArrayObjetos, fichero);
    }

    //************************
    public static boolean Existe() {
        return Archivo.ExisteFichero(fichero);
    }

    public static Menu MenuActivo() throws IOException, FileNotFoundException, ClassNotFoundException {
        Date fecha = new Date();
        SimpleDateFormat format_dia = new SimpleDateFormat("E");
        SimpleDateFormat format_mes = new SimpleDateFormat("MMM");
        String dia = format_dia.format(fecha);
        String mes = format_mes.format(fecha);
        ArrayList<Menu> ArrayMenus = new ArrayList<Menu>();
        LeerMenu(ArrayMenus);

        for (Menu objMenu : ArrayMenus) {
            String aux = objMenu.getDias().substring(0, objMenu.getDias().length() - 1);
            String[] dias = aux.split("\\|");
            String aux2 = objMenu.getMeses().substring(0, objMenu.getMeses().length() - 1);
            String[] meses = aux2.split("\\|");

            for (String auxMes : meses) {
                auxMes.toLowerCase();

                if (auxMes.toLowerCase().equals(mes)) {
                    for (String auxDia : dias) {
                        auxDia.toLowerCase();

                        if (auxDia.toLowerCase().equals(dia)) {

                            return objMenu;

                        }
                    }
                }
            }

        }
        return null;
    }
}
