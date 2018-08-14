/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Luchi
 */
public interface IPropuesta {
    
    
    
 public abstract boolean AgregarPropuesta(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cat);
        
}
