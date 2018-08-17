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
import javax.swing.JOptionPane;

/**
 *
 * @author Luchi
 */
public class ctrlUsuario implements IUsuario {
    
     private static ctrlUsuario instancia;
     private Map<String, Usuario> usuarios;
     private Map<String, Proponente> Proponentes;
     private Map<String, Colaborador> colaboradores;
     private DBusuario usu=null;
   
public static ctrlUsuario getInstance(){
        if (instancia == null){
            instancia = new ctrlUsuario();
        }
        return instancia;
    }


private ctrlUsuario(){
    this.usuarios=new HashMap<String, Usuario>();

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


    
    public void cargarProponentes(){
    this.Proponentes=this.usu.cargarProponentes();
    }
    
    public void cargarColaboradores()
    {
        this.colaboradores = this.usu.cargarColaboradores();
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
    
    public List<DtColaborador> listarColaboradores()
    {
        List<DtColaborador> listita = new ArrayList<>();
        Set se = colaboradores.entrySet();
        Iterator iterator = se.iterator();
        while(iterator.hasNext())
        {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Colaborador aux = (Colaborador) mentry.getValue();
            listita.add(aux.obtenerInfo());
        }
        return listita;
    }

//    long ini = System.currentTimeMillis();
//    InputStream fuente = null;
}
