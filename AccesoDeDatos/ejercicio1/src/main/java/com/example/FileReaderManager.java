package com.example;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderManager {
    public void readFile(String filePath) {
        try (FileReader fileReader = new FileReader(filePath)) {
            System.out.println("Leyendo archivo: " + filePath);
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            System.out.println("No se puede leer");
        }
    }
}
