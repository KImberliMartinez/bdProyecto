/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banconegocio;

import com.mycompany.bancodominio.dtos.UsuarioDTO;
import static com.mycompany.bancopersistencia.ConexionBD.obtenerConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author delll
 */
public class controlCuenta {

    private Connection conexion;

    public controlCuenta(Connection conexion) {
        this.conexion = conexion;
    }
    private static final Logger LOG = Logger.getLogger(controlCuenta.class.getName());

    public void consultarClientesPortelefono(UsuarioDTO u) throws SQLException {
        String sql = "ConsultarCuentasCliente(?)";

        try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setString(1, u.getTelefono());
            // Ejecutamos la llamada al procedimiento almacenado
            pstmt.executeUpdate();
            LOG.log(Level.INFO, "Cuentas consultados con exito");

        }

    }

    private int obtenerNumeroCuenta(int idCliente) {
        String query = "SELECT Numero_Cuenta FROM Cuentas WHERE ID_Cliente = ?";
        try ( Connection conexion = obtenerConexion();  PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idCliente);
            System.out.println("Consulta SQL para obtener número de cuenta: " + pstmt.toString()); // Imprimir consulta SQL
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int numeroCuenta = rs.getInt("Numero_Cuenta");
                    System.out.println("Número de cuenta encontrado: " + numeroCuenta); // Imprimir número de cuenta encontrado
                    return numeroCuenta;
                } else {
                    System.out.println("El cliente no tiene una cuenta asociada"); // Imprimir si el cliente no tiene una cuenta asociada
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprimir el stack trace de la excepción
            return -1;
        }
    }

    public int consultarNumeroCuenta(long telefono, String contrasena) {
        String query = "SELECT id_cliente FROM usuarios WHERE telefono = ? AND contrasena = ?";
        try ( Connection conexion = obtenerConexion();  PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setLong(1, telefono);
            pstmt.setString(2, contrasena);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // El usuario existe en la base de datos, devuelve su número de cuenta asociado
                    int idCliente = rs.getInt("id_cliente");
                    int numeroCuenta = obtenerNumeroCuenta(idCliente);
                    return numeroCuenta;
                } else {
                    // El usuario no existe en la base de datos
                    return -1;
                }
            }
        } catch (SQLException ex) {
            // Manejo del error en caso de fallo en la consulta
            ex.printStackTrace();

            return -1;
        }
    }
    public int obtenerSaldoDisponible(int numeroCuenta) {
        int saldoDisponible = 0;
        String query = "SELECT Saldo FROM Cuentas WHERE Numero_Cuenta = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, numeroCuenta);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    saldoDisponible = rs.getInt("Saldo");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return saldoDisponible;

}
    public boolean actualizarSaldoCliente(int numeroCuenta, double nuevoSaldo) {
        String query = "UPDATE Cuentas SET Saldo = ? WHERE Numero_Cuenta = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setDouble(1, nuevoSaldo);
            pstmt.setInt(2, numeroCuenta);
            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
