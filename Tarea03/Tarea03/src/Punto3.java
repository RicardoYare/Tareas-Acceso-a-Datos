
import java.sql.*;
import java.util.Scanner;

public class Punto3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String user = "root";
        String pass = "root";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea03aed", user, pass);
        
        System.out.println("Introduce Codigo del Vuelo");
        Scanner teclado = new Scanner(System.in);
        String codigoVuelo = teclado.nextLine();
        
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM pasajeros WHERE COD_VUELO = '"+codigoVuelo+"'");
        
        System.out.println("--------------------------------");
        System.out.println("Tabla Pasajeros del Vuelo "+codigoVuelo);
        System.out.println("--------------------------------");
        String formato = "%-20s%-20s%-20s%-20s";
        System.out.printf(formato, "NumPasajero", "Codigo Vuelo", "Tipo Plaza", "Fumador");
        System.out.println(""); 
      
        
        while (rs.next()) {
            
            int numFPasajero = rs.getInt("NUM");
            String codVuelo = rs.getString("COD_VUELO");
            String tipoPlaza = rs.getString("TIPO_PLAZA");
            String fumador = rs.getString("FUMADOR");     
          
            System.out.printf(formato, numFPasajero, codVuelo, tipoPlaza, fumador);
            System.out.println("");  
        
        }
        
        rs.close();
        stmt.close();
        conn.close();
    }
}
