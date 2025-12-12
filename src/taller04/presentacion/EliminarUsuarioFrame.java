package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.logica.Sistema;
import taller04.dominio.Usuario;

public class EliminarUsuarioFrame extends JFrame {

    private Sistema sistema;

    public EliminarUsuarioFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Eliminar Usuario");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        JTextField txtUsuario = new JTextField();

        add(new JLabel("Usuario a eliminar:"));
        add(txtUsuario);

        JButton btnEliminar = new JButton("Eliminar");
        JButton btnCancelar = new JButton("Cancelar");

        add(btnEliminar);
        add(btnCancelar);

        btnEliminar.addActionListener(e -> {
            String nombre = txtUsuario.getText().trim();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un usuario.");
                return;
            }

            Usuario encontrado = null;
            for (Usuario u : sistema.getUsuarios()) {
                if (u.getNombreUsuario().equalsIgnoreCase(nombre)) {
                    encontrado = u;
                    break;
                }
            }

            if (encontrado == null) {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado.");
                return;
            }

            sistema.getUsuarios().remove(encontrado);
            JOptionPane.showMessageDialog(this, "Usuario eliminado.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        setVisible(true);
    }
}
