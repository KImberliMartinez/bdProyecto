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
public class ClienteNuevoDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String fechaNacimiento;
    private String telefono;
    private String contra;


//    public ClienteNuevoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String fechaNacimiento, int edad) {
//        this.nombre = nombre;
//        this.apellidoPaterno = apellidoPaterno;
//        this.apellidoMaterno = apellidoMaterno;
//        this.domicilio = domicilio;
//        this.fechaNacimiento = fechaNacimiento;
//       
//    }

    public ClienteNuevoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
    }

    public ClienteNuevoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String fechaNacimiento, String telefono, String contra) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.contra = contra;
    }

   

   

    public ClienteNuevoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

 

    @Override
    public String toString() {
        return "ClienteNuevoDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", domicilio=" + domicilio + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
}

