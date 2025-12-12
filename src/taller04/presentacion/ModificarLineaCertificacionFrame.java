package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.logica.Sistema;
import taller04.dominio.Certificacion;

public class ModificarLineaCertificacionFrame extends JFrame {

    private Sistema sistema;

    public ModificarLineaCertificacionFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Modificar Línea de Certificación");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2, 10, 10));

        JComboBox<String> comboCert = new JComboBox<>();
        for (Certificacion c : sistema.getCertificaciones()) {
            comboCert.addItem(c.getId());
        }

        JTextField txtNombre = new JTextField();
        JTextField txtDesc = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnSalir = new JButton("Cerrar");

        add(new JLabel("Seleccionar Certificación:"));
        add(comboCert);
        add(new JLabel("Nuevo Nombre:"));
        add(txtNombre);
        add(new JLabel("Nueva Descripción:"));
        add(txtDesc);
        add(btnGuardar);
        add(btnSalir);

        btnGuardar.addActionListener(e -> {
            String id = comboCert.getSelectedItem().toString();
            Certificacion c = sistema.buscarCertificacion(id);

            if (c != null) {
                if (!txtNombre.getText().isEmpty()) c.setNombre(txtNombre.getText());
                if (!txtDesc.getText().isEmpty()) c.setDescripcion(txtDesc.getText());
                JOptionPane.showMessageDialog(this, "Certificación modificada.");
            }
        });

        btnSalir.addActionListener(e -> dispose());

        setVisible(true);
    }
}