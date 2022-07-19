
import java.io.FileWriter;
import java.io.IOException;  

public class Main {

    
    public static void main(String[] args) {
        
        String palFichero;
           
        try {
            
             FileWriter numNatu = new FileWriter("numNaturales.txt");
             System.out.println("Fichero Creado");
             
             for (int i = 1; i < 101; i++) {
                   
                   palFichero = String.valueOf(i)+ " ";
                   numNatu.write(palFichero);                
                
            }  
             
             numNatu.close();           
            
        } catch (IOException e) {
            System.out.println(e);            
        }       
        
    }
    
}
