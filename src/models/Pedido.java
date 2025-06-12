package models;
import models.Calendario;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Pedido implements Serializable {
    static Scanner teclado = new Scanner(System.in);
    private int id_pedido;
    private Usuario usuario;
    private Bocadillo bocadillo;
    private LocalDate fecha;
    private String estado;


    public Pedido() {
    }

    //Constructores
    public Pedido(int id_pedido, String estado, Usuario usuario, Bocadillo bocadillo, LocalDate fecha) {
        this.id_pedido = id_pedido;
        this.estado = estado;
        this.usuario = usuario;
        this.bocadillo = bocadillo;
        this.fecha = fecha;

    }


    public static void seleccionarBocadillo() {

    }
    //Getters y Setters

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bocadillo getBocadillo() {
        return bocadillo;
    }

    public void setBocadillo(Bocadillo bocadillo) {
        this.bocadillo = bocadillo;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                " usuario=" + usuario +
                ", bocadillo=" + bocadillo +
                ", fecha=" + fecha +
                ", estado='" + estado + '\'' +
                '}';
    }
}



