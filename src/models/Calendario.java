package models;

import java.io.Serializable;
import java.time.LocalDate;


public class Calendario implements Serializable {
    private int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Bocadillo[] quincena_frio;
    private Bocadillo[] quincena_caliente;

    public Calendario() {
        this.id = 0;
        this.fecha_inicio = LocalDate.now();
        this.fecha_fin = null;
        this.quincena_frio = new Bocadillo[7];
        this.quincena_caliente = new Bocadillo[7];
    }

    public Calendario(int id, LocalDate fecha_inicio, LocalDate fecha_fin, Bocadillo[] quincena_frio, Bocadillo[] quincena_caliente) {
        this.id = id;
        this.fecha_inicio = fecha_inicio != null ? fecha_inicio : LocalDate.now();
        this.fecha_fin = fecha_fin;
        this.quincena_frio = quincena_frio;
        this.quincena_caliente = quincena_caliente;
    }

    @Override
    public String toString() {
        return "";
    }
}
