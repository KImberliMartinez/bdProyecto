/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.mycompany.bancodominio.Cuenta;
import com.mycompany.bancodominio.DAO.CuentaDAO;
import com.mycompany.bancodominio.DAO.TransaccionDAO;
import com.mycompany.bancodominio.dtos.UsuarioDTO;
import com.mycompany.banconegocio.controlCuenta;
import com.mycompany.bancopersistencia.ConexionBD;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author delll
 */
public final class AdministrarCuentas extends javax.swing.JFrame {
    private String Tel;
    private int id;
    private CuentaDAO cc;
     private Connection conexion;
   
    /**
     * Creates new form AdministrarCuentas
     */
    public AdministrarCuentas()  {
        initComponents();
        try {
            conexion = ConexionBD.obtenerConexion();
             cc = new CuentaDAO(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        IniciaSesion i= new IniciaSesion();
        Tel=i.usuario;
        
        System.out.println("pantalla admiCuentas"+Tel);
        try {
            id=cc.consultarClientesPortelefono(Tel);
            lista(id);
           
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarCuentas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AdministrarCuentas(Connection conexion) {
        this.conexion = conexion;
    }
    

    public void setTelefono(String Telefono) {
        this.Tel = Telefono;
        txUsuario.setText(Telefono);
    }
      public String getTelefono(){
         String tel=txUsuario.getText();
        return tel ;
    }
    

       public List<Cuenta> lista(int idC) throws SQLException {
        List<Cuenta> lista = new ArrayList<>();
        String query = "SELECT * FROM Cuentas WHERE id_cliente = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(query)) {
            pstmt.setInt(1, idC);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                  int idCuenta= rs.getInt("Numero_cuenta");
                   String fecha= rs.getString("Fecha_de_apertura");
                    int Saldo=rs.getInt("saldo");
                    int cliente=rs.getInt("id_cliente");
                    System.out.println(idCuenta);
                    System.out.println(fecha);
                    System.out.println(Saldo);
                    System.out.println(cliente);
                    Cuenta c=new Cuenta(idCuenta, fecha, Saldo, cliente);
                    lista.add(c);
                }
            }
        }catch(SQLException e){
            Logger.getLogger(AdministrarCuentas.class.getName()).log(Level.SEVERE, null, e);
        }
        return lista;
    }

    public void mostrarRegistros() {
        try {
            List<Cuenta> listaCuentas = lista(id);
             DefaultTableModel modeloTabla =  (DefaultTableModel) this.tCuentas.getModel();
        modeloTabla.setRowCount(0);
        listaCuentas.forEach(cuentas -> {
            Object[] filas = new Object[4];
            filas[0] = cuentas.getNumeroCuenta();
            filas[1] = cuentas.getFechaApertura();
            filas[2] = cuentas.getSaldo();
            filas[3]=cuentas.getIdCliente();
               modeloTabla.addRow(filas);
        });
        } catch (SQLException ex) {
            Logger.getLogger(AdministrarCuentas.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tCuentas = new javax.swing.JTable();
        txUsuario = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cuentas");

        tCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Num de cuenta", "Fecha Apertura", "Saldo actual", "idCliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tCuentas);

        jButton1.setText("Agregar Nueva");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Cancelar.setText("Cancelar una cuenta");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(Cancelar)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(Salir))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Salir)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(Cancelar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        opcionesCliente op= new opcionesCliente();
        op.setVisible(true);
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        CancelarCuenta c= new CancelarCuenta();
        c.setTelefono(Tel);
        c.setVisible(true);
        dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AdministrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                    new AdministrarCuentas().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tCuentas;
    private javax.swing.JLabel txUsuario;
    // End of variables declaration//GEN-END:variables
}
