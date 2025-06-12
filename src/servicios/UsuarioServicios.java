package servicios;

import models.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioServicios {
    // Lista que almacena los usuarios registrados en memoria
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param usuario nombre de usuario a buscar
     * @return el objeto Usuario si se encuentra, o null si no
     */

    public static Usuario buscarUsuario(String usuario) {
        for (Usuario itemUsuario : listaUsuarios)
            if (itemUsuario.getUsuario().equals(usuario))
                return itemUsuario;

        return null;

    }

    public static void listarUsuarios() {
        for (Usuario u : listaUsuarios) {
            u.mostrarInfoUsuario();
        }
    }


    public static void insertarUsuario(Usuario nuevo) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        nuevo.setNombre(nombre);

        System.out.println("Apellido:");
        String apellido = scanner.nextLine();
        nuevo.setApellidos(apellido);

        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        nuevo.setCorreo(correo);

        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        nuevo.setPassword(contrasena);

        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        nuevo.setCurso(curso);

        System.out.println("Usuario registrado con éxito.");

        nuevo = new Alumno(nombre, nombre, apellido, correo, contrasena, LocalDate.of(2004, 9, 25), null, curso, "A");

        listaUsuarios.add(nuevo);
        volcarListas();
    }

    /**
     * Modifica los datos de un usuario existente según el objeto `modificado`.
     *
     * @param modificado Usuario con los datos actualizados.
     */

    public static void modificarUsuario(Usuario modificado) {
        Usuario usu = buscarUsuario(modificado.getUsuario());
        if (usu != null) {
            usu.setNombre(modificado.getNombre());
            usu.setApellidos(modificado.getApellidos());
            usu.setCorreo(modificado.getCorreo());
            usu.setPassword(modificado.getPassword());
            usu.setFecha_nacimiento(modificado.getFecha_nacimiento());
            System.out.println("Usuario modificado.");
        } else {
            System.out.println("Usuario no encontrado.");
        }

    }

    /**
     * Elimina un usuario por su nombre de usuario.
     *
     * @param eliminar nombre de usuario a eliminar
     */
    public static void eliminarUsuario(String eliminar) {
        Usuario encontrado = null;
        for (Usuario itemUsuario : listaUsuarios) {
            if (itemUsuario.getUsuario().equals(eliminar)) {
                encontrado = itemUsuario;
                break;
            }
        }
        if (encontrado != null) {
            listaUsuarios.remove(encontrado);
            System.out.println("El usuario se ha eliminado");
        } else {
            System.out.println("Usuario no encontrado");
        }
    }


    public static void volcarListas() {
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Usuarios.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            /*listaUsuarios.add(new Alumno("lolo", "lolo", "lol", "lolo@gmail.com", "123456", LocalDate.now(), null, "1ºESO", "A"));
            listaUsuarios.add(new Alumno("lolo", "lolo", "lol", "lolo@gmail.com", "123456", LocalDate.now(), null, "1ºESO", "A"));
            listaUsuarios.add(new Alumno("maria", "gomez", "mari", "maria@gmail.com", "abcdef", LocalDate.now(), null, "1ºESO", "B"));
            listaUsuarios.add(new Alumno("juan", "perez", "juampi", "juanp@gmail.com", "654321", LocalDate.now(), null, "2ºESO", "A"));
            listaUsuarios.add(new Alumno("ana", "lopez", "anita", "ana.lopez@gmail.com", "qwerty", LocalDate.now(), null, "3ºESO", "C"));
            listaUsuarios.add(new Alumno("carlos", "ruiz", "charly", "carlosr@gmail.com", "zxcvb", LocalDate.now(), null, "4ºESO", "B"));
            listaUsuarios.add(new Alumno("lucia", "navarro", "luci", "lucia.n@gmail.com", "112233", LocalDate.now(), null, "1ºESO", "A"));

            listaUsuarios.add(new Cocina("cocina1", "Pepa", "pep", "pepa@gmail.com", "123456", LocalDate.now()));
            listaUsuarios.add(new Administrador("admin", "Admin", "vera", "admin@gmail.com", "123456", LocalDate.now()));*/
            // También se vuelcan los usuarios actuales en listaUsuarios
            for (Usuario u : listaUsuarios) {
                oos.writeObject(u);
            }

            fos.close();
            oos.flush();
            oos.close();

        } catch (EOFException e) {
            e.getMessage();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {
        }

    }

    public static ArrayList<Usuario> obtenerUsuario() {
        listaUsuarios.clear();

        try {
            FileInputStream fis = new FileInputStream("src/persistencia/Usuarios.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Usuario u;
            while (true) {
                u = (Usuario) ois.readObject();
                listaUsuarios.add(u);
            }
        } catch (FileNotFoundException | EOFException e) {
            //System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

}




