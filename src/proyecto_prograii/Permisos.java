/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_prograii;

/**
 *
 * @author lfern
 */
public class Permisos {
    boolean eliminar;
    boolean modificar;
    boolean consulta;
    boolean acceso;

    public Permisos(boolean eliminar, boolean modificar, boolean consulta, boolean acceso) {
        this.eliminar = eliminar;
        this.modificar = modificar;
        this.consulta = consulta;
        this.acceso = acceso;
    }

    public boolean isEliminar() {
        return eliminar;
    }

    public void setEliminar(boolean eliminar) {
        this.eliminar = eliminar;
    }

    public boolean isModificar() {
        return modificar;
    }

    public void setModificar(boolean modificar) {
        this.modificar = modificar;
    }

    public boolean isConsulta() {
        return consulta;
    }

    public void setConsulta(boolean consulta) {
        this.consulta = consulta;
    }

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }
    
}
