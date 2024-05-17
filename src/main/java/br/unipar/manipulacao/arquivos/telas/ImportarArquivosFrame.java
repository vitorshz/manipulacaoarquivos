package br.unipar.manipulacao.arquivos.telas;

import br.unipar.manipulacao.arquivos.dao.PessoaDAO;
import br.unipar.manipulacao.arquivos.dao.PessoaDAOImp;
import br.unipar.manipulacao.arquivos.model.Pessoa;
import br.unipar.manipulacao.arquivos.utils.EntityManagerUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

    public class ImportarArquivosFrame extends javax.swing.JFrame {

    /**
     * Creates new form TelaManipulacaoArquivosFrame
     */
    public ImportarArquivosFrame() {
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

        jPanelArquivos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textArquivo = new javax.swing.JTextField();
        labelArquivo = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanelArquivosLayout = new javax.swing.GroupLayout(jPanelArquivos);
        jPanelArquivos.setLayout(jPanelArquivosLayout);
        jPanelArquivosLayout.setHorizontalGroup(
            jPanelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        jPanelArquivosLayout.setVerticalGroup(
            jPanelArquivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Importar Arquivos");

        labelArquivo.setText("Arquivo");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelArquivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(12, 12, 12)
                .addComponent(jPanelArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false); //não exibe .ALL
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV Files", "csv"));
        
        int returnValue = fileChooser.showOpenDialog(this);
        
        if(returnValue == JFileChooser.APPROVE_OPTION){
            File arquivo = fileChooser.getSelectedFile();
            textArquivo.setText(arquivo.getAbsolutePath());
            
            converterPessoa(arquivo);
            dispose();
        } else{
            textArquivo.setText("");
        }
        
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(ImportarArquivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportarArquivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportarArquivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportarArquivosFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntityManagerUtil.getEntityManagerFactory();
                new ImportarArquivosFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelArquivos;
    private javax.swing.JLabel labelArquivo;
    private javax.swing.JTextField textArquivo;
    // End of variables declaration//GEN-END:variables

    private void converterPessoa(File arquivo) {
        try {
            BufferedReader br = 
                    new BufferedReader(new InputStreamReader(
                        new FileInputStream(arquivo.getAbsolutePath()),
                            "UTF-8"));
            String linha;
            Integer id = 0;
            List<Pessoa> pessoaList = new ArrayList<>();
            
            br.readLine();
            while((linha = br.readLine()) != null){
                String[] campos = linha.split(";");
                
                Pessoa pessoa = new Pessoa();

                pessoa.setId(id++);
                pessoa.setNome(campos[0]);
                pessoa.setIdade(Integer.parseInt(campos[1]));
                pessoa.setCpf(campos[2]);
                pessoa.setRg(campos[3]);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(campos[4], formatter);
                pessoa.setData_nasc(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                
                pessoa.setSexo(campos[5]);
                pessoa.setSigno(campos[6]);
                pessoa.setMae(campos[7]);
                pessoa.setPai(campos[8]);
                pessoa.setEmail(campos[9]);
                pessoa.setSenha(campos[10]);
                pessoa.setCep(campos[11]);
                pessoa.setEndereco(campos[12]);
                pessoa.setNumero(campos[13]);
                pessoa.setBairro(campos[14]);
                pessoa.setCidade(campos[15]);
                pessoa.setEstado(campos[16]);
                pessoa.setTelefone_fixo(campos[17]);
                pessoa.setCelular(campos[18]);
                pessoa.setAltura(Double.valueOf(campos[19]));
                pessoa.setPeso(Double.valueOf(campos[20]));
                pessoa.setTipo_sanguineo(campos[21]);
                pessoa.setCor(campos[22]);
                
                pessoaList.add(pessoa);
                
                PessoaDAO pessoaDAO = new PessoaDAOImp(EntityManagerUtil.getManager());
                pessoaDAO.save(pessoa);
   
            }
            JOptionPane.showMessageDialog(this, "Arquivo importado com sucesso! ");
            

        } catch (IOException e) {
            System.out.println("Algo deu errado...."+e.getMessage());
        }
    }
        @Override
        public void dispose() {

            super.dispose();
        }
}
