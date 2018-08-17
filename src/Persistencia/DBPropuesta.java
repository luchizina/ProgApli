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
    public boolean agregarPropuesta(Propuesta p) throws SQLException{
   
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO propuesta "
                    + "(Titulo, Descripcion,Fecha, Precio,montoActual,fechaPub,ImagenUrl,TipoRetorno,MontoTotal,categoria,nickprop, lugar) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, p.getTitulo());
            statement.setString(2, p.getDesc());
            Date fechaC= p.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt=sdf.format(fechaC);
            statement.setString(3, fechaSt);
         //   statement.setInt(3, p.get);
       //    statement.setString(5, "1999-12-12");
            String fechapub = sdf.format(p.getFechaPub());
            statement.setInt(4, p.getPrecioE());
            statement.setInt(5, 0);
            statement.setString(6, fechapub);
            statement.setString(7, p.getImg()); 
             statement.setString(8, String.valueOf(p.getTipoRetorno()));
            statement.setInt(9, p.getMontoTotal());
            statement.setString(10, p.getCate());
            statement.setString(11, p.getProp());
            statement.setString(12, p.getLugar());
            statement.executeUpdate();
            statement.close();
            return true;
            
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
                Propuesta p=new Propuesta(titulo, descripcion, fechita, precio, fechaPub, montoTotal, categoria);
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
