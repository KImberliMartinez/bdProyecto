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

/**
 *
 * @author delll
 */
public class controlCliente {
    ClienteDAO datos;
    Cliente cliente;
    ClienteNuevoDTO c;
   
     public String insertar(String nombre, String apellidoP, String apellidoM, String Direccion,String fecha,int edad ){
        c.setNombre(nombre);
        c.setApellidoPaterno(apellidoP);
        c.setApellidoMaterno(apellidoM);
        c.setDomicilio(Direccion);
        c.setFechaNacimiento(fecha);
        c.setEdad(edad);
    // cliente.setFechaNacimiento(fecha);
        try {
            datos.agregarCliente(c);
        } catch (SQLException ex) {
            Logger.getLogger(controlCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(controlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
        return "listo";

    }

     public String actualizar(ClienteNuevoDTO a) throws PersistenciaException, SQLException {
        datos.actualizarCliente(a);
        return "";
    }
}
