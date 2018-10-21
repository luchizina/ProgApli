/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.Colaborador;
import Logica.DtColaboracion;
import Logica.DtInfo;
import Logica.DtUsuario;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.Proponente;
import Logica.DataListColaboraciones;
import Logica.DataListColaboradores;
import Logica.DataListProponentes;
import Logica.DataListPropuestas;
import Logica.DataListStrings;
import Logica.DataListUsuarios;
import Logica.DtProponente;
import Logica.Usuario;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

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
            endpoint = Endpoint.publish("http://127.0.0.1:8280/servicio", this);
    }
    @WebMethod
    public boolean altaColaborador(@WebParam(name = "Nick") String Nick, @WebParam(name = "Correo ")String Correo, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "Apellido") String Apellido, @WebParam(name = "fecha") Date fecha, @WebParam(name = "Imagen") String Imagen,@WebParam(name = "tipo") String tipo,@WebParam(name = "pass") String pass){
        boolean lol = xD.altaColaborador(Nick, Correo, Nombre, Apellido, fecha, Imagen, tipo, pass);
        return lol;
    }
    @WebMethod
    public DataListUsuarios listaNC(String txt)
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
    public DataListUsuarios traerSeguidos(String nick)
    {
        return xD.traerSeguidos2(nick);
    }
    @WebMethod
    public DataListUsuarios traerSeguidores(String nick)
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
    public DataListProponentes listarProponentes()
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
    public DataListProponentes listarUsuario()
    {
        return xD.listarUsuario2();
    }
    @WebMethod
    public DataListColaboradores listarColaboradores()
    {
       return xD.listarColaboradores2();
    }
    @WebMethod
    public DataListUsuarios listarUsuarios()
    {
        return xD.listarUsuarios2();
    }
    @WebMethod
    public DataListColaboraciones datosCol(Colaborador a)
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
     public DataListPropuestas traerPropFav(String nick)
     {
         return xD.traerPropFav2(nick);
     }
     @WebMethod
     public DataListColaboraciones traerPropuestasColaboradas(String nick)
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
     public DataListStrings seleccionarColaborante(String nick)
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
     public DataListPropuestas traerMisPropuestasF(String nick)
     {
         return xD.traerMisPropuestasF2(nick);
     }
     @WebMethod
     public DataListPropuestas TraerTodasPropuestas(String nick)
     {
         return xD.TraerTodasPropuestas2(nick);
     }
     @WebMethod
     public DataListPropuestas TraerTodasPropuestasIng(String nick)
     {
         return xD.TraerTodasPropuestasIng2(nick);
     }
//     @WebMethod
////     public Path agregarImagen(final DtUsuario imagenUsuario)
////     {
////         return xD.agregarImagen(imagenUsuario);
////     }
     @WebMethod
     public BufferedImage retornarImagen(final String nick) throws IOException
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
}
