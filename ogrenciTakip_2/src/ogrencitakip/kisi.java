package ogrencitakip;

/**
 *
 * @author Lenovo
 */
public class kisi {

    // constructor
    public kisi() {
    }
            
    public static String ad;
    public static String soyad;

    // getter setter
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

    @Override
    public String toString() {
        return "kisi{" + '}';
    }
       
}
