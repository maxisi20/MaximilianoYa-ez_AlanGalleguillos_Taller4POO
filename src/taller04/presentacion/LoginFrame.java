package taller04.presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import taller04.logica.Sistema;
import taller04.dominio.Usuario;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private Sistema sistema;

    public LoginFrame() {
        sistema = Sistema.getInstancia();

        setTitle("Inicio de Sesión");
        setSize(350, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("Usuario: "));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña: "));
        txtPassword = new JPasswordField();
        add(txtPassword);

        JButton btnLogin = new JButton("Iniciar Sesión");
        add(btnLogin);

        JButton btnSalir = new JButton("Salir");
        add(btnSalir);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        btnSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void login() {
        String user = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        Usuario u = sistema.login(user, pass);

        if (u == null) {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña inválidos.");
            return;
        }

        // Abrir menú según rol
        switch (u.getRol()) {
            case "ADMIN":
                new MenuAdminFrame();
                break;
            case "COORDINADOR":
                new MenuCoordinadorFrame();
                break;
            case "ESTUDIANTE":
                new MenuEstudianteFrame(u.getNombreUsuario());
                break;
        }

        this.dispose(); // cerrar login
    }
}