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
        
        
        
        List<DtCategoria> catego = this.iCat.listarCategorias();
        DefaultTreeModel modeloArbol=null;
        DefaultMutableTreeNode raiz= new DefaultMutableTreeNode("Categoria");
        
        modeloArbol= new DefaultTreeModel(raiz);
        arbolito.setModel(this.imprimirArbol(modeloArbol, catego, raiz));
        
//        for(int i=0; i<catego.size(); i++){
//            DtCategoria c=(DtCategoria) catego.get(i);
//            if(c.getProfundidad()==0){
//                
//            
//            modeloArbol.insertNodeInto(new DefaultMutableTreeNode(c.getNombre()), raiz, raiz.getChildCount());
//       }
//            }
//        
//          for (int k = 0; k < catego.size(); k++) {
//            DtCategoria ca = (DtCategoria) catego.get(k);
//            int otro = modeloArbol.getChildCount(raiz);
//            for (int m = 0; m < otro; m++) {
//                DefaultMutableTreeNode nodito = (DefaultMutableTreeNode) (modeloArbol.getChild(raiz, m));
//                if ((ca.getNombre().compareTo(nodito.toString())) != 0 && (ca.getPadre().compareTo(nodito.toString())) == 0 && tieneEsteHijo(nodito, ca.getPadre()) == true) 
//                {
//                    modeloArbol.insertNodeInto(new DefaultMutableTreeNode(ca.getNombre()), nodito, nodito.getChildCount());
//                } 
//                else if ((ca.getNombre().compareTo(nodito.toString())) != 0 && (ca.getPadre().compareTo(nodito.toString())) != 0 && tieneEsteHijo(raiz, ca.getPadre()) == true && tieneEsteHijo(devolverNodo(raiz, ca.getPadre()), ca.getNombre()) == false)
//                {
//                    modeloArbol.insertNodeInto(new DefaultMutableTreeNode(ca.getNombre()), devolverNodo(raiz, ca.getPadre()), devolverNodo(raiz, ca.getPadre()).getChildCount());
//                }
//
//            }
//        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
            }
    
   public DefaultTreeModel imprimirArbol(DefaultTreeModel modeloArbol, List<DtCategoria> catego, DefaultMutableTreeNode raiz ){
          for(int i=0; i<catego.size(); i++){
            DtCategoria c=(DtCategoria) catego.get(i);
            if(c.getProfundidad()==0){
            modeloArbol.insertNodeInto(new DefaultMutableTreeNode(c.getNombre()), raiz, raiz.getChildCount());
       }
            else{
                  for (int k = 0; k < catego.size(); k++) {
            DtCategoria ca = (DtCategoria) catego.get(k);
            int otro = modeloArbol.getChildCount(raiz);
            for (int m = 0; m < otro; m++) {
                DefaultMutableTreeNode nodito = (DefaultMutableTreeNode) (modeloArbol.getChild(raiz, m));
                if ((ca.getNombre().compareTo(nodito.toString())) != 0 && (ca.getPadre().compareTo(nodito.toString())) == 0 && tieneEsteHijo(nodito, ca.getNombre()) == false) 
                {
                    modeloArbol.insertNodeInto(new DefaultMutableTreeNode(ca.getNombre()), nodito, nodito.getChildCount());
                } 
                else if ((ca.getNombre().equals(nodito.toString())) == false && (ca.getPadre().compareTo(nodito.toString())) != 0 && tieneEsteHijo(raiz, ca.getPadre()) == true && tieneEsteHijo(devolverNodo(raiz, ca.getPadre()), ca.getNombre()) == false)
                {
                    modeloArbol.insertNodeInto(new DefaultMutableTreeNode(ca.getNombre()), devolverNodo(raiz, ca.getPadre()), devolverNodo(raiz, ca.getPadre()).getChildCount());
                }
               

            }
        } 
            }
            }
        
       
          return modeloArbol;
   } 
    
    
    
    
    
    public DefaultMutableTreeNode devolverNodo(DefaultMutableTreeNode nodo, String padre){
         Enumeration<DefaultMutableTreeNode> hijos = nodo.children();
         Enumeration<DefaultMutableTreeNode> otroshijos = nodo.children();
 DefaultMutableTreeNode n=new DefaultMutableTreeNode();
             DefaultMutableTreeNode p=new DefaultMutableTreeNode();
             DefaultMutableTreeNode q=new DefaultMutableTreeNode();
       if(nodo.getChildCount()==0){
           return null;
       }
       
             // if(nodo.getChildCount()>0){
           
                    while(hijos.hasMoreElements()){
                        n=(DefaultMutableTreeNode) (hijos.nextElement());
                      String hijito = n.getUserObject().toString();
                        Enumeration<DefaultMutableTreeNode> hijitos =n.children();
                      if(padre.equals(hijito)){
                          return n;
                      }
                         while(hijitos.hasMoreElements()){
                          p=(DefaultMutableTreeNode) (hijitos.nextElement());
                          String hijote = p.getUserObject().toString();
                         if(padre.equals(hijote)){
                          return p;
                      }
                        
                      }
//                     
                    }
                    while(otroshijos.hasMoreElements()){
                        q=(DefaultMutableTreeNode) (otroshijos.nextElement());
                        return devolverNodo(q, padre);
                    }
                      return null;
                    }
    
    
     public boolean tieneEsteHijo( DefaultMutableTreeNode nodo, String padre){
       // cmbCategorias.addItem(nodo.toString());
       Enumeration<DefaultMutableTreeNode> hijos = nodo.children();
       Enumeration<DefaultMutableTreeNode> otroshijos = nodo.children();
             DefaultMutableTreeNode n=new DefaultMutableTreeNode();
             DefaultMutableTreeNode p=new DefaultMutableTreeNode();
              DefaultMutableTreeNode q=new DefaultMutableTreeNode();
       if(nodo.getChildCount()==0){
           return false;
       }
  
                         while(hijos.hasMoreElements()){
                        n=(DefaultMutableTreeNode) (hijos.nextElement());
                      String hijito = n.getUserObject().toString();
                      Enumeration<DefaultMutableTreeNode> hijitos =n.children();
                      if(padre.equals(hijito)){
                          return true;
                      }
                      
                      while(hijitos.hasMoreElements()){
                          p=(DefaultMutableTreeNode) (hijitos.nextElement());
                          String hijote = p.getUserObject().toString();
                         if(padre.equals(hijote)){
                          return true;
                      }
                        
                      }
                    }  
                             while(otroshijos.hasMoreElements()){
                        q=(DefaultMutableTreeNode) (otroshijos.nextElement());
                         return tieneEsteHijo(q,padre);
                    }
//              while(hijos.hasMoreElements()){
//              n=(DefaultMutableTreeNode) (hijos.nextElement());
//              
//                      return tieneEsteHijo(n, padre);
//                      }
return false;
           
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
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolito = new javax.swing.JTree();

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

        jScrollPane1.setViewportView(arbolito);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        DefaultTreeModel modeloArbol=null;
        DefaultMutableTreeNode raiz= new DefaultMutableTreeNode("Categoria");
        
        modeloArbol= new DefaultTreeModel(raiz);
         
        
       if(txtNombre.getText().equals("")){
           javax.swing.JOptionPane.showMessageDialog(null, "No ha ingresado una categoría");
       
       }
       else if(!rBtnSi.isSelected() && !rBtnNo.isSelected()){
           javax.swing.JOptionPane.showMessageDialog(null, "Seleccione si tiene padre o no");
           
       }
       
       else if(rBtnNo.isSelected()==true){
       
          DtCategoria nuevo= new DtCategoria(txtNombre.getText(), "Categoria",0);
          ing=nuevo;
          
                 boolean ok=iCat.ingresarCat(ing);
           List<DtCategoria> catego = this.iCat.listarCategorias();
         List<DtCategoria> combo = this.iCat.listarCategorias();
       
       
        if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Categoría Dada de alta");
            arbolito.removeAll();
            arbolito.setModel(this.imprimirArbol(modeloArbol, catego, raiz));
            
            
            
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
                        
                  int suma= this.iCat.traerProfu(cmbCategorias.getSelectedItem().toString())+1;
                        
       DtCategoria nuevo= new DtCategoria(txtNombre.getText(), cmbCategorias.getSelectedItem().toString(), suma);
              ing=nuevo;
              
                     boolean ok=iCat.ingresarCat(ing);
           List<DtCategoria> catego = this.iCat.listarCategorias();
         List<DtCategoria> combo = this.iCat.listarCategorias();
       
       
        if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Categoría Dada de alta");
           
            
            arbolito.removeAll();
               arbolito.setModel(this.imprimirArbol(modeloArbol, catego, raiz));
               
               
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
    private javax.swing.JTree arbolito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLet;
    private javax.swing.JRadioButton rBtnNo;
    private javax.swing.JRadioButton rBtnSi;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
