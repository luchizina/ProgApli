/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
 
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author apias
 */
public class ConexionDB {
    private final String host="localhost";
    private final String port="3306";
    private final String db="culturarte";
    private final String user="root";
    private final String pass="KKGkvdxq0o";
    
    //Para hacer ConexionDB singleton descomentar
    //private static Connection conexion=null;
    private Connection conexion=null;
    //Para hacer ConexionDB singleton descomentar
    //private ConexionDB(){};
    public ConexionDB(){};
    //Para hacer ConexionDB singleton descomentar
    //public static Connection getConexion() {
    public Connection getConexion() {
        if (conexion == null) {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    public void cerrar(){
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
}