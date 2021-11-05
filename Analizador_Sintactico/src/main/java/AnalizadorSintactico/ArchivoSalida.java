/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dell
 */
public class ArchivoSalida {
    int fila=5;
            int columna=3;
    
    public void creandoArchivo(String texto) throws IOException{
       FileWriter archivo= new  FileWriter("C:/Users/dell/Desktop/salida.txt");
       archivo.write(texto+"\n");
       
      
    }
}
