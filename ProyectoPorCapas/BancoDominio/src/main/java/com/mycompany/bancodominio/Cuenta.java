/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bancodominio;

/**
 *
 * @author ruben
 */
import java.util.Date;

public class Cuenta {
    private int numeroCuenta;
    private String fechaApertura;
    private int saldo;
    private int idCliente;

    public Cuenta(int numeroCuenta, String fechaApertura, int saldo, int idCliente) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Cuenta(int numeroCuenta, String fechaApertura, int saldo) {
        this.numeroCuenta = numeroCuenta;
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
}

