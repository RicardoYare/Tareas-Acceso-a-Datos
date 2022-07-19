
import java.sql.*;
import java.util.Scanner;

public class Punto4 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        Statement stmt = null;
      
        String user = "root";
        String pass = "root";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea03aed", user, pass);
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduce Codigo del Vuelo");        
        String codigoVuelo = teclado.nextLine();
        
        System.out.println("Introduce Hora Salida");
        String horaSalida = teclado.nextLine();        
        
        System.out.println("Introduce Destino");
        String Destino = teclado.nextLine();        
        
        System.out.println("Introduce Procedencia");
        String Procedencia = teclado.nextLine();     
        
        System.out.println("Introduce Plazas Fumador");
        int PlzFumador = teclado.nextInt();      
        
        System.out.println("Introduce Plazas NO Fumador");
        int PlzNoFumador = teclado.nextInt();  
        
        System.out.println("Introduce Plazas Turista");
        int PlzTurista = teclado.nextInt();   
        
        System.out.println("Introduce Plazas de Primera");
        int PlzPrimera = teclado.nextInt();   
        
        stmt = conn.createStatement();
        String SQL = "INSERT INTO vuelos VALUES('"+codigoVuelo+"','"+horaSalida+"','"+Destino+"','"+Procedencia+"',"+PlzFumador+","
                +PlzNoFumador+","+PlzTurista+","+PlzPrimera+");";
        stmt.executeUpdate(SQL);     
        
        System.out.println("Vuelo insertado");
       
        stmt.close();
        conn.close();
    }
}