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
public void cargarCategorias(){
    
    this.categorias=this.dbCategoria.cargarCategorias();
    
}

 @Override
public Map<String, Categoria> listarCategorias(){
    Map<String,Categoria> mapita= new HashMap<String,Categoria>();
  
    return mapita;
}

 @Override
public void ingresarCat(DtCategoria datos){
        if(this.categorias.get(datos.getNombre())==null){
        Categoria nueva= new Categoria(datos.getNombre(),datos.getPadre());
        categorias.put(datos.getNombre(), nueva);
    }
  
}

}