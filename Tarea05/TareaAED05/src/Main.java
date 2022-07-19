import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;



public class Main {

    public static void main(String[] args) throws SQLException {       
        String url = "jdbc:postgresql://localhost/postgres";
        Connection conn = null;
        conn = DriverManager.getConnection(url, "postgres", "root");       
        
        Scanner teclado = new Scanner(System.in);
        int seleccion;        
     
        do { 
            espacioPrint();
            menuPrincipalPrint();       
           
            seleccion = teclado.nextInt();
            
            switch(seleccion){
           
                case 1: espacioPrint(); crear(conn); pulsarParaVolver();
                    break;
                case 2: espacioPrint(); eliminar(conn); pulsarParaVolver();
                    break;
                case 3: espacioPrint(); ListaClientes(conn); pulsarParaVolver();
                    break;
                case 4: espacioPrint(); ListaProveedores(conn); pulsarParaVolver();
                    break;
                case 5: espacioPrint(); ListaDireccion(conn); pulsarParaVolver();
                    break;
                case 6: espacioPrint(); CrearNeoBD(conn); pulsarParaVolver();
                    break;
                case 7: espacioPrint(); ListaNeoBD(); pulsarParaVolver();
                    break;
                case 8: espacioPrint(); consultaExtra1(); pulsarParaVolver();
                    break;
                case 9: espacioPrint(); consultaExtra2(); pulsarParaVolver();
                    break;    
                case 0:  espacioPrint();System.out.println("Programa Finalizado");
                    break;
                
                default: System.out.println("Valor introducido no valido");  
       
             }
            
        } while (seleccion != 0); 
        
      conn.close();
    }
    
    
     public static void menuPrincipalPrint (){
        
        System.out.println("Seleccione Una Opción");
        System.out.println("PostgreSQL BD------------------------------");
        System.out.println("1. Crear Tablas, Funciones y Tipos");
        System.out.println("2. Eliminar Tablas, Funciones y Tipos");
        System.out.println("PostgreSQL Consultas-----------------------");
        System.out.println("3. Lista de Empresas Clientes"); 
        System.out.println("4. Lista de Empresas Proveedores");
        System.out.println("5. Lista De Direcciones (Funcion)");           
        System.out.println("NeoDatis-----------------------------------");
        System.out.println("6. Crear BD NeoDatis"); 
        System.out.println("7. Lista de Empresas (General) Neodatis"); 
        System.out.println("8. Consulta Extra 1, proveedores “Peras” dirección calle “Cervantes”"); //Siguiente
        System.out.println("9. Consulta Extra 2,  clientes nivel fidelidad “Oro” o dirección calle “La Luz”");   
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
     
    
    public static void crear(Connection conn){       
        
        try {
            Statement sta = conn.createStatement();
            
             sta.execute("CREATE TYPE tlf AS(tlfPRI VARCHAR(50),tlfSEC VARCHAR(50));");
             sta.execute("CREATE TYPE fidelidad AS ENUM('ORO','PLATA','BRONCE');");
             
             sta.execute("CREATE TABLE empCliente( codEmp INT NOT NULL PRIMARY KEY, "
             +"nombre VARCHAR(50) NOT NULL UNIQUE, telefono tlf,calle VARCHAR(50),num INT, fidel fidelidad);");              
             
             sta.executeUpdate("INSERT INTO empCliente VALUES( 2000, 'Frutas del Valle',('623819829','922847637'), 'La Luz', 25, 'BRONCE')");
             sta.executeUpdate("INSERT INTO empCliente VALUES( 2001, 'Frutas del Monte',('675899387',''), 'La Oscuridad', 23, 'ORO')");
             sta.executeUpdate("INSERT INTO empCliente VALUES( 2002, 'Frutas del Bosque',('689654366','922348282'), 'Sombras', 12, 'PLATA')");
             sta.executeUpdate("INSERT INTO empCliente VALUES( 2003, 'Furtas del Lago',('922478922',''), 'Las Tinieblas', 13, 'ORO')");             
             
             sta.execute("CREATE TABLE empProveedor( codEmp INT NOT NULL PRIMARY KEY, "
             + "nombre VARCHAR(50) NOT NULL UNIQUE, telefono tlf,calle VARCHAR(50),num INT, producto TEXT);"); 
             
             sta.executeUpdate("INSERT INTO empProveedor VALUES( 3000, 'Manzanas del Norte',('633244617','922478922'), 'Goya', 1, 'Manzanas')");
             sta.executeUpdate("INSERT INTO empProveedor VALUES( 3001, 'Naranjas del Sur',('689654366','922378276'), 'Gongora', 34, 'Naranjas')");
             sta.executeUpdate("INSERT INTO empProveedor VALUES( 3002, 'Peras del Este',('666738938',''), 'Cervantes', 12, 'Peras')");
             sta.executeUpdate("INSERT INTO empProveedor VALUES( 3003, 'Limones del Oeste',('922873633',''), 'Dali', 22, 'Limones')"); 
            
             sta.execute("CREATE OR REPLACE FUNCTION direccion(varchar, varchar, int) RETURNS TEXT "
            + "AS $$ " +
            " SELECT  'La dirección de la empresa '|| $1 || ' es '|| $2 || ' numero '|| $3 ;\n" 
            +"$$"
            + " LANGUAGE SQL;");
             
            
            System.out.println("DATOS VOLCADOS");
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }   
    
    } 
    
    public static void eliminar(Connection conn){
       
        try {
            Statement sta = conn.createStatement();
            
            sta.execute("DROP TABLE empCliente");
            sta.execute("DROP TABLE empProveedor");
            sta.execute("DROP TYPE tlf");
            sta.execute("DROP TYPE fidelidad");
            sta.execute("DROP FUNCTION direccion");
            
            System.out.println("DATOS ELIMINADOS");
            
        } catch (SQLException ex) {            
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }     
    
    }
    
    
     public static void ListaClientes(Connection conn){
         
         String formato = "%-20s%-20s%-30s%-20s%-20s%-20s";
         System.out.println("Empresas Cliente");
         System.out.printf(formato, "Codigo Empresa", "Nombre", "Telefono", "Calle", "Número", "Nivel Fidelidad");
         System.out.println("");
         System.out.println("------------------------------------------------------------------------------------------------------------------");
         
         try {
             Statement sta = conn.createStatement();
             ResultSet rst = sta.executeQuery("SELECT * FROM empcliente");
             
             while (rst.next()) {
                 
                 System.out.printf(formato, rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), 
                         rst.getInt(5), rst.getString(6));
                 System.out.println("");
                 
             }           
             
         } catch (Exception e) {
             
             System.out.println(e);
         }
         
        
         
     }
     
      public static void ListaProveedores(Connection conn){
         
         String formato = "%-20s%-20s%-30s%-20s%-20s%-20s";
         System.out.println("Empresas Proovedoras");
         System.out.printf(formato, "Codigo Empresa", "Nombre", "Telefono", "Calle", "Número", "Producto");
         System.out.println("");
         System.out.println("------------------------------------------------------------------------------------------------------------------");
         
         try {
             Statement sta = conn.createStatement();
             ResultSet rst = sta.executeQuery("SELECT * FROM empproveedor");
             
             while (rst.next()) {
                 
                 System.out.printf(formato, rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), 
                         rst.getInt(5), rst.getString(6));
                 System.out.println("");
                 
             }           
             
         } catch (Exception e) {
             
             System.out.println(e);
         }
         
        
         
     }
      
    public static void ListaDireccion(Connection conn){        
         
         
         try {
             Statement sta = conn.createStatement();             
             ResultSet rst1 = sta.executeQuery("SELECT * FROM empcliente");       
             PreparedStatement ps = conn.prepareStatement("Select direccion(?,?,?);"); //Aqui se llama a la funcion
             ResultSet rst3;              
             
             while (rst1.next()) {
                 
                 ps.setString(1, rst1.getString(2));
                 ps.setString(2, rst1.getString(4));
                 ps.setInt(3, rst1.getInt(5));  
                 
                 rst3 = ps.executeQuery();
                 while (rst3.next()) { System.out.println(rst3.getString(1));}
             }             
            
            ResultSet rst2 = sta.executeQuery("SELECT * FROM empproveedor");             
            while (rst2.next()) {
                 
                 ps.setString(1, rst2.getString(2));
                 ps.setString(2, rst2.getString(4));
                 ps.setInt(3, rst2.getInt(5));  
                 
                 rst3 = ps.executeQuery();
                 while (rst3.next()) { System.out.println(rst3.getString(1));}
             }  
            
             
         } catch (Exception e) {
             
             System.out.println(e);
         }
         
        
         
     }
    public static void CrearNeoBD(Connection conn){        
        
        ODB odb = ODBFactory.open("empresas.db");
        
          try {
             Statement sta = conn.createStatement();
             ResultSet rst = sta.executeQuery("SELECT * FROM empcliente");             
             
             while (rst.next()) {
                 
               EmpCliente Cliente = new EmpCliente(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getString(6));                 
               odb.store(Cliente);                  
             }     
             
             rst = sta.executeQuery("SELECT * FROM empproveedor");             
             
             while (rst.next()) {
                 
               EmpProveedor Proveedor = new EmpProveedor(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getString(6));                 
               odb.store(Proveedor);                  
             }   
             
              System.out.println("Base de Datos Creada, Datos Volcados");
             
         } catch (Exception e) {
             
             System.out.println(e);
         }       
         
        odb.close();
         
     }
    
    public static void ListaNeoBD(){        
        
        ODB odb = ODBFactory.open("empresas.db");
        
        String formato = "%-20s%-20s%-30s%-20s%-20s%-20s";
        System.out.println("Empresas Clientes/Proveedoras");
        System.out.printf(formato, "Codigo Empresa", "Nombre", "Telefono", "Calle", "Número", "Fidelidad/Producto");
        System.out.println("");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        
          try {
            
              Objects<EmpCliente> objects = odb.getObjects(EmpCliente.class);
               
              while(objects.hasNext()){
      
                     EmpCliente Cliente = objects.next();           
                     System.out.printf(formato, Cliente.getCodEmp(), Cliente.getNombre(), Cliente.getTelefono(), Cliente.getCalle(), 
                             Cliente.getNumero(), Cliente.getFidelidad());  
                     System.out.println("");
               } 
              
              Objects<EmpProveedor> objects2 = odb.getObjects(EmpProveedor.class);
               
              while(objects2.hasNext()){
      
                     EmpProveedor Proveedor = objects2.next();           
                     System.out.printf(formato, Proveedor.getCodEmp(), Proveedor.getNombre(), Proveedor.getTelefono(), Proveedor.getCalle(), 
                             Proveedor.getNumero(), Proveedor.getProducto());  
                     System.out.println("");
               } 
             
         } catch (Exception e) {
             
             System.out.println(e);
         }       
         
        odb.close();
         
     }
    
    
    public static void consultaExtra1(){
    
         String formato = "%-20s%-20s%-30s%-20s%-20s%-20s";
         System.out.println("Empresas con Producto Peras y Ubicadas en Calle Cervantes ");
         System.out.printf(formato, "Codigo Empresa", "Nombre", "Telefono", "Calle", "Número", "Producto");
         System.out.println("");
         System.out.println("------------------------------------------------------------------------------------------------------------------");
         
         ODB odb = ODBFactory.open("empresas.db"); 
         
         ICriterion criterio = new And().add(Where.equal("Producto", "Peras")).add(Where.equal("calle","Cervantes"));         
         IQuery query = new CriteriaQuery(EmpProveedor.class, criterio);      
         Objects<EmpProveedor> objects = odb.getObjects(query);                  
         
         while(objects.hasNext()){
      
                     EmpProveedor Proveedor = objects.next();           
                     System.out.printf(formato, Proveedor.getCodEmp(), Proveedor.getNombre(), Proveedor.getTelefono(), Proveedor.getCalle(), 
                             Proveedor.getNumero(), Proveedor.getProducto());  
                     System.out.println("");
               } 
    
         odb.close();
    }
    
    public static void consultaExtra2(){
        
        String formato = "%-20s%-20s%-30s%-20s%-20s%-20s";
         System.out.println("Empresas con Fidelidad Oro o Ubicadas en Calle La Luz ");
         System.out.printf(formato, "Codigo Empresa", "Nombre", "Telefono", "Calle", "Número", "Fidelidad");
         System.out.println("");
         System.out.println("------------------------------------------------------------------------------------------------------------------");
         
         ODB odb = ODBFactory.open("empresas.db"); 
         
         ICriterion criterio = new Or().add(Where.equal("fidelidad", "ORO")).add(Where.equal("calle","La Luz"));         
         IQuery query = new CriteriaQuery(EmpCliente.class, criterio);      
         Objects<EmpCliente> objects = odb.getObjects(query);                  
         
         while(objects.hasNext()){
      
                     EmpCliente Cliente = objects.next();           
                     System.out.printf(formato, Cliente.getCodEmp(), Cliente.getNombre(), Cliente.getTelefono(), Cliente.getCalle(), 
                             Cliente.getNumero(), Cliente.getFidelidad());  
                     System.out.println("");
               } 
    
         odb.close();
         
    }
    
}
