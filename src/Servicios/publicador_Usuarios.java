/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.Colaborador;
import Logica.DataImagen;
import Logica.DtColaboracion;
import Logica.DtPropuesta;
import Logica.DtInfo;
import Logica.DtPath;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.Proponente;
import Logica.dataListColaboraciones;
import Logica.dataListColaboradores;
import Logica.dataListProponentes;
import Logica.dataListPropuestas;
import Logica.dataListStrings;
import Logica.dataListUsuarios;
import Logica.DtProponente;
import Logica.Usuario;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Properties;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;
import config.*;

/**
 *
 * @author Aeliner
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class publicador_Usuarios {
    private Endpoint endpoint = null;
    IUsuario xD = Fabrica.getInstance().getICtrlUsuario();
    
    
    
    @WebMethod
    public void publicar() {
      Properties p= Utils.getPropiedades();
      String servicio1=p.getProperty("http")+p.getProperty("ipServices")+p.getProperty("puertoServ")+p.getProperty("serv1");
            endpoint = Endpoint.publish(servicio1, this);
            
    }
    @WebMethod
    public boolean altaColaborador(String Nick,String Correo, String Nombre,String Apellido,Date fecha, String Imagen, String tipo, String pass){
        boolean lol = xD.altaColaborador(Nick, Correo, Nombre, Apellido, fecha, Imagen, tipo, pass);
        return lol;
    }
    @WebMethod
    public dataListUsuarios listaNC(String txt)
    {
        return xD.listaNC2(txt);
    }
    @WebMethod
    public Colaborador traerColaborador(String f)
    {     
        return xD.traerColaborador(f);
    }
    @WebMethod
    public Proponente traerProponente(String f)
    {
        return xD.traerProponente(f);
    }
    @WebMethod
    public boolean yaSigue()
    {
        return xD.yaSigue();
    }
    @WebMethod
    public boolean seguirUsuario()
    {
        return xD.seguirUsuario();
    }
    @WebMethod
    public boolean dejarDeSeguir()
    {
        return xD.dejarDeSeguir();
    }
    @WebMethod
    public dataListUsuarios traerSeguidos(String nick)
    {
        return xD.traerSeguidos2(nick);
    }
    @WebMethod
    public dataListUsuarios traerSeguidores(String nick)
    {
        return xD.traerSeguidores2(nick);
    }
    @WebMethod
    public void seleccionarUsuario(String nick)
    {
        xD.seleccionarUsuario(nick);
    }

    @WebMethod
    public void seleccionarUsuSeg(String nick)
    {
        xD.seleccionarUsuSeg(nick);
    }
    @WebMethod
    public dataListProponentes listarProponentes()
    {
        return xD.listarProponentes2();
    }
    @WebMethod
    public boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo, String pass) {
        return xD.altaProponente(Nick, Correo, Nombre, Apellido, fecha, Imagen, direccion, biografia, web, tipo, pass);
    }
    @WebMethod
    public boolean existe(String nick, String correo)
    {
        return xD.existe(nick, correo);
    }
    @WebMethod
    public boolean copia(String origen, String destino)
    {
        return xD.copia(origen, destino);
    }
    @WebMethod
    public void cargarProponentes()
    {
        xD.cargarProponentes();
    }
    @WebMethod
    public void limpiarUsuarios()
    {
        xD.limpiarUsuarios();
    }
    @WebMethod
    public void cargarPropPrueba()
    {
        xD.cargarPropPrueba();
    }
    @WebMethod
    public dataListProponentes listarUsuario()
    {
        return xD.listarUsuario2();
    }
    @WebMethod
    public dataListColaboradores listarColaboradores()
    {
       return xD.listarColaboradores2();
    }
    @WebMethod
    public dataListUsuarios listarUsuarios()
    {
        return xD.listarUsuarios2();
    }
    @WebMethod
    public dataListColaboraciones datosCol(Colaborador a)
    {
        return xD.datosCol2(a);
    }
    @WebMethod
    public boolean escorreo(String correo)
    {
        return xD.escorreo(correo);
    }
    @WebMethod
     public boolean existeNick(String nick)
     {
         return xD.existeNick(nick);
     }
     @WebMethod
     public DtUsuario traerDtUsuario(String nick)
     {
         return xD.traerDtUsuario(nick);
     }
     @WebMethod
     public dataListPropuestas traerPropFav(String nick)
     {
         return xD.traerPropFav2(nick);
     }
     @WebMethod
     public dataListColaboraciones traerPropuestasColaboradas(String nick)
    {
        return xD.traerPropuestasColaboradas2(nick);
    }
     @WebMethod
      public DtInfo resolverLogin(String nick, String pass)
     {
         return xD.resolverLogin(nick, pass);
     }
     @WebMethod
     public boolean existeCorreo(String correo)
     {
         return xD.existe(correo, correo);
     }
     @WebMethod
     public void cargarUsuarios2()
     {
         xD.cargarUsuarios2();
     }
//     @WebMethod
//     public Map<String, Usuario> cargarSeg(Map<String, Usuario> lista)
//     {
//         return xD.cargarSeg(lista);
//     }
     @WebMethod
     public boolean validaWeb(String algo)
     {
         return xD.validaWeb(algo);
     }
     @WebMethod
     public dataListStrings seleccionarColaborante(String nick)
     {
         return xD.seleccionarColaborante2(nick);
     }
     @WebMethod
     public DtColaboracion SeleccionarColaboracion(String xTitulo)
     {
         return xD.SeleccionarColaboracion(xTitulo);
     }
     @WebMethod
     public String encripta(String pass, String type)
     {
         return xD.encripta(pass, type);
     }
     @WebMethod
     public String sha1(String pass)
     {
         return xD.sha1(pass);
     }
     @WebMethod
     public void configurarParametros(String carpetaImagenes)
     {
         xD.configurarParametros(carpetaImagenes);
     }
     @WebMethod
     public dataListPropuestas traerMisPropuestasF(String nick)
     {
         return xD.traerMisPropuestasF2(nick);
     }
     @WebMethod
     public dataListPropuestas TraerTodasPropuestas(String nick)
     {
         return xD.TraerTodasPropuestas2(nick);
     }
     @WebMethod
     public dataListPropuestas TraerTodasPropuestasIng(String nick)
     {
         return xD.TraerTodasPropuestasIng2(nick);
     }
     @WebMethod
     public String agregarImagen(String nick1, DataImagen img, String pass)
     {
         return xD.agregarImagen(nick1, img, pass);
     }
     @WebMethod
     public byte[] retornarImagen(final String nick) throws IOException
     {
         return xD.retornarImagen(nick);
     }
     @WebMethod
     public DtProponente traerDtProponente(String nick)
    {
        return xD.traerDtProponente(nick);
    }
     @WebMethod
     public void desactivarProp(String nick)
    {
        xD.desactivarProp(nick);
    }
     @WebMethod
     public Usuario traerUsuario(String nick) {
         return xD.traerUsuario(nick);
     }
     @WebMethod
     public dataListUsuarios rankingUser2()
    {
        return xD.rankingUser2();
    }
    
    public DataImagen Crear_DataImagen_Publicador(final byte[] stream, final String nombreArchivo, final String extensionArchivo){  
        return xD.Crear_DataImagen(stream, nombreArchivo, extensionArchivo);
    }
     
    
    
}
