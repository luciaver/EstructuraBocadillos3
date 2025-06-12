package ui;

import models.Pedido;
import models.Usuario;
import servicios.IncidenciaServicios;
import servicios.PedidoServicio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCocina {

    public static void menu(Usuario usuario) {
        String seleccionCocina;
        Scanner entrada = new Scanner(System.in);
        ArrayList<Pedido> listaPedidos = PedidoServicio.obtenerPedidos();

        do {
            System.out.println("====================================");
            System.out.println("=          MENÚ COCINA             =");
            System.out.println("====================================");
            System.out.println("1. Listar bocadillos de pedidos");
            System.out.println("2. Consultar pedidos");
            System.out.println("3. Reportar incidencias");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            seleccionCocina = entrada.nextLine();

            switch (seleccionCocina) {
                case "1":
                    if (listaPedidos.isEmpty()) {
                        System.out.println("No hay pedidos registrados.");
                    } else {
                        System.out.println("Bocadillos pedidos actualmente:");
                        int i = 1;
                        for (Pedido p : listaPedidos) {
                            System.out.println(i + ". " + p.getBocadillo().getNombre());
                            i++;
                        }
                    }
                    break;
                case "2":
                    if (listaPedidos.isEmpty()) {
                        System.out.println("No hay pedidos para consultar.");
                    } else {
                        System.out.println("Lista de pedidos detallada:");
                        for (Pedido p : listaPedidos) {
                            System.out.println("- Pedido #" + p.getId_pedido() + " Bocadillo: " + p.getBocadillo().getNombre() +
                                    " Alumno: " + p.getUsuario().getNombre() + "  Fecha: " + p.getFecha() +
                                    "  Estado: " + p.getEstado());
                        }
                    }
                    break;
                case "3":
                    System.out.println("Creando incidencia...");
                    if (!listaPedidos.isEmpty()) {
                        IncidenciaServicios.crearIncidencia(usuario);
                    } else {
                        System.out.println("No hay pedidos disponibles para crear incidencia.");
                    }
                    break;
                case "0":
                    System.out.println("Saliendo del menú de cocina...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!seleccionCocina.equals("4"));
    }
}
