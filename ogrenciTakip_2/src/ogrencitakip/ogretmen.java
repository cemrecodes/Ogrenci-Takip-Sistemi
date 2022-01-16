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

// kisi classindan inherit alan ogretmen sinifi

public class ogretmen extends kisi {
    public static String sifre;
            
    public static boolean ogretmenGiris(String ogretAd, String ogretSoyad, String ogretSifre, JFrame frame){
        try{
            // bir dbHelper objesi oluşturuldu
            DbHelper db = new DbHelper();
            // dbHelperin getConnection metoduyla bir baglanti olusturuldu
            Connection myConn = db.getConnection();
            // veri tabaninda bulunacak verinin stringi yazildi
            String mysqlQuery = 
                    "SELECT ad, soyad, sifre FROM ogretmenler WHERE Ad = '" +
                    ogretAd+
                    "'AND Soyad = '" +
                    ogretSoyad+
                    "'AND Sifre = '" +
                    ogretSifre+
                    "'";
            // string PreparedStatement'a donusturuldu
            PreparedStatement preparedStatement = myConn.prepareStatement(mysqlQuery);
            // veri tabanindan sonuc almak icin Result Set olusturuldu
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()){
                // satirlar arasinda veri araniyor
                kisi.ad = resultSet.getString("ad");
                kisi.soyad = resultSet.getString("soyad");
                ogretmen.sifre = resultSet.getString("sifre");
                
                // ogretmen veri tabaninda varsa true gonderecek
                return true;
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(frame, "Veri tabanı hatası: " + e.getMessage());
        }
        // ogretmen veri tabaninda yoksa false gonderecek
        return false;
    }

}
