/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author nambr
 */
import Persistencia.ConexionDB;
import Logica.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DBCategoria {
    
    
    private Connection conexion = new ConexionDB().getConexion();
    
    
     public Map<String, Categoria> cargarCategorias(){
        try {
            
            Map<String, Categoria> lista=new HashMap<String, Categoria>();
            Map<String,Categoria> hijos=new HashMap<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categoria");  
            PreparedStatement st2 = conexion.prepareStatement("SELECT * FROM categoria where NombreP !='No'");    
            ResultSet rs=st.executeQuery();
            ResultSet rs2= st2.executeQuery();
            while (rs.next()){
                
                //nuevo
               while(rs2.next()){
                   if(rs.getString("NombreH").compareTo(rs2.getString("NombreP"))==0 ) {
                 Categoria hijo = new Categoria(rs2.getString("NombreH"), rs2.getString("NombreP"));
                 hijos.put(rs2.getString("NombreH"), hijo);
                   }
               }
               rs2.beforeFirst();
//               //nuevo
             
                Categoria p=new Categoria(rs.getString("NombreH"),rs.getString("NombreP"), hijos);
             lista.put(rs.getString("NombreH"), p);
            }
        rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }        
    }
       public boolean agregarPersona(Categoria c){
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO categoria "
                    + "(NombreH, NombreP) values(?,?)");
            statement.setString(1, c.getNombre());
            statement.setString(2, c.getPadre());
                  statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
    }
     
     
     
     

     
     
}


