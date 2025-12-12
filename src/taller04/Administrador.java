package taller04;

public class Administrador extends Usuario {

    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña, "ADMIN");
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "usuario='" + nombreUsuario + '\'' +
                '}';
    }
}