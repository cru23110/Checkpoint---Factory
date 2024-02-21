// Factories/AuditorExternoFactory.java
package Factories;

import java.util.List;

import Users.AuditorExterno;
import Users.Usuario;
import db.ArchivoCSV;

public class AuditorExternoFactory implements Factory {
    @Override
public Usuario crearUsuario(String nombre, String apellido, String usuario, String contraseña) {
    // Crear instancias de ArchivoCSV para los archivos relacionados
    ArchivoCSV archivoNotas = new ArchivoCSV("db/Notas.csv");
    ArchivoCSV archivoPagosEstudiantes = new ArchivoCSV("db/PagosEstudiantes.csv");
    ArchivoCSV archivoPagosDocentes = new ArchivoCSV("db/PagosDocentes.csv");

    // Crear una instancia de AuditorExterno con los datos proporcionados y los archivos relacionados
    return new AuditorExterno(nombre, apellido, usuario, contraseña,
                              archivoNotas, archivoPagosEstudiantes, archivoPagosDocentes);
}


    @Override
public Usuario autenticar(String usuario, String contraseña) {
    ArchivoCSV archivoAuditores = new ArchivoCSV("db/usuarios_auditores.csv");
    List<String[]> datosAuditores = archivoAuditores.leer();

    for (String[] auditorData : datosAuditores) {
        if (auditorData[2].equals(usuario) && auditorData[3].equals(contraseña)) {
            // Crear instancias de ArchivoCSV para los archivos relacionados
            ArchivoCSV archivoNotas = new ArchivoCSV("db/Notas.csv");
            ArchivoCSV archivoPagosEstudiantes = new ArchivoCSV("db/PagosEstudiantes.csv");
            ArchivoCSV archivoPagosDocentes = new ArchivoCSV("db/PagosDocentes.csv");
            
            // Crear una instancia de AuditorExterno con los datos del CSV y los archivos relacionados
            return new AuditorExterno(auditorData[0], auditorData[1], auditorData[2], auditorData[3],
                                       archivoNotas, archivoPagosEstudiantes, archivoPagosDocentes);
        }
    }

    return null; // Si no se encuentra al auditor externo, devolver null
}

}
