/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lfern
 */
public class AdmUsuario {
    ArrayList<usuario> listaUsuarios = new ArrayList();
    File archivo = null;

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
    
    public void setUsuario(usuario p){
        this.listaUsuarios.add(p);
    }
    public void cargarArchivo() throws FileNotFoundException, IOException{
        FileReader fr = null;
        BufferedReader br = null;
        listaUsuarios = new ArrayList();
        if(archivo.exists()){
            try {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                while((linea= br.readLine()) != null){
                    String tokens[] = linea.split(";");
                    String nombre = tokens[0];
                    String contra = tokens[1];
                    boolean gestionU = Boolean.parseBoolean(tokens[2]);
                    boolean create = Boolean.parseBoolean(tokens[3]);
                    boolean select = Boolean.parseBoolean(tokens[4]);
                    boolean insert = Boolean.parseBoolean(tokens[5]);
                    boolean delete = Boolean.parseBoolean(tokens[6]);
                    boolean drop = Boolean.parseBoolean(tokens[7]);

                    usuario User = new usuario(nombre, contra, gestionU, create, select, insert, delete, drop);
                    if(tokens.length > 8){
                       String dbs[] = tokens[8].split(";");
                        for (String db : dbs) {
                            String []dbPartes = db.split(":");
                            String nombreDB = dbPartes[0];
                            Database database = new Database(nombreDB);
                            String permisos[] = dbPartes[1].split("-");
                            boolean eliminar = Boolean.parseBoolean(permisos[0]);
                            boolean modificar = Boolean.parseBoolean(permisos[1]);
                            boolean consultar = Boolean.parseBoolean(permisos[2]);
                            boolean acceso = Boolean.parseBoolean(permisos[3]);
                            database.permisos.add(new Permisos(eliminar, modificar, consultar, acceso));
                            User.databases.add(database);
                        } 
                    }
                    listaUsuarios.add(User);
                }   
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                br.close();
                fr.close(); 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*Scanner sc = null;
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
                            Permisos p = new Permisos(sc3.nextBoolean(), 
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
        }*/
    }
    public void escribirArchivo() throws IOException{
        FileWriter  fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo,false);
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
                if(!u.databases.isEmpty()){
                    ArrayList<Database> d = u.getDatabases();
                    for (Database db : d) {
                        bw.write(db.getNameDB()+":");
                        ArrayList<Permisos> p = db.getPermisos();
                        for (Permisos perm : p) {
                            bw.write(perm.eliminar+"-");
                            bw.write(perm.modificar+"-");
                            bw.write(perm.consulta+"-");
                            bw.write(perm.acceso+"-");
                        }
                    }
                    bw.write(";");
                }
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }
}
