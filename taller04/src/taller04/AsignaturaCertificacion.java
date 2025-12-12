package taller04;

public class AsignaturaCertificacion {

    private String idCertificacion; // ID de la certificación
    private String nrc;             // Código único del curso

    public AsignaturaCertificacion(String idCertificacion, String nrc) {
        this.idCertificacion = idCertificacion;
        this.nrc = nrc;
    }

    public String getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(String idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    @Override
    public String toString() {
        return "AsignaturaCertificacion{" +
                "idCertificacion='" + idCertificacion + '\'' +
                ", nrc='" + nrc + '\'' +
                '}';
    }
}