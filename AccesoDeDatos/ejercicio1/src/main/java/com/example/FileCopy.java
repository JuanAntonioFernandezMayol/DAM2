package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public void copyFile(String originalFilePath, String copyFilePath) {
        try (FileReader fileReader = new FileReader(originalFilePath);
                FileWriter fileWriter = new FileWriter(copyFilePath)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                fileWriter.write(character);
            }
            System.out.println("El archivo ha sido copiado de " + originalFilePath + " a " + copyFilePath);
        } catch (IOException e) {
            System.out.println("Error al copiar el archivo: " + e.getMessage());
        }
    }
}
