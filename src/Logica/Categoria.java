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
public class Categoria {
    private 
            String nombre;
            Categoria hijos;

    public Categoria(String nombre, Categoria hijos) {
        this.nombre = nombre;
        this.hijos = hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getHijos() {
        return hijos;
    }

    public void setHijos(Categoria hijos) {
        this.hijos = hijos;
    }
            
            
            
    
}
