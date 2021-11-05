/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejecutable;

import AnalizadorLexico.Analizador_lexico;
import AnalizadorSintactico.ArchivoSalida;
import Jframe.VentanaInicio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dell
 */
public class Ejecutable {
    
    public static void main(String args []){
       VentanaInicio ventana=new VentanaInicio();
        ventana.setVisible(true);
        ArchivoSalida tmp=new  ArchivoSalida();
       /* try {
            tmp.creandoArchivo("hola");
        } catch (IOException ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
