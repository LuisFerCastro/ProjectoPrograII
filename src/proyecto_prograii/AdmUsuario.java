/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lfern
 */
public class AdmUsuario {
    private ArrayList<usuario> listaUsuarios = new ArrayList();
    private File archivo = null;

    public AdmUsuario(String path) {
        archivo = new File(path);
    }

    public ArrayList<usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "listaUsuarios=" + listaUsuarios;
    }
    
    public void cargarArchivo(){
        Scanner sc = null;
        if(archivo.exists()){
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    listaUsuarios.add(new usuario(sc.next(), 
                            sc.next(), 
                            sc.nextBoolean(), 
                            sc.nextBoolean(), 
                            sc.nextBoolean(), 
                            sc.nextBoolean(), 
                            sc.nextBoolean(), 
                            sc.nextBoolean()));
                    String tkn_db = sc.next();
                    Scanner sc2 = new Scanner(tkn_db);
                    sc2.useDelimiter("/");
                    while (sc2.hasNext()) {
                        Database db = new Database(sc2.next());
                        listaUsuarios.get(listaUsuarios.size()-1).getDatabases().add(db);
                        String tkn_permisos = sc2.next();
                        Scanner sc3 = new Scanner(tkn_permisos);
                        sc3.useDelimiter("|");
                        while (sc3.hasNext()) {
                            Permisos p = new Permisos(sc3.hasNextBoolean(), 
                                    sc3.nextBoolean(), 
                                    sc3.nextBoolean(), 
                                    sc3.nextBoolean());
                            listaUsuarios.get(listaUsuarios.size()-1).getDatabases().get(listaUsuarios.get(listaUsuarios.size()-1).getDatabases().size()-1).getPermisos().add(p);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            sc.close();
        }
    }
    public void escribirArchivo() throws IOException{
        FileWriter  fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo);
            bw = new BufferedWriter(fw);
            for (usuario u : listaUsuarios) {
                bw.write(u.getNombre()+";");
                bw.write(u.getContra()+";");
                bw.write(u.gestionU+";");
                bw.write(u.create+";");
                bw.write(u.select+";");
                bw.write(u.insert+";");
                bw.write(u.delete+";");
                bw.write(u.drop+";");
                ArrayList<Database> d = u.getDatabases();
                for (Database db : d) {
                    bw.write(db.getNameDB()+"/");
                    ArrayList<Permisos> p = db.getPermisos();
                    for (Permisos perm : p) {
                        bw.write(perm.eliminar+"|");
                        bw.write(perm.modificar+"|");
                        bw.write(perm.consulta+"|");
                        bw.write(perm.acceso+"|");
                    }
                }
                bw.write(";");
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }
}
