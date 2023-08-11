package com.example.retoAPI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
    // Método para leer el archivo CSV y devolver una lista de listas de strings
    public List<List<String>> leerCSV(String archivo) throws IOException {
        List<List<String>> datos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String header = br.readLine(); // Leer la primera línea como encabezado (header)
            String coma;
            while ((coma = br.readLine()) != null) {
                String[] valores = coma.split(",");
                datos.add(List.of(valores));
            }
        }
        return datos;
    }
}
