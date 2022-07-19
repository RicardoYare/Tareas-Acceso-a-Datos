import java.sql.*;



public class Punto6 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
      
        String user = "root";
        String pass = "root";
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tarea03aed", user, pass);  
        
        stmt = conn.createStatement();
        String SQL = "UPDATE pasajeros SET FUMADOR ='NO' WHERE FUMADOR='SI'";
        stmt.executeUpdate(SQL); 

        System.out.println("Cambio Efectuado");  

        rs = stmt.executeQuery("SELECT vue.COD_Vuelo,"
            +"SUM(CASE WHEN pa.FUMADOR = \"SI\" then 1 else 0 end) AS NumeroFumadores,"
            +"SUM(CASE WHEN pa.FUMADOR = \"NO\" then 1 else 0 end) NumeroNOFumadores "               
            +"FROM vuelos vue "
            +"LEFT JOIN pasajeros pa ON pa.COD_Vuelo = vue.COD_Vuelo "
            +"GROUP BY vue.COD_Vuelo;"
            );

        System.out.println("--------------------------------");
        String formato = "%-20s%-20s%-20s";
        System.out.printf(formato, "Codigo Vuelo", "NumeroFumadores", "NumeroNOFumadores");
        System.out.println(""); 

        while (rs.next()) {

            String codVuelo = rs.getString("COD_VUELO");
            String tipoPlaza = rs.getString("NumeroFumadores");
            String fumador = rs.getString("NumeroNOFumadores");     

            System.out.printf(formato, codVuelo, tipoPlaza, fumador);
            System.out.println("");  

        }               
        
        rs.close();
        stmt.close();
        conn.close();
    }   
    
    
}