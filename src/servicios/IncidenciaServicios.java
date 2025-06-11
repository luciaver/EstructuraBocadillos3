package servicios;

import data.Gesdata;
import models.*;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class IncidenciaServicios {
    private static ArrayList<Incidencia> listaIncidencias = new ArrayList<>();

    public static void crearIncidencia(Usuario usuario){
        Scanner sc = new Scanner(System.in);
        Incidencia incidencia = new Incidencia();

        System.out.println("Introduzca la descripción de la incidencia: ");
        String descripcion = sc.nextLine();
        incidencia.setDescripcion(descripcion);

        incidencia.setUsuario(usuario);

        incidencia.setFechaHora(LocalDateTime.now());

        listaIncidencias.add(incidencia);
        volcarIncidencias();

        System.out.println("Incidencia creada con exito!");
    }

    public static void volcarIncidencias() {
        ArrayList<Usuario> listaUsuarios = Gesdata.listaUsuarios;
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Incidencia.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            listaIncidencias.add(new Incidencia(0, "incidencia 1", listaUsuarios.get(0)));
            listaIncidencias.add(new Incidencia(1, "incidencia 2", listaUsuarios.get(1)));
            listaIncidencias.add(new Incidencia(2, "incidencia 3", listaUsuarios.get(2)));
            // También se vuelcan los usuarios actuales en listaUsuarios
            for (Incidencia i : listaIncidencias) {
                oos.writeObject(i);
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

    public static ArrayList<Incidencia> obtenerIncidencias() {
        listaIncidencias.clear();
        try {
            FileInputStream fis = new FileInputStream("src/persistencia/Incidencia.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Incidencia i;
            while (true) {
                i = (Incidencia) ois.readObject();
                listaIncidencias.add(i);
            }
        } catch (FileNotFoundException | EOFException e) {
            //System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaIncidencias;
    }
}
