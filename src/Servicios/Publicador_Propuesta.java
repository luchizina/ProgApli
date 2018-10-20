/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.Colaborador;
import Logica.DataList_Comentario;
import Logica.DtPropuesta;
import Logica.Estado;
import Logica.Fabrica;
import Logica.IPropuesta;
import Logica.IUsuario;
import Logica.Lista_DtPropuestas;
import Logica.Propuesta;
import Logica.dataListStrings;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author matheo
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)

public class Publicador_Propuesta {
    private Endpoint endpoint = null;
    
    Fabrica fabrica = Fabrica.getInstance();
    
    private IPropuesta IP = fabrica.getICtrlPropuesta();
    private IUsuario IU = fabrica.getICtrlUsuario();
    
    //@WebMethod(exclude = true)
    public void publicar() {
            endpoint = Endpoint.publish("http://127.0.0.1:8280/servicio", this);
    }  
    
    // Listar propuestas
    @WebMethod
    public Lista_DtPropuestas Listar_Propuestas_Web()throws SQLException {
           return IP.ListPropuesta_A_DT(IP.WEB_listarPropuestas_No_Ingresada());
    } 
    
    @WebMethod
    public Lista_DtPropuestas Listar_Propuestas_X_Categoria_Web(String nombre_categoria)throws SQLException {
           return IP.ListPropuesta_A_DT(IP.WEB_listarPropuestas_X_Categoria(nombre_categoria));
    }
    
    @WebMethod
    public DtPropuesta Selccionar_Propuesta( String nombre_p)  throws SQLException {
            return IP.SeleccionarProp(nombre_p);
    }
    
    @WebMethod
    public dataListStrings Colaboradores_De_Propuesta( String nombre_p)  throws SQLException {
            return IP.ListString_A_DT(IP.ColaborantesDePro());
    }
    
    public boolean Ya_Comento( String nombre_propuesta, String nombre_colaborador)  throws SQLException {
            return IP.Ya_Comento_Propuesta(nombre_colaborador, nombre_propuesta);
    }
    
    public boolean Ya_Favoritio( String nombre_propuesta, String nombre_colaborador)  throws SQLException {
            return IP.yaFavoriteo(IU.traerUsuario(nombre_colaborador), nombre_propuesta);
    }
    
    public boolean Existe_Propuesta( String nombre_propuesta)  throws SQLException {
            return IP.existeTitulo(nombre_propuesta);
    }
    
    public DtPropuesta Traer_Propuesta( String nombre_p)  throws SQLException {
            return IP.traerPropuesta(nombre_p);
    }
    
    public void Alta_Colaboracion( String titulo, String nick, String monto, String tipoR)  throws SQLException {
            IP.altaColaboracion(titulo, nick, monto, tipoR);
    }
    
    public BufferedImage Retornar_Imagen_Propuesta(final String titulo) throws IOException{
        return IP.retornarImagen_Propuesta(titulo);
    }
    
    public void Configurar_Parametros(String imagen){
        IP.configurarParametros(imagen);
    }
    
    public boolean Agregar_Propuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img, String nickP, String hora, String Lugar){
        return IP.AgregarPropuesta(titulo, desc, fecha, precioE, montoActual, fechaPub, Retorno, montoTotal, cate, estActual, img, nickP, hora, Lugar);
    }
    
    public void Cambiar_Estado(String propuesta, String estado){
        IP.cambiarEstadito(propuesta, estado);
    }
    
    public Lista_DtPropuestas Buscardor_Web_ListaTDL(String texto){
        return IP.ListPropuesta_A_DT(IP.listaTDL(texto));
    }
    
    public void Agregar_Comentario(String nick, String titulo, String texto){
        IP.agregarComentario(IU.traerColaborador(nick), IP.getPropPorNick(titulo), texto);
    }
    
    public void Cargar_Pro_Col_Est(){ 
        IP.cargarPropuestas();
        IP.cargarColaboraciones();
        IP.EstadosPropuestas();
    }
    
    public void Exterder(String nombre_propuesta) throws IOException, SQLException{
        IP.extender(nombre_propuesta); 
    }
    
    public void Agregar_Favorito(String nick,String prop){
        IP.agregarFavorito(IU.traerUsuario(nick), IP.getPropPorNick(prop));
    }

    public DataList_Comentario Traer_Comentarios(String titulo_propuesta){
        return IP.ListComentario_A_DT(IP.traerComentarios(titulo_propuesta));
    }
}
