/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtPropuesta;
import Logica.IPropuesta;
import Logica.Testado;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Nuevo
 */
public class Consultar_Propuesta extends javax.swing.JInternalFrame {
    private IPropuesta propuesta;
    /**
     * Creates new form Consultar_Propuesta
     */
    public Consultar_Propuesta() {
        initComponents();
    }
    
     public Consultar_Propuesta(IPropuesta propu) {
        initComponents();
        this.propuesta = propu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        TxtPropuesto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLImagen = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TxtDescriopcion = new javax.swing.JTextPane();
        TxtFecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLColaboradores = new javax.swing.JList<>();
        TxtLugar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jLPropuestas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TxtMontoTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtCategoria = new javax.swing.JTextField();
        TxtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtMontoActual = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtFPublica = new javax.swing.JTextField();
        TxtEstado = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        TxtBuscador = new javax.swing.JTextField();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jLabel9.setText("Estado:");

        TxtPropuesto.setEditable(false);
        TxtPropuesto.setText(" ");
        TxtPropuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPropuestoActionPerformed(evt);
            }
        });

        jLabel10.setText("Propuesto por:");

        jLabel12.setText("Imagen:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Consulta de propuestas");

        TxtDescriopcion.setEditable(false);
        jScrollPane3.setViewportView(TxtDescriopcion);

        TxtFecha.setEditable(false);
        TxtFecha.setText(" ");

        jLabel13.setText("Propuestas:");

        jLColaboradores.setAutoscrolls(false);
        jScrollPane2.setViewportView(jLColaboradores);

        TxtLugar.setEditable(false);
        TxtLugar.setText(" ");

        jLabel14.setText("Colaboradores:");

        jLPropuestas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jLPropuestasValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(jLPropuestas);

        jLabel3.setText("Fecha:");

        jLabel4.setText("Lugar:");

        jLabel2.setText("Descripcion: ");

        jLabel5.setText("Precio:");

        jLabel15.setText("Categoria:");

        TxtMontoTotal.setEditable(false);
        TxtMontoTotal.setText(" ");

        jLabel6.setText("Monto Total:");

        TxtCategoria.setEditable(false);

        TxtPrecio.setEditable(false);
        TxtPrecio.setText(" ");

        jLabel7.setText("Monto Actual:");

        TxtMontoActual.setEditable(false);
        TxtMontoActual.setText(" ");

        jLabel8.setText("Fecha de Publicacion:");

        TxtFPublica.setEditable(false);
        TxtFPublica.setText(" ");

        TxtEstado.setEditable(false);
        TxtEstado.setText(" ");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Buscar Propuesta:");

        TxtBuscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtBuscadorFocusGained(evt);
            }
        });
        TxtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtBuscadorActionPerformed(evt);
            }
        });
        TxtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBuscadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtBuscadorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(TxtBuscador, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TxtFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                                .addComponent(TxtMontoTotal, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TxtEstado, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(TxtPrecio)
                                            .addComponent(TxtFPublica)
                                            .addComponent(TxtMontoActual)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel5))
                                                .addGap(0, 35, Short.MAX_VALUE))
                                            .addComponent(TxtPropuesto, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TxtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtPropuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtFPublica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtMontoActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5)))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                    .addComponent(jLImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLPropuestasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jLPropuestasValueChanged
        
        if (jLPropuestas.getSelectedIndex() != -1) {
            DtPropuesta x = propuesta.SeleccionarProp(jLPropuestas.getSelectedValue()); 
            List<String> nombres = propuesta.ColaborantesDePro();
            Date date = x.getFecha();
            DateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
            String convertido = fecha.format(date);
            Date datep = x.getFechaPub();
            DateFormat fechap = new SimpleDateFormat("yyyy/MM/dd");
            String convertidop = fechap.format(datep);

            TxtDescriopcion.setText(x.getDescripcion());
            TxtLugar.setText(x.getLugar());
            TxtMontoTotal.setText(Integer.toString(x.getMontototal()));
            TxtMontoActual.setText(Integer.toString(x.getMontoActual()));
            TxtPrecio.setText(Integer.toString(x.getPrecio()));
            TxtFecha.setText(convertido);
            TxtFPublica.setText(convertidop);
            TxtPropuesto.setText(x.getPropo());
            TxtCategoria.setText(x.getNombreCate());
            ImageIcon imagen = new ImageIcon(x.getImg());
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jLImagen.getWidth(), jLImagen.getHeight(), Image.SCALE_DEFAULT));
            jLImagen.setIcon(icono);
            if (x.getEstActual() != null) {
                if (x.getEstActual().getEstado().toString().equals("Ingresada")) {
                    TxtEstado.setText("Ingresada");
                } else if (x.getEstActual().getEstado().toString().equals("Publicada")) {
                    TxtEstado.setText("Publicada");
                } else if (x.getEstActual().getEstado().toString().equals("En_Financiacion")) {
                    TxtEstado.setText("En Financiacion");
                } else if (x.getEstActual().getEstado().toString().equals("Financiada")) {
                    TxtEstado.setText("Financiada");
                } else if (x.getEstActual().getEstado().toString().equals("No_Financiada")) {
                    TxtEstado.setText("No Financiada");
                } else {
                    TxtEstado.setText("Cancelada");
                }
            }
            if (nombres != null) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < nombres.size(); i++) {
                    String p = (String) nombres.get(i);
                    modelo.addElement(p);
                }
                jLColaboradores.setModel(modelo);
            } else {
                javax.swing.JOptionPane.showMessageDialog(null, "No posee Colaborantes");
            }
        }
    }//GEN-LAST:event_jLPropuestasValueChanged

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
        List<String> pro = propuesta.ListarProp();
        if (!pro.isEmpty()) {                                                   // SI HAY PROPUESTAS
            DefaultListModel modelo = new DefaultListModel();                   
            for (int i = 0; i < pro.size(); i++) {
                String p = (String) pro.get(i);
                modelo.addElement(p);
            }
            jLPropuestas.setModel(modelo);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "No hay Propuestas");
        }
    }//GEN-LAST:event_formInternalFrameOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         this.dispose(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TxtBuscadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscadorKeyTyped
        // TODO add your handling code here:
      
    }//GEN-LAST:event_TxtBuscadorKeyTyped

    private void TxtBuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscadorKeyPressed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_TxtBuscadorKeyPressed

    private void TxtBuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscadorKeyReleased
        // TODO add your handling code here:
         List<String> pro = propuesta.ListarProp();
        if (TxtBuscador.getText().equals("")) { // SI NO BUSCA
            if (!pro.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < pro.size(); i++) {
                    String p = (String) pro.get(i);
                    modelo.addElement(p);
                }
                jLPropuestas.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!pro.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < pro.size(); i++) {
                    String p = (String) pro.get(i);
                    if (p.contains(TxtBuscador.getText())) {
                        modelo.addElement(p);
                    }
                }
                jLPropuestas.setModel(modelo);
            }
        }
    }//GEN-LAST:event_TxtBuscadorKeyReleased

    private void TxtBuscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtBuscadorFocusGained
        // TODO add your handling code here:
         jLPropuestas.setSelectedIndex(-1); //PARA QUE NO BUSCQUE SI SELECCIONA LA CAJA ADEMAS LIMPIA
          TxtDescriopcion.setText("");
          TxtLugar.setText("");
          TxtMontoTotal.setText("");
          TxtMontoActual.setText("");
          TxtPrecio.setText("");
          TxtFecha.setText("");
          TxtFPublica.setText("");
          TxtPropuesto.setText("");
          TxtCategoria.setText("");
          TxtEstado.setText("");
          ImageIcon imagen = new ImageIcon("");
          DefaultListModel modelo = new DefaultListModel(); 
          jLColaboradores.setModel(modelo);
          Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(jLImagen.getWidth(), jLImagen.getHeight(), Image.SCALE_DEFAULT));
          jLImagen.setIcon(icono);
    }//GEN-LAST:event_TxtBuscadorFocusGained

    private void TxtPropuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPropuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPropuestoActionPerformed

    private void TxtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtBuscadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtBuscador;
    private javax.swing.JTextField TxtCategoria;
    private javax.swing.JTextPane TxtDescriopcion;
    private javax.swing.JTextField TxtEstado;
    private javax.swing.JTextField TxtFPublica;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtLugar;
    private javax.swing.JTextField TxtMontoActual;
    private javax.swing.JTextField TxtMontoTotal;
    private javax.swing.JTextField TxtPrecio;
    private javax.swing.JTextField TxtPropuesto;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jLColaboradores;
    private javax.swing.JLabel jLImagen;
    private javax.swing.JList<String> jLPropuestas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
