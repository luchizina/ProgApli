/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.DataImagen;
import Logica.DataList_Comentario;
import Logica.DataReporte;
import Logica.DtPropuesta;
import Logica.Estado;
import Logica.Fabrica;
import Logica.IPropuesta;
import Logica.IUsuario;
import Logica.dataListPropuestas;
import Logica.dataListStrings;
import Logica.Propuesta;
//import Logica.dataRenderedImag;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import config.Utils;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        Properties p= Utils.getPropiedades();
         String servicio2=p.getProperty("http")+p.getProperty("ipServices")+p.getProperty("puertoServ")+p.getProperty("serv2");
            endpoint = Endpoint.publish(servicio2, this);
    }  
    
    // Listar propuestas
    @WebMethod
    public dataListPropuestas Listar_Propuestas_Web() {
           return IP.ListPropuesta_A_DT(IP.WEB_listarPropuestas_No_Ingresada());
    } 
    
    @WebMethod
    public dataListPropuestas Listar_Propuestas_X_Categoria_Web(String nombre_categoria) {
           return IP.ListPropuesta_A_DT(IP.WEB_listarPropuestas_X_Categoria(nombre_categoria));
    }
    
    @WebMethod
    public DtPropuesta Selccionar_Propuesta( String nombre_p)  {
            return IP.SeleccionarProp(nombre_p);
    }
    
    @WebMethod
    public dataListStrings Colaboradores_De_Propuesta() {
            return IP.ListString_A_DT(IP.ColaborantesDePro());
    }
    @WebMethod
    public boolean Ya_Comento(String nombre_colaborador, String nombre_propuesta){
            return IP.Ya_Comento_Propuesta(nombre_colaborador, nombre_propuesta);
    }
    @WebMethod
    public boolean Ya_Favoritio(String nombre_colaborador, String nombre_propuesta ){
            return IP.yaFavoriteo(IU.traerUsuario(nombre_colaborador), nombre_propuesta);
    }
    @WebMethod
    public boolean Existe_Propuesta( String nombre_propuesta){
            return IP.existeTitulo(nombre_propuesta);
    }
    @WebMethod
    public DtPropuesta Traer_Propuesta( String nombre_p) {
            return IP.traerPropuesta(nombre_p);
    }
    @WebMethod
    public void Alta_Colaboracion( String titulo, String nick, String monto, String tipoR){
            IP.altaColaboracion(titulo, nick, monto, tipoR);
    }
    @WebMethod
    public byte[] Retornar_Imagen_Propuesta(final String titulo){
        return IP.retornarImagen(titulo);
    }
    @WebMethod
    public void Configurar_Parametros(){
        IP.configurarParametros();
    }
    @WebMethod
    public boolean Agregar_Propuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img, String nickP, String hora, String Lugar){
        return IP.AgregarPropuesta(titulo, desc, fecha, precioE, montoActual, fechaPub, Retorno, montoTotal, cate, estActual, img, nickP, hora, Lugar);
    }
    @WebMethod
    public void Cambiar_Estado(String propuesta, String estado){
        IP.cambiarEstadito(propuesta, estado);
    }
    @WebMethod
    public dataListPropuestas Buscardor_Web_ListaTDL(String texto){
        return IP.ListPropuesta_A_DT(IP.listaTDL(texto));
    }
    @WebMethod
    public void Agregar_Comentario(String nick, String titulo, String texto){
        IP.agregarComentario(IU.traerColaborador(nick), IP.getPropPorNick(titulo), texto);
    }
    @WebMethod
    public void Cargar_Pro_Col_Est(){ 
        IP.cargarPropuestas();
        IP.cargarColaboraciones();
        IP.EstadosPropuestas();
    }
    @WebMethod
    public void extender(String nombre_propuesta) {
        try {
            IP.extender(nombre_propuesta);
        } catch (SQLException ex) {
            Logger.getLogger(Publicador_Propuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @WebMethod
    public void Agregar_Favorito(String nick,String prop){
        IP.agregarFavorito(IU.traerUsuario(nick), IP.getPropPorNick(prop));
    }
@WebMethod
    public DataList_Comentario Traer_Comentarios(String titulo_propuesta){
        return IP.ListComentario_A_DT(IP.traerComentarios(titulo_propuesta));
    }
    
    @WebMethod
    public void cargarPropuestas() {
        IP.cargarPropuestas();
    }
    @WebMethod
    public void Cargar_Favoritos_Memoria() {
        IP.Cargar_Favoritos_Memoria();
    }
    @WebMethod
    public void cargarColaboraciones() {
        IP.cargarColaboraciones();
    }
    @WebMethod
    public void actualizarMontos() {
        IP.actualizarMontos();
    }
    @WebMethod
    public void EstadosPropuestas() {
        IP.EstadosPropuestas();
    }
    @WebMethod
    public Propuesta getPropPorNick(String nick) {
        return IP.getPropPorNick(nick);
    }
    
    public String AgregarImagen_Propuesta(String titulo_propuesta, DataImagen imagen){
        return IP.agregarImagen(titulo_propuesta, imagen);
    }
    
    public DataImagen Crear_DataImagen_Publicador(final byte[] stream, final String nombreArchivo, final String extensionArchivo){  
        return IP.Crear_DataImagen_Propuesta(stream, nombreArchivo, extensionArchivo);
    }
    
    public Estado Crear_Estado(){
        return IP.Crear_Esatado_Ingresada();
    }
    
    @WebMethod
    public boolean Agregar_Propuesta_web(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, String img, String nickP, String hora, String Lugar){
        return IP.AgregarPropuesta_WEB(titulo, desc, fecha, precioE, montoActual, fechaPub, Retorno, montoTotal, cate, img, nickP, hora, Lugar);
    }
    
    @WebMethod
    public DataReporte traerReporte(String prop, String usu){
        return IP.traerRep(prop, usu);
    }
    
    @WebMethod
    public Boolean SaberSiPago(String prop, String usu){
        return IP.pago(prop, usu);
    }
    
    @WebMethod
    public void GenerarReporte(String prop, String usu){
        IP.crearReporte(prop, usu);
    }
    
    @WebMethod
    public byte[] generaDescarga(String prop, String usu){
        return IP.crearDescarga(prop, usu);
    }
    public boolean pagarTarjeta2(String Nro, String Tipo, Date Fecha, String CVC, String Propuesta, String Colaborador)
   {
        return IP.pagarTarjeta( Nro,  Tipo,  Fecha, CVC,  Propuesta, Colaborador);
    }
     @WebMethod
    public boolean pagarTrans2(String Nro, String Banco, String Propuesta, String Colaborador)
   {
        return IP.pagarTrans(Nro, Banco, Propuesta, Colaborador);
    } 
    @WebMethod
    public boolean pagarPayPal2(String Nro,  String Propuesta, String Colaborador)
    {
        return IP.pagarPayPal(Nro,Propuesta, Colaborador); 
    } 
}
