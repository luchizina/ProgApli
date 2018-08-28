/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Categoria;
import Logica.ICategoria;
import Logica.ctrlCategoria;
import java.util.List;
import java.util.ArrayList;
import Logica.DtCategoria;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
/**
 *
 * @author nambr
 */
public class Alta_Categoria extends javax.swing.JInternalFrame {

    private ICategoria iCat;
    /**
     * Creates new form Alta_Categoria
     */
    public Alta_Categoria() {
        initComponents();
    }
    public Alta_Categoria(ICategoria icat){
        initComponents();
        lblLet.setVisible(false);
        
        this.iCat=icat;
        this.iCat.cargarCategorias();
       
cmbCategorias.addItem("Seleccione la categoría padre...");
        List<DtCategoria> combo = this.iCat.listarCategorias();
        for(int i=0; i< combo.size(); i++){
            DtCategoria combito=(DtCategoria) combo.get(i);
                       cmbCategorias.addItem(combito.getNombre());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rBtnSi = new javax.swing.JRadioButton();
        rBtnNo = new javax.swing.JRadioButton();
        cmbCategorias = new javax.swing.JComboBox<>();
        lblLet = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jLabel2.setText("Ingresar nueva categoría");

        jLabel3.setText("Nombre");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jButton1.setText("Agregar categoría");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("¿tiene padre?");

        rBtnSi.setText("Si");
        rBtnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnSiActionPerformed(evt);
            }
        });

        rBtnNo.setText("No");
        rBtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rBtnNoActionPerformed(evt);
            }
        });

        cmbCategorias.setEnabled(false);
        cmbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriasActionPerformed(evt);
            }
        });

        lblLet.setForeground(new java.awt.Color(255, 51, 51));
        lblLet.setText("No se permite ingresar números");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rBtnSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rBtnNo)))
                        .addGap(18, 18, 18)
                        .addComponent(lblLet))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rBtnSi)
                    .addComponent(rBtnNo))
                .addGap(13, 13, 13)
                .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Alta de categoría");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rBtnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnSiActionPerformed
        // TODO add your handling code here:
        
        if(rBtnNo.isSelected()==true){
            rBtnNo.setSelected(false);
        }
        if(rBtnSi.isSelected()==true){
            cmbCategorias.setEnabled(true);
        } 
       
    }//GEN-LAST:event_rBtnSiActionPerformed

    private void rBtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNoActionPerformed
        // TODO add your handling code here:
        if(rBtnSi.isSelected()==true){
            rBtnSi.setSelected(false);      
           }
          if(rBtnSi.isSelected()==false){
                cmbCategorias.setEnabled(false);
        }
    }//GEN-LAST:event_rBtnNoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DtCategoria ing = new DtCategoria("algo", "algo");
         
        
       if(txtNombre.getText().equals("")){
           javax.swing.JOptionPane.showMessageDialog(null, "No ha ingresado una categoría");
       
       }
       else if(!rBtnSi.isSelected() && !rBtnNo.isSelected()){
           javax.swing.JOptionPane.showMessageDialog(null, "Seleccione si tiene padre o no");
           
       }
       
       else if(rBtnNo.isSelected()==true){
       
          DtCategoria nuevo= new DtCategoria(txtNombre.getText(), "Categoria");
          ing=nuevo;
          
                 boolean ok=iCat.ingresarCat(ing);
           List<DtCategoria> catego = this.iCat.listarCategorias();
         List<DtCategoria> combo = this.iCat.listarCategorias();
       
       
        if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Categoría Dada de alta");
            cmbCategorias.removeAllItems();
            cmbCategorias.addItem("Seleccione la categoría padre...");
            for(int i=0; i< combo.size(); i++){
            DtCategoria combito=(DtCategoria) combo.get(i);
                       cmbCategorias.addItem(combito.getNombre());
        }
            rBtnSi.setSelected(false);
            rBtnNo.setSelected(true);
            cmbCategorias.setSelectedIndex(0);
            

        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"La categoría ya está ingresada");
        }
           
     }
     
     
     else if(rBtnSi.isSelected()== true) 
     {
                    if(cmbCategorias.getSelectedItem().toString().equals(cmbCategorias.getItemAt(0)) && txtNombre.getText().equals("")==false){
             javax.swing.JOptionPane.showMessageDialog(null, "Seleccione una categoría padre");
         }
                    else{
                        
                  
       DtCategoria nuevo= new DtCategoria(txtNombre.getText(), cmbCategorias.getSelectedItem().toString());
              ing=nuevo;
              
                     boolean ok=iCat.ingresarCat(ing);
           List<DtCategoria> catego = this.iCat.listarCategorias();
         List<DtCategoria> combo = this.iCat.listarCategorias();
       
       
        if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Categoría Dada de alta");
            cmbCategorias.removeAllItems();
            cmbCategorias.addItem("Seleccione la categoría padre...");
            for(int i=0; i< combo.size(); i++){
            DtCategoria combito=(DtCategoria) combo.get(i);
                       cmbCategorias.addItem(combito.getNombre());
        }
            rBtnSi.setSelected(false);
            rBtnNo.setSelected(true);
            cmbCategorias.setSelectedIndex(0);
            

        }else{
            javax.swing.JOptionPane.showMessageDialog(null,"La categoría ya está ingresada");
        }
             }    
          }
     

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped

         char c=evt.getKeyChar(); 
             
         
          if(Character.isDigit(c)) { 
              getToolkit().beep(); 
               
              evt.consume(); 
               
              lblLet.setVisible(true);
               
          }
          else lblLet.setVisible(false);


        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void cmbCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCategoriasActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLet;
    private javax.swing.JRadioButton rBtnNo;
    private javax.swing.JRadioButton rBtnSi;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
