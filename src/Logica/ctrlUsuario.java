/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Luchi
 */
public class ctrlUsuario implements IUsuario {
    
     private static ctrlUsuario instancia;
     private Map<String, Usuario> usuarios;
     private Map<String, Proponente> Proponentes;
     private Map<String, Colaborador> Colaboradores;
     private DBusuario usu=null;
   
public static ctrlUsuario getInstance(){
        if (instancia == null){
            instancia = new ctrlUsuario();
        }
        return instancia;
    }


private ctrlUsuario(){
    this.usuarios=new HashMap<String, Usuario>();
    this.Proponentes=new HashMap<String, Proponente>();
    this.Colaboradores=new HashMap<String, Colaborador>();
    this.usu=new DBusuario();
}

    @Override
    public boolean altaColaborador(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String tipo) {
        if(this.existe(Nick, Correo)==false){
            return false;
        }
//        } else {
            if(Imagen.equals("")==false){
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String destino = "Imagenes/Colaborador/" + Nick + "." + termina;
                try {
                    if(this.copia(Imagen, destino)==true){
                        Imagen=destino;
                    } else {
                        Imagen = null;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
 
            Colaborador c = new Colaborador(Nick, Nombre, Apellido, Correo, fecha, Imagen, tipo);
            boolean res = this.usu.agregarColaborador(c);
            if(res){
                this.usuarios.put(Nick, c);
            }
            return res;
        }
    

    @Override
    public boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo) {
        if(this.existe(Nick, Correo)==false){
            return false;
        } else {
         if(Imagen.equals("")==false){
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String destino = "Imagenes/Proponente/" + Nick + "." + termina;
                try {
                    if(this.copia(Imagen, destino)==true){
                        Imagen=destino;
                    } else {
                        Imagen = null;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } 
        Proponente p = new Proponente(Nick, Nombre, Apellido, Correo, fecha, Imagen, direccion, biografia, web, tipo);
        boolean res = this.usu.agregarProponente(p);
        if(res){
            this.usuarios.put(Nick, p);
        }
            return res;
        }
    }

    @Override
    public boolean existe(String nick, String correo){
        for(Usuario usu : this.usuarios.values()){
            if(usu.getNick().equals(nick)){
                return false;
            }
            if(usu.getCorreo().equals(correo)){
                return false;
            }
        }
        return true;
    }
    
    public boolean copia(String origen, String destino) throws IOException{
        try{
            File aor = new File(origen);
            File ade = new File(destino);
            ade.getParentFile().mkdirs();
            ade.createNewFile();
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch(IOException ex){
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


     @Override
    public void cargarProponentes(){
    this.Proponentes=this.usu.cargarProponentes();
    }
    
     @Override
     public void cargarColaboradores(){
         this.Colaboradores=this.usu.cargarColaboradores();
     }
    
    
     @Override
    public List<DtProponente> listarUsuario()
      {
           List<DtProponente> retorna=new ArrayList<>();
   // DtCategoria nuevo=null;
          Set se = Proponentes.entrySet();
        Iterator iterator = se.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            Proponente aux=(Proponente) mentry.getValue();    
            retorna.add(aux.obtenerInfo());
            }       
        return retorna;
      }
    
    @Override
    public boolean escorreo(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean existeNick(String nick){
        for(Colaborador usu : this.Colaboradores.values()){
            if(usu.getNick().equals(nick)){
                return false;
            }
        }
        
        for(Proponente p : this.Proponentes.values()){
            if(p.getNick().equals(nick)){
                return false;
            }
        }
        return true;
    }
    
    
     @Override
    public boolean existeCorreo(String correo){
        for(Colaborador usu : this.Colaboradores.values()){
            if(usu.getCorreo().equals(correo)){
                return false;
            }
        }
        
        for(Proponente p : this.Proponentes.values()){
            if(p.getCorreo().equals(correo)){
                return false;
            }
        }
        return true;
    }

//    long ini = System.currentTimeMillis();
//    InputStream fuente = null;
}
