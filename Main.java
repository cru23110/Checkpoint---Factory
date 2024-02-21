import db.ArchivoCSV;
import Factories.*;
import Users.AuditorExterno;
import Users.Docente;
import Users.Estudiante;
import Users.PersonalAdministrativo;
import Users.Usuario;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema universitario");

        // Autenticación
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        // Verificación del usuario
        Factory factory = new EstudianteFactory(); // O cualquier otra Factory correspondiente
        Usuario usuarioLogueado = factory.autenticar(usuario, contraseña);


        if (usuarioLogueado == null) {
            System.out.println("Usuario o contraseña incorrectos. Saliendo del programa...");
            return;
        }

        System.out.println("Bienvenido, " + usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido());

        // Menú de opciones según el tipo de usuario
        if (usuarioLogueado instanceof Estudiante) {
            menuEstudiante();
        } else if (usuarioLogueado instanceof Docente) {
            menuDocente();
        } else if (usuarioLogueado instanceof PersonalAdministrativo) {
            menuPersonalAdministrativo();
        } else if (usuarioLogueado instanceof AuditorExterno) {
            menuAuditorExterno();
        }
    }

    private static void menuEstudiante() {
        System.out.println("Bienvenido, Estudiante.");
        System.out.println("1. Consultar nota de una clase específica");
        System.out.println("2. Realizar pago");
        System.out.println("3. Consultar pagos");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void menuDocente() {
        System.out.println("Bienvenido, Docente.");
        System.out.println("1. Ingresar notas de estudiantes en una clase específica");
        System.out.println("2. Cobrar pago");
        System.out.println("3. Consultar historial de pagos");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void menuPersonalAdministrativo() {
        System.out.println("Bienvenido, Personal Administrativo.");
        System.out.println("1. Crear cursos, docentes y estudiantes");
        System.out.println("2. Asignar estudiante a curso");
        System.out.println("3. Asignar catedrático a curso");
        System.out.println("4. Asignar pago a catedrático");
        System.out.println("5. Resumen de notas y pagos de estudiantes");
        System.out.println("6. Salir");
        System.out.print("Ingrese su opción: ");
    }

    private static void menuAuditorExterno() {
        System.out.println("Bienvenido, Auditor Externo.");
        System.out.println("1. Revisar notas");
        System.out.println("2. Revisar cuotas pagadas de estudiantes");
        System.out.println("3. Revisar pagos a docentes");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
    }

}
