/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLases.Cajero;
import CLases.Mesero;
import CLases.Plato;
import Data.DataMeseros;
import Data.DataPlato;
import Logica.LogCajero;
import Logica.LogMesero;
import Logica.LogPlato;
import java.io.IOException;
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
    static ArrayList<Mesero> ArrayMeseros = new ArrayList<Mesero>();
    static ArrayList<Plato> ArrayPlatos = new ArrayList<Plato>();
    static ArrayList<Cajero> ArrayCajeros = new ArrayList<Cajero>();
    static Cajero objCajero = new Cajero();

    static LogCajero objLogCajero = new LogCajero();

    static DataPlato objDataPlato = new DataPlato();
    static Scanner sc = new Scanner(System.in);
    static DataMeseros objDatosMeseros = new DataMeseros();
    static LogPlato objLogPlato = new LogPlato();

    public static void main(String[] args) throws ParseException, IOException {
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

        objDatosMeseros.GuardarArrayMeseros(ArrayMeseros);
        for (Mesero objMesero : ArrayMeseros) {
            System.out.println(objMesero.toString());
        }

    }

    //************************************************ Funciones para el manejo de gerente ************************************
    private static void Gerente() throws ParseException, IOException {

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
    private static void AdministrarEmpleado() throws ParseException, IOException {
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
                    RegistrarMesero(ArrayMeseros);
                    break;
                case 2:
                    RegistrarCajero(ArrayCajeros);
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

    private static void RegistrarCajero(ArrayList<Cajero> ArrayCajeros) throws IOException {
        // INGRESAR UN Cajero
        Scanner sc = new Scanner(System.in);
      
        //int pedidosDespachados, String codigo, String horario, double sueldo, String cedula, String nombre, String apellido, String direccion, String celular
        System.out.println("Ingrese cedula");
        String cedula = sc.nextLine();
        System.out.println("Ingrese nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese apellido");
        String apellido = sc.nextLine();
        System.out.println("Ingrese direccion");
        String direccion = sc.nextLine();
        System.out.println("Ingrese celular");
        String celular = sc.nextLine();
        System.out.println("Ingrese codigo");
        String codigo = sc.nextLine();
        System.out.println("Ingrese horario");
        String horario = sc.nextLine();
        System.out.println("Ingrese sueldo");
        double sueldo = sc.nextDouble();
        System.out.println("Ingrese numero de pedidos despachados");
        int  pedidosDespachados = sc.nextInt();

        objCajero = objLogCajero.CrearCajero(pedidosDespachados, codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        System.out.println(objCajero);
        ArrayCajeros.add(objCajero);

        objLogCajero.GuardarCajero(objCajero);

        System.out.println("Cajero Registrado");
    }

    private static void RegistrarMesero(ArrayList<Mesero> ArrayMeseros) throws ParseException {

        LogMesero objLogMesero = new LogMesero();

        sc.nextLine();

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
        System.out.println("Ingrese Horario de trabajo del Empleado");
        String horario = sc.nextLine();
        System.out.println("Ingresa el celular de empleado");
        String celular = sc.nextLine();
               
        System.out.println("Ingrese numero de mesas ");
        int mesasAtendidas = sc.nextInt();
        System.out.println("Ingrese sueldo del Empleado");
        double sueldo = sc.nextDouble();

        Mesero objMesero = new Mesero();
        objMesero = objLogMesero.CrearMesero(mesasAtendidas, Codigo, horario, sueldo, Cedula, Nombres, Apellidos, Direccion, celular);

        ArrayMeseros.add(objMesero);
        System.out.println("Mesero Registrado\n");

    }

    // Seccion de metodos de administracion Plato
    private static void AdministrarPlato() throws ParseException, IOException {
        String tecla = null;
        int op4 = 0;
        do {
            System.out.println("Que accion quiere realizar");
            System.out.println("<1>Crear Plato");
            System.out.println("<2>Eliminar Plato");
            System.out.println("<3>Listar Platos");
            System.out.println("<4>****");

            System.out.println("********************************");
            op4 = sc.nextInt();
            switch (op4) {
                case 1:
                    CrearPlato();
                    break;
                case 2:
                    //EliminarPlato();
                    break;
                case 3:
                    //ListarPlatos();
                    break;
                case 4:
                    break;
            }
            System.out.println("\n¿Quiere seguir?\n");
            System.out.println("Presione: S para continuar o N para regresar al menu");
            tecla = new Scanner(System.in).nextLine();
        } while (tecla.equals("s") || tecla.equals("S"));

    }

    private static void CrearPlato() throws ParseException, IOException {

        LogPlato objLogPlato = new LogPlato();

        sc.nextLine();

        System.out.println("Ingrese el nombre del plato");
        String nombre = sc.nextLine();
        System.out.println("Ingrese la descripcion del plato");
        String descripcion = sc.nextLine();
        System.out.println("Ingrese el costo del plato");
        double coste = sc.nextDouble();
        System.out.println("Ingrese el tiempo aproximado del plato(plato)");
        double tiempo = sc.nextDouble();

        Plato plato = objLogPlato.CrearPlato(nombre, descripcion, coste, tiempo);
        ArrayPlatos.add(plato);

        objLogPlato.GuardarPlato(plato);
        System.out.println("guardado exitoso");
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
