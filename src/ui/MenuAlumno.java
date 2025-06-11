package ui;
import practica.Menu;
import models.Alumno;
import models.Bocadillo;
import models.Pedido;
import servicios.BocadilloServicio;
import servicios.IncidenciaServicios;
import servicios.PedidoServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAlumno {
    public static void menu(Alumno alumno){
        ArrayList<Bocadillo> listaBocadillos = BocadilloServicio.obtenerBocadillos();
        ArrayList<Pedido> listaPedidos = PedidoServicio.obtenerPedidos();
        ArrayList<Bocadillo> listaFrios = new ArrayList<>();
        ArrayList<Bocadillo> listaCaliente = new ArrayList<>();
        int cont = 1;
        Scanner scanner = new Scanner(System.in);
        String seleccionAlumno;

        for (Bocadillo b : listaBocadillos) {
            if (b.isCaliente()) {
                listaCaliente.add(b);
            } else {
                listaFrios.add(b);
            }
        }

        //Menu principal alumno
        do {

            System.out.println("====================================");
            System.out.println("=          MENÚ ALUMNO             =");
            System.out.println("====================================");
            System.out.println("1. Solicitar bocadillo");
            System.out.println("2. Horario Bocadillo");
            System.out.println("3. Historial de pedidos");
            System.out.println("4. Reportar incidencia");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            seleccionAlumno = scanner.nextLine();

            switch (seleccionAlumno) {

                //Solicitar bocadillo

                case "1":
                    System.out.println("Elige tu bocadillo");
                    System.out.println("Frios: ");

                    for (Bocadillo b : listaFrios) {
                        if (LocalDate.now().isEqual(b.getCalendario().getFecha())) {
                            System.out.println(cont + "." + b.getNombre() + " - " + b.getPrecio() + "€");
                            cont++;
                        }
                    }

                    System.out.println("Calientes: ");

                    for (Bocadillo b : listaCaliente) {
                        if (LocalDate.now().isEqual(b.getCalendario().getFecha())) {
                            System.out.println(cont + "." + b.getNombre() + " - " + b.getPrecio() + "€");
                            cont++;
                        }
                    }

                    break;

                case "2":

                    System.out.println("Horario para pedir : 9:00-12:00");

                    break;

                case "3":
                    listarPedidos(alumno);

                    break;

                case "4":
                    System.out.println("Creando incidencia..."); //todo -> mostrar pedidos del alumno para escoger aa cual hacer la incidencia
                    if (!listaPedidos.isEmpty()) {
                        IncidenciaServicios.crearIncidencia(alumno);
                    } else {
                        System.out.println("No hay pedidos disponibles para crear incidencia.");
                    }
                    break;


                case "0":
                    System.out.println("Saliendo del menú de alumno...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!seleccionAlumno.equals("4"));
    }

    public static void listarPedidos(Alumno alumno) {
        //todo -> menu para pedidos
        for (Pedido p : alumno.getListaPedidos()){
            System.out.println(p.getBocadillo().getNombre());
            System.out.println(p.getCalendario().getFecha());
            System.out.println(p.getEstado());
        }
    }



}


