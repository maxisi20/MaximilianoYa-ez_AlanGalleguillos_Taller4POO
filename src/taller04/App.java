/**
 * Nombre: Maximiliano Hernan Yañez Castillo  
 * RUT: 21.668.966-6  
 * Carrera: ITI
 */

package taller04;

import java.io.File;
import javax.swing.SwingUtilities;

import taller04.logica.Sistema;
import taller04.presentacion.LoginFrame;

/**
 * Clase principal del sistema.
 * <p>
 * Esta clase se encarga de inicializar la aplicación, cargar todos los
 * archivos necesarios y finalmente lanzar la interfaz gráfica de inicio de sesión.
 * Implementa la arquitectura de presentación, actuando como punto de entrada
 * para el sistema completo.
 * </p>
 */
public class App {

    /**
     * Método principal que inicia la ejecución del programa.
     * <p>
     * Se encarga de:
     * <ul>
     *   <li>Instanciar el sistema (patrón Singleton)</li>
     *   <li>Cargar los archivos de asignaturas, certificaciones, estudiantes,
     *       notas, registros y usuarios</li>
     *   <li>Inicializar la ventana de inicio de sesión</li>
     * </ul>
     * </p>
     *
     * @param args Argumentos de línea de comando (no utilizados).
     */
    public static void main(String[] args) {

        Sistema sistema = Sistema.getInstancia();

        sistema.cargarAsignaturasCertificacion(new File("asignaturas_certificaciones.txt"));
        sistema.cargarCertificaciones(new File("certificaciones.txt"));
        sistema.cargarEstudiantes(new File("estudiantes.txt"));
        sistema.cargarNotas(new File("notas.txt"));
        sistema.cargarRegistros(new File("registros.txt"));
        sistema.cargarUsuarios(new File("usuarios.txt"));

        System.out.println("Archivos cargados correctamente.");

        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }
}