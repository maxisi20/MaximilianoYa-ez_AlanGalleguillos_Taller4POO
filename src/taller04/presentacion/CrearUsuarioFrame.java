package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.dominio.Administrador;
import taller04.dominio.Coordinador;
import taller04.dominio.Estudiante;
import taller04.logica.Sistema;

public class CrearUsuarioFrame extends JFrame {

    private Sistema sistema;

    public CrearUsuarioFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Crear Nuevo Usuario");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        JTextField txtUsuario = new JTextField();
        JTextField txtPass = new JTextField();
        String[] roles = {"ADMIN", "COORDINADOR", "ESTUDIANTE"};
        JComboBox<String> comboRol = new JComboBox<>(roles);

        add(new JLabel("Nombre Usuario:"));
        add(txtUsuario);

        add(new JLabel("Contraseña:"));
        add(txtPass);

        add(new JLabel("Rol:"));
        add(comboRol);

        JButton btnCrear = new JButton("Crear");
        JButton btnCancelar = new JButton("Cancelar");

        add(btnCrear);
        add(btnCancelar);

        // -------- Acción del botón CREAR ----------
        btnCrear.addActionListener(e -> {

            String user = txtUsuario.getText().trim();
            String pass = txtPass.getText().trim();
            String rol = comboRol.getSelectedItem().toString();

            if (user.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            switch (rol) {

            case "ADMIN":
                sistema.getUsuarios().add(new Administrador(user, pass));
                break;

            case "COORDINADOR":
                sistema.getUsuarios().add(new Coordinador(user, pass, "General"));
                break;

            case "ESTUDIANTE":
                // Crear estudiante básico
                Estudiante nuevo = new Estudiante(
                    user,      // nombreUsuario
                    pass,      // contraseña
                    user,      // rut (temporal hasta que lo pidas)
                    user,      // nombre
                    "Sin Carrera",
                    1,         // semestre
                    user + "@correo.cl"
                );

                sistema.getEstudiantes().add(nuevo);
                sistema.getUsuarios().add(nuevo);
                break;
        }
            

            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente.");
            dispose();
        });

        btnCancelar.addActionListener(e -> dispose());

        setVisible(true);
    }
}