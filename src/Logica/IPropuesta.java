/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.List;
import java.util.Map;
import Logica.*;

/**
 *
 * @author Luchi
 */
public interface IPropuesta {

    public abstract void cargarPropuestas();
    public abstract List<DtPropuesta> listarPropuestas();
    public abstract DtPropuesta traerPropuesta(String titulo);
    public abstract boolean AgregarPropuesta(String titulo, String desc, Date fecha, int precioE, int montoActual, Date fechaPub, String Retorno, int montoTotal, String cate, Estado estActual, String img, String nickP, String hora, String Lugar);
    public abstract void CargaPropuestasPrueba();
    public abstract boolean existeColaboracion(String nick, String titulo);
    public abstract Propuesta getPropPorNick(String nick);
    public abstract void cargarColaboraciones();
    public abstract boolean altaColaboracion(Propuesta prop, Colaborador colab, String monto, String tipoR);
    
    
    public abstract DtPropuesta SeleccionarProp(String xTitulo);
    public abstract List<String> NombrePropoConsulta(); 
    public abstract List<String> ListarProp(); 
}
