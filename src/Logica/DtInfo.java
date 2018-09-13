/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author nambr
 */
public class DtInfo {
    boolean estLogin;
    String mensaje;
    
    public DtInfo(boolean est, String mens){
        
        this.estLogin=est;
        this.mensaje=mens;
    }
    
    public boolean getEstLogin(){
        return estLogin;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setEstLogin(boolean esta){
        this.estLogin=esta;
        
    }
    
    public void setMensaje(String mens){
        this.mensaje=mens;
    }
}
