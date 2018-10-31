/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Colaboracion;
import Logica.DtPropuesta;
import Logica.IPropuesta;
import Logica.Proponente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Aeliner
 */
public class Cancelar_Colaboracion extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cancelar_Colaboracion
     */
    IPropuesta IP;
    public Cancelar_Colaboracion(IPropuesta IP) {
        initComponents();
        this.IP = IP;
        this.setClosable(true);
        cargarDatitos();
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
        listaColabs = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setTitle("Cancelar colaboracion a propuesta");

        listaColabs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Colaborador", "Título de Propuesta", "Fecha", "Hora", "Monto", "Tipo de Retorno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaColabs);
        if (listaColabs.getColumnModel().getColumnCount() > 0) {
            listaColabs.getColumnModel().getColumn(0).setResizable(false);
            listaColabs.getColumnModel().getColumn(1).setResizable(false);
            listaColabs.getColumnModel().getColumn(2).setResizable(false);
            listaColabs.getColumnModel().getColumn(3).setResizable(false);
            listaColabs.getColumnModel().getColumn(4).setResizable(false);
            listaColabs.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int index = listaColabs.getSelectedRow();
        TableModel model = listaColabs.getModel();
        if(!listaColabs.getSelectionModel().isSelectionEmpty())
        {
        String c = (String) model.getValueAt(index, 0);
        String p = (String) model.getValueAt(index, 1);
        this.IP.cancelarColaboracion(c,p);
        cargarDatitos();
        JOptionPane.showMessageDialog(null, "Colaboración cancelada con éxito");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se ha podido cancelar la colaboración");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    void cargarDatitos()
    {
        List<Colaboracion> listita = IP.listarColaboraciones();
        DefaultTableModel model = (DefaultTableModel) listaColabs.getModel();
    model.setRowCount(0);
    for(int i = 0; i < listita.size(); i++)
    {
        Colaboracion p = (Colaboracion) listita.get(i);
        String horita = p.getFecha().toString();
        Object[] dat={p.getColab().getNombre()+"("+p.getColab().getNick()+")", p.getProp().getTitulo(), p.getFecha(), p.getHora(), p.getMonto(), p.getRetorno()};
        model.addRow(dat);
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaColabs;
    // End of variables declaration//GEN-END:variables
}
