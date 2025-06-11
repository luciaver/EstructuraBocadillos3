package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Usuario {

    //Variables y getters y setters

    private String [] alergias;
    private String curso;
    private String num_expediente;
    private String motivoBaja;
    private String fechaBaja;
    private ArrayList<Pedido> listaPedidos;

    public Alumno(String usuario, String nombre, String apellidos,
                  String correo, String password, LocalDate fecha_nacimiento,
                  String[] alergias, String curso, String num_expediente) {

        super(usuario, nombre, apellidos, correo, password, curso, fecha_nacimiento);
        this.alergias = alergias;
        this.curso = curso;
        this.num_expediente = num_expediente;
        this.listaPedidos = new ArrayList<>();
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

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public void setNum_expediente(String num_expediente) {
        this.num_expediente = num_expediente;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
