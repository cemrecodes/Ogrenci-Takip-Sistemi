package ogrencitakip;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Cemre
 */
public class notlar {
    // constructor
    public notlar() {
    }
    
    // turkce ort bulan metod
    public static double turkceOrtBul(int no) throws SQLException{
        // sinav1 ve sinav2 tanimlandi
       int sinav1 = 0;
       int sinav2 = 0;
       // bir dbHelper objesi oluşturuldu
       DbHelper db = new DbHelper();
       // dbHelperin getConnection metoduyla bir baglanti olusturuldu
       Connection myConn = db.getConnection();
       // veri tabaninda bulunacak verinin stringi yazildi
       String mysqlQuery = "SELECT * FROM notlar WHERE no = '" + ogrenci.no +"'";
       // string PreparedStatement'a donusturuldu
       PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
       // veri tabanindan sonuc almak icin Result Set olusturuldu
       ResultSet resultSet = preparedStatement.executeQuery();
            
       // satirlar arasinda veri araniyor
            while (resultSet.next()){
                sinav1 = resultSet.getInt("turkce1");
                sinav2 = resultSet.getInt("turkce2");
                return (sinav1 + sinav2)/2;
            }
        return 0;
    }
    
    // mat ort bulan metod
    public static double matOrtBul(int no) throws SQLException{
       int sinav1 = 0;
       int sinav2 = 0;
       DbHelper db = new DbHelper();
       Connection myConn = db.getConnection();
       String mysqlQuery = "SELECT * FROM notlar WHERE no = '" + ogrenci.no +"'";
       PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                sinav1 = resultSet.getInt("mat1");
                sinav2 = resultSet.getInt("mat2");
                return (sinav1 + sinav2)/2;
            }
        return 0;
    }
    
    // ing ort bulan metod
    public static double ingOrtBul(int no) throws SQLException{
       int sinav1 = 0;
       int sinav2 = 0;
       DbHelper db = new DbHelper();
       Connection myConn = db.getConnection();
       String mysqlQuery = "SELECT * FROM notlar WHERE no = '" + ogrenci.no +"'";
       PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                sinav1 = resultSet.getInt("ing1");
                sinav2 = resultSet.getInt("ing2");
                return (sinav1 + sinav2)/2;
            }
        return 0;
    }
    
    // sos ort bulan metod
    public static double sosOrtBul(int no) throws SQLException{
       int sinav1 = 0;
       int sinav2 = 0;
       DbHelper db = new DbHelper();
       Connection myConn = db.getConnection();
       String mysqlQuery = "SELECT * FROM notlar WHERE no = '" + ogrenci.no +"'";
       PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                sinav1 = resultSet.getInt("sosyal1");
                sinav2 = resultSet.getInt("sosyal2");
                return (sinav1 + sinav2)/2;
            }
        return 0;
    }
    
    // fen ort bulan metod
    public static double fenOrtBul(int no) throws SQLException{
       int sinav1 = 0;
       int sinav2 = 0;
       DbHelper db = new DbHelper();
       Connection myConn = db.getConnection();
       String mysqlQuery = "SELECT * FROM notlar WHERE no = '" + ogrenci.no +"'";
       PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                sinav1 = resultSet.getInt("fen1");
                sinav2 = resultSet.getInt("fen2");
                return (sinav1 + sinav2)/2;
            }
        return 0;
    }
    
    // din ort bulan metod
    public static double dinOrtBul(int no) throws SQLException{
       int sinav1 = 0;
       int sinav2 = 0;
       DbHelper db = new DbHelper();
       Connection myConn = db.getConnection();
       String mysqlQuery = "SELECT * FROM notlar WHERE no = '" + ogrenci.no +"'";
       PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
       ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                sinav1 = resultSet.getInt("din1");
                sinav2 = resultSet.getInt("din2");
                return (sinav1 + sinav2)/2;
            }
        return 0;
    }
    
    // genel ort bulan metod
    public static double genelOrt(int no) throws SQLException{
        return (turkceOrtBul(no)+matOrtBul(no)+fenOrtBul(no)+sosOrtBul(no)+dinOrtBul(no)+ingOrtBul(no))/6;
    }
     
}
