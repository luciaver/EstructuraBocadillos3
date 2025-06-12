package data;
import models.Usuario;

public class Session {
    private static Usuario usuarioActual;
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuarioActual) {
        Session.usuarioActual = usuarioActual;
    }
}
