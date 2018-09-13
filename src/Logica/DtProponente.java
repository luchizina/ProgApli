package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;

/**
 *
 * @author Luchi
 */
public class DtProponente  extends DtUsuario  {
    private
            String nick;
            String img;
            String biografia;
            String linkWeb;
            String direccion;
            String nombre;
            String apellido;
            String correo;
            DtFecha fecha;
            String pass;

    public DtProponente(String nick, String img, String biografia, String linkWeb, String direccion, String nombre, String apellido, String correo) {
        this.nick = nick;
        this.img = img;
        this.biografia = biografia;
        this.linkWeb = linkWeb;
        this.direccion = direccion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;

    }

    public DtProponente(String nick) {
        this.nick = nick;
    }
    
    public DtProponente(String nick, String correo, String pass){
        
        this.nick=nick;
        this.correo=correo;
        this.pass=pass;
    }
    

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

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

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }
    
    public String getPass(){
        return pass;
    }
    
    
            
     
}
