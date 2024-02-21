// Factories/DocenteFactory.java
package Factories;

import java.util.List;

import Users.Docente;
import Users.Usuario;
import db.ArchivoCSV;

public class DocenteFactory implements Factory {
    @Override
    public Usuario crearUsuario(String nombre, String apellido, String usuario, String contraseña) {
        return new Docente(nombre, apellido, usuario, contraseña);
    }

    @Override
    public Usuario autenticar(String usuario, String contraseña) {
        ArchivoCSV archivoDocentes = new ArchivoCSV("db/usuarios_docentes.csv");
        List<String[]> datosDocentes = archivoDocentes.leer();

        for (String[] docenteData : datosDocentes) {
            if (docenteData[2].equals(usuario) && docenteData[3].equals(contraseña)) {
                // Crear una instancia de Docente con los datos del CSV y devolverla
                return new Docente(docenteData[0], docenteData[1], docenteData[2], docenteData[3]);
            }
        }

        return null; // Si no se encuentra al docente, devolver null
    }

}
