import autentication.MenuAutenticar;
import data.Gesdata;
import models.*;
import servicios.BocadilloServicio;
import servicios.PedidoServicio;
import servicios.UsuarioServicios;
import ui.MenuAdministrador;
import ui.MenuAlumno;
import ui.MenuCocina;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Gesdata.iniciarFicheros();


        Usuario activo;

        activo = MenuAutenticar.menAuth();

        if (activo == null) System.out.println("NO ESTAS EN EL SISTEMA");
        else {
            if (activo instanceof Alumno) {
                MenuAlumno.menu();
            }

            if (activo instanceof Cocina) {
                MenuCocina.menu();
            }

            if (activo instanceof Administrador) {
                MenuAdministrador.menu();
            }
        }
    }
}

