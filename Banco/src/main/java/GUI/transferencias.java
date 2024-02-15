/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CuentaDAO;
import DAO.TransaccionDAO;
import Persistencia.ConexionBD;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author delll
 */
public class transferencias extends javax.swing.JFrame {

    private TransaccionDAO transaccionDAO;
    private int saldoDisponibleA;
    private Connection conexion;

    public transferencias(TransaccionDAO transaccionDAO, int saldoDisponible) {
        this.transaccionDAO = transaccionDAO;
        this.saldoDisponibleA = saldoDisponible;

        initComponents();

    }

    public transferencias() {
        initComponents();
        try {
            conexion = ConexionBD.obtenerConexion();
            transaccionDAO = new TransaccionDAO(conexion);

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cantidadATrasnferir = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cuentaQueSeTransferira = new javax.swing.JTextField();
        saldoDisponible = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonRealizar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad a transferir:");

        jLabel2.setText("Cuenta a la que se transferira:");

        saldoDisponible.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        saldoDisponible.setText("2000");

        jLabel4.setText("Saldo disponible");

        botonRealizar.setText("Realizar");
        botonRealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRealizarActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");

        jLabel5.setText("No.cuenta origen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuentaQueSeTransferira, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantidadATrasnferir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(saldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(botonRealizar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(botonSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cantidadATrasnferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cuentaQueSeTransferira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonRealizar)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarActionPerformed
        realizarTransferencia();
    }//GEN-LAST:event_botonRealizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transferencias().setVisible(true);
            }
        });
    }

    private void realizarTransferencia() {
        int cantidadTransferir = Integer.parseInt(cantidadATrasnferir.getText());
        int numCuentaOrigen = Integer.parseInt(jTextField3.getText());
        int cuentaDestino = Integer.parseInt(cuentaQueSeTransferira.getText());
        CuentaDAO cuentaDAO = new CuentaDAO(conexion);
        try {
            // Verificar la existencia de la cuenta de origen
            if (!cuentaDAO.verificarExistenciaCuenta(numCuentaOrigen)) {
                JOptionPane.showMessageDialog(this, "La cuenta de origen no existe");
                return;
            }

            // Verificar la existencia de la cuenta de destino
            if (!cuentaDAO.verificarExistenciaCuenta(cuentaDestino)) {
                JOptionPane.showMessageDialog(this, "La cuenta de destino no existe");
                return;
            }

            if (numCuentaOrigen == cuentaDestino) {
                JOptionPane.showMessageDialog(this, "No puedes transferir dinero a tu propia cuenta bancaria");
                return;
            }

            // Obtener el saldo disponible actualizado desde la base de datos
            int saldoDisponibleActualizado = obtenerSaldoDisponible(numCuentaOrigen);

            // Verificar si la cantidad a transferir excede el saldo disponible
            if (cantidadTransferir > saldoDisponibleActualizado) {
                JOptionPane.showMessageDialog(this, "La cantidad a transferir excede el saldo disponible");
                return;
            }

            // Realizar la transferencia de dinero utilizando el DAO correspondiente
            transaccionDAO.transferirDinero(numCuentaOrigen, cuentaDestino, cantidadTransferir);
            JOptionPane.showMessageDialog(this, "Transferencia exitosa");

            // Actualizar el saldo disponible en la interfaz gráfica
            saldoDisponibleA = saldoDisponibleActualizado - cantidadTransferir;
            saldoDisponible.setText(Integer.toString(saldoDisponibleA));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar la transferencia: " + ex.getMessage());
            ex.printStackTrace(); // Manejo del error
        }
    }

    private int obtenerSaldoDisponible(int numeroCuenta) throws SQLException {
        // Creamos una instancia de CuentaDAO utilizando la conexión a la base de datos
        CuentaDAO cuentaDAO = new CuentaDAO(conexion);

        // Llamamos al método obtenerSaldo de CuentaDAO para obtener el saldo de la cuenta
        int saldoTotal = cuentaDAO.obtenerSaldo(numeroCuenta);

        // Retornamos el saldo obtenido
        return saldoTotal;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRealizar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField cantidadATrasnferir;
    private javax.swing.JTextField cuentaQueSeTransferira;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel saldoDisponible;
    // End of variables declaration//GEN-END:variables
}
