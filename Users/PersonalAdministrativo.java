package Users;

import db.ArchivoCSV;

import java.util.ArrayList;
import java.util.List;

import University.Curso;

public class PersonalAdministrativo extends Usuario {
    private List<Curso> cursos;

    public PersonalAdministrativo(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
        this.cursos = new ArrayList<>();
    }

    @Override
    public void login() {
        System.out.println("Bienvenido, personal administrativo " + getNombre() + " " + getApellido());
    }

    @Override
    public void logout() {
        System.out.println("Hasta luego, personal administrativo " + getNombre() + " " + getApellido());
    }

    public void crearCurso(String nombreCurso) {
        Curso curso = new Curso(nombreCurso);
        cursos.add(curso);
        curso.guardarInformacion(); // Guardar información del curso en el archivo CSV
        System.out.println("Se ha creado el curso: " + nombreCurso);
    }

    public void asignarEstudianteACurso(Estudiante estudiante, Curso curso) {
        curso.agregarEstudiante(estudiante);
        curso.guardarInformacion(); // Actualizar información del curso en el archivo CSV
        System.out.println("Se ha asignado al estudiante " + estudiante.getNombre() + " " +
                estudiante.getApellido() + " al curso " + curso.getNombre());
    }

    public void asignarCatedraticoACurso(Docente docente, Curso curso) {
        curso.setCatedratico(docente);
        curso.guardarInformacion(); // Actualizar información del curso en el archivo CSV
        System.out.println("Se ha asignado al docente " + docente.getNombre() + " " +
                docente.getApellido() + " como catedrático del curso " + curso.getNombre());
    }

    public void asignarPagoACatedratico(Docente docente, double monto) {
        docente.registrarPago(monto);
        // Lógica para registrar el pago al catedrático (si fuera necesario)
        System.out.println("Se ha registrado el pago al docente " + docente.getNombre() + " " +
                docente.getApellido() + " por un monto de $" + monto);
    }

    public void resumenNotasPagosEstudiantes() {
        System.out.println("Resumen de notas y pagos de estudiantes:");
        for (Curso curso : cursos) {
            System.out.println("Curso: " + curso.getNombre());
            System.out.println("Catedrático: " + (curso.getCatedratico() != null ?
                    curso.getCatedratico().getNombre() + " " + curso.getCatedratico().getApellido() :
                    "No asignado"));
            System.out.println("Estudiantes:");
            for (Estudiante estudiante : curso.getEstudiantes()) {
                System.out.println("- " + estudiante.getNombre() + " " + estudiante.getApellido());
                // Aquí podrías incluir la lógica para mostrar las notas y los pagos de cada estudiante
            }
            System.out.println("-----------------------------------");
        }
    }
}



