/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.DBusuario;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luchi
 */
public class Fabrica {
     //SINGLETON
    private static Fabrica instancia;

    public static Fabrica getInstance(){
        if (instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }    
     public IUsuario getICtrlUsuario() {
        IUsuario ICU = ctrlUsuario.getInstance();
        return ICU;
    }   
    public IPropuesta getICtrlPropuesta() {
        IPropuesta ICP = ctrlPropuesta.getInstance();
        return ICP;
    }   
    
    public ICategoria getICtrlCategoria() {
        ICategoria ICC = ctrlCategoria.getInstance();
        return ICC;
    }
    
//      private Fabrica(){
//        this.cargarDatosPrueba();
//    };
      
       public void cargarDatosPrueba(){
        ICategoria ic=this.getICtrlCategoria();
        IUsuario iu = this.getICtrlUsuario();
        ic.cargarCategorias();
        iu.cargarColaboradores();
        iu.cargarProponentes();
    }
       
       public void limpiar(){
           IUsuario iu = this.getICtrlUsuario();
           iu.limpiarUsuarios();
       }
       
       public void cargaProp(){
           IUsuario iu = this.getICtrlUsuario();
           iu.cargarPropPrueba();
       }
       
       public void pruebas(){
          IUsuario iu = this.getICtrlUsuario();
          iu.cargarUsuarios();
       }
}
