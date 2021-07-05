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
## Zadane 1 ceny przelotów
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

## Zad 2 ceny przelotów

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

# UTP4
## Zad 1
Zadanie badawczo-analityczne

klasa InputConverter - bezpieczeństwo fazy wykonania

Zobaczmy przykładowy fragment z poprzedniego zadania:
```
public static void main(String[] args) {
    /*
     *  definicja operacji w postaci lambda-wyrażeń:
     *  - flines - zwraca listę wierszy z pliku tekstowego
     *  - join - łączy napisy z listy (zwraca napis połączonych ze sobą elementów listy napisów)
     *  - collectInts - zwraca listę liczb całkowitych zawartych w napisie
     *  - sum - zwraca sumę elmentów listy liczb całkowitych
     */

    String fname = System.getProperty("user.home") + "/LamComFile.txt"; 
    InputConverter<String> fileConv = new InputConverter<>(fname);
    List<String> lines = fileConv.convertBy(flines);
    String text = fileConv.convertBy(flines, join);
    List<Integer> ints = fileConv.convertBy(flines, join, collectInts);
    Integer sumints = fileConv.convertBy(flines, join, collectInts, sum);

    System.out.println(lines);
    System.out.println(text);
    System.out.println(ints);
    System.out.println(sumints);

    List<String> arglist = Arrays.asList(args);
    InputConverter<List<String>> slistConv = new InputConverter<>(arglist);  
    sumints = slistConv.convertBy(join, collectInts, sum);
    System.out.println(sumints);
  }
```
Przy powierzchownej konstrukcji klasy InputConverter i metody convertBy następujący fragment:
```
 slistConv.convertBy(collectInts, sum); 
```
spowoduje powstanie wyjątku ClassCastException

Zadania badawcze: jak temu zaradzić w fazie wykonania programu, tak by uzyskiwać operacyjne wyniki (i nigdy NullPointerException)

To wymaga odpowiedniej definicji klasy InputConverter oraz ew. modyfikacji klasy Main (są tu dozwolone) .

## Zad 2 
Zadanie badawcze Przekazywanie wyjątków kontrolowanych z lambda-wyrażeń do obsługi w bloku otaczającym lambda.

Uwaga: w programie nie wolno definiować żadnych własnych interfejsów (za wyjątkiem być może rozszerzeń interfejsów z pakietu java.util.function), a więc operacje flines, join, itp. muszą opierać się na gotowych interfejsach funkcyjnych z pakietu java.util.function lub ich rozszerzeniach.

Operacja flines zawiera odczyt pliku, zatem może powstać wyjątek IOException. Wymagane jest, aby tę operację zdefiniowac jako lambda-wyrażenie. Ale z lambda wyrażeń, opierających się na interfejsach funkcyjnych z pakietu java.util.function, nie możemy przekazać obsługi wyjatków do otaczającego bloku. I wobec tego musimy pisać w definicji flines try { } catch { } Jak spowodować, aby nie było to konieczne i w przypadku powstania wyjątku IOException zadziałała klauzula throws metody main ?

## Zad 3
Zadanie. Lambda-wyrażenia dla niefunkcyjnych interfejsów ? Spowodować, by w programie, po naciśnięciu klawisza myszki na przycisku b na konsoli zostało wypisane "ok".

## Zad 4
Zadanie: dodatkowe operacje na listach

Stworzyć klasę XList, dostarczającą dodatkowych możliwości tworzenia list i operowania na nich. W klasie powinny znaleźć się odpowiednie konstruktory oraz statyczne metody of, umożliwiające tworzenie obiektów XList z innych kolekcji, tablic oraz argumentów podawanych przez przecinki.

Dodatkowo pomocnicze metody do tworzenia xlist z napisów:

ofChars(napis) - zwraca x-listę znaków napisu,
ofTokens(napis, [ sep ]) - zwraca x-listę symboli napisu, rozdzielonych separatorami z sep (jesśi brak - to białymi znakami).
Oprócz tego dostarczyć metod:

union(dowolna_kolekcja) - zwraca nową x-list z dołączaną do tej x-list zawartością kolekcji,
diff(dowolna_kolekcja) - zwraca x-list zawierającą te elementy tej x-list, które nie występują w kolekcji,
unique() - zwraca nową x-list, która zawiera wszystkie niepowtarzające się elementy tej x-list
combine() - zwraca x-listę list-kombinacji elementów z poszczególnych kolekcji, będących elementami tej x-listy
collect(Function) - zwraca nową x-listę, której elemenatmi są wyniki funkcji stosowanej wobec elementów tej x-listy,
join([sep]) - zwraca napis, będący połączeniem elementów tej x-listy, z ewentualnie wstawionym pomiędzy nie separatorem,
forEachWithIndex(konsumer_z_dwoma argumentami: element, index) - do iterowania po liście z dostępem i do elementów i do ich indeksów.


