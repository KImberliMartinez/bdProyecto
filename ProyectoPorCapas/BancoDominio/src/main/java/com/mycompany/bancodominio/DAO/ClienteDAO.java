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
import javax.swing.JOptionPane;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    
 public  void agregarCliente(ClienteNuevoDTO c) throws SQLException {
        // Definimos la llamada al procedimiento almacenado
        String sql = "CALL sp_agregarCliente(?,?,?,?,?)";
        
         try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getApellidoPaterno());
            pstmt.setString(3, c.getApellidoMaterno());
            pstmt.setString(4, c.getDomicilio());
            

            // Ejecutamos la llamada al procedimiento almacenado
            pstmt.executeUpdate();
          
        }
         LOG.log(Level.INFO,"Cliente agregado con exito");
    }
 
 
 public  void agregarClienteYusuario(ClienteNuevoDTO c) throws SQLException {
        // Definimos la llamada al procedimiento almacenado
        String sql = "CALL AgregarClienteYUsuario (?,?,?,?,?,?,?)";
        
         try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getApellidoPaterno());
            pstmt.setString(3, c.getApellidoMaterno());
            pstmt.setString(4, c.getDomicilio());
            pstmt.setString(5, c.getFechaNacimiento());
            pstmt.setString(6, c.getTelefono());
            pstmt.setString(7, c.getContra());
            
            

            // Ejecutamos la llamada al procedimiento almacenado
            pstmt.executeUpdate();
          LOG.log(Level.INFO,"Cliente y usuario agregados con exito");
        }catch(SQLException e){
           LOG.log(Level.SEVERE,"Cliente y usuario no  agregados",e);

        }
         
    }
         public void actualizarCliente(ClienteNuevoDTO cliente) throws SQLException, PersistenciaException {
        String query = "CALL actualizar_cliente  (?,?,?,?)"; 
                       
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellidoPaterno());
            pstmt.setString(3, cliente.getApellidoMaterno());
            pstmt.setString(4, cliente.getDomicilio());
           
            pstmt.executeUpdate();
              int registrosModificados = pstmt.executeUpdate();
            LOG.log(Level.INFO, "Se modifico con éxito {0} ", registrosModificados);
            
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "cliente no encontrado", e);
            throw new PersistenciaException("No se ha encontrado ningún cliente", e);
        }    
    }

//    public List<Cliente> obtenerClientes() throws SQLException, PersistenciaException {
//        List<Cliente> clientes = new ArrayList<>();
//        String query = "SELECT * FROM Clientes";
//        try (PreparedStatement pstmt = conexion.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery()) {
//           while (rs.next()) {
//                int id = rs.getInt("ID_cliente");
//                String nombre = rs.getString("nombre");
//                String apellidoP = rs.getString("Ap_Paterno");
//                String apellidoM = rs.getString("Ap_Materno");
//                String domicilio = rs.getString("Domicilio");
//                String fecha_nacimiento = rs.getString("fecha_Nacimiento");
//                int edad = rs.getInt("edad");
//                Cliente c = new Cliente(id, nombre, apellidoP, apellidoM, domicilio, fecha_nacimiento,edad);
//                clientes.add(c);
//                
//            }
//          
//            LOG.log(Level.INFO, "Se consultaron {0} clientes", clientes.size());
//           // return listaActivistas;
//
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, "No se pudieron obtener los clientes", e);
//            throw new PersistenciaException("No se pudieron consultar los clientes", e);
//
//        }
//
//        return clientes;
//    }
//    
//        public Cliente actualizarCliente(ClienteNuevoDTO cliente) throws SQLException, PersistenciaException {
//        String query = "UPDATE  Clientes SET Nombre=?, Domicilio=? WHERE Nombre=?"; 
//                       
//        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
//            pstmt.setString(1, cliente.getNombre());
//            pstmt.setString(2, cliente.getApellidoPaterno());
//            pstmt.setString(3, cliente.getApellidoMaterno());
//            pstmt.setString(4, cliente.getDomicilio());
//            pstmt.setString(5, cliente.getFechaNacimiento());
//            //pstmt.setDate(5, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
//            pstmt.setInt(6, cliente.getEdad());
////            pstmt.executeUpdate();
//              int registrosModificados = pstmt.executeUpdate();
//            LOG.log(Level.INFO, "Se modifico con éxito {0} ", registrosModificados);
//             ResultSet registroGenerado = pstmt.getGeneratedKeys();
//
//            //nos posicionamos en el primer registro o en el siguiente disponible. 
//            registroGenerado.next();
//
//            Cliente clienteNuevo = new Cliente(
//                    registroGenerado.getInt(1),
//                    cliente.getNombre(),
//                    cliente.getApellidoPaterno(),
//                    cliente.getApellidoMaterno(),
//                    cliente.getDomicilio(),
//                    cliente.getFechaNacimiento(),
//                    cliente.getEdad()
//            );
//            return clienteNuevo;
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, "cliente no encontrado", e);
//            throw new PersistenciaException("No se ha encontrado ningún cliente", e);
//        }
//        
//        
//    }

}

