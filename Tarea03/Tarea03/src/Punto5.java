import java.sql.*;
import java.util.Scanner;

public class Punto5 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        Statement stmt = null;
      
        String user = "root";
        String pass = "root";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea03aed", user, pass);
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce Codigo del Vuelo a Eliminar");        
        String codigoVuelo = teclado.nextLine();
        
        stmt = conn.createStatement();
        String SQL = "DELETE FROM vuelos WHERE COD_VUELO = '"+codigoVuelo+"'";
        stmt.executeUpdate(SQL);     
        
        System.out.println("Vuelo Eliminado");
       
        stmt.close();
        conn.close();
    }
}