package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Map;
/**
 *
 * @author Luchi
 */
public class Categoria {
    private 
            String nombre; 
            String padre;
            Map<String,Categoria> hijos;

    public Categoria(String nombre, Map<String, Categoria> hijos) {
        this.nombre = nombre;
        this.hijos = hijos;
    }
    public Categoria(String nombre, String padre){
        this.nombre=nombre;
        this.padre=padre;
    }
    
    public Categoria(String nombre, String padre, Map<String, Categoria> hijos){
        this.nombre=nombre;
        this.padre=padre;
        this.hijos=hijos;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getPadre(){
        return padre;
    }
    public void setPadre(String padre){
        this.padre=padre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String,Categoria> getHijos() {
        return hijos;
    }

    public void setHijos(Map<String,Categoria> hijos) {
        this.hijos = hijos;
    }
    
    public DtCategoria obtenerInfo(){
        return new DtCategoria(nombre,padre, hijos);
    }
            
            
            
    
}
