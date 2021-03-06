/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtPropuesta;
import Logica.IPropuesta;
import Logica.IUsuario;
import Logica.Proponente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Nazareno
 */
public class Evaluar_Propuesta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Evaluar_Propuesta
     */
    
    IPropuesta IP;
    IUsuario iUsu;
    List<DtPropuesta> listitaActual;
    public Evaluar_Propuesta(IPropuesta IP, IUsuario iUsu) {
        initComponents();
        this.IP = IP;
        this.iUsu = iUsu;
        cargarProps();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaProps = new javax.swing.JTable();
        filtroProps = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Evaluar Propuesta");

        listaProps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Título", "Proponente"
            }
        ));
        jScrollPane1.setViewportView(listaProps);

        filtroProps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroPropsActionPerformed(evt);
            }
        });
        filtroProps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroPropsKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Filtrar por Tïtulo o Proponente");

        jButton1.setText("Publicar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtroProps, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroProps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroPropsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroPropsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroPropsActionPerformed

    private void filtroPropsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroPropsKeyReleased
        // TODO add your handling code here:
        listaProps.setModel( IP.BUSCADOR_Propuestas2(filtroProps.getText(), this.listitaActual, listaProps.getModel()));
    }//GEN-LAST:event_filtroPropsKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = listaProps.getSelectedRow();
        if(index > -1)
        {
        TableModel model = listaProps.getModel();
        String f = (String) model.getValueAt(index, 0);
        IP.cambiarEstadito(f, "Publicada");
        }
        cargarProps();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = listaProps.getSelectedRow();
        if(index > -1)
        {
        TableModel model = listaProps.getModel();
        String f = (String) model.getValueAt(index, 0);
        IP.cambiarEstadito(f, "Cancelada");
        }
        cargarProps();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void cargarProps()
    {
        this.listitaActual = new ArrayList<>();
        this.listitaActual.clear();
        List<DtPropuesta> listita = this.IP.listarPropuestas();
        DefaultTableModel model = (DefaultTableModel) listaProps.getModel();
        model.setRowCount(0);
        for (int i = 0; i < listita.size(); i++) {
            DtPropuesta p = (DtPropuesta) listita.get(i);
            if(p.getEstActual().getEstado().toString().equals("Ingresada"))
            {
              this.listitaActual.add(p);
            Proponente p2 = iUsu.traerProponente(p.getPropo());
            Object[] dat = {p.getTitulo(), p2.getNombre() + "(" + p2.getNick() + ")"};
            model.addRow(dat);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filtroProps;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaProps;
    // End of variables declaration//GEN-END:variables
}

