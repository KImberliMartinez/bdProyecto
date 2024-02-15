/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author ruben
 */
import Dominio.Cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CuentaDAO {
    private Connection conexion;

    public CuentaDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void agregarCuenta(Cuenta cuenta) throws SQLException {
    }

    public List<Cuenta> obtenerCuentas() throws SQLException {

        return null;
        
    }
}

