/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Logica.Fabrica;
import Logica.IPropuesta;
import Logica.IUsuario;
import Logica.ICategoria;
import Logica.Lista_DtPropuestas;
import Logica.dataListCategoria;
import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

/**
 *
 * @author matheo
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Publicador_Categoria {
    
    private Endpoint endpoint = null;
    
    Fabrica fabrica = Fabrica.getInstance();
    
    private IPropuesta IP = fabrica.getICtrlPropuesta();
    private IUsuario IU = fabrica.getICtrlUsuario();
    private ICategoria IC = fabrica.getICtrlCategoria();
    
    //@WebMethod(exclude = true)
    public void publicar() {
            endpoint = Endpoint.publish("http://127.0.0.1:8280/servicio", this);
    }  
    
    // Listar propuestas
    @WebMethod
    public dataListCategoria Listar_Categorias_Web()throws SQLException {
           return IC.ListCategoria_A_DT(IC.listarCategorias());
    } 
    
    @WebMethod
    public boolean Existe_Categoria(String Nombre_categoria)throws SQLException {
           return IC.existecat(Nombre_categoria);
    } 
    
}
