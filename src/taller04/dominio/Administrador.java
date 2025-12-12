package taller04.dominio;

/**
 * Clase que representa a un Administrador.
 * <p>
 * Un administrador es un tipo de usuario con rol "ADMIN". Tiene acceso
 * completo a todas las funciones del sistema relacionadas con la gestión
 * de usuarios, certificaciones y registros.
 * </p>
 */
public class Administrador extends Usuario {

    /**
     * Constructor de la clase Administrador.
     * 
     * @param nombreUsuario El nombre de usuario del administrador.
     * @param contraseña La contraseña del administrador.
     */
    public Administrador(String nombreUsuario, String contraseña) {
        super(nombreUsuario, contraseña, "ADMIN");
    }

    /**
     * Método que retorna una representación en cadena del Administrador.
     * <p>
     * Esta representación incluye el nombre de usuario del administrador.
     * </p>
     *
     * @return Una cadena con los detalles del administrador.
     */
    @Override
    public String toString() {
        return "Administrador{" +
                "usuario='" + nombreUsuario + '\'' +
                '}';
    }
}