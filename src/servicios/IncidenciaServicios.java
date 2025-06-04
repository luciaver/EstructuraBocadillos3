package servicios;

import models.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class IncidenciaServicios {
    private static ArrayList<Incidencia> listaIncidencias = new ArrayList<>();
    private static ArrayList<Pedido> listaPedidos = PedidoServicio.obtenerPedidos();
    private static ArrayList<Usuario> listaUsuarios = UsuarioServicios.obtenerUsuario();

    public static void crearIncidencia(String desripcion, Pedido pedido){
        //todo -> crear menú incidencias
        Incidencia incidencia = new Incidencia();

        incidencia.setDescripcion(desripcion);

        incidencia.setFechaHora(LocalDateTime.now());

        incidencia.setPedido(pedido);
    }

    public static void eliminarIncidencia(Incidencia incidencia) {
        listaIncidencias.remove(incidencia);
    }

    public static void resolverIncidencia(Incidencia incidencia) {
        incidencia.setResuelta(true);
    }

    public static void editarDescIncidencia(Incidencia incidencia) {
        //sout de poner descripción con scanner:)
        incidencia.setDescripcion("ola jajant");
    }

    public static void volcarIncidencias() {
        ArrayList<Pedido> listaPedidos = PedidoServicio.obtenerPedidos();
        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Incidencia.dat", true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new Incidencia(0, "incidencia 1", LocalDateTime.now(), listaPedidos.get(0)));
            oos.writeObject(new Incidencia(1, "incidencia 2", LocalDateTime.now(), listaPedidos.get(1)));
            oos.writeObject(new Incidencia(2, "incidencia 3", LocalDateTime.now(), listaPedidos.get(2)));
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
