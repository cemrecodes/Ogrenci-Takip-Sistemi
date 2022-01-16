package ogrencitakip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Cemre
 */

// kisi classindan inherit alan ogrenci sinifi

public class ogrenci extends kisi {
    public static int no;
    public static String dogumTarihi;
    public static String sinif;
    public static String sinifHarf;
    
    //ogrenci constructor
    ogrenci(){
        
    }

    // getter ve setterlar
    public static int getNo() {
        return no;
    }

    public static void setNo(int no) {
        ogrenci.no = no;
    }

    public static String getDogumTarihi() {
        return dogumTarihi;
    }

    public static void setDogumTarihi(String dogumTarihi) {
        ogrenci.dogumTarihi = dogumTarihi;
    }

    public static String getSinif() {
        return sinif;
    }

    public static void setSinif(String sinif) {
        ogrenci.sinif = sinif;
    }

    public static String getSinifHarf() {
        return sinifHarf;
    }

    public static void setSinifHarf(String sinifHarf) {
        ogrenci.sinifHarf = sinifHarf;
    }

    public static String getAd() {
        return ad;
    }

    public static void setAd(String ad) {
        kisi.ad = ad;
    }

    public static String getSoyad() {
        return soyad;
    }

    public static void setSoyad(String soyad) {
        kisi.soyad = soyad;
    }
    
    
    // ogrenci girisini saglayan metod
    public static boolean ogrenciGiris(int no, JFrame frame){
        try{
            // bir dbHelper objesi oluşturuldu
            DbHelper db = new DbHelper();
            // dbHelperin getConnection metoduyla bir baglanti olusturuldu
            Connection myConn = db.getConnection();
            // veri tabaninda bulunacak verinin stringi yazildi
            String mysqlQuery = 
                    "SELECT no FROM ogrenciler WHERE no = '" +
                    no+"'";
            // string PreparedStatement'a donusturuldu
            PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
            // veri tabanindan sonuc almak icin Result Set olusturuldu
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // satirlar arasinda veri araniyor
            while (resultSet.next()){
                ogrenci.no = resultSet.getInt("no"); 
                // ogrenci veri tabaninda varsa true gonderecek
                return true;
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(frame, "Veri tabanı hatası: " + e.getMessage());
        }
        // ogrenci veri tabaninda yoksa false gonderecek
        return false;
    }

    // veri tabaninda ogrenci arayan metod
    public static boolean ogrenciAra(int no, JFrame frame){
        try{
            DbHelper db = new DbHelper();
            Connection myConn = db.getConnection();
            String mysqlQuery = 
                    "SELECT no FROM ogrenciler WHERE no = '" +
                    no+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                ogrenci.no = resultSet.getInt("no");               
                return true;
                // ogrenci veri tabaninda varsa true gonderecek
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(frame, "Veri tabanı hatası: " + e.getMessage());
        }
        // ogrenci veri tabaninda yoksa false gonderecek
        return false;
    }
    
       
    public static boolean notlardaOgrAra(int no, JFrame frame){
        try{
            DbHelper db = new DbHelper();
            Connection myConn = db.getConnection();
            String mysqlQuery = 
                    "SELECT no FROM notlar WHERE no = '" +
                    no+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){   
                // ogrenci veri tabaninda varsa true gonderecek
                return true;
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(frame, "Veri tabanı hatası: " + e.getMessage());
        }
        // ogrenci veri tabaninda yoksa false gonderecek
        return false;
    }

}
