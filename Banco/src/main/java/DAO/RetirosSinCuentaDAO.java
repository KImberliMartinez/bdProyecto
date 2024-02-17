/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ruben
 */
public class RetirosSinCuentaDAO {

    private Connection conexion;

    public RetirosSinCuentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarRetiroSinCuenta(int numeroCuenta, int folioOperacion, String estado, String contraseña) throws SQLException {
        String query = "INSERT INTO RetirosSinCuenta (Destino_Numero, Folio_de_operacion, Contraseña, Fecha) "
                + "VALUES (?, ?, ?, CURDATE())";
        try ( PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, numeroCuenta);
            pstmt.setInt(2, folioOperacion);
            pstmt.setString(3, contraseña);
            pstmt.executeUpdate();
        }
    }

    public boolean validarFolioYContrasenia(int folio, String contrasenia) throws SQLException {
        String query = "SELECT * FROM RetirosSinCuenta WHERE Folio_de_operacion = ? AND Contraseña = ?";
        try ( PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, folio);
            pstmt.setString(2, contrasenia);
            try ( ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); // Si hay una fila, significa que se encontró una coincidencia
            }
        }
    }
}
