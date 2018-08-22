/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtColaborador;
import Logica.DtProponente;
import Logica.IUsuario;
import Logica.Usuario;
import java.util.List;

/**
 *
 * @author Familia
 */
public class Seguir_usuario extends javax.swing.JInternalFrame {

    private IUsuario iUsu;
    /**
     * Creates new form Seguir_usuario
     */
    
    public Seguir_usuario(){
        
    }
    public Seguir_usuario(IUsuario iusu) {
        initComponents();
        this.iUsu=iusu;
        this.iUsu.cargarColaboradores();
        this.iUsu.cargarProponentes();
        cmbColab.setVisible(false);
        cmbColabSeg.setVisible(false);
        cmbProp.setVisible(false);
        cmbPropSeg.setVisible(false);
        jPanel3.setVisible(false);
      List<DtColaborador> colabs=this.iUsu.listarColaboradores();
      List<DtProponente> props=this.iUsu.listarProponentes();
      
              for(int i=0; i< props.size(); i++){
            DtProponente combitoProp=(DtProponente) props.get(i);
                       cmbProp.addItem(combitoProp.getNick());
                       cmbPropSeg.addItem(combitoProp.getNick());
                                      
        }
              
              for(int i=0; i< colabs.size(); i++){
                  DtColaborador combitoColab=(DtColaborador) colabs.get(i);
                  cmbColab.addItem(combitoColab.getNick());
                  cmbColabSeg.addItem(combitoColab.getNick());
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

        SeguidorGrup = new javax.swing.ButtonGroup();
        SeguidoGrupo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        cmbProp = new javax.swing.JComboBox<>();
        cmbColab = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        cmbPropSeg = new javax.swing.JComboBox<>();
        cmbColabSeg = new javax.swing.JComboBox<>();
        btnSeguir = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setText("Seguir usuario");

        jLabel8.setText("Elige tipo de seguidor:");

        SeguidorGrup.add(jRadioButton1);
        jRadioButton1.setText("Proponente");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        SeguidorGrup.add(jRadioButton2);
        jRadioButton2.setText("Colaborador");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        cmbProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropActionPerformed(evt);
            }
        });

        cmbColab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbColabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(66, 66, 66))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbProp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(23, 23, 23)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(cmbColab, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbColab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel9.setText("Elige usuario a seguir");

        SeguidorGrup.add(jRadioButton3);
        jRadioButton3.setText("Proponente");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        SeguidorGrup.add(jRadioButton4);
        jRadioButton4.setText("Colaborador");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        cmbPropSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropSegActionPerformed(evt);
            }
        });

        cmbColabSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbColabSegActionPerformed(evt);
            }
        });

        btnSeguir.setText("Seguir");
        btnSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSeguir)
                .addGap(46, 46, 46))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addComponent(cmbPropSeg, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton4)
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addComponent(cmbColabSeg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPropSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbColabSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(btnSeguir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropActionPerformed
   
       
        
        this.iUsu.seleccionarUsuario(cmbProp.getSelectedItem().toString());
        
    }//GEN-LAST:event_cmbPropActionPerformed

    private void btnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguirActionPerformed
        // TODO add your handling code here:
        boolean ok= this.iUsu.seguirUsuario();
        if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Usuario seguido");

        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Error ");
        }

    }//GEN-LAST:event_btnSeguirActionPerformed

    private void cmbPropSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropSegActionPerformed
      
       
           
      
        this.iUsu.seleccionarUsuSeg(cmbPropSeg.getSelectedItem().toString());
         
// TODO add your handling code here:
    }//GEN-LAST:event_cmbPropSegActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       if(jRadioButton1.isSelected())
       {
        cmbProp.setVisible(true);
        cmbColab.setVisible(false);
        jPanel3.setVisible(true);
       }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
      if(jRadioButton2.isSelected())
       {
        cmbColab.setVisible(true);
        cmbProp.setVisible(false);
        jPanel3.setVisible(true);
       }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
         if(jRadioButton3.isSelected())
       {
        cmbColabSeg.setVisible(false);
        cmbPropSeg.setVisible(true);
        jPanel3.setVisible(true);
       }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
  if(jRadioButton4.isSelected())
       {
        cmbColabSeg.setVisible(true);
        cmbPropSeg.setVisible(false);
        jPanel3.setVisible(true);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void cmbColabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbColabActionPerformed
        // TODO add your handling code here:
  
            
        
        this.iUsu.seleccionarUsuario(cmbColab.getSelectedItem().toString());
       
    }//GEN-LAST:event_cmbColabActionPerformed

    private void cmbColabSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbColabSegActionPerformed
        // TODO add your handling code here:

         this.iUsu.seleccionarUsuSeg(cmbColabSeg.getSelectedItem().toString());
          
    }//GEN-LAST:event_cmbColabSegActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup SeguidoGrupo;
    private javax.swing.ButtonGroup SeguidorGrup;
    private javax.swing.JButton btnSeguir;
    private javax.swing.JComboBox<String> cmbColab;
    private javax.swing.JComboBox<String> cmbColabSeg;
    private javax.swing.JComboBox<String> cmbProp;
    private javax.swing.JComboBox<String> cmbPropSeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
