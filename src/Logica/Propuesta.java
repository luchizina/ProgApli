/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Map;

/**
 *
 * @author Luchi
 */
public class Propuesta {
    private 
            String titulo;
            String desc;
            DtFecha fecha;
            int precioE;
            int montoActual;
            DtFecha fechaPub;
            Tretorno tipoRetorno;
            int montoTotal;
            Categoria cat;
            Estado estActual;
            ListEstado listaEstados;
            
             private Map<Integer, ListEstado> listaDeEstados;
    public Propuesta(String titulo, String desc, DtFecha fecha, int precioE, int montoActual, DtFecha fechaPub, Tretorno tipoRetorno, int montoTotal) {
        this.titulo = titulo;
        this.desc = desc;
        this.fecha = fecha;
        this.precioE = precioE;
        this.montoActual = montoActual;
        this.fechaPub = fechaPub;
        this.tipoRetorno = tipoRetorno;
        this.montoTotal = montoTotal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public int getPrecioE() {
        return precioE;
    }

    public void setPrecioE(int precioE) {
        this.precioE = precioE;
    }

    public int getMontoActual() {
        return montoActual;
    }

    public void setMontoActual(int montoActual) {
        this.montoActual = montoActual;
    }

    public DtFecha getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(DtFecha fechaPub) {
        this.fechaPub = fechaPub;
    }

    public Tretorno getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(Tretorno tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(int montoTotal) {
        this.montoTotal = montoTotal;
    }
    
    public DtPropuesta obtenerInfo() 
    {
        return null;
    }
    
    public void IngresarValores(DtPropuesta valor) 
    {
    
    }

    public Map<Integer, ListEstado> getListaDeEstados() {
        return listaDeEstados;
    }

    public void setListaDeEstados(Map<Integer, ListEstado> listaDeEstados) {
        this.listaDeEstados = listaDeEstados;
    }
    
}
