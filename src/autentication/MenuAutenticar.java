package autentication;

import data.Gesdata;
import models.Alumno;
import models.Usuario;
import servicios.UsuarioServicios;
import ui.MenuAlumno;
import utils.Validaciones;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAutenticar {

    public static Usuario menAuth() {
        Usuario usuarioActivo = null;
        ArrayList<Usuario> listaUsuarios = UsuarioServicios.obtenerUsuario();
        Scanner entrada = new Scanner(System.in);

        do {
            try {
                System.out.println("1. Iniciar Sesión");
                System.out.println("2. Registro");
                System.out.println("3. Restablecer Contraseña");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");

                int opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {
                    case 1:
                        usuarioActivo = AuthService.login();
                        break;
                    case 2:
                        usuarioActivo = AuthService.registro();
                        break;
                    case 3:
                        Validaciones.recuperacontrasenya(listaUsuarios);
                    case 0:
                        System.out.println("Saliendo...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Debes introducir un valor entero");
                entrada.nextLine();
            }
        } while (usuarioActivo == null);

        return usuarioActivo;
    }


    }



