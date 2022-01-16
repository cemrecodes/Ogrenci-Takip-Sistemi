package ogrencitakip;
/**
 *
 * @author Cemre
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

// tekrar tekrar mysql username,password ve url'unu yazmamak icin DbHelper sinifi olusturuldu

public class DbHelper {
    static String username = "root";
    static String password = "cemre2002";
    static String dbUrl = "jdbc:mysql://localhost:3306/proje";
    
    //Connection olusturucu metod olusturuldu
    public Connection getConnection() throws SQLException {
        return (Connection) DriverManager.getConnection(dbUrl,username,password);
        
    }
    public void ShowError(SQLException exception){
        System.out.println("Error: "+ exception.getMessage());
        System.out.println("Error Kodu: "+ exception.getErrorCode());
        
    }
}
