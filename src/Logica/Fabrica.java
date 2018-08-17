/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Luchi
 */
public class Fabrica {
     //SINGLETON
    private static Fabrica instancia;

    public static Fabrica getInstance(){
        if (instancia == null){
            instancia = new Fabrica();
        }
        return instancia;
    }    
     public IUsuario getICtrlUsuario() {
        IUsuario ICU = ctrlUsuario.getInstance();
        return ICU;
    }   
    public IPropuesta getICtrlPropuesta() {
        IPropuesta ICP = ctrlPropuesta.getInstance();
        return ICP;
    }   
    
    public ICategoria getICtrlCategoria() {
        ICategoria ICC = ctrlCategoria.getInstance();
        return ICC;
    }
    
//      private Fabrica(){
//        this.cargarDatosPrueba();
//    };
      
       public void cargarDatosPrueba(){
        ICategoria ic=this.getICtrlCategoria();
        IUsuario iu = this.getICtrlUsuario();
        ic.cargarCategorias();
        iu.cargarColaboradores();
        iu.cargarProponentes();
    }
       
       public void pruebas() throws ParseException{
          IUsuario iu = this.getICtrlUsuario();
          SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
          Date hrubino = sd.parse("1962-02-25");
//          Date hrubino = new Date(1962, 02, 25);
          iu.altaProponente("hrubino", "horacio.rubino@guambia.com.uy", "Horacio", "Rubino", hrubino, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\hr.JPG", "18 de Julio 1234", " ", "https://twitter.com/horaciorubino", "Proponente");
          Date mb = sd.parse("1972-06-14");
          iu.altaProponente("mbusca", "Martin.bus@agadu.org.uy", "Martín", "Buscaglia", mb, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\mb.jpg", "Colonia 4321", " ", "http://www.martinbuscaglia.com/", "Proponente");
          Date hg = sd.parse("1954-01-07");
          iu.altaProponente("hectorg", "hector.gui@elgalpon.org.uy", "Héctor", "Guido", hg, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\hg.jpg", "Gral. Flores 5645", "", "", "Proponente");
          Date tc = sd.parse("1971-07-24");
          iu.altaProponente("tabarec", "tabare.car@agadu.org.uy", "Tabaré", "Cardozo", tc, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\tc.jpg", "Santiago Rivas 1212", "", "https://www.facebook.com/Tabar%C3%A9-Cardozo-55179094281/?ref=br_rs", "Proponente");
          Date cs = sd.parse("1947-01-01");
          iu.altaProponente("cachilas", "Cachila.sil@c1080.org.uy", "Waldemar “Cachila” ", "Silva", cs, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\cs.jpg", "Br. Artigas 4567", "", "https://www.facebook.com/C1080?ref=br_rs", "Proponente");
          Date jb = sd.parse("1967-03-16");
          iu.altaProponente("juliob", "juliobocca@sodre.com.uy", "Julio", "Bocca", jb, "", "Benito Blanco 4321", "", "", "Proponente");
          Date dp = sd.parse("1975-01-01");
          iu.altaProponente("diegop", "diego@efectocine.com", "Diego", "Parodi", dp, "", "Emilio Frugoni 1138 Ap. 02", "", "http://www.efectocine.com/", "Proponente");
          Date kh = sd.parse("1840-04-25");
          iu.altaProponente("kairoh", "kairoher@pilsenrock.com.uy", "Kairo", "Herrera", kh, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\kh.jpg", "Paraguay 1423", "", "", "Proponente");
          Date lb = sd.parse("1980-10-31");
          iu.altaProponente("durazno", "comunicacion@durazno.gub.uy", "Itendencia", "Durazno", lb, "C:\\Users\\Nuevo\\Desktop\\Prueba\\Proponente\\lb.jpg", "8 de Octubre 1429", "", "http://durazno.gub.uy/portal/index.php", "Proponente");
       }
}
