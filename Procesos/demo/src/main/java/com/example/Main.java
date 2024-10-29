package com.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length <= 0) {
            System.err.println("Se necessita un programa a executar");
            System.exit(-1);
        }
        ProcessBuilder pb = new ProcessBuilder(args);
        try {
            Process process = pb.start();
            int retorno = process.waitFor();
            System.out.println("La execució de " + Arrays.toString(args) + " retorna " + retorno);
        } catch (IOException ex) {
            System.err.println("Excepció de E/S");
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El proces fill ha finalitzat de forma incorrecta");
            System.exit(-1);
        }
    }
}