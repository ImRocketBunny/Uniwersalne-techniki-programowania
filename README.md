# UTP 1 Zadanie: tabela państw

Przedstawić w tabeli JTable państwa z pliku.

Plik powinien mieć następującą postać:
```
nazwa_kol1<TAB>nazwa_kol2<TAB> ....
nazwa_państwa1<TAB>stolica1<TAB> ludność1 ....

Na przykład:
Name    Capital    Population
Republic of Poland    Warsaw    38500
Chech Republic    Prague    10500 
Kingdom of Spain    Madrid    46599
```
Proszę zwrócić uwagę, że pola są rozdzielane przez znak tabulacji, liczba ludności podawana jest w tysiącach. Kolumny zawierające nazwy i stolice państw są nieedytowalne, natomiast dane z kolumny zawierającej ludność można edytować.

Plik powinien znajdować się w katalogu data projektu i mieć nazwę countries.txt

Wymaganiem podstawowym jest pokazanie państw w tabeli z użyciem następującej klasy Main, która uruchamia cały program:
```
import javax.swing.*;

public class Main {

  private JTable ctab;

  public void createTable(String countriesFileName) throws Exception {
    ctab = new CountryTable(countriesFileName).create();
  }

  public void showGui() {
    SwingUtilities.invokeLater( new Runnable() {
      public void run() {
        JFrame f = new JFrame("Countries table");
        f.add( new JScrollPane(ctab) );
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
      }
    });
  }

  public static void main(String[] args)  {
    Main main = new Main();
    try {
      main.createTable("data/countries.txt");
      main.showGui();
    } catch(Exception exc) {
      JOptionPane.showMessageDialog(null, "Table creation failed, " + exc);
    }
  }
}
```
Dodatkowe wymagania:

kolumny tabeli mają mieć nazwy z pierwszego wiersza pliku
dane o ludności mają być traktowane jako liczby
i pokazywane w tabeli jak liczby
pokazać w tabeli flagi państw (wymaga modyfikacji pliku państw i dodanie kolumny, pokazującej flagę jako grafikę)
zapewnić pokazywanie wszystkich państw świata (jakich narzędzi użyjemy, żeby to łatwo zrobić)
wyróżnić komórki z liczbą ludności dla państw z ludnością > 20 mln czerwonym kolorem pisma


# UTP 3 
# Zadane 1 ceny przelotów
Lista dest zawiera informacje o cenach przelotów w postaci napisów: port_wylotu port_przylotu cena_w_EUR

Należy utworzyć listę wynikową, której elementy będą opisywać ceny przelotów do poszczególnych miejsc (tylko) z Warszawy w PLN i wypisać na konsoli jej kolejne elementy.

Aby rozwiązać to zadanie, należy utworzyć sparametryzowaną klasę ListCreator, zawierającą: statyczną metodę collectFrom (lista) metodę when metodę mapEvery które działają w taki sposób, że symboliczny zapis:
```
collectFrom(list).when(lambda-1).mapEvery(lambda-2)
```
spowoduje utworzenie listy wynikowej, której elementy stanowią wybrane przez lambda-1 elementy listy list, przekształcone za pomocą podanego lambda-2.

Uwagi: w zadaniu nie wolno korzystać z własnych interfejsów, klasa ListCreator i jej metody powinny działać dla list (źródłowej i docelowej) elementów dowolnego typu.

Następujący (niemodyfikowalny poza miejsami oznaczonymi /<--/) program:
```
import java.util.*;

  public class Main {

    static List<String> getPricesInPLN(List<String> destinations, double xrate) {
      return ListCreator.collectFrom(destinations)
                         .when(  /*<-- lambda wyrażenie
                                  *  selekcja wylotów z Warszawy (zaczynających się od WAW)
                                  */
                          )
                         .mapEvery( /*<-- lambda wyrażenie
                                     *  wyliczenie ceny przelotu w PLN
                                     *  i stworzenie wynikowego napisu
                                     */
                          );
    }

    public static void main(String[] args) {
      // Lista destynacji: port_wylotu port_przylotu cena_EUR 
      List<String> dest = Arrays.asList(
        "bleble bleble 2000",
        "WAW HAV 1200",
        "xxx yyy 789",
        "WAW DPS 2000",
        "WAW HKT 1000"
      );
      double ratePLNvsEUR = 4.30;
      List<String> result = getPricesInPLN(dest, ratePLNvsEUR);
      for (String r : result) System.out.println(r);
    }
  }
```
ma wyprowadzić na konsolę napisy:

to HAV - price in PLN: 5160

to DPS - price in PLN: 8600

to HKT - price in PLN: 4300

Postać wydruku jest obowiązkowa.

# Zad 2 ceny przelotów

Lista dest zawiera informacje o cenach przelotów w postaci napisów: port_wylotu port_przylotu cena_w_EUR

Należy utworzyć listę wynikową, której elementy będą opisywać ceny przelotów do poszczególnych miejsc (tylko) z Warszawy w PLN i wypisać na konsoli jej kolejne elementy, używając następującego programu:
```
/*<-- niezbędne importy */

public class Main {

  public static void main(String[] args) {
    // Lista destynacji: port_wylotu port_przylotu cena_EUR 
    List<String> dest = Arrays.asList(
      "bleble bleble 2000",
      "WAW HAV 1200",
      "xxx yyy 789",
      "WAW DPS 2000",
      "WAW HKT 1000"
    );
    double ratePLNvsEUR = 4.30;
    List<String> result = 
    /*<-- tu należy dopisać fragment
     * przy czym nie wolno używać żadnych własnych klas, jak np. ListCreator
     * ani też żadnych własnych interfejsów
     */

    for (String r : result) System.out.println(r);
  }
}
```
Plik Main.java wolno modyfikować tylko w miejscach oznaczonych /*<-- */, a program ma wyprowadzić na konsolę:

to HAV - price in PLN: 5160

to DPS - price in PLN: 8600

to HKT - price in PLN: 4300

