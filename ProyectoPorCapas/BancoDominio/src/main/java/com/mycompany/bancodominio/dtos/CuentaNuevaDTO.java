/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bancodominio.dtos;

import java.util.Date;

/**
 *
 * @author delll
 */
public class CuentaNuevaDTO {

    private Date fechaApertura;
    private int saldo;
    private int idCliente;

    public CuentaNuevaDTO(Date fechaApertura, int saldo, int idCliente) {
        this.fechaApertura = fechaApertura;
        this.saldo = saldo;
        this.idCliente = idCliente;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
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

    @Override
    public String toString() {
        return "CuentaNuevaDTO{" + "fechaApertura=" + fechaApertura + ", saldo=" + saldo + ", idCliente=" + idCliente + '}';
    }
    
}
