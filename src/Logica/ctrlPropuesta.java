/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Logica.Propuesta;
import Persistencia.DBListEstado;
import Persistencia.DBPropuesta;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import Logica.Colaboracion;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.HashMap;
//import Persistencia.DBPersona;
import java.util.Map;
import java.util.Set;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;

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
    
    public Propuesta getPropPorNick(String nick)
    {
        Propuesta pr = this.propuestas.get("Un día de Julio");
        return this.propuestas.get(nick);
    }
    
    public void actualizarMontos()
    {
        Set set = propuestas.entrySet();
        Iterator iteradorsito = set.iterator();
        while (iteradorsito.hasNext()) {
            Map.Entry mentry = (Map.Entry) iteradorsito.next();
            Propuesta aux = (Propuesta) mentry.getValue();
            aux.actualizarMonto();
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
                    String destino = "Imagenes/Propusta/" + nickP + "." + termina;
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
                    System.out.println(est.getEst().toString() + est.getFecha().toString() + est.getHora().toString() + " ESTOOOOOOOOOOOoo");
                    // pe.getListaDeEstados().put(estActual.getEstado(), est);

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
    public boolean existeColaboracion(String nick, String titulo)
    {
        Propuesta p = (Propuesta) this.propuestas.get(titulo);
        Iterator iteradorsito = p.colaboraciones.iterator();
        while (iteradorsito.hasNext()) {
            
            Colaboracion aux = (Colaboracion) iteradorsito.next();
            if(aux.getColab().nick == nick)
                return true;
    }
        return false;
    }
    
    @Override
    public boolean altaColaboracion(Propuesta prop, Colaborador colab, String monto, String tipoR)
    {
        Date lul = new Date();
        String horita = java.time.LocalTime.now().toString();
        Colaboracion c = new Colaboracion(lul, tipoR, Integer.parseInt(monto), colab, prop, horita);
        
        if (dbPropuesta.agregarColaboracion(c))
        {
            this.colaboraciones.add(c);
            prop.addColab(c);
            colab.AddColab(c);
            prop.actualizarMonto();
            return true;
        }
        return false;
    }
    private String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("kkmmss");
        String currentTime = dateFormat.format(System.currentTimeMillis());
        return currentTime;
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

    public void cargarPropuestas() {
        this.propuestas = this.dbPropuesta.cargarPropuestas();
    }
    
    @Override
    public void cargarProp(){
        this.dbPropuesta.cargarPropuestasPrueba();
        this.dbE.agregarListPrueb();
        this.cargarPropuestas();
        this.dbPropuesta.colaboracionesPrueba();
        //this.cargarColaboraciones();
    }
    
    public void cargarColaboraciones()
    {
        this.colaboraciones = this.dbPropuesta.cargarColaboraciones();
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

    @Override
    public void CargaPropuestasPrueba() {
        Estado estA = new Estado(Testado.Ingresada);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        String[] fechas = {"2018-09-16", "2018-10-07", "2018-10-19", "2018-10-21", "2018-11-18", "2018-11-16", "2018-12-03", "2018-10-12"};
        String[] fechitap = {"2018-05-15", "2018-06-18", "2017-07-17", "2018-07-30", "2018-08-04", "2018-08-06", "2018-08-18", "2018-08-23"};
        String[] horas = {"15:30", "4:28", "15:30", "15:40", "12:20", "02:00", "02:40", "2:12"};
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
        
        Integer [] precio = {200, 300, 400, 1000, 800, 650, 350, 0};
        String [] retornos = {"porcentaje", "entrada, porcentaje", "porcentaje", "entrada, porcentaje", "porcentaje", "entrada, porcentaje", "entrada", "porcentaje"};
        Integer [] montos = {150000, 300000, 400000, 900000, 750000, 300000, 175000, 100000};
        String [] categorias = {"Cine al Aire Libre", "Parodistas", "Concierto", "Festival", "Ballet", "Murga", "Teatro Dramático", "Festival"};
        String [] imagenes = {"", "Prueba\\Propuesta\\mom.jpg", "Prueba\\Propuesta\\pim.jpg", "Prueba\\Propuesta\\pil.jpg","Prueba\\Propuesta\\ryj.jpg","Prueba\\Propuesta\\udj.jpg","",""};
        String [] proponente = {"Diego (diegop)", "Horacio (hrubino)", "Martín (mbusca)", "Kairo(kairoh)", "Julio(juliob)", "Tabaré(tabarec)", "Héctor(hectorg)", "Itendencia(durazno)"};
        String [] lugares = {"Jardín Botánico", "Teatro de Verano", "Teatro Solís", "Rural de Prado", "Auditorio Nacional del Sodre", "Landia", "Teatro el Galpón", "Durazno"};
        for(int i =0; i<8; i++){
            try {
                Date fechaHace = sd.parse(fechas[i]);
                Date publicada = sd.parse(fechitap[i]);
                this.AgregarPropuesta(titulos[i], descripciones[i], fechaHace, precio[i], 0, publicada, retornos[i], montos[i], categorias[i], estA, imagenes[i], proponente[i], horas[i], lugares[i]);
            } catch (ParseException ex) {
                Logger.getLogger(ctrlPropuesta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    public DtPropuesta SeleccionarProp(String xTitulo) // error 
    {
    Propuesta pro = this.propuestas.get(xTitulo);
    DtPropuesta X = new DtPropuesta(pro,pro.getCate());
    this.propuestaconsulta = pro;
    return X; 
    }
    
    
    @Override
    public List<String> NombrePropoConsulta(){
        
        return this.propuestaconsulta.NombreColaborantes();
        
    };
    
    
    @Override
    public List<String> ListarProp(){
    List<String> Nicks = new ArrayList<String>();
    Set set = propuestas.entrySet();
    Iterator iterator = set.iterator();
    while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
            Propuesta aux=(Propuesta) mentry.getValue();
            if (aux != null){
            Nicks.add(aux.getTitulo()); 
            }
        }       
        return Nicks;
};
 
    @Override
    public List<String> ColaborantesDePro(){
        List<String> Nicks = new ArrayList<String>();
        Iterator iteradorsito = colaboraciones.iterator();
        while (iteradorsito.hasNext()) {
            Colaboracion aux = (Colaboracion) iteradorsito.next();
            if(aux.getProp().getTitulo().equals(this.propuestaconsulta.getTitulo())){
                String N = aux.getColab().getNombre() +"("+ aux.getColab().getNick()+")";
                Nicks.add(N); 
            }
    }
    this.propuestaconsulta = null;    
    return Nicks;
    };
    
    @Override
     public void EstadosPropuestas(){
        Set set = propuestas.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
        Map.Entry mentry = (Map.Entry)iterator.next();
            Propuesta aux=(Propuesta) mentry.getValue();
            this.dbE.SetearEstadoPropuesta(aux);
        }       
     };
}
