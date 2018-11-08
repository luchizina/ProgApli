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
 * @author Nuevo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataReporte {
    String nick;
    String nombre;

    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEmision() {
        return emision;
    }

    public String getPropuesta() {
        return propuesta;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getMonto() {
        return monto;
    }

    public String getRetorno() {
        return retorno;
    }

    public int getCvc() {
        return cvc;
    }

    public String getVenc() {
        return venc;
    }

    public String getNum() {
        return num;
    }

    public String getTipoT() {
        return tipoT;
    }

    public String getBanco() {
        return banco;
    }
    String apellido;
    String fechaNac;
    String correo;
    String emision;
    String propuesta;
    String fecha;
    String hora;
    int monto;
    String retorno;
    int cvc;
    String venc;
    String num;
    String tipoT;
    String banco;
    
    public DataReporte(String nick, String nombre, String ap, String fecN, String correo, String emision, String prop, String fecha, String hora, int mont, String retorno, String num){
        this.nick=nick;
        this.nombre=nombre;
        this.apellido=ap;
        this.fechaNac=fecN;
        this.correo=correo;
        this.emision=emision;
        this.propuesta=prop;
        this.fecha=fecha;
        this.hora=hora;
        this.monto=mont;
        this.retorno=retorno;
        this.num=num;
    }
    
    public DataReporte(String nick, String nombre, String ap, String fecN, String correo, String emision, String prop, String fecha, String hora, int mont, String retorno, String num, String ban){
        this.nick=nick;
        this.nombre=nombre;
        this.apellido=ap;
        this.fechaNac=fecN;
        this.correo=correo;
        this.emision=emision;
        this.propuesta=prop;
        this.fecha=fecha;
        this.hora=hora;
        this.monto=mont;
        this.retorno=retorno;
        this.num=num;
        this.banco=ban;
    }
    
    public DataReporte(String nick, String nombre, String ap, String fecN, String correo, String emision, String prop, String fecha, String hora, int mont, String retorno, String num, int cvc, String ven, String tipoT){
        this.nick=nick;
        this.nombre=nombre;
        this.apellido=ap;
        this.fechaNac=fecN;
        this.correo=correo;
        this.emision=emision;
        this.propuesta=prop;
        this.fecha=fecha;
        this.hora=hora;
        this.monto=mont;
        this.retorno=retorno;
        this.num=num;
        this.cvc=cvc;
        this.venc=ven;
        this.tipoT=tipoT;
    }
}
