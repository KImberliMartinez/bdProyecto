/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import DAO.ClienteDAO;
import Dominio.Cliente;
import Persistencia.PersistenciaException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author delll
 */
public class controlCliente {
    ClienteDAO datos;
    Cliente cliente;
     public String insertar(String nombre, String apellidoP, String apellidoM, String Direccion,String fecha) throws PersistenciaException {

        cliente.setNombre(nombre);
        cliente.setApellidoPaterno(apellidoP);
        cliente.setApellidoMaterno(apellidoM);
        cliente.setDomicilio(Direccion);
        cliente.setFechaNacimiento(fecha);
    // cliente.setFechaNacimiento(fecha);
   
        
        try {
            datos.agregarCliente(cliente);
        } catch (SQLException ex) {
            Logger.getLogger(controlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        return "listo";

    }

     public String actualizar(Cliente a) throws PersistenciaException, SQLException {
        datos.actualizarCliente(a);
        return "";
    }
}
