package taller04;

public class Coordinador extends Usuario {

    private String area;

    public Coordinador(String nombreUsuario, String contraseña, String area) {
        super(nombreUsuario, contraseña, "COORDINADOR");
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Coordinador{" +
                "usuario='" + nombreUsuario + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}