/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Colaborador;
import Logica.DtProponente;
import Logica.DtPropuesta;
import Logica.Estado;
import Logica.ICategoria;
import Logica.IPropuesta;
import Logica.IUsuario;
import Logica.Proponente;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.ListModel;

/**
 *
 * @author Luchi
 */
public class ConsultaPropEst extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaPropEst
     */
    private IPropuesta IP;
    private IUsuario iUsu;
    List<DtPropuesta> listitaActual;
    List<Colaborador> colabActuales;
    public ConsultaPropEst(IUsuario iUsu, IPropuesta IP) {
        initComponents();
        estaditos.addItem("Ingresada");
        setClosable(true);
        estaditos.addItem("Publicada");
        estaditos.addItem("En_Financiacion");
        estaditos.addItem("Financiada");
        estaditos.addItem("No_Financiada");
        estaditos.addItem("Cancelada");
        this.IP = IP;
        this.iUsu = iUsu;
        filtroTit.setEnabled(false);
        filtroColabs.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        estaditos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filtroTit = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProp = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listColabs = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        filtroColabs = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        estado = new javax.swing.JTextField();
        proponente = new javax.swing.JTextField();
        categoria = new javax.swing.JTextField();
        precios = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        fechapub = new javax.swing.JTextField();
        montoT = new javax.swing.JTextField();
        montoA = new javax.swing.JTextField();
        lugar = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextPane();

        setTitle("Filtrar Propuestas por Estado");

        estaditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        estaditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estaditosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Lista de Propuestas:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Filtrar por título:");

        filtroTit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filtroTitFocusGained(evt);
            }
        });
        filtroTit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroTitKeyReleased(evt);
            }
        });

        listProp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPropMouseClicked(evt);
            }
        });
        listProp.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPropValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listProp);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Lista de Estados:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filtroTit)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(estaditos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(estaditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroTit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Estado:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Propuesto por:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Categoría:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Precio de entradas:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Fecha:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Fecha de Publicación:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Monto a Recaudar:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Monto Actual:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Lugar:");

        listColabs.setFocusable(false);
        jScrollPane2.setViewportView(listColabs);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Filtrar por Nick o Nombre:");

        filtroColabs.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filtroColabsFocusGained(evt);
            }
        });
        filtroColabs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroColabsKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Lista de Colaboradores:");

        imagen.setFocusable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Descripción:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Imagen:");

        estado.setFocusable(false);

        proponente.setFocusable(false);

        categoria.setFocusable(false);
        categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaActionPerformed(evt);
            }
        });

        precios.setFocusable(false);

        fecha.setFocusable(false);

        fechapub.setFocusable(false);
        fechapub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechapubActionPerformed(evt);
            }
        });

        montoT.setFocusable(false);
        montoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montoTActionPerformed(evt);
            }
        });

        montoA.setFocusable(false);

        lugar.setFocusable(false);
        lugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lugarActionPerformed(evt);
            }
        });

        descripcion.setFocusable(false);
        jScrollPane4.setViewportView(descripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(filtroColabs, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lugar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel3)
                                                .addGap(117, 117, 117))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(proponente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7)
                                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fechapub)
                                            .addComponent(precios)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel8))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(montoT, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(montoA)
                                        .addGap(4, 4, 4)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filtroColabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(precios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechapub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(montoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(montoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estaditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estaditosActionPerformed
        // TODO add your handling code here:
        limpiar();
        filtroTit.setText("");
        String estadoSelec = estaditos.getSelectedItem().toString();
        List<DtPropuesta> listita2 = new ArrayList<>();
            List<DtPropuesta> listita = this.IP.listarPropuestas();
                DefaultListModel dlm = new DefaultListModel();
    for(int b = 0; b<listita.size(); b++)
    {
        DtPropuesta q = (DtPropuesta) listita.get(b);
        Estado f = q.getEstActual();
        if(estadoSelec.equalsIgnoreCase(q.getEstActual().getEstado().toString()))
        {
        String lul = q.getTitulo();
        dlm.addElement(lul);
        listita2.add(q);
        }
    }
        listProp.setModel(dlm);
        if(listProp.getModel().getSize() == 0)
        {
            dlm.addElement("No hay propuestas disponibles");
            listProp.setEnabled(false);
            listProp.setFocusable(false);
            filtroColabs.setEnabled(false);
            filtroTit.setEnabled(false);
        }
        else
        {
           listProp.setEnabled(true); 
        listProp.setFocusable(true);
        filtroTit.setEnabled(true);
        filtroColabs.setEnabled(false);
        }
        DefaultListModel dlm2 = new DefaultListModel();
        listColabs.setModel(dlm2);
        this.listitaActual = listita2;
        
        
    }//GEN-LAST:event_estaditosActionPerformed

    private void filtroTitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtroTitFocusGained
        // TODO add your handling code here:
        limpiar();

    }//GEN-LAST:event_filtroTitFocusGained

    private void filtroTitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroTitKeyReleased
        // TODO add your handling code here:
        this.IP.filtrarP(filtroTit.getText(), listProp, listitaActual);
    }//GEN-LAST:event_filtroTitKeyReleased

    private void listPropValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPropValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listPropValueChanged

    private void listPropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPropMouseClicked
        // TODO add your handling code here:
        if(listProp.getModel().getSize() > 0 && listProp.isEnabled())
        {
           List<Colaborador> listitacolabs = new ArrayList<>();
        int index = listProp.getSelectedIndex();
        ListModel  model= listProp.getModel();
        String f = (String) model.getElementAt(index);
        DtPropuesta p= IP.SeleccionarProp(f);
        List<String> nicks = new ArrayList<>(p.getColabs().keySet());
        DefaultListModel dlm = new DefaultListModel();
        for(int b = 0; b<nicks.size(); b++)
    {
        String lul = (String) nicks.get(b);
        String lul2 = iUsu.traerColaborador(lul).getNombre()+"("+lul+(")");
        dlm.addElement(lul2);
        listitacolabs.add(iUsu.traerColaborador(lul));
    }
        if(dlm.isEmpty())
        {
            dlm.addElement("Esta propuesta aún no tiene colaboradores");
        }
        listColabs.setModel(dlm);
        this.colabActuales = listitacolabs;
        estado.setText(p.getEstActual().getEstado().toString());
        Proponente e = iUsu.traerProponente(p.getPropo());
        proponente.setText(e.getNombre()+"("+e.getNick()+")");
        categoria.setText(p.getNombreCate());
        lugar.setText(p.getLugar());
        fecha.setText(p.getFecha().toString());
        fechapub.setText(p.getFecha().toString());
        precios.setText(Integer.toString(p.getPrecio()));
        montoT.setText(Integer.toString(p.getMontototal()));
        descripcion.setText(p.getDescripcion());
        montoA.setText(Integer.toString(p.getMontoActual()));
        filtroColabs.setText("");
        filtroColabs.setEnabled(true);
        if(p.getImg() == null || p.getImg().equals("")){
            ImageIcon img = new ImageIcon("Imagenes/not-available-es.png");
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
            imagen.setIcon(icono);
        }else{
        ImageIcon imagen2 = new ImageIcon(p.getImg());
            Icon icono = new ImageIcon(imagen2.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
            imagen.setIcon(icono);
        }
    } 
    }//GEN-LAST:event_listPropMouseClicked

    private void categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaActionPerformed

    private void fechapubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechapubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechapubActionPerformed

    private void montoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montoTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_montoTActionPerformed

    private void lugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lugarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lugarActionPerformed

    private void filtroColabsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtroColabsFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_filtroColabsFocusGained

    private void filtroColabsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroColabsKeyReleased
        // TODO add your handling code here:
        if(colabActuales != null)
        this.iUsu.filtrarC(filtroColabs.getText(), listColabs, colabActuales);
    }//GEN-LAST:event_filtroColabsKeyReleased

    private void limpiar()
    {
        estado.setText("");
        proponente.setText("");
        categoria.setText("");
        lugar.setText("");
        fecha.setText("");
        fechapub.setText("");
        precios.setText("");
        montoT.setText("");
        montoA.setText("");
        descripcion.setText("");
        listProp.clearSelection();
        listColabs.clearSelection();
        filtroColabs.setText("");
        ImageIcon imagen2 = new ImageIcon("");
        Icon icono = new ImageIcon(imagen2.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_DEFAULT));
          imagen.setIcon(icono);
          DefaultListModel modelo = new DefaultListModel();
          listColabs.setModel(modelo);
          this.colabActuales = null;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoria;
    private javax.swing.JTextPane descripcion;
    private javax.swing.JComboBox<String> estaditos;
    private javax.swing.JTextField estado;
    private javax.swing.JTextField fecha;
    private javax.swing.JTextField fechapub;
    private javax.swing.JTextField filtroColabs;
    private javax.swing.JTextField filtroTit;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> listColabs;
    private javax.swing.JList<String> listProp;
    private javax.swing.JTextField lugar;
    private javax.swing.JTextField montoA;
    private javax.swing.JTextField montoT;
    private javax.swing.JTextField precios;
    private javax.swing.JTextField proponente;
    // End of variables declaration//GEN-END:variables
}
