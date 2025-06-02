package servicios;

import models.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioServicios {
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static Usuario buscarUsuario(String usuario) {
        for (Usuario itemUsuario : listaUsuarios)
            if (itemUsuario.getUsuario().equals(usuario))
                return itemUsuario;

        return null;

    }


    public static void insertarUsuario(Usuario nuevo) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Apellido:");
        String apellido =scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();
        System.out.println("Usuario registrado con éxito.");
        listaUsuarios.add(nuevo);

    }

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
            FileOutputStream fos = new FileOutputStream("src/persistencia/Usuarios.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Alumno("lolo", "lolo", "lol", "lolo@gmail.com", "123456", LocalDate.now(), null, "1ºESO", "A"));
            oos.writeObject(new Cocina("cocina1", "Pepa", "pep", "pepa@gmail.com", "123456", LocalDate.now()));
            oos.writeObject(new Administrador("admin", "Admin", "vera", "admin@gmail.com", "123456", LocalDate.now()));
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
        return (ArrayList<Usuario>) listaUsuarios;
    }

}




