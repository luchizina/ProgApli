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
public class Proponente extends Usuario {
    private
            String direccion;
            String biografia;
            String linkWeb;
            private Map<String, Propuesta> propuestas;
            Boolean activo;
            Date fecha_des;

    public Proponente(String direccion, String biografia, String linkWeb, String nick, String nombre, String Apellido, String Correo, Date fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav, String cont) {
        super(nick, nombre, Apellido, Correo, fecha, img, usuSeguidos, propuFav, cont);
        this.direccion = direccion;
        this.biografia = biografia;
        this.linkWeb = linkWeb;
        this.propuestas = new HashMap<>(); // agregado
    }

    public Proponente(String nick) {
        super(nick);
        
    }

    

    

    public Proponente(String nick, String nombre, String Apellido, String Correo, Date fecha, String img, String Tipo, String cont) {
        super(nick, nombre, Apellido, Correo, fecha, img, Tipo, cont);
    }

    public Proponente(String nick, String nombre, String Apellido, String Correo, Date fecha, String img, String dir, String bio, String link, String tipo, String cont, boolean act, Date fecha_desac) {
        super(nick, nombre, Apellido, Correo, fecha, img, tipo, cont);
        this.direccion=dir;
        this.biografia=bio;
        this.linkWeb=link;
        this.propuestas = new HashMap<>(); // agregado
        this.activo=act;
        this.fecha_des=fecha_desac;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Date getFecha_des() {
        return fecha_des;
    }



   

    public String getLinkWeb() {
        return linkWeb;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }
            
    public DtProponente obtenerInfo(){
        return new DtProponente(nick, img, biografia, linkWeb, direccion, nombre, Apellido, Correo);
    }         

    public Map<String, Propuesta> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(Map<String, Propuesta> propuestas) {
        this.propuestas = propuestas;
    }

}
