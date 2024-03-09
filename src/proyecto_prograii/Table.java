/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lfern
 */
public class Table {
    String nombre;
    String creador;
    String fecha;
    ArrayList<String> atributos = new ArrayList();
    ArrayList<String[]>datos = new ArrayList();

    public Table(String nombre, String creador, String fecha) {
        this.nombre = nombre;
        this.creador = creador;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<String> getAtributos() {
        return atributos;
    }

    public void setAtributos(ArrayList<String> atributos) {
        this.atributos = atributos;
    }

    public ArrayList<String[]> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<String[]> datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
