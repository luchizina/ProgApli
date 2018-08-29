/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Propuesta;
import Persistencia.DBListEstado;
import Persistencia.DBPropuesta;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import Logica.Colaboracion;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.HashMap;
//import Persistencia.DBPersona;
import java.util.Map;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 *
 * @author Luchi
 */
public class ctrlPropuesta implements IPropuesta {

    private Map<String, Propuesta> propuestas;
    private static ctrlPropuesta instancia;
    private List<Colaboracion> colaboraciones;
    private Propuesta propuestaconsulta = null;
    DBPropuesta dbPropuesta = null;
    DBListEstado dbE = null;

    public static ctrlPropuesta getInstance() {
        if (instancia == null) {
            instancia = new ctrlPropuesta();
        }
        return instancia;
    }

    private ctrlPropuesta() {
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.propuestas = new HashMap<String, Propuesta>();
        this.dbPropuesta = new DBPropuesta();
        this.dbE = new DBListEstado();
        //this.dbPersona=new DBPersona();
    }

    public Map<String, Propuesta> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(Map<String, Propuesta> propuestas) {
        this.propuestas = propuestas;
    }
    
    public Propuesta getPropPorNick(String nick)
    {
        Propuesta pr = this.propuestas.get("Un día de Julio");
        return this.propuestas.get(nick);
    }
    
    public void actualizarMontos()
    {
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            aux.actualizarMonto();
        }
    }
 

//(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cate,String img)
    @Override
    public boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img, String nickP, String hora, String Lugar) {
        if (this.propuestas.get(titulo) != null) {
            return false;
        } else {
            try {
                if (img.equals("") == false) {
                    String[] aux = img.split("\\.");
                    String termina = aux[1];
                    String destino = "Imagenes/Propuesta/" + titulo + "." + termina;
                    try {
                        if (this.copy(img, destino) == true) {
                            img = destino;
                        } else {
                            img = null;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //  public Propuesta(String titulo, String desc, Date fecha, int precioE, String fechaPub, int montoTotal, String cate,String Lugar) {
                fechaPub = new Date();
                Propuesta pe;
                pe = new Propuesta(titulo, desc, fecha, precioE, montoActual, fechaPub, Retorno, montoTotal, cate, estActual, img, Lugar);
                pe.setProp(nickP);
                pe.setEstActual(estActual);

                boolean res;
                res = this.dbPropuesta.agregarPropuesta(pe);
                if (res) {

                    //Colección genérica común
                    //this.personas.add(p);
                    this.propuestas.put(titulo, pe);
                    pe.setCate(cate);

                    java.sql.Time fecFormatoTime = null;
                    try {
                        SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss", new Locale("es", "ES"));
                        fecFormatoTime = new java.sql.Time(sdf.parse(hora).getTime());
                        System.out.println("Fecha con el formato java.sql.Time: " + fecFormatoTime);
                    } catch (ParseException ex) {
                        System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
                    }
                    ListEstado est = new ListEstado(fechaPub, fecFormatoTime, "Ingresada");
                    System.out.println(est.getEst() + est.getFecha().toString() + est.getHora().toString() + " ESTOOOOOOOOOOOoo");
                    // pe.getListaDeEstados().put(estActual.getEstado(), est);

                    boolean Est = this.dbE.agregarEstado(est, titulo);
                    if (Est) {
                        System.out.println("Lo hace bien!!!");
                    } else {
                        System.out.println("Lo hace mal!!!");
                    }
                    return res;

                }
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public List<Colaboracion> listarColaboraciones()
    {
        return this.colaboraciones;
    }
    
    @Override
    public boolean existeColaboracion(String nick, String titulo)
    {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        Iterator iteradorsito = p.colaboraciones.iterator();
        while (iteradorsito.hasNext()) {
            
            Colaboracion aux = (Colaboracion) iteradorsito.next();
            if(aux.getColab().nick == nick)
                return true;
    }
        return false;
    }
    
    @Override
    public boolean altaColaboracion(Propuesta prop, Colaborador colab, String monto, String tipoR)
    {
        Date lul = new Date();
        String horita = java.time.LocalTime.now().toString();
        Colaboracion c = new Colaboracion(lul, tipoR, Integer.parseInt(monto), colab, prop, horita);
        
        if (dbPropuesta.agregarColaboracion(c))
        {
            this.colaboraciones.add(c);
            prop.addColab(c);
            colab.AddColab(c);
            prop.actualizarMonto();
            return true;
        }
        return false;
    }
    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("kkmmss");
        String currentTime = dateFormat.format(System.currentTimeMillis());
        return currentTime;
    }

    public void cancelarColaboracion(String c, String p)
    {
        String[] partes = c.split(Pattern.quote("("));
        String parte1 = partes[0];
        String parte2 = partes[1];
        String[] partes3 = parte2.split(Pattern.quote(")"));
        String parte4 = partes3[0];
        for(int i = 0; i<this.colaboraciones.size(); i++)
        {
            Colaboracion co = (Colaboracion) colaboraciones.get(i);
            if(co.getColab().getNick().equals(parte4) && co.getProp().getTitulo().equals(p))
            {
                try {
                    if(dbPropuesta.eliminarColaboracion(co))
                    {
                        this.colaboraciones.remove(co);
                        co.getColab().removeColab(co);
                        co.getProp().removeColab(co);
                        this.actualizarMontos();
                        co = null;
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public Date fecha(String fecha) {
        java.util.Date fec;
        java.sql.Date sqlDate = null;
        SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fec = da.parse(fecha);
            sqlDate = new java.sql.Date(fec.getTime());
            System.out.println(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }

    /* public Date horas(String hora) throws ParseException{
 
    return date;
    }*/
    public boolean copy(String origen, String destino) throws IOException {
        try {
            File aor = new File(origen);
            File ade = new File(destino);
            ade.getParentFile().mkdirs();
            ade.createNewFile();
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void cargarPropuestas() {
        this.propuestas = this.dbPropuesta.cargarPropuestas();
    }
    
    @Override
    public void cargarProp(){
        this.dbPropuesta.cargarPropuestasPrueba();
        this.dbE.agregarListPrueb();
        this.cargarPropuestas();
        this.EstadosPropuestas();
        this.dbPropuesta.colaboracionesPrueba();
        this.cargarColaboraciones();
        this.actualizarMontos();
    }
    
    public void cargarColaboraciones()
    {
        this.colaboraciones = this.dbPropuesta.cargarColaboraciones();
    }
    
    @Override
    public void cargarEstados(){
        this.dbPropuesta.cargarEstados();
    }

    public List<DtPropuesta> listarPropuestas() {
        List<DtPropuesta> listita = new ArrayList<>();
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            listita.add(aux.obtenerInfo());
        }
        return listita;
    }

    public DtPropuesta traerPropuesta(String titulo) {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        DtPropuesta q = new DtPropuesta(p);
        return q;
    }

 
    
    public DtPropuesta SeleccionarProp(String xTitulo) // error 
    {
    Propuesta pro = this.propuestas.get(xTitulo);
    DtPropuesta X = new DtPropuesta(pro,pro.getCate());
    this.propuestaconsulta = pro;
    return X; 
    }
    
    
    @Override
    public List<String> NombrePropoConsulta(){
        
        return this.propuestaconsulta.NombreColaborantes();
        
    };
    
    
    @Override
    public List<String> ListarProp(){
    List<String> Nicks = new ArrayList<String>();
    Set set = propuestas.entrySet();
    Iterator iterator = set.iterator();
    while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
            Propuesta aux=(Propuesta) mentry.getValue();
            if (aux != null){
            Nicks.add(aux.getTitulo()); 
            }
        }       
        return Nicks;
};
 
    @Override
    public List<String> ColaborantesDePro(){
        List<String> Nicks = new ArrayList<String>();
        Iterator iteradorsito = colaboraciones.iterator();
        while (iteradorsito.hasNext()) {
            Colaboracion aux = (Colaboracion) iteradorsito.next();
            if(aux.getProp().getTitulo().equals(this.propuestaconsulta.getTitulo())){
                String N = aux.getColab().getNombre() +"("+ aux.getColab().getNick()+")";
                Nicks.add(N); 
            }
    }
    this.propuestaconsulta = null;    
    return Nicks;
    };
    
    @Override
     public void EstadosPropuestas(){
        Set set = propuestas.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
            Propuesta aux=(Propuesta) mentry.getValue();
            this.dbE.SetearEstadoPropuesta(aux);
        }       
     };

    @Override
    public boolean actualizarDatos(String titulo, Date fecha, int entrada, int monto, String lugar, String cat, String retorno, String desc, String url) {
         if (url.equals("") == false) {
                    String[] aux = url.split("\\.");
                    String termina = aux[1];
                    String destino = "Imagenes/Propuesta/" + titulo + "." + termina;
                    try {
                        if (this.copy(url, destino) == true) {
                            url = destino;
                        } else {
                            url = null;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
         boolean ok=this.dbPropuesta.modificarProp(titulo, fecha, entrada, monto, lugar, cat, retorno, desc, url);
         if(ok){
             for(Propuesta prop: this.propuestas.values()){
                 if(prop.getTitulo().equals(titulo)){
                     prop.setFecha(fecha);
                     prop.setPrecioE(entrada);
                     prop.setMontoTotal(monto);
                     prop.setLugar(lugar);
                     prop.setCate(cat);
                     prop.setTipoRetorno(retorno);
                     prop.setDesc(desc);
                     prop.setImg(url);
                 }
             }
             return true;
         }
         else {
             return false;
         }
         
    }
}
