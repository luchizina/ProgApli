/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
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
import Logica.DtFecha;

/**
 *
 * @author apias
 */
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBPropuesta {    
    java.util.Date fec;
     java.sql.Date sqlDate;
    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private Connection conexion = new ConexionDB().getConexion();
    public boolean agregarPropuesta(Propuesta p){
        try {
            
            SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
             try {
        fec = da.parse(p.getFecha());
         sqlDate = new java.sql.Date(fec.getTime());
        System.out.println(sqlDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO propuesta "
                    + "(Titulo, Descripcion,Fecha, Precio,montoActual,MontoTotal,categoria,nickprop) values(?,?,?,?,?,?,?,?)");
            statement.setString(1, p.getTitulo());
            statement.setString(2, p.getDesc());
            statement.setDate(3, sqlDate);
         //   statement.setInt(3, p.get);
       //    statement.setString(5, "1999-12-12");
            statement.setInt(4, 23);
            statement.setInt(5, 456);
            statement.setInt(6, 569);
            statement.setString(7, "kpop");
            statement.setString(8, "lola");
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
    public Map<String, Propuesta> cargarPropuestas(){
        try {
            Map<String, Propuesta> lista = new HashMap<String, Propuesta>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM propuesta");          
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                Date fechita = rs.getDate("Fecha");
                int precio = rs.getInt("precio");
                int montoActual = rs.getInt("montoactual");
                Date fechaPub = rs.getDate("fechapub");
                String url = rs.getString("imagenurl");
                String tipoRetorno = rs.getString("tiporetorno");
                int montoTotal = rs.getInt("montototal");
                String categoria = rs.getString("Categoria");
                String nickProp = rs.getString("nickprop");
                SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat da2 = new SimpleDateFormat("yyyy-MM-dd");
                Propuesta p=new Propuesta(titulo, descripcion, da.format(fechita), precio, da2.format(fechaPub), montoTotal, categoria);
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