/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtCategoria;
import Logica.DtPropuesta;
import Logica.ICategoria;
import Logica.IPropuesta;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 *
 * @author Nuevo
 */
public class Modificar_Propuesta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Modificar_Propuesta
     */
    private IPropuesta prop;
    private ICategoria cat;

    public Modificar_Propuesta(IPropuesta p, ICategoria icat) throws ParseException {
        initComponents();
        this.prop = p;
        this.cat = icat;
        this.cat.cargarCategorias();
        List<DtCategoria> catego = this.cat.listarCategorias();
        this.lista();
        DefaultTreeModel modeloArbol = null;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categoria");
        construirArbolito(catego, raiz);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date desde = new Date();
        Date hasta = sd.parse("2030-01-01");
        this.fechaEv.setSelectableDateRange(desde, hasta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        titulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaEv = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lugar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        imagenProp = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        estado = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        proponente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        porcentaje = new javax.swing.JRadioButton();
        entrada = new javax.swing.JRadioButton();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        actual = new javax.swing.JTextField();
        catAct = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        entradaP = new javax.swing.JLabel();
        montoN = new javax.swing.JLabel();
        lugarCont = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        retornoact = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        arbol = new javax.swing.JTree();
        retornocamb = new javax.swing.JTextField();
        url = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Modificar Propuesta");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Modificar Propuesta");

        lista.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarFocusGained(evt);
            }
        });
        buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarKeyReleased(evt);
            }
        });

        jLabel2.setText("Buscar:");

        jLabel3.setText("Titulo:");

        titulo.setEditable(false);

        jLabel5.setText("Fecha:");

        fechaEv.getDateEditor().setEnabled(false);

        jLabel6.setText("Precio de entrada:");

        precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioKeyTyped(evt);
            }
        });

        jLabel7.setText("Monto necesario:");

        monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                montoKeyTyped(evt);
            }
        });

        jLabel8.setText("Lugar:");

        lugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lugarKeyTyped(evt);
            }
        });

        jLabel9.setText("Categoria:");

        imagenProp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nuevo.setText("Nueva imagen");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado:");

        estado.setEditable(false);

        jLabel12.setText("Proponente:");

        proponente.setEditable(false);

        jLabel13.setText("Nuevo retorno:");

        porcentaje.setText("Porcentaje");

        entrada.setText("Entradas");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Descripcion: ");

        descripcion.setColumns(20);
        descripcion.setRows(5);
        jScrollPane2.setViewportView(descripcion);

        jLabel10.setText("Monto Actual:");

        actual.setEditable(false);

        catAct.setEditable(false);

        jLabel14.setText("Nueva categoria:");

        entradaP.setText("jLabel15");

        montoN.setText("jLabel15");

        lugarCont.setText("jLabel15");

        jLabel15.setText("Retorno:");

        retornoact.setEditable(false);

        jScrollPane3.setViewportView(arbol);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(imagenProp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5))
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(nuevo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lugarCont)
                                    .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(proponente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaEv, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(catAct, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(entrada)
                                    .addComponent(porcentaje)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(actual, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(montoN)
                                            .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(retornoact, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(entradaP)
                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(aceptar)
                                .addGap(53, 53, 53)
                                .addComponent(cancelar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imagenProp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(nuevo)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(actual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(montoN))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(catAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(entradaP)
                                            .addComponent(jLabel4))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(retornoact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(porcentaje))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(entrada))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(proponente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(fechaEv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lugarCont))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        retornocamb.setVisible(false);

        url.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(retornocamb)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(url)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(retornocamb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void construirArbolito(List<DtCategoria> catego, DefaultMutableTreeNode raiz) {
        Collections.sort(catego, (DtCategoria dt1, DtCategoria dt2) -> dt1.getProfundidad() - dt2.getProfundidad());
        for (int i = 0; i < catego.size(); i++) {
            arbol.setModel(this.imprimirArbol(catego.get(i), raiz));
        }
    }

    public DefaultTreeModel imprimirArbol(DtCategoria catego, DefaultMutableTreeNode raiz) {
        if (catego.getPadre().compareTo(raiz.toString()) == 0) {
            DefaultMutableTreeNode nodito = new DefaultMutableTreeNode(catego.getNombre());
            raiz.add(nodito);
        } else {
            for (int i = 0; i < raiz.getChildCount(); i++) {
                imprimirArbol(catego, (DefaultMutableTreeNode) raiz.getChildAt(i));
            }
        }
        DefaultTreeModel modelito = new DefaultTreeModel(raiz);
        return modelito;
    }

    private void listaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaValueChanged
        if (lista.getSelectedIndex() != -1) {
            DtPropuesta propu = prop.SeleccionarProp(lista.getSelectedValue());
            Date fecha = propu.getFecha();
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
            String fechita = sd.format(fecha);
            descripcion.setText(propu.getDescripcion());
            lugar.setText(propu.getLugar());
            actual.setText(Integer.toString(propu.getMontoActual()));
            monto.setText(Integer.toString(propu.getMontototal()));
            precio.setText(Integer.toString(propu.getPrecio()));
            fechaEv.setDate(fecha);
            proponente.setText(propu.getPropo());
            titulo.setText(propu.getTitulo());
            url.setText(propu.getImg());
            if(propu.getImg() != null){
            ImageIcon img = new ImageIcon(propu.getImg());
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(imagenProp.getWidth(), imagenProp.getHeight(), Image.SCALE_DEFAULT));
            imagenProp.setIcon(icono);
            } else if (propu.getImg() == null){
            ImageIcon img = new ImageIcon("Imagenes/not-available-es.png");
            Icon icono = new ImageIcon(img.getImage().getScaledInstance(imagenProp.getWidth(), imagenProp.getHeight(), Image.SCALE_DEFAULT));
            imagenProp.setIcon(icono);
            }
            TreePath tp = new TreePath(propu.getNombreCate());
            arbol.setSelectionPath(tp);
            catAct.setText(propu.getNombreCate());
            if (propu.getEstActual() != null) {
                if (propu.getEstActual().getEstado().toString().equals("Ingresada")) {
                    estado.setText("Ingresada");
                } else if (propu.getEstActual().getEstado().toString().equals("Publicada")) {
                    estado.setText("Publicada");
                } else if (propu.getEstActual().getEstado().toString().equals("En_Financiacion")) {
                    estado.setText("En Financiacion");
                } else if (propu.getEstActual().getEstado().toString().equals("Financiada")) {
                    estado.setText("Financiada");
                } else if (propu.getEstActual().getEstado().toString().equals("No_Financiada")) {
                    estado.setText("No Financiada");
                } else {
                    estado.setText("Cancelada");
                }
            }

            String retorno = propu.getTRetornos();
            if (retorno.equals("entrada, porcentaje")) {
                entrada.setSelected(true);
                porcentaje.setSelected(true);
                retornoact.setText("entrada, porcentaje");
            }

            if (retorno.equals("entrada")) {
                entrada.setSelected(true);
                porcentaje.setSelected(false);
                retornoact.setText("entrada");
            }
            if (retorno.equals("porcentaje")) {
                entrada.setSelected(false);
                porcentaje.setSelected(true);
                retornoact.setText("porcentaje");
            }

            entradaP.setText("");
            montoN.setText("");
            lugarCont.setText("");

        }
    }//GEN-LAST:event_listaValueChanged

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        /*List<String> pro = prop.ListarProp();
        
        if (buscar.getText().equals("")) {
            if (!pro.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < pro.size(); i++) {
                    String p = (String) pro.get(i);
                    modelo.addElement(p);
                }
                lista.setModel(modelo);
            }
        } else {
            if (!pro.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < pro.size(); i++) {
                    String p = (String) pro.get(i);
                    if (p.contains(buscar.getText())) {
                        modelo.addElement(p);
                    }
                }
                lista.setModel(modelo);
            }
        }*/
        this.prop.filtrar(this.buscar.getText(), lista);
    }//GEN-LAST:event_buscarKeyReleased

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

        JFileChooser j = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg", "png");
        j.setFileFilter(filtro);
        int ap = j.showOpenDialog(this);
        if (ap == JFileChooser.APPROVE_OPTION) {
            File file = j.getSelectedFile();
            String ruta = file.getPath();
            this.url.setText(ruta);
            ImageIcon imagen3 = new ImageIcon(ruta);
            Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(this.imagenProp.getWidth(), this.imagenProp.getHeight(), Image.SCALE_DEFAULT));
            this.imagenProp.setIcon(icono);
            this.pack();
        }
    }//GEN-LAST:event_nuevoActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (lista.getSelectedValue() != null) {
            if (arbol.getSelectionPath().getLastPathComponent().toString().equals("Categoria") == false) {
                if (catAct.getText().equals(arbol.getSelectionPath().getLastPathComponent().toString()) == false || arbol.getSelectionPath().getLastPathComponent() != null) {
                    catAct.setText(arbol.getSelectionPath().getLastPathComponent().toString());
                }
                if (entrada.isSelected() && porcentaje.isSelected()) {
                    retornocamb.setText("entrada" + ", " + "porcentaje");
                } else if (entrada.isSelected() && !(porcentaje.isSelected())) {
                    retornocamb.setText("entrada");
                } else {
                    retornocamb.setText("porcentaje");
                }

                if (this.vacio()) {
                    JOptionPane.showMessageDialog(null, "Ha dejado campos vacios");
                } else {
                    if (entrada.isSelected() == false && porcentaje.isSelected() == false) {
                        retornocamb.setText("");
                        JOptionPane.showMessageDialog(null, "Debe seleccionar algun tipo de retorno");
                    } else {
                        if (retornoact.getText().equals(retornocamb.getText()) == false && retornocamb.getText().equals("") == false) {
                            retornoact.setText(retornocamb.getText());
                        }
                        boolean ok = this.prop.actualizarDatos(titulo.getText(), fechaEv.getDate(), Integer.parseInt(precio.getText()), Integer.parseInt(monto.getText()), lugar.getText(), catAct.getText(), retornoact.getText(), descripcion.getText(), url.getText());
                        if (ok) {
                            JOptionPane.showMessageDialog(null, "Datos modificados");
                            this.limpiar();
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al modificar los datos");
                            this.limpiar();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "La categoria no puede ser seleccionada");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ha seleccionado alguna propuesta");
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void limpiar() {
        lista.setSelectedIndex(-1); //PARA QUE NO BUSCQUE SI SELECCIONA LA CAJA ADEMAS LIMPIA
        descripcion.setText("");
        lugar.setText("");
        monto.setText("");
        actual.setText("");
        precio.setText("");
        fechaEv.setDate(null);
        titulo.setText("");
        catAct.setText("");
        porcentaje.setSelected(false);
        entrada.setSelected(false);
        estado.setText("");
        proponente.setText("");
        ImageIcon imagen = new ImageIcon("");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(imagenProp.getWidth(), imagenProp.getHeight(), Image.SCALE_DEFAULT));
        imagenProp.setIcon(icono);
        entradaP.setText("");
        montoN.setText("");
        lugarCont.setText("");
        retornoact.setText("");
        lista.clearSelection();
    }
    private void buscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarFocusGained
        this.limpiar();
    }//GEN-LAST:event_buscarFocusGained

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.limpiar();
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioKeyTyped
        char car = evt.getKeyChar();
        if (car == KeyEvent.VK_BACK_SPACE || Character.isDigit(car)) {
            entradaP.setText("");
        } else {
            evt.consume();
            entradaP.setText("Solo numeros");
        }
    }//GEN-LAST:event_precioKeyTyped

    private void montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_montoKeyTyped
        char car = evt.getKeyChar();
        if (car == KeyEvent.VK_BACK_SPACE || Character.isDigit(car)) {
            montoN.setText("");
        } else {
            evt.consume();
            montoN.setText("Solo numeros");
        }
    }//GEN-LAST:event_montoKeyTyped


    private void lugarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lugarKeyTyped
        char car = evt.getKeyChar();
        if (Character.isLetter(car) || car == KeyEvent.VK_BACK_SPACE || car == KeyEvent.VK_SPACE || Character.isDigit(car)) {
            lugarCont.setText("");
        } else {
            evt.consume();
            lugarCont.setText("Solo letras o numeros");
        }
    }//GEN-LAST:event_lugarKeyTyped

    private void lista() {
        List<String> pro = prop.ListarProp();
        if (!pro.isEmpty()) {
            DefaultListModel modelo = new DefaultListModel();
            for (int i = 0; i < pro.size(); i++) {
                String p = (String) pro.get(i);
                modelo.addElement(p);
            }
            lista.setModel(modelo);
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "No hay Propuestas");
        }
    }

    private boolean vacio() {
        String lug = lugar.getText().trim();
        String mon = monto.getText().trim();
        String prec = precio.getText().trim();
        String des = descripcion.getText().trim();
        if (lug.isEmpty() || mon.isEmpty() || prec.isEmpty()
                || des.isEmpty() || catAct.getText().equals("")) {
            return true;
        }
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField actual;
    private javax.swing.JTree arbol;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField catAct;
    private javax.swing.JTextArea descripcion;
    private javax.swing.JRadioButton entrada;
    private javax.swing.JLabel entradaP;
    private javax.swing.JTextField estado;
    private com.toedter.calendar.JDateChooser fechaEv;
    private javax.swing.JLabel imagenProp;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField lugar;
    private javax.swing.JLabel lugarCont;
    private javax.swing.JTextField monto;
    private javax.swing.JLabel montoN;
    private javax.swing.JButton nuevo;
    private javax.swing.JRadioButton porcentaje;
    private javax.swing.JTextField precio;
    private javax.swing.JTextField proponente;
    private javax.swing.JTextField retornoact;
    private javax.swing.JTextField retornocamb;
    private javax.swing.JTextField titulo;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
