/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.List;
import java.util.Map;
import Logica.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Luchi
 */
public interface IPropuesta {
    public List<DtComentarios> traerComentarios(String prop);
    public void extender(String tit) throws SQLException ;
    public List<DtPropuesta> listaTDL(String txt);
    public boolean yaFavoriteo(Usuario u,String p);
    public void agregarFavorito(Usuario usu, Propuesta prop);
    public void agregarComentario(Colaborador nick, Propuesta titulo, String texto);
    public void configurarParametros(String carpetaImagenes);
    public Path agregarImagen(final DtPropuesta imagenUsuario);
    public abstract boolean existeTitulo(String titulo);
    public abstract void cargarPropuestas();
    public abstract List<DtPropuesta> listarPropuestas();
    public abstract DtPropuesta traerPropuesta(String titulo);
    public abstract boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img, String nickP, String hora, String Lugar);
    public abstract boolean existeColaboracion(String nick, String titulo);
    public abstract Propuesta getPropPorNick(String nick);
    public abstract void cargarColaboraciones();
    public abstract boolean altaColaboracion(String prop, String colab, String monto, String tipoR);
    public abstract void cargarProp();
    public abstract List<String> ColaborantesDePro();
    public abstract DtPropuesta SeleccionarProp(String xTitulo);
    public abstract List<String> NombrePropoConsulta(); 
    public abstract List<String> ListarProp(); 
    public abstract void EstadosPropuestas();
    public abstract void cargarEstados();
    public abstract void actualizarMontos();
    public abstract List<Colaboracion> listarColaboraciones();
    public abstract void cancelarColaboracion(String c, String p);
    public abstract void filtrarP(String campito, JList lista, List<DtPropuesta> prop);
    public abstract boolean actualizarDatos(String titulo, Date fecha, int entrada, int monto, String lugar, String cat, String retorno, String desc, String url);
    public abstract DefaultListModel BUSCADOR_Propuestas(String Palabra);
    public abstract DefaultTableModel BUSCADOR_Propuestas2(String Palabra, List<DtPropuesta> listita, TableModel modelito);
    public abstract void cambiarEstadito(String p, String f);
    public abstract List<DtPropuesta> WEB_listarPropuestas_No_Ingresada();
    public abstract List<DtPropuesta> WEB_listarPropuestas_X_Categoria(String x);
    public abstract void Cargar_Favoritos_Memoria();
    public abstract void Cargar_Comentarios_Memoria();
    BufferedImage retornarImagen(final String titulo);
    public abstract boolean Ya_Comento_Propuesta(String c,String p);
    public abstract BufferedImage retornarImagen_Propuesta(final String titu) throws IOException;
    public abstract DataListPropuestas ListPropuesta_A_DT(List<DtPropuesta> dts);
    public abstract DataListStrings ListString_A_DT(List<String> dts);
    public abstract DataList_Comentario ListComentario_A_DT(List<DtComentarios> dts);
}
