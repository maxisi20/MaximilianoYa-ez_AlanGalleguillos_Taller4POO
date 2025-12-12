package taller04;

public class RegistroCertificacion {

    private String rut;
    private String idCertificacion;
    private String fechaRegistro;
    private String estado;        // Activa, Completada, Suspendida
    private int progreso;         // porcentaje (0–100)

    public RegistroCertificacion(String rut, String idCertificacion,
                                 String fechaRegistro, String estado, int progreso) {
        this.rut = rut;
        this.idCertificacion = idCertificacion;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
        this.progreso = progreso;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(String idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }

    @Override
    public String toString() {
        return "RegistroCertificacion{" +
                "rut='" + rut + '\'' +
                ", idCertificacion='" + idCertificacion + '\'' +
                ", estado='" + estado + '\'' +
                ", progreso=" + progreso +
                '}';
    }
}