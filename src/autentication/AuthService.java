package autentication;
import data.Gesdata;
import models.Alumno;
import models.Usuario;
import utils.Validaciones;

import java.time.LocalDate;
import java.util.Scanner;

public class AuthService {

    public static Usuario login() {
        Scanner entrada= new Scanner(System.in);
        String usuario,password;

        System.out.println("### LOGIN ###");
        System.out.println("Introduce el usuario:");
        usuario=entrada.nextLine();
        System.out.println("Introduce la contraseña:");
        password=entrada.nextLine();

        try {

        }catch (NullPointerException e){
            System.out.println("No hay usuarios en la lista");
        }
        for (Usuario item : Gesdata.listaUsuarios) {
            if (item != null) {

                if (item.getUsuario().equals(usuario) && item.getPassword().equals(password)) {
                    System.out.println("USUARIO ENCONTRADO");
                    return item;

                }

                System.out.println("El usuario o la contraseña son incorrectos");

            }

        }
        return null;
    }
    public static Usuario registro(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registro de usuario");
        String usuario,nombre,apellidos,correo,password,curso;
        String[] alergias;
        String fecha_nacimiento;



        do {
            System.out.print("Ingrese su usuario : ");
             usuario = scanner.nextLine();
        }while (!Validaciones.validarUsuario(usuario));

        do {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine();
        }while (!Validaciones.validarNombre(nombre));

        do{
            System.out.print("Ingrese sus apellidos: ");
            apellidos = scanner.nextLine();
        } while (!Validaciones.validarApellido(apellidos));

        do {
            System.out.print("Ingrese su correo: ");
            correo = scanner.nextLine();

        }while (!Validaciones.comprobarEmail(correo));

        do {
            System.out.print("Contraseña: ");
            password = scanner.nextLine();

        }while (!Validaciones.validarContrasenya(password));

        do {
            System.out.println("Introduce tu fecha de nacimiento (AA-MM-DD): ");
            fecha_nacimiento= scanner.nextLine();
        }while (!Validaciones.validarEdad(fecha_nacimiento));

        System.out.print("Introduce tu curso: ");
        curso = scanner.nextLine();

        Usuario nuevoUsuario=new Alumno(usuario, nombre, apellidos, correo, password, LocalDate.parse(fecha_nacimiento), null, curso, null);
        Gesdata.listaUsuarios.add(nuevoUsuario);

        return nuevoUsuario;
    }
}






