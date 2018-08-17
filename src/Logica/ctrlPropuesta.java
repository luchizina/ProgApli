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
import java.text.ParseException;
import java.util.HashMap;
//import Persistencia.DBPersona;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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
         this.dbE= new DBListEstado();
        //this.dbPersona=new DBPersona();
    }
    public Map<String, Propuesta> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(Map<String, Propuesta> propuestas) {
        this.propuestas = propuestas;
    }

//(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cate,String img)
         @Override
    public boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img,String nickP,String hora,String Lugar) {
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
                //  public Propuesta(String titulo, String desc, Date fecha, int precioE, String fechaPub, int montoTotal, String cate,String Lugar) {
    
                Propuesta pe;
                pe = new Propuesta(titulo,desc,fecha,  precioE,montoActual, fechaPub,Retorno, montoTotal, cate,estActual,img,Lugar);
                pe.setProp(nickP);
                pe.setEstActual(estActual);
                
                boolean res;
                res = this.dbPropuesta.agregarPropuesta(pe);
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
                    ListEstado est = new ListEstado(fechaPub,fecFormatoTime, Testado.ingresada) ;
                    System.out.println(est.getEst().toString() + est.getFecha().toString() + est.getHora().toString() + " ESTOOOOOOOOOOOoo");
                    // pe.getListaDeEstados().put(estActual.getEstado(), est);
                  
                    boolean Est =  this.dbE.agregarEstado(est, titulo);
                    if(Est){
                        System.out.println("Lo hace bien!!!");
                    }
                    else{
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
    }        return false;
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
    
    }

