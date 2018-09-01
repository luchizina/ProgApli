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
import java.util.Collections;
import java.util.Comparator;
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
        jLabel5.setEnabled(false);
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
        construirArbolito(catego, raiz);
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
    
   public DefaultTreeModel imprimirArbol(DtCategoria catego, DefaultMutableTreeNode raiz){
         if(catego.getPadre().compareTo(raiz.toString()) == 0)
         {
             DefaultMutableTreeNode nodito = new DefaultMutableTreeNode(catego.getNombre());
             raiz.add(nodito);
         }
         
         else
         {
             for (int i = 0; i<raiz.getChildCount(); i++)
             {
                 imprimirArbol(catego, (DefaultMutableTreeNode) raiz.getChildAt(i));
             }
         }
         DefaultTreeModel modelito = new DefaultTreeModel(raiz);
         return modelito;
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
        jLabel4 = new javax.swing.JLabel();
        rBtnSi = new javax.swing.JRadioButton();
        rBtnNo = new javax.swing.JRadioButton();
        cmbCategorias = new javax.swing.JComboBox<>();
        lblLet = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolito = new javax.swing.JTree();

        setClosable(true);
        setTitle("Alta de categoría");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ingrese nuevo tipo de espectáculo");

        jLabel3.setText("Nombre:");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setText("¿Es una subcategoría?");

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

        jButton1.setText("Agregar categoría");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("elige una:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblLet))
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rBtnSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rBtnNo))
                            .addComponent(jLabel4)
                            .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 53, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rBtnSi)
                    .addComponent(rBtnNo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(arbolito);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            jLabel5.setEnabled(true);
        } 
       
    }//GEN-LAST:event_rBtnSiActionPerformed

    private void rBtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rBtnNoActionPerformed
        // TODO add your handling code here:
        if(rBtnSi.isSelected()==true){
            rBtnSi.setSelected(false);      
           }
          if(rBtnSi.isSelected()==false){
                cmbCategorias.setEnabled(false);
                jLabel5.setEnabled(false);
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
            txtNombre.setText("");
            arbolito.removeAll();
            construirArbolito(catego, raiz);
            
            
            
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
               construirArbolito(catego, raiz);
               
               
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

    private void construirArbolito(List<DtCategoria> catego, DefaultMutableTreeNode raiz)
    {
        Collections.sort(catego, (DtCategoria dt1, DtCategoria dt2) -> dt1.getProfundidad() - dt2.getProfundidad());
        for(int i = 0; i < catego.size(); i++)
        {
        arbolito.setModel(this.imprimirArbol(catego.get(i), raiz));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLet;
    private javax.swing.JRadioButton rBtnNo;
    private javax.swing.JRadioButton rBtnSi;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
