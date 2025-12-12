package taller04.dominio;

/**
 * Representa la relación entre una certificación y una asignatura específica.
 * <p>
 * Cada instancia de esta clase asocia una certificación con un curso (NRC),
 * indicando qué asignaturas forman parte de cada línea de certificación.
 * </p>
 */
public class AsignaturaCertificacion {

    /** ID único de la certificación asociada. */
    private String idCertificacion;

    /** Código NRC del curso asociado. */
    private String nrc;

    /**
     * Crea una nueva relación entre certificación y asignatura.
     *
     * @param idCertificacion Identificador de la certificación.
     * @param nrc Código NRC de la asignatura perteneciente a la certificación.
     */
    public AsignaturaCertificacion(String idCertificacion, String nrc) {
        this.idCertificacion = idCertificacion;
        this.nrc = nrc;
    }

    /**
     * Obtiene el ID de la certificación asociada.
     *
     * @return ID de la certificación.
     */
    public String getIdCertificacion() {
        return idCertificacion;
    }

    /**
     * Establece el ID de la certificación asociada.
     *
     * @param idCertificacion Nuevo ID de certificación.
     */
    public void setIdCertificacion(String idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    /**
     * Obtiene el NRC del curso asociado.
     *
     * @return Código NRC del curso.
     */
    public String getNrc() {
        return nrc;
    }

    /**
     * Establece el NRC del curso asociado.
     *
     * @param nrc Nuevo código NRC del curso.
     */
    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    /**
     * Retorna una representación en texto de la relación entre certificación y asignatura.
     *
     * @return Cadena con el ID de certificación y el NRC del curso asociado.
     */
    @Override
    public String toString() {
        return "AsignaturaCertificacion{" +
                "idCertificacion='" + idCertificacion + '\'' +
                ", nrc='" + nrc + '\'' +
                '}';
    }
}