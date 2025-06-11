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
                    System.out.println("Listando bocadillos...");
                    
                    //for(Pedido p : listaPedidos) {'1. ' + p.getNombre}
                    break;
                case "2":
                    System.out.println("Consultando pedidos...");
                    //todo -> hacer menú para listar pedidos
                    //for(Pedido p : listaPedidos) {'1. ' + p.getNombre} (lista toda la informacion relevante de los pedidos)
                    break;
                case "3":
                    System.out.println("Creando incidencia..."); //todo -> mostrar pedidos del alumno para escoger aa cual hacer la incidencia
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
