/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import Logica.ListEstado;
import Logica.Propuesta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import Logica.Estado;
import Logica.Testado;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
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
    
    
    
    public void SetearEstadoPropuesta(Propuesta x){
    try {
            List<ListEstado> Lestados = new ArrayList<ListEstado>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM listestado WHERE TituloP=?"); 
            st.setString(1, x.getTitulo());
            ResultSet rs=st.executeQuery();
            while (rs.next()){
                // Setear lista 
                java.sql.Time xhora = rs.getTime("Hora");
                java.util.Date xfecha = rs.getDate("Fecha");
                String e = rs.getString("Estado");
                // si xfecha paso antes  que el estaco actual lo agrega 
               
                Testado d;
                if (e.equals("ingresada")){
                d = Testado.publicada;
                }
                else if (e.equals("publicada")){
                d = Testado.publicada;
                }
                 else if (e.equals("en_financiacion")){
                d = Testado.en_financiacion;
                }
                 else if (e.equals("financiada")){
                d = Testado.financiada;
                }
                 else if (e.equals("no_financiada")){
                d = Testado.no_financiada;
                }
                 else{ // cancelada
                d = Testado.cancelada;
                }
                ListEstado ListaEstadopasado = new ListEstado(xfecha, xhora, d);
                Lestados.add(ListaEstadopasado);
                }
                x.setLE(Lestados);
                
                PreparedStatement stx = conexion.prepareStatement("SELECT * FROM listestado WHERE fecha=(SELECT MAX(fecha) FROM listestado WHERE TituloP =? ) AND TituloP =?"); 
                stx.setString(1, x.getTitulo());
                stx.setString(2, x.getTitulo());
                ResultSet rsx=stx.executeQuery();
                while (rsx.next()){
                String ex = rsx.getString("Estado");
                java.sql.Time Actualhora = rsx.getTime("Hora"); // falta comparar con la hora
                java.util.Date Actualfecha = rsx.getDate("Fecha");
                Testado dx;
                if (ex.equals("Ingresada")){
                dx = Testado.publicada;
                }
                else if (ex.equals("Publicada")){
                dx = Testado.publicada;
                }
                 else if (ex.equals("En_Financiacion")){
                dx = Testado.en_financiacion;
                }
                 else if (ex.equals("Financiada")){
                dx = Testado.financiada;
                }
                 else if (ex.equals("No_Financiada")){
                dx = Testado.no_financiada;
                }
                 else{ // cancelada
                dx = Testado.cancelada;
                }
                Estado es = new Estado(dx);
                x.setEstActual(es);
                
                }
            rsx.close();
            stx.close();    
            rs.close();
            st.close();
           
        } catch (SQLException ex) {
            ex.printStackTrace();
           
        }
    
    };
}
