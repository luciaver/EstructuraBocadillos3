package models;

import java.time.LocalDate;
import java.util.Scanner;

//Variables y getters and setters
public class Administrador extends Usuario {
    private int nivel;
    private static Scanner scanner = new Scanner(System.in);

    public Administrador(String usuario, String nombre, String correo, String password, int nivel) {
        super(usuario, nombre, "", correo, password, null, LocalDate.now());
        this.nivel = nivel;
    }


    public Administrador(String usuario, String nombre, String apellidos, String correo, String password, LocalDate fecha_nacimiento) {
        super(usuario, nombre, apellidos, correo, password, null, fecha_nacimiento);
        this.nivel = 3;
    }

    public void obtenerIncidencias() {
        // Método aún por implementar
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
