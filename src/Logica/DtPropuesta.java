package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;
import java.util.Map;
import java.util.Date;

/**
 *
 * @author Luchi
 */
public class DtPropuesta{
    private 
            String titulo;
            String desc;
            String img;
            Date fecha;
            String lugar;
            int precio;
            int montoActual;
            int montoTotal;
            Date fechaPub;
             Map<String, DtColaborador> colaboradores;
             DtProponente propoACargo;
             String estActual;
       

public DtPropuesta(Propuesta p)
{
    this.titulo = p.getTitulo();
    this.desc = p.getDesc();
    this.img = p.getImg();
    this.fecha = p.getFecha();
    this.lugar = p.getLugar();
    this.precio = p.getPrecioE();
    this.montoActual = p.getMontoActual();
    this.montoTotal = p.getMontoTotal();
    this.fechaPub = p.getFechaPub();
    
}

}