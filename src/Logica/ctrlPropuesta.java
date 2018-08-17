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
/**
 *
 * @author Luchi
 */
public class ctrlPropuesta implements IPropuesta {
         private Map<String, Propuesta> propuestas;
         private static ctrlPropuesta instancia;
         DBPropuesta dbPropuesta = null;
          DBListEstado dbE = null;
   
public static ctrlPropuesta getInstance(){
        if (instancia == null){
            instancia = new ctrlPropuesta();
        }
        return instancia;
}
 private ctrlPropuesta(){
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.propuestas=new HashMap<String, Propuesta>();
         this.dbPropuesta=new DBPropuesta();
        //this.dbPersona=new DBPersona();
    }
    public Map<String, Propuesta> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(Map<String, Propuesta> propuestas) {
        this.propuestas = propuestas;
    }

//(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cate,String img)
    public boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img,String nickP,String hora,String lugar) {
        if (this.propuestas.get(titulo)!=null){
            return false;
        }else{
           
            try {
                if(img.equals("")==false){
                    String[] aux = img.split("\\.");
                    String termina = aux[1];
                    String destino = "Imagenes/Propusta/" + nickP + "." + termina;
                    try {
                        if(this.copy(img, destino)==true){
                            img=destino;
                        } else {
                            img = null;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //String titulo, String desc, String fecha, int precioE, int montoActual, String fechaPub, Tretorno tipoRetorno, int montoTotal, Categoria cat, String cate, Estado estActual, String img)
                Propuesta pe = new Propuesta(titulo,desc,fecha,  precioE,montoActual, fechaPub,Retorno, montoTotal, cate,estActual,img,lugar);
                pe.setProp(nickP);
                pe.setEstActual(estActual);
                
                boolean res= this.dbPropuesta.agregarPropuesta(pe);  
                if (res){
                    
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
//                    Date fec = fecha(fechaPub);
                    ListEstado est = new ListEstado(fechaPub,fecFormatoTime, estActual);
                    // pe.getListaDeEstados().put(estActual.getEstado(), est);
                   boolean Est =  this.dbE.agregarEstado(est, titulo);
                    if(Est){
                    }
                    else{
                        System.out.println("Lo hace mal!!!");
                    }
                    return res;
                }   } catch (SQLException ex) {  
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             return false;
    }
        
       private String getCurrentTime() {    
    SimpleDateFormat dateFormat = new SimpleDateFormat("kkmmss");
    String currentTime = dateFormat.format(System.currentTimeMillis());
    return currentTime;
}
    public Date fecha(String fecha){
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
     
     
       public boolean copy(String origen, String destino) throws IOException{
        try{
            File aor = new File(origen);
            File ade = new File(destino);
            ade.getParentFile().mkdirs();
            ade.createNewFile();
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch(IOException ex){
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
          
    public void cargarPropuestas()
    {
        this.propuestas = this.dbPropuesta.cargarPropuestas();
    }
    
    public List<DtPropuesta> listarPropuestas()
    {
        List<DtPropuesta> listita = new ArrayList<>();
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while(iteradorsito.hasNext())
        {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            listita.add(aux.obtenerInfo());
        }
        return listita;
    }
    
    
    public DtPropuesta traerPropuesta(String titulo)
    {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        DtPropuesta q = new DtPropuesta(p);
        return q;
    }
    }

