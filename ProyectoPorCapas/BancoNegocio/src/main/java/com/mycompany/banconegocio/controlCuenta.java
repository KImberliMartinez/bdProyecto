/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banconegocio;

import com.mycompany.bancodominio.dtos.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 
    
}
