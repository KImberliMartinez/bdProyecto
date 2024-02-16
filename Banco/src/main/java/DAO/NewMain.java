/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Dominio.Cliente;

/**
 *
 * @author delll
 */
public class NewMain {
        ClienteDAO cliente;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        Cliente c=new Cliente("a", "a", "a", "a", "2000-05-15");
        cliente.agregarCliente(cliente);
    }
    
}
