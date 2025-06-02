package utils;

import models.Usuario;

import java.time.LocalDate;
import java.util.*;

public class Validaciones {
    static String usuarioRegistrado = null;
    static String contrasenyaRegistrada = null;
    static Scanner teclado = new Scanner(System.in);
    static int intentosLogin = 0;

    public static void login() {
        if (usuarioRegistrado == null) {
            System.out.println("Error, no hay usuarios registrados");
            return;
        }

        if (contrasenyaRegistrada == null) {
            System.out.println("Error, no hay contraseñas registradas");
        }
        if (intentosLogin >= 3) {
            System.out.println("Error, usted ha intentado iniciar sesión mas de 3 veces y esta bloqueado temporalmente");
            return;
        }
        System.out.print("Introduce el nombre de usuario : ");
        teclado.nextLine();
        String usuario = teclado.nextLine();
        System.out.print("Introduce la contraseña : ");
        String contrasenya = teclado.nextLine();

        if (usuario.equals(usuarioRegistrado) && contrasenya.equals(contrasenyaRegistrada)) {
            System.out.println("Inicio de sesión correcto " + usuario + "!");

        } else {
            System.out.println("Error, usuario o contraseña incorrectas");
            intentosLogin++;
        }
    }


    public static boolean verificarContrasenya(String contrasenya) {
        System.out.print("Introduce de nuevo la contraseña para verificarla: ");
        String contrasenya2 = teclado.nextLine();
        while ((!contrasenya2.equals(contrasenya))) {
            System.out.print("Las contraseñas no coinciden. Introduce de nuevo la contraseña para verificarla: ");
            contrasenya2 = teclado.nextLine();
        }

        System.out.println("Las contraseñas coinciden.");
        return true;
    }


    public static void registro() {
        if (usuarioRegistrado != null) {
            System.out.println("Error, ya hay un usuario registrado");
        } else {
            System.out.print("Introduce el nombre (Solo nombre, letras o caracteres especiales no válidos): ");
            teclado.nextLine();
            String nombre = teclado.nextLine();
            validarNombre(nombre);

            System.out.print("Introduce el apellido (Solo nombre, letras o caracteres especiales no válidos):");
            String apellido = teclado.nextLine();
            validarApellido(apellido);

            boolean esCorrecto = false;
            while (!esCorrecto) {
                System.out.print("Introduce el email(caracteres@gmail.com): ");
                String email = teclado.nextLine();
                esCorrecto = comprobarEmail(email);
            }

            System.out.println("Introduce tu fecha de nacimiento");
            System.out.print("Introduce el dia: ");
            int dia = teclado.nextInt();
            System.out.print("Introduce el mes: ");
            int mes = teclado.nextInt();
            System.out.print("Introduce el año: ");
            int anyo = teclado.nextInt();
            // validarEdad(dia, mes, anyo);

            System.out.print("Introduce el nombre de usuario(Puede contener letras, números y carácteres especiales): ");
            teclado.nextLine();//limpia buffer
            usuarioRegistrado = teclado.nextLine();
            validarUsuario(usuarioRegistrado);

            System.out.print("Introduce una contraseña: ");
            contrasenyaRegistrada = teclado.nextLine();
            validarContrasenya(contrasenyaRegistrada);

            System.out.print("Pregunta de seguridad (ej. ¿Cuál es tu color favorito?): ");
            String respuestaSeguridad = teclado.nextLine();
            captcha();
        }
    }


    public static void recuperacontrasenya(ArrayList<Usuario> listaUsuarios) {
        System.out.print("Introduce el nombre de usuario: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();

        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(nombre)) {
                System.out.print("Establezca la nueva contraseña: ");
                String contrasenyaNueva = teclado.nextLine();
                validarContrasenya(contrasenyaNueva);
                contrasenyaRegistrada = contrasenyaNueva;
                u.setPassword(contrasenyaRegistrada);

                System.out.println("CONTRASEÑA CAMBIADA CON EXITO!");
            } else {
                System.out.println("Usuario no encontrado");
                return;
            }
        }
    }


    public static boolean validarContrasenya(String contrasenya) {
        while (contrasenya.length() < 8) {
            System.out.println("Error, la contraseña debe tener minimo 8 caracteres, inténtalo de nuevo");
            contrasenya = teclado.nextLine();
            validarContrasenya(contrasenya);
            return false;
        }
        //METODO PARA VALIDAR LAS CONDICIONES DE LA CONTRASEÑA

        boolean tieneMayus = false;
        boolean tieneMinus = false;
        boolean tieneNum = false;
        boolean tieneEspec = false;
        do {
            for (int i = 0; i < contrasenya.length(); i++) {
                char ch = contrasenya.charAt(i);

                if (Character.isUpperCase(ch)) {
                    tieneMayus = true;
                } else if (Character.isLowerCase(ch)) {
                    tieneMinus = true;
                } else if (Character.isDigit(ch)) {
                    tieneNum = true;
                } else if (!Character.isLetterOrDigit(ch)) {
                    tieneEspec = true;
                }
            }

            if (!(tieneEspec && tieneNum && tieneMayus && tieneMinus)) {
                System.out.println("Error, introduce de nuevo la contraseña, debe tener 1 MAYUSCULA, 1 MINUSCULA, 1 NUMERO Y 1 CARACTER ESPECIAL");
                contrasenya = teclado.nextLine();
                return false;
            }

        } while (!(tieneEspec && tieneNum && tieneMayus && tieneMinus));
        verificarContrasenya(contrasenya);

        return true;
    }


    public static boolean validarEdad(String fecha) {
        String[] fecha_partes = fecha.split("-");
        int anyo = Integer.parseInt(fecha_partes[0]);
        int mes = Integer.parseInt(fecha_partes[1]);
        int dia = Integer.parseInt(fecha_partes[2]);

        if (dia <= 0 || dia > 31) {
            System.out.print("Error, establezca un día entre 1 y 31\nDia: ");
            return false;
        }

        if (mes <= 0 || mes > 12) {
            System.out.print("El mes debe tener un valor válido entre 1 y 12\nMes: ");
            return false;
        }

        if (anyo < 1920 || anyo > 2024) {
            System.out.print("El año debe tener un valor válido, entre 1930 y 2024\nAño: ");
            return false;
        }

        if (anyo == 2006) {
            if (mes == 12) {
                if (dia > 0 && dia < 31) {
                    System.out.println("Eres menor de edad\nNO PUEDES REGISTARTE!");
                    System.exit(0);
                }
            }
            if (mes == 11) {
                if (dia > 25) {
                    System.out.println("Eres menor de edad\nNO PUEDES REGISTARTE!");
                    System.exit(0);
                }
            }
        }

        System.out.println("REGISTRO COMPLETADO");
        return true;
    }


    public static boolean validarNombre(String nombre) {
        while (nombre.length() == 0 || nombre.length() < 5) {
            System.out.println("Error, el nombre esta vacío o debe tener más de 5 carácteres");
            System.out.print("Introduce el nombre(solo letras): ");
            nombre = teclado.nextLine();
        }
        boolean todoMayus = true;
        for (int i = 0; i < nombre.length(); i++) {
            if (!Character.isUpperCase(nombre.charAt(i))) {
                todoMayus = false;
                break;
            }
        }
        if (todoMayus) {
            System.out.print("Error, no puede ser todo el nombre en mayúsculas: ");
            nombre = teclado.nextLine();
            return validarNombre(nombre);
        }
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (!Character.isUpperCase(nombre.charAt(0))) {
                System.out.print("Error, el primer carácter del nombre debe estar en mayúscula, inténtalo de nuevo: ");
                nombre = teclado.nextLine();
                return validarNombre(nombre);
            }

            if (Character.isDigit(c)) {
                System.out.print("Error, el nombre no puede contener números : ");
                nombre = teclado.nextLine();
                return validarNombre(nombre);

            }
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                    c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                    c == 'ñ' || c == 'Ñ' || c == 'ü' || c == 'Ü')) {
                System.out.println("Error, el nombre contiene caracteres no permitidos");
                System.out.print("Introduce de nuevo el nombre(solo letras): ");
                nombre = teclado.nextLine();
                return validarNombre(nombre);
            }
        }
        System.out.println("NOMBRE CORRECTO: " + nombre);
        return true;
    }

    public static boolean validarUsuario(String usuario) {
        while (usuario.length() == 0) {
            System.out.println("Error, el usuario esta vacío");
            System.out.print("Introduce el nombre de usuario: ");
            usuario = teclado.nextLine();

        }
        System.out.println("NOMBRE DE USUARIO CORRECTO: " + usuario);
        return true;
    }

    public static boolean validarApellido(String apellido) {
        while (apellido.length() == 0) {
            System.out.println("Error, el apellido esta vacío");
            System.out.print("Introduce el apellido(solo letras): ");
            apellido = teclado.nextLine();

        }
        boolean todoMayus = true;
        for (int i = 0; i < apellido.length(); i++) {
            if (!Character.isUpperCase(apellido.charAt(i))) {
                todoMayus = false;
                break;
            }
        }
        if (todoMayus) {
            System.out.print("Error, no puede ser todo el apellido en mayúsculas: ");
            apellido = teclado.nextLine();
            return validarApellido(apellido);
        }
        for (int i = 0; i < apellido.length(); i++) {
            char c = apellido.charAt(i);
            if (!Character.isUpperCase(apellido.charAt(0))) {
                System.out.print("Error, el primer carácter del apellido debe estar en mayúscula, inténtalo de nuevo: ");
                apellido = teclado.nextLine();
                return validarApellido(apellido);
            }

            if (Character.isDigit(c)) {
                System.out.print("Error, el apellido no puede contener números : ");
                apellido = teclado.nextLine();
                return validarApellido(apellido);

            }
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                    c == 'Á' || c == 'É' || c == 'Í' || c == 'Ó' || c == 'Ú' ||
                    c == 'ñ' || c == 'Ñ' || c == 'ü' || c == 'Ü')) {

                System.out.println("Error, el apellido contiene caracteres no permitidos");
                System.out.print("Introduce de nuevo el apellido(solo letras): ");
                apellido = teclado.nextLine();
                return validarApellido(apellido);
            }
        }
        System.out.println("APELLIDO CORRECTO: " + apellido);
        return true;
    }


    public static boolean comprobarEmail(String email) {
        int index = email.indexOf("@"); //Almacena la primera posición del @
        if (index < 0) {//Si no hay @ devuelve falso y error
            return false;
        }
        boolean igual = true;
        String gmail = "@gmail.com";
        String dominio = email.substring(index);
        if (gmail.length() != dominio.length()) {
            return false;
        }
        for (int i = 0; i < gmail.length(); i++) {
            if (dominio.charAt(i) != gmail.charAt(i)) {
                igual = false;
                break;
            }
        }
        System.out.println("EMAIL CORRECTO: " + email);
        return igual;
    }


    public static void captcha() {
        int random1 = (int) (Math.random() * 100 + 1);
        int random2 = (int) (Math.random() * 100 + 1);
        System.out.println("CAPTCHA POR SEGURIDAD");
        System.out.println("Resuelva la suma de " + random1 + " + " + random2);
        int sumaUsuario = teclado.nextInt();

        if (sumaUsuario == random1 + random2) {
            System.out.println("CAPTCHA VERIFICADO\n¡Registro completado!");

        } else {

            System.out.println("CAPTCHA INCORRECTO, INTÉNTELO DE NUEVO");
            captcha();
        }
    }


}