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
      
    public void consultarClientesPortelefono(UsuarioDTO u) throws SQLException{
        String sql = "ConsultarCuentasCliente(?)";
        
         try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setString(1,u.getTelefono());
            // Ejecutamos la llamada al procedimiento almacenado
            pstmt.executeUpdate();
            LOG.log(Level.INFO,"Cuentas consultados con exito");
          
        }
         
    }
    
    private int obtenerNumeroCuenta(int idCliente) {
        String query = "SELECT Numero_Cuenta FROM Cuentas WHERE ID_Cliente = ?";
        try (Connection conexion = obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idCliente);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Devuelve el número de cuenta asociado al cliente
                    return rs.getInt("Numero_Cuenta");
                } else {
                    // El cliente no tiene una cuenta asociada
                    return -1;
                }
            }
        } catch (SQLException ex) {
            // Manejo del error en caso de fallo en la consulta
            ex.printStackTrace();
            return -1;
        }
    }

    
    
     private int consultarNumeroCuenta(long telefono, String contrasena) {
        String query = "SELECT id_cliente FROM usuarios WHERE telefono = ? AND contrasena = ?";
        try (Connection conexion = obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setLong(1, telefono);
            pstmt.setString(2, contrasena);
            try (ResultSet rs = pstmt.executeQuery()) {
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

 
    
}
