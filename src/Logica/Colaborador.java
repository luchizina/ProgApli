/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Luchi
 */
public class Colaborador extends Usuario {

        private
                List<Colaboracion> colHechas;

    public Colaborador(List<Colaboracion> colHechas, String nick, String nombre, String Apellido, String Correo, Date fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav) {
        super(nick, nombre, Apellido, Correo, fecha, img, usuSeguidos, propuFav);
        this.colHechas = colHechas;
    }

    public Colaborador(String Nick, String Nombre, String Apellido, String Correo, Date fecha, String Imagen, String tipo) {
       super(Nick, Nombre, Apellido, Correo, fecha, Imagen, tipo);
       this.colHechas = new ArrayList<>(); 
    }

   public void AddColab(Colaboracion c)
   {
       this.colHechas.add(c);
   }
   

    public List<Colaboracion> getColHechas() {
        return colHechas;
    }

    public void setColHechas(List<Colaboracion> colHechas) {
        this.colHechas = colHechas;
    }
    
    public DtColaborador obtenerInfo()
    {
        return new DtColaborador(this.nick, this.nombre, this.Apellido, this.Correo, this.fecha, this.img, this.colHechas);
    }
    
    
}
