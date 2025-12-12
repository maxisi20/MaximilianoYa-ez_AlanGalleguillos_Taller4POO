package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.logica.Sistema;
import taller04.dominio.Coordinador;

public class MenuCoordinadorFrame extends JFrame {

    private Sistema sistema;

    public MenuCoordinadorFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Menú Coordinador");
        setSize(420, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(8, 1, 10, 10));

        JButton btnModificarLinea = new JButton("Modificar Línea de Certificación");
        JButton btnGenerarCertificados = new JButton("Generar Certificados Completados");

        JButton btnEstadisticasInscripciones = new JButton("Estadísticas de Inscripciones");
        JButton btnAnalisisCriticas = new JButton("Análisis de Asignaturas Críticas");

        JButton btnPerfilEstudiante = new JButton("Consultar Perfil Completo de Estudiante");
        JButton btnValidarAvances = new JButton("Revisar y Validar Avances Académicos");

        JButton btnSalir = new JButton("Salir");

        add(btnModificarLinea);
        add(btnGenerarCertificados);
        add(btnEstadisticasInscripciones);
        add(btnAnalisisCriticas);
        add(btnPerfilEstudiante);
        add(btnValidarAvances);
        add(btnSalir);

        // ACCIONES
        btnModificarLinea.addActionListener(e -> new ModificarLineaCertificacionFrame());
        btnGenerarCertificados.addActionListener(e -> new GenerarCertificadosFrame());

        btnEstadisticasInscripciones.addActionListener(e -> new EstadisticasInscripcionesFrame());
        btnAnalisisCriticas.addActionListener(e -> new AnalisisCriticasFrame());

        btnPerfilEstudiante.addActionListener(e -> new PerfilEstudianteFrame());
        btnValidarAvances.addActionListener(e -> new ValidarAvancesFrame());

        btnSalir.addActionListener(e -> dispose());

        setVisible(true);
    }
}