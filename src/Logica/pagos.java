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
public class pagos {
    String numero;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Colaboracion getColab() {
        return colab;
    }

    public void setColab(Colaboracion colab) {
        this.colab = colab;
    }
    Colaboracion colab;
    public pagos(String num, Colaboracion col){
        this.numero=num;
        this.colab=col;
    }
}
