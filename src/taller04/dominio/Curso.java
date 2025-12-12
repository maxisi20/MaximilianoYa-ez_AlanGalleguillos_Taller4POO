package taller04.dominio;

import java.util.List;

/**
 * Representa un curso dentro del sistema académico.
 * <p>
 * Cada curso posee un NRC único, un nombre, semestre recomendado,
 * cantidad de créditos, área académica y una lista de prerrequisitos.
 * Los cursos pueden formar parte de líneas de certificación.
 * </p>
 */
public class Curso {

    /** Código único del curso (NRC). */
    private String nrc;

    /** Nombre oficial del curso. */
    private String nombre;

    /** Semestre recomendado en el que se dicta. */
    private int semestre;

    /** Cantidad de créditos del curso. */
    private int creditos;

    /** Área académica asociada al curso. */
    private String area;

    /** Lista de prerrequisitos (NRC o códigos de otros cursos). */
    private List<String> prerrequisitos;

    /**
     * Crea un nuevo curso con sus datos asociados.
     *
     * @param nrc            Código NRC del curso.
     * @param nombre         Nombre del curso.
     * @param semestre       Semestre recomendado.
     * @param creditos       Créditos del curso.
     * @param area           Área del curso.
     * @param prerrequisitos Lista de prerrequisitos.
     */
    public Curso(String nrc, String nombre, int semestre, int creditos, String area, List<String> prerrequisitos) {
        this.nrc = nrc;
        this.nombre = nombre;
        this.semestre = semestre;
        this. creditos = creditos;
        this.area = area;
        this.prerrequisitos = prerrequisitos;
    }

    /** @return NRC del curso. */
    public String getNrc() {
        return nrc;
    }

    /** @param nrc Nuevo NRC del curso. */
    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    /** @return Nombre del curso. */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre Nuevo nombre del curso. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return Semestre recomendado. */
    public int getSemestre() {
        return semestre;
    }

    /** @param semestre Nuevo semestre recomendado. */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /** @return Créditos del curso. */
    public int getCreditos() {
        return creditos;
    }

    /** @param creditos Nueva cantidad de créditos. */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /** @return Área del curso. */
    public String getArea() {
        return area;
    }

    /** @param area Nueva área del curso. */
    public void setArea(String area) {
        this.area = area;
    }

    /** @return Lista de prerrequisitos del curso. */
    public List<String> getPrerrequisitos() {
        return prerrequisitos;
    }

    /** @param prerrequisitos Nuevos prerrequisitos del curso. */
    public void setPrerrequisitos(List<String> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

    /**
     * Representación en cadena del curso.
     *
     * @return Cadena con los datos del curso.
     */
    @Override
    public String toString() {
        return "Curso{" +
                "nrc='" + nrc + '\'' +
                ", nombre='" + nombre + '\'' +
                ", semestre=" + semestre +
                ", creditos=" + creditos +
                ", area='" + area + '\'' +
                ", prerrequisitos=" + prerrequisitos +
                '}';
    }
}