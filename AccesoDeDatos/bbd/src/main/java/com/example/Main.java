package com.example;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    private static Connection connect() {
        Connection conn = null;
        try {
            // Ruta de la base de datos SQLite
            String url = "jdbc:sqlite:C:/Users/pukyt/Desktop/DAM2/AccesoDeDatos/mi_base_de_datos.db";

            // Verificar si el archivo de la base de datos existe
            File dbFile = new File("C:/Users/pukyt/Desktop/DAM2/AccesoDeDatos/mi_base_de_datos.db");
            if (dbFile.exists()) {
                System.out.println("El archivo de la base de datos existe en la ruta especificada.");
            }

            // Establecer la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Conexión establecida a la base de datos.");

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conn;
    }

    private static void seeBooks(Connection conn) {
        String sql = "SELECT * FROM usuarios";

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // Leer los resultados del SELECT y mostrarlos por terminal
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String edad = rs.getString("edad");

                System.out.println("ID: " + id);
                System.out.println("Title: " + nombre);
                System.out.println("Author: " + edad);

                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar el SELECT: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Conectar a la base de datos
        Connection conn = connect();
        // Mostrar los datos de la tabla books
        seeBooks(conn);

        // Cerrar la conexión
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}