/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancopersistencia;

/**
 *
 * @author ruben
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/Banco";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "12131442";

    // Método para obtener una conexión a la base de datos
    public static Connection obtenerConexion() throws SQLException {
        Connection conexion = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException e) {
            // Si no se encuentra el driver, imprime un mensaje de error
            System.out.println("Driver MySQL no encontrado: " + e.getMessage());
            throw new SQLException("Driver MySQL no encontrado");
        } catch (SQLException e) {
            // Si hay un error al conectar, imprime un mensaje de error
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            throw e;
        }
        // Devuelve la conexión establecida
        return conexion;
    }
}
