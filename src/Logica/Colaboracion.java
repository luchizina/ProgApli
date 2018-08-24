package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Date;

/**
 *
 * @author Luchi
 */
public class Colaboracion {
    private
            Date fecha;
            String retorno;
            int monto;
            Colaborador colab;
            Propuesta prop;
            String hora;

            Fabrica fab = Fabrica.getInstance();
            private IPropuesta IP = fab.getICtrlPropuesta();
            private IUsuario iUsu = fab.getICtrlUsuario();
    public Colaboracion(Date fecha, String retorno, int monto, Colaborador colab, Propuesta prop, String hora) {
        this.fecha = fecha;
        this.retorno = retorno;
        this.monto = monto;
        this.colab = colab;
        this.prop = prop;
        this.hora = hora;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Colaborador getColab() {
        return colab;
    }

    public void setColab(Colaborador colab) {
        this.colab = colab;
    }

    public Propuesta getProp() {
        return prop;
    }

    public void setProp(Propuesta prop) {
        this.prop = prop;
    }
            
            
}
