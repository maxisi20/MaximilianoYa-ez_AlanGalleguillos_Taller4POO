package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.logica.Sistema;
import taller04.dominio.Usuario;

public class ResetPasswordFrame extends JFrame {

    private Sistema sistema;

    public ResetPasswordFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Restablecer Contraseña");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField txtUsuario = new JTextField();
        JTextField txtNueva = new JTextField();

        add(new JLabel("Usuario:"));
        add(txtUsuario);

        add(new JLabel("Nueva contraseña:"));
        add(txtNueva);

        JButton btnCambiar = new JButton("Cambiar");
        JButton btnCancelar = new JButton("Cancelar");

        add(btnCambiar);
        add(btnCancelar);

        btnCambiar.addActionListener(e -> {
            String nombre = txtUsuario.getText().trim();
            String nuevaPass = txtNueva.getText().trim();

            if (nombre.isEmpty() || nuevaPass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
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

            encontrado.setContraseña(nuevaPass);
            JOptionPane.showMessageDialog(this, "Contraseña actualizada.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        setVisible(true);
    }
}