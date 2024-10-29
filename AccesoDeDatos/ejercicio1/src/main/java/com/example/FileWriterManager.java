package com.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterManager {
    public void writeFile(String filePath, String content, boolean append) {
        try (FileWriter writer = new FileWriter(filePath, append)) {
            writer.write(content);
            System.out.println("Se ha escrito correctamente: " + filePath);
        } catch (IOException e) {
            System.out.println("No se puede escribir en el archivo: " + e.getMessage());
        }
    }
}
