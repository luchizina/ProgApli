/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

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

    public Proponente(String direccion, String biografia, String linkWeb, String nick, String nombre, String Apellido, String Correo, DtFecha fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav) {
        super(nick, nombre, Apellido, Correo, fecha, img, usuSeguidos, propuFav);
        this.direccion = direccion;
        this.biografia = biografia;
        this.linkWeb = linkWeb;
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

    public String getLinkWeb() {
        return linkWeb;
    }

    public void setLinkWeb(String linkWeb) {
        this.linkWeb = linkWeb;
    }
            
            
         
}
