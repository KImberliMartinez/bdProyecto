/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.Random;

/**
 *
 * @author ruben
 */
public class ServiciosBanco {
    public int generarNumeroFolioConsecutivo() {
        Random random = new Random();
        return random.nextInt(1000000); 
    }

    public String generarContraseniaAleatoria() {
        Random random = new Random();
        int contraseniaNumerica = 10000000 + random.nextInt(90000000); // Número aleatorio de 8 dígitos
        return String.valueOf(contraseniaNumerica);
    }
}
