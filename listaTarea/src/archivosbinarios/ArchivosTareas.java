/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivosbinarios;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ArchivosTareas {
    private File archivo = null;
    
    public void setArchivo (String dir){
        archivo = new File (dir);
    }
    
    public Tarea[] leerTareas(){
        if (!archivo.exists())
            return new Tarea[0];
        
        int cantidad = 0;
        try {
            FileReader fr = new FileReader (archivo);
            String contenido = "";
            int c;
            while ((c = fr.read()) != -1){
            contenido = contenido + (char) c;
        }
            fr.close();
            
          String[] lineas = contenido.split("\n");
          for (String linea : lineas){
              if (!linea.trim().isEmpty() && linea.contains("|")){
                  cantidad++;
              }
          }
            
        }catch (IOException e){
            System.out.println("Error al leer el archivo: " +e.getMessage());
            return new Tarea[0];
        }
        
        Tarea[] tareas = new Tarea [cantidad];
        try{
            FileReader fr = new FileReader (archivo);
            String contenido = "";
            int c;
            while ((c = fr.read()) != -1){
                contenido = contenido + (char) c;
            }
            fr.close();
            
            String[] lineas = contenido.split("\n");
            int indice = 0;
            for (String linea : lineas){
                linea = linea.trim();
                if (!linea.isEmpty() && linea.contains("|")){
                    String [] partes = linea.split("\\|", 2);
                    boolean completado = partes[0].equals("true");
                    String nombre = partes[1];
                    tareas[indice++] = new Tarea (nombre, completado);
                }
            }
            
            
        }catch (IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return tareas;
    }
    
    public void agregarTarea (Tarea tarea){
        try{
            FileWriter fw = new FileWriter (archivo, true);
            fw.write(tarea.toLinea() + "\n");
            fw.close();
            
        } catch (IOException e){
            System.out.println("Error al guardar la tarea: " + e.getMessage());
        }
    }
    
    public void GuardarTodas (Tarea[] tareas){
        try{
            FileWriter fw = new FileWriter (archivo, false);
            for (Tarea t : tareas){
                fw.write(t.toLinea() + "\n");
            }
            fw.close();
        }catch (IOException e){
            System.out.println("Error al guardar las tareas: " +e.getMessage());
        }
    }
    
    
}
