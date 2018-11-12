/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.awt.AWTKeyStroke;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import Logica.Colaborador;
import Logica.Proponente;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Comparator;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import config.Utils;
import java.util.Properties;

/**
 *
 * @author Luchi
 */
public class ctrlUsuario implements IUsuario {

    private static ctrlUsuario instancia;
    private Map<String, Usuario> usuarios;
    private Map<String, Proponente> Proponentes;
    private String usuRec;
    private String usuAseguir;
    private Colaborador ColaboradorConsulta = null;
   

    private DBusuario usu = null;

    public static ctrlUsuario getInstance() {
        if (instancia == null) {
            instancia = new ctrlUsuario();
        }
        return instancia;
    }

    private ctrlUsuario() {
        this.usuarios = new HashMap<String, Usuario>();
        this.Proponentes = new HashMap<String, Proponente>();
        this.usu = new DBusuario();
    }

  
    @Override
    public boolean altaColaborador(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String tipo, String pass) {
     Properties pr= Utils.getPropiedades();
        
        
        if (this.existe(Nick, Correo) == false) {
            return false;
        } else {
            if (Imagen.equals("") == false) {
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
               String rutaSistema= System.getProperty("user.dir")+"\\";          
                String dest=rutaSistema+pr.getProperty("imagenes")+pr.getProperty("colaborador");
                String destino = dest + Nick + "." + termina;
                //String destino = "Imagenes/Colaborador/" + Nick + "." + termina;

                if (this.copia(Imagen, destino) == true) {
                    Imagen = destino;
                } else {
                    Imagen = null;
                }
            }
            String nuevo = this.sha1(pass);
            Colaborador c = new Colaborador(Nick, Nombre, Apellido, Correo, fecha, Imagen, tipo, nuevo);
            boolean res = this.usu.agregarColaborador(c);
            if (res) {
                this.usuarios.put(Nick, c);
            }
            return res;
        }
    }
    
    @Override
public List<DtUsuario> listaNC(String txt) {
        List<DtUsuario> prop = new ArrayList<>();
        Set set = usuarios.entrySet();
        Iterator it = set.iterator();
        boolean esta = false;
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Usuario aux = (Usuario) mentry.getValue();
            
            if(aux instanceof Proponente){
            Proponente propo = (Proponente) aux;        
            if(propo.getActivo()==true){
                
          
            if (propo.getNick().contains(txt) == true) {
                DtUsuario da = this.traerDtUsuario(propo.getNick());
                prop.add(da);
                esta = true;
            }

            if (propo.getCorreo().contains(txt) == true && !esta) {
                 DtUsuario da = this.traerDtUsuario(propo.getNick());
                prop.add(da);
                esta = true;
            }
            esta = false;
              }
             }else{
               if (aux.getNick().contains(txt) == true) {
                DtUsuario da = this.traerDtUsuario(aux.getNick());
                prop.add(da);
                esta = true;
            }

            if (aux.getCorreo().contains(txt) == true && !esta) {
                 DtUsuario da = this.traerDtUsuario(aux.getNick());
                prop.add(da);
                esta = true;
            }  
            }
        }
        return prop;
    }
    @Override
    public Colaborador traerColaborador(String f) {
        Colaborador fa = (Colaborador) this.usuarios.get(f);
        return fa;
    }

    @Override
    public Proponente traerProponente(String f) {
        Proponente p = (Proponente) this.usuarios.get(f);
        return p;
    }

    @Override
    public boolean yaSigue() {
        Usuario u = this.usuarios.get(this.usuRec);
        Usuario aSeguir = this.usuarios.get(this.usuAseguir);

        Map<String, Usuario> listita = new HashMap<>();
        listita = u.getUsuSeguidos();
        if (listita.get(aSeguir.getNick()) != null) {
            return true;
        }

        Set se = listita.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Usuario aux = (Usuario) mentry.getValue();
            if ((aSeguir.getNick().equals(aux.getSeguido())) == true) {
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean seguirUsuario() {

        Usuario u = this.usuarios.get(this.usuRec);
        Usuario aSeguir = this.usuarios.get(this.usuAseguir);

        if (u instanceof Colaborador) {
            if (aSeguir instanceof Colaborador) {
                this.usu.seguirCC(u.getNick(), aSeguir.getNick());
                u.seguirUsuario(aSeguir);
                return true;
            } else if (aSeguir instanceof Proponente) {
                this.usu.seguirCP(u.getNick(), aSeguir.getNick());
                u.seguirUsuario(aSeguir);
                return true;
            }

        }

        if (u instanceof Proponente) {
            if (aSeguir instanceof Proponente) {
                this.usu.seguirPP(u.getNick(), aSeguir.getNick());
                u.seguirUsuario(aSeguir);
                return true;
            } else if (aSeguir instanceof Colaborador) {
                this.usu.seguirPC(u.getNick(), aSeguir.getNick());
                u.seguirUsuario(aSeguir);
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean dejarDeSeguir() {
        Usuario u = this.usuarios.get(this.usuRec);
        Usuario aSeguir = this.usuarios.get(this.usuAseguir);

        if (u instanceof Colaborador) {
            if (aSeguir instanceof Colaborador) {
                this.usu.dejarSeguirCC(u.getNick(), aSeguir.getNick());
                return u.dejarDeSeguir(aSeguir);
            } else if (aSeguir instanceof Proponente) {
                this.usu.dejarSeguirCP(u.getNick(), aSeguir.getNick());
                return u.dejarDeSeguir(aSeguir);
            }

        }

        if (u instanceof Proponente) {
            if (aSeguir instanceof Proponente) {
                this.usu.dejarSeguirPP(u.getNick(), aSeguir.getNick());
                return u.dejarDeSeguir(aSeguir);
            } else if (aSeguir instanceof Colaborador) {
                this.usu.dejarSeguirPC(u.getNick(), aSeguir.getNick());
                return u.dejarDeSeguir(aSeguir);
            }

        }

        return false;
    }

    @Override
    public List<DtUsuario> traerSeguidos(String nick) {
        List<DtUsuario> usuarios = new ArrayList<>();
        Usuario u = this.usuarios.get(nick);
        Map<String, Usuario> listaSeguidos = u.getUsuSeguidos();
        Set se = listaSeguidos.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Usuario us = (Usuario) mentry.getValue();
            System.out.println(us.getNick());
            DtUsuario usuarito = this.traerDtUsuario(us.getNick());
            if (us instanceof Proponente){          // agregado
                if(((Proponente) us).getActivo()){  // agregado
                usuarios.add(usuarito);
                }
            }
        }
        return usuarios;
    }

    @Override
    public List<DtUsuario> traerSeguidores(String nick) {
        List<DtUsuario> seguidores = new ArrayList<>();
        Set se = this.usuarios.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            Usuario aux = (Usuario) mentry.getValue();
            if (!aux.getNick().equals(nick)) {
                List<DtUsuario> seguidosdeAux = this.traerSeguidos(aux.getNick());
                for (int i = 0; i < seguidosdeAux.size(); i++) {
                    DtUsuario user = seguidosdeAux.get(i);
                    if (user != null) {

                        if (user.getNick().equals(nick)) {
                            DtUsuario seguidor = this.traerDtUsuario(aux.getNick());
                            //seguidores.add(seguidor);
                            if (aux instanceof Proponente) {             // agregado
                                if (((Proponente) aux).getActivo()) {    // agregado
                                    seguidores.add(seguidor);
                                }
                            }
                        }
                    }
                }

            }

        }
        return seguidores;
    }

    @Override
    public void seleccionarUsuario(String nick) {
        this.usuRec = nick;
    }

    @Override
    public void seleccionarUsuSeg(String nick) {
        this.usuAseguir = nick;
    }

    @Override
    public List<DtProponente> listarProponentes() {
        List<DtProponente> listita = new ArrayList<>();
        Set se = usuarios.entrySet();
        Iterator iterator = se.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Proponente) {

                Proponente aux = (Proponente) mentry.getValue();
                if (aux.getActivo()){   //agregado
                listita.add(aux.obtenerInfo());
            }
            }
        }
        return listita;
        //return this.List_DtProponente_Eliminar_Desactivado(listita);
    }

    @Override
    public boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo, String pass) {
      Properties pr= Utils.getPropiedades();
        
        if (this.existe(Nick, Correo) == false) {
            return false;
        } else {
            if (Imagen.equals("") == false) {
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String rutaSistema= System.getProperty("user.dir")+"\\";
String dest=rutaSistema+pr.getProperty("imagenes")+pr.getProperty("proponente");
                String destino = dest + Nick + "." + termina;

  

                if (this.copia(Imagen, destino) == true) {
                    Imagen = destino;
                } else {
                    Imagen = null;
                }

            }
            String nuevo = this.sha1(pass);
            Proponente p = new Proponente(Nick, Nombre, Apellido, Correo, fecha, Imagen, direccion, biografia, web, tipo, nuevo, true, null);
            boolean res = this.usu.agregarProponente(p);
            if (res) {
                this.usuarios.put(Nick, p);
            }
            return res;
        }
    }

    public boolean existe(String nick, String correo) {
        for (Usuario usu : this.usuarios.values()) {
            if (usu.getNick().equals(nick)) {
                return false;
            }
            if (usu.getCorreo().equals(correo)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean copia(String origen, String destino) {
        try {
            File aor = new File(origen);
            File ade = new File(destino);
            ade.getParentFile().mkdirs();
            if (ade.createNewFile()) {
                System.out.println("Se crea");
            }
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            String algo = ex.toString();
            return false;
        }
    }

    @Override
    public void cargarProponentes() {
        this.usuarios = this.usu.cargarProponentes();

    }

    public void borrarArch(File f) {
        File[] arch = f.listFiles();
        if (arch.length > 0) {
            for (int i = 0; i < arch.length; i++) {
                arch[i].delete();
            }
        }
    }

    @Override
    public void limpiarUsuarios() {
        
        Properties p=Utils.getPropiedades();
      String rutaSistema= System.getProperty("user.dir")+"\\";
        String img=p.getProperty("imagenes");
        String colab=p.getProperty("colaborador");
        String propu=p.getProperty("propuesta");
        String propo=p.getProperty("proponente");
        
        try {
            this.usu.limpiarBase();
            File borrar = new File(rutaSistema+img+colab);
            if (borrar.exists()) {
                this.borrarArch(borrar);
            }
            File borrar1 = new File(rutaSistema+img+propo);
            if (borrar1.exists()) {
                this.borrarArch(borrar1);
            }
            File borrar2 = new File(rutaSistema+img+propu);
            if (borrar2.exists()) {
                this.borrarArch(borrar2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void cargarPropPrueba() {
        this.usu.cargarProponentesPrueba();
        this.usu.CargarColabPrueba();
        this.cargarUsuarios2();
        this.usu.seguirCPprueb();
        this.usu.seguirCCPrueb();
        this.usu.seguirPCPrueb();
        this.usu.seguirPPprueb();
        this.cargarSeg(usuarios);
    }

    @Override
    public void cargarColaboradores() {
//        this.colaboradores = this.usu.cargarColaboradores();
    }

    @Override
    public List<DtProponente> listarUsuario() {
        List<DtProponente> retorna = new ArrayList<>();
        // DtCategoria nuevo=null;
        Set se = Proponentes.entrySet();
        Iterator iterator = se.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            Proponente aux = (Proponente) mentry.getValue();
            retorna.add(aux.obtenerInfo());
        }
        return retorna;
    }

    @Override
    public List<DtColaborador> listarColaboradores() {
        List<DtColaborador> listita = new ArrayList<>();
        Set se = this.usuarios.entrySet();
        Iterator iterator = se.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Colaborador) {
                Colaborador aux = (Colaborador) mentry.getValue();

                listita.add(aux.obtenerInfo());
            }
        }
        return listita;
    }

    @Override
    public List<DtUsuario> listarUsuarios() {
        List<DtUsuario> lista = new ArrayList<>();
        List<DtColaborador> colab = this.listarColaboradores();
        List<DtProponente> prop = this.listarProponentes();
        boolean a = lista.addAll(colab);
        boolean b = lista.addAll(prop);

        if (a && b) {
            // Collections.sort(lista, new Sortbyroll());

            Collections.sort(lista, (c, d) -> {
                return c.getNombre().compareTo(d.getNombre());

            });
            return lista;
        }
        return lista;
    }

    @Override
    public List<DtColaboracion> datosCol(Colaborador a) {
        List<DtColaboracion> listita = new ArrayList<>();
        List<Colaboracion> listitaC = new ArrayList<>();

        listitaC = a.getColHechas();
        for (int i = 0; i < listitaC.size(); i++) {
            DtPropuesta prop = new DtPropuesta(listitaC.get(i).getProp());
            DtColaboracion cola = new DtColaboracion(prop);
            if(this.traerProponente(listitaC.get(i).getProp().getPropo()).getActivo()){ // agregado
            listita.add(cola);
            }
        }
        return listita;
    }

    @Override
    public boolean escorreo(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existeNick(String nick) {

        for (Usuario u : this.usuarios.values()) {
            if (u.getNick().equalsIgnoreCase(nick)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Usuario traerUsuario(String nick) {
        for (Usuario u : this.usuarios.values()) {
            if (u.getNick().equalsIgnoreCase(nick) || u.getCorreo().equalsIgnoreCase(nick)) {
                return u;
            }
        }
        return null;

    }

    @Override
    public DtUsuario traerDtUsuario(String nick) {
        DtProponente prop = null;
        DtColaborador colab = null;
        for (Usuario u : this.usuarios.values()) {
            if (u.getNick().equalsIgnoreCase(nick) || u.getCorreo().equalsIgnoreCase(nick)) {
                if (u instanceof Proponente) {
                    prop = new DtProponente(u.getNick(), u.getCorreo(), u.getCont(), u.getNombre(), u.getApellido(), u.getImg(), ((Proponente) u).getLinkWeb(), ((Proponente) u).getDireccion(), ((Proponente) u).getBiografia(), u.getFecha());

                    return prop;
                } else if (u instanceof Colaborador) {
                    colab = new DtColaborador(u.getNick(), u.getCorreo(), u.getCont(), u.getNombre(), u.getFecha(), u.getApellido(), u.getImg());
                    return colab;
                }
            }
        }
        return null;
    }

    @Override
    public List<DtPropuesta> traerPropFav(String nick) {
        List<DtPropuesta> propuestas = new ArrayList<>();
        Usuario u = this.traerUsuario(nick);
        Map<String, Propuesta> otras = u.getPropuFav();
        Set se = otras.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            DtPropuesta prop = new DtPropuesta((Propuesta) mentry.getValue());
         Usuario propoACargo= this.traerUsuario(prop.getPropo());
         Proponente propon = (Proponente) propoACargo;
         if(propon.getActivo()==true){
            propuestas.add(prop);
             }
        }
        return propuestas;
    }

    @Override
    public List<DtColaboracion> traerPropuestasColaboradas(String nick) {
        List<DtColaboracion> propuestas = new ArrayList<>();
        Colaborador colab = this.traerColaborador(nick);
        List<Colaboracion> colaboraciones = colab.getColHechas(); 
        for (int i = 0; i < colaboraciones.size(); i++) {
            Colaboracion col = (Colaboracion) colaboraciones.get(i);
            Propuesta prop = col.getProp();
            DtPropuesta pro = new DtPropuesta(prop);
            DtColaborador cola = new DtColaborador(col.getColab().getNick(), col.getColab().getNombre(), col.getColab().getApellido(), col.getColab().getCorreo(), col.getColab().getFecha(), col.getColab().getImg());
            DtColaboracion ma = new DtColaboracion(col.getHora(), col.getFecha(), col.getMonto(),cola, pro);
            propuestas.add(ma);
        }
        return propuestas;
    }
        public List<DtColaboracion> traerPropuestasColaboradasNoPagas(String nick) {
        List<DtColaboracion> propuestas = new ArrayList<>();
        Colaborador colab = this.traerColaborador(nick);
        List<Colaboracion> colaboraciones = colab.getColHechas(); 
        for (int i = 0; i < colaboraciones.size(); i++) {
         
            Colaboracion col = (Colaboracion) colaboraciones.get(i);
               if(!(ctrlPropuesta.getInstance().pago(col.getProp().getTitulo(),col.getColab().getNick()))){
            Propuesta prop = col.getProp();
            DtPropuesta pro = new DtPropuesta(prop);
            DtColaborador cola = new DtColaborador(col.getColab().getNick(), col.getColab().getNombre(), col.getColab().getApellido(), col.getColab().getCorreo(), col.getColab().getFecha(), col.getColab().getImg());
            DtColaboracion ma = new DtColaboracion(col.getHora(), col.getFecha(), col.getMonto(),cola, pro);
            propuestas.add(ma);
               }
        }
        return propuestas;
    }


    public DtInfo resolverLogin(String nick, String pass) {
        DtInfo resultado = new DtInfo(false, "algo", "algo", "algo");
        String passEncriptada = sha1(pass);
        DtUsuario user = this.traerDtUsuario(nick);
        DtProponente prop = null;
        DtColaborador colab = null;
        boolean valido = false;

        if (user instanceof DtColaborador) {
            colab = (DtColaborador) user;
            String cadena1 = colab.getNombre();
            String cadena2 = colab.getApellido();
            String cadena3 = " ";
            String cadena4 = cadena1.concat(cadena3);
            String cadena5 = cadena4.concat(cadena2);
            if (this.escorreo(nick)) {
                if (this.existeCorreo(nick)) {
                    //no existe direccion de correo en sistema
                    resultado.setEstLogin(false);
                    resultado.setMensaje("No existe la dirección de correo ingresada en el sistema");

                } else {
                    if (colab.getPass().equals(passEncriptada)) {

                        resultado.setEstLogin(true);
                        resultado.setMensaje(cadena5);
                        resultado.setTipo("colaborador");
                        resultado.setNick(colab.getNick());

                    } else {
                        resultado.setEstLogin(false);
                        resultado.setMensaje("La contraseña ingresada es incorrecta");

                    }
                }
            } else if (this.existeNick(nick)) {
                //no existe el usuario en el sistema con ese nick
                resultado.setEstLogin(false);

                resultado.setMensaje("No existe un usuario en el sistema con ese nick");

            } else {
                if (colab.getPass().equals(passEncriptada)) {

                    resultado.setEstLogin(true);
                    resultado.setMensaje(cadena5);
                    resultado.setNick(colab.getNick());
                    resultado.setTipo("colaborador");
                    //ingresa bien
                } else {
                    //la contraseña ingresada es incorrecta
                    resultado.setEstLogin(false);
                    resultado.setMensaje("La contraseña ingresada es incorrecta");

                }
            }

        } else if (user instanceof DtProponente) {
            prop = (DtProponente) user;
            String cadena1 = prop.getNombre();
            String cadena2 = prop.getApellido();
            String cadena3 = " ";
            String cadena4 = cadena1.concat(cadena3);
            String cadena5 = cadena4.concat(cadena2);
            if (this.escorreo(nick)) {
                if (this.existeCorreo(nick)) {
                    //no existe la direccion de correo ingresada en el sistema
                    resultado.setEstLogin(false);
                    resultado.setMensaje("No existe la dirección de correo ingresada en el sistema");

                } else {
                    if (prop.getPass().equals(passEncriptada)) {
 Usuario nuevo=this.traerUsuario(nick);             

Proponente nuevito=(Proponente) nuevo;
if(nuevito.getActivo()==false){
      resultado.setEstLogin(false);
}else{
                        resultado.setEstLogin(true);
                        resultado.setMensaje(cadena5);
                        resultado.setNick(prop.getNick());
                        resultado.setTipo("proponente");
}   } else {
                        //la contraseña ingresada es incorrectafas
                        resultado.setEstLogin(false);
                        resultado.setMensaje("La contraseña ingresada es incorrecta");
                    }
                }
            } else if (this.existeNick(nick)) {
                //No existe un usuario en el sistema con ese nick
                resultado.setEstLogin(false);
                resultado.setMensaje("No existe un usuario en el sistema con ese nick");

            } else {
                if (prop.getPass().equals(passEncriptada)) {
       Usuario nuevo=this.traerUsuario(nick);             

Proponente nuevito=(Proponente) nuevo;
if(nuevito.getActivo()==false){
      resultado.setEstLogin(false);
}else{
    

                    resultado.setEstLogin(true);
                    resultado.setMensaje(cadena5);
                    resultado.setTipo("proponente");
                    resultado.setNick(prop.getNick());

               } } else {
                    resultado.setEstLogin(false);
                    resultado.setMensaje("La contraseña ingresada es incorrecta");

                }
            }

        } else {
            resultado.setEstLogin(false);
            if (this.escorreo(nick)) {
                resultado.setMensaje("El correo ingresado no existe en el sistema");
            } else {
                resultado.setMensaje("No existe un usuario en el sistema con ese nick");
            }
        }

        return resultado;
    }

    @Override
    public boolean existeCorreo(String correo) {

        for (Usuario u : this.usuarios.values()) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void cargarUsuarios2() {
        Map<String, Usuario> listita = new HashMap<>();
        listita.putAll(this.usu.cargarColaboradores());
        listita.putAll(this.usu.cargarProponentes());
        this.usuarios = listita;
        this.usuarios = this.cargarSeg(listita);
    }

    @Override
    public Map<String, Usuario> cargarSeg(Map<String, Usuario> lista) {
        List<Usuario> usuPP = new ArrayList<>();
        List<Usuario> usuPC = new ArrayList<>();
        List<Usuario> usuCC = new ArrayList<>();
        List<Usuario> usuCP = new ArrayList<>();
        Map<String, Usuario> nueva = new HashMap<>();

        nueva = lista;
        usuPP = this.usu.cargarSegPP();
        usuPC = this.usu.cargarSegPC();
        usuCC = this.usu.cargarSegCC();
        usuCP = this.usu.cargarSegCP();

        Set se = nueva.entrySet();

        Iterator it = se.iterator();

        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            if (mentry.getValue() instanceof Proponente) {
                Proponente aux = (Proponente) mentry.getValue();

                for (int i = 0; i < usuPP.size(); i++) {
                    Usuario auxPP = traerUsuario(usuPP.get(i).getSeguido()) ;
                    if (aux.getNick().equals(usuPP.get(i).getNick()) == true) {
                        aux.seguirUsuBD(auxPP);
                    }
                }

                for (int i = 0; i < usuPC.size(); i++) {
                    Usuario auxPC = traerUsuario(usuPC.get(i).getSeguido());
                    if (aux.getNick().equals(usuPC.get(i).getNick()) == true) {
                        aux.seguirUsuBD(auxPC);
                    }
                }

            } else if (mentry.getValue() instanceof Colaborador) {
                Colaborador aux2 = (Colaborador) mentry.getValue();

                for (int i = 0; i < usuCC.size(); i++) {
                    Usuario auxCC = traerUsuario(usuCC.get(i).getSeguido());
                    if (aux2.getNick().equals(usuCC.get(i).getNick()) == true) {
                        aux2.seguirUsuBD(auxCC);
                    }
                }

                for (int i = 0; i < usuCP.size(); i++) {
                    Usuario auxCP = traerUsuario(usuCP.get(i).getSeguido());
                    if (aux2.getNick().equals(usuCP.get(i).getNick()) == true) {
                        aux2.seguirUsuBD(auxCP);
                    }
                }

            }
        }

        return nueva;
    }

    @Override
    public void filtrarP(String campito, JList listita) {
        List<DtProponente> listita2 = this.listarProponentes();
        if (campito.equals("")) { // SI NO BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    DtProponente p = (DtProponente) listita2.get(i);
                    modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                }
                listita.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    DtProponente p = (DtProponente) listita2.get(i);
                    if (p.getNombre().contains(campito) || p.getNick().contains(campito)) {
                        modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                    }
                }
                listita.setModel(modelo);
            }
        }
    }

    @Override
    public void filtrarC(String campito, JList listita, List<Colaborador> listita2) {
        if (campito.equals("")) { // SI NO BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    Colaborador p = (Colaborador) listita2.get(i);
                    modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                }
                listita.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    Colaborador p = (Colaborador) listita2.get(i);
                    if (p.getNick().contains(campito) || p.getNombre().contains(campito)) {
                        modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                    }
                }
                listita.setModel(modelo);
            }
        }
    }

    @Override
    public boolean validaWeb(String algo) {
        if (algo.matches("(http://)(www\\.)(.+)(\\.)(.+)") || algo.matches("(www\\.)(.+)(\\.)(.+)") || algo.matches("(https://)(www\\.)(.+)(\\.)(.+)") || algo.matches("(http://)(.+)(\\.)(.+)") || algo.matches("(https://)(.+)(\\.)(.+)") || algo.equals("")) {
            return true;
        }
        return false;
    }

//    long ini = System.currentTimeMillis();
//    InputStream fuente = null;
    @Override
    public List<String> SeleccionarColaborante(String xNick) {
        Colaborador x = (Colaborador) usuarios.get(xNick);
        this.ColaboradorConsulta = x;
        List<String> nombresP = new ArrayList<>();
        List<Colaboracion> listitaC = new ArrayList<>();
        listitaC = x.getColHechas();
        for (int i = 0; i < listitaC.size(); i++) {
            // filtro aca
            if(this.traerProponente(listitaC.get(i).getProp().getPropo()).getActivo()){
            String name = listitaC.get(i).getProp().getTitulo();
            nombresP.add(name);
            }
        }
        return nombresP; 
    }

    ;
    

    @Override
    public DtColaboracion SeleccionarColaboracion(String xTitulo) {
        Colaborador x = this.ColaboradorConsulta;
        List<Colaboracion> listitaC = new ArrayList<>();
        listitaC = x.getColHechas();
        for (int i = 0; i < listitaC.size(); i++) {

            if (xTitulo.equals(listitaC.get(i).getProp().getTitulo())) {
                DtPropuesta prop = new DtPropuesta(listitaC.get(i).getProp());
                Tretorno re = new Tretorno();
                if (listitaC.get(i).getRetorno().equals("entrada")) {
                    re.gsetEntraada("entrada");
                } else {
                    re.gsetPorcentaje("porcentaje");
                }
                DtColaboracion colad = new DtColaboracion(listitaC.get(i).getHora(), listitaC.get(i).getFecha(), listitaC.get(i).getMonto(), re, null, prop);
                return colad; //colad
            }
        }
        return null;
    }

    ;
     
     
    @Override
    public DefaultListModel BUSCADOR_Colaborador(String Palabra) {
        DefaultListModel modelo = new DefaultListModel();
        List<DtColaborador> col = this.listarColaboradores();
        if (Palabra.equals("")) { // SI NO BUSCA
            if (!col.isEmpty()) {

                for (int i = 0; i < col.size(); i++) {
                    DtColaborador p = (DtColaborador) col.get(i);
                    modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                }
            }
        } else {                                // SI BUSCA
            if (!col.isEmpty()) {

                for (int i = 0; i < col.size(); i++) {
                    DtColaborador p = (DtColaborador) col.get(i);
                    if (p.getNick().contains(Palabra) || p.getNombre().contains(Palabra)) {
                        modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                    }
                }
            }
        }
        return modelo;
    }

    ;
     public DefaultListModel BUSCADOR_Proponente(String palabrita) {
        DefaultListModel modelo = new DefaultListModel();
        List<DtProponente> col = this.listarProponentes();
        if (palabrita.equals("")) { // SI NO BUSCA
            if (!col.isEmpty()) {

                for (int i = 0; i < col.size(); i++) {
                    DtProponente p = (DtProponente) col.get(i);
                    modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                }
            }
        } else {                                // SI BUSCA
            if (!col.isEmpty()) {

                for (int i = 0; i < col.size(); i++) {
                    DtProponente p = (DtProponente) col.get(i);
                    if (p.getNick().contains(palabrita) || p.getNombre().contains(palabrita)) {
                        modelo.addElement(p.getNombre() + "(" + p.getNick() + ")");
                    }
                }
            }
        }
        return modelo;
    }

    @Override
    public String encripta(String pass, String type) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(type);
            byte[] arreglo = md.digest(pass.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arreglo.length; ++i) {
                sb.append(Integer.toHexString((arreglo[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String sha1(String pass) {
        return this.encripta(pass, "SHA1");
    }
    String carpetaImagenes;

    @Override
    public void configurarParametros() {
         String tara2vos= System.getProperty("user.dir")+"\\"+"web";
        File ade = new File(tara2vos);
        if(!ade.exists()){
        ade.getParentFile().mkdirs();
        }
        this.carpetaImagenes = tara2vos;
    }

    private Map<String, DataImagen> imagenesMap = new HashMap<>();
    private static Logger LOG;

    @Override
    public List<DtPropuesta> TraerMisPropuestasF(String nick) {
        DtUsuario user = this.traerDtUsuario(nick);
        List<DtPropuesta> propuestas = new ArrayList<>();

        Proponente prop = this.traerProponente(nick);
        Map<String, Propuesta> propuestasAux = prop.getPropuestas();
        Set se = propuestasAux.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            DtPropuesta propuesta = new DtPropuesta((Propuesta) mentry.getValue());
            if (propuesta.getEstActual().getEstado().compareTo(Testado.Financiada) == 0) {
                propuestas.add(propuesta);
            }
        }
        return propuestas;
    }

    @Override
    public List<DtPropuesta> TraerTodasPropuestas(String nick) {
        DtUsuario user = this.traerDtUsuario(nick);
        List<DtPropuesta> propuestas = new ArrayList<>();
        Proponente prop = this.traerProponente(nick);
        if(prop.getActivo()==true){
            
        
        Map<String, Propuesta> propuestasAux = prop.getPropuestas();
        Set se = propuestasAux.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            DtPropuesta propuesta = new DtPropuesta((Propuesta) mentry.getValue());
            if (!(propuesta.getEstActual().getEstado().equals(Testado.Ingresada))) {
                propuestas.add(propuesta);
            }
        }
        }
        return propuestas;
    }

    @Override
    public List<DtPropuesta> TraerTodasPropuestasIng(String nick) {
        DtUsuario user = this.traerDtUsuario(nick);
        List<DtPropuesta> propuestas = new ArrayList<>();
        Proponente prop = this.traerProponente(nick);
        if(prop.getActivo()==true){
            
        
        Map<String, Propuesta> propuestasAux = prop.getPropuestas();
        Set se = propuestasAux.entrySet();
        Iterator it = se.iterator();
        while (it.hasNext()) {
            Map.Entry mentry = (Map.Entry) it.next();
            DtPropuesta propuesta = new DtPropuesta((Propuesta) mentry.getValue());
            if (propuesta.getEstActual().getEstado().equals(Testado.Ingresada)) {
                propuestas.add(propuesta);
            }
        }
        }
        return propuestas;
    }

    @Override
    public String agregarImagen(String nick1, DataImagen img, String pass) {
        DtUsuario imagenUsuario = new DtUsuario(nick1, img, pass);
        LOG = Logger.getLogger(this.getClass().getPackage().getName());
        String nick = imagenUsuario.getNick();
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
        final DataImagen imagen = imagenUsuario.getImagen();
        pathStr = pathStr + File.separatorChar + imagen.getNombreArchivo() + "." + imagen.getExtensionArchivo();
        Path path = Paths.get(pathStr);
        try {
            Files.write(path, imagen.getStream(), CREATE);
        } catch (IOException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "Archivo guardado:{0}", pathStr);
        return pathStr;
    }

    @Override
    public byte[] retornarImagen(final String nick) {
        /*if (!this.credencialesMap.keySet().contains(email)){
                         throw new UsuarioNoEncontradoException(email);
                }*/
        for (Usuario usu : usuarios.values()) {
            if (usu.getNick().equals(nick)) {
                String pat = usu.getImg();
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
    
    @Override
    public dataListUsuarios listaNC2(String txt)
    {
        dataListUsuarios datatype = new dataListUsuarios(listaNC(txt));
        return datatype;
    }
    
    @Override
    public dataListUsuarios traerSeguidos2(String nick)
    {
        dataListUsuarios datatype = new dataListUsuarios(traerSeguidos(nick));
        return datatype;
    }
    
    @Override
    public dataListUsuarios traerSeguidores2(String nick)
    {
        dataListUsuarios datatype = new dataListUsuarios(traerSeguidores(nick));
        return datatype;
    }
    
    @Override
    public dataListProponentes listarProponentes2()
    {
        dataListProponentes datatype = new dataListProponentes(listarProponentes());
        return datatype;
    }
    
    @Override
    public dataListProponentes listarUsuario2()
    {
        
        dataListProponentes datatype = new dataListProponentes(listarUsuario());
        return datatype;
    }
    
    @Override
    public dataListColaboradores listarColaboradores2()
    {
        dataListColaboradores datatype = new dataListColaboradores(listarColaboradores());
        return datatype;
    }
    
    @Override
    public dataListUsuarios listarUsuarios2()
    {
        List<DtUsuario> listita = new ArrayList<>();
        if(this.usuarios.isEmpty())
        {
            DtColaborador prueba = new DtColaborador("xD3", "xDD3", "xDDD3", "xDDDD3", "xDDDDD3");
        listita.add(prueba);
        }
        else
        {
        Set se = this.usuarios.entrySet();
        Iterator iterator = se.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if (mentry.getValue() instanceof Proponente) {

                Proponente aux = (Proponente) mentry.getValue();
                if(aux.getActivo()==true){
                    
               
                DtProponente lol = new DtProponente(aux.getNick(), aux.getImg() ,aux.getBiografia() ,aux.getLinkWeb(), aux.getDireccion(),aux.getNombre(),aux.getApellido(), aux.getCorreo());
                listita.add(lol);
            } }
            else
            {
                Colaborador aux = (Colaborador) mentry.getValue();
                DtColaborador lol = new DtColaborador(aux.getNick(), aux.getCorreo(), aux.getCont(), aux.getNombre(),aux.getApellido());
                listita.add(lol);
            }
        }
        }
        Collections.sort(listita, (c, d) -> {
        return c.getNombre().compareTo(d.getNombre());
            });
        dataListUsuarios datatype = new dataListUsuarios(listita);
        return datatype;
    }
    
    public dataListColaboraciones datosCol2(Colaborador a)
    {
        dataListColaboraciones datatype = new dataListColaboraciones(datosCol(a));
        return datatype;
    }
    
    public dataListPropuestas traerPropFav2(String nick)
    {
        dataListPropuestas datatype = new dataListPropuestas(traerPropFav(nick));
        return datatype;
    }
    
    public dataListColaboraciones traerPropuestasColaboradas2(String nick)
    {
        dataListColaboraciones datatype = new dataListColaboraciones(traerPropuestasColaboradas(nick));
        return datatype;
    }
     public dataListColaboraciones traerPropuestasColaboradasNoPagas2(String nick)
    {
        dataListColaboraciones datatype = new dataListColaboraciones(traerPropuestasColaboradasNoPagas(nick));
        return datatype;
    }
    public dataListStrings seleccionarColaborante2(String nick)
    {
        dataListStrings datatype = new dataListStrings(SeleccionarColaborante(nick));
        return datatype;
    }
    
    public dataListPropuestas traerMisPropuestasF2(String nick)
    {
        dataListPropuestas datatype = new dataListPropuestas(TraerMisPropuestasF(nick));
        return datatype;
    }
    
    public dataListPropuestas TraerTodasPropuestas2(String nick)
    {
        dataListPropuestas datatype = new dataListPropuestas(TraerTodasPropuestas(nick));
        return datatype;
    }
    
    public dataListPropuestas TraerTodasPropuestasIng2(String nick)
    {
        dataListPropuestas datatype = new dataListPropuestas(TraerTodasPropuestasIng(nick));
        return datatype;
    }
    
    public void desactivarProp(String nick)
    {
        Usuario nuevo = this.usuarios.get(nick);
        if(nuevo instanceof Proponente)
        {
            Date nueva_fecha = new Date();
            Proponente prop = (Proponente) nuevo;
            prop.setActivo(false);
            prop.setFecha_des(nueva_fecha);
             this.usu.desactivarProponente(nick, nueva_fecha);
        }
       
    }
    
    public int contarSeguidores(String nick)
    {
        return this.traerSeguidores(nick).size();
    }
    
    public List<DtUsuario> rankingUser()
    {
        List<DtUsuario>lista = this.listarUsuarios2().getListita();
        Collections.sort(lista, (DtUsuario dt1, DtUsuario dt2) -> this.contarSeguidores(dt2.getNick()) - this.contarSeguidores(dt1.getNick()));
        return lista;
    }
    
    public dataListUsuarios rankingUser2()
    {
        dataListUsuarios datatype = new dataListUsuarios(rankingUser());
        return datatype;
    }
    
    public DtProponente traerDtProponente(String nick)
    {
        Proponente p = (Proponente) this.usuarios.get(nick);
        DtProponente xD = new DtProponente(p.getNick(), p.getCorreo(), p.getCont(), p.getNombre(), p.getApellido(), p.getImg(),p.getLinkWeb(), p.getDireccion(), p.getBiografia(), p.getFecha());
        return xD;
    }
    
    
    @Override
    public DtPath Path_A_DT(Path dts){
        DtPath lista = new DtPath(dts);
        return lista;
    };
    
    @Override
    public DataImagen Crear_DataImagen(final byte[] stream, final String nombreArchivo, final String extensionArchivo){
        DataImagen imagen = new DataImagen(stream, nombreArchivo, extensionArchivo);
        return imagen;
    };
    
    public boolean Existe_Proponente (String nick){ 
        Usuario A = usuarios.get(nick);
        if (A instanceof Proponente){
            return true;
        }
        else 
            return false;
    }; 
    
//    @Override
//    public List<DtProponente> List_DtProponente_Eliminar_Desactivado(List<DtProponente> lista){
//        int x = lista.size();
//        List<DtProponente> aux = lista;
//        for (int i = 0; i < x; i++) {
//            //if (this.Existe_Proponente(lista.get(i).getNick())){ // Todos deberian de ser proponentes
//                int c = lista.size();
//                Proponente P = (Proponente) this.traerProponente(lista.get(i).getNick());
//                if (!P.getActivo()) {                                           // Si esta desactivado 
//                    aux.remove(lista.get(i));                                 // lo saco de la lista
//                }
//            //}
//        }
//    return aux;
//    };
    
//    @Override
//    public List<DtColaboracion> List_DtColaboracio_Eliminar_Desactivado(List<DtColaboracion> lista){
//        int x = lista.size();
//        for (int i = 0; i < x; i++){
//            if(!this.traerProponente(lista.get(i).getPropuesta().getPropo()).getActivo()){
//                lista.remove(i);
//            }
//        }
//        return lista;
//    };
    
    
//    public List<DtUsuario> List_DtUsuario_Eliminar_Desactivado(List<DtUsuario> lista){
//        int x = lista.size();
//        for (int i = 0; i < x; i++) {
//            if (this.Existe_Proponente(lista.get(i).getNick())){ 
//                Proponente P = (Proponente) this.traerProponente(lista.get(i).getNick());
//                if (!P.getActivo()) {                                           // Si esta desactivado 
//                    lista.remove(lista.get(i));                                 // lo saco de la lista
//                }
//            }
//        }
//    return lista;
//    };
}
