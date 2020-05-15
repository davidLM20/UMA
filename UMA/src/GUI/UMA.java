/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLases.Mesero;
import Logica.LogEmpleado;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class UMA {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Mesero> ArrayMesero = new ArrayList<Mesero>();
    static Scanner sc = new Scanner(System.in);
    
    

    public static void main(String[] args) throws ParseException {
        // TODO code application logic here

        int op = 0;

        // menu Principal 
        boolean salir = false;
        while (!salir) {
            System.out.println("Como desea Ingresar");
            System.out.println("<1>Gerente");
            System.out.println("<2>Mesero");
            System.out.println("<3>Cocinero");
            System.out.println("<4>Cajero");
            System.out.println("<5>Salir");

            System.out.println("********************************");

            op = sc.nextInt();
            switch (op) {
                case 1:
                    Gerente();
                    break;
                case 2:
                    Mesero();
                    break;
                case 3:
                    Cocinero();
                    break;
                case 4:
                    Cajero();
                    break;
                case 5:
                    salir = true;
                    break;
            }
        }

    }

    //************************************************ Funciones para el manejo de gerente ************************************
    private static void Gerente() throws ParseException {

        String tecla = null;
        int op2 = 0;
        do {
            System.out.println("Que accion quiere realizar");
            System.out.println("<1>Administrar Empleado");
            System.out.println("<2>Administrar Plato");
            System.out.println("<3>Administrar Menu");
            System.out.println("<4>Ver Estadisticas de los empleados");
            System.out.println("<5>****");

            System.out.println("********************************");
            op2 = sc.nextInt();
            switch (op2) {
                case 1:
                    AdministrarEmpleado();
                    break;
                case 2:
                    AdministrarPlato();
                    break;
                case 3:
                    AdministrarMenu();
                    break;
                case 4:
                    EstadisticasEmpleado();
                    break;
                case 5:
                    break;
            }

            System.out.println("\n¿Quiere seguir?\n");
            System.out.println("Presione: S para continuar o N para regresar al menu");
            tecla = new Scanner(System.in).nextLine();
        } while (tecla.equals("s") || tecla.equals("S"));

    }

    /// Funciones para la administracion de Empleados**********
    //Menu de administracion empleado
    private static void AdministrarEmpleado() throws ParseException {
        String tecla = null;
        int op3 = 0;
        do {
            System.out.println("Que accion quiere realizar");
            System.out.println("<1>Registrar Mesero");
            System.out.println("<2>Registrar Cajero");
            System.out.println("<3>Registrar Cocinero");
            //System.out.println("<4>Ver Estadisticas de los empleados"); Para agregar si eliminar o actualizar datos
            System.out.println("<5>****");

            System.out.println("********************************");
            op3 = sc.nextInt();
            switch (op3) {
                case 1:
                    RegistrarMesero(ArrayMesero);
                    break;
                case 2:
                    RegistrarCajero();
                    break;
                case 3:
                    RegistrarCocinero();
                    break;
                case 4:
                    break;

            }

            System.out.println("\n¿Quiere seguir?\n");
            System.out.println("Presione: S para continuar o N para regresar al menu");
            tecla = new Scanner(System.in).nextLine();
        } while (tecla.equals("s") || tecla.equals("S"));
    }
    // seccion de metodos de creaccion de empleados
    private static void RegistrarCocinero() {
        
        
    }

    private static void RegistrarCajero() {
    }

    private static void RegistrarMesero( ArrayList<Mesero> ArrayMeseros) throws ParseException{
      
        LogEmpleado objLogEmpleado = new LogEmpleado();       
               
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese Codigo");
        String Codigo = sc.nextLine();
        System.out.println("Ingrese nombres del Empleado");
        String Nombres = sc.nextLine();
        System.out.println("Ingrese apellidos del Empleado");
        String Apellidos = sc.nextLine();
        System.out.println("Ingrese direccion del Empleado");
        String Direccion = sc.nextLine();
        System.out.println("Ingrese cedula del Empleado");
        String Cedula = sc.nextLine();
        System.out.println("Ingrese estatura del jugador");
        String Estatura = sc.nextLine();
        System.out.println("Ingrese dieta del jugador");
        String Dieta = sc.nextLine();
        System.out.println("Ingrese numero de posicion del jugador");
        int NumeroJug = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese numero de partidos del jugador");
        int PartidoJugados = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese categoria del jugador");
        String Categoria = sc.nextLine();
        
        
        
    }
    // Seccion de metodos de administracion Plato
    private static void AdministrarPlato() {
    }
    // Seccion de metodos de administracion Menu

    private static void AdministrarMenu() {
    }
    // Seccion de metodos de estadisticas empleado

    private static void EstadisticasEmpleado() {
    }

    //********************************************************Funciones pertenecientes a Mesero**********************************************
    private static void Mesero() {

    }

    //**********************************************************Fuciones pertenecientes a Cocienro********************************************
    private static void Cocinero() {

    }

    //**********************************************************Fuciones pertenecientes a Cajero***********************************************
    private static void Cajero() {

    }

}
