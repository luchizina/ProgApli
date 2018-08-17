package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Luchi
 */
public class ListEstado {
    private
            
            Date fecha;
            Time hora;
            Estado est;

    public ListEstado(Date fecha, Time hora, Estado est) {
        this.fecha = fecha;
        this.hora = hora;
        this.est = est;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }



    public Estado getEst() {
        return est;
    }

    public void setEst(Estado est) {
        this.est = est;
    }
            
            
}
