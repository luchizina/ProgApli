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
public class DtColaboracion {
    private
            DtFecha fecha;
            int monto;
            Tretorno retorno;
            DtColaborador colaborador;
            DtPropuesta propuesta;

    public DtColaboracion(DtFecha fecha, int monto, Tretorno retorno, DtColaborador colaborador, DtPropuesta propuesta) {
        this.fecha = fecha;
        this.monto = monto;
        this.retorno = retorno;
        this.colaborador = colaborador;
        this.propuesta = propuesta;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Tretorno getRetorno() {
        return retorno;
    }

    public void setRetorno(Tretorno retorno) {
        this.retorno = retorno;
    }

    public DtColaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(DtColaborador colaborador) {
        this.colaborador = colaborador;
    }

    public DtPropuesta getPropuesta() {
        return propuesta;
    }

    public void setPropuesta(DtPropuesta propuesta) {
        this.propuesta = propuesta;
    }
            
           
}
