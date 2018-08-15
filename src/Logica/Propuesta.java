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
           String fecha;
            int precioE;
            int montoActual;
            String fechaPub;
            String tipoRetorno;
            int montoTotal;
            Categoria cat;
            String cate;
            Estado estActual;
            ListEstado listaEstados;
            String img;
            String Prop;
            private Map<Testado, ListEstado> listaDeEstados;
public Propuesta(){

}

public Propuesta(String titulo, String desc, String fecha, int precioE, int montoActual, String fechaPub, String tipoRetorno, int montoTotal,String cate, Estado estActual, String img) {
        this.titulo = titulo;
        this.desc = desc;
        this.fecha = fecha;
        this.precioE = precioE;
        this.montoActual = montoActual;
        this.fechaPub = fechaPub;
        this.tipoRetorno = tipoRetorno;
        this.montoTotal = montoTotal;
        this.cat = cat;
        this.cate = cate;
        this.estActual = estActual;
        
        this.img = img;
        this.Prop = Prop;
        this.listaDeEstados = listaDeEstados;
        
    }


    public String getProp() {
        return Prop;
    }
   
 
        
    public Propuesta(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cate,String img) {
        this.titulo = titulo;
        this.desc = desc;
        this.fecha = fecha;
        this.precioE = precioE;
        this.fechaPub = fechaPub;
        this.montoTotal = montoTotal;
        this.cate = cate;
        this.img = img;
        
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setProp(String Prop) {
        this.Prop = Prop;
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

    public String getTipoRetorno() {
        return tipoRetorno;
    }

    public void setTipoRetorno(String tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
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

    public Map<Testado, ListEstado> getListaDeEstados() {
        return listaDeEstados;
    }

    public void setListaDeEstados(Map<Testado, ListEstado> listaDeEstados) {
        this.listaDeEstados = listaDeEstados;
    }

   
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(String fechaPub) {
        this.fechaPub = fechaPub;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public Estado getEstActual() {
        return estActual;
    }

    public void setEstActual(Estado estActual) {
        this.estActual = estActual;
    }

    public ListEstado getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(ListEstado listaEstados) {
        this.listaEstados = listaEstados;
    }
    
}
