package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPU01E01_juanantonio_fernandez {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Error: No has especificado ninguna comanda.");
            return;
        }

        try {
            Process process = new ProcessBuilder(args).start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("El proceso terminó correctamente.");
            } else {
                System.out.println("El proceso falló con código: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al ejecutar la comanda.");
            e.printStackTrace();
        }
    }
}

// Comando para copilar:
// javac com/example/SPU01E01_juanantonio_fernandez.java
// Comando para ejecutar:
// java com.example.SPU01E01_juanantonio_fernandez cmd /c dir
// Desde la carpeta java ejecutamos todo y funcionara :)