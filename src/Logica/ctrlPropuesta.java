/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Propuesta;
import Logica.ctrlUsuario;
import Persistencia.DBListEstado;
import Persistencia.DBPropuesta;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import static Logica.Testado.Publicada;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.HashMap;
//import Persistencia.DBPersona;
import java.util.Map;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Luchi
 */
public class ctrlPropuesta implements IPropuesta {

    private Map<String, Propuesta> propuestas;
    private static ctrlPropuesta instancia;
    private List<Colaboracion> colaboraciones;
    private Propuesta propuestaconsulta = null;
    DBPropuesta dbPropuesta = null;
    DBListEstado dbE = null;
    Fabrica fab = Fabrica.getInstance();    //agregado
    IUsuario iUsu = fab.getICtrlUsuario(); //agregado

    public static ctrlPropuesta getInstance() {
        if (instancia == null) {
            instancia = new ctrlPropuesta();
        }
        return instancia;
    }

    private ctrlPropuesta() {
        //Colección genérica común
        //this.personas=new ArrayList<Persona>();
        this.propuestas = new HashMap<String, Propuesta>();
        this.dbPropuesta = new DBPropuesta();
        this.dbE = new DBListEstado();
        //this.dbPersona=new DBPersona();
    }

    public Map<String, Propuesta> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(Map<String, Propuesta> propuestas) {
        this.propuestas = propuestas;
    }

    public Propuesta getPropPorNick(String nick) {
        Propuesta pr = this.propuestas.get("Un día de Julio");
        return this.propuestas.get(nick);
    }

    public void actualizarMontos() {
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            try {
                aux.actualizarMonto();
            } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

//(String titulo, String desc, String fecha, int precioE, String fechaPub, int montoTotal, String cate,String img)
    @Override
    public boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img, String nickP, String hora, String Lugar) {
        if (this.propuestas.get(titulo) != null) {
            return false;
        } else {
            try {
                if (img.equals("") == false) {
                    String[] aux = img.split("\\.");
                    String termina = aux[1];
                    String destino = "C:\\Users\\Nuevo\\Documents\\NetBeansProjects\\ProgApli1\\LaqueAnda13\\Imagenes\\Propuesta\\" + titulo + "." + termina;
                    try {
                        if (this.copy(img, destino) == true) {
                            img = destino;
                        } else {
                            img = null;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //  public Propuesta(String titulo, String desc, Date fecha, int precioE, String fechaPub, int montoTotal, String cate,String Lugar) {
                fechaPub = new Date();
                Propuesta pe;
                pe = new Propuesta(titulo, desc, fecha, precioE, montoActual, fechaPub, Retorno, montoTotal, cate, estActual, img, Lugar);
                pe.setProp(nickP);
                pe.setEstActual(estActual);

                boolean res;
                res = this.dbPropuesta.agregarPropuesta(pe);
                if (res) {

                    //Colección genérica común
                    //this.personas.add(p);
                    this.propuestas.put(titulo, pe);
                    pe.setCate(cate);

                    java.sql.Time fecFormatoTime = null;
                    try {
                        SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss", new Locale("es", "ES"));
                        fecFormatoTime = new java.sql.Time(sdf.parse(hora).getTime());
                        System.out.println("Fecha con el formato java.sql.Time: " + fecFormatoTime);
                    } catch (ParseException ex) {
                        System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
                    }
                    ListEstado est = new ListEstado(fechaPub, fecFormatoTime, "Ingresada");
                    System.out.println(est.getEst() + est.getFecha().toString() + est.getHora().toString() + " ESTOOOOOOOOOOOoo");

                    pe.addLE(est);

                    for (int i = 0; i < pe.getLE().size(); i++) {
                        System.out.println(pe.getLE().get(i).getEst() + " ESTOOOO" + pe.getLE().get(i).getEst());

                    }
                    boolean Est = this.dbE.agregarEstado(est, titulo);
                    if (Est) {
                        System.out.println("Lo hace bien!!!");
                    } else {
                        System.out.println("Lo hace mal!!!");
                    }
                    return res;

                }
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public void extender(String tit) throws SQLException {
        Propuesta prop = this.getPropPorNick(tit);
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        String hora = formateador.format(ahora);
        java.sql.Time fecFormatoTime = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss", new Locale("es", "ES"));
            fecFormatoTime = new java.sql.Time(sdf.parse(hora).getTime());
            System.out.println("Fecha con el formato java.sql.Time: " + fecFormatoTime);
        } catch (ParseException ex) {
            System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
        }
        if (prop.getEstActual().getEstado().equals(Testado.Publicada)) {
            ListEstado est = new ListEstado(ahora, fecFormatoTime, "Publicada");
            prop.addLE(est);
            try {
                this.dbE.agregarEstado(est, prop.getTitulo());
            } catch (ParseException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (prop.getEstActual().getEstado().equals(Testado.En_Financiacion)) {
            ListEstado est = new ListEstado(ahora, fecFormatoTime, "En Financiacion");
            prop.addLE(est);
            try {
                this.dbE.agregarEstado(est, prop.getTitulo());
            } catch (ParseException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DefaultTableModel BUSCADOR_Propuestas2(String palabrita, List<DtPropuesta> listita, TableModel modelito) {
        DefaultTableModel model = (DefaultTableModel) modelito;
        model.setRowCount(0);
        if (palabrita.equals("")) { // SI NO BUSCA
            if (!listita.isEmpty()) {
                for (int i = 0; i < listita.size(); i++) {
                    DtPropuesta p = (DtPropuesta) listita.get(i);
                    Proponente p2 = ctrlUsuario.getInstance().traerProponente(p.getPropo());
                    Object[] dat = {p.getTitulo(), p2.getNombre() + "(" + p2.getNick() + ")"};
                    model.addRow(dat);
                }
                return model;
            }
        } else {                                // SI BUSCA
            if (!listita.isEmpty()) {
                for (int i = 0; i < listita.size(); i++) {
                    DtPropuesta p = (DtPropuesta) listita.get(i);
                    Proponente p2 = ctrlUsuario.getInstance().traerProponente(p.getPropo());
                    if (p.getTitulo().contains(palabrita) || p2.getNick().contains(palabrita)) {
                        Object[] dat = {p.getTitulo(), p2.getNombre() + "(" + p2.getNick() + ")"};
                        model.addRow(dat);
                    }
                }

            }
        }
        return model;
    }

    public void cambiarEstadito(String p, String f) {
        Propuesta pr = this.propuestas.get(p);
        Estado est = new Estado(Testado.valueOf(f));
        pr.setEstActual(est);
        Date fechita = new Date();
        Date hora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss");
        String fg = formateador.format(hora);
        java.sql.Time fecFormatoTime = null;
        try {
            SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss", new Locale("es", "ES"));

            fecFormatoTime = new java.sql.Time(sdf.parse(fg).getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListEstado estad = new ListEstado(fechita, fecFormatoTime, f);
        try {
            this.dbE.agregarEstado(estad, p);
        } catch (SQLException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        pr.addLE(estad);
    }

    public List<Colaboracion> listarColaboraciones() {
        return this.colaboraciones;
    }

    @Override
    public boolean existeColaboracion(String nick, String titulo) {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        Iterator iteradorsito = p.colaboraciones.iterator();
        while (iteradorsito.hasNext()) {

            Colaboracion aux = (Colaboracion) iteradorsito.next();
            if (aux.getColab().nick == nick) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean altaColaboracion(String prop, String colab, String monto, String tipoR) {
        Date lul = new Date();
        String horita = java.time.LocalTime.now().toString();
        Colaborador colab2 = ctrlUsuario.getInstance().traerColaborador(colab);
        Propuesta prop2 = this.propuestas.get(prop);

        Colaboracion c = new Colaboracion(lul, tipoR, Integer.parseInt(monto), colab2, prop2, horita);

        if (dbPropuesta.agregarColaboracion(c)) {
            this.colaboraciones.add(c);
            if (!prop2.tieneColab()) {
                this.cambiarEstadito(prop2.getTitulo(), "En_Financiacion");
            }
            prop2.addColab(c);
            colab2.AddColab(c);
            try {
                prop2.actualizarMonto();
            } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }

    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("kkmmss");
        String currentTime = dateFormat.format(System.currentTimeMillis());
        return currentTime;
    }

    public void cancelarColaboracion(String c, String p) {
        String[] partes = c.split(Pattern.quote("("));
        String parte1 = partes[0];
        String parte2 = partes[1];
        String[] partes3 = parte2.split(Pattern.quote(")"));
        String parte4 = partes3[0];
        for (int i = 0; i < this.colaboraciones.size(); i++) {
            Colaboracion co = (Colaboracion) colaboraciones.get(i);
            if (co.getColab().getNick().equals(parte4) && co.getProp().getTitulo().equals(p)) {
                try {
                    if (dbPropuesta.eliminarColaboracion(co)) {
                        this.colaboraciones.remove(co);
                        co.getColab().removeColab(co);
                        co.getProp().removeColab(co);
                        this.actualizarMontos();
                        co = null;
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Date fecha(String fecha) {
        java.util.Date fec;
        java.sql.Date sqlDate = null;
        SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
        try {
            fec = da.parse(fecha);
            sqlDate = new java.sql.Date(fec.getTime());
            System.out.println(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }

    /* public Date horas(String hora) throws ParseException{
 
    return date;
    }*/
    public boolean copy(String origen, String destino) throws IOException {
        try {
            File aor = new File(origen);
            File ade = new File(destino);
            ade.getParentFile().mkdirs();
            ade.createNewFile();
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void cargarPropuestas() {
        this.propuestas = this.dbPropuesta.cargarPropuestas();
        this.SetearPropuestas_A_Proponentes();              //agregado
        this.Cargar_Comentarios_Memoria();                  //agregado  
        this.Cargar_Favoritos_Memoria();                    //agregado
    }

    @Override
    public void cargarProp() {
        this.dbPropuesta.cargarPropuestasPrueba();
        this.cargarPropuestas();
        this.dbE.agregarListPrueb();
        this.EstadosPropuestas();
        this.dbPropuesta.colaboracionesPrueba();
        this.cargarColaboraciones();
        this.actualizarMontos();
        this.dbPropuesta.CargarComentarios_BaseDeDatos();   //agregado
        this.dbPropuesta.CargarFavoritos_BaseDeDatos();     //agregado
        this.Cargar_Comentarios_Memoria();                  //agregado  
        this.Cargar_Favoritos_Memoria();                    //agregado
    }

    public void cargarColaboraciones() {
        this.colaboraciones = this.dbPropuesta.cargarColaboraciones();
    }

    @Override
    public void cargarEstados() {
        this.dbPropuesta.cargarEstados();
    }

    public List<DtPropuesta> listarPropuestas() {
        List<DtPropuesta> listita = new ArrayList<>();
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            listita.add(aux.obtenerInfo());
        }
        return listita;
    }

    public DtPropuesta traerPropuesta(String titulo) {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        DtPropuesta q = new DtPropuesta(p);
        return q;
    }

    public DtPropuesta SeleccionarProp(String xTitulo) // error 
    { 
        Propuesta pro = this.propuestas.get(xTitulo);
        ActualizarEstado(pro); // agregado TAREA 2
        DtPropuesta X = new DtPropuesta(pro, pro.getCate());
        this.propuestaconsulta = pro;
        return X;
    }

    @Override
    public List<String> NombrePropoConsulta() {

        return this.propuestaconsulta.NombreColaborantes();

    }

    @Override
    public List<String> ListarProp() {
        List<String> Nicks = new ArrayList<String>();
        Set set = propuestas.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            if (aux != null) {
                Nicks.add(aux.getTitulo());
            }
        }
        return Nicks;
    }

    ;
 
    @Override
    public List<String> ColaborantesDePro() {
        List<String> Nicks = new ArrayList<String>();
        Iterator iteradorsito = colaboraciones.iterator();
        while (iteradorsito.hasNext()) {
            Colaboracion aux = (Colaboracion) iteradorsito.next();
            if (aux.getProp().getTitulo().equals(this.propuestaconsulta.getTitulo())) {
                String N = aux.getColab().getNombre() + "(" + aux.getColab().getNick() + ")";
                Nicks.add(N);
            }
        }
        this.propuestaconsulta = null;
        return Nicks;
    }

    ;
    
    @Override
    public void EstadosPropuestas() {
        Set set = propuestas.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            this.dbE.SetearEstadoPropuesta(aux);
        }
    }

    ;

    @Override
    public boolean actualizarDatos(String titulo, Date fecha, int entrada, int monto, String lugar, String cat, String retorno, String desc, String url) {
        if (url.equals("") == false) {
            String[] aux = url.split("\\.");
            String termina = aux[1];
            String destino = "Imagenes/Propuesta/" + titulo + "." + termina;
            try {
                if (this.copy(url, destino) == true) {
                    url = destino;
                } else {
                    url = null;
                }
            } catch (IOException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        boolean ok = this.dbPropuesta.modificarProp(titulo, fecha, entrada, monto, lugar, cat, retorno, desc, url);
        if (ok) {
            for (Propuesta prop : this.propuestas.values()) {
                if (prop.getTitulo().equals(titulo)) {
                    prop.setFecha(fecha);
                    prop.setPrecioE(entrada);
                    prop.setMontoTotal(monto);
                    prop.setLugar(lugar);
                    prop.setCate(cat);
                    prop.setTipoRetorno(retorno);
                    prop.setDesc(desc);
                    prop.setImg(url);
                }
            }
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean existeTitulo(String titulo) {
        for (Propuesta p : this.propuestas.values()) {
            if (p.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }

    public void filtrarP(String campito, JList listita, List<DtPropuesta> propuestitas) {
        if (campito.equals("")) { // SI NO BUSCA
            if (!propuestitas.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < propuestitas.size(); i++) {
                    DtPropuesta p = (DtPropuesta) propuestitas.get(i);
                    modelo.addElement(p.getTitulo());
                }
                listita.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!propuestitas.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < propuestitas.size(); i++) {
                    DtPropuesta p = (DtPropuesta) propuestitas.get(i);
                    if (p.getTitulo().contains(campito)) {
                        modelo.addElement(p.getTitulo());
                    }
                }
                listita.setModel(modelo);
            }
        }
    }

    @Override
    public DefaultListModel BUSCADOR_Propuestas(String Palabra) {
        DefaultListModel modelo = new DefaultListModel();
        if (Palabra.equals("")) {                      // SI NO BUSCA
            if (!this.ListarProp().isEmpty()) {
                for (int i = 0; i < propuestas.size(); i++) {
                    String p = (String) this.ListarProp().get(i);
                    modelo.addElement(p);
                }
            }
        } else {                                    // SI BUSCA
            if (!this.ListarProp().isEmpty()) {
                for (int i = 0; i < propuestas.size(); i++) {
                    String p = (String) this.ListarProp().get(i);
                    if (p.contains(Palabra)) {
                        modelo.addElement(p);
                    }
                }
            }
        }
        return modelo;
    }

    ;
    public void Cargar_Comentarios_Memoria() {
        this.dbPropuesta.CargarComentarios_Memoria();
//    List<Comentario> x = this.dbPropuesta.CargarComentarios_Memoria();
//    if(!x.isEmpty()){
//        for (int i = 0; i < x.size(); i++) {
//                    Comentario p = (Comentario) x.get(i);
//                    p.getColaborador().getComentarios().add(p);
//                    p.getPropuesta().getCometarios().add(p);
//                    System.out.println(p.getPropuesta().getTitulo()+" "+p.getColaborador().getNombre());
//                }
//    }
//    else {
//        System.out.println("Vacio no anda algo");
//    }
    }

    @Override
    public void agregarComentario(Colaborador nick, Propuesta titulo, String texto) {
        Comentario c = new Comentario(nick, titulo, texto);
        titulo.Agregar_Comentario(c);
        nick.Agregar_Comentario(c);
        this.dbPropuesta.agregarComentario(c);
    }

    ;
    
 @Override
    public void agregarFavorito(Usuario usu, Propuesta prop) {
        if (usu instanceof Proponente) {
            usu.getPropuFav().put(prop.getTitulo(), prop);
            this.dbPropuesta.favProp(usu.getNick(), prop.getTitulo());
        }

        if (usu instanceof Colaborador) {
            usu.getPropuFav().put(prop.getTitulo(), prop);
            this.dbPropuesta.favCol(usu.getNick(), prop.getTitulo());
        }
    }

    @Override
    public void Cargar_Favoritos_Memoria() {
        this.dbPropuesta.CargarFavoritos_Memoria();
    }

    ;
    
    
    @Override
    public List<DtPropuesta> WEB_listarPropuestas_No_Ingresada() {
        List<DtPropuesta> listita = new ArrayList<>();
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            if (aux.getEstActual().getEstado().toString().equals("Ingresada") == false) {
                //ActualizarEstado(aux);
                listita.add(aux.obtenerInfo());
            }
        }
        Collections.sort(listita, (c, d) -> {
            return c.getTitulo().compareTo(d.getTitulo());
        });
        return listita;
    }

    @Override
    public List<DtPropuesta> WEB_listarPropuestas_X_Categoria(String x) {
        List<DtPropuesta> listita = new ArrayList<>();
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            if (aux.getCate().equals(x) && aux.getEstActual().getEstado().toString().equals("Ingresada") == false) {
                listita.add(aux.obtenerInfo());
            }
        }
        Collections.sort(listita, (c, d) -> {
            return c.getTitulo().compareTo(d.getTitulo());
        });
        return listita;
    }

    @Override
    public List<DtPropuesta> listaTDL(String txt) {
        List<DtPropuesta> prop = new ArrayList<>();
        Set set = propuestas.entrySet();
        Iterator it = set.iterator();
        boolean esta = false;
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            if (aux.getTitulo().contains(txt) == true) {
                prop.add(aux.obtenerInfo());
                esta = true;
            }

            if (aux.getLugar().contains(txt) == true && !esta) {
                prop.add(aux.obtenerInfo());
                esta = true;
            }

            if (aux.getDesc().contains(txt) == true && !esta) {
                prop.add(aux.obtenerInfo());
                esta = true;
            }

            esta = false;
        }

        return prop;
    }

    String carpetaImagenes;

    @Override
    public void configurarParametros(String carpetaImagenes) {
        File ade = new File(carpetaImagenes);
        if(!ade.exists()){
        ade.getParentFile().mkdirs();
        }
        this.carpetaImagenes = carpetaImagenes;

    }

    private Map<String, DataImagen> imagenesMap;
    private static Logger LOG;

    @Override
    public Path agregarImagen(final DtPropuesta imagenP) {
        this.imagenesMap = new HashMap<>();
        LOG = Logger.getLogger(this.getClass().getPackage().getName());
        String nick = imagenP.getTitulo();
        if (this.carpetaImagenes == null) {
            LOG.log(Level.SEVERE, "carpetaImagenes is null");
            throw new IllegalStateException("La carpeta de imagenes no fue configurada");
        }//if
        final File fileImagenes = new File(this.carpetaImagenes);
        if (!fileImagenes.isDirectory()) {
            LOG.log(Level.SEVERE, this.carpetaImagenes + "no es un directorio");
            try {
                throw new IOException("La carpeta de imagenes no fue configurada");
            } catch (IOException ex) {
                Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//if
        String pathStr = this.carpetaImagenes + File.separatorChar + nick;
        final File dirUsuario = new File(pathStr);
        if (!dirUsuario.isDirectory()) {
            dirUsuario.mkdirs();
        }
        final DataImagen imagen = imagenP.getImagen();
        pathStr = pathStr + File.separatorChar + imagen.getNombreArchivo() + "." + imagen.getExtensionArchivo();
        Path path = Paths.get(pathStr);
        try {
            Files.write(path, imagen.getStream(), CREATE);
            return path;
        } catch (IOException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "Archivo guardado:{0}", pathStr);
        imagenesMap.put(nick, imagen);
        return path;
    }

    @Override
    public BufferedImage retornarImagen(final String titulo) {
        /*if (!this.credencialesMap.keySet().contains(email)){
                         throw new UsuarioNoEncontradoException(email);
                }*/
        DataImagen imagen = imagenesMap.get(titulo);
        String pathStr = this.carpetaImagenes + File.separatorChar + titulo;
        pathStr = pathStr + File.separatorChar + imagen.getNombreArchivo() + "." + imagen.getExtensionArchivo();
        File f = new File(pathStr);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bi;
    }

    public void ActualizarEstado(Propuesta x) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date g = x.getFechaPub();   // Esta fecha? vereficar 
        Date h = new Date();
        String sg = myFormat.format(g);
        String sh = myFormat.format(h);
        LocalDate dateBefore = LocalDate.parse(sg);
        LocalDate dateBefore2 = LocalDate.parse(sh);
        long dias = ChronoUnit.DAYS.between(dateBefore, dateBefore2);
        //System.out.println(dias);
        if (x.getEstActual().getEstado().toString().equals("Publicada")) {
            if (dias > 30) {
                cambiarEstadito(x.getTitulo(), "No_Financiada");
            }
            if(x.getMontoActual()>0 && !x.getEstActual().getEstado().toString().equals("En_Financiacion")){
                 cambiarEstadito(x.getTitulo(), "En_Financiacion");
            }
        }
        if (x.getEstActual().getEstado().toString().equals("En_Financiacion")) {
            if (dias <= 30 && x.getMontoActual() >= x.getMontoTotal()) {
                if (!x.getEstActual().getEstado().toString().equals("Financiada")) {
                    cambiarEstadito(x.getTitulo(), "Financiada");
                }
            }
            if (dias > 30 && x.getEstActual().getEstado().toString().equals("En_Financiacion")) {
                if (x.getMontoActual() < x.getMontoTotal()) {
                    cambiarEstadito(x.getTitulo(), "No_Financiada");
                }
            }
        }
    }

    ;
        
        
        public void SetearPropuestas_A_Proponentes() {
        Set set = this.propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            Proponente pro = iUsu.traerProponente(aux.getPropo());
            pro.getPropuestas().put(aux.getTitulo(), aux);
        }
    }

    ;
        
    @Override
    public boolean yaFavoriteo(Usuario usu, String p) {
        if (usu instanceof Proponente) {
            Propuesta pro = usu.getPropuFav().get(p);
            if (pro != null) {
                return true;
            }
        }

        if (usu instanceof Colaborador) {
            Propuesta pro = usu.getPropuFav().get(p);
            if (pro != null) {
                return true;
            }
        }
        return false;
    }

    ;
        
        @Override
    public BufferedImage retornarImagen_Propuesta(final String titu) {
        /*if (!this.credencialesMap.keySet().contains(email)){
                         throw new UsuarioNoEncontradoException(email);
                }*/
        for (Propuesta pro : propuestas.values()) {
            if (pro.getTitulo().equals(titu)) {
                String pat = pro.getImg();
                File f = new File(pat);
                BufferedImage bi = null;
                try {
                    bi = ImageIO.read(f);
                } catch (IOException ex) {
                    Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
                }
                return bi;
            }
        }
        return null;
    }

    @Override
    public boolean Ya_Comento_Propuesta(String c, String p) {
        Propuesta P = this.getPropPorNick(p);
        for (int i = 0; i < P.getCometarios().size(); i++) {
            Comentario comentar = (Comentario) P.getCometarios().get(i);
            if (comentar.getColaborador().getNick().equals(c)) {
                return true;
            }
        }
        return false;
    }
;
}
