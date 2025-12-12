package taller04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws FileNotFoundException {

	    File asignaturasFile = new File("asignaturas_certificaciones.txt");
	    File certificacionesFile = new File("certificaciones.txt");
	    File cursosFile = new File("estudiantes.txt");
	    File notasFile = new File("notas.txt");
	    File registrosFile = new File("registros.txt");
	    File usuariossFile = new File("usuarios.txt");

	    Scanner asignaturasLector = new Scanner(asignaturasFile);
	    Scanner certificacionesLector = new Scanner(certificacionesFile);
	    Scanner cursosLector = new Scanner(cursosFile);
	    Scanner notasLector = new Scanner(notasFile);
	    Scanner registrosLector = new Scanner(registrosFile);
	    Scanner usuariosLector = new Scanner(usuariossFile);

	}
}