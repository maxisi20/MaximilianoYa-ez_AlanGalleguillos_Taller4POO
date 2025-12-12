package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import taller04.logica.Sistema;

public class MenuAdminFrame extends JFrame {

    private Sistema sistema;

    public MenuAdminFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Menú Administrador");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnCrearUsuario = new JButton("Crear Usuario");
        JButton btnModificarUsuario = new JButton("Modificar Usuario");
        JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
        JButton btnResetPassword = new JButton("Restablecer Contraseña");
        JButton btnSalir = new JButton("Salir");

        add(btnCrearUsuario);
        add(btnModificarUsuario);
        add(btnEliminarUsuario);
        add(btnResetPassword);
        add(btnSalir);

        // --- ACCIONES ---
        btnCrearUsuario.addActionListener(e -> new CrearUsuarioFrame());
        btnModificarUsuario.addActionListener(e -> new ModificarUsuarioFrame());
        btnEliminarUsuario.addActionListener(e -> new EliminarUsuarioFrame());
        btnResetPassword.addActionListener(e -> new ResetPasswordFrame());
        btnSalir.addActionListener(e -> dispose());

        setVisible(true);
    }
}