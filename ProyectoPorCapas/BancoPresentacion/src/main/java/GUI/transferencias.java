/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mycompany.bancodominio.DAO.CuentaDAO;
import com.mycompany.bancodominio.DAO.TransaccionDAO;
import com.mycompany.banconegocio.SesionUsuario;
import com.mycompany.banconegocio.controlCuenta;
import com.mycompany.bancopersistencia.ConexionBD;
import java.awt.Dimension;
import java.awt.Toolkit;
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
    private int id;
    controlCuenta c;

    public transferencias(TransaccionDAO transaccionDAO, int saldoDisponible) {
        this.transaccionDAO = transaccionDAO;

        initComponents();

    }

    // int numCuentaOrigen = Integer.parseInt(NumCuentaOrigen.getText());
    // int saldoDisponibleActualizado = obtenerSaldoDisponible(numCuentaOrigen);
    // saldoDisponibleA = saldoDisponibleActualizado
    public transferencias() {
        initComponents();
        centraVentana();
        c = new controlCuenta(conexion);
        SesionUsuario sesionUsuario = SesionUsuario.getInstancia();
        id = c.obtenerClientePorTelefono(sesionUsuario.getTelefono());
        c.RellenarComboBox(ComboBox1, "numero_cuenta", id);
        try {

            conexion = ConexionBD.obtenerConexion();
            transaccionDAO = new TransaccionDAO(conexion);
            saldoDisponible.setText(Integer.toString(saldoDisponibleA));

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos");
        }

    }

    public void actualizar() {
        String datoSeleccionado = (String) ComboBox1.getSelectedItem();//selecionar la cuenta
        int dato = Integer.parseInt(datoSeleccionado);
        NumCuentaOrigen.setText(datoSeleccionado); //mandar el num de cuenta al txt de cuenta origien
        String saldo = String.valueOf(c.obtenerSaldoDisponible(dato));
        saldoDisponible.setText(saldo);//mandar el saldo disponible al label
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
        NumCuentaOrigen = new javax.swing.JTextField();
        ComboBox1 = new javax.swing.JComboBox<>();
        Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cantidad a transferir:");

        cantidadATrasnferir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadATrasnferirKeyTyped(evt);
            }
        });

        jLabel2.setText("Cuenta a la que se transferira:");

        cuentaQueSeTransferira.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cuentaQueSeTransferiraKeyTyped(evt);
            }
        });

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
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        jLabel5.setText("No.cuenta origen:");

        NumCuentaOrigen.setEditable(false);
        NumCuentaOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumCuentaOrigenActionPerformed(evt);
            }
        });

        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(saldoDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cantidadATrasnferir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cuentaQueSeTransferira, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NumCuentaOrigen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(botonRealizar)
                        .addGap(18, 18, 18)
                        .addComponent(Cancelar)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(botonSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoDisponible, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cantidadATrasnferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(NumCuentaOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cuentaQueSeTransferira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonRealizar)
                    .addComponent(Cancelar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void limpiar() {
        cantidadATrasnferir.setText("");
        cuentaQueSeTransferira.setText("");
        NumCuentaOrigen.setText("");
        cantidadATrasnferir.requestFocus();
    }
    private void botonRealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRealizarActionPerformed
        String palabra1 = cantidadATrasnferir.getText();
        int cantidad = Integer.parseInt(palabra1);
        String palabra2 = NumCuentaOrigen.getText();
        String palabra3 = cuentaQueSeTransferira.getText();
        if (palabra1.isEmpty() || palabra2.isEmpty() || palabra3.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos");
        } else {
            if (cantidad < 1 || cantidad > 10000) {
                JOptionPane.showMessageDialog(this, "No es posible realizar este deposito", "Cantidad no permitida", JOptionPane.INFORMATION_MESSAGE);

            }
            realizarTransferencia();
        }

    }//GEN-LAST:event_botonRealizarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        opcionesCliente op = new opcionesCliente();
        op.setVisible(true);
        this.setVisible(false);
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void NumCuentaOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumCuentaOrigenActionPerformed
        // TODO add your handling code here:
        //  this.saldoDisponibleA = obtenerSaldoDisponible();


    }//GEN-LAST:event_NumCuentaOrigenActionPerformed

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        // TODO add your handling code here:
        //actualizar();
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_CancelarActionPerformed

    private void cantidadATrasnferirKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadATrasnferirKeyTyped
        // TODO add your handling code here:
        if (cantidadATrasnferir.getText().length() >= 10) {
            evt.consume();
        }
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (cantidadATrasnferir.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_cantidadATrasnferirKeyTyped

    private void cuentaQueSeTransferiraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cuentaQueSeTransferiraKeyTyped
        // TODO add your handling code here:
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }
    }//GEN-LAST:event_cuentaQueSeTransferiraKeyTyped
    private void centraVentana() {
        //Obtiene el tamaño de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Obtiene el tamaño de la ventana de la aplicación
        Dimension frameSize = getSize();

        // Se asegura que el tamaño de la ventana de la aplicación
        // no exceda el tamaño de la pantalla
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        // Centra la ventana de la aplicación sobre la pantalla
        setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }

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
        int numCuentaOrigen = Integer.parseInt(NumCuentaOrigen.getText());
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
            // Verificar que no se pueda transferir dinero a el mismo
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
    private javax.swing.JButton Cancelar;
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JTextField NumCuentaOrigen;
    private javax.swing.JButton botonRealizar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField cantidadATrasnferir;
    private javax.swing.JTextField cuentaQueSeTransferira;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel saldoDisponible;
    // End of variables declaration//GEN-END:variables
}
