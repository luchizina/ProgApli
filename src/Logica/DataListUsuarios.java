/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Aeliner
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataListUsuarios {
    private List<DtUsuario> listita;
    
    
    DataListUsuarios(List<DtUsuario> listita)
    {
        this.listita = listita;
    }
    
   public List<DtUsuario> getListita()
    {
        return this.listita;
    }
}
