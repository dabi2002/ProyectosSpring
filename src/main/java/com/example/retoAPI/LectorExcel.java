package com.example.retoAPI;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LectorExcel {


    public static List<List<String>> leerExcel(MultipartFile excel) {
        List<List<String>> excelData = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excel.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                List<String> rowData = new ArrayList<>();
                for (int j = 0; j < 11  ; j++) {
                    rowData.add(row.getCell(j).toString());
                }
                excelData.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Agrega un mensaje de error a los datos si ocurre una excepción
            List<String> errorData = new ArrayList<>();
            errorData.add("Error: " + e.getMessage());
            excelData.add(errorData);
        }

        return excelData;
    }
}
