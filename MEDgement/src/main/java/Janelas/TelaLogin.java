/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Janelas;

import DAO.UsuarioDAO;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author michel.matos
 */
public class TelaLogin extends javax.swing.JFrame {

    /**
     * Creates new form TelaLogin
     */
    public TelaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        UIManager.put("OptionPane.cancelButtonText", "Cancelar"); 
        UIManager.put("OptionPane.noButtonText", "Não"); 
        UIManager.put("OptionPane.yesButtonText", "Sim");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        caixaLogin = new javax.swing.JLabel();
        caixaUsuario = new javax.swing.JLabel();
        caixaInsUsuario = new javax.swing.JTextField();
        caixaSenha = new javax.swing.JLabel();
        caixaInsSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botaoEntrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 550));

        caixaLogin.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        caixaLogin.setText("LOGIN");

        caixaUsuario.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaUsuario.setText("Usuário");

        caixaInsUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caixaInsUsuarioKeyPressed(evt);
            }
        });

        caixaSenha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        caixaSenha.setText("Senha");

        caixaInsSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                caixaInsSenhaKeyPressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/300.png"))); // NOI18N

        botaoEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Login.png"))); // NOI18N
        botaoEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoEntrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botaoEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botaoEntrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(caixaUsuario)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(caixaInsUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(caixaLogin)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(caixaSenha)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(caixaInsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(botaoEntrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jLabel1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(caixaLogin)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixaUsuario)
                            .addComponent(caixaInsUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixaSenha)
                            .addComponent(caixaInsSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(botaoEntrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel2)))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void caixaInsSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaInsSenhaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            UsuarioDAO dao = new UsuarioDAO();

            if (dao.checarLogin(caixaInsUsuario.getText(), caixaInsSenha.getText())) {
                this.dispose();

                TelaInicial inicio = new TelaInicial(caixaInsUsuario.getText());
                inicio.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Verificar código do usuário ou senha!");
            }
        }
    }//GEN-LAST:event_caixaInsSenhaKeyPressed

    private void caixaInsUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caixaInsUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            caixaInsSenha.requestFocus();
        }
    }//GEN-LAST:event_caixaInsUsuarioKeyPressed

    private void botaoEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEntrarMouseEntered
        // TODO add your handling code here:
        this.setCursor(Cursor.HAND_CURSOR);
    }//GEN-LAST:event_botaoEntrarMouseEntered

    private void botaoEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEntrarMouseExited
        // TODO add your handling code here:
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_botaoEntrarMouseExited

    private void botaoEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoEntrarMouseClicked
        // TODO add your handling code here:
        UsuarioDAO dao = new UsuarioDAO();

        if (dao.checarLogin(caixaInsUsuario.getText(), caixaInsSenha.getText())) {
            this.dispose();

            TelaInicial inicio = new TelaInicial(caixaInsUsuario.getText());
            inicio.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Verificar código do usuário ou senha!");
        }
    }//GEN-LAST:event_botaoEntrarMouseClicked

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
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botaoEntrar;
    private javax.swing.JPasswordField caixaInsSenha;
    private javax.swing.JTextField caixaInsUsuario;
    private javax.swing.JLabel caixaLogin;
    private javax.swing.JLabel caixaSenha;
    private javax.swing.JLabel caixaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
