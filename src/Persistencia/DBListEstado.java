/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.ListEstado;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author apias
 */
public class DBListEstado {    
   
    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private final Connection conexion = new ConexionDB().getConexion();
    
    public boolean agregarEstado(ListEstado p, String t)throws SQLException, ParseException{
        
    PreparedStatement statement = conexion.prepareStatement("INSERT INTO listestado "
                    + "(Fecha,Hora,TituloP,Estado) values(?,?,?,?)"); 
//                     SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
//                    java.sql.Date sqlDate = new java.sql.Date(p.getFecha().getTime());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String fechaSt=sdf.format(p.getFecha());
            String[] lul = fechaSt.split(" ");
            String parte1 = lul[0];
            String parte2 = lul[1];
                statement.setString(1,parte1);
                statement.setString(2,parte2);
                statement.setString(3, t);
                statement.setString(4,  p.getEst().toString());
                statement.executeUpdate();
                statement.close();
            return true;
        }        
}