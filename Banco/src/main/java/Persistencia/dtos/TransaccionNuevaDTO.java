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
public class TransaccionNuevaDTO {
    
    private Date fecha;
    private int monto;
    private int numeroCuentaDestino;

    public TransaccionNuevaDTO(Date fecha, int monto, int numeroCuentaDestino) {
        this.fecha = fecha;
        this.monto = monto;
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getNumeroCuentaDestino() {
        return numeroCuentaDestino;
    }

    public void setNumeroCuentaDestino(int numeroCuentaDestino) {
        this.numeroCuentaDestino = numeroCuentaDestino;
    }

    @Override
    public String toString() {
        return "TransaccionNuevaDTO{" + "fecha=" + fecha + ", monto=" + monto + ", numeroCuentaDestino=" + numeroCuentaDestino + '}';
    }
    
}
