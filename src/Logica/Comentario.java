/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Colaborador;
import Logica.Propuesta;

/**
 *
 * @author matheo
 */
public class Comentario {
    private 
            Colaborador colaborador;
            Propuesta propuesta;
            String texto;
            
            
    public Comentario(Colaborador xcolaborador, Propuesta xpropuesta, String xtexto) {
        this.colaborador = xcolaborador;
        this.propuesta = xpropuesta;
        this.texto = xtexto;
    }        

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public void setPropuesta(Propuesta propuesta) {
        this.propuesta = propuesta;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public Propuesta getPropuesta() {
        return propuesta;
    }

    public String getTexto() {
        return texto;
    }
    
}
