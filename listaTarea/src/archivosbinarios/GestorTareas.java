/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosbinarios;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class GestorTareas {
    private ArchivosTareas archivo;
    private Scanner scanner;

public void mostrarMenu(){
System.out.println("\nGESTOR DE TAREAS");
System.out.println("===================");
System.out.println("1: Agregar tarea");
System.out.println("2: Mostrar tareas");
System.out.println("3: Completar tarea");
System.out.println("4: Salir");

}

public void agregarTarea(){
    System.out.print("Ingresa la nueva tarea: ");
    String nombre = scanner.nextLine().trim();
    
    if (nombre.isEmpty()){
        System.out.println("La tarea debe ser nombrado");
        return;
    }
    
    Tarea tarea = new Tarea (nombre,false);
    archivo.agregarTarea(tarea);
    System.out.println("\n✓ Tarea agregada: " +nombre);
    
}

public void mostrarTareas(){
    Tarea[] tareas = archivo.leerTareas();
    
    System.out.println("\nLISTA DE TAREAS");
    System.out.println("=============");
    
    if (tareas.length == 0){
        System.out.println("No hay tareas registradas.");
        return;
    }
    
    for (int i = 0; i < tareas.length; i++){
        System.out.println((i+1) + ". " +tareas[i]);
    }
    
}




}

