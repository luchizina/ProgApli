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
public class ListEstado {
    private
            DtFecha fecha;
            int hora;
            Estado est;

    public ListEstado(DtFecha fecha, int hora, Estado est) {
        this.fecha = fecha;
        this.hora = hora;
        this.est = est;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Estado getEst() {
        return est;
    }

    public void setEst(Estado est) {
        this.est = est;
    }
            
            
}
