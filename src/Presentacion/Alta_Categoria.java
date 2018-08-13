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
    
    public boolean tieneEsteHijo( DefaultMutableTreeNode nodo, String padre){
       // cmbCategorias.addItem(nodo.toString());
       Enumeration<DefaultMutableTreeNode> hijos = nodo.children();
             DefaultMutableTreeNode n=new DefaultMutableTreeNode();
             
       if(nodo.getChildCount()==0){
           return false;
       }
  
                         while(hijos.hasMoreElements()){
                        n=(DefaultMutableTreeNode) (hijos.nextElement());
                      String hijito = n.getUserObject().toString();
                      if(padre.equals(hijito)){
                          return true;
                      }
                    }
                                                  
//              while(hijos.hasMoreElements()){
//              n=(DefaultMutableTreeNode) (hijos.nextElement());
//              
//                      return tieneEsteHijo(n, padre);
//                      }
              return tieneEsteHijo(n,padre);
                    }
    
    public DefaultMutableTreeNode devolverNodo(DefaultMutableTreeNode nodo, String padre){
         Enumeration<DefaultMutableTreeNode> hijos = nodo.children();
       DefaultMutableTreeNode n=new DefaultMutableTreeNode();
       if(nodo.getChildCount()==0){
           return null;
       }
             // if(nodo.getChildCount()>0){
                    while(hijos.hasMoreElements()){
                        n=(DefaultMutableTreeNode) (hijos.nextElement());
                      String hijito = n.getUserObject().toString();
                      if(padre.equals(hijito)){
                          return n;
                      }
//                     
                    }
                      return devolverNodo(n, padre);
                    }
        
    
    
    public DefaultTreeModel imprimirArbol(DefaultMutableTreeNode raiz, List<DtCategoria> catego){
          DefaultTreeModel modeloArbol =null;
                DefaultMutableTreeNode hijo = null;
        DefaultMutableTreeNode padre = null;
        DefaultMutableTreeNode papi=new DefaultMutableTreeNode();
        DefaultMutableTreeNode aux= null;
        //DefaultMutableTreeNode childnode = null;
         //raiz = new DefaultMutableTreeNode("Categoría");
       modeloArbol = new DefaultTreeModel(raiz);
        //Enumeration e1 = raiz.breadthFirstEnumeration();
        
        
        
         
        for (int i = 0; i < catego.size(); i++) {
            DtCategoria c = (DtCategoria) catego.get(i);
            
            //nuevo
//              Map<String,Categoria> hijos= new HashMap<>();
//            hijos=c.getHijos();
//                    Set set= hijos.entrySet();
//                    Iterator iterator = set.iterator();
//                    while(iterator.hasNext()){
//                         Map.Entry mentry = (Map.Entry)iterator.next();
//            Categoria son=(Categoria) mentry.getValue();    
//                        cmbHijos.addItem(son.getNombre());
//                    }
                         //nuevo  
                    
                    
             papi=new DefaultMutableTreeNode(c.getPadre());
            cmbCategorias.addItem(c.getNombre());
            
//            padre=new DefaultMutableTreeNode(c.getPadre());
//            hijo = new DefaultMutableTreeNode(c.getNombre());
            
            if (c.getPadre().compareTo("No") == 0  && tieneEsteHijo(raiz, c.getNombre())== false)
            {
                modeloArbol.insertNodeInto(new DefaultMutableTreeNode(c.getNombre()), raiz, raiz.getChildCount());
            }
//            else if (tieneEsteHijo(raiz, c.getPadre()) == false && (c.getPadre().compareTo("No")!=0))
//            {
//                modeloArbol.insertNodeInto(padre = new DefaultMutableTreeNode(c.getPadre()), raiz, raiz.getChildCount());
//                modeloArbol.insertNodeInto(hijo = new DefaultMutableTreeNode(c.getNombre()), padre, padre.getChildCount());
//            } 
//            else if ((tieneEsteHijo(raiz, c.getPadre()) == true) && (padre.toString().compareTo(c.getPadre()))==0)
//            {
//                modeloArbol.insertNodeInto(hijo = new DefaultMutableTreeNode(c.getNombre()), padre, padre.getChildCount());
//            }
//            else if((tieneEsteHijo(raiz,c.getPadre()) == true) && (padre.toString().compareTo(c.getPadre()))!=0)
//            {
//                modeloArbol.insertNodeInto(hijo = new DefaultMutableTreeNode(c.getNombre()), devolverNodo(raiz,c.getPadre()), (devolverNodo(raiz,c.getPadre())).getChildCount());
//            }
//            else if (tieneEsteHijo(raiz, c.getPadre()) == true && tieneEsteHijo(padre,hijo.toString())==true)
//            {
//              return imprimirArbol(padre,catego);
//            }
       
        }
        
        for(int k= 0; k<catego.size();k++){
            DtCategoria ca = (DtCategoria) catego.get(k);
           int otro= modeloArbol.getChildCount(raiz);
           for(int m=0; m<otro; m++ ){
            DefaultMutableTreeNode nodito=(DefaultMutableTreeNode) (modeloArbol.getChild(raiz, m));
            if((ca.getNombre().compareTo(nodito.toString()))!=0  && (ca.getPadre().compareTo(nodito.toString()))==0)
                    {
                modeloArbol.insertNodeInto(new DefaultMutableTreeNode(ca.getNombre()), nodito, nodito.getChildCount());
            }
            else if((ca.getNombre().compareTo(nodito.toString()))!=0  && (ca.getPadre().compareTo(nodito.toString()))!=0 && tieneEsteHijo(raiz, ca.getPadre())==true)
            {
                modeloArbol.insertNodeInto(new DefaultMutableTreeNode(ca.getNombre()), devolverNodo(raiz,ca.getPadre()), devolverNodo(raiz,ca.getPadre()).getChildCount());
            }
           
              }
           
        }
      
        
        return modeloArbol;

    }
 
    
    public Alta_Categoria(ICategoria icat){
        initComponents();
        this.iCat=icat;
          int bcount=0;
    int count = 0;
    int aux = 1;
        
         DefaultTreeModel modeloArbol =null;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categoría");
        DefaultMutableTreeNode hijo = null;
        DefaultMutableTreeNode padre = null;
        DefaultMutableTreeNode childnode = null;
        
        
                             //   this.arbolito.setModel(modeloArbol);
       raiz = new DefaultMutableTreeNode("Categoría");
       modeloArbol = new DefaultTreeModel(raiz);
        Enumeration e1 = raiz.breadthFirstEnumeration();
        List<DtCategoria> catego = this.iCat.listarCategorias();
       // padre= (DefaultMutableTreeNode) e1.nextElement();
        
       //a partir de aca seria la recursiva?
        
        //hasta aca la recursiva?
      
        
        this.arbolito.setModel(imprimirArbol(raiz,catego));
    

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
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolito = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rBtnSi = new javax.swing.JRadioButton();
        rBtnNo = new javax.swing.JRadioButton();
        cmbCategorias = new javax.swing.JComboBox<>();
        lblPrueba = new javax.swing.JLabel();
        cmbHijos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        jScrollPane1.setViewportView(arbolito);

        jLabel2.setText("Ingresar nueva categoría");

        jLabel3.setText("Nombre");

        jButton1.setText("Agregar categoría");

        jLabel4.setText("tiene padre?");

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

        lblPrueba.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(41, 41, 41)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(rBtnSi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rBtnNo))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(cmbHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3))
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rBtnSi)
                            .addComponent(rBtnNo))
                        .addGap(25, 25, 25)
                        .addComponent(cmbCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(cmbHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(lblPrueba))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Alta de categoría");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel1)
                .addContainerGap(340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategorias;
    private javax.swing.JComboBox<String> cmbHijos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPrueba;
    private javax.swing.JRadioButton rBtnNo;
    private javax.swing.JRadioButton rBtnSi;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
