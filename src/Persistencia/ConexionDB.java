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
import config.Utils;
import java.util.Properties;
 
/**
 *
 * @author apias
 */
public class ConexionDB {


    //Para hacer ConexionDB singleton descomentar
    //Para hacer ConexionDB singleton descomentar
    //Para hacer ConexionDB singleton descomentar
    //private static Connection conexion=null;
    private Connection conexion=null;
    //Para hacer ConexionDB singleton descomentar
    //private ConexionDB(){};
    public ConexionDB(){};
    //Para hacer ConexionDB singleton descomentar
    //public static Connection getConexion() {
    public Connection getConexion() {
        Properties p= Utils.getPropiedades();
        String host= p.getProperty("hostDB");
        String port = p.getProperty("portDB");
        String db= p.getProperty("db");
        String user= p.getProperty("userDB");
        String pass= p.getProperty("passDBlucia");
        
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
