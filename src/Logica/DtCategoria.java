package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/**
 *
 * @author Luchi
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria {
    private
            String nombre;
            String padre;
             Map<String,Categoria> hijos;
             int profundidad;
            
            public DtCategoria(String nombre, String padre, Map<String,Categoria> hijos){
                this.nombre=nombre;
                this.padre=padre;
                this.hijos=hijos;
            }
            public DtCategoria(String nombre, String padre, int profundidad){
                this.nombre=nombre;
                this.padre=padre;
                this.profundidad=profundidad;
            }
            
            public DtCategoria(String nombre, String padre){
                this.nombre= nombre;
                this.padre=padre;
            }
            public String getNombre(){
                return this.nombre;
                           }
            
            public String getPadre(){
                return this.padre;
            }
            
            public int getProfundidad(){
                return this.profundidad;
            }
                    
            
            public Map<String,Categoria> getHijos(){
                return this.hijos;
            }
}
