/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.unipar.manipulacao.arquivos.telas;

import br.unipar.manipulacao.arquivos.dao.PessoaDAO;
import br.unipar.manipulacao.arquivos.dao.PessoaDAOImp;
import br.unipar.manipulacao.arquivos.model.Pessoa;
import br.unipar.manipulacao.arquivos.utils.EntityManagerUtil;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucia
 */
public class ExportarArquivoFrame extends javax.swing.JFrame {

    /**
     * Creates new form ExportarArquivoFrame
     */
    public ExportarArquivoFrame() {
        initComponents();
        atualizarLista();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criar Arquivo CSV");

        jButton1.setText("Exportar Arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(52, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PessoaDAO pessoaDAO = new PessoaDAOImp(EntityManagerUtil.getManager());
        List<Pessoa> pessoas = pessoaDAO.findAll();
        
        File d = new File("C:\\CSVPessoa");

        d.mkdir();

        if (!d.exists()) {
            d.mkdir();
        }

        File tabuada = new File("C:\\CSVPessoa\\pessoa.csv");

        try {
            // Criação do arquivo
            if (tabuada.exists()) {
                System.out.println("O arquivo já existe. Será excluído.");
                tabuada.delete();
            }
            tabuada.createNewFile();

            // Escrita da tabuada no arquivo
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tabuada))) {
                for (Pessoa pessoa : pessoas) {
                    // Escrever o cabeçalho
                    writer.write("Id,Nome,Idade,CPF,RG,Data de Nascimento,Sexo,Signo,Mãe,Pai,Email,Senha,CEP,Endereço,Número,Bairro,Cidade,Estado,Telefone Fixo,Celular,Altura,Peso,Tipo Sanguíneo,Cor");
                    writer.newLine();

                    // Escrever os dados da pessoa
                    writer.write(
                            pessoa.getId() + ","
                            + pessoa.getNome() + ","
                            + pessoa.getIdade() + ","
                            + pessoa.getCpf() + ","
                            + pessoa.getRg() + ","
                            + pessoa.getData_nasc() + ","
                            + pessoa.getSexo() + ","
                            + pessoa.getSigno() + ","
                            + pessoa.getMae() + ","
                            + pessoa.getPai() + ","
                            + pessoa.getEmail() + ","
                            + pessoa.getSenha() + ","
                            + pessoa.getCep() + ","
                            + pessoa.getEndereco() + ","
                            + pessoa.getNumero() + ","
                            + pessoa.getBairro() + ","
                            + pessoa.getCidade() + ","
                            + pessoa.getEstado() + ","
                            + pessoa.getTelefone_fixo() + ","
                            + pessoa.getCelular() + ","
                            + pessoa.getAltura() + ","
                            + pessoa.getPeso() + ","
                            + pessoa.getTipo_sanguineo() + ","
                            + pessoa.getCor()
                    );
                    writer.newLine();

                }
                JOptionPane.showMessageDialog(null, "Arquivo exportado com sucesso! Verifique o caminho:" + d);
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "erro ao escrever as pessoas");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(ExportarArquivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportarArquivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportarArquivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportarArquivoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new ExportarArquivoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void atualizarLista() {
            PessoaDAO pessoaDAO = new PessoaDAOImp(EntityManagerUtil.getManager());
            List<Pessoa> pessoas = pessoaDAO.findAll();
            
            for(Pessoa pessoa : pessoas){
               jTextArea1.append(pessoa.toString()); 
            }
                   
        }
    @Override
        public void dispose() {
            super.dispose();
        }
}
