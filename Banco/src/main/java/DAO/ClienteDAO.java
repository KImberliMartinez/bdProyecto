/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ruben
 */
import Dominio.Cliente;
import Persistencia.PersistenciaException;
import Persistencia.dtos.ClienteNuevoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());
    

//    public void agregarCliente(Cliente cliente) throws SQLException, PersistenciaException {
//        String query = "INSERT INTO Clientes (Nombre, Ap_Paterno, Ap_Materno, Domicilio, Fecha_Nacimiento) " +
//                       "VALUES ('?','?' ,'?','?','?')";
//        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
//            pstmt.setString(1, cliente.getNombre());
//            pstmt.setString(2, cliente.getApellidoPaterno());
//            pstmt.setString(3, cliente.getApellidoMaterno());
//            pstmt.setString(4, cliente.getDomicilio());
//            pstmt.setString(5, cliente.getFechaNacimiento());
//            //pstmt.setDate(5, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
//           // pstmt.setInt(6, cliente.getEdad());
//             int registrosModificados =pstmt.executeUpdate();
//             LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);
//
//            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
//            ResultSet registroGenerado = pstmt.getGeneratedKeys();
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
//            
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, "cliente no agregado", e);
//            throw new PersistenciaException("No se ha podido agregar ningún cliente", e);
//    }
//    }

    public  void agregarCliente(ClienteNuevoDTO c) throws SQLException {
        // Definimos la llamada al procedimiento almacenado
        String sql = "CALL sp_agregarCliente(?,?,?,?,?)";
        
         try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getApellidoPaterno());
            pstmt.setString(3, c.getApellidoMaterno());
            pstmt.setString(4, c.getDomicilio());
            pstmt.setString(5,c.getFechaNacimiento());
            

            // Ejecutamos la llamada al procedimiento almacenado
            pstmt.executeUpdate();
        }
    }
//    public List<Cliente> obtenerClientes() throws SQLException {
//        List<Cliente> clientes = new ArrayList<>();
//        String query = "SELECT * FROM Clientes";
//        try (PreparedStatement pstmt = conexion.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery()) {
//            while (rs.next()) {
//                Cliente cliente = new Cliente();
//                cliente.setIdCliente(rs.getInt("ID_Cliente"));
//                cliente.setNombre(rs.getString("Nombre"));
//                cliente.setApellidoPaterno(rs.getString("Ap_Paterno"));
//                cliente.setApellidoMaterno(rs.getString("Ap_Materno"));
//                cliente.setDomicilio(rs.getString("Domicilio"));
//                cliente.setFechaNacimiento(rs.getString("Fecha_Nacimiento"));
//                //cliente.setFechaNacimiento(rs.getDate("Fecha_Nacimiento"));
//                cliente.setEdad(rs.getInt("Edad"));
//                clientes.add(cliente);
//            }
//        }
//        return clientes;
//    }
//    
//        public void actualizarCliente(Cliente cliente) throws SQLException, PersistenciaException {
//        String query = "UPDATE  Clientes SET Nombre=?, Ap_Paterno=?, Ap_Materno=?, Domicilio=?, Fecha_Nacimiento=?, Edad=? WHERE Nombre=?"; 
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
//            
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, "cliente no encontrado", e);
//            throw new PersistenciaException("No se ha encontrado ningún cliente", e);
//        }
//    }

}

