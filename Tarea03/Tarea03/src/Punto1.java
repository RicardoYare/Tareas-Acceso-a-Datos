
import java.sql.*;

public class Punto1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String user = "root";
        String pass = "root";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea03aed", user, pass);
        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT vue.COD_Vuelo, vue.HORA_SALIDA, vue.DESTINO, vue.PROCEDENCIA, COUNT(pa.NUM) AS CantidaPasajeros, "
                +"SUM(CASE WHEN pa.FUMADOR = \"SI\" then 1 else 0 end) AS NumeroFumadores,"
                +"SUM(CASE WHEN pa.TIPO_PLAZA = \"PR\" then 1 else 0 end) AS NumeroClasePri,"
                +"SUM(CASE WHEN pa.TIPO_PLAZA = \"TU\" then 1 else 0 end) AS NumeroClaseTurista "
                +"FROM vuelos vue "
                +"LEFT JOIN pasajeros pa ON pa.COD_Vuelo = vue.COD_Vuelo "
                +"GROUP BY vue.COD_Vuelo;"
                );
        
        System.out.println("Relación Vuelos Pasajeros");
        System.out.println("--------------------------------");
        String formato = "%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s";
        System.out.printf(formato, "CódigoVuelo", "HoraSalida", "Destino", "Procedencia", "NumPasajeros", "NumFumadores", "NumPrimera", "NumTuristas");
        System.out.println(""); 
      
        
        while (rs.next()) {
            String codVuelo = rs.getString("COD_VUELO");
            String horaSalida = rs.getString("HORA_SALIDA").replaceAll("\n", "");            
            String destino = rs.getString("DESTINO").replaceAll("\n", "").trim();
            String procedencia = rs.getString("PROCEDENCIA").replaceAll("\n", "").trim();
            int canPasajeros = rs.getInt("CantidaPasajeros");
            int numFumadores = rs.getInt("NumeroFumadores");
            int numPro = rs.getInt("NumeroClasePri");
            int numTuris = rs.getInt("NumeroClaseTurista");
            
            System.out.printf(formato, codVuelo, horaSalida, destino, procedencia, canPasajeros, numFumadores, numPro, numTuris);
            System.out.println("");          
        }        
        
        rs.close();
        stmt.close();
        conn.close();
    }
}
