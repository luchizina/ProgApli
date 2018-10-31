package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Luchi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtProponente  extends DtUsuario  {
    private
            
            String biografia;
            String linkWeb;
            String direccion;
            boolean activo;

    public DtProponente(String nick, String img, String biografia, String linkWeb, String direccion, String nombre, String apellido, String correo) {
        super (nick, correo, nombre, apellido, img);
        this.biografia = biografia;
        this.linkWeb = linkWeb;
        this.direccion = direccion;
        this.activo = true;

    }
    
    
    public DtProponente(String nick,  final DataImagen img, String pass) {
        super (nick,img,pass);
        this.activo = true;
    }
    
    

    

  
    
    public DtProponente(String nick, String correo, String pass, String nombre, String apellido, String img, String linkWeb, String direccion, String biografia, Date fecha){
        super (nick,correo, pass,nombre,apellido,img,fecha);
        
        this.linkWeb=linkWeb;
        this.direccion=direccion;
        this.biografia=biografia;
        this.activo = true;
    }
    

//    public String getNick() {
//        return nick;
//    }
//
//    public void setNick(String nick) {
//        this.nick = nick;
//    }

    


    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }

//    public String getCorreo() {
//        return correo;
//    }
//
//    public void setCorreo(String correo) {
//        this.correo = correo;
//    }
//
//    public Date getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(Date fecha) {
//        this.fecha = fecha;
//    }
//    
//    public String getPass(){
//        return pass;
//    }
    
      public boolean getActivo(){
          return this.activo;
      };  
      
      public void setActivo(boolean x){
          this.activo=x;
      };
}
