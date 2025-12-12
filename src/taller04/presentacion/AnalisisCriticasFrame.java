package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import taller04.logica.Sistema;
import taller04.dominio.Nota;

public class AnalisisCriticasFrame extends JFrame {

    public AnalisisCriticasFrame() {
        Sistema sistema = Sistema.getInstancia();

        setTitle("Análisis de Asignaturas Críticas");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        HashMap<String, Integer> reprobados = new HashMap<>();

        for (Nota n : sistema.getNotas()) {
            if (n.getEstado().equalsIgnoreCase("reprobado")) {
                reprobados.put(n.getNota(),
                    reprobados.getOrDefault(n.getNota(), 0) + 1);
            }
        }

        JTextArea area = new JTextArea();
        area.append("Asignaturas más críticas (más reprobadas):\n\n");

        reprobados.forEach((nrc, cant) ->
                area.append("NRC " + nrc + " → " + cant + " reprobados\n")
        );

        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);
        setVisible(true);
    }
}
