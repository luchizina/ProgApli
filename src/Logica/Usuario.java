/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author Luchi
 */
public class Usuario {
    
    String nick;
    String nombre;
    String Apellido;
    String Correo;
    Date fecha;
    String img;
    String tipo;
    private Map<String, Usuario> usuSeguidos;
    private Map<String, Propuesta> propuFav;


    public Usuario(String nick) {
        this.nick = nick;
    }


    public Usuario(String nick, String nombre, String Apellido, String Correo, Date fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav) {
        this.nick = nick;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.fecha = fecha;
        this.img = img;
        this.usuSeguidos = usuSeguidos;
        this.propuFav = propuFav;
    }

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
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public Map<String, Usuario> getUsuSeguidos() {
        return usuSeguidos;
    }

   

    public void setUsuSeguidos(Map<String, Usuario> usuSeguidos) {
        this.usuSeguidos = usuSeguidos;
    }

    public Map<String, Propuesta> getPropuFav() {
        return propuFav;
    }

    public void setPropuFav(Map<String, Propuesta> propuFav) {
        this.propuFav = propuFav;
    }
    
    public boolean seguirUsuario(Usuario aSeguir){
        Usuario nuevo= new Usuario(aSeguir.getNick(), aSeguir.getNombre(), aSeguir.getApellido(), aSeguir.getCorreo(), aSeguir.getFecha(), aSeguir.getImg(), aSeguir.getTipo());
        this.usuSeguidos.put(nuevo.getNick(), nuevo);
        return true;
          }
    
    
    public boolean dejarDeSeguir(Usuario aSeguir){
   this.usuSeguidos.remove(aSeguir.getNick());
   return true;
    }
    
    

    public Usuario(String nick, String nombre, String Apellido, String Correo, Date fecha, String img, String tipo){
        this.nick = nick;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.fecha = fecha;
        this.img = img;
      
        this.tipo=tipo;
    }
}