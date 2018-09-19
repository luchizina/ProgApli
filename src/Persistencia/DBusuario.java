/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Presentacion.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nuevo
 */
/**
 *
 * @author Nuevo
 */
public class DBusuario {

    private Connection conexion = new ConexionDB().getConexion();

    public boolean agregarColaborador(Colaborador u) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaborador "
                    + "(NickC, CorreoC, NombreC, ApellidoC, FechaNacC, ImagenUrlC, pass) values(?,?,?,?,?,?,?)");
            statement.setString(1, u.getNick());
            statement.setString(2, u.getCorreo());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            Date fechaC = u.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt = sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, u.getImg());
            statement.setString(7, u.getCont());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean agregarProponente(Proponente u) {
        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO proponente "
                    + "(NickP, CorreoP, NombreP, ApellidoP, FechaNac, ImagenUrlP, Direccion, Biografia, linkweb, pass) values(?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, u.getNick());
            statement.setString(2, u.getCorreo());
            statement.setString(3, u.getNombre());
            statement.setString(4, u.getApellido());
            Date fechaC = u.getFecha();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSt = sdf.format(fechaC);
            statement.setString(5, fechaSt);
            statement.setString(6, u.getImg());
            statement.setString(7, u.getDireccion());
            statement.setString(8, u.getBiografia());
            statement.setString(9, u.getLinkWeb());
            statement.setString(10, u.getCont());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void seguirCPprueb() {
        String[] seguidorC = {"robinh", "robinh", "robinh", "marcelot", "marcelot", "marcelot", "novick", "novick", "novick", "sergiop", "sergiop", "sergiop", "nicoJ", "nicoJ", "juanP", "juanP", "juanP", "Mengano", "Mengano", "Perengano", "Tiajaci", "Tiajaci"};
        String[] seguidoP = {"hectorg", "juliob", "diegop", "cachilas", "juliob", "kairoh", "hrubino", "tabarec", "cachilas", "mbusca", "juliob", "diegop", "diegop", "durazno", "tabarec", "cachilas", "kairoh", "hectorg", "juliob", "diegop", "juliob", "kairoh"};
        for (int i = 0; i < 22; i++) {
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguircp "
                        + "(SeguidorC, SeguidoP) values(?,?)");
                statement.setString(1, seguidorC[i]);
                statement.setString(2, seguidoP[i]);
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void seguirCCPrueb() {
        String[] seguidorC = {"chino", "tonyp", "Mengano", "Perengano", "Tiajaci"};
        String[] seguidoC = {"tonyp", "chino", "chino", "tonyp", "sergiop"};
        for (int i = 0; i < 5; i++) {
            try {
                PreparedStatement statement = conexion.prepareStatement("INSERT INTO siguecc "
                        + "(Seguidor, Seguido) values(?,?)");
                statement.setString(1, seguidorC[i]);
                statement.setString(2, seguidoC[i]);

                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void seguirPCPrueb(){
        String [] seguidorP = {"kairoh","durazno"};
        String [] seguidoC = {"sergiop","nicoJ"};
        for(int i = 0; i<2; i++){
            try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguirpc "
                    + "(SeguidorP, SeguidoC) values(?,?)");
            statement.setString(1, seguidorP[i]);
            statement.setString(2, seguidoC[i]);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    }
    
    public void seguirPPprueb(){
        String [] seguidorP = {"hrubino","hrubino","hrubino","mbusca","mbusca","mbusca","hectorg","hectorg","tabarec","tabarec","cachilas","juliob","juliob","diegop","diegop","durazno"};
        String [] seguidoP = {"hectorg","diegop","durazno","tabarec","cachilas","kairoh","mbusca","juliob","hrubino","cachilas","hrubino","mbusca","diegop","hectorg","durazno","hrubino"};
        for(int i=0;i<16;i++){
             try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO siguepp "
                    + "(Seguidor, Seguido) values(?,?)");
            statement.setString(1, seguidorP[i]);
            statement.setString(2, seguidoP[i]);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        }
    }

    public boolean seguirCP(String nickcolab, String nickProp) {

        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguircp "
                    + "(SeguidorC, SeguidoP) values(?,?)");
            statement.setString(1, nickcolab);
            statement.setString(2, nickProp);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean dejarSeguirCP(String nickcolab, String nickProp) {

        try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM seguircp WHERE SeguidorC=? and SeguidoP=?");
            statement.setString(1, nickcolab);
            statement.setString(2, nickProp);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean seguirPC(String nickProp, String nickColab) {

        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO seguirpc "
                    + "(SeguidorP, SeguidoC) values(?,?)");
            statement.setString(1, nickProp);
            statement.setString(2, nickColab);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean dejarSeguirPC(String nickProp, String nickColab) {

        try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM seguirpc WHERE SeguidorP=? and SeguidoC=?");
            statement.setString(1, nickProp);
            statement.setString(2, nickColab);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean seguirPP(String nickProp, String nickProp2) {

        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO siguepp "
                    + "(Seguidor, Seguido) values(?,?)");
            statement.setString(1, nickProp);
            statement.setString(2, nickProp2);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean dejarSeguirPP(String nickProp, String nickProp2) {

        try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM siguepp WHERE Seguidor=? and Seguido=?");
            statement.setString(1, nickProp);
            statement.setString(2, nickProp2);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean seguirCC(String nickColab, String nickColab2) {

        try {
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO siguecc "
                    + "(Seguidor, Seguido) values(?,?)");
            statement.setString(1, nickColab);
            statement.setString(2, nickColab2);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean dejarSeguirCC(String nickColab, String nickColab2) {

        try {
            PreparedStatement statement = conexion.prepareStatement("DELETE FROM siguecc WHERE Seguidor=? and Seguido=?");
            statement.setString(1, nickColab);
            statement.setString(2, nickColab2);

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

    }
  public List<Usuario> cargarSegPP() {
        try {
            List<Usuario> lista = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM siguepp");
          //  st.setString(1,nickProp);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("Seguidor");
                Usuario p = new Usuario(nick, rs.getString("Seguido"));
                lista.add(p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
  
  public List<Usuario> cargarSegPC() {
        try {
           List<Usuario> lista = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM seguirpc");
          //  st.setString(1,nickProp);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("SeguidorP");
                Usuario p = new Usuario(nick, rs.getString("SeguidoC"));
                lista.add(p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
  
   public List<Usuario> cargarSegCC() {
        try {
            List<Usuario> lista = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM siguecc");
          //  st.setString(1,nickProp);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("Seguidor");
                Usuario p = new Usuario(nick, rs.getString("Seguido"));
                lista.add(p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
   
    public List<Usuario> cargarSegCP() {
        try {
            List<Usuario> lista = new ArrayList<>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM seguircp");
          //  st.setString(1,nickProp);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("SeguidorC");
                Usuario p = new Usuario(nick, rs.getString("SeguidoP"));
                lista.add(p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
  
  
  
    public Map<String, Usuario> cargarProponentes() {
        try {
            Map<String, Usuario> lista = new HashMap<String, Usuario>();
            PreparedStatement st = conexion.prepareStatement("SELECT * FROM proponente");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("NickP");
                Proponente p = new Proponente(nick, rs.getString("NombreP"), rs.getString("ApellidoP"), rs.getString("CorreoP"), rs.getDate("FechaNac"), rs.getString("ImagenUrlP"), rs.getString("Direccion"), rs.getString("Biografia"), rs.getString("linkWeb"), "Proponente", rs.getString("pass"));
                lista.put(nick, p);
            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            return null;
        }
    }

    public void limpiarBase() throws SQLException {
        try {
            PreparedStatement st = conexion.prepareStatement("Delete FROM colaborador");
            st.executeUpdate();
            st.close();
            PreparedStatement stt = conexion.prepareStatement("Delete FROM proponente");
            stt.executeUpdate();
            stt.close();
            PreparedStatement s = conexion.prepareStatement("Delete FROM categoria");
            s.executeUpdate();
            s.close();
            PreparedStatement a = conexion.prepareStatement("Delete FROM propuesta");
            a.executeUpdate();
            a.close();
            PreparedStatement b = conexion.prepareStatement("Delete FROM colaboracion");
            b.executeUpdate();
            b.close();
            PreparedStatement c = conexion.prepareStatement("Delete FROM listestado");
            c.executeUpdate();
            c.close();
            PreparedStatement d = conexion.prepareStatement("Delete FROM seguircp");
            d.executeUpdate();
            d.close();
            PreparedStatement e = conexion.prepareStatement("Delete FROM seguirpc");
            e.executeUpdate();
            e.close();
            PreparedStatement f = conexion.prepareStatement("Delete FROM siguecc");
            f.executeUpdate();
            f.close();
            PreparedStatement g = conexion.prepareStatement("Delete FROM siguepp");
            g.executeUpdate();
            g.close();
            PreparedStatement comentario = conexion.prepareStatement("Delete FROM comentarios");        // agregado
            comentario.executeUpdate();
            comentario.close();
            PreparedStatement Fav_Colaborador = conexion.prepareStatement("Delete FROM favoriteacp");   // agregado
            Fav_Colaborador.executeUpdate();
            Fav_Colaborador.close();
            PreparedStatement Fav_Proponente = conexion.prepareStatement("Delete FROM favoriteapp");    // agregado
            Fav_Proponente.executeUpdate();
            Fav_Proponente.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cargarProponentesPrueba() {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Date hrubino = sd.parse("1962-02-25");
            Date mb = sd.parse("1972-06-14");
            Date hg = sd.parse("1954-01-07");
            Date tc = sd.parse("1971-07-24");
            Date cs = sd.parse("1947-01-01");
            Date jb = sd.parse("1967-03-16");
            Date dp = sd.parse("1975-01-01");
            Date kh = sd.parse("1840-04-25");
            Date lb = sd.parse("1980-10-31");
            String[] nick = {"hrubino", "mbusca", "hectorg", "tabarec", "cachilas", "juliob", "diegop", "kairoh", "durazno"};
            String[] correo = {"horacio.rubino@guambia.com.uy", "Martin.bus@agadu.org.uy", "hector.gui@elgalpon.org.uy", "tabare.car@agadu.org.uy", "Cachila.sil@c1080.org.uy", "juliobocca@sodre.com.uy", "diego@efectocine.com", "kairoher@pilsenrock.com.uy", "comunicacion@durazno.gub.uy"};
            String[] nombre = {"Horacio", "Martín", "Héctor", "Tabaré", "Waldemar “Cachila” ", "Julio", "Diego", "Kairo", "Itendencia"};
            String[] apellido = {"Rubino", "Buscaglia", "Guido", "Cardozo", "Silva", "Bocca", "Parodi", "Herrera", "Durazno"};
            String[] pass = {"pass1","pass2","pass3","pass4","pass5","pass6","pass7","pass8","pass9"};
            Date[] fechasN = {hrubino, mb, hg, tc, cs, jb, dp, kh, lb};
            String[] urlImg = {"Prueba\\Proponente\\hr.JPG", "Prueba\\Proponente\\mb.jpg", "Prueba\\Proponente\\hg.jpg", "Prueba\\Proponente\\tc.jpg", "Prueba\\Proponente\\cs.jpg", null, null, "Prueba\\Proponente\\kh.jpg", "Prueba\\Proponente\\lb.png"};
            String[] direccion = {"18 de Julio 1234", "Colonia 4321", "Gral. Flores 5645", "Santiago Rivas 1212", "Br. Artigas 4567", "Benito Blanco 4321", "Emilio Frugoni 1138 Ap. 02", "Paraguay 1423", "8 de Octubre 1429"};
            String[] link = {"https://twitter.com/horaciorubino", "http://www.martinbuscaglia.com/", "", "https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs", "https://www.facebook.com/C1080?ref=br_rs", "", "http://www.efectocine.com/", "", "http://durazno.gub.uy/portal/index.php"};
            String[] biografias = {"Horacio Rubino Torres nace el 25 de febrero de 1962, es conductor, actor y libretista.\n"
                + "Debuta en 1982 en carnaval en Los \"Klaper´s\", donde estuvo cuatro años, actuando y\n"
                + "libretando. Luego para \"Gaby´s\" (6 años), escribió en categoría revistas y humoristas y\n"
                + "desde el comienzo y hasta el presente en su propio conjunto Momosapiens.", "Martín Buscaglia (Montevideo, 1972) es un artista, músico, compositor y\n"
                + "productor uruguayo. Tanto con su banda (“Los Bochamakers”) como en su formato “Hombre\n"
                + "orquesta”, o solo con su guitarra, ha recorrido el mundo tocando entre otros países en\n"
                + "España, Estados Unidos, Inglaterra, Francia, Australia, Brasil, Colombia, Argentina, Chile,\n"
                + "Paraguay, México y Uruguay. (Actualmente los Bochamakers son Matías Rada, Martín\n"
                + "Ibarburu, Mateo Moreno, Herman Klang) Paralelamente, tiene proyectos a dúo con el\n"
                + "español Kiko Veneno, la cubana Yusa, el argentino Lisandro Aristimuño, su compatriota\n"
                + "Antolín, y a trío junto a los brasileros Os Mulheres Negras.", "En 1972 ingresó a la Escuela de Arte Dramático del teatro El Galpón. Participó en más de\n"
                + "treinta obras teatrales y varios largometrajes. Integró el elenco estable de Radioteatro\n"
                + "del Sodre, y en 2006 fue asesor de su Consejo Directivo. Como actor recibió múltiples\n"
                + "reconocimientos: cuatro premios Florencio, premio al mejor actor extranjero del Festival de\n"
                + "Miami y premio Mejor Actor de Cine 2008. Durante varios períodos fue directivo del teatro\n"
                + "El Galpón y dirigente de la Sociedad Uruguaya de Actores (SUA); integró también la\n"
                + "Federación Uruguaya de Teatros Independientes (FUTI). Formó parte del equipo de gestión\n"
                + "de la refacción de los teatros La Máscara, Astral y El Galpón, y del equipo de gestión en la\n"
                + "construcción del teatro De la Candela y de la sala Atahualpa de El Galpón.", "Tabaré Cardozo (Montevideo, 24 de julio de 1971) es\n"
                + "un cantante, compositor y murguista uruguayo; conocido por su participación en\n"
                + "la murga Agarrate Catalina, conjunto que fundó junto a su hermano Yamandú y Carlos\n"
                + "Tanco en el año 2001Tabaré Cardozo (Montevideo, 24 de julio de 1971) es\n"
                + "un cantante, compositor y murguista uruguayo; conocido por su participación en\n"
                + "la murga Agarrate Catalina, conjunto que fundó junto a su hermano Yamandú y Carlos\n"
                + "Tanco en el año 2001", "Nace en el año 1947 en el conventillo \"Medio Mundo\" ubicado en pleno Barrio Sur. Es\n"
                + "heredero parcialmente-junto al resto de sus hermanos- de la Comparsa \"Morenada\"\n"
                + "(inactiva desde el fallecimiento de Juan Ángel Silva), en 1999 forma su propia Comparsa de\n"
                + "negros y lubolos \"Cuareim 1080\". Director responsable, compositor y cantante de la misma.", "", "", "", "Nuestros festivales que son orgullo del Uruguay, como cada enero con lo mejor del tango o\n"
                + "el festival de la música tropical. La fiesta de los jóvenes, donde miles de ellos disfrutan de\n"
                + "variados espectáculos al aire libre y se confunden para vivir tres días inolvidables,\n"
                + "convocados por diversos géneros, como rock, tropical, murga y tango. "};
            for (int i = 0; i < 9; i++) {
                String Imagen = null;
                if (urlImg[i] != null) {
                    String[] aux = urlImg[i].split("\\.");
                    String termina = aux[1];
                    String origen = urlImg[i];
                    String destino = "Imagenes/Proponente/" + nick[i] + "." + termina;
                    if (this.copia(origen, destino) == true) {
                        Imagen = destino;
                    } else {
                        Imagen = null;
                    }
                }
                try {
                    PreparedStatement statement = conexion.prepareStatement("INSERT INTO proponente "
                            + "(NickP, CorreoP, NombreP, ApellidoP, FechaNac, ImagenUrlP, Direccion, Biografia, linkweb, pass) values(?,?,?,?,?,?,?,?,?,?)");
                    statement.setString(1, nick[i]);
                    statement.setString(2, correo[i]);
                    statement.setString(3, nombre[i]);
                    statement.setString(4, apellido[i]);
                    Date fechaC = fechasN[i];
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaSt = sdf.format(fechaC);
                    statement.setString(5, fechaSt);
                    statement.setString(6, Imagen);
                    statement.setString(7, direccion[i]);
                    statement.setString(8, biografias[i]);
                    statement.setString(9, link[i]);
                    statement.setString(10, sha1(pass[i])); // encrip
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(DBusuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void CargarColabPrueba() {
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Date rh = sd.parse("1940-08-03");
            Date mt = sd.parse("1960-04-01");
            Date en = sd.parse("1952-07-17");
            Date sp = sd.parse("1950-01-28");
            Date ar = sd.parse("1976-03-17");
            Date ap = sd.parse("1955-02-14");
            Date nj = sd.parse("1960-08-09");
            Date jp = sd.parse("1970-01-01");
            Date mg = sd.parse("1982-02-02");
            Date pl = sd.parse("1985-03-03");
            Date tj = sd.parse("1990-04-04");
            String[] nick = {"robinh", "marcelot", "novick", "sergiop", "chino", "tonyp", "nicoJ", "juanP", "Mengano", "Perengano", "Tiajaci"};
            String[] correos = {"Robin.h@tinglesa.com.uy", "marcelot@ideasdelsur.com.ar", "edgardo@novick.com.uy", "puglia@alpanpan.com.uy", "chino@trico.org.uy", "eltony@manya.org.uy", "jodal@artech.com.uy", "juanp@elpueblo.com", "menganog@elpueblo.com", "pere@elpueblo.com", "jacinta@elpueblo.com"};
            String[] nombres = {"Robin", "Marcelo", "Edgardo", "Sergio", "Alvaro", "Antonio", "Nicolás", "Juan", "Mengano", "Perengano", "Tía"};
            String[] apellidos = {"Henderson", "Tinelli", "Novick", "Puglia", "Recoba", "Pacheco", "Jodal", "Perez", "Gómez", "López", "Jacinta"};
            String[] pass = {"pass1","pass2","pass3","pass4","pass5","pass6","pass7","pass8","pass9","pass10","pass11"};
            Date[] fechasN = {rh, mt, en, sp, ar, ap, nj, jp, mg, pl, tj};
            String[] imagenes = {null, "Prueba\\Colaborador\\mt.jpg", "Prueba\\Colaborador\\en.jpg", "Prueba\\Colaborador\\sp.jpg", null, "Prueba\\Colaborador\\ap.jpg", "Prueba\\Colaborador\\nj.jpg", null, null, null, null};
            for (int i = 0; i < 11; i++) {
                String Imagen = null;
                if (imagenes[i] != null) {
                    String[] aux = imagenes[i].split("\\.");
                    String termina = aux[1];
                    String origen = imagenes[i];
                    String destino = "Imagenes/Colaborador/" + nick[i] + "." + termina;
                    if (this.copia(origen, destino) == true) {
                        Imagen = destino;
                    } else {
                        Imagen = null;
                    }
                }
                try {
                    PreparedStatement statement = conexion.prepareStatement("INSERT INTO colaborador "
                            + "(NickC, CorreoC, NombreC, ApellidoC, FechaNacC, ImagenUrlC, pass) values(?,?,?,?,?,?,?)");
                    statement.setString(1, nick[i]);
                    statement.setString(2, correos[i]);
                    statement.setString(3, nombres[i]);
                    statement.setString(4, apellidos[i]);
                    Date fechaC = fechasN[i];
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String fechaSt = sdf.format(fechaC);
                    statement.setString(5, fechaSt);
                    statement.setString(6, Imagen);
                    statement.setString(7, sha1(pass[i])); //ecrip
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(DBusuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Map<String, Colaborador> cargarColaboradores() {
        try {
            Map<String, Colaborador> lista = new HashMap<String, Colaborador>();
            try (PreparedStatement st = conexion.prepareStatement("SELECT * FROM colaborador")) {
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    String nick = rs.getString("NickC");
                    Colaborador p = new Colaborador(nick, rs.getString("NombreC"), rs.getString("ApellidoC"), rs.getString("CorreoC"), rs.getDate("FechaNacC"), rs.getString("ImagenUrlC"), "Colaborador", rs.getString("pass"));
                    lista.put(nick, p);
                }
                rs.close();
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
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
    
     public String encripta(String pass, String type){
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(type);
            byte [] arreglo = md.digest(pass.getBytes());
            StringBuffer sb =new StringBuffer();
            for(int i=0; i<arreglo.length; ++i){
                sb.append(Integer.toHexString((arreglo[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
     
     
     public String sha1(String pass){
         return this.encripta(pass, "SHA1");
     }
}
