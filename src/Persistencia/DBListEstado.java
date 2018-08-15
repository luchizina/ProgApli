/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.ListEstado;
import Logica.Propuesta;
import Persistencia.ConexionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author apias
 */
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBListEstado {    
    java.util.Date fec;
     java.sql.Date sqlDate;
    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private Connection conexion = new ConexionDB().getConexion();
    public boolean agregarEstado(ListEstado p, String t){
        try {
            
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO ListEstado "
                    + "(Fecha,Hora,TituloP,Estado) values(?,?,?,?)");
            statement.setDate(1, (java.sql.Date) p.getFecha());
            statement.setDate(2, (java.sql.Date) p.getHora());
            statement.setString(3, t);
            statement.setString(4,  p.getEst().toString());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }        
    }
    
//    public boolean borrarPersona(Persona p){
//        try {
//            PreparedStatement statement = conexion.prepareStatement("DELETE FROM personas WHERE codigo=?");
//            statement.setInt(1, p.getCodigo());
//            statement.executeUpdate();
//            statement.close();
//            return true;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return false;
//        }        
//    }    
//    
    public Map<String, Propuesta> cargarPersonas(){
        try {
            Map<String, Propuesta> lista = new HashMap<String, Propuesta>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM propuesta");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                String titulo = rs.getString("titulo");
                Propuesta p=new Propuesta();
                lista.put(titulo, p);
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