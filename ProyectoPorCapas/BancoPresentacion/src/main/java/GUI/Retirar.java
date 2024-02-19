/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mycompany.bancodominio.DAO.CuentaDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author delll
 */
public class Retirar extends javax.swing.JFrame {
private Connection conexion;
    /**
     * Creates new form Retirar
     */
    public Retirar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        botonRetirarDinero = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        montoDineroARetirar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Monto a retirar");

        botonRetirarDinero.setText("Retirar dinero");
        botonRetirarDinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRetirarDineroActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonRetirarDinero)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(montoDineroARetirar)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(botonSalir)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(montoDineroARetirar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addComponent(botonRetirarDinero)
                .addGap(27, 27, 27)
                .addComponent(botonSalir)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     private int obtenerSaldoDisponible(int numeroCuenta) throws SQLException {
        // Creamos una instancia de CuentaDAO utilizando la conexión a la base de datos
        CuentaDAO cuentaDAO = new CuentaDAO(conexion);

        // Llamamos al método obtenerSaldo de CuentaDAO para obtener el saldo de la cuenta
        int saldoTotal = cuentaDAO.obtenerSaldo(numeroCuenta);

        // Retornamos el saldo obtenido
        return saldoTotal;
    }
    
    private void botonRetirarDineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRetirarDineroActionPerformed
         double montoARetirar = Double.parseDouble(montoDineroARetirar.getText());

        // Obtener el saldo actual del cliente desde la base de datos
        double saldoActual = obtenerSaldoDisponible();

        if (saldoActual >= montoARetirar) {
            // Permitir el retiro
            double nuevoSaldo = saldoActual - montoARetirar;
            // Actualizar el saldo en la base de datos
            actualizarSaldoClienteEnBD(nuevoSaldo);
            JOptionPane.showMessageDialog(this, "Retiro exitoso. Nuevo saldo: " + nuevoSaldo);
        } else {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(this, "Fondos insuficientes para realizar el retiro.");
        }
    }//GEN-LAST:event_botonRetirarDineroActionPerformed

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
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Retirar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonRetirarDinero;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField montoDineroARetirar;
    // End of variables declaration//GEN-END:variables
}
