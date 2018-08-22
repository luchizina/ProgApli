/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Presentacion.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuevo
 */



/**
 *
 * @author Nuevo
 */
public class DBusuario {
    private Connection conexion = new ConexionDB().getConexion();
    
    public boolean agregarColaborador(Colaborador u){
          try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaborador "
                    + "(NickC, CorreoC, NombreC, ApellidoC, FechaNacC, ImagenUrlC) values(?,?,?,?,?,?)");
            statement.setString(1, u.getNick());
            statement.setString(2, u.getCorreo());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            Date fechaC= u.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt=sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, u.getImg());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
     public boolean agregarProponente(Proponente u){
         try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO proponente "
                    + "(NickP, CorreoP, NombreP, ApellidoP, FechaNac, ImagenUrlP, Direccion, Biografia, linkweb) values(?,?,?,?,?,?,?,?,?)");
            statement.setString(1, u.getNick());
            statement.setString(2, u.getCorreo());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            Date fechaC= u.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt=sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, u.getImg());
            statement.setString(7, u.getDireccion());
            statement.setString(8, u.getBiografia());
            statement.setString(9, u.getLinkWeb());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
     
     
     
     
     public boolean seguirCP(String nickcolab, String nickProp){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguircp "
                    + "(SeguidorC, SeguidoP) values(?,?)");
            statement.setString(1,nickcolab);
            statement.setString(2,nickProp);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
     
         public boolean dejarSeguirCP(String nickcolab, String nickProp){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM seguircp WHERE SeguidorC=? and SeguidoP=?");
            statement.setString(1,nickcolab);
            statement.setString(2,nickProp);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
         

     
     
     
     
       public boolean seguirPC(String nickProp, String nickColab){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguirpc "
                    + "(SeguidorP, SeguidoC) values(?,?)");
            statement.setString(1,nickProp);
            statement.setString(2,nickColab);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
       
       
       
          public boolean dejarSeguirPC(String nickProp, String nickColab){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM seguirpc WHERE SeguidorP=? and SeguidoC=?");
            statement.setString(1,nickProp);
            statement.setString(2,nickColab);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
       
       
                          
     
       public boolean seguirPP(String nickProp, String nickProp2){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO siguepp "
                    + "(Seguidor, Seguido) values(?,?)");
            statement.setString(1,nickProp);
            statement.setString(2,nickProp2);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
       
        public boolean dejarSeguirPP(String nickProp, String nickProp2){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM siguepp WHERE Seguidor=? and Seguido=?");
            statement.setString(1,nickProp);
            statement.setString(2,nickProp2);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
     
      public boolean seguirCC(String nickColab, String nickColab2){
         
           try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO siguecc "
                    + "(Seguidor, Seguido) values(?,?)");
            statement.setString(1,nickColab);
            statement.setString(2,nickColab2);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
      
      
            public boolean dejarSeguirCC(String nickColab, String nickColab2){
         
           try {
        PreparedStatement statement = conexion.prepareStatement("DELETE FROM siguecc WHERE Seguidor=? and Seguido=?");
            statement.setString(1,nickColab);
            statement.setString(2,nickColab2);
            
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 

     }
   
     
     
     
     
     
     
     
     
      public Map<String,Usuario> cargarProponentes(){
        try {
            Map<String, Usuario> lista = new HashMap<String, Usuario>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM proponente");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                String nick = rs.getString("NickP");
                Proponente p=new Proponente(nick, rs.getString("NombreP"), rs.getString("ApellidoP"), rs.getString("CorreoP"), rs.getDate("FechaNac"), rs.getString("ImagenUrlP"), rs.getString("Direccion"), rs.getString("Biografia"), rs.getString("linkWeb"), "Proponente");
                lista.put(nick, p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            return null;
        }        
    }
      
      
      
      
      
      public void limpiarBase() throws SQLException{
          try{
          PreparedStatement st = conexion.prepareStatement("Delete FROM colaborador"); 
          st.executeUpdate();
          st.close();
          PreparedStatement stt = conexion.prepareStatement("Delete FROM proponente"); 
          stt.executeUpdate();
          stt.close();
          PreparedStatement s = conexion.prepareStatement("Delete FROM categoria"); 
          s.executeUpdate();
          s.close();
          PreparedStatement a = conexion.prepareStatement("Delete FROM propuesta"); 
          a.executeUpdate();
          a.close();
          } catch (SQLException ex) {
            ex.printStackTrace();
        }
      }
      
      /*
      public void cargarProponentesPrueba(){
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Date hrubino = sd.parse("1962-02-25");
            Date mb = sd.parse("1972-06-14");
            Date hg = sd.parse("1954-01-07");
            Date tc = sd.parse("1971-07-24");
            Date cs = sd.parse("1947-01-01");
            Date jb = sd.parse("1967-03-16");
            Date dp = sd.parse("1975-01-01");
            Date kh = sd.parse("1840-04-25");
            Date lb = sd.parse("1980-10-31");
            String [] nick = {"hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob", "diegop", "kairoh", "durazno"};
            String [] correo = {"horacio.rubino@guambia.com.uy", "Martin.bus@agadu.org.uy", "hector.gui@elgalpon.org.uy", "tabare.car@agadu.org.uy", "Cachila.sil@c1080.org.uy", "juliobocca@sodre.com.uy", "diego@efectocine.com", "kairoher@pilsenrock.com.uy", "comunicacion@durazno.gub.uy"};
            String [] nombre = {"Horacio", "Martín", "Héctor", "Tabaré", "Waldemar “Cachila” ", "Julio", "Diego", "Kairo", "Itendencia"};
            String [] apellido = {"Rubino", "Buscaglia", "Guido", "Cardozo", "Silva", "Bocca", "Parodi", "Herrera", "Durazno"};
            Date [] fechasN = {hrubino, mb, hg, tc, cs, jb, dp, kh, lb};
            String [] urlImg = {"C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\hr.JPG", "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\mb.jpg", "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\hg.jpg", "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\tc.jpg", "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\cs.jpg", null, null, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\kh.jpg", "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\lb.png"};
            String [] direccion = {"18 de Julio 1234", "Colonia 4321", "Gral. Flores 5645", "Santiago Rivas 1212", "Br. Artigas 4567", "Benito Blanco 4321", "Emilio Frugoni 1138 Ap. 02", "Paraguay 1423", "8 de Octubre 1429"};
            String [] link = {"https://twitter.com/horaciorubino", "http://www.martinbuscaglia.com/", "", "https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs", "https://www.facebook.com/C1080?ref=br_rs", "", "http://www.efectocine.com/", "", "http://durazno.gub.uy/portal/index.php"};
            for(int i=0; i<9; i++){
                String Imagen = null;
                if(urlImg[i] != null){
                    String[] aux = urlImg[i].split("\\.");
                    String termina = aux[1];
                    String origen = urlImg[i];
                    String destino = "Imagenes/Proponente/" + nick[i] + "." + termina;
                    if(this.copia(origen, destino)==true){
                        Imagen=destino;
                    } else {
                        Imagen = null;
                    }
                }
                 try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO proponente "
                    + "(NickP, CorreoP, NombreP, ApellidoP, FechaNac, ImagenUrlP, Direccion, Biografia, linkweb) values(?,?,?,?,?,?,?,?,?)");
            statement.setString(1, nick[i]);
            statement.setString(2, correo[i]);
            statement.setString(3, nombre[i]);
            statement.setString(4, apellido[i]);
            Date fechaC= fechasN[i];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt=sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, Imagen);
            statement.setString(7, direccion[i]);
            statement.setString(8, "");
            statement.setString(9, link[i]);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
            }
        } catch (ParseException ex) {
            Logger.getLogger(DBusuario.class.getName()).log(Level.SEVERE, null, ex);
        }
          
      }
      */
      
        public Map<String, Colaborador> cargarColaboradores(){
        try {
            Map<String, Colaborador> lista = new HashMap<String, Colaborador>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM colaborador");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                String nick = rs.getString("NickC");
                Colaborador p=new Colaborador(nick, rs.getString("NombreC"), rs.getString("ApellidoC"), rs.getString("CorreoC"), rs.getDate("FechaNacC"), rs.getString("ImagenUrlC"), "Colaborador");
                lista.put(nick, p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }        
    }
        
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
}
