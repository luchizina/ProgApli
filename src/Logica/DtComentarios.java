/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Nuevo
 */
public class DtComentarios {
    String nick;
    String propu;
    String comentario;
    
    public DtComentarios(String nick, String prop, String com){
        this.nick=nick;
        this.propu=prop;
        this.comentario=com;
    }

    public String getNick() {
        return nick;
    }

    public String getPropu() {
        return propu;
    }

    public String getComentario() {
        return comentario;
    }
    
    
}
