package taller04.dominio;

import java.util.ArrayList;
import java.util.List;

import taller04.logica.CertificacionVisitor;

/**
 * Representa una línea de certificación dentro del sistema.
 * <p>
 * Cada certificación contiene información general (nombre, descripción,
 * créditos requeridos, validez en años) y una lista de cursos asociados
 * que deben cumplirse para completarla.
 * </p>
 * 
 * <p>
 * Además, implementa el patrón de diseño <b>Visitor</b> mediante el método
 * {@link #accept(CertificacionVisitor)}, permitiendo aplicar diferentes
 * operaciones sobre instancias de certificación sin modificar su clase.
 * </p>
 */
public class Certificacion {

    /** Identificador único de la certificación. */
    private String id;

    /** Nombre de la certificación. */
    private String nombre;

    /** Descripción general de la certificación. */
    private String descripcion;

    /** Créditos totales requeridos para completarla. */
    private int creditosRequeridos;

    /** Cantidad de años durante los cuales la certificación es válida. */
    private int validezAnios;

    /** Lista de cursos asociados necesarios para completar la certificación. */
    private List<Curso> cursosAsociados;

    /**
     * Construye una nueva certificación con sus atributos principales.
     *
     * @param id Identificador único.
     * @param nombre Nombre de la certificación.
     * @param descripcion Descripción general.
     * @param creditosRequeridos Créditos necesarios para completarla.
     * @param validezAnios Años de validez de la certificación.
     */
    public Certificacion(String id, String nombre, String descripcion,
                         int creditosRequeridos, int validezAnios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditosRequeridos = creditosRequeridos;
        this.validezAnios = validezAnios;
        this.cursosAsociados = new ArrayList<>();
    }

    /** @return ID único de la certificación. */
    public String getId() {
        return id;
    }

    /** @param id Nuevo ID de la certificación. */
    public void setId(String id) {
        this.id = id;
    }

    /** @return Nombre de la certificación. */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre Nuevo nombre de la certificación. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return Descripción de la certificación. */
    public String getDescripcion() {
        return descripcion;
    }

    /** @param descripcion Nueva descripción de la certificación. */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /** @return Créditos requeridos. */
    public int getCreditosRequeridos() {
        return creditosRequeridos;
    }

    /** @param creditosRequeridos Nuevo total de créditos requeridos. */
    public void setCreditosRequeridos(int creditosRequeridos) {
        this.creditosRequeridos = creditosRequeridos;
    }

    /** @return Años de validez. */
    public int getValidezAnios() {
        return validezAnios;
    }

    /** @param validezAnios Nueva validez en años. */
    public void setValidezAnios(int validezAnios) {
        this.validezAnios = validezAnios;
    }

    /** @return Lista de cursos asociados a la certificación. */
    public List<Curso> getCursosAsociados() {
        return cursosAsociados;
    }

    /**
     * Agrega un curso a la certificación.
     *
     * @param curso Curso a asociar.
     */
    public void agregarCurso(Curso curso) {
        cursosAsociados.add(curso);
    }

    /**
     * Acepta un visitante externo para aplicar operaciones mediante el patrón Visitor.
     *
     * @param visitor Implementación de CertificacionVisitor que define la operación a realizar.
     */
    public void accept(CertificacionVisitor visitor) {
        visitor.visit(this);
    }

    /**
     * Representación textual de la certificación.
     *
     * @return Cadena con información resumida de la certificación.
     */
    @Override
    public String toString() {
        return "Certificacion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", creditosRequeridos=" + creditosRequeridos +
                ", validezAnios=" + validezAnios +
                ", cursosAsociados=" + cursosAsociados.size() +
                '}';
    }
}