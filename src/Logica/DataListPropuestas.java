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
public class DataListPropuestas {
    private List<DtPropuesta> listita;
    
    
    DataListPropuestas(List<DtPropuesta> listita)
    {
        this.listita = listita;
    }
    
    public List<DtPropuesta> getListita()
    {
        return this.listita;
    }
}
