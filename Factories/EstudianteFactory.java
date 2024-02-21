// Factories/EstudianteFactory.java
package Factories;

import java.util.List;

import Users.Estudiante;
import Users.Usuario;
import db.ArchivoCSV;

public class EstudianteFactory implements Factory {
    @Override
    public Usuario crearUsuario(String nombre, String apellido, String usuario, String contraseña) {
        return new Estudiante(nombre, apellido, usuario, contraseña);
    }

    @Override
    public Usuario autenticar(String usuario, String contraseña) {
        ArchivoCSV archivoEstudiantes = new ArchivoCSV("db/usuarios_estudiantes.csv");
        List<String[]> datosEstudiantes = archivoEstudiantes.leer();

        for (String[] estudianteData : datosEstudiantes) {
            if (estudianteData[2].equals(usuario) && estudianteData[3].equals(contraseña)) {
                // Crear una instancia de Estudiante con los datos del CSV y devolverla
                return new Estudiante(estudianteData[0], estudianteData[1], estudianteData[2], estudianteData[3]);
            }
        }

        return null; // Si no se encuentra al estudiante, devolver null
    }
}
