package data;
import models.Usuario;

public class Session {
    private static Usuario usuarioActual;
//Verificar que usario esta ahora mismo

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuarioActual) {
        Session.usuarioActual = usuarioActual;
    }
}
