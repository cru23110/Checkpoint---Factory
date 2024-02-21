// Users/Docente.java
package Users;

import db.ArchivoCSV;
import java.util.ArrayList;
import java.util.List;

public class Docente extends Usuario {
    private static final String RUTA_HISTORIAL_PAGOS = "db/historial_pagos.csv";

    public Docente(String nombre, String apellido, String usuario, String contraseña) {
        super(nombre, apellido, usuario, contraseña);
    }
    
    @Override
    public void login() {
        // Implementación específica del login para docentes
        System.out.println("Bienvenido, docente " + getNombre() + " " + getApellido());
    }
    
    @Override
    public void logout() {
        // Implementación específica del logout para docentes
        System.out.println("Hasta luego, docente " + getNombre() + " " + getApellido());
    }
    
    // Método para ingresar notas de estudiantes en una clase específica
    public void ingresarNotas(String clase, int[] notas) {
        System.out.println("Ingresando notas para la clase de " + clase + "...");
        
        // Guardar las notas en un archivo CSV
        String rutaArchivoNotas = "db/notas_" + clase + ".csv";
        ArchivoCSV archivoNotas = new ArchivoCSV(rutaArchivoNotas);
        List<String[]> registrosNotas = new ArrayList<>();
        registrosNotas.add(new String[] { "Estudiante", "Nota" });
        for (int i = 0; i < notas.length; i++) {
            registrosNotas.add(new String[] { "Estudiante" + (i + 1), String.valueOf(notas[i]) });
        }
        archivoNotas.escribir(registrosNotas);
    }
    
    // Método para cobrar un pago
    public void cobrarPago() {
        System.out.println("Cobrando pago...");
        // La implementación de este método dependerá de cómo se manejen los pagos en tu sistema
    }
    
    // Método para consultar el historial de pagos
    public void historialPagos() {
        System.out.println("Consultando historial de pagos...");
        
        // Leer el historial de pagos desde el archivo CSV
        ArchivoCSV archivoHistorialPagos = new ArchivoCSV(RUTA_HISTORIAL_PAGOS);
        List<String[]> registrosHistorialPagos = archivoHistorialPagos.leer();
        
        // Mostrar los registros del historial de pagos
        for (String[] registro : registrosHistorialPagos) {
            System.out.println("ID Pago: " + registro[0] + ", Monto: " + registro[1] + ", Concepto: " + registro[2]);
        }
    }
}

