/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JTree;

/**
 *
 * @author lfern
 */
public class Adm_Trees {
    Trees arbol;
    //ArrayList<Trees> jtrees = new ArrayList();
    File archivo = null;

    public Adm_Trees(String path) {
        archivo = new File(path);
    }

    /*public ArrayList<Trees> getJtrees() {
        return jtrees;
    }

    public void setJtrees(ArrayList<Trees> jtrees) {
        this.jtrees = jtrees;
    }*/

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "Adm_Trees{" + "arbol=" + arbol + ", archivo=" + archivo + '}';
    }

    
    public void escribirArchivo(){
        FileOutputStream salida = null;
        ObjectOutputStream objeto = null;
        try {
            salida = new FileOutputStream(archivo);
            objeto = new ObjectOutputStream(salida);
            objeto.writeObject(arbol);
            objeto.flush();
        } catch (Exception e) {
        }
        try {
            objeto.close();
            salida.close();
        } catch (Exception e) {
        }
    }
    
    public void cargarArchivo(){
        FileInputStream fw = null;
        ObjectInputStream ow = null;
        /*Trees temp;
        jtrees = new ArrayList();*/
        if(archivo.exists()){
            try {
                fw = new FileInputStream(archivo);
                ow = new ObjectInputStream(fw);
                try {
                    if((arbol = (Trees)ow.readObject()) != null){
                        arbol = (Trees)ow.readObject();
                    }
                    /*while((temp = (Trees)ow.readObject())!= null){
                        jtrees.add(temp);
                    }*/
                } catch (EOFException e) {
                }
       
            } catch (Exception e) {
            }
        }
    }
}
