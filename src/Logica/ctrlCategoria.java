/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import Persistencia.DBCategoria;
import Logica.Categoria;
import java.util.Iterator;


/**
 *
 * @author Luchi
 */
public class ctrlCategoria implements ICategoria {
         private static ctrlCategoria instancia;
      private Map<String, Categoria> categorias;
    private DBCategoria dbCategoria=null;
   
public static ctrlCategoria getInstance(){
        if (instancia == null){
            instancia = new ctrlCategoria();
        }
        return instancia;
}
private ctrlCategoria(){
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.categorias=new HashMap<String, Categoria>();
        this.dbCategoria=new DBCategoria();
    }

 @Override
public void cargarCategorias(){
    
    this.categorias=this.dbCategoria.cargarCategorias();
    
}

 @Override
public List<DtCategoria> listarCategorias(){
        List<DtCategoria> retorna=new ArrayList<DtCategoria>();
   // DtCategoria nuevo=null;
          Set set = categorias.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Categoria aux=(Categoria) mentry.getValue();    
            retorna.add(aux.obtenerInfo());
            }       
        return retorna;
    }
 


 @Override
public boolean ingresarCat(DtCategoria datos){
      if (this.categorias.get(datos.getNombre())!=null){
            return false;
        }else{
            Categoria c=new Categoria(datos.getNombre(), datos.getPadre());
            boolean res =this.dbCategoria.agregarPersona(c);
            if (res){
                //Colección genérica común
                //this.personas.add(p);
                this.categorias.put(datos.getNombre(), c);
            }
            return res;
        }
  
}

@Override
public void categoriasPrueba(){
    String [] categoria = {"Teatro", "Teatro Dramático", "Teatro Musical", "Comedia", "Stand-up", "Literatura", "Música", "Festival", "Concierto", "Cine", "Cine al Aire Libre", "Cine a Pedal", "Danza", "Ballet", "Flamenco", "Carnaval","Murga","Humoristas","Parodistas","Lubolos", "Revista"};
    String [] padre = {"Categoria", "Teatro", "Teatro", "Teatro", "Comedia", "Categoria", "Categoria", "Música", "Música", "Categoria", "Cine", "Cine", "Categoria", "Danza", "Danza", "Categoria", "Carnaval", "Carnaval", "Carnaval","Carnaval","Carnaval"};
    for(int i =0; i<21; i++){
        DtCategoria a = new DtCategoria(categoria[i], padre[i]);
        this.ingresarCat(a);
    }
//    DtCategoria a = new DtCategoria("Teatro", "Categoria");
//    this.ingresarCat(a);
//    DtCategoria b = new DtCategoria("Teatro Dramático","Teatro");
}

}