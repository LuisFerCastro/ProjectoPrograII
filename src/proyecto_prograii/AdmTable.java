/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lfern
 */
public class AdmTable {
    File archivo; 
    DefaultTableModel modelo;
    ArrayList<Table>tablas = new ArrayList();

    public AdmTable(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public ArrayList<Table> getTablas() {
        return tablas;
    }

    public void setTablas(ArrayList<Table> tablas) {
        this.tablas = tablas;
    }

    public void escribirArchivo(){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);
            for (Table tabla : tablas) {
                bw.write("Tabla: "+tabla.getNombre());
                bw.newLine();
                bw.write("Creador: "+tabla.getCreador());
                bw.newLine();
                bw.write("Fecha: "+tabla.getFecha());
                bw.newLine();
                bw.write("Atributos: ");
                for (int i = 0; i < tabla.getAtributos().size(); i++) {
                    bw.write(tabla.atributos.get(i));
                    if(i < tabla.atributos.size()-1){
                        bw.write(",");
                    }
                }
                bw.newLine();
                
                for (String[] datos : tabla.getDatos()) {
                    for (int i = 0; i < datos.length; i++) {
                        bw.write(datos[i]);
                        if(i<datos.length-1){
                            bw.write(",");
                        }
                    }
                    bw.newLine();
                }
            }
            bw.flush();
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public DefaultTableModel leerTabla(){
        DefaultTableModel m = new DefaultTableModel();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            for (int i = 0; i < 4; i++) {
                linea = br.readLine();
                if(linea != null){
                    String[]encabezado = linea.split("://s*",2);
                    if(encabezado.length == 2){
                        if(i == 3){
                            String[]atributos = encabezado[1].split(",");
                            m.setColumnIdentifiers(atributos);
                        }
                    }
                }
            }
            ArrayList<String[]> datos = new ArrayList();
            while((linea = br.readLine()) != null){
                String data[] = linea.split(",");
                datos.add(data);
            }
            for (String[] dato : datos) {
                m.addRow(dato);
            }
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        return m;
    }
}
