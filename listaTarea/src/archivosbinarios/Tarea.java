/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosbinarios;

/**
 *
 * @author user
 */
public class Tarea {
 private String nombre;
 private boolean completado;
 
 public Tarea (String nombre, boolean completado){
     this.nombre = nombre;
     this.completado = completado;
 }

    public String getNombre() {
        return nombre;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
 
 public String toLinea (){
     String estado;
     if (completado)
         estado = "true";
     else
         estado = "false";
     return estado + "|" + nombre;
 }
 

public String toString(){
    String estado;
    if (completado)
        estado = "✓";
    else
        estado = " ";
    
    return "[" + estado + "] " + nombre;
}

 
}
