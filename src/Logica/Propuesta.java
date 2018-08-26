/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Luchi
 */
public class Propuesta {
    private 
            String titulo;
            String desc;
            Date fecha;
            int precioE;
            int montoActual;
            Date fechaPub;
            String tipoRetorno;
            int montoTotal;
            Categoria cat;
            String cate;
            Estado estActual;
            ListEstado listaEstados; // ?
            String img;
            String lugar;
            String Prop;
            List<Colaboracion> colaboraciones;
            //private Map<Testado, ListEstado> listaDeEstados; // Cambiar a lista? 
            private List<ListEstado> LE;
            
public Propuesta(){

}

public void setLE(List<ListEstado>  ELX) {
        this.LE = ELX;
    }



public Propuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String tipoRetorno, int montoTotal,String cate, Estado estActual, String img,String lugar) {
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
        this.colaboraciones = new ArrayList();
        this.img = img;
        this.Prop = Prop;
        //this.listaDeEstados = listaDeEstados;
        this.LE = new ArrayList();
        this.lugar = lugar;
    }


    public String getPropo() {
        return Prop;
    }
     public Propuesta(String titulo, String desc, Date fecha, int precioE, Date fechaPub, int montoTotal, String cate,String lugar) {
        this.titulo = titulo;
        this.desc = desc;
        this.fecha = fecha;
        this.precioE = precioE;
        this.fechaPub = fechaPub;
        this.montoTotal = montoTotal;
        this.cate = cate;
        this.lugar = lugar;
        this.colaboraciones = new ArrayList<>();
        //this.listaDeEstados = new HashMap<>();
        this.LE  = new ArrayList();
     }
     
     public Propuesta(String titulo, String descripcion, Date fechita, int montoActual, Date fechaPub, String url, String tipoRetorno, int montoTotal, String categoria, String nickProp, int precioE)
     {
         this.titulo = titulo;
         this.desc = descripcion;
         this.fecha = fechita;
         this.montoActual = montoActual;
         this.fechaPub = fechaPub;
         this.img = url;
         this.tipoRetorno = tipoRetorno;
         this.montoTotal = montoTotal;
         this.cate = categoria;
         this.Prop = nickProp;
         this.precioE = precioE;
         this.colaboraciones = new ArrayList<>();
         //this.listaDeEstados = new HashMap<>();
          this.LE = new ArrayList();
         
     }
    public Propuesta(String titulo, String desc, Date fecha, int precioE, Date fechaPub, int montoTotal, String cate, String img, String lugar) {
        this.titulo = titulo;
        this.desc = desc;
        this.fecha = fecha;
        this.precioE = precioE;
        this.fechaPub = fechaPub;
        this.montoTotal = montoTotal;
        this.cate = cate;
        this.img = img;
        this.lugar = lugar;
        this.colaboraciones = new ArrayList<>();
        //this.listaDeEstados = new HashMap<>();
        this.LE = new ArrayList();
    }
    
    // AGREGE LUGAR 
    public Propuesta(String xlugar,String titulo, String descripcion, Date fechita, int montoActual, Date fechaPub, String url, String tipoRetorno, int montoTotal, String categoria, String nickProp, int precioE)
     {
         this.titulo = titulo;
         this.desc = descripcion;
         this.fecha = fechita;
         this.montoActual = montoActual;
         this.fechaPub = fechaPub;
         this.img = url;
         this.tipoRetorno = tipoRetorno;
         this.montoTotal = montoTotal;
         this.cate = categoria;
         this.Prop = nickProp;
         this.precioE = precioE;
         this.colaboraciones = new ArrayList<>();
         //this.listaDeEstados = new HashMap<>();
         this.LE = new ArrayList();
         this.lugar = xlugar;
         
     }
    
    
    
    
    public void addColab(Colaboracion c)
    {
        this.colaboraciones.add(c);
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
        DtPropuesta retorno = new DtPropuesta(this);
        return retorno;
    }
    
    public void IngresarValores(DtPropuesta valor) 
    {
    
    }

//    public Map<Testado, ListEstado> getListaDeEstados() {
//        return listaDeEstados;
//    }
//
//    public void setListaDeEstados(Map<Testado, ListEstado> listaDeEstados) {
//        this.listaDeEstados = listaDeEstados;
//    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(Date fechaPub) {
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

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    
    
    public Map<String, DtColaborador> listarColaboradores()
    {
        if(this.colaboraciones != null)
        {
        Map<String, DtColaborador> listita = new HashMap<>();
        for(int i = 0; i<this.colaboraciones.size(); i++)
        {
            DtColaborador aux;
            Colaboracion col = this.colaboraciones.get(i);
            aux = new DtColaborador(col.getColab().getNick(),col.getColab().getNombre(),col.getColab().getApellido(),col.getColab().getCorreo(),col.getColab().getFecha(),col.getColab().getImg());
            listita.put(col.getColab().getNick(),aux);
        }
        return listita;
    }
        return  null;
    }
    
    public List<String> NombreColaborantes(){ // aborrar
       List x =  new ArrayList<String>();
       if(this.colaboraciones == null)
           return null;
       //Set set = this.colaboraciones.entrySet();
       for(int i=0; i<this.colaboraciones.size(); i++){
           Colaboracion aux= (Colaboracion)this.colaboraciones.get(i);
           String N = aux.getColab().getNombre() +"("+ aux.getColab().getNick()+")";
            x.add(N); 
       }
       return x;
   };
    
    
    public void actualizarMonto()
    {
        this.montoActual = 0;
        for(int i = 0; i<this.colaboraciones.size(); i++)
        {
            Colaboracion aux = (Colaboracion) this.colaboraciones.get(i);
            this.montoActual = this.montoActual+aux.getMonto();
        }
    }


    void removeColab(Colaboracion co)
    {
         this.colaboraciones.remove(co);
    }
    
}
