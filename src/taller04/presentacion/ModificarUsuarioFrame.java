package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.logica.Sistema;
import taller04.dominio.Usuario;
import taller04.dominio.Coordinador;
import taller04.dominio.Administrador;

public class ModificarUsuarioFrame extends JFrame {

    private Sistema sistema;

    public ModificarUsuarioFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Modificar Usuario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        JTextField txtUsuario = new JTextField();
        JTextField txtNuevaPass = new JTextField();
        String[] roles = {"ADMIN", "COORDINADOR", "ESTUDIANTE"};
        JComboBox<String> comboRol = new JComboBox<>(roles);

        add(new JLabel("Usuario a modificar:"));
        add(txtUsuario);

        add(new JLabel("Nueva contraseña:"));
        add(txtNuevaPass);

        add(new JLabel("Nuevo rol:"));
        add(comboRol);

        JButton btnModificar = new JButton("Modificar");
        JButton btnCancelar = new JButton("Cancelar");

        add(btnModificar);
        add(btnCancelar);

        btnModificar.addActionListener(e -> {
            String nombre = txtUsuario.getText().trim();
            String nuevaPass = txtNuevaPass.getText().trim();
            String nuevoRol = comboRol.getSelectedItem().toString();

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

            // Cambiar contraseña
            if (!nuevaPass.isEmpty()) {
                encontrado.setContraseña(nuevaPass);
            }

            // Cambiar rol
            switch (nuevoRol) {
                case "ADMIN":
                    sistema.getUsuarios().remove(encontrado);
                    sistema.getUsuarios().add(new Administrador(nombre, nuevaPass));
                    break;
                case "COORDINADOR":
                    sistema.getUsuarios().remove(encontrado);
                    sistema.getUsuarios().add(new Coordinador(nombre, nuevaPass, "General"));
                    break;
                case "ESTUDIANTE":
                    JOptionPane.showMessageDialog(this, "Los estudiantes se modifican desde estudiantes.txt");
                    return;
            }

            JOptionPane.showMessageDialog(this, "Usuario modificado.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        setVisible(true);
    }
}