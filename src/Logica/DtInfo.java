/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author nambr
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtInfo {
    boolean estLogin;
    String mensaje;
    String nick;
    String tipoUser;
    
    public DtInfo(boolean est, String mens, String nick, String tipoUser){
        
        this.estLogin=est;
        this.mensaje=mens;
        this.nick=nick;
        this.tipoUser=tipoUser;
    }
    
    public boolean getEstLogin(){
        return estLogin;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public String getNick(){
        return nick;
    }
    
    public String getTipoUser(){
        return tipoUser;
    }
    
    public void setNick(String nick){
        this.nick=nick;
    }
    
    public void setTipo(String tipo){
        this.tipoUser=tipo;
    }
    
    public void setEstLogin(boolean esta){
        this.estLogin=esta;
        
    }
    
    public void setMensaje(String mens){
        this.mensaje=mens;
    }
}
