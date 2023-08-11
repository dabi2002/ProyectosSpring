package com.example.retoAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication

public class RetoAPI {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        // Nombre del archivo CSV en la carpeta resources
        String filename = "C:/Users/Usuario/Desktop/Makaia/springboot/reto/RetoAPI/src/main/resources/people.csv";
        String delimiter = ",";
        String line;
        List<List<String>> lines = new ArrayList<>();
        
        // Cargar el archivo como recurso utilizando ResourceLoader
        ResourceLoader resourceLoader = SpringApplication.run(RetoAPI.class, args).getBean(ResourceLoader.class);
        Resource resource = resourceLoader.getResource("classpath:" + filename);

        try (InputStream inputStream = resource.getInputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            // Leer el archivo línea por línea y dividir cada línea por el delimitador ","
            while ((line = br.readLine()) != null) {
                List<String> rowData = Arrays.asList(line.split(delimiter));
                lines.add(rowData);
            }
            
            // Imprimir los datos leídos del archivo CSV
            for (List<String> rowData : lines) {
                System.out.println(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
