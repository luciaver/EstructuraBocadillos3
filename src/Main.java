import autentication.MenuAutenticar;
import data.Gesdata;
import models.*;
import servicios.IncidenciaServicios;
import servicios.PedidoServicio;
import ui.MenuAdministrador;
import ui.MenuAlumno;
import ui.MenuCocina;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gesdata.iniciarFicheros();

        Usuario activo;

        activo = MenuAutenticar.menAuth();

        if (activo == null) System.out.println("NO ESTAS EN EL SISTEMA");
        else {
            if (activo instanceof Alumno) {
               MenuAlumno.menu((Alumno) activo);
            }

            if (activo instanceof Cocina) {
                MenuCocina.menu(activo);
            }

            if (activo instanceof Administrador) {
                MenuAdministrador.menu();
            }
        }
    }
}


