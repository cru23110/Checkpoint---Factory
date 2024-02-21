// Factories/PersonalAdministrativoFactory.java
package Factories;

import java.util.List;

import Users.PersonalAdministrativo;
import Users.Usuario;
import db.ArchivoCSV;

public class PersonalAdministrativoFactory implements Factory {
    @Override
    public Usuario crearUsuario(String nombre, String apellido, String usuario, String contraseña) {
        return new PersonalAdministrativo(nombre, apellido, usuario, contraseña);
    }

    @Override
    public Usuario autenticar(String usuario, String contraseña) {
        ArchivoCSV archivoAdmins = new ArchivoCSV("db/usuarios_administrativos.csv");
        List<String[]> datosAdmins = archivoAdmins.leer();

        for (String[] adminData : datosAdmins) {
            if (adminData[2].equals(usuario) && adminData[3].equals(contraseña)) {
                // Crear una instancia de PersonalAdministrativo con los datos del CSV y devolverla
                return new PersonalAdministrativo(adminData[0], adminData[1], adminData[2], adminData[3]);
            }
        }

        return null; // Si no se encuentra al personal administrativo, devolver null
    }

}

