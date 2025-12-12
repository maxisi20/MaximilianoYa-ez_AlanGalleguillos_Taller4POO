package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import taller04.logica.Sistema;
import taller04.dominio.RegistroCertificacion;

public class GenerarCertificadosFrame extends JFrame {

    private Sistema sistema;

    public GenerarCertificadosFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Generar Certificados");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        ArrayList<RegistroCertificacion> registros = sistema.getRegistros();
        StringBuilder sb = new StringBuilder();

        for (RegistroCertificacion r : registros) {
            if (r.getProgreso() >= 100) {
                sb.append("Estudiante ").append(r.getRut())
                  .append(" completó certificación ")
                  .append(r.getIdCertificacion())
                  .append("\n");
            }
        }

        if (sb.length() == 0)
            sb.append("No hay estudiantes con certificación completada.");

        area.setText(sb.toString());

        add(new JScrollPane(area), BorderLayout.CENTER);

        setVisible(true);
    }
}