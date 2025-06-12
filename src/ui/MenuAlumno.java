package ui;

import models.Alumno;
import models.Bocadillo;
import models.Pedido;
import models.Usuario;
import servicios.BocadilloServicio;
import servicios.PedidoServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAlumno {

    public static void menu(Alumno alumno){
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
            System.out.println("1. Pedir bocadillo");
            System.out.println("2. Horario Bocadillo");
            System.out.println("3. Historial de pedidos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            seleccionAlumno = scanner.nextLine();

            switch (seleccionAlumno) {


                case "1":
                    ArrayList<Bocadillo> disponibles = new ArrayList<>();
                    System.out.print("¿Quieres un bocadillo frío o caliente? (f/c): ");
                    String tipo = scanner.nextLine().toLowerCase();

                    ArrayList<Bocadillo> listaSeleccionada = tipo.equals("f") ? listaFrios : tipo.equals("c") ? listaCaliente : null;

                    if (listaSeleccionada == null) {
                        System.out.println("Tipo no reconocido.");
                        break;
                    }

                    System.out.println((tipo.equals("f") ? "Fríos:" : "Calientes:"));
                    int i = 0;
                    for (Bocadillo b : listaSeleccionada) {
                        if (LocalDate.now().isEqual(b.getCalendario().getFecha())) {
                            System.out.println(i + ". " + b.getNombre() + " - " + b.getPrecio() + "€");
                            disponibles.add(b);
                            i++;
                        }
                    }

                    if (disponibles.isEmpty()) {
                        System.out.println("No hay bocadillos disponibles hoy.");
                        break;
                    }

                    System.out.print("Selecciona el número del bocadillo: ");
                    try {
                        int op = Integer.parseInt(scanner.nextLine());
                        if (op < 0 || op >= disponibles.size()) {
                            System.out.println("Opción inválida.");
                            break;
                        }

                        Bocadillo bocata = disponibles.get(op);
                        Pedido nuevoPedido = new Pedido(0, "Pendiente", alumno, bocata, LocalDate.now());
                        PedidoServicio.obtenerPedidos();
                        System.out.println("Pedido realizado correctamente.");
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada no válida.");
                    }

                    //Escoger un bocadillo de la lista, y creas el pedido ap artir de ese bocadillo
                    //Pedir si es frío o caliente

                    //Si escojo el 0 de la lista de fríos:::::   Bocadillo bocata=listafrios.get(op);

                    //Pedido nuevoP=new Pedido(alumno, bocata, LocalDate.now(),"Pendiente");

                    break;

                case "2":

                    System.out.println("Horario para pedir : 9:00-12:00");

                    break;

                case "3":
                    int contador = 1;
                    for (Pedido p : alumno.getListaPedidos()) {
                        System.out.println(contador + p.toString());
                        contador++;
                    }


                    break;

                case "4":

                    System.out.println("Saliendo del menú de alumno...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!seleccionAlumno.equals("4"));
    }


}

