package models;

import java.io.Serializable;
import java.time.LocalDate;

public class Cocina extends Usuario implements Serializable {

    public Cocina(String usuario, String nombre, String apellidos, String correo, String password, LocalDate fecha_nacimiento) {
        super(usuario, nombre, apellidos, correo, password, null, fecha_nacimiento);
    }
    public void crearIncidencia(){

    }

    public boolean servirBocadillo(){
        return false;
    }




}
