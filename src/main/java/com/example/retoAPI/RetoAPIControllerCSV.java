package com.example.retoAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class RetoAPIControllerCSV {

    private final String archivoCSV = "C:/Users/Usuario/Desktop/Makaia/springboot/reto/RetoAPI/src/main/resources/people.csv";
    private final LectorCSV lectorCSV = new LectorCSV();

    @Autowired
    private LectorExcel excelService;

    @PostMapping("/personas-csv")
    public List<List<String>> obtenerPersonas() {
        try {
            return lectorCSV.leerCSV(archivoCSV);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/excel")
    public List<List<String>> excelReader(@RequestParam("file") MultipartFile excel) {
        return LectorExcel.leerExcel(excel);
    }

    }

