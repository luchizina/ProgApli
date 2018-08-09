package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Map;

/**
 *
 * @author Luchi
 */
public class DtColaborador extends DtUsuario {
    private
            String nick;
            String nombre;
            String apellido;
            String correo;
            DtFecha fecha;
            String img;
            Map<String,DtColaboracion> colaboraciones;

    public DtColaborador(String nick, String nombre, String apellido, String correo, DtFecha fecha, String img, Map<String, DtColaboracion> colaboraciones) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fecha = fecha;
        this.img = img;
        this.colaboraciones = colaboraciones;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Map<String, DtColaboracion> getColaboraciones() {
        return colaboraciones;
    }

    public void setColaboraciones(Map<String, DtColaboracion> colaboraciones) {
        this.colaboraciones = colaboraciones;
    }

            
    
}
