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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
        //Collections.sort(retorna, new Sortbyroll());
        Collections.sort(retorna, (c, d) -> {
        return c.getNombre().compareTo(d.getNombre()); 
        });
        return retorna;
    }
    
    class Sortbyroll implements Comparator<DtCategoria>{
        
        @Override
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
            Categoria c = new Categoria(datos.getNombre(), datos.getPadre(), datos.getProfundidad());
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
    public boolean existecat(String nom){
        for(Categoria cat: this.categorias.values()){
            if(cat.getNombre().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int traerProfu(String nombre){
      Categoria aux= this.categorias.get(nombre);
      return aux.getProfundidad();
    }
    
    public DefaultTreeModel imprimirArbol(DtCategoria catego, DefaultMutableTreeNode raiz) {
        if (catego.getPadre().compareTo(raiz.toString()) == 0)
        {
            DefaultMutableTreeNode nodito = new DefaultMutableTreeNode(catego.getNombre());
            raiz.add(nodito);
        } 
        
        else   
        {
            for (int i = 0; i < raiz.getChildCount(); i++)
            {
                imprimirArbol(catego, (DefaultMutableTreeNode) raiz.getChildAt(i));
            }
        }
        DefaultTreeModel modelito = new DefaultTreeModel(raiz);
        return modelito;
    }
    
    public DefaultTreeModel construirArbolito(List<DtCategoria> catego, DefaultMutableTreeNode raiz) {
        Collections.sort(catego, (DtCategoria dt1, DtCategoria dt2) -> dt1.getProfundidad() - dt2.getProfundidad());
        DefaultTreeModel p = null;
        for (int i = 0; i < catego.size(); i++) {
            p = (this.imprimirArbol(catego.get(i), raiz));
        }
        return p;
    }


}
