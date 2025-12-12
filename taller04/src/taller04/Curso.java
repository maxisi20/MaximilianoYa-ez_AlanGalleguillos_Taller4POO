package taller04;

import java.util.List;

public class Curso {

    private String nrc;
    private String nombre;
    private int semestre;
    private int creditos;
    private String area;
    private List<String> prerrequisitos;

    public Curso(String nrc, String nombre, int semestre, int creditos, String area, List<String> prerrequisitos) {
        this.nrc = nrc;
        this.nombre = nombre;
        this.semestre = semestre;
        this.creditos = creditos;
        this.area = area;
        this.prerrequisitos = prerrequisitos;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<String> getPrerrequisitos() {
        return prerrequisitos;
    }

    public void setPrerrequisitos(List<String> prerrequisitos) {
        this.prerrequisitos = prerrequisitos;
    }

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