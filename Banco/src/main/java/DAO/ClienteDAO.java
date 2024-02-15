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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarCliente(Cliente cliente) throws SQLException {
        String query = "INSERT INTO Clientes (Nombre, Ap_Paterno, Ap_Materno, Domicilio, Fecha_Nacimiento, Edad) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellidoPaterno());
            pstmt.setString(3, cliente.getApellidoMaterno());
            pstmt.setString(4, cliente.getDomicilio());
            pstmt.setDate(5, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            pstmt.setInt(6, cliente.getEdad());
            pstmt.executeUpdate();
        }
    }

    public List<Cliente> obtenerClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        try (PreparedStatement pstmt = conexion.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("ID_Cliente"));
                cliente.setNombre(rs.getString("Nombre"));
                cliente.setApellidoPaterno(rs.getString("Ap_Paterno"));
                cliente.setApellidoMaterno(rs.getString("Ap_Materno"));
                cliente.setDomicilio(rs.getString("Domicilio"));
                cliente.setFechaNacimiento(rs.getDate("Fecha_Nacimiento"));
                cliente.setEdad(rs.getInt("Edad"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Otros métodos para actualizar, eliminar clientes, etc.
}

