
import java.util.Scanner;

//Instalar pg Admin4
// CREATE DATABASE tarea07
// CREATE TABLE actor(nombre varchar(50), nacionalidad varchar(50), fechaNacimiento INT);

public class Main {
    
    static private String URL;
    static private String usuario;
    static private String pass;

   
    public static void main(String[] args) {
      
        Scanner teclado = new Scanner(System.in);
        int seleccion;  
        
        do { 
            espacioPrint();
            menuPrincipalPrint();       
           
            seleccion = teclado.nextInt();
            
            switch(seleccion){
           
                case 1: espacioPrint(); selectBD(); pulsarParaVolver();
                    break;
                case 2: espacioPrint(); compCon(); pulsarParaVolver();
                    break;
                case 3: espacioPrint(); anniadir(); pulsarParaVolver();
                    break;                          
                   
                case 0:  espacioPrint();System.out.println("Programa Finalizado");
                    break;
                
                default: System.out.println("Valor introducido no valido");  
       
             }
            
        } while (seleccion != 0);
        
        
    }
    
    public static void menuPrincipalPrint (){
        
        System.out.println("Seleccione Una Opción");        
        System.out.println("1. Seleccionar BD //Esta Opción Primero");
        System.out.println("2. Comprobar Conexión");        
        System.out.println("3. Añadir Actor");
        System.out.println("0. Salir"); 
    
    }
     
     public static void espacioPrint(){    
        System.out.println("\n");   
    }
     
     public static void pulsarParaVolver(){
    
        Scanner teclado = new Scanner(System.in);        
        String salida = "";        
        do {     
            
            System.out.println("\n");
            System.out.println("0 Para Volver al Menú");
            salida = teclado.next();
            System.out.println("\n");                    
            
        } while (!salida.equalsIgnoreCase("0")); 
    
    
    }
     
     public static void selectBD(){
     
         espacioPrint();
     
        System.out.println("Seleccione BD");        
        System.out.println("1. MYSQL");
        System.out.println("2. POSTGRESSQL");
      
        Scanner teclado = new Scanner(System.in);
        int seleccion;   
           
        seleccion = teclado.nextInt();        
        espacioPrint(); 
        
        if (seleccion == 1) {
            
            miDbComponent c = new miDbComponent();
            
            String URL = "jdbc:mysql://localhost:3306/tarea07";
            String usuario = "root";
            String pass = "root";       
            
            Main.URL = URL;
            Main.pass = pass;
            Main.usuario = usuario;
            
            
            c.setMode(miDbComponent.MY_SQL);
            c.Connect(URL, usuario, pass);
            System.out.println("Seleccionada BD MYSQL");

        }else if (seleccion == 2){

            miDbComponent c = new miDbComponent();
            
            String URL = "jdbc:postgresql://localhost/tarea07";
            String usuario = "postgres";
            String pass = "root";     
            
            Main.URL = URL;
            Main.pass = pass;
            Main.usuario = usuario;
            
            c.setMode(miDbComponent.POSTGRES_SQL);
            c.Connect(URL, usuario, pass);
            System.out.println("Seleccionada BD POSTGRESSQL");

        }else{
        
            System.out.println("Valor introducido incorrecto");
        
        }     
     
     }
     
     public static void compCon(){
     
         miDbComponent c = new miDbComponent();
         
         try {
             
             boolean conexion = c.Connect(Main.URL, Main.usuario, Main.pass);   
             
             if (conexion == true) {
                 
                 System.out.println("Conexión Correcta");
                 
             }else{
             
                 System.out.println("Conexión No establecida");
             
             }            
             
         } catch (Exception e) {
             
             System.out.println("Error en la Conexion");
             
         }         
     
     
     }
     
     
     public static void anniadir(){
         
         Scanner teclado = new Scanner(System.in);
         
         miDbComponent c = new miDbComponent();
         registro cambioRegistro = new registro();   
         
         c.addPropertyChangeListener(cambioRegistro);
         
         System.out.println("Introducir Nombre");
         String nombre = teclado.next();
         System.out.println("Introducir Nacionalidad");
         String nacion = teclado.next();
         System.out.println("Introducir fecha de nacimiento(cualquier int)");
         int fecha = teclado.nextInt();
        
         try {
             
              c.Connect(Main.URL, Main.usuario, Main.pass);         
              actor NuevoActor = new actor(nombre, nacion, fecha);
              c.AddActor(NuevoActor);
              System.out.println("Nueva Entrada Añadida");
             
         } catch (Exception e) {
             
             System.out.println(e);
         }  
     
     }     
     
    
    
}
