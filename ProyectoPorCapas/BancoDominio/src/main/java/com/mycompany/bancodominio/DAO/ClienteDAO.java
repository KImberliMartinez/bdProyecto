/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio.DAO;

/**
 *
 * 
 */


import com.mycompany.bancodominio.Cliente;
import com.mycompany.bancodominio.dtos.ClienteNuevoDTO;
import com.mycompany.bancopersistencia.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    

    public Cliente agregarCliente(ClienteNuevoDTO cliente) throws SQLException, PersistenciaException {
   //1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO Clientes (nombre, Ap_Paterno,Ap_Materno,Domicilio, fecha_Nacimiento) VALUES (?,?,?,?,?)";

        //2. Vamos a insertar o intentar hacer la inserción en la tabla
        // Try With Resources
        try (//recursos
               //  establecemos la conexion con la bd
                //Crear el statement o el comando donde ejecutamos la sentencia
                PreparedStatement comandoSQL = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // mandamos la sentencia y obtenemos de regreso la llave generada o el ID
                ) {

            //3. mandar los valores del cliente al comandoSQL
            comandoSQL.setString(1, cliente.getNombre());
            comandoSQL.setString(2, cliente.getApellidoPaterno());
            comandoSQL.setString(3, cliente.getApellidoMaterno());
            comandoSQL.setString(4, cliente.getDomicilio());
            comandoSQL.setString(5, cliente.getFechaNacimiento());
            comandoSQL.setInt(6, cliente.getEdad());

            //4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = comandoSQL.executeUpdate();
            LOG.log(Level.INFO, "Se agrego con éxito {0} ", registrosModificados);

            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = comandoSQL.getGeneratedKeys();

            //nos posicionamos en el primer registro o en el siguiente disponible. 
            registroGenerado.next();

            Cliente ClienteN = new Cliente(
                    registroGenerado.getInt(1),
                    cliente.getNombre(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getDomicilio(),
                    cliente.getFechaNacimiento(),
                    cliente.getEdad()
            );
           
            // regresamos el cliente
            return ClienteN;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito el cliente", e);
            throw new PersistenciaException("No se pudo guardar el cliente ", e);

        }

    }


    public List<Cliente> obtenerClientes() throws SQLException, PersistenciaException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try (PreparedStatement pstmt = conexion.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
           while (rs.next()) {
                int id = rs.getInt("ID_cliente");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("Ap_Paterno");
                String apellidoM = rs.getString("Ap_Materno");
                String domicilio = rs.getString("Domicilio");
                String fecha_nacimiento = rs.getString("fecha_Nacimiento");
                int edad = rs.getInt("edad");
                Cliente c = new Cliente(id, nombre, apellidoP, apellidoM, domicilio, fecha_nacimiento,edad);
                clientes.add(c);
                
            }
          
            LOG.log(Level.INFO, "Se consultaron {0} clientes", clientes.size());
           // return listaActivistas;

        } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
            throw new PersistenciaException("No se pudieron consultar los clientes", e);

        }

        return clientes;
    }
    
        public Cliente actualizarCliente(ClienteNuevoDTO cliente) throws SQLException, PersistenciaException {
        String query = "UPDATE  Clientes SET Nombre=?, Domicilio=? WHERE Nombre=?"; 
                       
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellidoPaterno());
            pstmt.setString(3, cliente.getApellidoMaterno());
            pstmt.setString(4, cliente.getDomicilio());
            pstmt.setString(5, cliente.getFechaNacimiento());
            //pstmt.setDate(5, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            pstmt.setInt(6, cliente.getEdad());
//            pstmt.executeUpdate();
              int registrosModificados = pstmt.executeUpdate();
            LOG.log(Level.INFO, "Se modifico con éxito {0} ", registrosModificados);
             ResultSet registroGenerado = pstmt.getGeneratedKeys();

            //nos posicionamos en el primer registro o en el siguiente disponible. 
            registroGenerado.next();

            Cliente clienteNuevo = new Cliente(
                    registroGenerado.getInt(1),
                    cliente.getNombre(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getDomicilio(),
                    cliente.getFechaNacimiento(),
                    cliente.getEdad()
            );
            return clienteNuevo;
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "cliente no encontrado", e);
            throw new PersistenciaException("No se ha encontrado ningún cliente", e);
        }
        
        
    }

}

