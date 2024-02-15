/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.dtos;

import java.util.Date;

/**
 *
 * @author delll
 */
public class RetiroSinCuentaDTO {
    private int numeroCuenta;
    private int folioOperacion;
    private String estado;
    private String contrasena;
    private Date fecha;

    public RetiroSinCuentaDTO(int numeroCuenta, int folioOperacion, String estado, String contrasena, Date fecha) {
        this.numeroCuenta = numeroCuenta;
        this.folioOperacion = folioOperacion;
        this.estado = estado;
        this.contrasena = contrasena;
        this.fecha = fecha;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getFolioOperacion() {
        return folioOperacion;
    }

    public void setFolioOperacion(int folioOperacion) {
        this.folioOperacion = folioOperacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "RetiroSinCuentaDTO{" + "numeroCuenta=" + numeroCuenta + ", folioOperacion=" + folioOperacion + ", estado=" + estado + ", contrasena=" + contrasena + ", fecha=" + fecha + '}';
    }
    
}
