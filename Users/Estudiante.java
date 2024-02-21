// Users/Estudiante.java
package Users;

import db.ArchivoCSV;

import java.util.List;

public class Estudiante extends Usuario {
    public Estudiante(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
    }
    
    @Override
    public void login() {
        // Implementación específica del login para estudiantes
        System.out.println("Bienvenido, estudiante " + getNombre() + " " + getApellido());
    }
    
    @Override
    public void logout() {
        // Implementación específica del logout para estudiantes
        System.out.println("Hasta luego, estudiante " + getNombre() + " " + getApellido());
    }
    
    // Método para consultar la nota de una clase específica
    public void consultarNota(String clase) {
        System.out.println("Consultando nota para la clase de " + clase + "...");
        ArchivoCSV archivoNotas = new ArchivoCSV("db/notas.csv");
        List<String[]> registrosNotas = archivoNotas.leer();
        
        // Buscar la nota del estudiante en el archivo CSV
        for (String[] registro : registrosNotas) {
            if (registro[0].equals(getUsuario()) && registro[1].equals(clase)) {
                System.out.println("Nota para la clase de " + clase + ": " + registro[2]);
                return;
            }
        }
        
        System.out.println("No se encontró la nota para la clase de " + clase);
    }
    
    // Método para realizar un pago
    public void realizarPago() {
        // Implementación para realizar un pago
        System.out.println("Realizando pago...");
        // Lógica para el pago
    }
    
    // Método para consultar los pagos realizados
    public void consultarPagos() {
        // Implementación para consultar los pagos realizados
        System.out.println("Consultando pagos realizados...");
        // Lógica para consultar pagos
    }
}


