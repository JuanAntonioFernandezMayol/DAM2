package com.example;

import java.io.File;

public class FilePermissionManager {
    public void setWritePermission(String filePath, boolean isWritable) {
        File file = new File(filePath);
        if (isWritable) {
            if (file.setWritable(true)) {
                System.out.println("Permisos restaurados: " + filePath);
            } else {
                System.out.println("No se pudo restaurar los permisos.");
            }
        } else {
            if (file.setWritable(false)) {
                System.out.println("Permisos eliminados para el archivo: " + filePath);
            } else {
                System.out.println("No se pudieron eliminar los permisos.");
            }
        }
    }
}
