package models;

import java.io.Serializable;
import java.time.LocalDate;

//Variable
public class Calendario implements Serializable {
    private int id;
    private LocalDate fecha;

    //Constructores
    public Calendario() {
        this.id = 0;
        this.fecha = LocalDate.now();
    }

    public Calendario(int id, LocalDate fecha) {
        this.id = id;
        this.fecha = fecha;
    }
    public Calendario(LocalDate fecha) {
        this.id = 0;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "";
    }
}
