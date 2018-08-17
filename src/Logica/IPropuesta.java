/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Luchi
 */
public interface IPropuesta {
    
          
 public abstract boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img,String nickP, String hora, String Lugar);
  public abstract void cargarPropuestas();      
}
