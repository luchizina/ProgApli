/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.nio.file.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author matheo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DtPath {
    private Path url;
    
    DtPath(Path xurl){
        this.url = xurl;
    }
    
    Path getPath(){
        return this.url;
    }
    
}
