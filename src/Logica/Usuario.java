/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.HashMap;
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
    String seguido;
    String cont;
    DataImagen imagen;
    

    public Usuario(String nick) {
        this.nick = nick;
    }
    
    public Usuario(String nick, String seguido){
        this.nick = nick;
        this.seguido =seguido;
    }


    public Usuario(String nick, String nombre, String Apellido, String Correo, Date fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav, String cont) {
        this.nick = nick;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.fecha = fecha;
        this.img = img;
        this.usuSeguidos = new HashMap<>();
        this.propuFav =new HashMap<>();
        this.cont = cont;
    }

    public DataImagen getImagen(){
        return imagen;
    }
    public void setImagen(DataImagen img){
        this.imagen=img;
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

    public String getSeguido(){
        return seguido;
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
    
    public void seguirUsuario(Usuario aSeguir){
       
        
        this.usuSeguidos.put(aSeguir.getNick(), aSeguir);
      //  return true;
          }
    
    public void seguirUsuBD(Usuario aSeguir){
        
        this.usuSeguidos.put(aSeguir.getSeguido(), aSeguir);
    }
    
    
    public boolean dejarDeSeguir(Usuario aSeguir){
   this.usuSeguidos.remove(aSeguir.getNick());
   return true;
    }
    
    

    public Usuario(String nick, String nombre, String Apellido, String Correo, Date fecha, String img, String tipo, String cont){
        this.nick = nick;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.Correo = Correo;
        this.fecha = fecha;
        this.img = img;
        this.tipo=tipo;
        this.propuFav = new HashMap<>();
        this.usuSeguidos = new HashMap<>();
        this.cont = cont;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
}