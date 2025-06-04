package data;

import models.*;
import servicios.BocadilloServicio;
import servicios.IncidenciaServicios;
import servicios.PedidoServicio;
import servicios.UsuarioServicios;
import java.util.ArrayList;

public class Gesdata {
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Bocadillo> listaBocadillos = new ArrayList<>();
    public static ArrayList<Pedido> listaPedidos = new ArrayList<>();


    public static void iniciarFicheros() {
        UsuarioServicios.volcarListas();
        BocadilloServicio.volcarBocadillos();
        PedidoServicio.volcarPedidos();
        IncidenciaServicios.volcarIncidencias();
    }



    public static void cargarPedidos() {

    }

    public static void cargarCalendario() {

    }

    public static void insertarUsuario(Usuario nuevo) {
        listaUsuarios.add(nuevo);
    }

    public static void actualizarUsuarios(Usuario modificado) {
        UsuarioServicios.modificarUsuario(modificado);
    }

    public static void eliminarUsuario(Usuario eliminar) {
        UsuarioServicios.eliminarUsuario(eliminar.getUsuario());
    }
}
