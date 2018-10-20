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
 * @author Aeliner
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataListProponentes {
     private List<DtProponente> listita;
    
    
    DataListProponentes(List<DtProponente> listita)
    {
        this.listita = listita;
    }
    
    public List<DtProponente> getListita()
    {
        return this.listita;
    }
}
