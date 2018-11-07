/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DtProponente;
import Logica.IPropuesta;
import Logica.IUsuario;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author matheo
 */
public class Consulta_Desactivados extends javax.swing.JInternalFrame {

    private IUsuario IU;
    private IPropuesta IP;
    
    /**
     * Creates new form Consulta_Desactivados
     */
    public Consulta_Desactivados() {
        initComponents();
    }
    
    public Consulta_Desactivados(IUsuario xIU, IPropuesta xIP) {
        initComponents();
        this.IU = xIU;
        this.IP = xIP;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txt_Correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Txt_FechaNac = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Txt_Direccion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Txt_PaginaWeb = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        Txt_FechaDesac = new javax.swing.JTextField();
        Jl_Imagen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_Proponentes = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        List_Propuestas = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Colaboraciones = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        Txt_Biografia = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        Txt_Buscador = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Txt_Nick = new javax.swing.JTextField();
        Txt_Apellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Txt_Nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setTitle("Consulta de desactivados");
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

        Txt_Correo.setEditable(false);
        Txt_Correo.setEnabled(false);
        Txt_Correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_CorreoActionPerformed(evt);
            }
        });

        jLabel6.setText("Fecha de nacimiento:");

        Txt_FechaNac.setEditable(false);
        Txt_FechaNac.setEnabled(false);

        jLabel7.setText("Direccion:");

        Txt_Direccion.setEditable(false);
        Txt_Direccion.setEnabled(false);

        jLabel8.setText("Pagina Web:");

        Txt_PaginaWeb.setEditable(false);
        Txt_PaginaWeb.setEnabled(false);
        Txt_PaginaWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_PaginaWebActionPerformed(evt);
            }
        });

        jLabel9.setText("Fecha de desactivacion:");

        Txt_FechaDesac.setEditable(false);
        Txt_FechaDesac.setEnabled(false);
        Txt_FechaDesac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_FechaDesacActionPerformed(evt);
            }
        });

        jLabel10.setText("Imagen:");

        List_Proponentes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                List_ProponentesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(List_Proponentes);

        jLabel11.setText("Biografia:");

        jLabel1.setText("Buscar:");

        List_Propuestas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                List_PropuestasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(List_Propuestas);

        Table_Colaboraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Colaborador", "Monto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Colaboraciones.setEnabled(false);
        jScrollPane3.setViewportView(Table_Colaboraciones);

        Txt_Biografia.setEditable(false);
        jScrollPane4.setViewportView(Txt_Biografia);

        jLabel12.setText("Propuestas:");

        Txt_Buscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Txt_BuscadorFocusGained(evt);
            }
        });
        Txt_Buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_BuscadorActionPerformed(evt);
            }
        });
        Txt_Buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_BuscadorKeyReleased(evt);
            }
        });

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Txt_Nick.setEditable(false);
        Txt_Nick.setEnabled(false);
        Txt_Nick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_NickActionPerformed(evt);
            }
        });

        Txt_Apellido.setEditable(false);
        Txt_Apellido.setEnabled(false);
        Txt_Apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_ApellidoActionPerformed(evt);
            }
        });

        jLabel2.setText("Nick:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Nombre:");

        Txt_Nombre.setEditable(false);
        Txt_Nombre.setEnabled(false);
        Txt_Nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_NombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Correo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2)
                                .addGap(89, 89, 89)
                                .addComponent(jLabel5)
                                .addGap(125, 125, 125)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel11)
                                .addGap(175, 175, 175)
                                .addComponent(jLabel12)))
                        .addGap(0, 204, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Txt_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(Txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(Txt_FechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(Txt_Nick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                        .addComponent(Txt_Nombre, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(Txt_FechaDesac, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Txt_Correo, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(Txt_Direccion)
                                            .addComponent(Txt_PaginaWeb))))
                                .addGap(18, 18, 18)
                                .addComponent(Jl_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(14, 66, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Txt_Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Txt_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(Txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(Txt_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(Txt_FechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Txt_Correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7)
                        .addGap(1, 1, 1)
                        .addComponent(Txt_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(Txt_PaginaWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(Txt_FechaDesac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Jl_Imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel12)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Txt_CorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_CorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_CorreoActionPerformed

    private void Txt_PaginaWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_PaginaWebActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_PaginaWebActionPerformed

    private void Txt_FechaDesacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_FechaDesacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_FechaDesacActionPerformed

    private void List_ProponentesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_List_ProponentesValueChanged
        // TODO add your handling code here:
        if (List_Proponentes.getSelectedIndex() != -1) {
            String Nombre_seleccionado = ObtenerNick(List_Proponentes.getSelectedValue());
            DtProponente Proponente_seleccionado = IU.traerDtProponente(Nombre_seleccionado);
            List_Propuestas.setModel(IP.Propuestas_Desactivadas(Nombre_seleccionado));
            Txt_Nick.setText(Proponente_seleccionado.getNick());
            Txt_Nombre.setText(Proponente_seleccionado.getNombre());
            Txt_Apellido.setText(Proponente_seleccionado.getApellido());
            Txt_Correo.setText(Proponente_seleccionado.getCorreo());
            Txt_Direccion.setText(Proponente_seleccionado.getDireccion());
            Txt_FechaDesac.setText(IU.TraerFecha_desactivado(Nombre_seleccionado));
            Txt_Biografia.setText(Proponente_seleccionado.getBiografia());
            Txt_PaginaWeb.setText(Proponente_seleccionado.getLinkWeb());
            String c [] = {"Colaborador","Monto"};
            DefaultTableModel X= new DefaultTableModel(null,c);
            Table_Colaboraciones.setModel(X);
            Date Fnacimiento = Proponente_seleccionado.getFecha();
            DateFormat fecha = new SimpleDateFormat("yyyy/MM/dd");
            String Fnacimiento_String = fecha.format(Fnacimiento);
            Txt_FechaNac.setText(Fnacimiento_String);

            String imag = Proponente_seleccionado.getLink();
            if (imag == null || imag.equals("")) {
                ImageIcon imgencita = new ImageIcon("Imagenes/icono.jpg");
                Icon iconito = new ImageIcon(imgencita.getImage().getScaledInstance(Jl_Imagen.getWidth(), Jl_Imagen.getHeight(), Image.SCALE_DEFAULT));
                Jl_Imagen.setIcon(iconito);
            } else {
                ImageIcon imagen = new ImageIcon(imag);
                Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Jl_Imagen.getWidth(), Jl_Imagen.getHeight(), Image.SCALE_DEFAULT));
                Jl_Imagen.setIcon(icono);
            }
        }
    }//GEN-LAST:event_List_ProponentesValueChanged

    private void List_PropuestasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_List_PropuestasValueChanged
        // TODO add your handling code here:
        if (List_Propuestas.getSelectedIndex() != -1) {
            Table_Colaboraciones.setModel(IP.Listar_Colaboracines_tabla(List_Propuestas.getSelectedValue()));
        }
    }//GEN-LAST:event_List_PropuestasValueChanged

    private void Txt_BuscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Txt_BuscadorFocusGained
        // TODO add your handling code here:
        Limpiar_Campos();
        List_Proponentes.clearSelection();
    }//GEN-LAST:event_Txt_BuscadorFocusGained

    private void Txt_BuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_BuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_BuscadorActionPerformed

    private void Txt_BuscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_BuscadorKeyReleased
        // TODO add your handling code here:
        List_Proponentes.setModel(IU.BUSCADOR_Proponente_Descativado(Txt_Buscador.getText()));
    }//GEN-LAST:event_Txt_BuscadorKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Txt_NickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_NickActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_NickActionPerformed

    private void Txt_ApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_ApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_ApellidoActionPerformed

    private void Txt_NombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_NombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_NombreActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        List_Proponentes.setModel(IU.Listar_Proponentes_desactivados());
    }//GEN-LAST:event_formInternalFrameOpened


    private String ObtenerNick(String nombre) {
        boolean nicksolo = false;
        String nickposta = "";
        for (int a = 0; a < nombre.length(); a++) {
            char xn = nombre.charAt(a);
            if (xn == '(') {
                nicksolo = true;
            }
            if (nicksolo && xn != '(' && xn != ')') {
                nickposta = nickposta+xn;
            }
        }
        return nickposta;
    }

    void Limpiar_Campos(){
        DefaultListModel modelo = new DefaultListModel();
        List_Propuestas.setModel(modelo);
        String c [] = {"Colaborador","Monto"};
        DefaultTableModel X= new DefaultTableModel(null,c);
        Table_Colaboraciones.setModel(X);
        Txt_Nick.setText("");
        Txt_Nombre.setText("");
        Txt_Apellido.setText("");
        Txt_Correo.setText("");
        Txt_Direccion.setText("");
        Txt_FechaDesac.setText("");
        Txt_Biografia.setText("");
        Txt_PaginaWeb.setText("");
        Txt_FechaNac.setText("");
        ImageIcon imagen = new ImageIcon("");
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(Jl_Imagen.getWidth(), Jl_Imagen.getHeight(), Image.SCALE_DEFAULT));
        Jl_Imagen.setIcon(icono);
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jl_Imagen;
    private javax.swing.JList<String> List_Proponentes;
    private javax.swing.JList<String> List_Propuestas;
    private javax.swing.JTable Table_Colaboraciones;
    private javax.swing.JTextField Txt_Apellido;
    private javax.swing.JTextPane Txt_Biografia;
    private javax.swing.JTextField Txt_Buscador;
    private javax.swing.JTextField Txt_Correo;
    private javax.swing.JTextField Txt_Direccion;
    private javax.swing.JTextField Txt_FechaDesac;
    private javax.swing.JTextField Txt_FechaNac;
    private javax.swing.JTextField Txt_Nick;
    private javax.swing.JTextField Txt_Nombre;
    private javax.swing.JTextField Txt_PaginaWeb;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    // End of variables declaration//GEN-END:variables
}
