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
            
            String fecha;
            String hora;
            String est;

    public ListEstado(String fecha, String hora, String est) {
        this.fecha = fecha;
        this.hora = hora;
        this.est = est;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }



    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }
            
            
}
