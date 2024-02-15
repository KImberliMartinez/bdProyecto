/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ruben
 */
import Dominio.Transaccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransaccionDAO {

    private Connection conexion;

    public TransaccionDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void transferirDinero(int numeroCuentaOrigen, int numeroCuentaDestino, int monto) throws SQLException {
        String query = "INSERT INTO Transacciones (Fecha, Monto, Numero_de_cuenta_destino) "
                + "VALUES (CURDATE(), ?, ?)";
        try ( PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, monto);
            pstmt.setInt(2, numeroCuentaDestino);
            pstmt.executeUpdate();
        }

        // Actualizar saldo de la cuenta origen
        String queryActualizarOrigen = "UPDATE Cuentas SET Saldo = Saldo - ? WHERE Numero_Cuenta = ?";
        try ( PreparedStatement pstmt = conexion.prepareStatement(queryActualizarOrigen)) {
            pstmt.setInt(1, monto);
            pstmt.setInt(2, numeroCuentaOrigen);
            pstmt.executeUpdate();
        }

        // Actualizar saldo de la cuenta destino
        String queryActualizarDestino = "UPDATE Cuentas SET Saldo = Saldo + ? WHERE Numero_Cuenta = ?";
        try ( PreparedStatement pstmt = conexion.prepareStatement(queryActualizarDestino)) {
            pstmt.setInt(1, monto);
            pstmt.setInt(2, numeroCuentaDestino);
            pstmt.executeUpdate();
        }
    }
}
