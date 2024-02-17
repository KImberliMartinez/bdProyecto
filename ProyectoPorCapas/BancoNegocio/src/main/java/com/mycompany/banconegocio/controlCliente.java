/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.banconegocio;


import com.mycompany.bancodominio.DAO.ClienteDAO;
import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.PersistenciaException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author delll
 */
public class controlCliente {
    ClienteDAO datos;
    ClienteNuevoDTO cliente;
//    ClienteNuevoDTO c;
   
   public void insertar(String nombre, String apellidoP, String apellidoM, String Direccion,String fecha) throws PersistenciaException {
        try {
            ClienteNuevoDTO c=new ClienteNuevoDTO(nombre,apellidoP,apellidoM,Direccion,fecha);
            datos.agregarCliente(c);
            
        } catch (SQLException ex) {
            Logger.getLogger(controlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
           
   }

//     public String actualizar(ClienteNuevoDTO a) throws PersistenciaException, SQLException {
//        datos.actualizarCliente(a);
//        return "";
//    }
}
