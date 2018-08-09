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
public class ctrlCategoria implements ICategoria {
         private static ctrlCategoria instancia;
     
   
public static ctrlCategoria getInstance(){
        if (instancia == null){
            instancia = new ctrlCategoria();
        }
        return instancia;
}


}