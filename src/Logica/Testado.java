package Logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logica.*;

/**
 *
 * @author Luchi
 */
public class Testado {
    
    private
            String ingresada;
            String publicada;
            String en_financiacion;
            String financiada;
            String no_financiada;
            String cancelada;

    public Testado(String ingresada, String publicada, String en_financiacion, String financiada, String no_financiada, String cancelada) {
        this.ingresada = ingresada;
        this.publicada = publicada;
        this.en_financiacion = en_financiacion;
        this.financiada = financiada;
        this.no_financiada = no_financiada;
        this.cancelada = cancelada;
    }

    public String getIngresada() {
        return ingresada;
    }

    public void setIngresada(String ingresada) {
        this.ingresada = ingresada;
    }

    public String getPublicada() {
        return publicada;
    }

    public void setPublicada(String publicada) {
        this.publicada = publicada;
    }

    public String getEn_financiacion() {
        return en_financiacion;
    }

    public void setEn_financiacion(String en_financiacion) {
        this.en_financiacion = en_financiacion;
    }

    public String getFinanciada() {
        return financiada;
    }

    public void setFinanciada(String financiada) {
        this.financiada = financiada;
    }

    public String getNo_financiada() {
        return no_financiada;
    }

    public void setNo_financiada(String no_financiada) {
        this.no_financiada = no_financiada;
    }

    public String getCancelada() {
        return cancelada;
    }

    public void setCancelada(String cancelada) {
        this.cancelada = cancelada;
    }
            
            
    
}
