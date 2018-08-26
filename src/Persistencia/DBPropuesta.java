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
import Logica.Estado;
import Logica.Fabrica;
import Logica.IUsuario;
import Logica.IPropuesta;
import Logica.Testado;
import Logica.ctrlUsuario;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;

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

    public boolean agregarPropuesta(Propuesta p) throws SQLException, ParseException {

        PreparedStatement statement = conexion.prepareStatement("INSERT INTO propuesta "
                + "(Titulo, Descripcion, Fecha, Precio, montoActual, fechaPub, ImagenUrl, TipoRetorno, MontoTotal, categoria, nickprop, lugar) values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
        statement.setString(11, p.getPropo());
        statement.setString(12, p.getLugar());
        statement.executeUpdate();
        statement.close();
        return true;

    }

    public void cargarEstados() {
        String[] estados = {"Ingresada", "Publicada", "En Financiación", "Financiada", "Cancelada", "No Financiada"};
        for (int i = 0; i < 6; i++) {
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO estado " + "(Estado) values (?)");
                statement.setString(1, estados[i]);
                //Estado e = new Estado (Testado.valueOf(estados[i]));
            } catch (SQLException ex) {
                Logger.getLogger(DBPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void cargarPropuestasPrueba() {
        String[] fechas = {"2018-09-16", "2018-10-07", "2018-10-19", "2018-10-21", "2018-11-18", "2018-11-16", "2018-12-03", "2018-10-12"};
        String[] titulos = {"Cine en el Botánico", "Religiosamente", "El Pimiento Indomable", "Pilsen Rock", "Romeo y Julieta", "Un dia de Julio", "El Lazarillo de Tormes", "Durazno Rock"};
        String[] descripciones = {"El 16 de Diciembre a la hora 20 se proyectará la película \"Clever\", en el Jardín Botánico (Av. 19 de Abril 1181)\n"
            + "en el marco de las actividades realizadas por el ciclo Cultura al Aire Libre. El largometraje uruguayo de ficción\n"
            + "Clever es dirigido por Federico Borgia y Guillermo Madeiro. Es apto para mayores de 15 años.", "MOMOSAPIENS presenta \"Religiosamente\". Mediante dos parodias y un hilo conductor que aborda la temática\n"
            + "de la religión Momosapiens, mediante el humor y la reflexión, hilvana una historia que muestra al hombre\n"
            + "inmerso en el tema religioso. El libreto está escrito utilizando diferentes lenguajes de humor, dando una\n"
            + "visión satírica y reflexiva desde distintos puntos de vista, logrando mediante situaciones paródicas armar una\n"
            + "propuesta plena de arte carnavalero.", "El Pimiento Indomable, formación compuesta por Kiko Veneno y el uruguayo Martín Buscaglia, presentará\n"
            + "este 19 de Octubre, su primer trabajo. Bajo un título homónimo al del grupo, es un disco que según los\n"
            + "propios protagonistas “no se parece al de ninguno de los dos por separado. Entre los títulos que se podrán\n"
            + "escuchar se encuentran “Nadador salvador”, “América es más grande”, “Pescaito Enroscado” o “La reina del\n"
            + "placer”.", "La edición 2018 del Pilsen Rock se celebrará el 21 de Octubre en la Rural del Prado y contará con la\n"
            + "participación de más de 15 bandas nacionales. Quienes no puedan trasladarse al lugar, tendrán la posibilidad\n"
            + "de disfrutar los shows a través de Internet, así como entrevistas en vivo a los músicos una vez finalizados los\n"
            + "conciertos.", "Romeo y Julieta de Kenneth MacMillan, uno de los ballets favoritos del director artístico Julio Bocca, se\n"
            + "presentará nuevamente el 5 de Noviembre en el Auditorio Nacional del Sodre. Basada en la obra homónima\n"
            + "de William Shakespeare, Romeo y Julieta es considerada la coreografía maestra del MacMillan. La producción\n"
            + "de vestuario y escenografía se realizó en los Talleres del Auditorio Adela Reta, sobre los diseños originales", "La Catalina presenta el espectáculo \"Un Día de Julio\" en Landia. Un hombre misterioso y solitario vive\n"
            + "encerrado entre las cuatro paredes de su casa. Intenta, con sus teorías extravagantes, cambiar el mundo\n"
            + "exterior que le resulta inhabitable. Un día de Julio sucederá algo que cambiará su vida y la de su entorno para\n"
            + "siempre.", "Vuelve unas de las producciones de El Galpón más aclamadas de los últimos tiempos. Esta obra se ha\n"
            + "presentado en Miami, Nueva York, Washington, México, Guadalajara, Río de Janeiro y La Habana. En nuestro\n"
            + "país, El Lazarillo de Tormes fue nominado en los rubros mejor espectáculo y mejor dirección a los Premios\n"
            + "Florencio 1995, obteniendo su protagonista Héctor Guido el Florencio a Mejor actor de ese año. ", "Una vez mas EspectaculosBA dice presente en DURAZNO ROCK! Mas de 400 personas nos acompañaron el\n"
            + "año pasado y este año se repite!! Este año con la presencia destacada de La Beriso!!"};
        Integer[] precio = {200, 300, 400, 1000, 800, 650, 350, 0};
        String[] retornos = {"porcentaje", "entrada, porcentaje", "porcentaje", "entrada, porcentaje", "porcentaje", "entrada, porcentaje", "entrada", "porcentaje"};
        Integer[] montos = {150000, 300000, 400000, 900000, 750000, 300000, 175000, 100000};
        String[] categorias = {"Cine al Aire Libre", "Parodistas", "Concierto", "Festival", "Ballet", "Murga", "Teatro Dramático", "Festival"};
        String[] imagenes = {null, "Prueba\\Propuesta\\mom.jpg", "Prueba\\Propuesta\\pim.jpg", "Prueba\\Propuesta\\pil.jpg", "Prueba\\Propuesta\\ryj.jpg", "Prueba\\Propuesta\\udj.jpg", null, null};
        String[] proponente = {"diegop", "hrubino", "mbusca", "kairoh", "juliob", "tabarec", "hectorg", "durazno"};
        String[] lugares = {"Jardín Botánico", "Teatro de Verano", "Teatro Solís", "Rural de Prado", "Auditorio Nacional del Sodre", "Landia", "Teatro el Galpón", "Durazno"};
        String[] fechitap = {"2018-05-15", "2018-06-18", "2017-07-17", "2018-07-30", "2018-08-04", "2018-08-06", "2018-08-18", "2018-08-23"};
        for (int i = 0; i < 8; i++) {
            String Imagen = null;
            if (imagenes[i] != null) {
                String[] aux = imagenes[i].split("\\.");
                String termina = aux[1];
                String origen = imagenes[i];
                String destino = "Imagenes/Propuesta/" + titulos[i] + "." + termina;
                if (this.copia(origen, destino) == true) {
                    Imagen = destino;
                } else {
                    Imagen = null;
                }
            }
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO propuesta "
                        + "(Titulo, Descripcion, Fecha, Precio, montoActual, fechaPub, ImagenUrl, TipoRetorno, MontoTotal, categoria, nickprop, lugar) values(?,?,?,?,?,?,?,?,?,?,?,?)");
                statement.setString(1, titulos[i]);
                statement.setString(2, descripciones[i]);
                statement.setString(3, fechas[i]);
                statement.setInt(4, precio[i]);
                statement.setInt(5, 0);
                statement.setString(6, fechitap[i]);
                statement.setString(7, Imagen);
                statement.setString(8, retornos[i]);
                statement.setInt(9, montos[i]);
                statement.setString(10, categorias[i]);
                statement.setString(11, proponente[i]);
                statement.setString(12, lugares[i]);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DBPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean copia(String origen, String destino) {
        try {
            File aor = new File(origen);
            File ade = new File(destino);
            ade.getParentFile().mkdirs();
            ade.createNewFile();
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    public Map<String, Propuesta> cargarPropuestas() {
        try {
            Map<String, Propuesta> lista = new HashMap<String, Propuesta>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM propuesta");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String titulo = rs.getString("titulo");
                String descripcion = rs.getString("descripcion");
                String lugar = rs.getString("lugar"); // agrege lugar y falta estado
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
                Propuesta p = new Propuesta(lugar, titulo, descripcion, fechita, montoActual, fechaPub, url, tipoRetorno, montoTotal, categoria, nickProp, precio);
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

    public Boolean agregarColaboracion(Colaboracion c) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaboracion " + "(Fecha, Retorno, Monto, NickCol, TituloP, Hora) VALUES (?,?,?,?,?,?)");
            Date fechaC = c.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String fechaSt = sdf.format(fechaC);
            String[] lul = fechaSt.split(" ");
            String parte1 = lul[0];
            String parte2 = lul[1];
            statement.setString(1, parte1);
            statement.setString(2, c.getRetorno());
            statement.setInt(3, c.getMonto());
            statement.setString(4, c.getColab().getNick());
            statement.setString(5, c.getProp().getTitulo());
            statement.setString(6, parte2);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void colaboracionesPrueba() {
        String[] colaboradores = {"novick", "robinh", "nicoJ", "marcelot", "Tiajaci", "Mengano", "novick", "sergiop", "marcelot", "sergiop", "chino", "novick", "tonyp", "sergiop", "marcelot", "tonyp", "marcelot"};
        String[] propuestas = {"Cine en el Botánico", "Cine en el Botánico", "Cine en el Botánico", "Religiosamente", "Religiosamente", "Religiosamente", "Religiosamente", "Religiosamente", "El Pimiento Indomable", "El Pimiento Indomable", "Pilsen Rock", "Pilsen Rock", "Pilsen Rock", "Romeo y Julieta", "Romeo y Julieta", "Un dia de Julio", "Un dia de Julio"};
        String[] fechas = {"2018-05-20", "2018-05-24", "2018-05-30", "2018-06-30", "2018-07-01", "2018-07-07", "2018-07-10", "2018-07-15", "2018-08-01", "2018-08-03", "2018-08-05", "2018-08-10", "2018-08-15", "2018-08-13", "2018-08-14", "2018-08-15", "2018-08-17"};
        String[] horas = {"14:30", "17:25", "18:30", "14:25", "18:05", "17:45", "14:35", "09:45", "07:40", "09:25", "16:50", "15:50", "19:30", "04:58", "11:25", "04:48", "15:30"};
        Integer[] montos = {50000, 50000, 50000, 200000, 500, 600, 50000, 50000, 200000, 80000, 50000, 120000, 120000, 100000, 200000, 30000, 150000};
        String[] retornos = {"porcentaje", "porcentaje", "porcentaje", "porcentaje", "entrada", "entrada", "porcentaje", "porcentaje", "porcentaje", "porcentaje", "entrada", "porcentaje", "entrada", "porcentaje", "porcentaje", "entrada", "porcentaje"};
        for (int i = 0; i < 17; i++) {
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaboracion " + "(Fecha, Retorno, Monto, NickCol, TituloP, Hora) VALUES (?,?,?,?,?,?)");
                statement.setString(1, fechas[i]);
                statement.setString(2, retornos[i]);
                statement.setInt(3, montos[i]);
                statement.setString(4, colaboradores[i]);
                statement.setString(5, propuestas[i]);
                statement.setString(6, horas[i]);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public List<Colaboracion> cargarColaboraciones() {
        try {
            IUsuario iUsu = fab.getICtrlUsuario();
            IPropuesta iProp = fab.getICtrlPropuesta();
            List<Colaboracion> listita = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM colaboracion");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Date fechita = rs.getDate("Fecha");
                String retorno = rs.getString("Retorno");
                int monto = rs.getInt("Monto");
                String nick = rs.getString("NickCol");
                Colaborador co = iUsu.traerColaborador(nick);
                String titulo = rs.getString("TituloP");
                Propuesta pr = iProp.getPropPorNick(titulo);
                String hora = rs.getString("Hora");
                Colaboracion c = new Colaboracion(fechita, retorno, monto, co, pr, hora);
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

    public boolean modificarProp(String titulo, Date fecha, int entrada, int monto, String lugar, String cat, String retorno, String desc, String url) {
        try {
            PreparedStatement st = conexion.prepareStatement("UPDATE propuesta SET Fecha=?, Precio=?, ImagenUrl=?, TipoRetorno=?, MontoTotal=?, categoria=?, lugar=?, Descripcion=? WHERE Titulo=" + titulo);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt = sdf.format(fecha);
            st.setString(1, fechaSt);
            st.setInt(2, entrada);
            st.setString(3, url);
            st.setString(4, retorno);
            st.setInt(5, monto);
            st.setString(6, cat);
            st.setString(7, lugar);
            st.setString(8, desc);
            st.executeUpdate();
            st.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
