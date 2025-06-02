package servicios;

import models.Bocadillo;
import models.Pedido;
import models.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PedidoServicio {
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private static ArrayList<Usuario> listaUsuarios = UsuarioServicios.obtenerUsuario();
    private static ArrayList<Bocadillo> listaBocadillos = BocadilloServicio.obtenerBocadillos();


    public static void volcarPedidos() {
        Random rand = new Random();
        for (int i = 1; i <= 5; i++) {
            listaPedidos.add(new Pedido(
                    i,
                    "pendiente",
                    listaUsuarios.get(rand.nextInt(0, listaUsuarios.size() - 1)),
                    listaBocadillos.get(rand.nextInt(0, listaBocadillos.size() - 1)),
                    null
            ));
            System.out.println("pedido " + i + " creado");
        }

        try {
            FileOutputStream fos = new FileOutputStream("src/persistencia/Pedido.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Pedido p : listaPedidos) {
                System.out.println(p.getBocadillo().getNombre());
                oos.writeObject(p);
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

    public static List<Pedido> obtenerPedidos() {
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

