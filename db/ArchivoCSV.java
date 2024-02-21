// db/ArchivoCSV.java
package db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoCSV {
    private String ruta;

    public ArchivoCSV(String ruta) {
        this.ruta = ruta;
    }

    public List<String[]> leer() {
        List<String[]> registros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                registros.add(campos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registros;
    }

    public void escribir(List<String[]> registros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            for (String[] campos : registros) {
                bw.write(String.join(",", campos));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> filtrarPorColumna(String valor, int indiceColumna) {
        List<String[]> registrosFiltrados = new ArrayList<>();
        List<String[]> registros = leer();
        for (String[] registro : registros) {
            if (registro.length > indiceColumna && registro[indiceColumna].equals(valor)) {
                registrosFiltrados.add(registro);
            }
        }
        return registrosFiltrados;
    }
}
