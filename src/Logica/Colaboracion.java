package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;

/**
 *
 * @author Luchi
 */
public class Colaboracion {
    private
            DtFecha fecha;
            Tretorno retorno;
            int monto;
            Colaborador colab;
            Propuesta prop;

    public Colaboracion(DtFecha fecha, Tretorno retorno, int monto, Colaborador colab, Propuesta prop) {
        this.fecha = fecha;
        this.retorno = retorno;
        this.monto = monto;
        this.colab = colab;
        this.prop = prop;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public Tretorno getRetorno() {
        return retorno;
    }

    public void setRetorno(Tretorno retorno) {
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
