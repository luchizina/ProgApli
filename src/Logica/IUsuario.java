/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Luchi
 */
public interface IUsuario {
    public abstract boolean altaColaborador(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String tipo);
    public abstract boolean altaProponente(String Nick, String Correo, String Nombre, String Apellido, Date fecha, String Imagen, String direccion, String biografia, String web, String tipo);
public abstract boolean escorreo(String correo);
    public abstract boolean existeNick(String nick);
    public abstract boolean existeCorreo(String correo);
    public abstract void cargarProponentes();
     public abstract List<DtProponente> listarUsuario();
     public abstract void cargarColaboradores();
     public abstract List<DtColaborador> listarColaboradores();
      public abstract void limpiarUsuarios();
      public abstract void cargarUsuarios();
    public abstract boolean existe(String nick, String correo);
     public abstract void cargarPropPrueba();
     public abstract boolean copia(String origen, String destino);
}
