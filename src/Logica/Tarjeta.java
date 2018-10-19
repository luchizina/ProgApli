/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;

/**
 *
 * @author Nuevo
 */
public class Tarjeta extends pagos{
    String tipo;
    Date fecha;
    int cvc;
    public Tarjeta(String numero, Colaboracion col, String tipo, Date fecha, int cvc){
        super(numero, col);
        this.tipo=tipo;
        this.fecha=fecha;
        this.cvc=cvc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}
