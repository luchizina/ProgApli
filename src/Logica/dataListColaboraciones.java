/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;

/**
 *
 * @author Aeliner
 */
public class dataListColaboraciones {
    private List<DtColaboracion> listita;
    
    
    dataListColaboraciones(List<DtColaboracion> listita)
    {
        this.listita = listita;
    }
    
    List<DtColaboracion> getListita()
    {
        return this.listita;
    }
}
