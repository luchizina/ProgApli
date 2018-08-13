/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.DBusuario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    public boolean altaColaborador(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen) {
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
 
            Usuario c = new Usuario(Nick, Nombre, Apellido, Correo, fecha, Imagen);
            boolean res = this.usu.agregarColaborador(c);
            if(res){
                this.usuarios.put(Nick, c);
            }
            return res;
        }
    

    @Override
    public boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web) {
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
        Usuario p = new Usuario(Nick, Nombre, Apellido, Correo, fecha, Imagen, direccion, biografia, web);
        boolean res = this.usu.agregarProponente(p);
        if(res){
            this.usuarios.put(Nick, p);
        }
            return res;
        }
    }

    @Override
    public void cancelar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
//    long ini = System.currentTimeMillis();
//    InputStream fuente = null;
}