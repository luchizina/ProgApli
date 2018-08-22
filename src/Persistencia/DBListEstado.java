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
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author apias
 */
public class DBListEstado {

    //Si ConexionDB fuera singleton
    //private Connection conexion = ConexionDB.getConexion();
    private final Connection conexion = new ConexionDB().getConexion();

    public boolean agregarEstado(ListEstado p, String t) throws SQLException, ParseException {

        PreparedStatement statement = conexion.prepareStatement("INSERT INTO listestado "
                + "(Fecha,Hora,TituloP,Estado) values(?,?,?,?)");
//                     SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
//                    java.sql.Date sqlDate = new java.sql.Date(p.getFecha().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String fechaSt = sdf.format(p.getFecha());
        String[] lul = fechaSt.split(" ");
        String parte1 = lul[0];
        String parte2 = lul[1];
        statement.setString(1, parte1);
        statement.setString(2, parte2);
        statement.setString(3, t);
        statement.setString(4, p.getEst().toString());
        statement.executeUpdate();
        statement.close();
        return true;
    }

    public void agregarListPrueb() {
        String[] fechas = {"2018-05-15 15:30", "2018-05-17 08:30", "2018-05-20 14:30", "2018-05-30 18:30", "2018-06-15 14:50", "2018-06-18 4:28", "2018-06-20 4:56", "2018-06-30 14:25", "2018-07-15 9:45", "2017-07-26 15:30", "2017-07-31 08:30", "2018-08-01 07:40", "2018-07-30 15:40", "2018-08-01 14:30", "2018-08-05 16:50", "2018-08-04 12:20", "2018-08-10 10:25", "2018-08-13 04:58", "2018-08-06 02:00", "2018-08-12 04:50", "2018-08-15 04:48", "2018-08-18 02:40", "2018-08-20 21:58", "2018-08-23 2:12"};
        String[] estado = {"Ingresada", "Publicada", "En Financiación", "Financiada", "Cancelada", "Ingresada", "Publicada", "En Financiación", "Financiada", "Ingresada", "Publicada", "En Financiación", "Ingresada", "Publicada", "En Financiacion", "Ingresada", "Publicada", "En Financiacion", "Ingresada", "Publicada", "En Financiacion", "Ingresada", "Publicada", "Ingresada"};
        String[] referencias = {"Cine en el Botánico", "Cine en el Botánico", "Cine en el Botánico", "Cine en el Botánico", "Cine en el Botánico", "Religiosamente", "Religiosamente", "Religiosamente", "Religiosamente", "El Pimiento Indomable", "El Pimiento Indomable", "El Pimiento Indomable", "Pilsen Rock", "Pilsen Rock", "Pilsen Rock", "Romeo y Julieta", "Romeo y Julieta", "Romeo y Julieta", "Un día de Julio", "Un día de Julio", "Un día de Julio", "El Lazarillo de Tormes", "El Lazarillo de Tormes", "Durazno Rock"};
        for (int i = 0; i < 24; i++) {
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO listestado "
                        + "(Fecha,Hora,TituloP,Estado) values(?,?,?,?)");
                String[] lul = fechas[i].split(" ");
                String parte1 = lul[0];
                String parte2 = lul[1];
                statement.setString(1, parte1);
                statement.setString(2, parte2);
                statement.setString(3, referencias[i]);
                statement.setString(4, estado[i]);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBListEstado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public List<ListEstado> cargarListEst(){
        List<ListEstado> listita = new ArrayList<ListEstado>();
        try {
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM listestado");
            ResultSet rs = st.executeQuery();
             while (rs.next()) {
                Date fecha = rs.getDate("Fecha");
                Time hora = rs.getTime("Hora");
//                String titulo = rs.getString("TituloP"); // agrege lugar y falta estado
                String estado = rs.getString("Estado");
                SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
                ListEstado estadito = new ListEstado(fecha, hora, estado);
                listita.add(estadito);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBListEstado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listita;
    }
}
