// University/Curso.java
package University;

import db.ArchivoCSV;

import java.util.ArrayList;
import java.util.List;

import Users.Docente;
import Users.Estudiante;

public class Curso {
    private String nombre;
    private Docente catedratico;
    private List<Estudiante> estudiantes;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Docente getCatedratico() {
        return catedratico;
    }

    public void setCatedratico(Docente catedratico) {
        this.catedratico = catedratico;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void guardarInformacion() {
        ArchivoCSV archivoCurso = new ArchivoCSV("db/cursos.csv");
        String[] cursoInfo = {nombre, catedratico != null ? catedratico.getNombre() + " " + catedratico.getApellido() : ""};
        archivoCurso.escribir(cursoInfo);
    }
}



