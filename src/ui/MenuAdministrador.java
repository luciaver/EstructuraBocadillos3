package ui;

import models.Usuario;
import servicios.BocadilloServicio;
import servicios.PedidoServicio;
import servicios.UsuarioServicios;

import java.util.Scanner;

public class MenuAdministrador {

    public static void menu() {
        String seleccionAdmin;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("====================================");
            System.out.println("=       MENÚ ADMINISTRADOR         =");
            System.out.println("====================================");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Bocadillos");
            System.out.println("3. Gestión de Pedidos");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            seleccionAdmin = scanner.nextLine();

            switch (seleccionAdmin) {
                case "1":
                    String opcionUsuario;
                    do {
                        System.out.println("----- GESTIÓN DE USUARIOS -----");
                        System.out.println("1. Insertar Usuario");
                        System.out.println("2. Modificar Usuario");
                        System.out.println("3. Buscar Usuario");
                        System.out.println("4. Eliminar Usuario");
                        System.out.println("5. Volver al Menú Principal");
                        System.out.print("Selecciona una opción: ");
                        opcionUsuario = scanner.nextLine();

                        switch (opcionUsuario) {
                            case "1": // Insertar un nuevo usuario
                                Usuario nuevoUsuario = new Usuario();
                                UsuarioServicios.insertarUsuario(nuevoUsuario);
                                break;
                            case "2": // Modificar
                                System.out.print("Introduce el nombre de usuario a modificar: ");
                                String usuarioAModificar = scanner.nextLine();
                                Usuario usuarioExistente = UsuarioServicios.buscarUsuario(usuarioAModificar);
                                if (usuarioExistente != null) {
                                    Usuario modificado = new Usuario();
                                    modificado.setUsuario(usuarioExistente.getUsuario());
                                    System.out.print("Nuevo nombre: ");
                                    modificado.setNombre(scanner.nextLine());
                                    System.out.print("Nuevos apellidos: ");
                                    modificado.setApellidos(scanner.nextLine());
                                    System.out.print("Nuevo correo: ");
                                    modificado.setCorreo(scanner.nextLine());
                                    System.out.print("Nueva contraseña: ");
                                    modificado.setPassword(scanner.nextLine());
                                    System.out.print("Nueva fecha de nacimiento (YYYY-MM-DD): ");
                                    modificado.setFecha_nacimiento(java.time.LocalDate.parse(scanner.nextLine()));
                                    UsuarioServicios.modificarUsuario(modificado);
                                } else {
                                    System.out.println("Usuario no encontrado.");
                                }
                                break;
                            case "3": // Buscar
                                System.out.print("Introduce el nombre de usuario a buscar: ");
                                String usuarioBuscado = scanner.nextLine();
                                Usuario encontrado = UsuarioServicios.buscarUsuario(usuarioBuscado);
                                if (encontrado != null) {
                                    System.out.println("Usuario encontrado: " + encontrado.getUsuario());
                                    System.out.println("Nombre: " + encontrado.getNombre());
                                    System.out.println("Correo: " + encontrado.getCorreo());
                                } else {
                                    System.out.println("Usuario no encontrado.");
                                }
                                break;
                            case "4": // Eliminar
                                System.out.print("Introduce el nombre de usuario a eliminar: ");
                                String usuarioEliminar = scanner.nextLine();
                                UsuarioServicios.eliminarUsuario(usuarioEliminar);
                                break;
                            case "5":
                                System.out.println("Volviendo al menú principal...");
                                break;
                            default:
                                System.out.println("Opción no válida. Intenta de nuevo.");
                        }
                    } while (!opcionUsuario.equals("5"));
                    break;

                case "2":
                    BocadilloServicio.gestionarBocadillosAdmin();
                    break;
                case "3":
                    System.out.println("Entrando en gestión de pedidos...");
                    break;
                case "4":
                    System.out.println("Saliendo del menú de administrador...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (!seleccionAdmin.equals("4"));

        scanner.close();
    }
}
