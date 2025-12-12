package taller04;

public class Nota {

    private String rut;
    private String nrc;         // código de la asignatura
    private double calificacion;
    private String estado;      // Aprobada, Reprobada, Cursando
    private int semestre;

    public Nota(String rut, String nrc, double calificacion, String estado, int semestre) {
        this.rut = rut;
        this.nrc = nrc;
        this.calificacion = calificacion;
        this.estado = estado;
        this.semestre = semestre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "Nota{" +
                "rut='" + rut + '\'' +
                ", nrc='" + nrc + '\'' +
                ", calificacion=" + calificacion +
                ", estado='" + estado + '\'' +
                ", semestre=" + semestre +
                '}';
    }
}