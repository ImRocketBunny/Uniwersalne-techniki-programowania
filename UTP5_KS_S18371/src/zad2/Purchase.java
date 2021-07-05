/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad2;


public class Purchase {
    String id_klienta;
    String nazwisko;
    String imie;
    String nazwaTowaru;
    double cena;
    double ilosc;
    double koszt;

    public Purchase(String id_klienta,String nazwisko, String imie, String nazwaTowaru, double cena, double ilosc, double koszt) {
        this.id_klienta = id_klienta;
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.nazwaTowaru = nazwaTowaru;
        this.cena = cena;
        this.ilosc = ilosc;
        this.koszt = koszt;
    }
    public String toString(){
        return id_klienta+";"+nazwisko+" "+imie+";"+nazwaTowaru+";"+cena+";"+ilosc;

    }
    String getId_klienta(){
        return id_klienta;
    }
    String getNazwisko(){
        return  nazwisko;
    }
    String getImie(){
        return imie;
    }
    String getNazwaTowaru(){
        return nazwaTowaru;
    }
    Double getKoszt(){
        return koszt;
    }
}
