/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Map;

/**
 *
 * @author Luchi
 */
public interface ICategoria {
    public abstract Map<String,Categoria> listarCategorias();
public abstract void ingresarCat(DtCategoria datos);
}
