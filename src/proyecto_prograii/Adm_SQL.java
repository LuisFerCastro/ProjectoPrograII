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

/**
 *
 * @author lfern
 */
public class Adm_SQL {
    ArrayList<String> sqls = new ArrayList();
    File archivo;

    public Adm_SQL(String path) {
        archivo = new File(path);
    }

    public ArrayList<String> getSqls() {
        return sqls;
    }

    public void setSqls(ArrayList<String> sqls) {
        this.sqls = sqls;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void escribirArchivo(){
        try {
            FileWriter fr = new FileWriter(archivo);
            BufferedWriter br = new BufferedWriter(fr);
            for (int i = 0; i < sqls.size(); i++) {
                br.write(sqls.get(i));
                br.newLine();
            }
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cargarArchivo(){
        sqls = new ArrayList();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null){
                sqls.add(linea);
            }
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
