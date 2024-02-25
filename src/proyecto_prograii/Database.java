/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.util.ArrayList;

/**
 *
 * @author lfern
 */
public class Database {
    String nameDB;
    ArrayList<Permisos> permisos = new ArrayList();

    public Database(String nameDB) {
        this.nameDB = nameDB;
    }

    public Database() {
    }

    public String getNameDB() {
        return nameDB;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }

    public ArrayList<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(ArrayList<Permisos> permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return nameDB;
    }
    
}
