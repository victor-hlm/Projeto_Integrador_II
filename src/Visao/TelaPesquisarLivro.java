/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author CyberOrangotango
 */
public class TelaPesquisarLivro extends javax.swing.JFrame {

    /**
     * Creates new form TelaPesquisarLivro
     */
    public TelaPesquisarLivro() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        livro = new javax.swing.JTextField();
        voltar = new javax.swing.JButton();
        consultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisar Livro");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Título:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        livro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                livroActionPerformed(evt);
            }
        });
        getContentPane().add(livro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 200, -1));

        voltar.setText("Voltar");
        voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarActionPerformed(evt);
            }
        });
        getContentPane().add(voltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        getContentPane().add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void livroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_livroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_livroActionPerformed

    private void voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_voltarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed

        //Emprestimo model = new Emprestimo();
        //TelaCadastroEmprestimo TCE = new TelaCadastroEmprestimo();

        if ( (livro.getText().equals("")) ){

            JOptionPane.showMessageDialog(null, "Preencha novamente todos os campos!!");
        }
        else{

            String autor = null, titulo = null, isbn = null, 
                   editora = null, volume = null, quantidade = null, status = null;

            String L = livro.getText();
            String url = "jdbc:mysql://localhost/db_livros";
            String sql = "SELECT * FROM livro WHERE titulo = '"+L+"'";

            try{

                Connection conexao = DriverManager.getConnection(url, "root","");

                PreparedStatement pesquisa = conexao.prepareStatement(sql);

                ResultSet resultado = pesquisa.executeQuery();

                while (resultado.next()) {

                    autor  = resultado.getString("autor");
                    titulo = resultado.getString("titulo");
                    isbn = resultado.getString("isbn");
                    editora = resultado.getString("editora");
                    volume = resultado.getString("volume");
                    quantidade = resultado.getString("quantidade");
                    status = resultado.getString("status");
                }

                JOptionPane.showMessageDialog(null, "Livro encontrado com sucesso!\n"+
                    "----------------------------\n"+
                    "Autor: "+autor+"\n"+
                    "Título: "+titulo+"\n"+
                    "ISBN: "+isbn+"\n"+
                    "Editor: "+editora+"\n"+
                    "Volume: "+volume+"\n"+
                    "Quantidade: "+quantidade+"\n"+
                    "Status: "+status+"\n"+
                    "----------------------------");
            }

            catch(Exception erro){

                JOptionPane.showMessageDialog(null,"Erro na Conexão com Banco de Dados: "+erro);
            }
        }
    }//GEN-LAST:event_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPesquisarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPesquisarLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPesquisarLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField livro;
    private javax.swing.JButton voltar;
    // End of variables declaration//GEN-END:variables
}
