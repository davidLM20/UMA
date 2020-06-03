/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CLases.Cajero;
import CLases.Cocinero;
import CLases.Mesero;
import CLases.Pedido;
import CLases.Plato;

import Data.DataMeseros;
import Data.DataPlato;
import Logica.LogCajero;
import Logica.LogCocinero;
import Logica.LogMesero;
import Logica.LogPedido;
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
    static ArrayList<Cocinero> ArrayCocineros = new ArrayList<Cocinero>();

    static LogPlato objLogPlato = new LogPlato();
    static LogCajero objLogCajero = new LogCajero();
    static LogPedido objLogPedido = new LogPedido();

    static DataPlato objDataPlato = new DataPlato();
    static DataMeseros objDatosMeseros = new DataMeseros();

    static Cajero objCajero = new Cajero();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws ParseException, IOException {
        // TODO code application logic here
        //objDataPlato.ImportarPlatos(ArrayPlatos);
        objDatosMeseros.ImportarMeseros(ArrayMeseros);

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

        //objDatosMeseros.GuardarArrayMeseros(ArrayMeseros);       
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
                    RegistrarMesero();
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
    private static void RegistrarCocinero() throws ParseException, IOException {

        LogCocinero objLogCocinero = new LogCocinero();

        sc.nextLine();

        //int pedidosDespachados, String codigo, String horario, double sueldo, String cedula, String nombre, String apellido, String direccion, String celular
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
        int pedidosDespachados = sc.nextInt();
        System.out.println("Ingrese sueldo del Empleado");
        double sueldo = sc.nextDouble();

        Cocinero objCocinero = objLogCocinero.CrearCocinero(pedidosDespachados, Codigo, horario, sueldo, Cedula, Nombres, Apellidos, Direccion, celular);
        ArrayCocineros.add(objCocinero);
        objLogCocinero.GuardarCocinero(objCocinero);

        System.out.println("Cocinero Registrado\n");

    }

    private static void RegistrarCajero(ArrayList<Cajero> ArrayCajeros) throws IOException {
        // INGRESAR UN Cajero
        Cajero objCajero = new Cajero();

        sc.nextLine();

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
        int pedidosDespachados = sc.nextInt();

        objCajero = objLogCajero.CrearCajero(pedidosDespachados, codigo, horario, sueldo, cedula, nombre, apellido, direccion, celular);
        ArrayCajeros.add(objCajero);
        objLogCajero.GuardarCajero(objCajero);

        System.out.println("Cajero Registrado\n");
//       
    }

    private static void RegistrarMesero() throws ParseException, IOException {

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

        //Mesero objMesero = new Mesero();
        Mesero objMesero = objLogMesero.CrearMesero(mesasAtendidas, Codigo, horario, sueldo, Cedula, Nombres, Apellidos, Direccion, celular);
        ArrayMeseros.add(objMesero);
        objLogMesero.GuardarMesero(objMesero);
        System.out.println("Mesero Registrado\n");

    }
    //********************************************************Funciones pertenecientes a Mesero**********************************************

    private static void Mesero() throws ParseException, IOException {
        String tecla = null;
        int op2 = 0;
        do {
            System.out.println("Que accion quiere realizar");
            System.out.println("<1>Cargar Menu");
            System.out.println("<2>Registrar Pedido");
            System.out.println("<3>Agregar Adicional");
            System.out.println("<4>");

            System.out.println("**");
            op2 = sc.nextInt();
            switch (op2) {
                case 1:
                    //CargarMenu();
                    break;
                case 2:
                    RegistrarPedido();
                    break;
                case 3:
                    //AgregarAdicional();
                    break;
                case 4:
                    break;

            }

            System.out.println("\n¿Quiere seguir?\n");
            System.out.println("Presione: S para continuar o N para regresar al menu");
            tecla = new Scanner(System.in).nextLine();
        } while (tecla.equals("s") || tecla.equals("S"));
    }

    public static void RegistrarPedido() throws ParseException, IOException {
        Pedido objPedido = objLogPedido.CrearPedido(null);
        presentarMenu();
        sc.nextLine();
        String tecla = null;
        do {
            System.out.println("Seleccione el plato que desea");
            int x = sc.nextInt();
            System.out.println("Seleccione la cantidad del mismo");
            int n = sc.nextInt();

            objLogPedido.agregarPlatoPedido(objPedido, ArrayPlatos.get(x - 1), n);

            System.out.println("\n¿Quiere seguir?\n");
            System.out.println("Presione: S para continuar o N para regresar al menu");
            tecla = new Scanner(System.in).nextLine();
        } while (tecla.equals("s") || tecla.equals("S"));
        objLogPedido.calcularTiempoAprox(objPedido);
        System.out.println("El tiempo aproximado de este pedido es: " + objPedido.getTiempoAproximado() + "min");
    }

    private static void presentarMenu() throws ParseException, IOException {
        ListarPlatos();
    }
//***********************************************************************
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
                    EliminarPlato();
                    break;
                case 3:
                    ListarPlatos();
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
        
        Plato objPlato = new Plato();
        
        ArrayPlatos.add(new Plato(nombre,descripcion,coste,tiempo));
        objLogPlato.EscribirPlatos(ArrayPlatos);
        //ArrayPlatos.add(plato);

        //objLogPlato.GuardarPlato(plato);
        System.out.println("guardado exitoso");
    }

    private static void ListarPlatos() throws ParseException, IOException {

        //RECORRER UN ARRAY LIST
        ArrayPlatos.clear();
        objLogPlato.importarPlatos(ArrayPlatos);
        int n = 1;
        for (Plato objPlato : ArrayPlatos) //RECORRER EL ARRAY LIST
        {
            System.out.println(n + ". " + objPlato.toString());
            n += 1;
        }

    }

    private static void EliminarPlato() throws ParseException, IOException {
        ListarPlatos();
        System.out.println("Ingrese el numero del plato que desea eliminar");
        int idPlato = sc.nextInt();
        Plato plato_seleccionado = ArrayPlatos.get(idPlato - 1);
        objLogPlato.EliminarPlato(ArrayPlatos, plato_seleccionado);

    }

    // Seccion de metodos de administracion Menu
    private static void AdministrarMenu() {
    }
    // Seccion de metodos de estadisticas empleado

    private static void EstadisticasEmpleado() {
    }

    //**********************************************************Fuciones pertenecientes a Cocienro********************************************
    private static void Cocinero() {

    }

    //**********************************************************Fuciones pertenecientes a Cajero***********************************************
    private static void Cajero() {

    }

}
