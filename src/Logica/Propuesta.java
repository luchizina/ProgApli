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
import Logica.Comentario;
import Persistencia.DBPropuesta;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author Luchi
 */
public class Propuesta {

    private String titulo;
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
    //rivate Map<Testado, ListEstado> listaDeEstados; // Cambiar a lista? 
    private List<ListEstado> LE;
    private List<Comentario> cometarios;

    public List<ListEstado> getLE() {
        return LE;
    }

    public List<Comentario> getCometarios() {
        return cometarios;
    }

    public void setCometarios(List<Comentario> xcometarios) {
        this.cometarios = xcometarios;
    }

    public Propuesta() {

    }

    public void setLE(List<ListEstado> ELX) {
        this.LE = ELX;
    }

    public void addLE(ListEstado estadito) {
        this.LE.add(estadito);
    }

    public Propuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String tipoRetorno, int montoTotal, String cate, Estado estActual, String img, String lugar) {
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
        this.cometarios = new ArrayList();
        this.lugar = lugar;
    }

    public String getPropo() {
        return Prop;
    }

    public Propuesta(String titulo, String desc, Date fecha, int precioE, Date fechaPub, int montoTotal, String cate, String lugar) {
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
        this.LE = new ArrayList();
        this.cometarios = new ArrayList();
    }

    public Propuesta(String titulo, String descripcion, Date fechita, int montoActual, Date fechaPub, String url, String tipoRetorno, int montoTotal, String categoria, String nickProp, int precioE) {
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
        this.cometarios = new ArrayList();
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
        this.cometarios = new ArrayList();
    }

    // AGREGE LUGAR 
    public Propuesta(String xlugar, String titulo, String descripcion, Date fechita, int montoActual, Date fechaPub, String url, String tipoRetorno, int montoTotal, String categoria, String nickProp, int precioE) {
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
        this.cometarios = new ArrayList();

    }

    public void addColab(Colaboracion c) {
        
        this.colaboraciones.add(c);
    }
    
    public boolean tieneColab()
    {
        if(this.colaboraciones.size() == 0)
        {
            return false;
        }
        return true;
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

    public DtPropuesta obtenerInfo() {
        DtPropuesta retorno = new DtPropuesta(this);
        return retorno;
    }

    public void IngresarValores(DtPropuesta valor) {

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

    public List<Colaboracion> getColaboraciones() {
        return colaboraciones;
    }
    
    public Colaboracion traerSegunCol(Colaborador usu){
        for(Colaboracion colab : colaboraciones){
            if(colab.getColab().equals(usu)){
                return colab;
            }
        }
        return null;
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

    public Map<String, DtColaborador> listarColaboradores() {
        if (this.colaboraciones != null) {
            Map<String, DtColaborador> listita = new HashMap<>();
            for (int i = 0; i < this.colaboraciones.size(); i++) {
                DtColaborador aux;
                Colaboracion col = this.colaboraciones.get(i);
                aux = new DtColaborador(col.getColab().getNick(), col.getColab().getNombre(), col.getColab().getApellido(), col.getColab().getCorreo(), col.getColab().getFecha(), col.getColab().getImg());
                listita.put(col.getColab().getNick(), aux);
            }
            return listita;
        }
        return null;
    }

    public List<String> NombreColaborantes() { // aborrar
        List x = new ArrayList<String>();
        if (this.colaboraciones == null) {
            return null;
        }
        //Set set = this.colaboraciones.entrySet();
        for (int i = 0; i < this.colaboraciones.size(); i++) {
            Colaboracion aux = (Colaboracion) this.colaboraciones.get(i);
            String N = aux.getColab().getNombre() + "(" + aux.getColab().getNick() + ")";
            x.add(N);
        }
        return x;
    }

    ;
    
    
    public void actualizarMonto() throws SQLException {
        this.montoActual = 0;
        for (int i = 0; i < this.colaboraciones.size(); i++) {
            Colaboracion aux = (Colaboracion) this.colaboraciones.get(i);
            this.montoActual = this.montoActual + aux.getMonto();
        }
        DBPropuesta p = new DBPropuesta();
        p.actualizarMonto(this, this.montoActual);
        
    }

    void removeColab(Colaboracion co) {
        this.colaboraciones.remove(co);
    }

    public void Agregar_Comentario(Comentario x) {
        this.cometarios.add(x);
    };
    
    boolean Comento_Propuesta(String c){
        for(int i = 0; i<this.cometarios.size(); i++)
        {
            Comentario aux = (Comentario) this.cometarios.get(i);
            if(c.equals(aux.getColaborador().getNick()))
                return true;
        }
        return false;
    };
    
    
    public Date sacaFechaPub(){
        Date act = new Date();
        List estados = new ArrayList<ListEstado>();
        for(int i=0; i<this.getLE().size(); i++){
            if(this.estActual.getEstado().equals(Testado.Publicada)){
                ListEstado p = (ListEstado) this.getLE().get(i);
                if(p.getEst().equals("Publicada")){
                    estados.add(p);
                }
            }
        }
        Collections.sort(estados, (ListEstado dt1, ListEstado dt2) -> dt1.getFecha().compareTo(dt2.getFecha()));
        ListEstado est = (ListEstado) estados.get(estados.size()-1);
        return est.getFecha();
    }
    
     public Date sacaFechaFin(){
        Date act = new Date();
        List estados = new ArrayList<ListEstado>();
        for(int i=0; i<this.getLE().size(); i++){
                ListEstado p = (ListEstado) this.getLE().get(i);
                if(p.getEst().equals("En_Financiacion") || p.getEst().equals("En Financiacion")){
                    estados.add(p);
                }
        }
        Collections.sort(estados, (ListEstado dt1, ListEstado dt2) -> dt1.getFecha().compareTo(dt2.getFecha()));
        ListEstado est = (ListEstado) estados.get(estados.size()-1);
        return est.getFecha();
    }
     
     public int MontoA30(){
        int monto = 0;
        Date fech = this.sacaFechaFin();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fech);
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        Date comp = calendar.getTime();
        for (int i = 0; i < this.colaboraciones.size(); i++) {
            Colaboracion aux = (Colaboracion) this.colaboraciones.get(i);
            if(aux.getFecha().before(comp)){
                monto = monto + aux.getMonto();
            }
        }
        return monto;
    }
    
}
