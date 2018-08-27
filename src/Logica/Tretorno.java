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
public class Tretorno {
    private
            String porcentaje;
            String entrada;
            
public Tretorno(){
     this.entrada = "";
     this.porcentaje = "";
};            
 public Tretorno(String xentrada,String  xporcetanje){
     this.entrada = xentrada;
     this.porcentaje = xporcetanje;
};
 
 public String getAmbosRetornos(){
 
     return (this.entrada+" "+this.porcentaje);
 };
 
 public String getEntrada(){
     return this.entrada;
 };
 public String getPorcentaje(){
     return this.porcentaje;
 };
 
  public void gsetPorcentaje( String x){
     this.porcentaje = x;
 };
  
   public void gsetEntraada( String x){
     this.entrada = x;
 };
}
