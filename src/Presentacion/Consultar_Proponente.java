/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Colaborador;
import Logica.DtColaborador;
import Logica.DtProponente;
import Logica.DtPropuesta;
import Logica.Estado;
import Logica.ICategoria;
import Logica.IPropuesta;
import Logica.IUsuario;
import Logica.Proponente;
import Logica.Propuesta;
import Logica.Testado;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.ListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aeliner
 */
public class Consultar_Proponente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Consultar_Proponente
     */
    
    private IPropuesta IP;
    private ICategoria iCat;
    private IUsuario iUsu;
    private Proponente prop;
    public Consultar_Proponente(IPropuesta Ip, IUsuario iUsu, ICategoria iCat) { 
        initComponents();
        estaditos.addItem("Ingresada");
        estaditos.addItem("Publicada");
        estaditos.addItem("En Financiación");
        estaditos.addItem("Financiada");
        estaditos.addItem("No financiada");
        estaditos.addItem("Cancelada");
        estaditos.setEnabled(false);
        listProp.setEnabled(false);
        listColabs.setEnabled(false);
        
        this.IP = Ip;
        this.iUsu = iUsu;
        this.iCat = iCat;
        List<DtProponente> listita = iUsu.listarProponentes();
    DefaultListModel dlm = new DefaultListModel();
    for(int b = 0; b<listita.size(); b++)
    {
        DtProponente q = (DtProponente) listita.get(b);
        String lul = q.getNombre()+"("+q.getNick()+(")");
        dlm.addElement(lul);
    }
    
    listPropo.setModel(dlm);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPropo = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        filtroProp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        nick = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        fechaNac = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        web = new javax.swing.JTextField();
        estaditos = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        listProp = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        montito = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        filtroColabs = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        listColabs = new javax.swing.JList<>();
        imagenP = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        biografia = new javax.swing.JTextArea();

        listPropo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listPropo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPropoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listPropo);

        jScrollPane2.setViewportView(jScrollPane1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Lista de Proponentes");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filtrar por nombre o nick");
        jLabel2.setFocusable(false);

        filtroProp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filtroPropFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                filtroPropFocusLost(evt);
            }
        });
        filtroProp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtroPropActionPerformed(evt);
            }
        });
        filtroProp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                filtroPropKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtroPropKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre");
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apellido");
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nick");
        jLabel5.setFocusable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Correo");
        jLabel6.setFocusable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Fecha de Nacimiento");
        jLabel7.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Dirección");
        jLabel8.setFocusable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Biografía");
        jLabel9.setFocusable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Sitio web");
        jLabel10.setFocusable(false);

        nombre.setFocusable(false);

        apellido.setFocusable(false);

        nick.setFocusable(false);

        correo.setFocusable(false);
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });

        fechaNac.setFocusable(false);

        direccion.setFocusable(false);

        web.setFocusable(false);

        estaditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        estaditos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estaditosMouseClicked(evt);
            }
        });
        estaditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estaditosActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Filtrar propuestas por estado");
        jLabel11.setFocusable(false);

        listProp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPropMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listProp);

        jScrollPane4.setViewportView(jScrollPane3);

        jLabel12.setText("Lista de Propuestas");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Monto Recaudado");
        jLabel13.setFocusable(false);

        montito.setFocusable(false);

        jLabel14.setText("Lista de Colaboradores");

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

        jScrollPane5.setViewportView(listColabs);

        imagenP.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        biografia.setColumns(20);
        biografia.setRows(5);
        jScrollPane6.setViewportView(biografia);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(filtroProp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(estaditos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(38, 38, 38)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nick, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel9))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                                                    .addComponent(fechaNac))
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 1, Short.MAX_VALUE)))
                                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(81, 81, 81)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(imagenP, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(133, 133, 133)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filtroColabs))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(montito))
                                    .addComponent(jScrollPane5))))
                        .addGap(23, 23, 23))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtroProp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(fechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(imagenP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(105, 105, 105))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(web, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(filtroColabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(montito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(estaditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filtroPropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtroPropActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroPropActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void estaditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estaditosActionPerformed
        String estadoSelec = estaditos.getSelectedItem().toString();
            if(estadoSelec.equals("En Financiación"))
                estadoSelec = "En_Financiacion";
            if(estadoSelec.equals("No financiada"))
                estadoSelec = "No_Financiada";
            List<DtPropuesta> listita = IP.listarPropuestas();
                DefaultListModel dlm = new DefaultListModel();
    for(int b = 0; b<listita.size(); b++)
    {
        DtPropuesta q = (DtPropuesta) listita.get(b);
        Estado f = q.getEstActual();
        if(estadoSelec.equalsIgnoreCase(q.getEstActual().getEstado().toString()) && q.getPropo().equals(this.prop.getNick()))
        {
        String lul = q.getTitulo();
        dlm.addElement(lul);
        }
    }
        listProp.setModel(dlm);
        if(listProp.getModel().getSize() == 0)
        {
            dlm.addElement("No hay propuestas disponibles");
            listProp.setEnabled(false);
            listProp.setFocusable(false);
        }
        else
        {
           listProp.setEnabled(true); 
        listProp.setFocusable(true);
        }
        montito.setText("");
        DefaultListModel dlm2 = new DefaultListModel();
        listColabs.setModel(dlm2);
    }//GEN-LAST:event_estaditosActionPerformed

    private void listPropoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPropoMouseClicked
        
            int index = listPropo.getSelectedIndex();
            
            ListModel  model= listPropo.getModel();
            String f = (String) model.getElementAt(index);
            String[] partes = f.split(Pattern.quote("("));
            String parte1 = partes[0];
            String parte2 = partes[1];
            String[] partes3 = parte2.split(Pattern.quote(")"));
            String parte4 = partes3[0];
            Proponente p = iUsu.traerProponente(parte4);
            nick.setText(p.getNick());
            nombre.setText(p.getNombre());
            apellido.setText(p.getApellido());
            correo.setText(p.getCorreo());
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sd.format(p.getFecha());
            fechaNac.setText(fecha);
            direccion.setText(p.getDireccion());
            biografia.setText(p.getBiografia());
            web.setText(p.getLinkWeb());
            p.getImg();
            ImageIcon imagen = new ImageIcon(p.getImg());
            Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(imagenP.getWidth(), imagenP.getHeight(), Image.SCALE_DEFAULT));
            imagenP.setIcon(icono);
//        this.nick1 = c.getNick();
this.prop = p;
        estaditos.setEnabled(true);
    }//GEN-LAST:event_listPropoMouseClicked

    private void estaditosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estaditosMouseClicked
            
    }//GEN-LAST:event_estaditosMouseClicked

    private void listPropMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPropMouseClicked
        // TODO add your handling code here:
        if(listProp.isEnabled())
        {
        int index = listProp.getSelectedIndex();
        ListModel  model= listProp.getModel();
        String f = (String) model.getElementAt(index);
        DtPropuesta p= IP.traerPropuesta(f);
        List<String> nicks = new ArrayList<>(p.getColabs().keySet());
        DefaultListModel dlm = new DefaultListModel();
        for(int b = 0; b<nicks.size(); b++)
    {
        String lul = (String) nicks.get(b);
        String lul2 = iUsu.traerColaborador(lul).getNombre()+"("+lul+(")");
        dlm.addElement(lul2);
    }
        if(dlm.isEmpty())
        {
            dlm.addElement("Esta propuesta aún no tiene colaboradores");
        }
        listColabs.setModel(dlm);
        montito.setText(Integer.toString(p.getMontoActual())+"/"+Integer.toString(p.getMontototal()));
    }//GEN-LAST:event_listPropMouseClicked
    }
    
    private void filtroPropKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroPropKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtroPropKeyPressed

    private void filtroPropFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtroPropFocusGained
        // TODO add your handling code here:
        listPropo.setSelectedIndex(-1); //PARA QUE NO BUSCQUE SI SELECCIONA LA CAJA ADEMAS LIMPIA
          nombre.setText("");
          apellido.setText("");
          nick.setText("");
          correo.setText("");
          web.setText("");
          biografia.setText("");
          fechaNac.setText("");
          direccion.setText("");
          montito.setText("");
          filtroProp.setText("");
          listPropo.clearSelection();
          ImageIcon imagen = new ImageIcon("");
         DefaultListModel modelo = new DefaultListModel(); 
         listProp.setModel(modelo);
         listColabs.setModel(modelo);
         List<DtProponente> listita = iUsu.listarProponentes();
    DefaultListModel dlm2 = new DefaultListModel();
    for(int b = 0; b<listita.size(); b++)
    {
        DtProponente q = (DtProponente) listita.get(b);
        String lul = q.getNombre()+"("+q.getNick()+(")");
        dlm2.addElement(lul);
    }
    
    listPropo.setModel(dlm2); 
          Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(imagenP.getWidth(), imagenP.getHeight(), Image.SCALE_DEFAULT));
          imagenP.setIcon(icono);
    }//GEN-LAST:event_filtroPropFocusGained

    private void filtroPropFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtroPropFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_filtroPropFocusLost

    private void filtroPropKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroPropKeyReleased
        // TODO add your handling code here:
        List<DtProponente> pro = iUsu.listarProponentes();
        if (filtroProp.getText().equals("")) { // SI NO BUSCA
            if (!pro.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < pro.size(); i++) {
                    DtProponente p = (DtProponente) pro.get(i);
                    modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                }
                listPropo.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!pro.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < pro.size(); i++) {
                    DtProponente p = (DtProponente) pro.get(i);
                    if (p.getNombre().contains(filtroProp.getText()) || p.getNick().contains(filtroProp.getText())) {
                        modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                    }
                }
                listPropo.setModel(modelo);
            }
        }
    }//GEN-LAST:event_filtroPropKeyReleased

    private void filtroColabsFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filtroColabsFocusGained
        // TODO add your handling code here:
//        filtroColabs.setText("");
//        int index = listProp.getSelectedIndex();
//        ListModel  model= listProp.getModel();
//        String f = (String) model.getElementAt(index);
//        DtPropuesta p= IP.traerPropuesta(f);
//        List<String> nicks = new ArrayList<>(p.getColabs().keySet());
//        DefaultListModel dlm = new DefaultListModel();
//        for(int b = 0; b<nicks.size(); b++)
//    {
//        String lul = (String) nicks.get(b);
//        String lul2 = iUsu.traerColaborador(lul).getNombre()+"("+lul+(")");
//        dlm.addElement(lul2);
//    }
//        if(dlm.isEmpty())
//        {
//            dlm.addElement("Esta propuesta aún no tiene colaboradores");
//        }
//        listColabs.setModel(dlm);
    }//GEN-LAST:event_filtroColabsFocusGained

    private void filtroColabsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filtroColabsKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_filtroColabsKeyReleased
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JTextArea biografia;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> estaditos;
    private javax.swing.JTextField fechaNac;
    private javax.swing.JTextField filtroColabs;
    private javax.swing.JTextField filtroProp;
    private javax.swing.JLabel imagenP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> listColabs;
    private javax.swing.JList<String> listProp;
    private javax.swing.JList<String> listPropo;
    private javax.swing.JTextField montito;
    private javax.swing.JTextField nick;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField web;
    // End of variables declaration//GEN-END:variables
}
