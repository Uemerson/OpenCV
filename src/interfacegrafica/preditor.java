/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import opencv.ExtratorImagem;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.lazy.IBk;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.OneR;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author UEMERSON
 */
public class preditor extends javax.swing.JFrame {
    
    //Variaveis
    private Instances instancias;
    
    public preditor() {
        initComponents();
    }
    
    private void classifica() throws Exception{
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(instancias);
        
        J48 arvore = new J48();
        arvore.buildClassifier(instancias);
        
        OneR oner = new OneR();
        JRip jrip = new JRip();
        oner.buildClassifier(instancias);
        jrip.buildClassifier(instancias);
        
        IBk ibk = new IBk(3);
        ibk.buildClassifier(instancias);
        
        LibSVM svm = new LibSVM();
        svm.setKernelType(new SelectedTag(LibSVM.KERNELTYPE_LINEAR, LibSVM.TAGS_KERNELTYPE));
        svm.buildClassifier(instancias);
        
        //Criando novo registro
        Instance novo = new DenseInstance(instancias.numAttributes());
        novo.setDataset(instancias);
        novo.setValue(0, Float.parseFloat(lblLaranjaBart.getText()));
        novo.setValue(1, Float.parseFloat(lblAzulCalcao.getText()));
        novo.setValue(2, Float.parseFloat(lblAzulSapato.getText()));
        novo.setValue(3, Float.parseFloat(lblMarromHomer.getText()));
        novo.setValue(4, Float.parseFloat(lblAzulHomer.getText()));
        novo.setValue(5, Float.parseFloat(lblSapatoHomer.getText()));
        
        //Previsão Naive Bayes
        DecimalFormat df = new DecimalFormat("#,###.0000");
        double resultadoNaive[] = nb.distributionForInstance(novo);
        
        lblNaiveBart.setText("Bart: " + df.format(resultadoNaive[0]));
        lblNaiveHomer.setText("Homer: " + df.format(resultadoNaive[1]));
        
        //Previsão J48
        double resultadoJ48[] = arvore.distributionForInstance(novo);
        
        lblJ48Bart.setText("Bart: " + df.format(resultadoJ48[0]));
        lblJ48Homer.setText("Homer: " + df.format(resultadoJ48[1]));
        
        //Previsão JRip
        double resultadoOneR[] = oner.distributionForInstance(novo);
        double resultadoJRip[] = jrip.distributionForInstance(novo);
        
        lblOneRBart.setText("Bart: " + df.format(resultadoOneR[0]));
        lblOneRHomer.setText("Homer: " + df.format(resultadoOneR[1]));
        
        lblJRipBart.setText("Bart: " + df.format(resultadoJRip[0]));
        lblJRipHomer.setText("Homer: " + df.format(resultadoJRip[1]));
        
        //Previsão IBk
        double resultadoIBK[] = ibk.distributionForInstance(novo);
        
        lblIBkBart.setText("Bart: " + df.format(resultadoIBK[0]));
        lblIBkHomer.setText("Homer: " + df.format(resultadoIBK[1]));
        
        //Previsão LibSVM
        double resultadoSVM[] = svm.distributionForInstance(novo);
        
        lblSVMBart.setText("Bart: " + df.format(resultadoSVM[0]));
        lblSVMHomer.setText("Homer: " + df.format(resultadoSVM[1]));
    }
    
    public void carregaBaseWeka() throws Exception{
        DataSource ds = new DataSource("src\\opencv\\caracteristicas.arff");
        instancias = ds.getDataSet();
        instancias.setClassIndex(instancias.numAttributes() - 1);               //Definindo a classe
        System.out.println(instancias.toString());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        txtCaminhoImagem = new javax.swing.JTextField();
        btnSelecionarImagem = new javax.swing.JButton();
        lblImagem = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblLaranjaBart = new javax.swing.JLabel();
        lblAzulCalcao = new javax.swing.JLabel();
        btnExtrairCaracteristicas = new javax.swing.JButton();
        lblAzulSapato = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblAzulHomer = new javax.swing.JLabel();
        lblMarromHomer = new javax.swing.JLabel();
        lblSapatoHomer = new javax.swing.JLabel();
        btnClassificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblNaiveBart = new javax.swing.JLabel();
        lblNaiveHomer = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblJ48Bart = new javax.swing.JLabel();
        lblJ48Homer = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblOneRBart = new javax.swing.JLabel();
        lblOneRHomer = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblJRipBart = new javax.swing.JLabel();
        lblJRipHomer = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblIBkBart = new javax.swing.JLabel();
        lblIBkHomer = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSVMBart = new javax.swing.JLabel();
        lblSVMHomer = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCaminhoImagem.setEnabled(false);

        btnSelecionarImagem.setText("Selecionar Imagem");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        jLabel1.setText("Caracteristicas do Bart");

        lblLaranjaBart.setText("0");

        lblAzulCalcao.setText("0");

        btnExtrairCaracteristicas.setText("Extrair Caracteristicas");
        btnExtrairCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtrairCaracteristicasActionPerformed(evt);
            }
        });

        lblAzulSapato.setText("0");

        jLabel5.setText("Caracteristicas do Homer");

        lblAzulHomer.setText("0");

        lblMarromHomer.setText("0");

        lblSapatoHomer.setText("0");

        btnClassificar.setText("Classificar");
        btnClassificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassificarActionPerformed(evt);
            }
        });

        jLabel2.setText("Naive Bayes");

        lblNaiveBart.setText("0");

        lblNaiveHomer.setText("0");

        jLabel4.setText("J48");

        lblJ48Bart.setText("0");

        lblJ48Homer.setText("0");

        jLabel6.setText("OneR");

        lblOneRBart.setText("0");

        lblOneRHomer.setText("0");

        jLabel7.setText("JRip");

        lblJRipBart.setText("0");

        lblJRipHomer.setText("0");

        jLabel8.setText("IBk");

        lblIBkBart.setText("0");

        lblIBkHomer.setText("0");

        jLabel9.setText("SVM");

        lblSVMBart.setText("0");

        lblSVMHomer.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExtrairCaracteristicas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClassificar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblLaranjaBart)
                                    .addComponent(lblAzulCalcao)
                                    .addComponent(lblAzulSapato))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSapatoHomer)
                                    .addComponent(lblMarromHomer)
                                    .addComponent(lblAzulHomer)
                                    .addComponent(jLabel5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lblNaiveBart)
                                    .addComponent(lblNaiveHomer)
                                    .addComponent(jLabel8)
                                    .addComponent(lblIBkBart)
                                    .addComponent(lblIBkHomer))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSVMHomer)
                                    .addComponent(lblSVMBart)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(lblJ48Bart)
                                            .addComponent(lblJ48Homer))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(lblOneRBart)
                                            .addComponent(lblOneRHomer))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(lblJRipBart)
                                            .addComponent(lblJRipHomer))))))
                        .addGap(0, 223, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCaminhoImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelecionarImagem)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCaminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarImagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLaranjaBart)
                            .addComponent(lblAzulHomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAzulCalcao)
                            .addComponent(lblMarromHomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAzulSapato)
                            .addComponent(lblSapatoHomer))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNaiveBart)
                            .addComponent(lblJ48Bart)
                            .addComponent(lblOneRBart)
                            .addComponent(lblJRipBart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNaiveHomer)
                            .addComponent(lblJ48Homer)
                            .addComponent(lblOneRHomer)
                            .addComponent(lblJRipHomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIBkBart)
                            .addComponent(lblSVMBart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIBkHomer)
                            .addComponent(lblSVMHomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExtrairCaracteristicas)
                            .addComponent(btnClassificar))))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
        JFileChooser fc = new JFileChooser();

        int retorno = fc.showDialog(this, "Selecione a imagem");

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            txtCaminhoImagem.setText(arquivo.getAbsolutePath());

            BufferedImage bitmap = null;
            try {
                bitmap = ImageIO.read(arquivo);
            } catch (IOException ex) {
                Logger.getLogger(preditor.class.getName()).log(Level.SEVERE, null, ex);
            }

            ImageIcon imagemLabel = new ImageIcon(bitmap);
            lblImagem.setIcon(
                    new ImageIcon(imagemLabel.getImage().getScaledInstance(
                            lblImagem.getWidth(),
                            lblImagem.getHeight(),
                            Image.SCALE_DEFAULT)));

        }
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void btnExtrairCaracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtrairCaracteristicasActionPerformed
        ExtratorImagem extrator = new ExtratorImagem();
        
        float []caracteristicas = extrator.extrairCaracteristicasImagem(txtCaminhoImagem.getText());
        
        lblLaranjaBart.setText(Float.toString(caracteristicas[0]));
        lblAzulCalcao.setText(Float.toString(caracteristicas[1]));
        lblAzulSapato.setText(Float.toString(caracteristicas[2]));
        lblAzulHomer.setText(Float.toString(caracteristicas[3]));
        lblMarromHomer.setText(Float.toString(caracteristicas[4]));
        lblSapatoHomer.setText(Float.toString(caracteristicas[5]));
    }//GEN-LAST:event_btnExtrairCaracteristicasActionPerformed

    private void btnClassificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassificarActionPerformed
        try {
            carregaBaseWeka();
            classifica();
        } catch (Exception ex) {
            Logger.getLogger(preditor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnClassificarActionPerformed

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
            java.util.logging.Logger.getLogger(preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new preditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClassificar;
    private javax.swing.JButton btnExtrairCaracteristicas;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblAzulCalcao;
    private javax.swing.JLabel lblAzulHomer;
    private javax.swing.JLabel lblAzulSapato;
    private javax.swing.JLabel lblIBkBart;
    private javax.swing.JLabel lblIBkHomer;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblJ48Bart;
    private javax.swing.JLabel lblJ48Homer;
    private javax.swing.JLabel lblJRipBart;
    private javax.swing.JLabel lblJRipHomer;
    private javax.swing.JLabel lblLaranjaBart;
    private javax.swing.JLabel lblMarromHomer;
    private javax.swing.JLabel lblNaiveBart;
    private javax.swing.JLabel lblNaiveHomer;
    private javax.swing.JLabel lblOneRBart;
    private javax.swing.JLabel lblOneRHomer;
    private javax.swing.JLabel lblSVMBart;
    private javax.swing.JLabel lblSVMHomer;
    private javax.swing.JLabel lblSapatoHomer;
    private javax.swing.JTextField txtCaminhoImagem;
    // End of variables declaration//GEN-END:variables
}
