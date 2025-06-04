package ui;
import models.Bocadillo;
import servicios.BocadilloServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAlumno {
    public static void menu(){
        ArrayList<Bocadillo> listaBocadillos = BocadilloServicio.obtenerBocadillos();
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
            System.out.println("4. Salir");
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
                    //Horario

                    System.out.println("Horario para pedir : 9:00-12:00");

                    break;

                case "3":
                    //Historial de pedidos


                    break;

                case "4":
                    //Salir

                    System.out.println("Saliendo del menú de alumno...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!seleccionAlumno.equals("4"));
    }




}


