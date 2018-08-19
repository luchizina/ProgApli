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
import Logica.Colaboracion;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Logica.DtFecha;
import Logica.Colaborador;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.IPropuesta;

/**
 *
 * @author apias
 */
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBPropuesta {    
    Fabrica fab = Fabrica.getInstance();

    java.util.Date fec;
     java.sql.Date sqlDate;
    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private Connection conexion = new ConexionDB().getConexion();
    public boolean agregarPropuesta(Propuesta p) throws SQLException, ParseException{
   
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO propuesta "
                    + "(Titulo, Descripcion,Fecha, Precio,montoActual,fechaPub,imagenUrl,tipoRetorno,MontoTotal,categoria,nickprop,lugar) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, p.getTitulo());
            statement.setString(2, p.getDesc());
            Date fechaC = p.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(fechaC);
            statement.setString(3, fecha);
         //   statement.setInt(3, p.get);
       //    statement.setString(5, "1999-12-12");
            statement.setInt(4, p.getPrecioE());
            statement.setInt(5, 0);
            Date fechaP = p.getFechaPub();
            String fec = sdf.format(fechaP);
            statement.setString(6, fec);
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
                Propuesta p=new Propuesta(titulo, descripcion, fechita, montoActual, fechaPub, url, tipoRetorno, montoTotal, categoria, nickProp, precio);
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

    public List<Colaboracion> cargarColaboraciones()
    {
        try{
                 IUsuario iUsu = fab.getICtrlUsuario();
                 IPropuesta iProp = fab.getICtrlPropuesta();
        List<Colaboracion> listita = new ArrayList<>();
        PreparedStatement st = conexion.prepareStatement("SELECT * FROM colaboracion");
        ResultSet rs = st.executeQuery();
        while(rs.next())
        {
            Date fechita = rs.getDate("Fecha");
            String retorno = rs.getString("Retorno");
            int monto = rs.getInt("Monto");
            String nick = rs.getString("NickCol");
            Colaborador co = iUsu.traerColaborador(nick);
            String titulo = rs.getString("TituloP");
            Propuesta pr = iProp.getPropPorNick(titulo);
            Colaboracion c = new Colaboracion(fechita,retorno ,monto ,co ,pr);
            listita.add(c);
            co.AddColab(c);
            pr.addColab(c);
        }
        rs.close();
        st.close();
        return listita;
    } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
    }
}
}
