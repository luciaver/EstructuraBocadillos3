package servicios;

import data.Gesdata;
import models.*;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PedidoServicio {
    // Lista que almacenará los pedidos generados
    private static ArrayList<Pedido> listaPedidos = Gesdata.listaPedidos;

    // Lista de usuarios obtenida desde el servicio de usuarios
    private static ArrayList<Usuario> listaUsuarios = Gesdata.listaUsuarios;
    private static ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    // Lista de bocadillos obtenida desde el servicio de bocadillos
    private static ArrayList<Bocadillo> listaBocadillos = Gesdata.listaBocadillos;


    public static void volcarPedidos() {
        for (Usuario u : listaUsuarios) {
            if (u instanceof Alumno) {
                listaAlumnos.add((Alumno) u);
            }
        }

        Random rand = new Random();
        // Genera 5 pedidos con datos aleatorios
        for (int i = 1; i <= 5; i++) {
            Alumno alumno = listaAlumnos.get(rand.nextInt(0, listaAlumnos.size() - 1));
            Bocadillo bocadillo = null;
            Pedido pedido = new Pedido(5, "Pendiente", alumno, bocadillo, LocalDate.now());

            listaPedidos.add(pedido);
            alumno.getListaPedidos().add(pedido);
        }

        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Pedido.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Pedido p : listaPedidos) {
                oos.writeObject(p);
            }

            fos.close();
            oos.flush();
            oos.close();

        } catch (EOFException e) {
            e.getMessage();

        } catch (FileNotFoundException e) {
            // No se encontró el archivo

        } catch (IOException e) {
        }

    }

    /**
     * Método para leer los pedidos almacenados en el archivo binario
     * y devolverlos en una lista.
     *
     * @return lista de pedidos cargados desde el archivo
     */


    public static ArrayList<Pedido> obtenerPedidos() {
        listaPedidos = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/persistencia/Pedido.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Pedido p;
            while (true) {
                p = (Pedido) ois.readObject();
                listaPedidos.add(p);
            }
        } catch (FileNotFoundException | EOFException e) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaPedidos;
    }
}

