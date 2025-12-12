package taller04;

import java.util.ArrayList;
import java.util.List;

public class Certificacion {

    private String id;
    private String nombre;
    private String descripcion;
    private int creditosRequeridos;
    private int validezAnios;

    private List<Curso> cursosAsociados; // cursos ligados a esta certificación

    public Certificacion(String id, String nombre, String descripcion,
                         int creditosRequeridos, int validezAnios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditosRequeridos = creditosRequeridos;
        this.validezAnios = validezAnios;
        this.cursosAsociados = new ArrayList<>();
    }

    // Métodos Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCreditosRequeridos() {
        return creditosRequeridos;
    }

    public void setCreditosRequeridos(int creditosRequeridos) {
        this.creditosRequeridos = creditosRequeridos;
    }

    public int getValidezAnios() {
        return validezAnios;
    }

    public void setValidezAnios(int validezAnios) {
        this.validezAnios = validezAnios;
    }

    public List<Curso> getCursosAsociados() {
        return cursosAsociados;
    }

    public void agregarCurso(Curso curso) {
        cursosAsociados.add(curso);
    }

    // ----- VISITOR PATTERN -----
    public void accept(CertificacionVisitor visitor) {
        visitor.visit(this);
    }

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