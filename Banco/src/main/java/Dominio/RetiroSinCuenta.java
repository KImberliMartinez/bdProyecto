/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author ruben
 */
import java.util.Date;

public class RetiroSinCuenta {

    private int idRetiroSinCuenta;
    private int numeroCuenta;
    private int folioOperacion;
    private String estado;
    private String contrasena;
    private Date fecha;

    public RetiroSinCuenta(int idRetiroSinCuenta, int numeroCuenta, int folioOperacion, String estado, String contrasena, Date fecha) {
        this.idRetiroSinCuenta = idRetiroSinCuenta;
        this.numeroCuenta = numeroCuenta;
        this.folioOperacion = folioOperacion;
        this.estado = estado;
        this.contrasena = contrasena;
        this.fecha = fecha;
    }

    
}
