package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario  implements Serializable {
    private String usuario;
    private String nombre;
    private String apellidos;
    private String correo;
    private String password;
    private LocalDate fecha_nacimiento;
    private String curso;
    private List<String> incidencias = new ArrayList<>();

    public Usuario() {}

    public Usuario(String usuario, String nombre, String apellidos, String correo, String password, String curso, LocalDate fecha_nacimiento) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.curso = curso;
        this.fecha_nacimiento = fecha_nacimiento;
    }


    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public List<String> getIncidencias() {
        return incidencias;
    }

    public void agregarIncidencia(String incidencia) {
        this.incidencias.add(incidencia);
    }

    public void mostrarInfoUsuario() {
        System.out.println("Usuario: " + usuario);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Correo: " + correo);
        System.out.println("Fecha de Nacimiento: " + fecha_nacimiento);
    }
}
