package com.example;

import java.io.*;

public class SPU01E02_juanantonio_fernandez {
    public static void main(String[] args) {
        try {
            Process procesoHijo = new ProcessBuilder("python", "generar_numero.py").start();

            BufferedReader lectorTeclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader salidaHijo = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            OutputStreamWriter entradaHijo = new OutputStreamWriter(procesoHijo.getOutputStream());

            System.out.println("Introduce un número aleatorio o escribe 'fi' para salir.");

            while (true) {
                String entrada = lectorTeclado.readLine();

                if (entrada.equals("fi")) {
                    entradaHijo.write("salir\n");
                    entradaHijo.flush();
                    procesoHijo.destroy();
                    System.out.println("Proceso finalizado.");
                    break;
                }

                entradaHijo.write("\n");
                entradaHijo.flush();

                String numeroAleatorio = salidaHijo.readLine();
                System.out.println("Número aleatorio recibido: " + numeroAleatorio);
            }
        } catch (IOException e) {
            System.out.println("Error al ejecutar el proceso hijo.");
        }
    }
}
