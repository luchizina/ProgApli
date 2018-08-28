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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Luchi
 */
public class ctrlCategoria implements ICategoria {

    private static ctrlCategoria instancia;
    private Map<String, Categoria> categorias;
    private DBCategoria dbCategoria = null;

    public static ctrlCategoria getInstance() {
        if (instancia == null) {
            instancia = new ctrlCategoria();
        }
        return instancia;
    }

    private ctrlCategoria() {
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.categorias = new HashMap<String, Categoria>();
        this.dbCategoria = new DBCategoria();
    }

    @Override
    public void cargarCategorias() {

        this.categorias = this.dbCategoria.cargarCategorias();

    }

    @Override
    public void cargaCatPrueb() {
        this.dbCategoria.cargarCatPrueba();
    }
    
    @Override
    public void cargar(){
        this.cargaCatPrueb();
        this.cargarCategorias();
    }

    @Override
    public List<DtCategoria> listarCategorias() {
        List<DtCategoria> retorna = new ArrayList<DtCategoria>();
        // DtCategoria nuevo=null;
        Set set = categorias.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Categoria aux = (Categoria) mentry.getValue();
            retorna.add(aux.obtenerInfo());
        }
        Collections.sort(retorna, new Sortbyroll());
        
        return retorna;
    }
    
    class Sortbyroll implements Comparator<DtCategoria>{
        
        public int compare(DtCategoria a, DtCategoria b ){
            if(a.getProfundidad() > b.getProfundidad()){
                return 1;
            }else{
                return -1;
            }
        }
    }

    @Override
    public boolean ingresarCat(DtCategoria datos) {
        if (this.categorias.get(datos.getNombre()) != null) {
            return false;
        } else {
            Categoria c = new Categoria(datos.getNombre(), datos.getPadre());
            boolean res = this.dbCategoria.agregarCategoria(c);
            if (res) {
                //Colección genérica común
                //this.personas.add(p);
                this.categorias.put(datos.getNombre(), c);
            }
            return res;
        }

    }
    
    @Override
    public int traerProfu(String nombre){
       Set se= this.categorias.entrySet();
       Iterator it= se.iterator();
        while(it.hasNext()){
              Map.Entry mentry = (Map.Entry) it.next();
            Categoria aux = (Categoria) mentry.getValue();
            if(aux.getNombre().equals(nombre)){
                return aux.getProfundidad();
            }
        }
        return 0;
        
    }

    @Override
    public void categoriasPrueba() {
        String[] categoria = {"Teatro", "Teatro Dramático", "Teatro Musical", "Comedia", "Stand-up", "Literatura", "Música", "Festival", "Concierto", "Cine", "Cine al Aire Libre", "Cine a Pedal", "Danza", "Ballet", "Flamenco", "Carnaval", "Murga", "Humoristas", "Parodistas", "Lubolos", "Revista"};
        String[] padre = {"Categoria", "Teatro", "Teatro", "Teatro", "Comedia", "Categoria", "Categoria", "Música", "Música", "Categoria", "Cine", "Cine", "Categoria", "Danza", "Danza", "Categoria", "Carnaval", "Carnaval", "Carnaval", "Carnaval", "Carnaval"};
        for (int i = 0; i < 21; i++) {
            DtCategoria a = new DtCategoria(categoria[i], padre[i]);
            this.ingresarCat(a);
        }
//    DtCategoria a = new DtCategoria("Teatro", "Categoria");
//    this.ingresarCat(a);
//    DtCategoria b = new DtCategoria("Teatro Dramático","Teatro");
    }

}
