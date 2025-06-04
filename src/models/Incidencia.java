package models;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Incidencia implements Serializable {
    private int id;
    private String descripcion;
    private LocalDateTime fechaHora;
    private Pedido pedido;
    private boolean resuelta;

    public Incidencia() {
    }

    public Incidencia(int id, String descripcion, LocalDateTime fechaHora, Pedido pedido) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.pedido = pedido;
        this.resuelta = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Descripción: " + descripcion + ", FechaHora: " + fechaHora +
                ", ID Pedido: " + pedido + ", Resuelta: " + resuelta;
    }
}
