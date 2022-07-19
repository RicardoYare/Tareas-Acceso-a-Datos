
import javax.xml.namespace.QName;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;


public class Main {

    
    public static void main(String[] args) throws XQException {

        XQDataSource xqs = new ExistXQDataSource();
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "8080");
        xqs.setProperty("user", "admin");
        xqs.setProperty("password", "root");

        XQConnection conn = xqs.getConnection();
        
        XQPreparedExpression consulta =  conn.prepareExpression("/bib/libro");
        XQResultSequence resultado = consulta.executeQuery();      
        
        while (resultado.next()) {   
                      
            String cad = resultado.getItemAsString(null);
            System.out.println(cad);           
            
        }     

        conn.close();
        
    }
    
}
