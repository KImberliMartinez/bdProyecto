/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banconegocio;

/**
 *
 * @author ruben
 */
public class SesionUsuario {
    private static SesionUsuario instancia;
  
    private long telefono;
    private int numeroCuenta;

    private SesionUsuario() {
    }

    public static SesionUsuario getInstancia() {
        if (instancia == null) {
            instancia = new SesionUsuario();
        }
        return instancia;
    }

    public void iniciarSesion(long telefono, int numeroCuenta) {
       
        this.telefono = telefono;
        this.numeroCuenta = numeroCuenta;
        // Aquí puedes cargar otros datos del usuario si lo deseas, por ejemplo, desde la base de datos
    }

    public void cerrarSesion() {
        // Limpiar los datos de la sesión al cerrar sesión
        this.telefono = 0;
        this.numeroCuenta = 0;
        // Otros datos se pueden limpiar aquí si es necesario
    }

    // Métodos para acceder a los datos del usuario
    public long getTelefono() {
        return telefono;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

}
