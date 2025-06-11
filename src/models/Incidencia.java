package models;
import java.io.Serializable;
import java.time.LocalDateTime;


public class Incidencia implements Serializable {
    private int id;
    private String descripcion;
    private LocalDateTime fechaHora;
    private Usuario usuario;
    private boolean resuelta;

    public Incidencia() {
    }

    public Incidencia(int id, String descripcion, Usuario usuario) {
        this.id = id;
        this.descripcion = descripcion;
        this.fechaHora = LocalDateTime.now();
        this.usuario = usuario;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
                ", ID Pedido: " + usuario + ", Resuelta: " + resuelta;
    }
}
