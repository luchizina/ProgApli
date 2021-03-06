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
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import config.Utils;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 *
 * @author Luchi
 */
public class ctrlPropuesta implements IPropuesta {

    private Map<String, Propuesta> propuestas;
    private static ctrlPropuesta instancia;
    private List<Colaboracion> colaboraciones;
    private List<pagos> pagos;
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

        Properties pr = Utils.getPropiedades();
        if (this.propuestas.get(titulo) != null) {
            return false;
        } else {
            try {
                if (img.equals("") == false) {
                    String[] aux = img.split("\\.");
                    String termina = aux[1];
                    String rutaSistema = System.getProperty("user.dir") + "\\";
                    String dest = rutaSistema + pr.getProperty("imagenes") + pr.getProperty("propuesta");
                    String destino = dest + titulo + "." + termina;
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
                    Proponente p = ctrlUsuario.getInstance().traerProponente(nickP);
                    p.getPropuestas().put(titulo, pe);
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
    public void extender(String tit) {
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
                boolean agregarEstado = this.dbE.agregarEstado(est, prop.getTitulo());
            } catch (ParseException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
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
            } catch (SQLException ex) {
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
        //return this.colaboraciones;
        List<Colaboracion> x = new ArrayList<>();
        for(int i = 0; i<colaboraciones.size();i++){
            Colaboracion aux = (Colaboracion) colaboraciones.get(i);
            if(iUsu.traerProponente(aux.getProp().getPropo()).getActivo()){
                x.add(aux);
            }    
        }
        return x;
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
            if (!prop2.tieneColab() && !prop2.estActual.getEstado().equals(Testado.Cancelada)) {
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
    @Override
    public boolean pagarTarjeta(String Nro, String Tipo, Date Fecha, String CVC, String Propuesta, String Colaborador)
            
    {
         Date lul = new Date();
        String horita = java.time.LocalTime.now().toString();
        Colaborador colab = ctrlUsuario.getInstance().traerColaborador(Colaborador);
        Propuesta prop2 = this.propuestas.get(Propuesta);
     List<Colaboracion> col = colab.getColHechas();
      for (int i = 0; i < col.size(); i++) {
        Colaboracion co = (Colaboracion) col.get(i);
        if(co.getColab().getNick().equals(Colaborador) && co.getProp().getTitulo().equals(Propuesta))
        {
            try {
                Tarjeta c = new Tarjeta(Nro,co, Tipo,lul, Integer.parseInt(CVC));
                if (dbPropuesta.pagosTarjeta2(c,prop2,Colaborador)) {
                    this.pagos.add(c);
                    return true;
                }
                else{
                    return false;
                }  } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      }
    return false;
    }
    @Override 
    public boolean pagarTrans(String Nro, String Banco, String Propuesta, String Colaborador)
            {
        Colaborador colab = ctrlUsuario.getInstance().traerColaborador(Colaborador);
        Propuesta prop2 = this.propuestas.get(Propuesta);
     List<Colaboracion> col = colab.getColHechas();
      for (int i = 0; i < col.size(); i++) {
        Colaboracion co = (Colaboracion) col.get(i);
        if(co.getColab().getNick().equals(Colaborador) && co.getProp().getTitulo().equals(Propuesta))
        {
            try {
                Transferencia c = new Transferencia(Nro,co,Banco );
                if (dbPropuesta.pagosTransferencia2(c,prop2.getTitulo(),Colaborador)) {
                    this.pagos.add(c);
                    return true;
                }
                
                else{
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
      }
    return false;
    }
     @Override 
    public boolean pagarPayPal(String Nro, String Propuesta, String Colaborador)
            {
        Colaborador colab = ctrlUsuario.getInstance().traerColaborador(Colaborador);
        Propuesta prop2 = this.propuestas.get(Propuesta);
     List<Colaboracion> col = colab.getColHechas();
      for (int i = 0; i < col.size(); i++) {
        Colaboracion co = (Colaboracion) col.get(i);
        if(co.getColab().getNick().equals(Colaborador) && co.getProp().getTitulo().equals(Propuesta))
        {
            try {
                PayPal c = new PayPal(Nro,co );
                if (dbPropuesta.pagosPayPal2(c,prop2.getTitulo(),Colaborador)) {
                    this.pagos.add(c);
                    return true;
                }
                
                else{
                    return false;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
      }
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
        try {
            this.dbPropuesta.pagosPayPal();
            this.dbPropuesta.pagosTarjeta();
            this.dbPropuesta.pagosTransferencia();
            this.cargarPag();
        } catch (SQLException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            if (iUsu.traerProponente(aux.getPropo()).getActivo()) { //agregado 
                listita.add(aux.obtenerInfo());
            }
        }
        return listita;
    }

    public DtPropuesta traerPropuesta(String titulo) {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        DtPropuesta q = new DtPropuesta(p);
        return q;
    }

    public DtPropuesta SeleccionarProp(String xTitulo)  
    {
        Propuesta pro = this.propuestas.get(xTitulo);
        if (pro.getEstActual().getEstado().equals(Testado.Publicada) || pro.getEstActual().getEstado().equals(Testado.En_Financiacion)) {
            ActualizarEstado(pro); // agregado TAREA 2
        }
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
            if (aux != null && iUsu.traerProponente(aux.getPropo()).getActivo()) { // midificado
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
                String N = aux.getColab().getNombre() + " " + aux.getColab().getApellido() + "(" + aux.getColab().getNick() + ")";
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
            if (p.getTitulo().equalsIgnoreCase(titulo) && iUsu.traerProponente(p.getPropo()).getActivo()) {
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
        List<String> lista_propuestas = this.ListarProp();
        if (Palabra.equals("")) {                      // SI NO BUSCA
            if (!this.ListarProp().isEmpty()) {
                for (int i = 0; i < lista_propuestas.size(); i++) {
                    String p = (String) lista_propuestas.get(i);
                    modelo.addElement(p);
                }
            }
        } else {                                    // SI BUSCA
            if (!this.ListarProp().isEmpty()) {
                for (int i = 0; i < lista_propuestas.size(); i++) {
                    String p = (String) lista_propuestas.get(i);
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

    public List<DtComentarios> traerComentarios(String prop) {
        Propuesta propu = this.getPropPorNick(prop);
        List<DtComentarios> com = new ArrayList<>();
        for (Comentario aux : propu.getCometarios()) {
            String col = aux.getColaborador().getNick();
            String p = aux.getPropuesta().getTitulo();
            String txt = aux.getTexto();
            DtComentarios coment = new DtComentarios(col, p, txt);
            com.add(coment);
        }
        return com;
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
            //if (aux.getEstActual().getEstado().toString().equals("Ingresada") == false && IU.traerProponente(aux.getPropo()).getActivo()) {
            if (aux.getEstActual().getEstado().toString().equals("Ingresada") == false && iUsu.traerProponente(aux.getPropo()).getActivo()) { // agregado
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
        //Fabrica fabrica = Fabrica.getInstance();    //agregado
        //IUsuario IU = fabrica.getICtrlUsuario();    //agregado
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            //if (aux.getCate().equals(x) && aux.getEstActual().getEstado().toString().equals("Ingresada") == false && IU.traerProponente(aux.getPropo()).getActivo()) {
            if (aux.getCate().equals(x) && aux.getEstActual().getEstado().toString().equals("Ingresada") == false && iUsu.traerProponente(aux.getPropo()).getActivo()) {
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
            Usuario propo = this.iUsu.traerUsuario(aux.getPropo());
            Proponente propone = (Proponente) propo;
            if (propone.getActivo() == true) {

                if (aux.getTitulo().contains(txt) == true && !aux.getEstActual().getEstado().equals(Testado.Ingresada)) {
                    prop.add(aux.obtenerInfo());
                    esta = true;
                }

                if (aux.getLugar().contains(txt) == true && !esta && !aux.getEstActual().getEstado().equals(Testado.Ingresada)) {
                    prop.add(aux.obtenerInfo());
                    esta = true;
                }

                if (aux.getDesc().contains(txt) && !esta && !aux.getEstActual().getEstado().equals(Testado.Ingresada)) {
                    prop.add(aux.obtenerInfo());
                }

                esta = false;
            }
        }

        return prop;
    }

    String carpetaImagenes;

    @Override
    public void configurarParametros() {
        String tara2vos = System.getProperty("user.dir") + "\\" + "web";
        File ade = new File(tara2vos);
        if (!ade.exists()) {
            ade.getParentFile().mkdirs();
        }
        this.carpetaImagenes = tara2vos;

    }

    private Map<String, DataImagen> imagenesMap;
    private static Logger LOG;

    @Override
    public String agregarImagen(String titulo_propuesta, DataImagen ximagen) {
        final DtPropuesta imagenP = new DtPropuesta(titulo_propuesta, ximagen);
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
            return path.toString(); // agrege el to string
        } catch (IOException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "Archivo guardado:{0}", pathStr);
        imagenesMap.put(nick, imagen);
        return path.toString(); // agrege el toString
    }

    @Override
    public byte[] retornarImagen(final String titulo) {
        /*if (!this.credencialesMap.keySet().contains(email)){
                         throw new UsuarioNoEncontradoException(email);
                }*/
        for (Propuesta pro : propuestas.values()) {
            if (pro.getTitulo().equals(titulo)) {
                String pat = pro.getImg();
                File f = new File(pat);
                try {
                    FileInputStream fis = new FileInputStream(f);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    byte[] buf = new byte[1024];
                    try {
                        for (int readNum; (readNum = fis.read(buf)) != -1;) {
                            bos.write(buf, 0, readNum);
                        }
                        byte[] bytes = bos.toByteArray();
                        return bytes;
                    } catch (IOException ex) {
                        Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return null;
    }

    public void ActualizarEstado(Propuesta x) {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date g = null;
        if (x.getEstActual().getEstado().equals(Testado.Publicada)) {
            g = x.sacaFechaPub();
        } else if (x.getEstActual().getEstado().equals(Testado.En_Financiacion)) {
            g = x.sacaFechaFin();
        }
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
            if (x.getMontoActual() > 0 && x.getEstActual().getEstado().toString().equals("Publicada")) { // cambiado
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
                int hola = x.MontoA30();
                if (x.MontoA30() >= x.getMontoTotal()) {
                    cambiarEstadito(x.getTitulo(), "Financiada");
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
    
    @Override
    public dataListPropuestas ListPropuesta_A_DT(List<DtPropuesta> dts) {
        dataListPropuestas lista = new dataListPropuestas(dts);
        return lista;
    }

    ;
    
    @Override
    public dataListStrings ListString_A_DT(List<String> dts) {
        dataListStrings lista = new dataListStrings(dts);
        return lista;
    }

    ;
    
    @Override
    public DataList_Comentario ListComentario_A_DT(List<DtComentarios> dts) {
        DataList_Comentario lista = new DataList_Comentario(dts);
        return lista;
    }

    ;
    
    @Override
    public DataImagen Crear_DataImagen_Propuesta(final byte[] stream, final String nombreArchivo, final String extensionArchivo) {
        DataImagen imagen = new DataImagen(stream, nombreArchivo, extensionArchivo);
        return imagen;
    }

    ;
    
    @Override
    public Estado Crear_Esatado_Ingresada() {  // NO sirve para el autogenerado 
        Estado e = new Estado(Testado.Ingresada);
        return e;
    }

    ;
 
    
    @Override
    public boolean AgregarPropuesta_WEB(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, String img, String nickP, String hora, String Lugar) {

        Properties pr = Utils.getPropiedades();
        if (this.propuestas.get(titulo) != null) {
            return false;
        } else {
            try {
                if (img.equals("") == false) {
                    String[] aux = img.split("\\.");
                    String termina = aux[1];
                    String dest = pr.getProperty("rutaNazarenoC") + pr.getProperty("imagenes") + pr.getProperty("propuesta");
                    String destino = dest + titulo + "." + termina;
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
                Estado estA2 = new Estado(Testado.Ingresada);
                pe = new Propuesta(titulo, desc, fecha, precioE, montoActual, fechaPub, Retorno, montoTotal, cate, estA2, img, Lugar);
                pe.setProp(nickP);
                pe.setEstActual(estA2);

                boolean res;
                res = this.dbPropuesta.agregarPropuesta(pe);
                if (res) {

                    //Colección genérica común
                    //this.personas.add(p);
                    this.propuestas.put(titulo, pe);
                    Proponente p = ctrlUsuario.getInstance().traerProponente(nickP);
                    p.getPropuestas().put(titulo, pe);
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
    public byte[] retornarImagen_Propuesta(String titu) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    //public dataRenderedImag traerImagensitaPropuesta(String titulo) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
//    @Override
//    public List<String> List_String_Eliminar_Desactivado(List<String> lista){
//    int x = lista.size();
//    for (int i = 0; i < x; i++) {
//            Propuesta P = (Propuesta) this.getPropPorNick(lista.get(i));
//            if (!iUsu.traerProponente(P.getPropo()).getActivo()) {              // Si esta desactivado 
//                lista.remove(lista.get(i));                                     // lo saco de la lista
//            }
//        }
//    return lista;
//    }
//    @Override
//    public List<DtPropuesta> List_DtPropuesta_Eliminar_Desactivado(List<DtPropuesta> lista){
//        int x = lista.size();
//         for (int i = 0; i < x; i++) {
//            Propuesta P = (Propuesta) this.getPropPorNick(lista.get(i).getTitulo());
//            if (!iUsu.traerProponente(P.getPropo()).getActivo()) {              // Si esta desactivado 
//                lista.remove(lista.get(i));                                     // lo saco de la lista
//            }
//        }
//    return lista;
//    };
    public Colaboracion Traer_Colboracion(String nick_colaborador, String titulo_propuesta) {
        for (int i = 0; i < this.colaboraciones.size(); i++) {
            Colaboracion C = (Colaboracion) this.colaboraciones.get(i);
            if (C.getColab().getNick().equals(nick_colaborador) && C.getProp().getTitulo().equals(titulo_propuesta)) {
                return C;
            }
        }
        return null;
    }

    ;
    
//    @Override
//    public List<Colaboracion> List_Colaboracion_Eliminar_Desactivado(List<Colaboracion> lista){
//        
//    int x = lista.size();    
//    for (int i = 0; i < x; i++) {
//            //Colaboracion C = this.Traer_Colboracion(lista.get(i).,);
//            if (!iUsu.traerProponente(lista.get(i).getProp().getPropo()).getActivo()) { // Si esta desactivado 
//                lista.remove(lista.get(i));                                             // lo saco de la lista
//            }
//        }
//    return lista;
//    };

  
    @Override
    public void cargarPag() {
        List<pagos> pag = new ArrayList<>();
        try {
            pag.addAll(this.dbPropuesta.cargarTar());
        } catch (ParseException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        pag.addAll(this.dbPropuesta.cargarTrans());
        pag.addAll(this.dbPropuesta.cargarPaypal());
        this.pagos = pag;
    }

    public Boolean pago(String prop, String usu) {
        Colaboracion col = this.Traer_Colboracion(usu, prop);
        for (pagos p : this.pagos) {
            if (p.getColab().getColab().getNick().equals(col.getColab().getNick()) && p.getColab().getProp().getTitulo().equals(col.getProp().getTitulo())) {
                System.out.println("Colaboracion pagada");
                return true;
            }
        }
        return false;
    }

    public pagos buscarPago(String prop, String usu) {
        Colaboracion col = this.Traer_Colboracion(usu, prop);
        for (pagos p : this.pagos) {
            if (p.getColab().equals(col)) {
                return p;
            }
        }
        return null;
    }

    public void crearReporte(String prop, String usu) {
        DataReporte dat = this.traerRep(prop, usu);
        if (dat != null) {
            Propuesta p = this.getPropPorNick(prop);
            Colaboracion col = this.Traer_Colboracion(usu, prop);
            Date hoy = new Date();
            SimpleDateFormat lala = new SimpleDateFormat("dd/MM/yyyy");
            String emision = lala.format(hoy);
            String nacimiento = lala.format(col.getColab().getFecha());
            String fechaCol = lala.format(col.getFecha());
            pagos pag = this.buscarPago(prop, usu);
            int cvc;
            Date fechaVen = null;
            String numero;
            String tipo;
            String banco;
            if (this.pago(prop, usu)) {
                Document nuevo = new Document();
                try {
                    FileOutputStream fichero = new FileOutputStream("pdfs/EmisionPago" + usu + prop + ".pdf");
                    PdfWriter writer = PdfWriter.getInstance(nuevo, fichero);
                    nuevo.open();
                    try {
                        Font titulos = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, BaseColor.PINK.darker());
                        Font sub = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.GREEN.darker());
                        Font todo = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.BLACK);
                        Paragraph par = new Paragraph();
                        par.add(new Phrase("Fecha de emision: " + emision + "\n", sub));
                        par.setAlignment(Element.ALIGN_RIGHT);
                        nuevo.add(par);
                        Image imagen = Image.getInstance("Imagenes/logo.png");
                        imagen.setAlignment(Element.ALIGN_CENTER);
                        imagen.scaleToFit(200, 200);
                        nuevo.add(imagen);
                        Paragraph usua = new Paragraph();
                        usua.add(new Phrase("Datos del usuario:", titulos));
                        nuevo.add(usua);
                        Paragraph p1 = new Paragraph();
                        p1.add(new Phrase("Nick del usuario: ", sub));
                        p1.add(new Phrase(usu + "\n", todo));
                        p1.add(new Phrase("Correo: ", sub));
                        p1.add(new Phrase(col.getColab().getCorreo() + "\n", todo));
                        p1.add(new Phrase("Nombre del usuario: ", sub));
                        p1.add(new Phrase(col.getColab().getNombre() + "\n", todo));
                        p1.add(new Phrase("Apellido del usuario: ", sub));
                        p1.add(new Phrase(col.getColab().getApellido() + "\n", todo));
                        p1.add(new Phrase("Fecha de nacimiento: ", sub));
                        p1.add(new Phrase(nacimiento + "\n\n", todo));
                        nuevo.add(p1);
                        Paragraph colab = new Paragraph();
                        colab.add(new Phrase("Datos de la colaboracion:", titulos));
                        nuevo.add(colab);
                        Paragraph p2 = new Paragraph();
                        p2.add(new Phrase("Propuesta: ", sub));
                        p2.add(new Phrase(prop + "\n", todo));
                        p2.add(new Phrase("Fecha: ", sub));
                        p2.add(new Phrase(fechaCol + "\n", todo));
                        p2.add(new Phrase("Hora: ", sub));
                        p2.add(new Phrase(col.getHora() + "\n", todo));
                        p2.add(new Phrase("Monto: ", sub));
                        p2.add(new Phrase(col.getMonto() + "\n", todo));
                        p2.add(new Phrase("Retorno elegido: ", sub));
                        p2.add(new Phrase(col.getRetorno() + "\n\n", todo));
                        nuevo.add(p2);
                        Paragraph tit = new Paragraph();
                        tit.add(new Phrase("Datos del pago", titulos));
                        nuevo.add(tit);
                        Paragraph p3 = new Paragraph();
                        if (pag instanceof Tarjeta) {
                            cvc = ((Tarjeta) pag).getCvc();
                            fechaVen = ((Tarjeta) pag).getFecha();
                            String vencimiento = lala.format(fechaVen);
                            numero = pag.getNumero();
                            tipo = ((Tarjeta) pag).getTipo();
                            p3.add(new Phrase("Pago por tarjeta" + "\n\n", sub));
                            p3.add(new Phrase("CVC: ", sub));
                            p3.add(new Phrase(cvc + "\n", todo));
                            p3.add(new Phrase("Fecha de vencimiento: ", sub));
                            p3.add(new Phrase(vencimiento + "\n", todo));
                            p3.add(new Phrase("Numero: ", sub));
                            p3.add(new Phrase(numero + "\n", todo));
                            p3.add(new Phrase("Tipo de tarjeta: ", sub));
                            p3.add(new Phrase(tipo + "\n", todo));
                        }
                        if (pag instanceof PayPal) {
                            numero = pag.getNumero();
                            p3.add(new Phrase("Pago por PayPal" + "\n\n", sub));
                            p3.add(new Phrase("Numero: ", sub));
                            p3.add(new Phrase(numero + "\n", todo));
                        }

                        if (pag instanceof Transferencia) {
                            banco = ((Transferencia) pag).getBanco();
                            numero = pag.getNumero();
                            p3.add(new Phrase("Pago por Transferencia" + "\n\n", sub));
                            p3.add(new Phrase("Banco: ", sub));
                            p3.add(new Phrase(banco + "\n", todo));
                            p3.add(new Phrase("Numero: ", sub));
                            p3.add(new Phrase(numero + "\n", todo));
                        }
                        nuevo.add(p3);
                        nuevo.close();
                    } catch (BadElementException | IOException ex) {
                        Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (FileNotFoundException | DocumentException ex) {
                    Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public byte[] crearDescarga(String prop, String usu) {
        Properties p = Utils.getPropiedades();
        String rutaSistema = System.getProperty("user.dir") + "\\";
        String rutaArch = rutaSistema + "pdfs\\" + "EmisionPago" + usu + prop + ".pdf";
        File pdf = new File(rutaArch);
        try {
            FileInputStream fis = new FileInputStream(pdf);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            try {
                for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum);
                }
                byte[] bytes = bos.toByteArray();
                return bytes;
            } catch (IOException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DataReporte traerRep(String prop, String usu) {
        Propuesta p = this.getPropPorNick(prop);
        Colaboracion col = this.Traer_Colboracion(usu, prop);
        Date hoy = new Date();
        SimpleDateFormat lala = new SimpleDateFormat("dd/MM/yyyy");
        String emision = lala.format(hoy);
        String nacimiento = lala.format(col.getColab().getFecha());
        String fechaCol = lala.format(col.getFecha());
        pagos pag = this.buscarPago(prop, usu);
        if (this.pago(prop, usu)) {
            if (pag instanceof PayPal) {
                DataReporte data = new DataReporte(usu, col.getColab().getNombre(), col.getColab().getApellido(), nacimiento, col.getColab().getCorreo(), emision, prop, fechaCol, col.getHora(), col.getMonto(), col.getRetorno(), pag.getNumero());
                return data;
            }
            if (pag instanceof Transferencia) {
                DataReporte data = new DataReporte(usu, col.getColab().getNombre(), col.getColab().getApellido(), nacimiento, col.getColab().getCorreo(), emision, prop, fechaCol, col.getHora(), col.getMonto(), col.getRetorno(), pag.getNumero(), ((Transferencia) pag).getBanco());
                return data;
            }
            if (pag instanceof Tarjeta) {
                String vencimiento = lala.format(((Tarjeta) pag).getFecha());
                DataReporte data = new DataReporte(usu, col.getColab().getNombre(), col.getColab().getApellido(), nacimiento, col.getColab().getCorreo(), emision, prop, fechaCol, col.getHora(), col.getMonto(), col.getRetorno(), pag.getNumero(), ((Tarjeta) pag).getCvc(), vencimiento, ((Tarjeta) pag).getTipo());
                return data;
            }
        }
        DataReporte rep = new DataReporte();
        return rep;
    }

    @Override
    public DefaultListModel Propuestas_Desactivadas(String proponente_nick) {
        DefaultListModel modelo = new DefaultListModel();
        Proponente P = iUsu.traerProponente(proponente_nick);
        Set set = P.getPropuestas().entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            //if (aux.getCate().equals(x) && aux.getEstActual().getEstado().toString().equals("Ingresada") == false && IU.traerProponente(aux.getPropo()).getActivo()) {
            modelo.addElement(aux.getTitulo());
        }
        return modelo;
    }

    ;
    
    
    @Override
    public TableModel Listar_Colaboracines_tabla(String titulo_propuesta) {
        String columnas[] = {"Colaborador", "Monto"};
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        Propuesta P = this.getPropPorNick(titulo_propuesta);
        for (int i = 0; i < P.getColaboraciones().size(); i++) {
            Colaboracion C = P.getColaboraciones().get(i);
            Object[] dat = {C.getColab().getNombre() + "(" + C.getColab().getNick() + ")", C.getMonto()};
            model.addRow(dat);
        }
        return model;
    }
;
}
