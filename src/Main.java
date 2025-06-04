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

        ArrayList<Pedido> listaPedidos = PedidoServicio.obtenerPedidos();
        ArrayList<Incidencia> listaIncidencias = IncidenciaServicios.obtenerIncidencias();

        for (Pedido p : listaPedidos) {
            System.out.println(p.getId_pedido());
        }

        for (Incidencia i : listaIncidencias) {
            System.out.println(i.getDescripcion());
        }

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


