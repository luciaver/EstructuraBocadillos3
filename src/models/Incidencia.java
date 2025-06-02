package models;
import java.time.LocalDateTime;


public class Incidencia {
    private int id;
    private String descripcion;
    private LocalDateTime fechaHora;
    private int idPedido;
    private boolean resuelta;

    public Incidencia(int id, String descripcion, LocalDateTime fechaHora, int idPedido) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.idPedido = idPedido;
        this.resuelta = false;
    }

    public int getId() {
        return id;
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
    public int getIdPedido() {
        return idPedido;
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
                ", ID Pedido: " + idPedido + ", Resuelta: " + resuelta;
    }
}
