/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ruben
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentaDAO {
    private Connection conexion;

    public CuentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public int obtenerSaldo(int numeroCuenta) throws SQLException {
        String query = "SELECT Saldo FROM Cuentas WHERE Numero_Cuenta = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, numeroCuenta);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Saldo");
                }
            }
        }
        return -1; // Retornar un valor negativo si no se encuentra la cuenta
    }

    public boolean actualizarSaldo(int numeroCuenta, int nuevoSaldo) throws SQLException {
        String query = "UPDATE Cuentas SET Saldo = ? WHERE Numero_Cuenta = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, nuevoSaldo);
            pstmt.setInt(2, numeroCuenta);
            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        }
    }
    
    public boolean verificarExistenciaCuenta(int numeroCuenta) throws SQLException {
    String query = "SELECT COUNT(*) AS cuenta FROM Cuentas WHERE Numero_Cuenta = ?";
    try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
        pstmt.setInt(1, numeroCuenta);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int cuenta = rs.getInt("cuenta");
                return cuenta > 0;
            }
        }
    }
    return false; // Retornar false si no se encuentra la cuenta
}
    
}


