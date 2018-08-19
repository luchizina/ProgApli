/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Luchi
 */
public interface ICategoria {
    public abstract List<DtCategoria> listarCategorias();
public abstract boolean ingresarCat(DtCategoria datos);
public abstract void cargarCategorias();
public abstract void categoriasPrueba();
}
