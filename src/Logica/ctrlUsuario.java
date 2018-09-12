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


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import Logica.Colaborador;
import Logica.Proponente;
import java.security.NoSuchAlgorithmException;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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
        if (this.existe(Nick, Correo) == false) {
            return false;
        } else {
            if (Imagen.equals("") == false) {
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String destino = "Imagenes/Colaborador/" + Nick + "." + termina;
                if (this.copia(Imagen, destino) == true) {
                    Imagen = destino;
                } else {
                    Imagen = null;
                }
            }
//            String nuevo = this.sha1(pass);
            Colaborador c = new Colaborador(Nick, Nombre, Apellido, Correo, fecha, Imagen, tipo, pass);
            boolean res = this.usu.agregarColaborador(c);
            if (res) {
                this.usuarios.put(Nick, c);
            }
            return res;
        }
    }
     @Override
    public Colaborador traerColaborador(String f)
    {
        Colaborador fa = (Colaborador) this.usuarios.get(f);
        return fa;
    }
    
    
    public Proponente traerProponente(String f)
    {
        Proponente p = (Proponente) this.usuarios.get(f);
        return p;
    }
    
    
    
    
    
    
    @Override
    public boolean yaSigue(){
     Usuario u= this.usuarios.get(this.usuRec);
     Usuario aSeguir = this.usuarios.get(this.usuAseguir);
     
     Map<String,Usuario> listita=new HashMap<>();
     listita = u.getUsuSeguidos();
        if(listita.get(aSeguir.getNick())!=null){
        return true;
    }
    
     Set se=listita.entrySet();
     Iterator it = se.iterator();
     while(it.hasNext()){
         Map.Entry mentry = (Map.Entry) it.next();
         Usuario aux= (Usuario) mentry.getValue();
         if((aSeguir.getNick().equals(aux.getSeguido()))==true){
          return true;   
         }
         
     }
     
          
//    if(u.getNick().equals(aSeguir.getNick())){
//        return true;
//    }
     return false;
    }
    
     @Override
    public boolean seguirUsuario(){
 
        Usuario u= this.usuarios.get(this.usuRec);
        Usuario aSeguir=this.usuarios.get(this.usuAseguir);
          
          if(u instanceof Colaborador){
              if(aSeguir instanceof Colaborador){
                  this.usu.seguirCC(u.getNick(), aSeguir.getNick());
                    u.seguirUsuario(aSeguir);
                    return true;
              }
              else if(aSeguir instanceof Proponente){
                  this.usu.seguirCP(u.getNick(), aSeguir.getNick());
                   u.seguirUsuario(aSeguir);
                   return true;
              }
              
          }
          
          if(u instanceof Proponente){
            if(aSeguir instanceof Proponente){
                this.usu.seguirPP(u.getNick(), aSeguir.getNick());
                u.seguirUsuario(aSeguir);
                return true;
            }
            else if(aSeguir instanceof Colaborador){
                this.usu.seguirPC(u.getNick(), aSeguir.getNick());
                 u.seguirUsuario(aSeguir);
                 return true;
            }
              
          }

 
    
         return false;       
    }
    
    @Override
    public boolean dejarDeSeguir(){
         Usuario u=this.usuarios.get(this.usuRec);
        Usuario aSeguir=this.usuarios.get(this.usuAseguir);
          
          if(u instanceof Colaborador){
              if(aSeguir instanceof Colaborador){
                  this.usu.dejarSeguirCC(u.getNick(), aSeguir.getNick());
                   return u.dejarDeSeguir(aSeguir);
              }
              else if(aSeguir instanceof Proponente){
                  this.usu.dejarSeguirCP(u.getNick(), aSeguir.getNick());
                   return u.dejarDeSeguir(aSeguir);
              }
              
          }
          
          if(u instanceof Proponente){
            if(aSeguir instanceof Proponente){
                this.usu.dejarSeguirPP(u.getNick(), aSeguir.getNick());
                return u.dejarDeSeguir(aSeguir);
            }
            else if(aSeguir instanceof Colaborador){
                this.usu.dejarSeguirPC(u.getNick(), aSeguir.getNick());
                 return u.dejarDeSeguir(aSeguir);
            }
              
          }

 
    
         return false;  
    }
    
    
    

    @Override
     public void seleccionarUsuario(String nick){
         this.usuRec=nick;
     }
     @Override
     public void seleccionarUsuSeg(String nick){
         this.usuAseguir=nick;
     }
    
    @Override
    public List<DtProponente> listarProponentes(){
      List<DtProponente> listita = new ArrayList<>();
        Set se = usuarios.entrySet();
        Iterator iterator = se.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if(mentry.getValue() instanceof Proponente){
                
            
            Proponente aux = (Proponente) mentry.getValue();
            listita.add(aux.obtenerInfo());
            }
        }
        return listita;
        
        
    }

    @Override
    public boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo, String pass) {
        if (this.existe(Nick, Correo) == false) {
            return false;
        } else {
            if (Imagen.equals("") == false) {
                String[] aux = Imagen.split("\\.");
                String termina = aux[1];
                String destino = "Imagenes/Proponente/" + Nick + "." + termina;
                if (this.copia(Imagen, destino) == true) {
                    Imagen = destino;
                } else {
                    Imagen = null;
                }

            }
//            String nuevo = this.sha1(pass);
            Proponente p = new Proponente(Nick, Nombre, Apellido, Correo, fecha, Imagen, direccion, biografia, web, tipo, pass);
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
            ade.createNewFile();
            Files.copy(aor.toPath(), ade.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ctrlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public void cargarProponentes() {
        this.usuarios = this.usu.cargarProponentes();
       
    }

    
    public void borrarArch(File f){
        File [] arch = f.listFiles();
        if(arch.length > 0){
        for(int i=0; i<arch.length; i++){
            arch[i].delete();
        }
        }
    }
    
    @Override
    public void limpiarUsuarios() {
        try {
            this.usu.limpiarBase();
            File borrar = new File("Imagenes/Colaborador");
            if(borrar.exists()){
            this.borrarArch(borrar);
            borrar.delete();
            }
            File borrar1 = new File("Imagenes/Proponente");
            if(borrar1.exists()){
            this.borrarArch(borrar1);
            borrar1.delete();
            }
            File borrar2 = new File("Imagenes/Propuesta");
            if(borrar2.exists()){
            this.borrarArch(borrar2);
            borrar2.delete();
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
        Set se = usuarios.entrySet();
        Iterator iterator = se.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            if(mentry.getValue() instanceof Colaborador)
            {
            Colaborador aux = (Colaborador) mentry.getValue();   
            
            listita.add(aux.obtenerInfo());
            }
        }
        return listita;
    }
    

@Override
public List<DtColaboracion> datosCol(Colaborador a){
  List<DtColaboracion> listita = new ArrayList<>();
  List<Colaboracion> listitaC = new ArrayList<>();
           
             listitaC = a.getColHechas();
             for(int i=0; i<listitaC.size();i++){
                 DtPropuesta prop = new DtPropuesta(listitaC.get(i).getProp());
                 DtColaboracion cola = new DtColaboracion(prop);
                  listita.add(cola);
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
    public Usuario traerUsuario(String nick){
         for (Usuario u : this.usuarios.values()) {
            if (u.getNick().equalsIgnoreCase(nick)) {
                return u;
            }
        }
        return null;
        
        
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
    
    public void cargarUsuarios2()
    {
        Map<String,  Usuario> listita = new HashMap<>();
        listita.putAll(this.usu.cargarColaboradores());
        listita.putAll(this.usu.cargarProponentes());
        
        this.usuarios = this.cargarSeg(listita);
    }
    
@Override
public Map<String,Usuario> cargarSeg(Map<String,Usuario> lista){
    List<Usuario> usuPP= new ArrayList<>();
     List<Usuario> usuPC= new ArrayList<>();
                    List<Usuario> usuCC= new ArrayList<>();
      List<Usuario> usuCP= new ArrayList<>();
          Map<String, Usuario> nueva= new HashMap<>();
    
    nueva=lista;
    usuPP=this.usu.cargarSegPP();
       usuPC=this.usu.cargarSegPC();
        usuCC=this.usu.cargarSegCC();
    usuCP=this.usu.cargarSegCP();
    
    
    
    Set se=nueva.entrySet();
   
    Iterator it=se.iterator();


    while (it.hasNext()) {
        Map.Entry mentry = (Map.Entry) it.next();
        if (mentry.getValue() instanceof Proponente) {
            Proponente aux = (Proponente) mentry.getValue();


    for(int i=0; i < usuPP.size(); i++){
                 Usuario auxPP = (Usuario) usuPP.get(i);
                if (aux.getNick().equals(auxPP.getNick()) == true) {
                    aux.seguirUsuBD(auxPP);
                }
            }
            
  
            
            
            for(int i=0; i < usuPC.size(); i++){
                 Usuario auxPC = (Usuario) usuPC.get(i);
                if (aux.getNick().equals(auxPC.getNick()) == true) {
                    aux.seguirUsuBD(auxPC);
                }
            }
            

            

        }
        
        else if(mentry.getValue() instanceof Colaborador){
            Colaborador aux2 = (Colaborador) mentry.getValue();
            
            
              for(int i=0; i < usuCC.size(); i++){
                 Usuario auxCC = (Usuario) usuCC.get(i);
                if (aux2.getNick().equals(auxCC.getNick()) == true) {
                    aux2.seguirUsuBD(auxCC);
                }
            }
            

   
              for(int i=0; i < usuCP.size(); i++){
                 Usuario auxCP = (Usuario) usuCP.get(i);
                if (aux2.getNick().equals(auxCP.getNick()) == true) {
                    aux2.seguirUsuBD(auxCP);
                }
            }
          
            
        }
    }
    
    return nueva;
}

    @Override
    public void filtrarP(String campito, JList listita)
{
        List<DtProponente> listita2 = this.listarProponentes();
        if (campito.equals("")) { // SI NO BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    DtProponente p = (DtProponente) listita2.get(i);
                    modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                }
                listita.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    DtProponente p = (DtProponente) listita2.get(i);
                    if (p.getNombre().contains(campito) || p.getNick().contains(campito)) {
                        modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                    }
                }
                listita.setModel(modelo);
            }
        }
}
    
    @Override
    public void filtrarC(String campito, JList listita, List<Colaborador> listita2)
    {
        if (campito.equals("")) { // SI NO BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    Colaborador p = (Colaborador) listita2.get(i);
                    modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                }
                listita.setModel(modelo);
            }
        } else {                                // SI BUSCA
            if (!listita2.isEmpty()) {
                DefaultListModel modelo = new DefaultListModel();
                for (int i = 0; i < listita2.size(); i++) {
                    Colaborador p = (Colaborador) listita2.get(i);
                    if (p.getNick().contains(campito) || p.getNombre().contains(campito)) {
                        modelo.addElement(p.getNombre()+"("+p.getNick()+")");
                    }
                }
                listita.setModel(modelo);
            }
        }
    }


    @Override
    public boolean validaWeb(String algo){
    if(algo.matches("(http://)(www\\.)(.+)(\\.)(.+)") || algo.matches("(www\\.)(.+)(\\.)(.+)") || algo.matches("(https://)(www\\.)(.+)(\\.)(.+)") || algo.matches("(http://)(.+)(\\.)(.+)") || algo.matches("(https://)(.+)(\\.)(.+)") || algo.equals("")){
        return true;
    } 
    return false;
}
 
//    long ini = System.currentTimeMillis();
//    InputStream fuente = null;
    
    @Override
    public List<String> SeleccionarColaborante(String xNick){
        Colaborador x = (Colaborador) usuarios.get(xNick);
        this.ColaboradorConsulta = x;
        List<String> nombresP = new ArrayList<>();
        List<Colaboracion> listitaC = new ArrayList<>();
             listitaC = x.getColHechas();
             for(int i=0; i<listitaC.size();i++){
                 String name = listitaC.get(i).getProp().getTitulo();
                  nombresP.add(name);
        }
    return nombresP;
    };
    

    @Override
     public DtColaboracion SeleccionarColaboracion(String xTitulo){
     Colaborador x = this.ColaboradorConsulta;
        List<Colaboracion> listitaC = new ArrayList<>();
             listitaC = x.getColHechas();
             for(int i=0; i<listitaC.size();i++){
                 
                 if(xTitulo.equals(listitaC.get(i).getProp().getTitulo()))
                 {
                 DtPropuesta prop = new DtPropuesta(listitaC.get(i).getProp());
                 Tretorno re = new Tretorno();
                 if(listitaC.get(i).getRetorno().equals("entrada")){
                     re.gsetEntraada("entrada");
                 }
                 else {
                     re.gsetPorcentaje("porcentaje");
                 }
                 DtColaboracion colad = new DtColaboracion(listitaC.get(i).getHora(),listitaC.get(i).getFecha(),listitaC.get(i).getMonto(), re, null, prop);
                 return colad; //colad
                 }
        }
     return null;
     };
     
     
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
