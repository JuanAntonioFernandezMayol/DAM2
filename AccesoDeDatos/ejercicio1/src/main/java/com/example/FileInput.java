package com.example;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInput {

    public void readFileInBytes(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            System.out.println("Leyendo archivo en bytes: " + filePath);
            int byteRead;
            while ((byteRead = fileInputStream.read()) != -1) {
                System.out.printf("%02X ", byteRead);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo en bytes: " + e.getMessage());
        }
    }
}
