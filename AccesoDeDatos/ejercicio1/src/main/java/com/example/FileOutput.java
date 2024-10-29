package com.example;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {

    public void writeBytesToFile(String filePath, byte[] data) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            fileOutputStream.write(data);
            System.out.println("Datos escritos correctamente en el archivo: " + filePath);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
