/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Luchi
 */
public interface IUsuario {
    void configurarParametros(final String carpetaImagenes);
    Path agregarImagen(final DtUsuario usuario);
    public abstract boolean altaColaborador(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String tipo, String pass);
    public abstract boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo, String pass);
    public abstract boolean escorreo(String correo);
    public abstract boolean existeNick(String nick);
    public abstract boolean existeCorreo(String correo);
    public abstract void cargarProponentes();
    public abstract void cargarColaboradores();
    public abstract void limpiarUsuarios();
    public abstract boolean existe(String nick, String correo);
     public abstract List<DtProponente> listarUsuario();
     public abstract List<DtColaborador> listarColaboradores();
    
     public abstract void cargarPropPrueba();
     public abstract boolean copia(String origen, String destino);
     public abstract Colaborador traerColaborador(String lul);
     public abstract Usuario traerUsuario(String nick);
     public abstract void cargarUsuarios2();
     public abstract boolean validaWeb(String algo);
     public abstract boolean seguirUsuario();
     public abstract Map<String,Usuario> cargarSeg(Map<String,Usuario> lista);
      public abstract List<DtProponente> listarProponentes();
     public abstract void seleccionarUsuario(String nick);
     public abstract void seleccionarUsuSeg(String nick);
     public abstract boolean dejarDeSeguir();
     public abstract Proponente traerProponente(String lul);
     public abstract boolean yaSigue();
     public abstract List<DtColaboracion> datosCol(Colaborador a);
      public abstract List<String> SeleccionarColaborante(String xNick);
      public abstract DtColaboracion SeleccionarColaboracion(String xTitulo);
      public abstract void filtrarP(String campo, JList lista);
      public abstract void filtrarC(String campo, JList lista, List<Colaborador> listita);
     public abstract DefaultListModel BUSCADOR_Colaborador(String Palabra);
     public abstract DefaultListModel BUSCADOR_Proponente(String palabrita);
     public abstract String sha1(String pass);
     public abstract String encripta(String pass, String type);
     public abstract DtUsuario traerDtUsuario(String nick);
     public abstract DtInfo resolverLogin(String nick, String pass);
     public abstract List<DtUsuario> listarUsuarios();
     public abstract List<DtUsuario> traerSeguidores(String nick);
}
