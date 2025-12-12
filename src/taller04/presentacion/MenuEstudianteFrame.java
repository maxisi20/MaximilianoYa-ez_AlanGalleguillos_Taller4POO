package taller04.presentacion;

import javax.swing.*;
import java.awt.*;

public class MenuEstudianteFrame extends JFrame {

    private String usuario;

    public MenuEstudianteFrame(String usuario) {
        this.usuario = usuario;

        setTitle("Menú Estudiante - " + usuario);
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 1, 10, 10));

        JButton btnPerfil = new JButton("Ver Perfil");
        JButton btnMalla = new JButton("Malla Curricular Interactiva");
        JButton btnCertificaciones = new JButton("Inscripción a Certificaciones");
        JButton btnDashboard = new JButton("Dashboard de Progreso");
        JButton btnSalir = new JButton("Cerrar Sesión");

        panel.add(btnPerfil);
        panel.add(btnMalla);
        panel.add(btnCertificaciones);
        panel.add(btnDashboard);
        panel.add(btnSalir);

        btnSalir.addActionListener(e -> {
            new LoginFrame();
            dispose();
        });

        add(panel);
        setVisible(true);
    }
}