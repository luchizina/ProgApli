package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Date;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Luchi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtUsuario {

    public String getLink() {
        return link;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFecha() {
        return fecha;
    }

    String nick;
    String nombre;
    String apellido;
    String seguido;
    String pass;
    String link;
    String correo;
    Date fecha;
    private DataImagen imagen;
    
    public DtUsuario(String nick, DataImagen img, String pass) {
        this.nick = nick;
        this.imagen = img;
        this.pass=pass;
    }

    public String getSeguido(){
        return seguido;
    }
    
    public String getPass(){
        return pass;
    }
    
    public void setSeguido(String seg){
        this.seguido=seg;
    }
    
    public DataImagen getImagen() {
        return imagen;
    }
    
    
    public String getNick(){
        return nick;

    }

    public String getNombre(){
        return nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setNick(String nick){
        this.nick=nick;

    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }

    DtUsuario(String nick, String correo, String pass, String nombre, String apellido, String img, Date fecha){
    
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.link = img;
        this.pass = pass;
        this.correo = correo;   
        this.fecha = fecha;
    }
    
    DtUsuario(String nick, String correo, String nombre, String apellido, String img){
    
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.link = img;
        this.correo = correo;   
       
    }
    
    DtUsuario(String nick, String correo, String nombre, String apellido, String img, Date fecha){
    
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.link = img;
        this.correo = correo;   
        this.fecha = fecha;
    }
    
     DtUsuario(String nick, String correo, String pass, String nombre, String apellido, String nada){
         // ignorar a "nada"
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
    }
    
    DtUsuario(String nick, String correo, String pass, String nombre,Date fecha, String apellido, final DataImagen img){
        this.nick = nick;
        this.correo = correo;
        this.pass = pass;
        this.nombre = nombre;
        this.fecha = fecha;
        this.apellido = apellido;
        this.imagen = img;
        
        
    } 
     
     
}
