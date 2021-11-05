/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorLexico;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class Analizador_lexico {
    
    ArrayList<Token> lisToken = new ArrayList();
    
    public void analizar(String text){
        int estado=0;
        int desimal=0;
        String token;
        String lexema="";
        String tipo="";
        String [] linea = separadores(text,'\n');
        
        for(int i=0; i<text.length(); i++){
            for(int j=0;j<linea[i].length();j++){
                 System.out.println(linea[i].charAt(j));
                   
            }
        }
    }
    
    
  
    
    public String [] separadores (String texto, char separador){
    
        String linea="";
        int contador=0;
        for(int i=0; i<texto.length();i++){
            if(texto.charAt(i)== separador){
                contador++;
            }
        }
        contador=0;
        String cadenas[]= new String[contador];
        for(int j=0;j<texto.length();j++){
            if(texto.charAt(j)!=separador){
                linea=linea+String.valueOf(texto.charAt(j));
            }
            else {
                cadenas[contador]=linea;
                contador++;
                linea="";
            }
        }
        return cadenas;
    }
}
