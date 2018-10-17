/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author Nuevo
 */
public class Transferencia extends pagos{
    String banco;
    
    public Transferencia(String nro, Colaboracion col, String banco){
        super(nro, col);
        this.banco=banco;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }
}
