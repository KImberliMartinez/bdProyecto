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
import com.mycompany.bancopersistencia.ConexionBD;
import java.awt.Component;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
        try ( PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, numeroCuenta);
            try ( ResultSet rs = pstmt.executeQuery()) {
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
        try ( PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setDouble(1, nuevoSaldo);
            pstmt.setInt(2, numeroCuenta);
            int filasActualizadas = pstmt.executeUpdate();
          JOptionPane.showMessageDialog(null, "Dato actualizado correctamente.", "actualizacion exitosa", JOptionPane.INFORMATION_MESSAGE);

            return filasActualizadas > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
             JOptionPane.showMessageDialog(null, "No hay datos para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void generarFolioYContrasena(Component parentComponent, int numeroCuenta) {
        Random random = new Random();
        String folio = Integer.toString(random.nextInt(10000)); // Genera un folio aleatorio de 4 dígitos
        String contrasena = String.format("%08d", random.nextInt(100000000)); // Genera una contraseña aleatoria de 8 dígitos

        try {
            Connection conexion = ConexionBD.obtenerConexion();
            String consulta = "INSERT INTO retirossincuenta (Numero_Cuenta,Folio_de_operacion, Contraseña, ESTADOS, Fecha) VALUES (?,?, ?, ?, ?)";
            PreparedStatement declaracion = conexion.prepareStatement(consulta);
            declaracion.setInt(1, numeroCuenta);
            declaracion.setInt(2, Integer.parseInt(folio));
            declaracion.setString(3, contrasena);
            declaracion.setString(4, "pendiente"); // Estado inicial
            declaracion.setDate(5, new java.sql.Date(System.currentTimeMillis())); // Fecha actual
            declaracion.executeUpdate();
            conexion.close(); // Cerrar conexión
            JOptionPane.showMessageDialog(parentComponent, "Retiro creado correctamente\nFolio: " + folio + "\nContraseña: " + contrasena, "Folio Creado", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
    public static boolean validarFolio(String folio) {
        boolean existe = false;
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            String consulta = "SELECT * FROM retirossincuenta WHERE Folio_de_operacion = ?";
            PreparedStatement declaracion = conexion.prepareStatement(consulta);
            declaracion.setString(1, folio);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                existe = true;
            }
            conexion.close(); // Cerrar conexión
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
        return existe;
    }
    
     public static String obtenerInformacionFolio(String folio) {
        StringBuilder informacion = new StringBuilder();
        try {
            Connection conexion = ConexionBD.obtenerConexion();
            String consulta = "SELECT * FROM retirossincuenta WHERE Folio_de_operacion = ?";
            PreparedStatement declaracion = conexion.prepareStatement(consulta);
            declaracion.setString(1, folio);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                informacion.append("Información del folio ").append(folio).append(":\n");
                informacion.append("Estado: ").append(resultado.getString("ESTADOS")).append("\n"); 
                informacion.append("Fecha: ").append(resultado.getDate("Fecha")).append("\n"); 
            } else {
                informacion.append("No se encontró información para el folio ").append(folio);
            }
            conexion.close(); // Cerrar conexión
        } catch (SQLException e) {
            informacion.append("Error al conectar con la base de datos: ").append(e.getMessage());
        }
        return informacion.toString();
    }
     
     public int obtenerClientePorTelefono(long telefono) {
        String query = "SELECT id_cliente FROM usuarios WHERE telefono = ?";
        try ( Connection conexion = obtenerConexion(); PreparedStatement pstmt = conexion.prepareStatement(query)) {//conectar y mandar la sentencia
            pstmt.setLong(1, telefono);
            try ( ResultSet rs = pstmt.executeQuery()) {//realiza la solicitud
                if (rs.next()) {
                    int idCliente = rs.getInt("id_cliente");
                    return idCliente;
                } else {
                    System.out.println("El cliente no exise"); // Imprimir si el cliente existe
                    return -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Imprimir el stack trace de la excepción
            return -1;
        }
    }
     
     public void agregarCuenta(int id){
         //1. Crear la sentencia SQL que vamos a mandar a la BD
        String sentenciaSQL = "INSERT INTO Cuentas (id_cliente) VALUES (?)";

        //insertar o intentar hacer la inserción en la tabla
        try (  Connection conexion = ConexionBD.obtenerConexion();//  establecemos la conexion con la bd
                //Crear el statement o el comando donde ejecutamos la sentencia
                PreparedStatement ps = conexion.prepareStatement(sentenciaSQL, Statement.RETURN_GENERATED_KEYS); // obtenemos de regreso la llave generada o el ID
                ) {

            //3. mandar los valores
            ps.setInt(1,id);

            //4. Ejecutamos el comando o lo enviamos a la BD
            int registrosModificados = ps.executeUpdate();
            LOG.log(Level.INFO, "Se agregaron con éxito {0} ", registrosModificados);
           
            // obtener el conjunto de resultados que tiene o contiene las llaves generadas durante el registro o inserción
            ResultSet registroGenerado = ps.getGeneratedKeys();

            //nos posicionamos en el primer registro o en el siguiente disponible. 
            registroGenerado.next();
            } catch (Exception e) {
            LOG.log(Level.SEVERE, "No se agregó con éxito", e);
        }
     }
       public void RellenarComboBox(JComboBox combo,String valor,int id){
            String sql= "SELECT numero_cuenta FROM cuentas WHERE id_cliente=?";
         try {Connection conexion = ConexionBD.obtenerConexion();//  establecemos la conexion con la bd
                //Crear el statement o el comando donde ejecutamos la sentencia
                PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"No encontrados"+e.toString());
        }
       }
       
        

     }

