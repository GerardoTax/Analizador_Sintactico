/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import AnalizadorLexico.PalabraReservadas;
import AnalizadorLexico.TipoError;
import AnalizadorLexico.TipoToken;
import AnalizadorLexico.Token;
import Jframe.VentanaInicio;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class AnalizadorSintactico {
   
    
    private PalabraReservadas reservada;
    private TipoToken tipoToken;
    private ArchivoSalida tmp=new  ArchivoSalida();

   
    int estado=0;
    int indice;
    public void analizar(ArrayList<Token> listaToken) throws IOException{
        FileWriter archivo= new  FileWriter("C:/Users/dell/Desktop/salida.txt");
        for(int i=0; i<listaToken.size(); i++){
             
            switch (estado) {
                case 0:
                    if(listaToken.get(i).getLexema().equals(reservada.ESCRIBIR.name())){
                       
                        estado=1;
                     }
                    else {
                        estado=0;  
                    }
                break;
                case 1:
                    if(listaToken.get(i).getToken().equals(tipoToken.LITERAL.name())){
                       
                        estado=2;
                    }
                    else if(listaToken.get(i).getToken().equals(tipoToken.ENTERO.name())){
                        estado=3;
                    }
                    
                    else {
                        System.out.println("Error sintactico");
                        estado=0;
                    }
                         
                break;
                case 2:
                    
                     if(listaToken.get(i).getLexema().equals(reservada.FIN.name()) && listaToken.get(i-1).getToken().equals(tipoToken.LITERAL.name())){
                         System.out.println("La palabra reservada es "+listaToken.get(i-1).getLexema());  
                        archivo.write("     "+listaToken.get(i-1).getLexema()+"\n");
                        estado=0;
                        
                     }
                     
                     else {
                     
                     }
                break;
                case 3:
                    if(listaToken.get(i).getLexema().equals(reservada.FIN.name()) && listaToken.get(i-1).getToken().equals(tipoToken.ENTERO.name())){
                         System.out.println("La palabra reservada es "+listaToken.get(i-1).getLexema());
                        archivo.write("     "+listaToken.get(i-1).getLexema()+"\n"); 
                        estado=0;
                     }
                    
                    break;                
                default:
                    throw new AssertionError();
            }
            
            
        }
       archivo.close();
     }
}
    
   
    
        
    
   
    
  
