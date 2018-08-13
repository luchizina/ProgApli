/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Luchi
 */
public class Colaborador extends Usuario {

        private
                Map<Integer, Colaboracion> colHechas;

    public Colaborador(Map<Integer, Colaboracion> colHechas, String nick, String nombre, String Apellido, String Correo, Date fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav) {
        super(nick, nombre, Apellido, Correo, fecha, img, usuSeguidos, propuFav);
        this.colHechas = colHechas;
    }

   
   

    public Map<Integer, Colaboracion> getColHechas() {
        return colHechas;
    }

    public void setColHechas(Map<Integer, Colaboracion> colHechas) {
        this.colHechas = colHechas;
    }
    
    
    
}
