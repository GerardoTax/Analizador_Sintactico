
package AnalizadorLexico;


import Jframe.VentanaInicio;
import Recursos.ManejadorTabla;
import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author dell
 */
public class Analizador {
    private VentanaInicio ventana;
    private ArrayList <String> listErrores = new ArrayList <String>();
    private ArrayList <String> listLexema = new ArrayList <String>();
    private ArrayList <String> list= new ArrayList <String>();
    private ArrayList <String> lisToken= new ArrayList <String>();
     private ArrayList <String> tipoError= new ArrayList <String>();
    int inidice=0;
    int estado=0;
    String lexema="";
    private PalabraReservadas reservada;
    
  
 public Analizador( VentanaInicio ventana){
     this.ventana=ventana;
     
 }
  
  public void analizar(){
    listLexema.clear();
    lisToken.clear();
    tipoError.clear();
    listErrores.clear();
    Buscar bs=new Buscar();
    String todoTexto= this.ventana.getjTextArea1().getText()+" ";
    String textolimpio="";
   
   for(int i=0;i<todoTexto.length(); i++){
   
       char letra=todoTexto.charAt(i);
       switch (letra) {
           case '\r' :
           case '\t' :
           case '\b' :
           case '\f' :
               
               break;
           default:
                textolimpio=textolimpio+letra;
       }
       
   }
   
   for(int indice=0; indice<textolimpio.length();indice++){
       char letra=textolimpio.charAt(indice);
       char Error;
       switch (estado) {
           case 0:
               if(Character.isLetter(letra) || letra=='_'){
                estado=1;
                lexema=""+letra;
               }
               else if(Character.isDigit(letra) || letra=='-'){
                   estado=2;
                   lexema=""+letra;
               }
               else if(letra==' ' | letra=='\n'){
                   estado=0;
               }
               
               else if (letra=='"') {
                   estado=3;
                   lexema=""+letra;
               }
               
               else if (letra=='/'){
                    estado=4;
                    lexema=""+letra;
               }
               
               else if(letra=='+'|| letra=='-' || letra=='*' || letra=='=' || letra=='(' || letra==')' ){
                   estado=0;
                   this.listLexema.add(String.valueOf(letra));
                   this.lisToken.add("simbolo");
               }
               
               else {
               //bs.buscarError(ventana.getjTextArea1(),String.valueOf(letra));
               System.out.println("Error Lexico   "+letra);
               listErrores.add(""+letra);
               tipoError.add("No existe en el alfabeto");
               }
               
               break;
               
           case 1:
               if(Character.isLetter(letra) | Character.isDigit(letra) || letra=='-' || letra=='_' ){
                   estado=1;
                   lexema=lexema+letra;
                  
               }
               else if(letra==' ' | letra=='\n'){
                    listLexema.add(lexema);
                    lisToken.add("Identificador");
                    lexema="";
                    estado=0;
                    indice--;
               }
               else {
                  String error=lexema+letra;
                  listLexema.add("Token: identificador    Lexema:  "+lexema);
                  listErrores.add(lexema+letra);
                  tipoError.add("Se esperaba un numero o una letra");
                  System.out.println("Error  ---"+letra);
                  lexema="";
                  estado=0;
                
               }
               break;
               
           case 2:
               if(Character.isDigit(letra)){
                        estado=2;
                        lexema=lexema+letra;
                        
                  }
               
               else if(letra==' ' | letra=='\n'){
                    listLexema.add(lexema);
                    lisToken.add("Entero");
                    lexema="";
                    estado=0;
                    indice--;
               }
       
               else {
                  //bs.buscarError(ventana.getjTextArea1(),String.valueOf(lexema+letra));
                  listLexema.add(lexema);
                  System.out.println("Error Lexico   "+letra);
                 // listErrores.add("Se esperava un numero    " +lexema+letra);
                 listErrores.add(lexema+letra); 
                 tipoError.add("se esperava un numero");
                 lexema="";
                  estado=0;
                 
               }
                
               break;
               
           
           case 3:
               String comilla="'";
               if(Character.isLetter(letra) || Character.isLetterOrDigit(letra)  || letra==' ' || letra=='<' || letra=='>'  || letra== ':' || letra==',' || letra==';' || letra=='/'|| letra=='.' || letra==')' || letra=='(' || letra=='=' || letra=='+' ){
                   estado=3;
                   lexema=lexema+letra;
               }
               
            else if(letra=='"'){
                    listLexema.add(lexema+letra);
                    lisToken.add("Literal");
                    lexema="";
                    estado=0;
                   // indice--;
                         
                }
            else if(comilla.equals(String.valueOf(letra))){
                    estado=3;
                    lexema=lexema+letra;
            }
            
               else {
                   // bs.buscarError(ventana.getjTextArea1(),String.valueOf(lexema+letra));
                    listLexema.add(lexema);
                    System.out.println("Error Lexico   "+letra);
                  //  listErrores.add("Se esperava un numero    " +lexema+letra);
                  listErrores.add(lexema+letra);  
                  tipoError.add("no es una literal");
                  lexema="";
                    estado=0;
                }
           
               break;
               
           case 4:
               if(letra=='/' ){
                   estado=5;
                    lexema=lexema+letra;
                    
                  }
               else {
                   //bs.buscarError(ventana.getjTextArea1(),String.valueOf(lexema+letra));
                    listLexema.add(lexema);
                    System.out.println("Error Lexico   "+letra);
                    //listErrores.add("Se esperaba un espacio "+lexema+letra);
                    listErrores.add(lexema+letra);
                    tipoError.add("se esperaba una /");
                    lexema="";
                    estado=0;
                    
               }
               break;
           case 5:
             if( letra=='\n'){
                 listLexema.add(lexema);
                 lisToken.add("Comentario");
                    lexema="";
                    estado=0;
                  }
               else {
                  estado=5;
                  lexema=lexema+letra;
               }
               break;
               
           default:
               throw new AssertionError();
       }
               
   }
  }
  
    public void contarLexemas(){
        
        for(int i=0; i<listLexema.size() ;i++){
            int cont=0;
            String texto="";
            for(int j=0;j<listLexema.size();j++){
                if(listLexema.get(i).equals(listLexema.get(j))){
                    cont++;
                    texto=listLexema.get(i);
                } 
            }
            agregarlista(texto+" cantidad de vez: "+cont);
        }    
    }
    
    public  void agregarlista(String campo){
       if(list.contains(campo)){
       
       }
       else {
           list.add(campo);
       }
        
         
    }
  
    
  /*  public void repetidos(){
        ventana.getjTextArea2().setText("");
        for(int i=0; i<list.size(); i++){
             System.out.println("------"+list.get(i));
              this.ventana.getjTextArea2().append(list.get(i)+"\n");
        }
    }
    */
    
  
    
    public void palabraReservadas(){
        for(int i=0; i<listLexema.size();i++){
            if(listLexema.get(i).equals(reservada.ESCRIBIR.name())){ 
               lisToken.add(i, "Palabras reservada");
            }
            else if(reservada.FIN.name().equals(listLexema.get(i))){
                lisToken.add(i, "Palabras reservada");  
            }
            else if(listLexema.get(i).equals(reservada.REPETIR.name())){
                lisToken.add(i, "Palabras reservada");  
            }
            else if(listLexema.get(i).equals(reservada.INICIAR.name())){
                lisToken.add(i, "Palabras reservada");  
            }
            else if(listLexema.get(i).equals(reservada.SI.name())){
                lisToken.add(i, "Palabras reservada");  
            }
            else if(listLexema.get(i).equals(reservada.VERDADERO.name())){
                lisToken.add(i, "Palabras reservada");  
            }
            else if(listLexema.get(i).equals(reservada.FALSO.name())){
                lisToken.add(i, "Palabras reservada");  
            }
            else if(listLexema.get(i).equals(reservada.ENTONCES.name())){
                lisToken.add(i, "Palabras reservada");  
            }
            
        }
    }
    
    public void imprimirLexemas(){
        
        ManejadorTabla tabla =new ManejadorTabla();
        
         if(listErrores.size()==0){
             tabla.tabla(listLexema, lisToken, this.ventana.getjTable1());
         }
         else {
             tabla.tablaErrores(listErrores,tipoError ,ventana.getjTable1());
         }
        
        
    }

    
   
    
}
