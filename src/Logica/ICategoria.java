/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import java.util.Map;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Luchi
 */
public interface ICategoria {
    public abstract List<DtCategoria> listarCategorias();
public abstract boolean ingresarCat(DtCategoria datos);
public abstract boolean existecat(String nom);
public abstract int traerProfu(String nombre);
public abstract void cargarCategorias();
public abstract void cargaCatPrueb();
public abstract void cargar();
public abstract DefaultTreeModel construirArbolito(List<DtCategoria> catego, DefaultMutableTreeNode raiz);
public abstract DefaultTreeModel imprimirArbol(DtCategoria catego, DefaultMutableTreeNode raiz);
public abstract DataListCategoria ListCategoria_A_DT(List<DtCategoria> dts);
}
