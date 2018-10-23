/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Nazareno
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class dataListColaboradores {
 
     private List<DtColaborador> listita;
     
     dataListColaboradores(List<DtColaborador> listita)
    {
        this.listita = listita;
    }
    
    public List<DtColaborador> getListita(){
        return this.listita;
    };
}
