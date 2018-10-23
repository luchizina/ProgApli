package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Map;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Luchi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtColaborador extends DtUsuario {
    private
            //String nick;
            //String nombre;
            //String apellido;
            //String correo;
            //Date fecha;
            //String img;
            List<Colaboracion> colaboraciones;
            //String pass;
            //private DataImagen imagen;
            
    public DtColaborador(String nick, String nombre, String apellido, String correo, Date fecha, String img, List<Colaboracion> colaboraciones) {
        super (nick,correo, nombre,apellido,img,fecha);
        //this.nick = nick;
        //this.nombre = nombre;
        //this.apellido = apellido;
        //this.correo = correo;
        //this.fecha = fecha;
        //this.img = img;
        // faltara pass? 
        this.colaboraciones = colaboraciones;
    }
    
    public DtColaborador(String nick, String nombre, String apellido, String correo, Date fecha, String img){
        super (nick,correo, nombre,apellido,img,fecha);
        //this.nick = nick;
        //this.nombre = nombre;
        //this.apellido = apellido;
        //this.correo = correo;
        //this.fecha = fecha;
        //this.img = img;
    }
    
    public DtColaborador(String nick, String correo, String pass, String nombre, String apellido)
    {
        super (nick,correo,pass,nombre,apellido,nick);
        //this.nick=nick;
        //this.correo=correo;
        //this.pass=pass;
        //this.nombre=nombre;
        //this.apellido=apellido;
    }
    
    public DtColaborador(String nick, String correo, String pass, String nombre,Date fecha, String apellido, String img)
    {
        super (nick,correo,pass,nombre,apellido,img,fecha);
        //this.nick=nick;
        //this.correo=correo;
        //this.pass=pass;
        //this.nombre=nombre;
        //this.apellido=apellido;
        //this.img=img;
        //this.fecha = fecha;
    }
    
        public DtColaborador(String nick, String correo, String pass, String nombre,Date fecha, String apellido, final DataImagen img)
    {
        super (nick,correo,pass,nombre,fecha,apellido,img);
        //this.nick=nick;
        //this.correo=correo;
        //this.pass=pass;
        //this.nombre=nombre;
        //this.apellido=apellido;
        //this.imagen=img;
        //this.fecha = fecha;
    }

//    public DataImagen getImagen() {
//        return imagen;
//    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

//    public String getImg() {
//        return img;
//    }

//    public void setImg(String img) {
//        this.img = img;
//    }

    public List<Colaboracion> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(List<Colaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }
    
      public String getPass(){
        return pass;
    }

            
    
}
