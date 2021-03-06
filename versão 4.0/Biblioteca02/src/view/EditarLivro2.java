/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Jefferson Queiroz
 */
public class EditarLivro2 extends javax.swing.JInternalFrame {

    /**
     * Creates new form EditarLivro2
     */
    public EditarLivro2() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldLivroPesquisaLivro2 = new javax.swing.JTextField();
        jButtonOkPesquisaLivro2 = new javax.swing.JButton();
        jButtonVoltarPesquisaLivro2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTabelaPesquisaLivro2 = new javax.swing.JTable();
        jButtonPesquisarPesquisaLivro2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Sistema de Biblioteca - Editar Livro");

        jLabel1.setText("Nome do Livro");

        jTextFieldLivroPesquisaLivro2.setToolTipText("Digite o nome do Livro");

        jButtonOkPesquisaLivro2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonOkPesquisaLivro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ok.png"))); // NOI18N
        jButtonOkPesquisaLivro2.setText("OK");

        jButtonVoltarPesquisaLivro2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonVoltarPesquisaLivro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/back-arrow_icon-icons.com_72866.png"))); // NOI18N
        jButtonVoltarPesquisaLivro2.setText("Voltar");
        jButtonVoltarPesquisaLivro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarPesquisaLivro2ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel10.setText("Pesquisar Livro");

        jTableTabelaPesquisaLivro2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableTabelaPesquisaLivro2);

        jButtonPesquisarPesquisaLivro2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonPesquisarPesquisaLivro2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldLivroPesquisaLivro2)))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonPesquisarPesquisaLivro2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(jButtonOkPesquisaLivro2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonVoltarPesquisaLivro2)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldLivroPesquisaLivro2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonPesquisarPesquisaLivro2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonOkPesquisaLivro2)
                    .addComponent(jButtonVoltarPesquisaLivro2))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarPesquisaLivro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarPesquisaLivro2ActionPerformed
       
       this.dispose();
    }//GEN-LAST:event_jButtonVoltarPesquisaLivro2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOkPesquisaLivro2;
    private javax.swing.JButton jButtonPesquisarPesquisaLivro2;
    private javax.swing.JButton jButtonVoltarPesquisaLivro2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTabelaPesquisaLivro2;
    private javax.swing.JTextField jTextFieldLivroPesquisaLivro2;
    // End of variables declaration//GEN-END:variables
}
