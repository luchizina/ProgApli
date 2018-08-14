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
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categoria");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
               
                Categoria p=new Categoria(rs.getString("NombreH"),rs.getString("NombreP"));
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
}
