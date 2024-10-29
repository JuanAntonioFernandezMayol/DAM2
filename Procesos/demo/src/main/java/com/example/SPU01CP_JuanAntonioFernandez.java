package com.example;

import java.io.*;

public class SPU01CP_JuanAntonioFernandez {
    public static void main(String[] args) {
        try {
            ProcessBuilder proceso1 = new ProcessBuilder("cmd", "/c", "dir");
            Process procesoHijo1 = proceso1.start();

            ProcessBuilder proceso2 = new ProcessBuilder("powershell", "-Command",
                    "[Console]::In.ReadToEnd() -replace 'd', 'D'");
            Process procesoHijo2 = proceso2.start();

            BufferedReader salidaHijo1 = new BufferedReader(new InputStreamReader(procesoHijo1.getInputStream()));
            BufferedWriter entradaHijo2 = new BufferedWriter(new OutputStreamWriter(procesoHijo2.getOutputStream()));

            String linea;
            while ((linea = salidaHijo1.readLine()) != null) {
                entradaHijo2.write(linea);
                entradaHijo2.newLine();
            }
            entradaHijo2.flush();
            entradaHijo2.close();

            BufferedReader salidaHijo2 = new BufferedReader(new InputStreamReader(procesoHijo2.getInputStream()));
            while ((linea = salidaHijo2.readLine()) != null) {
                System.out.println(linea);
            }

            procesoHijo1.waitFor();
            procesoHijo2.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error en la sincronización de los procesos.");
        }
    }
}
