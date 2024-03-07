/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

import java.io.Serializable;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author lfern
 */
public class Trees implements Serializable{
    DefaultTreeModel arbol;
    
    private static final long SerialVersionUID = 555;

    public Trees(DefaultTreeModel arbol) {
        this.arbol = arbol;
    }

    public DefaultTreeModel getArbol() {
        return arbol;
    }

    public void setArbol(DefaultTreeModel arbol) {
        this.arbol = arbol;
    }

    @Override
    public String toString() {
        return "Trees{" + "arbol=" + arbol + '}';
    }
    
}
