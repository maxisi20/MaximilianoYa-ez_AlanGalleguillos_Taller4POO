package taller04.dominio;

/**
 * Representa a un estudiante dentro del sistema.
 * <p>
 * Un estudiante es un tipo de usuario con información académica adicional
 * como RUT, carrera, semestre y correo institucional. También puede
 * asociarse al progreso en certificaciones y cursos inscritos.
 * </p>
 */
public class Estudiante extends Usuario {

    /** RUT del estudiante. */
    private String rut;

    /** Nombre completo del estudiante. */
    private String nombreCompleto;

    /** Carrera a la que pertenece el estudiante. */
    private String carrera;

    /** Semestre académico actual del estudiante. */
    private int semestre;

    /** Correo institucional del estudiante. */
    private String correo;

    /**
     * Crea un estudiante con su información personal y académica.
     *
     * @param nombreUsuario  Nombre de usuario para iniciar sesión.
     * @param contraseña     Contraseña de acceso.
     * @param rut            RUT del estudiante.
     * @param nombreCompleto Nombre completo.
     * @param carrera        Carrera a la que pertenece.
     * @param semestre       Semestre actual.
     * @param correo         Correo institucional del estudiante.
     */
    public Estudiante(String nombreUsuario, String contraseña,
                      String rut, String nombreCompleto,
                      String carrera, int semestre, String correo) {

        super(nombreUsuario, contraseña, "ESTUDIANTE");

        this.rut = rut;
        this.nombreCompleto = nombreCompleto;
        this.carrera = carrera;
        this.semestre = semestre;
        this.correo = correo;
    }

    /** @return RUT del estudiante. */
    public String getRut() {
        return rut;
    }

    /** @param rut Nuevo RUT del estudiante. */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /** @return Nombre completo del estudiante. */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /** @param nombreCompleto Nuevo nombre completo. */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /** @return Carrera del estudiante. */
    public String getCarrera() {
        return carrera;
    }

    /** @param carrera Nueva carrera. */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /** @return Semestre actual del estudiante. */
    public int getSemestre() {
        return semestre;
    }

    /** @param semestre Nuevo semestre. */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /** @return Correo institucional del estudiante. */
    public String getCorreo() {
        return correo;
    }

    /** @param correo Nuevo correo institucional. */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Representación en texto del estudiante.
     *
     * @return Cadena con información resumida del estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "usuario='" + getNombreUsuario() + '\'' +
                ", rut='" + rut + '\'' +
                ", nombre='" + nombreCompleto + '\'' +
                ", carrera='" + carrera + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}