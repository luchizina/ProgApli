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
            String tRetornos;
            Map<String, DtColaborador> colaboradores;
            String propoACargo;
            Estado estActual;
            String categoria="";
       

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
    this.tRetornos = p.getTipoRetorno();
    this.colaboradores = p.listarColaboradores();
    this.propoACargo = p.getProp();
    this.estActual = p.getEstActual();
}

// AGREGE CATEGORIA 
public DtPropuesta(Propuesta p, String x){
    this.titulo = p.getTitulo();
    this.desc = p.getDesc();
    this.img = p.getImg();
    this.fecha = p.getFecha();
    this.lugar = p.getLugar();
    this.precio = p.getPrecioE();
    this.montoActual = p.getMontoActual();
    this.montoTotal = p.getMontoTotal();
    this.fechaPub = p.getFechaPub();
    this.tRetornos = p.getTipoRetorno();
    this.colaboradores = p.listarColaboradores();
    this.propoACargo = p.getProp();
    this.estActual = p.getEstActual();
    this.categoria = x;

};

public String getTitulo()
{
    return titulo;
}

public String getDescripcion()
{
    return desc;
}

public String getImg()
{
    return img;
}

public Date getFecha()
{
    return fecha;
}

public String getLugar()
{
    return lugar;
}

public int getPrecio()
{
    return precio;
}

public int getMontoActual()
{
    return montoActual;
}

public int getMontototal()
{
    return montoTotal;
}

public Date getFechaPub()
{
    return fechaPub;
}

public String getPropo()
{
    return propoACargo;
}

public Estado getEstActual()
{
    return estActual;
}

public String getTRetornos()
{
    return tRetornos;
}

public String getNombreCate()
{
    return categoria;
}

public Map<String, DtColaborador> getColabs()
        {
            return this.colaboradores;
        }
}
