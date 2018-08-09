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
public class ctrlUsuario implements IUsuario {
    
     private static ctrlUsuario instancia;
     
   
public static ctrlUsuario getInstance(){
        if (instancia == null){
            instancia = new ctrlUsuario();
        }
        return instancia;
    }    
}