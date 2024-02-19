/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio.DAO;

/**
 *
 * @author ruben
 */
import com.mycompany.bancodominio.dtos.CuentaNuevaDTO;
import com.mycompany.bancodominio.dtos.UsuarioDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CuentaDAO {
    private Connection conexion;

    public CuentaDAO(Connection conexion) {
        this.conexion = conexion;
    }
    private static final Logger LOG = Logger.getLogger(CuentaDAO.class.getName());

    public int obtenerSaldo(int numeroCuenta) throws SQLException {
        String query = "SELECT Saldo FROM Cuentas WHERE Numero_Cuenta = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, numeroCuenta);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Saldo");
                }
            }
        }
        return -1; // Retornar un valor negativo si no se encuentra la cuenta
    }

    public boolean actualizarSaldo(int numeroCuenta, int nuevoSaldo) throws SQLException {
        String query = "UPDATE Cuentas SET Saldo = ? WHERE Numero_Cuenta = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, nuevoSaldo);
            pstmt.setInt(2, numeroCuenta);
            int filasActualizadas = pstmt.executeUpdate();
            return filasActualizadas > 0;
        }
    }
    
    public boolean verificarExistenciaCuenta(int numeroCuenta) throws SQLException {
    String query = "SELECT COUNT(*) AS cuenta FROM Cuentas WHERE Numero_Cuenta = ?";
    try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
        pstmt.setInt(1, numeroCuenta);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int cuenta = rs.getInt("cuenta");
                return cuenta > 0;
            }
        }
    }
    return false; // Retornar false si no se encuentra la cuenta
}
    
     public int consultarClientesPortelefono(String telefono) throws SQLException{
         int ids = 0;
        String sql = "SELECT id_cliente FROM usuarios  WHERE telefono = ?";
        try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setString(1,telefono);
            // Ejecutamos la llamada al procedimiento almacenado
          //  pstmt.executeUpdate();
              try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                int cliente = rs.getInt("id_cliente");
               
                return cliente;
                //System.out.println(cliente); 
            }
        }catch(SQLException e){
                  System.out.println("no fue posible realizar esta accion");   
        }
          
        }
    return 8;
    }
//     
//      public List<Cuenta> lista(int idC) throws SQLException {
//        List<Cuenta> lista = new ArrayList<>();
//        String query = "SELECT * FROM Cuentas WHERE id_cliente = ?";
//        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
//            pstmt.setInt(1, idC);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                  int idCuenta= rs.getInt("Numero_cuenta");
//                   String fecha= rs.getString("Fecha_de_apertura");
//                    int Saldo=rs.getInt("saldo");
//                    int cliente=rs.getInt("id_cliente");
//                    System.out.println(idCuenta);
//                    System.out.println(fecha);
//                    System.out.println(Saldo);
//                    System.out.println(cliente);
//                    Cuenta c=new Cuenta(idCuenta, fecha, Saldo, cliente);
//                    lista.add(c);
//                }
//            }
//        }catch(SQLException e){
//            Logger.getLogger(AdministrarCuentas.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return lista;
//    }
//
//    public void mostrarRegistros(int idCliente) { 
//        String query = "SELECT * FROM Cuentas WHERE id_cliente = ?";
//        DefaultTableModel modeloTabla =  (DefaultTableModel) this.tabla.getModel();
//        modeloTabla.addColumn("Numero cuenta");
//         modeloTabla.addColumn("Fecha Apertura");
//         modeloTabla.addColumn("Saldo");
//         modeloTabla.addColumn("Id_cliente");
//         tabla.setModel(modeloTabla);
//       
//         Object []datos=new Object[4];
//         
//          try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
//            pstmt.setInt(1,idCliente);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while  (rs.next()) {
//                  datos[0]= rs.getInt("Numero_cuenta");
//                   datos[1]= rs.getString("Fecha_de_apertura");
//                   datos[3]=rs.getInt("saldo");
//                    datos[4]=rs.getInt("id_cliente");
//                    modeloTabla.addRow(datos);
//       
//                    }
//            }       
//                }catch(SQLException e){
//            Logger.getLogger(AdministrarCuentas.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
    public void AgregarCuentaNueva(CuentaNuevaDTO a){
        // Definimos la llamada al procedimiento almacenado
        String sql = "INSERT INTO  cuentas (id_cliente) VALUES(?)";
        
         try ( PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            // Asignamos los valores a los parámetros del procedimiento almacenado
            pstmt.setInt(1, a.getIdCliente());

            // Ejecutamos la llamada al procedimiento almacenado
            pstmt.executeUpdate();
          LOG.log(Level.INFO,"Cuenta agregada con exito");
        }catch(SQLException e){
           LOG.log(Level.SEVERE," no agregados",e);

        }

    }

}


