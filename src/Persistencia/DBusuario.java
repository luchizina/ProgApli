/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Presentacion.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nuevo
 */
public class DBusuario {
    private Connection conexion = new ConexionDB().getConexion();
    
    public boolean agregarColaborador(Usuario u){
         try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaborador "
                    + "(NickC, CorreoC, NombreC, ApellidoC, FechaNacC, ImagenUrlC) values(?,?,?,?,?,?)");
            statement.setString(1, u.getNick());
            statement.setString(2, u.getCorreo());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            Date fechaC= u.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt=sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, u.getImg());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
     public boolean agregarProponente(Usuario u){
         try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO proponente "
                    + "(NickP, CorreoP, NombreP, ApellidoP, FechaNac, ImagenUrlP, Direccion, Biografia, linkweb) values(?,?,?,?,?,?,?,?,?)");
            statement.setString(1, u.getNick());
            statement.setString(2, u.getCorreo());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            Date fechaC= u.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt=sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, u.getImg());
            statement.setString(7, u.getDireccion());
            statement.setString(8, u.getBiografia());
            statement.setString(9, u.getLink());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } 
    }
}
