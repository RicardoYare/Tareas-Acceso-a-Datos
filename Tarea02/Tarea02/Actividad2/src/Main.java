
import generated.Ticket;
import generated.Ticket.Lineas;
import generated.Ticket.Lineas.Linea;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class Main {

//Principalmente lo que hice fue importar XSD, el inicial de la tarea y un segundo con los elementos a agregar
// El programa lee un xml con el primer esquema y genera uno nuevo agregando los elementos importe y total del segundo esquema
    
    public static void main(String[] args) throws JAXBException, IOException {
      
        JAXBContext context = JAXBContext.newInstance(Ticket.class);
        Unmarshaller unma =  context.createUnmarshaller();
        
        Ticket ticket = (Ticket) unma.unmarshal(new File ("ticket.xml"));  //Fichero xml proporcionado en la tarea ubicado en la carpeta de trabajo                                                                              
        Lineas lineas = ticket.getLineas();        
        List<Linea> lineaEntrada = lineas.getLinea();        
        int importe;        
        int total = 0;
        
        Marshaller marsh = context.createMarshaller();
        
        Ticket ticketSalida = new Ticket();
        Lineas lineasSalida = new Lineas();
        ArrayList<Linea> arrayLineas = new ArrayList<Linea>();
        
        for(Linea l :  lineaEntrada){
            
            Linea lineaSalida = new Linea();
            
            importe = Integer.parseInt(l.getPrecioUnitario()) * Integer.parseInt(l.getUnidades());                     
            total = total + importe;
            String importeString = String.valueOf(importe);
            
            lineaSalida.setConcepto(l.getConcepto());           
            lineaSalida.setPrecioUnitario(l.getPrecioUnitario());
            lineaSalida.setUnidades(l.getUnidades());
            lineaSalida.setImporte(importeString);                      
            
            arrayLineas.add(lineaSalida);
                    
        }             
        
        String totalString = String.valueOf(total);
        lineasSalida.setTotal(totalString);  
        
        lineasSalida.setLinea(arrayLineas);
        ticketSalida.setLineas(lineasSalida);
        
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marsh.marshal(ticketSalida, System.out); //Lo imprimo por consola para que se vea el resultado, por comodidad
        marsh.marshal(ticketSalida, new FileWriter("ticketSalida.xml")); //Se genera en la carpeta de trabajo
      
    }
    
}