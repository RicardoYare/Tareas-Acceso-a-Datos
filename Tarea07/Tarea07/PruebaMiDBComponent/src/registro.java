import java.beans.*;
import java.io.Serializable;
import java.util.*;


 public class registro implements Serializable, PropertyChangeListener{
      
    
       public registro(){}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        System.out.println("Numero de Registros Anterior: " + evt.getOldValue()); 
        System.out.println("Numero de Registros Actual: " + evt.getNewValue());
              
        
    }      
     
}
    
    
    
    

