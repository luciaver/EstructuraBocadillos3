package models;

import java.io.Serializable;
import java.util.Scanner;

public class Pedido implements Serializable {
    static Scanner teclado = new Scanner(System.in);
    private static int id_pedido;
    private static Usuario usuario;
    private static Bocadillo bocadillo;
    private static Calendario fecha;
    private static String estado;
    private static Usuario[] listaUsuarios;
    private static Bocadillo[] listaBocadillos;

    public Pedido() {
    }

    public Pedido(int id_pedido, String estado, Usuario usuario, Bocadillo bocadillo, Calendario fecha) {
        this.id_pedido = id_pedido;
        this.estado = estado;
        this.usuario = usuario;
        this.bocadillo = bocadillo;
        this.fecha = fecha;

    }

    public static void seleccionarBocadillo() {

    }

    public boolean tieneAlergia(Bocadillo bocata, Usuario usuario) {
        return false;
    }

    public static String mostrarDetallesPedido(Usuario u1) {
        return "";
    }

    public static void marcarRetirado() {
    }

    public void mostrarNotificaciones(Bocadillo b1, Usuario u1) {
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Pedido.usuario = usuario;
    }

    public static Bocadillo getBocadillo() {
        return bocadillo;
    }

    public static void setBocadillo(Bocadillo bocadillo) {
        Pedido.bocadillo = bocadillo;
    }

    public Calendario getFecha() {
        return fecha;
    }

    public void setFecha(Calendario fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


}



