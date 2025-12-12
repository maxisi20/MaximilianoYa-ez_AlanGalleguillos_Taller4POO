package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import taller04.logica.Sistema;
import taller04.dominio.RegistroCertificacion;

public class EstadisticasInscripcionesFrame extends JFrame {

    public EstadisticasInscripcionesFrame() {
        Sistema sistema = Sistema.getInstancia();

        setTitle("Estadísticas de Inscripciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        HashMap<String, Integer> conteo = new HashMap<>();

        for (RegistroCertificacion r : sistema.getRegistros()) {
            conteo.put(r.getIdCertificacion(),
                       conteo.getOrDefault(r.getIdCertificacion(), 0) + 1);
        }

        JTextArea area = new JTextArea();
        StringBuilder sb = new StringBuilder();

        conteo.forEach((id, cant) ->
                sb.append(id).append(": ").append(cant).append(" inscripciones\n")
        );

        area.setText(sb.toString());
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);

        setVisible(true);
    }
}