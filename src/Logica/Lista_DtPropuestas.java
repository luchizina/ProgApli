/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import Logica.DtPropuesta;
import java.util.List;

/**
 *
 * @author matheo
 */
public class Lista_DtPropuestas {
    
    private List<DtPropuesta> propuestas;
    
    public Lista_DtPropuestas(List<DtPropuesta> propuestas){
        this.propuestas=propuestas;
    }  
    
    public List<DtPropuesta> GetPropuestas(){
        return this.propuestas;
    };
}
