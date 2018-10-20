/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author matheo
 */
public class dataListCategoria {
 
     private List<DtCategoria> listita;
     
     dataListCategoria(List<DtCategoria> listita)
    {
        this.listita = listita;
    }
    
    public List<DtCategoria> GetPropuestas(){
        return this.listita;
    };
}
