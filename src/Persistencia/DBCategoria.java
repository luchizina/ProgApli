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
    
    
     public Map<Integer, Categoria> cargarCategorias(){
        try {
            Map<Integer, Categoria> lista=new HashMap<Integer, Categoria>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM categorias");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                int codigo=rs.getInt("codigo");
                //Categoria p=new Categoria(codigo,rs.getString("nombre"),rs.getInt("edad"));
              //  lista.put(codigo, p);
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
