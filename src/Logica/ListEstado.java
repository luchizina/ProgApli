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
public class ListEstado {
    private
            
            String fecha;
            String hora;
            Estado est;

    public ListEstado(String fecha, String hora, Estado est) {
        this.fecha = fecha;
        this.hora = hora;
        this.est = est;
    }

  

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

   

   

    public Estado getEst() {
        return est;
    }

    public void setEst(Estado est) {
        this.est = est;
    }
            
            
}
