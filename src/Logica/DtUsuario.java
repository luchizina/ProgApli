package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author Luchi
 */
public class DtUsuario {

    String nick;
    String nombre;
    String apellido;
    String seguido;
    private DataImagen imagen;

    public String getSeguido(){
        return seguido;
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



}

