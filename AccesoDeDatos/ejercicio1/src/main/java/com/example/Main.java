package com.example;

public class Main {
    public static void main(String[] args) {
        String originalFilePath = "originalFile.txt";
        String copyFilePath = "copyFile.txt";
        String byteFilePath = "byteFile.txt";

        FileCopy fileCopier = new FileCopy();
        fileCopier.copyFile(originalFilePath, copyFilePath);

        FileReaderManager fileReaderManager = new FileReaderManager();
        fileReaderManager.readFile(originalFilePath);

        FilePermissionManager filePermissionManager = new FilePermissionManager();
        filePermissionManager.setWritePermission(originalFilePath, false);

        FileWriterManager fileWriterManager = new FileWriterManager();
        fileWriterManager.writeFile(originalFilePath, "Intentando escribir sin permisos de escritura.\n", true);

        filePermissionManager.setWritePermission(originalFilePath, true);

        fileWriterManager.writeFile(originalFilePath, "Escritura exitosa tras restaurar permisos.\n", true);

        fileReaderManager.readFile(originalFilePath);

        byte[] byteData = "Este es un archivo escrito en formato de bytes.".getBytes();

        FileOutput fileOutput = new FileOutput();
        fileOutput.writeBytesToFile(byteFilePath, byteData);

        FileInput fileInput = new FileInput();
        fileInput.readFileInBytes(byteFilePath);
    }
}
