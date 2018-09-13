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
import Logica.Comentario;

/**
 *
 * @author Luchi
 */
public class Colaborador extends Usuario {

        private
                List<Colaboracion> colHechas;
                List<Comentario> comentarios;

    public Colaborador(List<Colaboracion> colHechas, String nick, String nombre, String Apellido, String Correo, Date fecha, String img, Map<String, Usuario> usuSeguidos, Map<String, Propuesta> propuFav, String cont) {
        super(nick, nombre, Apellido, Correo, fecha, img, usuSeguidos, propuFav, cont);
        this.colHechas = colHechas;
        this.comentarios = new ArrayList<>();
    }

    public Colaborador(String Nick, String Nombre, String Apellido, String Correo, Date fecha, String Imagen, String tipo, String cont) {
       super(Nick, Nombre, Apellido, Correo, fecha, Imagen, tipo, cont);
       this.colHechas = new ArrayList<>(); 
        this.comentarios = new ArrayList<>();
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

    void removeColab(Colaboracion co)
    {
        this.colHechas.remove(co);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
 
    public void Agregar_Comentario(Comentario x){
        this.comentarios.add(x);
    };
}
