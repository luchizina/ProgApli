/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Map;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import Logica.dataListUsuarios;

/**
 *
 * @author Luchi
 */
public interface IUsuario {
    void configurarParametros();
    String agregarImagen(String nick,  final DataImagen img, String pass); // Cambiado de Path a String
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
    public abstract List<DtUsuario> traerSeguidos(String nick);
    public abstract List<DtUsuario> traerSeguidores(String nick);
    public abstract List<DtPropuesta> traerPropFav(String nick);
    public abstract List<DtColaboracion> traerPropuestasColaboradas(String nick);  
    public abstract byte[] retornarImagen(final String email) throws IOException;
    public abstract List<DtPropuesta> TraerMisPropuestasF(String nick);
    public abstract List<DtPropuesta> TraerTodasPropuestas(String nick);
    public abstract List<DtPropuesta> TraerTodasPropuestasIng(String nick);
    public abstract List<DtUsuario> listaNC(String txt);
    public abstract dataListUsuarios listaNC2(String txt);
    public abstract dataListUsuarios traerSeguidos2(String nick);
    public abstract dataListUsuarios traerSeguidores2(String nick);
    public abstract dataListProponentes listarProponentes2();
    public abstract dataListProponentes listarUsuario2();
    public abstract dataListColaboradores listarColaboradores2();
    public abstract dataListUsuarios listarUsuarios2();
    public abstract dataListColaboraciones datosCol2(Colaborador a);
    public abstract dataListPropuestas traerPropFav2(String nick); 
    public abstract dataListColaboraciones traerPropuestasColaboradas2(String nick);
    public abstract dataListStrings seleccionarColaborante2(String nick);
    public abstract dataListPropuestas traerMisPropuestasF2(String nick);
    public abstract dataListPropuestas TraerTodasPropuestas2(String nick);
    public abstract dataListPropuestas TraerTodasPropuestasIng2(String nick);
    public abstract void desactivarProp(String nick);
    public abstract int contarSeguidores(String nick);
    public List<DtUsuario> rankingUser();
    public dataListUsuarios rankingUser2();
    public DtProponente traerDtProponente(String nick);
    public abstract DtPath Path_A_DT(Path dts);
    
    public abstract DataImagen Crear_DataImagen(final byte[] stream, final String nombreArchivo, final String extensionArchivo);
    public abstract DefaultListModel Listar_Proponentes_desactivados();
    public abstract String TraerFecha_desactivado(String nick_proponente);
    public abstract DefaultListModel BUSCADOR_Proponente_Descativado(String palabrita);
}
