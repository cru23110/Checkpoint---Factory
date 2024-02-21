// Users/AuditorExterno.java
package Users;

import db.ArchivoCSV;

import java.util.List;

public class AuditorExterno extends Usuario {
    private final ArchivoCSV archivoNotas;
    private final ArchivoCSV archivoPagosEstudiantes;
    private final ArchivoCSV archivoPagosDocentes;

    public AuditorExterno(String nombre, String apellido, String usuario, String contraseña,
                          ArchivoCSV archivoNotas, ArchivoCSV archivoPagosEstudiantes, ArchivoCSV archivoPagosDocentes) {
        super(nombre, apellido, usuario, contraseña);
        this.archivoNotas = archivoNotas;
        this.archivoPagosEstudiantes = archivoPagosEstudiantes;
        this.archivoPagosDocentes = archivoPagosDocentes;
}


    @Override
    public void login() {
        // Implementación específica del login para auditor externo
        System.out.println("Bienvenido, auditor externo " + getNombre() + " " + getApellido());
    }
    
    @Override
    public void logout() {
        // Implementación específica del logout para auditor externo
        System.out.println("Hasta luego, auditor externo " + getNombre() + " " + getApellido());
    }
    
    // Método para revisar las notas
    public void revisarNotas() {
        System.out.println("Revisando notas...");
        List<String[]> registrosNotas = archivoNotas.leer();
        // Aquí se podría procesar la lista de registros de notas según sea necesario
        for (String[] registro : registrosNotas) {
            // Se puede realizar alguna acción con cada registro de notas
            // Por ejemplo, mostrar la información o realizar algún cálculo
            System.out.println("Nota de estudiante: " + registro[0] + ", Clase: " + registro[1] + ", Nota: " + registro[2]);
        }
    }
    
    // Método para revisar las cuotas pagadas por estudiantes
    public void revisarCuotasPagadasEstudiantes() {
        System.out.println("Revisando cuotas pagadas por estudiantes...");
        List<String[]> registrosPagosEstudiantes = archivoPagosEstudiantes.leer();
        // Aquí se podría procesar la lista de registros de pagos de estudiantes según sea necesario
        for (String[] registro : registrosPagosEstudiantes) {
            // Se puede realizar alguna acción con cada registro de pagos de estudiantes
            // Por ejemplo, mostrar la información o realizar algún cálculo
            System.out.println("Pago de estudiante: " + registro[0] + ", Monto: " + registro[1] + ", Concepto: " + registro[2]);
        }
    }
    
    // Método para revisar los pagos a docentes
    public void revisarPagosDocentes() {
        System.out.println("Revisando pagos a docentes...");
        List<String[]> registrosPagosDocentes = archivoPagosDocentes.leer();
        // Aquí se podría procesar la lista de registros de pagos a docentes según sea necesario
        for (String[] registro : registrosPagosDocentes) {
            // Se puede realizar alguna acción con cada registro de pagos a docentes
            // Por ejemplo, mostrar la información o realizar algún cálculo
            System.out.println("Pago a docente: " + registro[0] + ", Monto: " + registro[1] + ", Concepto: " + registro[2]);
        }
    }
}

