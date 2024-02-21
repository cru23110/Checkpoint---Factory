// Factories/Factory.java
package Factories;

import Users.Usuario;

public interface Factory {
    Usuario crearUsuario(String nombre, String apellido, String usuario, String contraseña);
    Usuario autenticar(String usuario, String contraseña);
}
