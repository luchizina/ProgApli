/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import Logica.DtCategoria;
import Logica.DtColaborador;
import Logica.IPropuesta;
import Logica.DtProponente;
import Logica.Estado;
import Logica.ICategoria;
import Logica.IUsuario;
import Logica.Testado;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Luchi
 */
public class Alta_propuesta extends javax.swing.JInternalFrame {

    /**
     * Creates new form Alta_propuesta
     */
     private IPropuesta IP;
     private IUsuario iUsu;
     private ICategoria iCat;

     public Alta_propuesta(IPropuesta IP,ICategoria cat, IUsuario iUs) throws ParseException
    {
        initComponents();
        this.IP = IP;
        Jpanel1.setVisible(false);
        this.iCat = cat;
        this.iUsu = iUs;
        cargar();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date desde = new Date();
        Date hasta = sd.parse("2030-01-01");
        this.jDate.setSelectableDateRange(desde, hasta);
        urlimagen.setVisible(false);
         List<DtProponente> listita = iUsu.listarProponentes();
    DefaultListModel dlm = new DefaultListModel();
    for(int b = 0; b<listita.size(); b++)
    {
        DtProponente q = (DtProponente) listita.get(b);
        String lul = q.getNombre()+"("+q.getNick()+(")");
        dlm.addElement(lul);
    }
     ListProp.setModel(dlm);   
     
      List<DtCategoria> catego = this.iCat.listarCategorias();
       DefaultTreeModel modeloArbol = null;
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categoria");
        construirArbolito(catego, raiz);
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        opc = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Jpanel1 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        urlimagen = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jR1 = new javax.swing.JRadioButton();
        jR2 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt2 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        jCateg = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListProp = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel12 = new javax.swing.JLabel();
        jCo = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        adv2 = new javax.swing.JLabel();
        jTitulo = new javax.swing.JTextField();
        adv1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDesc = new javax.swing.JTextArea();
        jLugar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDate = new com.toedter.calendar.JDateChooser();
        jPrecioE = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPrecioT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setClosable(true);
        setResizable(true);
        setTitle("Alta propuesta");
        setToolTipText("Alta propuesta");
        setAutoscrolls(true);
        setVisible(true);

        img.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Subir imagen");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        urlimagen.setEditable(false);
        urlimagen.setEnabled(false);

        jLabel14.setText("Imagen:");

        javax.swing.GroupLayout Jpanel1Layout = new javax.swing.GroupLayout(Jpanel1);
        Jpanel1.setLayout(Jpanel1Layout);
        Jpanel1Layout.setHorizontalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Jpanel1Layout.createSequentialGroup()
                        .addGroup(Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urlimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Jpanel1Layout.setVerticalGroup(
            Jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Jpanel1Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(urlimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jLabel2.setText("*Proponente:");

        jR1.setText("Porcentaje entradas");

        jR2.setText("Entradas gratis");

        jLabel4.setText("*Tipo de retorno");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jR2)
                    .addComponent(jR1)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jR1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jR2)
                .addGap(16, 16, 16))
        );

        jLabel3.setText("*Categoría:");

        bt2.setText("Guardar");
        bt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt2MouseClicked(evt);
            }
        });
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        bt1.setText("Cancelar");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        jCateg.setBorder(null);
        jCateg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCateg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCategActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(ListProp);

        jScrollPane3.setViewportView(jTree1);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Complete estos datos:");

        jCo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCoKeyPressed(evt);
            }
        });

        adv2.setToolTipText("");

        adv1.setToolTipText("");

        jLabel5.setText("*Título:");

        jLabel6.setText("Descripcion:");

        jDesc.setColumns(20);
        jDesc.setRows(5);
        jScrollPane1.setViewportView(jDesc);

        jLabel7.setText("*Lugar:");
        jLabel7.setToolTipText("");

        jLabel8.setText("*Fecha:");
        jLabel8.setToolTipText("");

        jDate.getDateEditor().setEnabled(false);

        jPrecioE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrecioEActionPerformed(evt);
            }
        });
        jPrecioE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPrecioEKeyTyped(evt);
            }
        });

        jLabel9.setText("*Precio entrada:");
        jLabel9.setToolTipText("");

        jLabel10.setText("*Monto necesario:");
        jLabel10.setToolTipText("");

        jPrecioT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPrecioTKeyTyped(evt);
            }
        });

        jLabel11.setText("Imagen:");
        jLabel11.setToolTipText("");

        opc.add(jRadioButton1);
        jRadioButton1.setLabel("Sí");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        opc.add(jRadioButton2);
        jRadioButton2.setLabel("No");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPrecioT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adv1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPrecioE, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adv2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jPrecioE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(adv2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jPrecioT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adv1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCo))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCateg, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(Jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(bt2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jCateg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt2)
                                .addComponent(bt1)))))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(Jpanel1.isVisible() == true){
            Jpanel1.setVisible(false);
        }
      urlimagen.setText("");
      img.setIcon(null);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(Jpanel1.isVisible() == false){
            Jpanel1.setVisible(true);
        } 
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setVerticalAlignment(JLabel.CENTER);
        ImageIcon imgencita = new ImageIcon("Imagenes/prop.png");
        Icon iconito = new ImageIcon(imgencita.getImage().getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_DEFAULT));
        img.setIcon(iconito);
       

// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt2ActionPerformed
        
      //your handling code here:
    }//GEN-LAST:event_bt2ActionPerformed
public static String getHoraActual() {
    Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
    return formateador.format(ahora);
}
 private boolean vacios() {
        if (jTitulo.getText().equals("") || jLugar.getText().equals("") || jPrecioE.getText().equals("") || jPrecioT.getText().equals("") || ((String) jCateg.getSelectedItem()).equals("") || ((String) ListProp.getSelectedValue()).equals("") || (!jR1.isSelected() && !jR2.isSelected()) || (!jRadioButton1.isSelected() && !jRadioButton2.isSelected()) || jDate.getDate() == null || (jRadioButton1.isSelected() && urlimagen.getText().equals(""))) {
            return true;
        }
        return false;
    }
 private void limpiar() {
        jTitulo.setText("");
        jDesc.setText("");
        jLugar.setText("");
        jPrecioE.setText("");
        jDate.setDate(null);
        jPrecioT.setText("");
        jR1.setSelected(false);
        jR2.setSelected(false);
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(false);
        urlimagen.setText("");
        img.setIcon(null);
    }
    private void bt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt2MouseClicked
     String hora = getHoraActual();
      Estado estA = new Estado(Testado.Ingresada);
      String TRetorno;
      //
      if(ListProp.getSelectedIndex()>-1){
          
      
        String f = (String) ListProp.getSelectedValue();
        
        String[] partes = f.split(Pattern.quote("("));
        String parte1 = partes[0];
        String parte2 = partes[1];
        String[] partes3 = parte2.split(Pattern.quote(")"));
        String parte4 = partes3[0];
        if(jR1.isSelected() && jR2.isSelected()){
            TRetorno= "entrada" + ", " + "porcentaje";
        }
        else if(jR1.isSelected() && !(jR2.isSelected())){
            TRetorno="porcentaje";
        }
        else 
        {
            TRetorno="entrada";
        }
        
        if(vacios() == false)
        {
              if (jTree1.isSelectionEmpty()==true) {
                  
                   javax.swing.JOptionPane.showMessageDialog(null, "Tiene que seleccionar una categoría válida");
              }else if(jTree1.getSelectionPath().getLastPathComponent().toString().equals("Categoria") == true){
                      
                 javax.swing.JOptionPane.showMessageDialog(null, "Tiene que seleccionar una categoría válida");
               
                 
                        }
              
              else if(jRadioButton1.isSelected() || jRadioButton2.isSelected())
         {
             String catego= jTree1.getSelectionPath().getLastPathComponent().toString();
             
        boolean ok=IP.AgregarPropuesta(jTitulo.getText(), jDesc.getText(), jDate.getDate(), Integer.parseInt(jPrecioE.getText()),0,jDate.getDate(),TRetorno,Integer.parseInt(jPrecioT.getText()),catego,estA,urlimagen.getText(),parte4,hora,jLugar.getText());
             if (ok){
            javax.swing.JOptionPane.showMessageDialog(null,"Propuesta Dada de alta");
            limpiar();
             }else{
            javax.swing.JOptionPane.showMessageDialog(null,"Error al dar de alta la propuesta o la propuesta ya existe");
             }
         } else {
                 JOptionPane.showMessageDialog(null, "El titulo ya esta en uso");
             }
         }
        
        else{
            javax.swing.JOptionPane.showMessageDialog(null,"Algún campo obligatorio está vacio, por favor verifique.");
            
        }
      }else{
           javax.swing.JOptionPane.showMessageDialog(null,"Algún campo obligatorio está vacio, por favor verifique.");
      }
    }//GEN-LAST:event_bt2MouseClicked

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        this.limpiar();
        this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_bt1ActionPerformed

    private void jCategActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCategActionPerformed
     
    }//GEN-LAST:event_jCategActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (evt.getSource() == jButton1) {
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagenes", "jpg", "png");
            j.setFileFilter(filtro);
            int ap = j.showOpenDialog(this);
            if (ap == JFileChooser.APPROVE_OPTION) {
                File file = j.getSelectedFile();
                String ruta = file.getPath();
                this.urlimagen.setText(ruta);
                ImageIcon imagen3 = new ImageIcon(ruta);
                Icon icono = new ImageIcon(imagen3.getImage().getScaledInstance(this.img.getWidth(), this.img.getHeight(), Image.SCALE_DEFAULT));
                this.img.setIcon(icono);
                this.pack();
            }
      }
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void jPrecioEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrecioEActionPerformed
        
    }//GEN-LAST:event_jPrecioEActionPerformed

    private void jPrecioEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPrecioEKeyTyped
        char car = evt.getKeyChar();
        if (Character.isDigit(car)) {
            adv2.setText("");
        } else {
             adv2.setText("Solo se admiten numeros");
             evt.consume();
        }
    }//GEN-LAST:event_jPrecioEKeyTyped

    private void jPrecioTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPrecioTKeyTyped
        char car = evt.getKeyChar();
        if (Character.isDigit(car)) {
            adv1.setText("");
        } else {
             adv1.setText("Solo se admiten numeros");
             evt.consume();
        }      
    }//GEN-LAST:event_jPrecioTKeyTyped

    private void jCoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCoKeyPressed
          List<DtProponente> prop = iUsu.listarProponentes();
        if (jCo.getText().equals("")) { // SI NO BUSCA
            if (!prop.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < prop.size(); i++) {
                    DtProponente p = (DtProponente) prop.get(i);
                    modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                }
                ListProp.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!prop.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i <prop.size(); i++) {
                    DtProponente p = (DtProponente) prop.get(i);
                    if (p.getNombre().contains(jCo.getText()) || p.getNick().contains(jCo.getText())) {
                        modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                    }
                }
                ListProp.setModel(modelo);
               
               
            }
        }
    }//GEN-LAST:event_jCoKeyPressed
 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel1;
    private javax.swing.JList<String> ListProp;
    private javax.swing.JLabel adv1;
    private javax.swing.JLabel adv2;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCateg;
    private javax.swing.JTextField jCo;
    private com.toedter.calendar.JDateChooser jDate;
    private javax.swing.JTextArea jDesc;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLugar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jPrecioE;
    private javax.swing.JTextField jPrecioT;
    private javax.swing.JRadioButton jR1;
    private javax.swing.JRadioButton jR2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTitulo;
    private javax.swing.JTree jTree1;
    private javax.swing.ButtonGroup opc;
    private javax.swing.JTextField urlimagen;
    // End of variables declaration//GEN-END:variables

    private void cargar(){
        this.iCat.cargarCategorias();
      //  List<DtCategoria> catego = this.iCat.listarCategorias();
        List<DtCategoria> combo = this.iCat.listarCategorias();
        for(int i=0; i< combo.size(); i++){
            DtCategoria combito=(DtCategoria) combo.get(i);
                       jCateg.addItem(combito.getNombre());
        }
        
        }
    
    
    
      private void construirArbolito(List<DtCategoria> catego, DefaultMutableTreeNode raiz) {
        Collections.sort(catego, (DtCategoria dt1, DtCategoria dt2) -> dt1.getProfundidad() - dt2.getProfundidad());
        for (int i = 0; i < catego.size(); i++) {
            jTree1.setModel(this.imprimirArbol(catego.get(i), raiz));
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
    
    
    }
    
    

