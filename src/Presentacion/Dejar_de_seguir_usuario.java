/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author Familia
 */
import Logica.DtColaborador;
import Logica.DtProponente;
import Logica.IUsuario;
import Logica.Usuario;
import java.util.List;
public class Dejar_de_seguir_usuario extends javax.swing.JInternalFrame {
    private IUsuario iUsu;
    /**
     * Creates new form Dejar_de_seguir_usuario
     */
    public Dejar_de_seguir_usuario(IUsuario iusu) {
        initComponents();
       
        cmbProp.setVisible(false);
        cmbSeg.setVisible(false);
      
          this.iUsu=iusu;
    
        
        
     
          
        
        
        
        
        
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbProp = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbSeg = new javax.swing.JComboBox<>();
        btnDej = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setClosable(true);

        jLabel1.setText("Dejar de seguir usuario");

        jLabel2.setText("Seleccionar usuario");

        cmbProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPropActionPerformed(evt);
            }
        });

        jLabel5.setText("Seleccionar usuario a dejar de seguir");

        cmbSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSegActionPerformed(evt);
            }
        });

        btnDej.setText("Dejar de seguir");
        btnDej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDejActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Colaboradores");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Proponentes");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Colaboradores");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Proponentes");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbProp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jRadioButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jRadioButton3))
                        .addGap(107, 107, 107)
                        .addComponent(jRadioButton4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbSeg, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDej, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(221, Short.MAX_VALUE)
                    .addComponent(jRadioButton2)
                    .addGap(64, 64, 64)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(13, 13, 13)
                .addComponent(cmbProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbSeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnDej)
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(104, 104, 104)
                    .addComponent(jRadioButton2)
                    .addContainerGap(242, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDejActionPerformed
        // TODO add your handling code here:
        this.iUsu.seleccionarUsuario(cmbProp.getSelectedItem().toString());
         this.iUsu.seleccionarUsuSeg(cmbSeg.getSelectedItem().toString());
              if((cmbProp.getSelectedItem().toString()).equals(cmbProp.getItemAt(0))==true || (cmbSeg.getSelectedItem().toString()).equals(cmbSeg.getItemAt(0))== true){
                    
                   javax.swing.JOptionPane.showMessageDialog(null, "Tiene que seleccionar un usuario");
                }
                else if(this.iUsu.yaSigue()==false){
            javax.swing.JOptionPane.showMessageDialog(null, "No sigues a este usuario, o sos vos");
        }
                else{
         
            boolean ok= this.iUsu.dejarDeSeguir();
           if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Usuario dejado de seguir");
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
    }//GEN-LAST:event_btnDejActionPerformed

    private void cmbPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPropActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_cmbPropActionPerformed

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
       
       }

        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
 List<DtColaborador> colabs=this.iUsu.listarColaboradores();
        if(jRadioButton2.isSelected())
       {
        
           cmbProp.removeAllItems();
           cmbProp.addItem("Seleccione usuario...");
        cmbProp.setVisible(true);
               for(int i=0; i< colabs.size(); i++){
            DtColaborador combitoProp=(DtColaborador) colabs.get(i);
                       cmbProp.addItem(combitoProp.getNick());
               }
       // jPanel3.setVisible(true);
       }        // TODO add your handling code here:
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
        //jPanel3.setVisible(true);
       }        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
  List<DtColaborador> colabs=this.iUsu.listarColaboradores();
        if(jRadioButton4.isSelected())
       {
                cmbSeg.removeAllItems();
           cmbSeg.addItem("Seleccione usuario...");
        cmbSeg.setVisible(true);
              for(int i=0; i< colabs.size(); i++){
            DtColaborador combitoProp=(DtColaborador) colabs.get(i);
                      
                       cmbSeg.addItem(combitoProp.getNick());
                                      
        
       
       }
       // jPanel3.setVisible(true);
       }          // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDej;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbProp;
    private javax.swing.JComboBox<String> cmbSeg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
