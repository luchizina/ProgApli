/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Propuesta;
import Persistencia.DBPropuesta;
import java.util.HashMap;
//import Persistencia.DBPersona;
import java.util.Map;
import java.text.SimpleDateFormat;
/**
 *
 * @author Luchi
 */
public class ctrlPropuesta implements IPropuesta {
         private Map<String, Propuesta> propuestas;
         private static ctrlPropuesta instancia;
         DBPropuesta dbPropuesta = null;
   
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

@Override

    public boolean AgregarPropuesta(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cate) {
        if (this.propuestas.get(titulo)!=null){
            return false;
        }else{
           
            Propuesta pe = new Propuesta(titulo, desc,  fecha,  precioE, fechaPub, montoTotal, cate);
               boolean res= this.dbPropuesta.agregarPropuesta(pe);  
                if (res){
                //Colección genérica común
                //this.personas.add(p);
                this.propuestas.put(titulo, pe);
                pe.setCate(cate);
             
                }   
            return res;
        }
      
    }
    }

