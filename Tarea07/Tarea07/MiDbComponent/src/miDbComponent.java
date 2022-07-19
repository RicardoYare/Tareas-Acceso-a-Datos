
import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


public class miDbComponent implements Serializable {    
    
    
    private PropertyChangeSupport propertySupport;    
   
    
    public miDbComponent() {
        propertySupport = new PropertyChangeSupport(this);
    }   

    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    
    static private int mode;
    
    final static int MY_SQL = 0;
    final static int POSTGRES_SQL = 1;
    
    static private String URL;
    static private String usuario;
    static private String pass;
    
    private int nregistro;   

    public void setNregistro(int nuevoNregistro) {
        int oldRegistro = this.nregistro;
        this.nregistro = nuevoNregistro;
        
        if (oldRegistro != this.nregistro) {
            
            propertySupport.firePropertyChange("nregistro", oldRegistro, nregistro);
            
        }
        
    }

    public int getNregistro() {
        return nregistro;
    }    
    
    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }    
  
    
    public boolean Connect(String URL, String usuario, String pass){  //Cuando se use el metodo se pondrá los valores de conexion y el num de registros
                                                                      //de la tabla pertinente
        boolean conexionEstado = false;
        
        this.URL = URL;
        this.usuario = usuario;
        this.pass = pass;
                    
        try {            
            Connection conn = DriverManager.getConnection(this.URL, this.usuario, this.pass); 
            conexionEstado = true; 
            
            java.sql.Statement sta = conn.createStatement();
            ResultSet rst = sta.executeQuery("SELECT COUNT(*) FROM actor;");
             
            while (rst.next()) {               
            
                 this.nregistro = rst.getInt(1);     //Fijo el numero de registros de la tabla          
            }           
            
            rst.close();
            sta.close();
            conn.close();            

        } catch (Exception e) {
            
            System.out.println(e);              
        }             
        
        return conexionEstado;
    }    
   
    public void AddActor(actor newactor){       
        
        switch (mode) {
            case MY_SQL:                
                try {   
                   Connection conn = null;
                   java.sql.Statement stmt = null; 
                    
                   conn = DriverManager.getConnection(this.URL, this.usuario, this.pass);             
                   stmt = conn.createStatement();                
                   String SQL = "INSERT INTO actor VALUES('"+newactor.getNombre()+"','"+newactor.getNacionalidad()+"',"+newactor.getFechaNacimiento()+");";
                   
                   stmt.executeUpdate(SQL);      
                   
                   ResultSet rst = stmt.executeQuery("SELECT COUNT(*) FROM actor;");
             
                    while (rst.next()) {            
            
                        setNregistro(rst.getInt(1));
                        
                      }    
                  
                 
                  rst.close();
                  stmt.close();
                  conn.close();                                 
                    
                } catch (Exception e) {
                    System.out.println(e);
                }            
                break;
            case POSTGRES_SQL:
                
                try {
                    
                   Connection conn = null;
                   java.sql.Statement stmt = null; 
                    
                   conn = DriverManager.getConnection(this.URL, this.usuario, this.pass);             
                   stmt = conn.createStatement();                
                   String SQL = "INSERT INTO actor VALUES('"+newactor.getNombre()+"','"+newactor.getNacionalidad()+"',"+newactor.getFechaNacimiento()+");";
                   
                   stmt.executeUpdate(SQL); 
                   
                   
                   ResultSet rst = stmt.executeQuery("SELECT COUNT(*) FROM actor;");
             
                    while (rst.next()) {            
            
                        setNregistro(rst.getInt(1));
                        
                      }    
                  
                 
                  rst.close();                                      
                  stmt.close();
                  conn.close();                  
                    
                } catch (Exception e) {
                    System.out.println(e);
                }                
                break;
        }
    
    }
   
     
}
