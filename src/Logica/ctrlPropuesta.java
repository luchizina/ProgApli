/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Luchi
 */
public class ctrlPropuesta implements IPropuesta {
         private static ctrlPropuesta instancia;
     
   
public static ctrlPropuesta getInstance(){
        if (instancia == null){
            instancia = new ctrlPropuesta();
        }
        return instancia;
}



}
