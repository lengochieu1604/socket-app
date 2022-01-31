/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doangiuaky.PlayFair;

import doangiuaky.AES.Menu.MainMenu;
import doangiuaky.component.playfairCipherDecryption;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author PC 21H1 OS 19043.928
 */
public class PF_Client extends javax.swing.JFrame {
 
    Socket socket;
    DataInputStream din;
    DataOutputStream dout;    
    public static final int port_PF = 8001;


    /**
     * Creates new form client
     */
    public PF_Client() {
        initComponents();
//        setLocationRelativeTo(this); 

    }
    //MÃ HÓA VÀ GIẢI MÃ PLAYFAIR
    //------------------------------------------------------------------------------------
   

    //------------------------------------------------------------------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDecryptPlayFair = new javax.swing.JTextField();
        DecryptPlayerFair = new javax.swing.JButton();
        txtPlainTextPlayFair = new javax.swing.JTextField();
        txtKeyPlayFair = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtEncryptPlayFair = new javax.swing.JTextField();
        btnEncryptPlayFair = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lblNumber = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaNumberViTri = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtSubString = new javax.swing.JTextField();
        DecryptPlayerFair1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("PlainText");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Key");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("MÃ HÓA VÀ GIẢI MÃ PLAYFAIR");

        txtDecryptPlayFair.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        DecryptPlayerFair.setBackground(new java.awt.Color(102, 102, 255));
        DecryptPlayerFair.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DecryptPlayerFair.setForeground(new java.awt.Color(0, 0, 255));
        DecryptPlayerFair.setText("Decrypt");

        txtPlainTextPlayFair.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        txtKeyPlayFair.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        jLabel4.setText("Encypt");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Decrypt");

        txtEncryptPlayFair.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtEncryptPlayFair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEncryptPlayFairActionPerformed(evt);
            }
        });

        btnEncryptPlayFair.setBackground(new java.awt.Color(255, 204, 102));
        btnEncryptPlayFair.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnEncryptPlayFair.setForeground(new java.awt.Color(255, 102, 0));
        btnEncryptPlayFair.setText("Encrypt");
        btnEncryptPlayFair.setToolTipText("");
        btnEncryptPlayFair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptPlayFairActionPerformed(evt);
            }
        });

        lblNumber.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblNumber.setForeground(new java.awt.Color(0, 204, 0));
        lblNumber.setText("Các vị trí xuất hiện của SubString");

        txtAreaNumberViTri.setColumns(20);
        txtAreaNumberViTri.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtAreaNumberViTri.setRows(5);
        jScrollPane1.setViewportView(txtAreaNumberViTri);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("SubString");

        txtSubString.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        DecryptPlayerFair1.setBackground(new java.awt.Color(102, 102, 255));
        DecryptPlayerFair1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        DecryptPlayerFair1.setForeground(new java.awt.Color(0, 0, 255));
        DecryptPlayerFair1.setText("Back");
        DecryptPlayerFair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DecryptPlayerFair1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(244, 244, 244)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(btnEncryptPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(100, 100, 100)
                                                    .addComponent(DecryptPlayerFair, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(txtDecryptPlayFair))
                                            .addComponent(txtEncryptPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtKeyPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)))
                                .addGap(180, 180, 180)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DecryptPlayerFair1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(644, 644, 644))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtPlainTextPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSubString, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(602, 602, 602))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPlainTextPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubString, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKeyPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEncryptPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DecryptPlayerFair, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEncryptPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DecryptPlayerFair1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDecryptPlayFair, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEncryptPlayFairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptPlayFairActionPerformed
        // TODO add your handling code here:
        playfairCipherDecryption x = new playfairCipherDecryption();
        String plainText = x.xoaTrang(txtPlainTextPlayFair.getText()); 
        String keyPlayfair = x.xoaTrang(txtKeyPlayFair.getText()); 
        String subString = x.xoaTrang(txtSubString.getText());  
        try {
            socket = new Socket("localhost", port_PF);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

            //XỬ LÝ 
            x.setKey(keyPlayfair);
            x.KeyGen();  
            
            if (plainText.length() % 2 != 0) { 
                plainText+="x";
            }
            if (plainText.length() % 2 == 0) {
                System.out.println("Encryption: " + x.encryptMessage(plainText));
                System.out.println("Decryption: " + x.decryptMessage(x.encryptMessage(plainText))); 
            }
            
            String encryptedClient = x.encryptMessage(plainText);
            String decryptedClient = x.decryptMessage(encryptedClient);
            System.out.println("encryptedClient :"+encryptedClient);
            System.out.println("decryptedClient :"+decryptedClient);
            
            System.out.println("plainText :"+plainText);
            System.out.println("key       :"+keyPlayfair);

            //GỮI DỮ LIỆU LÊN SERVER
            dout.writeUTF(keyPlayfair);
            dout.writeUTF(encryptedClient);
            dout.writeUTF(subString);
            
            
            //ĐỌC DỮ LIỆU TỪ SERVER 
            String decryptedServer = din.readUTF();
            System.out.println("decryptedServer :" + decryptedServer); 
            String cacViTriChuoiCon = din.readUTF();

            txtEncryptPlayFair.setText(encryptedClient);
            txtDecryptPlayFair.setText(decryptedServer); 
            txtAreaNumberViTri.setText(cacViTriChuoiCon);
            
            socket.close();
        } catch (Exception io) {

        }
    }//GEN-LAST:event_btnEncryptPlayFairActionPerformed

    private void txtEncryptPlayFairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEncryptPlayFairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEncryptPlayFairActionPerformed

    private void DecryptPlayerFair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DecryptPlayerFair1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_DecryptPlayerFair1ActionPerformed

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
            java.util.logging.Logger.getLogger(PF_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PF_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PF_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PF_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PF_Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DecryptPlayerFair;
    private javax.swing.JButton DecryptPlayerFair1;
    private javax.swing.JButton btnEncryptPlayFair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblNumber;
    private javax.swing.JTextArea txtAreaNumberViTri;
    private javax.swing.JTextField txtDecryptPlayFair;
    private javax.swing.JTextField txtEncryptPlayFair;
    private javax.swing.JTextField txtKeyPlayFair;
    private javax.swing.JTextField txtPlainTextPlayFair;
    private javax.swing.JTextField txtSubString;
    // End of variables declaration//GEN-END:variables
}