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
public class DataList_Comentario {
     private List<DtComentarios> comentario;
    
    public DataList_Comentario(List<DtComentarios> comentarios){
        this.comentario=comentarios;
    }  
    
    public List<DtComentarios> GetComentarios(){
        return this.comentario;
    };
}
