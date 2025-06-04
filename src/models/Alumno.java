package models;

import java.time.LocalDate;

public class Alumno extends Usuario {

    //Variables y getters y setters

    private String [] alergias;
    private String curso;
    private String num_expediente;
    private String motivoBaja;
    private String fechaBaja;

    public Alumno(String usuario, String nombre, String apellidos,
                  String correo, String password, LocalDate fecha_nacimiento,
                  String[] alergias, String curso, String num_expediente) {

        super(usuario, nombre, apellidos, correo, password, curso, fecha_nacimiento);
        this.alergias = alergias;
        this.curso = curso;
        this.num_expediente = num_expediente;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public String getCurso() {
        return curso;
    }
    public String getNum_expediente() {
        return num_expediente;
    }
    public String getMotivoBaja() {
        return motivoBaja;
    }
    public String getFechaBaja() {
        return fechaBaja;
    }
    public void darDeBaja(String motivo, String fecha) {
        this.motivoBaja = motivo;
        this.fechaBaja = fecha;
    }






}
