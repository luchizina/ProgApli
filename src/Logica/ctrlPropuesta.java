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
import java.text.DateFormat;
import java.text.ParseException;
import java.util.HashMap;
//import Persistencia.DBPersona;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
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
    public boolean AgregarPropuesta(String titulo, String desc, String fecha, int precioE, int montoActual, String fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img,String nickP,String hora) {
        if (this.propuestas.get(titulo)!=null){
            return false;
        }else{
           
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
             Propuesta pe = new Propuesta(titulo,desc,fecha,  precioE,montoActual, fechaPub,Retorno, montoTotal, cate,estActual,img);
            pe.setProp(nickP);
            pe.setEstActual(estActual);
            
               boolean res= this.dbPropuesta.agregarPropuesta(pe);  
                if (res){
                //Colección genérica común
                //this.personas.add(p);
                this.propuestas.put(titulo, pe);
                pe.setCate(cate);
                
                ListEstado est = new ListEstado(fechaPub,hora, estActual);
                // pe.getListaDeEstados().put(estActual.getEstado(), est);
                 this.dbE.agregarEstado(est, titulo);
                         }
                  return res;
        }
          
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
      
    }
    

