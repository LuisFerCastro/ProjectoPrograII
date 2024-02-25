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
public class usuario {
    String nombre;
    String contra;
    boolean gestionU;
    boolean create;
    boolean select;
    boolean insert;
    boolean delete;
    boolean drop;
    
    public ArrayList<Database> databases = new ArrayList();
    

    public usuario() {
    }

    public usuario(String nombre, String contra) {
        this.nombre = nombre;
        this.contra = contra;
    }

    public usuario(String nombre, String contra, boolean gestionU, boolean create, boolean select, boolean insert, boolean delete, boolean drop) {
        this.nombre = nombre;
        this.contra = contra;
        this.gestionU = gestionU;
        this.create = create;
        this.select = select;
        this.insert = insert;
        this.delete = delete;
        this.drop = drop;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean isGestionU() {
        return gestionU;
    }

    public void setGestionU(boolean gestionU) {
        this.gestionU = gestionU;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDrop() {
        return drop;
    }

    public void setDrop(boolean drop) {
        this.drop = drop;
    }

    public ArrayList<Database> getDatabases() {
        return databases;
    }

    public void setDatabases(ArrayList<Database> databases) {
        this.databases = databases;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
