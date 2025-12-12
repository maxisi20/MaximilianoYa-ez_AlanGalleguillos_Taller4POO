package taller04.dominio;

/**
 * Representa una nota obtenida por un estudiante en un curso específico.
 * <p>
 * Una nota incluye el RUT del estudiante, el código del curso asociado,
 * la calificación obtenida, el estado del curso (aprobado, reprobado, cursando)
 * y el periodo académico en el que fue evaluado.
 * </p>
 */
public class Nota {

    /** RUT del estudiante al que pertenece la nota. */
    private String rut;

    /** Código del curso asociado (NRC o identificador). */
    private String codigoCurso;

    /** Calificación numérica obtenida por el estudiante. */
    private double nota;

    /** Estado del curso: Aprobada, Reprobada o Cursando. */
    private String estado;

    /** Periodo académico en formato "AÑO-SEMESTRE" (ej: "2022-1"). */
    private String periodo;

    /**
     * Crea una nueva nota asociada a un estudiante y curso específicos.
     *
     * @param rut          RUT del estudiante.
     * @param codigoCurso  Código del curso evaluado.
     * @param nota         Calificación obtenida.
     * @param estado       Estado del curso (Aprobada, Reprobada, Cursando).
     * @param periodo      Periodo académico de la evaluación.
     */
    public Nota(String rut, String codigoCurso, double nota, String estado, String periodo) {
        this.rut = rut;
        this.codigoCurso = codigoCurso;
        this.nota = nota;
        this.estado = estado;
        this.periodo = periodo;
    }

    /** @return RUT del estudiante. */
    public String getRut() { return rut; }

    /** @return Código del curso asociado. */
    public String getCodigoCurso() { return codigoCurso; }

    /** @return Calificación obtenida. */
    public double getNota() { return nota; }

    /** @return Estado del curso. */
    public String getEstado() { return estado; }

    /** @return Periodo académico. */
    public String getPeriodo() { return periodo; }

    /**
     * Representación en texto de la nota.
     *
     * @return Cadena con información resumida de la evaluación.
     */
    @Override
    public String toString() {
        return rut + " - " + codigoCurso +
                " - Nota: " + nota +
                " - " + estado +
                " (" + periodo + ")";
    }
}