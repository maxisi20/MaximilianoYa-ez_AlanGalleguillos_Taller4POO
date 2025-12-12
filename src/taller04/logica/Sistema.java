package taller04.logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import taller04.dominio.Administrador;
import taller04.dominio.AsignaturaCertificacion;
import taller04.dominio.Certificacion;
import taller04.dominio.Coordinador;
import taller04.dominio.Curso;
import taller04.dominio.Estudiante;
import taller04.dominio.Nota;
import taller04.dominio.RegistroCertificacion;
import taller04.dominio.Usuario;

/**
 * Sistema central del Taller 4 POO.
 * Contiene la lógica principal: carga de archivos, autenticación y menús por rol.
 * Implementa Singleton y mantiene las colecciones principales del dominio.
 *
 * NOTA: Los archivos esperados usan ';' como separador:
 *  - usuarios.txt: usuario;contraseña;rol[;area]
 *  - estudiantes.txt: rut;nombre;carrera;semestre;correo;contraseña
 *  - cursos.txt: nrc;nombre;semestre;creditos;area;prerrequisitosCommaSeparated
 *  - certificaciones.txt: id;nombre;descripcion;creditosRequeridos;validezAnios
 *  - asignaturas_certificaciones.txt: idCertificacion;nrc
 *  - notas.txt: rut;nrc;calificacion;estado;periodo   (periodo = "2022-1")
 *  - registros.txt: rut;idCertificacion;fechaRegistro;estado;progreso
 *
 * @author
 * @version 1.0
 */
public class Sistema {

    // ---------------- SINGLETON ----------------
    private static Sistema instancia = null;

    public static Sistema getInstancia() {
        if (instancia == null) instancia = new Sistema();
        return instancia;
    }

    // ---------------- LISTAS PRINCIPALES ----------------
    private ArrayList<Usuario> usuarios;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private ArrayList<Certificacion> certificaciones;
    private ArrayList<AsignaturaCertificacion> asignaturasCertificacion;
    private ArrayList<Nota> notas;
    private ArrayList<RegistroCertificacion> registros;

    // Scanner para menús
    private Scanner sc;

    // Constructor privado
    private Sistema() {
        usuarios = new ArrayList<>();
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        certificaciones = new ArrayList<>();
        asignaturasCertificacion = new ArrayList<>();
        notas = new ArrayList<>();
        registros = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    // ========================================================================
    // =================== MÉTODOS DE CARGA (ARCHIVOS) =========================
    // ========================================================================

    public void cargarUsuarios(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            usuarios.clear();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 3) continue;
                String nombreUsuario = p[0].trim();
                String contrasena = p[1].trim();
                String rol = p[2].trim().toUpperCase();
                if (rol.equals("ADMIN") || rol.equals("ADMINISTRADOR")) {
                    usuarios.add(new Administrador(nombreUsuario, contrasena));
                } else if (rol.equals("COORDINADOR")) {
                    String area = (p.length >= 4) ? p[3].trim() : "";
                    usuarios.add(new Coordinador(nombreUsuario, contrasena, area));
                } else if (rol.equals("ESTUDIANTE")) {
                    // si hay línea de estudiante en este archivo (opcional)
                    // no creamos Estudiante desde aquí porque los estudiantes se cargan desde estudiantes.txt
                    usuarios.add(new UsuarioProxy(nombreUsuario, contrasena, "ESTUDIANTE"));
                } else {
                    // Rol desconocido, crear usuario genérico (opcional)
                    usuarios.add(new UsuarioProxy(nombreUsuario, contrasena, rol));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando usuarios: " + e.getMessage());
        }
    }

    public void cargarEstudiantes(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            estudiantes.clear();
            for (Usuario u : new ArrayList<>(usuarios)) {
                // opcional: no remover usuarios aquí
            }
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 6) continue;
                String rut = p[0].trim();
                String nombre = p[1].trim();
                String carrera = p[2].trim();
                int semestre = 0;
                try { semestre = Integer.parseInt(p[3].trim()); } catch(Exception ex) { semestre = 0; }
                String correo = p[4].trim();
                String contrasena = p[5].trim();

                Estudiante est = new Estudiante(nombre, contrasena, rut, nombre, carrera, semestre, correo);
                estudiantes.add(est);
                // también mantener en usuarios si no existe
                if (!existeUsuario(nombre)) {
                    usuarios.add(est);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando estudiantes: " + e.getMessage());
        }
    }

    public void cargarCursos(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            cursos.clear();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 6) continue;
                String nrc = p[0].trim();
                String nombre = p[1].trim();
                int semestre = 0;
                try { semestre = Integer.parseInt(p[2].trim()); } catch(Exception ex) { semestre = 0; }
                int creditos = 0;
                try { creditos = Integer.parseInt(p[3].trim()); } catch(Exception ex) { creditos = 0; }
                String area = p[4].trim();
                String prer = p[5].trim();
                List<String> prereq = new ArrayList<>();
                if (!prer.isEmpty()) {
                    String[] parts = prer.split(",");
                    for (String s : parts) prereq.add(s.trim());
                }
                cursos.add(new Curso(nrc, nombre, semestre, creditos, area, prereq));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando cursos: " + e.getMessage());
        }
    }

    public void cargarCertificaciones(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            certificaciones.clear();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 5) continue;
                String id = p[0].trim();
                String nombre = p[1].trim();
                String descripcion = p[2].trim();
                int creditosRequeridos = 0;
                try { creditosRequeridos = Integer.parseInt(p[3].trim()); } catch(Exception ex) {}
                int validez = 0;
                try { validez = Integer.parseInt(p[4].trim()); } catch(Exception ex) {}
                certificaciones.add(new Certificacion(id, nombre, descripcion, creditosRequeridos, validez));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando certificaciones: " + e.getMessage());
        }
    }

    public void cargarAsignaturasCertificacion(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            asignaturasCertificacion.clear();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 2) continue;
                String idCert = p[0].trim();
                String nrc = p[1].trim();
                asignaturasCertificacion.add(new AsignaturaCertificacion(idCert, nrc));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando asignaturas-certificación: " + e.getMessage());
        }
    }

    public void cargarNotas(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            notas.clear();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 5) continue;
                String rut = p[0].trim();
                String nrc = p[1].trim();
                double cal = 0.0;
                try { cal = Double.parseDouble(p[2].trim()); } catch(Exception ex) {}
                String estado = p[3].trim();
                String periodo = p[4].trim();
                notas.add(new Nota(rut, nrc, cal, estado, periodo));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando notas: " + e.getMessage());
        }
    }

    public void cargarRegistros(File archivo) {
        if (archivo == null || !archivo.exists()) return;
        try (Scanner lector = new Scanner(archivo)) {
            registros.clear();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine().trim();
                if (linea.isEmpty()) continue;
                String[] p = linea.split(";");
                if (p.length < 5) continue;
                String rut = p[0].trim();
                String idCert = p[1].trim();
                String fecha = p[2].trim();
                String estado = p[3].trim();
                int progreso = 0;
                try { progreso = Integer.parseInt(p[4].trim()); } catch(Exception ex) {}
                registros.add(new RegistroCertificacion(rut, idCert, fecha, estado, progreso));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error cargando registros: " + e.getMessage());
        }
    }

    // ========================================================================
    // ======================= MÉTODOS DE AUTENTICACIÓN =======================
    // ========================================================================

    /**
     * Busca un usuario por nombre y contraseña.
     * @return Usuario si coincide, null si no.
     */
    public Usuario login(String nombreUsuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getContraseña().equals(contraseña)) {
                return u;
            }
        }
        return null;
    }

    private boolean existeUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) return true;
        }
        return false;
    }

    // ========================================================================
    // ========================= MENÚ PRINCIPAL ================================
    // ========================================================================

    /**
     * Menú principal: autentica y deriva a menús por rol.
     */
    public void menuPrincipal() {
        while (true) {
            System.out.println("\n=== INICIO DE SESIÓN ===");
            System.out.print("Usuario (o 'salir'): ");
            String user = sc.nextLine().trim();
            if (user.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo del sistema.");
                return;
            }
            System.out.print("Contraseña: ");
            String pass = sc.nextLine().trim();

            Usuario usuario = login(user, pass);
            if (usuario == null) {
                System.out.println("Credenciales incorrectas.");
                continue;
            }

            System.out.println("\nBienvenido " + usuario.getNombreUsuario() + " (" + usuario.getRol() + ")");

            String rol = usuario.getRol().toUpperCase();
            switch (rol) {
                case "ADMIN":
                case "ADMINISTRADOR":
                    menuAdmin((Administrador) usuario);
                    break;
                case "COORDINADOR":
                    menuCoordinador((Coordinador) usuario);
                    break;
                case "ESTUDIANTE":
                    menuEstudiante((Estudiante) usuario);
                    break;
                default:
                    System.out.println("Rol no reconocido: " + rol);
            }
        }
    }

    // ========================================================================
    // ========================= MENÚ ADMINISTRADOR ============================
    // ========================================================================

    private void menuAdmin(Administrador admin) {
        while (true) {
            System.out.println("\n=== MENÚ ADMINISTRADOR ===");
            System.out.println("1. Listar todos los usuarios");
            System.out.println("2. Listar cursos");
            System.out.println("3. Listar certificaciones");
            System.out.println("4. Listar estudiantes");
            System.out.println("5. Guardar cambios (opcional)");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione: ");
            String opt = sc.nextLine().trim();

            switch (opt) {
                case "1":
                    System.out.println("\n-- USUARIOS --");
                    for (Usuario u : usuarios) System.out.println(u);
                    break;
                case "2":
                    System.out.println("\n-- CURSOS --");
                    for (Curso c : cursos) System.out.println(c);
                    break;
                case "3":
                    System.out.println("\n-- CERTIFICACIONES --");
                    for (Certificacion c : certificaciones) System.out.println(c);
                    break;
                case "4":
                    System.out.println("\n-- ESTUDIANTES --");
                    for (Estudiante e : estudiantes) System.out.println(e);
                    break;
                case "5":
                    guardarArchivosBasicos();
                    System.out.println("Guardado (siempre opcional en esta implementación).");
                    break;
                case "0":
                    System.out.println("Cerrando sesión administrador.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ========================================================================
    // ======================== MENÚ COORDINADOR ===============================
    // ========================================================================

    private void menuCoordinador(Coordinador coord) {
        while (true) {
            System.out.println("\n=== MENÚ COORDINADOR ===");
            System.out.println("1. Buscar estudiante por RUT");
            System.out.println("2. Listar certificaciones");
            System.out.println("3. Listar cursos");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione: ");
            String opt = sc.nextLine().trim();

            switch (opt) {
                case "1":
                    System.out.print("RUT: ");
                    String rut = sc.nextLine().trim();
                    Estudiante e = buscarEstudiante(rut);
                    System.out.println((e != null) ? e : "Estudiante no encontrado.");
                    break;
                case "2":
                    System.out.println("\n-- CERTIFICACIONES --");
                    for (Certificacion c : certificaciones) System.out.println(c);
                    break;
                case "3":
                    System.out.println("\n-- CURSOS --");
                    for (Curso c : cursos) System.out.println(c);
                    break;
                case "0":
                    System.out.println("Cerrando sesión coordinador.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ========================================================================
    // ======================== MENÚ ESTUDIANTE =================================
    // ========================================================================

    private void menuEstudiante(Estudiante est) {
        while (true) {
            System.out.println("\n=== MENÚ ESTUDIANTE ===");
            System.out.println("1. Ver mis datos");
            System.out.println("2. Ver mis notas");
            System.out.println("3. Ver mis registros de certificación");
            System.out.println("0. Cerrar sesión");
            System.out.print("Seleccione: ");
            String opt = sc.nextLine().trim();

            switch (opt) {
                case "1":
                    System.out.println(est);
                    break;
                case "2":
                    System.out.println("\n-- MIS NOTAS --");
                    for (Nota n : notas) {
                        if (n.getRut().equals(est.getRut())) System.out.println(n);
                    }
                    break;
                case "3":
                    System.out.println("\n-- MIS REGISTROS --");
                    for (RegistroCertificacion r : registros) {
                        if (r.getRut().equals(est.getRut())) System.out.println(r);
                    }
                    break;
                case "0":
                    System.out.println("Cerrando sesión estudiante.");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    // ========================================================================
    // ======================== MÉTODOS AUXILIARES =============================
    // ========================================================================

    public Estudiante buscarEstudiante(String rut) {
        for (Estudiante e : estudiantes) {
            if (e.getRut().equalsIgnoreCase(rut)) return e;
        }
        return null;
    }

    public Certificacion buscarCertificacion(String id) {
        for (Certificacion c : certificaciones) {
            if (c.getId().equalsIgnoreCase(id)) return c;
        }
        return null;
    }

    public Curso buscarCurso(String nrc) {
        for (Curso c : cursos) {
            if (c.getNrc().equalsIgnoreCase(nrc)) return c;
        }
        return null;
    }

    // ========================================================================
    // =================== GUARDADO SIMPLE (OPCIONAL) ==========================
    // ========================================================================

    /**
     * Guarda algunos archivos básicos (ejemplo sencillo).
     * Ajusta según necesites persistir más datos.
     */
    private void guardarArchivosBasicos() {
        // Ejemplo: guardar usuarios en usuarios_out.txt (no sobrescribe original por seguridad)
        try (PrintWriter pw = new PrintWriter(new FileWriter("usuarios_out.txt"))) {
            for (Usuario u : usuarios) {
                pw.println(u.getNombreUsuario() + ";" + u.getContraseña() + ";" + u.getRol());
            }
        } catch (IOException e) {
            System.out.println("Error guardando usuarios: " + e.getMessage());
        }

        // Nota: puedes implementar guardado para estudiantes, notas, etc.
    }

    // ========================================================================
    // =================== GETTERS (si necesitas acceso externo) ==============
    // ========================================================================
    public ArrayList<Usuario> getUsuarios() { return usuarios; }
    public ArrayList<Estudiante> getEstudiantes() { return estudiantes; }
    public ArrayList<Curso> getCursos() { return cursos; }
    public ArrayList<Certificacion> getCertificaciones() { return certificaciones; }
    public ArrayList<AsignaturaCertificacion> getAsignaturasCertificacion() { return asignaturasCertificacion; }
    public ArrayList<Nota> getNotas() { return notas; }
    public ArrayList<RegistroCertificacion> getRegistros() { return registros; }

    // ========================================================================
    // =================== CLASE AUXILIAR USUARIO PROXY (OPCIONAL) ============
    // ========================================================================
    /**
     * Clase ligera para representar usuarios no estudiante que provienen de users.txt
     * Si prefieres, puedes eliminarla y usar solo Administrador/Coordinador/Estudiante.
     */
    private static class UsuarioProxy extends Usuario {
        public UsuarioProxy(String nombreUsuario, String contraseña, String rol) {
            super(nombreUsuario, contraseña, rol);
        }
    }
}