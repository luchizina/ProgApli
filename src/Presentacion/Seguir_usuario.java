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
     
        
        cmbProp.setVisible(false);
        cmbSeg.setVisible(false);
        
        jPanel3.setVisible(false);
      
              
    
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        cmbProp = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        cmbSeg = new javax.swing.JComboBox<>();
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
                .addComponent(jRadioButton2)
                .addContainerGap(132, Short.MAX_VALUE))
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
                .addComponent(cmbProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel9.setText("Elige usuario a seguir");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Proponente");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Colaborador");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        cmbSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSegActionPerformed(evt);
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
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(61, 61, 61)
                        .addComponent(jRadioButton4))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbSeg, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel9))))
                .addContainerGap(52, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnSeguir)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropActionPerformed
   
       
        
  

        
    }//GEN-LAST:event_cmbPropActionPerformed

    private void btnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguirActionPerformed
        // TODO add your handling code here:
       
             
                
               if(!(jRadioButton3.isSelected()) && !(jRadioButton4.isSelected())){
                    javax.swing.JOptionPane.showMessageDialog(null, "Seleccione el tipo de usuario a seguir");
                }
                
               else if((cmbProp.getSelectedItem().toString()).equals(cmbProp.getItemAt(0))==true || (cmbSeg.getSelectedItem().toString()).equals(cmbSeg.getItemAt(0))== true){
                    
                   javax.swing.JOptionPane.showMessageDialog(null, "Tiene que seleccionar un usuario de la lista");
                }
                
               
          
        else{
            
        this.iUsu.seleccionarUsuario(cmbProp.getSelectedItem().toString());
                this.iUsu.seleccionarUsuSeg(cmbSeg.getSelectedItem().toString());
                     if(this.iUsu.yaSigue()){
            javax.swing.JOptionPane.showMessageDialog(null, "Ya sigue a este usuario");
        }
                     else if(cmbProp.getSelectedItem().toString().equals(cmbSeg.getSelectedItem().toString())){
                         javax.swing.JOptionPane.showMessageDialog(null, "El usuario no se puede seguir a si mismo");
                     }
                     else{
                         
                  
        boolean ok= this.iUsu.seguirUsuario();
        if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Ha seguido al usuario con éxito");
jRadioButton1.setSelected(false);
jRadioButton2.setSelected(false);
jRadioButton3.setSelected(false);
jRadioButton4.setSelected(false);
cmbProp.setSelectedIndex(0);
cmbSeg.setSelectedIndex(0);
        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Error ");
        }
         }
                        }

    }//GEN-LAST:event_btnSeguirActionPerformed

    private void cmbSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSegActionPerformed
      
       
           
      
      
         
// TODO add your handling code here:
    }//GEN-LAST:event_cmbSegActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
       List<DtProponente> props=this.iUsu.listarProponentes();
        if(jRadioButton1.isSelected())
       {
           cmbProp.removeAllItems();
           cmbProp.addItem("Seleccione usuario...");
        cmbProp.setVisible(true);
               for(int i=0; i< props.size(); i++){
            DtProponente combitoProp=(DtProponente) props.get(i);
                       cmbProp.addItem(combitoProp.getNick());
                       
                                      
        }
                  
        
        jPanel3.setVisible(true);
       }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
      List<DtColaborador> colabs=this.iUsu.listarColaboradores();
        if(jRadioButton2.isSelected())
       {
           cmbProp.removeAllItems();
        cmbProp.addItem("Seleccione usuario...");
        cmbProp.setVisible(true);
                              
              for(int i=0; i< colabs.size(); i++){
                  DtColaborador combitoColab=(DtColaborador) colabs.get(i);
                  cmbProp.addItem(combitoColab.getNick());
                  
              }
        
        
        jPanel3.setVisible(true);
       }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
          List<DtProponente> props=this.iUsu.listarProponentes();
        if(jRadioButton3.isSelected())
       {
               cmbSeg.removeAllItems();
                cmbSeg.addItem("Seleccione usuario...");
        cmbSeg.setVisible(true);
               for(int i=0; i< props.size(); i++){
            DtProponente combitoProp=(DtProponente) props.get(i);
                       cmbSeg.addItem(combitoProp.getNick());
                       
                                      
        }
      
        cmbSeg.setVisible(true);
        jPanel3.setVisible(true);
       }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
  List<DtColaborador> colabs=this.iUsu.listarColaboradores();
        if(jRadioButton4.isSelected())
       {
        
            cmbSeg.removeAllItems();
       cmbSeg.addItem("Seleccione usuario...");
        cmbSeg.setVisible(true);
                              
              for(int i=0; i< colabs.size(); i++){
                  DtColaborador combitoColab=(DtColaborador) colabs.get(i);
                  cmbSeg.addItem(combitoColab.getNick());
                  
              }
        jPanel3.setVisible(true);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup SeguidorGrup;
    private javax.swing.JButton btnSeguir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbProp;
    private javax.swing.JComboBox<String> cmbSeg;
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
