package practica;

import models.Alumno;
import models.Incidencia;
import models.Pedido;
import models.Usuario;
import servicios.IncidenciaServicios;
import servicios.PedidoServicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static final Scanner teclado = new Scanner(System.in);
    public static Pedido pedido1 = new Pedido();
    private static Usuario us1 = new Usuario("usuario1", "Juan", "Pérez", "juan.perez@mail.com", "123456", "1", LocalDate.of(2000, 1, 1));


    //MENU MENU
    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("========  MENÚ DE INICIO ========");
            System.out.println("1. Login");
            System.out.println("2. Registro");
            System.out.println("3. Recuperar contraseña");
            System.out.println("4. Salir");
            System.out.println("Seleccione una opción (1-4)");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Login");
                    System.out.println("Iniciando el proceso de login...");
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Registro");
                    System.out.println("Iniciando el proceso de Registro...");
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Recuperar contraseña");
                    System.out.println("Iniciando el proceso de recuperar contraseña...");
                    break;

                default:
                    System.out.println("Opción seleccionada: Salir");
                    System.out.println("Saliendo del programa...");
            }

        } while (opcion != 4);
    }

    public static void login() {
        int opcion;
        do {
            System.out.println("========  MENÚ DE INICIO ========");
            System.out.println("1. Usuario");
            System.out.println("2. Contraseña");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción (1-3)");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada: Usuario");
                    System.out.println("Validando usuario...");
                    break;
                case 2:
                    System.out.println("Opción seleccionada: Contraseña");
                    System.out.println("Validando contraseña...");
                    break;

                default:
                    System.out.println("Opción seleccionada: Salir");
                    System.out.println("Saliendo del programa...");
            }

        } while (opcion != 3);
    }


    //MENU USUARIO
    public static void menuUsuario() {
        int opcion;
        do {
            System.out.println("========  MENÚ DE ALUMNO========");
            System.out.println("1. Solicitar bocadillo");
            System.out.println("2. Horario");
            System.out.println("3. Historial de bocadillos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción (1-4): ");
            opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Opción seleccionada:Solicitar bocadillos");

                    break;
                case 2:
                    System.out.println("Opción seleccionada: Horario");

                    break;
                case 3:
                    System.out.println("Historial de bocadillos");
                    mostrarMenu();
                    break;
                case 4:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }


    public static void menuAdministrador() {
        int opcion2;
        do {
            System.out.println("========  MENÚ DE ADMINISTRADOR ========");
            System.out.println("1. Gestionar Bocadillos");
            System.out.println("2. Gestionar Usuarios");
            System.out.println("3. Gestionar Pedidos");
            System.out.println("4. Retroceder");
            System.out.println("Seleccione una opción (1-4)");
            opcion2 = teclado.nextInt();
            switch (opcion2) {
                case 1:
                    System.out.println("Opción seleccionada:Gestionar Bocadillos");
                    System.out.println("Iniciando el proceso de gestionar bocadillos de un usuario...");
                    break;
                case 2:
                    System.out.println("Opción seleccionada:Gestionar Usuarios");
                    System.out.println("Iniciando el proceso de gestionar usuarios...");
                    break;
                case 3:
                    System.out.println("Opción seleccionada: Gestionar Pedidos");
                    System.out.println("Iniciando el proceso de Gestionar Pedidos de un usuario...");
                    break;
                case 4:
                    mostrarMenu();
                    break;
                default:
                    System.out.println("Seleccione una opción");
                    break;
            }

        } while (opcion2 != 4);
    }

    public static void menuCocina() {
        Scanner sc = new Scanner(System.in);
        int opcion3;

        do {
            System.out.println("======MENÚ COCINA======");
            System.out.println("1.Listar Bocadillos");
            System.out.println("2.Consultar Bocadillos");
            System.out.println("3.Salir");
            System.out.println("Selecciona una opción");
            teclado.nextLine();
            opcion3 = teclado.nextInt();

            switch (opcion3) {
                case 1:
                    System.out.println("Opcion seleccionada: Listar bocadillos");
                    break;
                case 2:
                    System.out.println("opcion seleccionada: Consultar Pedidos");
                    break;
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Seleccione una opción");
            }
        } while (opcion3 != 3);
    }

    public static void crearIncidencia(Usuario usuario) {
        ArrayList<Pedido> listaPedidos = PedidoServicio.obtenerPedidos();

        System.out.println("Creando incidencia...");
        if (!listaPedidos.isEmpty()) {
            IncidenciaServicios.crearIncidencia(usuario);
        } else {
            System.out.println("No hay pedidos disponibles para crear incidencia.");
        }
    }

    public static void listarIncidencias() {
        ArrayList<Incidencia> listaIncidencias = IncidenciaServicios.obtenerIncidencias();

        System.out.println("Listado de incidencias:");
        for (Incidencia i : listaIncidencias) {
            System.out.println(i.toString());
        }
    }
}






