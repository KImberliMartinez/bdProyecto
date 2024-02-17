/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.ClienteDAO;
import Dominio.Cliente;
import Persistencia.PersistenciaException;
import Persistencia.dtos.ClienteNuevoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author delll
 */
public class controlCliente {
        private Connection conexion;

    public controlCliente(Connection conexion) {
        this.conexion = conexion;
    }
    ClienteDAO datos;
    ClienteNuevoDTO cliente;
     public void insertar(String nombre, String apellidoP, String apellidoM, String Direccion,String fecha) throws PersistenciaException {
         cliente=new ClienteNuevoDTO(nombre, apellidoP, apellidoM, Direccion, fecha);
//        cliente.setNombre(nombre);
//        cliente.setApellidoPaterno(apellidoP);
//        cliente.setApellidoMaterno(apellidoM);
//        cliente.setDomicilio(Direccion);
//        cliente.setFechaNacimiento(fecha);
            try {
                // cliente.setFechaNacimiento(fecha);
                datos.agregarCliente(cliente);
            } catch (SQLException ex) {
                Logger.getLogger(controlCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
       
        

        

    }

     public String actualizar(Cliente a) throws PersistenciaException, SQLException {
        datos.actualizarCliente(a);
        return "";
    }
}
