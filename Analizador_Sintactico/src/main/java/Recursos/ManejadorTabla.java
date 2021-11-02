/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class ManejadorTabla {
    
    
    public void tabla(ArrayList<String> lexema, ArrayList<String> token, JTable table) {
         DefaultTableModel modelo = new DefaultTableModel();
          table.setModel(modelo);
          modelo.addColumn("Nombre Token");
          modelo.addColumn("Lexema");
          modelo.addColumn("Posicion");
          String [] listaLexema =lexema.toArray(new String [lexema.size()]);
          
          for(int i=0; i<lexema.size(); i++){
          
               String vectorToken[] = {token.get(i)};
               String vectorLexemas[] = {lexema.get(i)};
               modelo.addRow(new Object[]{token.get(i),lexema.get(i)});
              
              
          }
    }
    
    public void tablaErrores(ArrayList<String> errores,ArrayList<String> tipoEror, JTable table){
          DefaultTableModel modelo = new DefaultTableModel();
          table.setModel(modelo);
          modelo.addColumn("Tipo de Error ");
          modelo.addColumn("lexema de error");
          for(int i=0; i<errores.size();i++){
              modelo.addRow(new Object[]{tipoEror.get(i),errores.get(i)});
             
          }
    }
}
