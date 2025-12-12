package taller04.dominio;

/**
 * Representa a un usuario con rol de Coordinador dentro del sistema.
 * <p>
 * El coordinador es responsable de administrar líneas de certificación,
 * analizar métricas y gestionar información relacionada con estudiantes.
 * </p>
 */
public class Coordinador extends Usuario {

    /** Área académica o administrativa a la que pertenece el coordinador. */
    private String area;

    /**
     * Crea una instancia de Coordinador asignando usuario, contraseña y área correspondiente.
     *
     * @param nombreUsuario Nombre de usuario del coordinador.
     * @param contraseña    Contraseña de acceso.
     * @param area          Área académica o administrativa del coordinador.
     */
    public Coordinador(String nombreUsuario, String contraseña, String area) {
        super(nombreUsuario, contraseña, "COORDINADOR");
        this.area = area;
    }

    /**
     * Obtiene el área del coordinador.
     *
     * @return Área asignada.
     */
    public String getArea() {
        return area;
    }

    /**
     * Modifica el área del coordinador.
     *
     * @param area Nueva área a asignar.
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * Representación en texto del coordinador.
     *
     * @return Cadena con el nombre de usuario y el área.
     */
    @Override
    public String toString() {
        return "Coordinador{" +
                "usuario='" + nombreUsuario + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}