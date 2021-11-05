/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import AnalizadorLexico.TipoError;
import AnalizadorLexico.Token;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class ManejadorTabla {
    
    
    public void ReporteTokens(ArrayList<Token> list, JTable table) {
         DefaultTableModel modelo = new DefaultTableModel();
          table.setModel(modelo);
          modelo.addColumn("Nombre Token");
          modelo.addColumn("Lexema");
          modelo.addColumn("fila");
          modelo.addColumn("columna");
          for(int i=0; i<list.size();i++){
              modelo.addRow(new Object[]{list.get(i).getToken(),list.get(i).getLexema(),list.get(i).getFila(),list.get(i).getColumna()});
          }
           
    }
    
    
    public void ReporteError(ArrayList<TipoError> lista, JTable table) {
         DefaultTableModel modelo = new DefaultTableModel();
          table.setModel(modelo);
          modelo.addColumn("Tipo Error");
          modelo.addColumn("Lexema");
          modelo.addColumn("fila");
          modelo.addColumn("columna");
          for(int j=0; j<lista.size();j++){
              modelo.addRow(new Object[]{lista.get(j).getTipoError(),lista.get(j).getLexema(),lista.get(j).getFila(),lista.get(j).getColumna()});

          }
           
    }
}
