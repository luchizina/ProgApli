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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
         else {
            if(Imagen.equals("")==false){
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String destino = "Imagenes/Colaborador/" + Nick + "." + termina;
                    if(this.copia(Imagen, destino)==true){
                        Imagen=destino;
                    } else {
                        Imagen = null;
                    }
            } 
 
            Colaborador c = new Colaborador(Nick, Nombre, Apellido, Correo, fecha, Imagen, tipo);
            boolean res = this.usu.agregarColaborador(c);
            if(res){
                this.usuarios.put(Nick, c);
            }
            return res;
        }
    }


    @Override
    public boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo) {
        if(this.existe(Nick, Correo)==false){
            return false;
        } 
        else {
         if(Imagen.equals("")==false){
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String destino = "Imagenes/Proponente/" + Nick + "." + termina;
                    if(this.copia(Imagen, destino)==true){
                        Imagen=destino;
                    } else {
                        Imagen = null;
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
    
     @Override
    public boolean copia(String origen, String destino) {
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
    this.usuarios=this.usu.cargarProponentes();
    }
    
    @Override
    public void limpiarUsuarios(){
         try {
             this.usu.limpiarBase();
         } catch (SQLException ex) {
             Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    
     @Override
    public void cargarPropPrueba(){
        this.usu.cargarProponentesPrueba();
    }
    
     @Override
     public void cargarColaboradores(){
         this.usuarios=this.usu.cargarColaboradores();
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

        for(Colaborador u : this.Colaboradores.values()){
            if(u.getNick().equals(nick)){
                return false;
            }
        }
        
        for(Proponente u : this.Proponentes.values()){
            if(u.getNick().equals(nick)){
                return false;
            }
        }
        
        for(Usuario u : this.usuarios.values()){
            if(u.getNick().equals(nick)){
                return false;
            }
        }
        return true;
    }
    
    
    
     @Override
    public boolean existeCorreo(String correo){
        for(Proponente u : this.Proponentes.values()){
            if(u.getCorreo().equals(correo)){
                return false;
            }
        }
        
        for(Colaborador u : this.Colaboradores.values()){
            if(u.getCorreo().equals(correo)){
                return false;
            }
        }
        
         for(Usuario u : this.usuarios.values()){
            if(u.getCorreo().equals(correo)){
                return false;
            }
        }
        return true;
    }
    
    @Override
    public void cargarUsuarios(){
         try {
             //Proponentes
             SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
             Date hrubino = sd.parse("1962-02-25");
             this.altaProponente("hrubino", "horacio.rubino@guambia.com.uy", "Horacio", "Rubino", hrubino, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\hr.JPG", "18 de Julio 1234", " ", "https://twitter.com/horaciorubino", "Proponente");
             Date mb = sd.parse("1972-06-14");
             this.altaProponente("mbusca", "Martin.bus@agadu.org.uy", "Martín", "Buscaglia", mb, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\mb.jpg", "Colonia 4321", " ", "http://www.martinbuscaglia.com/", "Proponente");
             Date hg = sd.parse("1954-01-07");
             this.altaProponente("hectorg", "hector.gui@elgalpon.org.uy", "Héctor", "Guido", hg, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\hg.jpg", "Gral. Flores 5645", "", "", "Proponente");
             Date tc = sd.parse("1971-07-24");
             this.altaProponente("tabarec", "tabare.car@agadu.org.uy", "Tabaré", "Cardozo", tc, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\tc.jpg", "Santiago Rivas 1212", "", "https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs", "Proponente");
             Date cs = sd.parse("1947-01-01");
             this.altaProponente("cachilas", "Cachila.sil@c1080.org.uy", "Waldemar “Cachila” ", "Silva", cs, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\cs.jpg", "Br. Artigas 4567", "", "https://www.facebook.com/C1080?ref=br_rs", "Proponente");
             Date jb = sd.parse("1967-03-16");
             this.altaProponente("juliob", "juliobocca@sodre.com.uy", "Julio", "Bocca", jb, "", "Benito Blanco 4321", "", "", "Proponente");
             Date dp = sd.parse("1975-01-01");
             this.altaProponente("diegop", "diego@efectocine.com", "Diego", "Parodi", dp, "", "Emilio Frugoni 1138 Ap. 02", "", "http://www.efectocine.com/", "Proponente");
             Date kh = sd.parse("1840-04-25");
             this.altaProponente("kairoh", "kairoher@pilsenrock.com.uy", "Kairo", "Herrera", kh, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\kh.jpg", "Paraguay 1423", "", "", "Proponente");
             Date lb = sd.parse("1980-10-31");
             this.altaProponente("durazno", "comunicacion@durazno.gub.uy", "Itendencia", "Durazno", lb, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\lb.png", "8 de Octubre 1429", "", "http://durazno.gub.uy/portal/index.php", "Proponente");
            //Colaboradores
            
         } catch (ParseException ex) {
             Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

//    long ini = System.currentTimeMillis();
//    InputStream fuente = null;
}
