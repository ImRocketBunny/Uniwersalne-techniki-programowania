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

# UTP5
## Zad 1
W pliku allwords.txt, znajdującym się w katalogu {user.home} zapisane są (rozdzielone białymi znakami) słowa. Znaleźć wszystkie anagramy, które można utworzyć z tych słów i wypisac je jako listy słów na konsoli w porządku liczby anagramów. Przy takiej samej liczbie anagramów listy wypisywane są w porządku alfabetycznym pierwszego słowa na liście.

Dla realizacji tego zadania w klasie Anagrams utworzyć metodę getSortedByAnQty(), która zwraca listę list słów będacych anagramami, uporządkowaną wedle podanych wyżej kryteriów. W klasie tej dostarczyć także metody String getAnagramsFor(String word), która zwraca napis, przedstwiający listę anagramów dla podanego słowa w postaci:
```
słowo: [ anagram1, anagram2, ... , anagramN]
```
Jeśli słowo nie ma nagramow lista jest pusta (po dwukropku mamy [] ). Jesli podanego słowa nie ma w pliku allwords.txt to po dwukropku powinnien znaleźć się napis null.

Słowa dla których będziemy szukać anagramów, wczytywane są z pliku o nazwie {user.home}/wordsToFind.

Przykładowo, jeśli plik allwords.txt zawiera słowa:
```
andes danes deans evil gals lags levi live sedan
slag streets testers uprising veil vile
```
a plik wordsToFind słowa:
```
evil streets uprising
```
to program (zaczynający wykonanie od obowiązkowej klasy Main) powinien wyprowadzić następującą informację
```
[evil, levi, live, veil, vile]
[andes, danes, deans, sedan]
[gals, lags, slag]
[streets, testers]
[uprising]
************************
evil: [levi, live, veil, vile]
streets: [testers]
uprising: []
```
## Zad 2
W pliku customers.txt umieszczonym w katalogu {user.home} znajdują się dane o zakupach klientów w postaci:

id_klienta; nazwisko i imię; nazwa_towaru;cena;zakupiona_ilość

Identyfikator klienta ma postać

```
cNNNNN
gdzie N cyfra ze zbioru [0...9]
np.
c00001;Kowalski Jan;bułka;2;100
```
Wczytać dane z pliku i wypisać na konsoli w kolejnych wierszach: poprzedzone napisem "Nazwiska" dane posortowane wg nazwisk w porządku rosnącym (porządek rekordów z tymi samymi nazwiskami jest określany przez identyfikatory klientów - rosnąco),

poprzedzone napisem "Koszty" dane posortowane wg kosztów zakupów w porządku malejącym (porządek rekordów z tymi samymi kosztami jest określany przez identyfikatory klientów - rosnąco) z dodatkowym dopiskiem na końcu w nawiasach: koszty: kosztZakupu (np. (koszt: 200.0)),

poprzedzone napisem "Klient c00001" dane o wszystkich zakupach klienta o identyfikatorze "c00001" (w odrębnych wierszach)

poprzedzone napisem "Klient c00002" - w odrębnych wierszach -dane o wszystkich zakupach klienta o identyfikatorze "c00002" (w odrebnych wierszach) (a więc uwaga: w pliku muszą być klienci o identyfikatorach c00001 i c00002)

Np. dla pliku w postaci:
```
c00004;Nowak Anna;banany;4.0;50.0
c00003;Kowalski Jan;mleko;4.0;5.0
c00001;Kowalski Jan;mleko;4.0;10.0
c00001;Kowalski Jan;mleko;5.0;2.0
c00002;Malina Jan;mleko;4.0;2.0
c00002;Malina Jan;chleb;3.0;5.0
c00001;Kowalski Jan;bulka;2.0;100.0
```
Nazwiska
```
c00001;Kowalski Jan;mleko;4.0;10.0
c00001;Kowalski Jan;mleko;5.0;2.0
c00001;Kowalski Jan;bulka;2.0;100.0
c00003;Kowalski Jan;mleko;4.0;5.0
c00002;Malina Jan;mleko;4.0;2.0
c00002;Malina Jan;chleb;3.0;5.0
c00004;Nowak Anna;banany;4.0;50.0
```
Koszty
```
c00001;Kowalski Jan;bulka;2.0;100.0 (koszt: 200.0)
c00004;Nowak Anna;banany;4.0;50.0 (koszt: 200.0)
c00001;Kowalski Jan;mleko;4.0;10.0 (koszt: 40.0)
c00003;Kowalski Jan;mleko;4.0;5.0 (koszt: 20.0)
c00002;Malina Jan;chleb;3.0;5.0 (koszt: 15.0)
c00001;Kowalski Jan;mleko;5.0;2.0 (koszt: 10.0)
c00002;Malina Jan;mleko;4.0;2.0 (koszt: 8.0)
```
Klient c00001
```
c00001;Kowalski Jan;mleko;4.0;10.0
c00001;Kowalski Jan;mleko;5.0;2.0
c00001;Kowalski Jan;bulka;2.0;100.0
```
Klient c00002
```
c00002;Malina Jan;mleko;4.0;2.0
c00002;Malina Jan;chleb;3.0;5.0
```
Uwaga: programy nie dające pokazanej formy wydruku otrzymują 0 punktów.

Niezbędne jest stworzenie klasy, opisującej zakupy klientów (Purchase) i operowanie na jej obiektach. Nie przyjmuję rozwiązań działających na "surowych" Stringach.

Aplikacja powinna zawierać klasy Purchase, CustomersPurchaseSortFind oraz Main. Ta ostatnia ma obowiązakową postać (nie wolno jej zmienić):
```
public class Main {

    public static void main(String[] args)  {
      CustomersPurchaseSortFind cpsf = new CustomersPurchaseSortFind();
      String fname = System.getProperty("user.home") + "/customers.txt";
      cpsf.readFile(fname);
      cpsf.showSortedBy("Nazwiska");
      cpsf.showSortedBy("Koszty");

      String[] custSearch = { "c00001", "c00002" };

      for (String id : custSearch) {
        cpsf.showPurchaseFor(id);
      }
    }

  }
```
Generator projektów utworzy wymagane klasy.

Wykonanie programu rozpoczyna się od metody main(...) w klasie Main.

Uwaga: nazwa pliku jest obowiązkowe. Niespełnienie tego warunku skutkuje brakiem punktów. Utworzona przez generator projektów klasa Main zawiera fragment pomocny dla uzyskania wymaganej nazwy pliku.

Uwaga: aby dowiedzieć się który katalog jest {user.home} i umieścić w nim plik testowy można z poziomu Javy użyć: System.getProperty("user.home"); Np. jeśli identyfikatorem użytkownika jest Janek, to w Windows 7 katalog {user.home} to C:\Users\Janek.

Należy samodzielnie utworzyć testowy plikii umieścić je w katalogu {user.home}.

## Zad 3

Firma software’owa prowadzi projekty w różnych językach programowania. Plik Prpgrammers.tsv z katalogu {user.home} zawiera informacje o programistach w postaci:
```
język1<TAB>nazwisko(1)<TAB>nazwisko(2)<TAB> itd
język2<TAB>nazwisko(1)<TAB>nazwisko(2)<TAB> itd
```
Stworzyć klasę ProgLang, mającą:

konstruktor ProgLang(String nazwaPliku), w którym następuje wczytanie pliku o podanej nazwie,
metodę getLangsMap() – zwracająca mapę, w której pod kluczem nazwa języka znajduje się kolekcja programistów tego języka,
metodę getProgsMap() – zwracającą mapę, w której pod kluczem nazwisko programisty znajduje się kolekcja języków, w których programuje,
metodę getLangsMapSortedByNumOfProgs() – zwracającą mapę z wejściami język -> kolekcja programistów. uporządkowaną malejąco według liczby osób znających poszczególne języki, w przypadku równej liczbu porządek jest alfabetyczny wg nazw języków,
metodę getProgsMapSortedByNumOfLangs() – zwracającą mapę z wejścimi programista -> kolekcja językow, uporządkowaną malejąco wg liczby języków znanych programiści; w przypadku równej liczby porządek jest alfabetyczny wg nazwisk,
metodę getProgsMapForNumOfLangsGreaterThan(int n) – zwracającą mapę z wejściami programista -> kolekcja języków, dla ktorych liczba języków jest większa od podanego n.
metodę sorted(…), wołaną z argumentami mapa i lambda-wyrażenie. Metoda zwraca posortowaną wersję dowolnej mapy przekazanej jako piewrszy argument, a porządek sortowania jest określony przez lambda wyrażenia, podane jako drugi argument,
metodę filtered(…) z argumentami: dowolna mapa i lambda. Metoda zwraca mapę, która zawiera tylko te wejścia z przekazanej jako pierwszy argument mapy, które spelniają warunek podany jako drugi argument (lambda z wynikiem typu boolean).
Metod sorted(…) lub filtered(…) użyć w oprogramowaniu innych, odpowiednich, metod klasy. Mają one jednak ogólniejsze znaczenia, bo mogą być używane dla dowolnych innych map z warunkami sortowania czy filtrowania, zadawanymi przez własściwe w danych przypadkach lambdy.

Programmers.tsv:

```
Groovy	Z	Y	X	D
Java	V	B	C	D	A	Z
C++	G	J	H
C#	P	S	Q	V	D
Scala	A	D	A
```
Uwagi:

zgodność informacji wyjściowej z oczekiwanym wynikiem (w tym kolejność pokazywania danych) jest istotna – wynika z zastosowania odpowiednich map i innych klas kolekcyjnych. Uniwersalność metod sorted i filtered (możliwość ich zastosowania dla innych niż w zadaniu map).W klasie ProgLang nie wolno używac surowych typów.

# UTP6
## Zad 1


## Zad 2

Zadanie 'FileVisitor':

Katalog {user.home}/UTP6dir zawiera pliki tekstowe (z rozszerzeniem .txt) umieszczone w różnych podkatalogach. Kodowanie plików to Cp1250. Przeglądając rekursywnie drzewo katalogowe, zaczynające się od {user.home}/UTP6dir, wczytać wszystkie te pliki. i połączoną ich zawartość zapisać do pliku o nazwie UTP6res.txt, znadującym się w katalogu projektu. Kodowanie pliku UTP6res.txt winno być UTF-8.

Uwagi:

trzeba dostarczyć definicji klasy Futil,
należy zastosować FileVisitor do przeglądania katalogu,
nalezy zalożyć, że na starcie programu wynikowego pliku nie ma.

# UTP7

# UTP8

## Zad 1

# UTP10

## Zad 1
Napisać prosty kalkulator dla liczb typu BigDecimal. Obliczenia mają być podawane jako argumenty wiersza poleceń w postaci:
```
liczba1 op liczba2
```
gdzie op jeden ze znaków +,- (minus), * (mnożenie), / (dzielenie), a pomiędzy liczba1, op i liczba2 występuje jeden lub więcej białych znaków.

Obliczenia zrealizować w klasie Calc jako metodę String doCalc(String cmd), zwracająca napisową reprezentację wyniku (uzyskanej liczby) lub napis "Invalid command to calc", jeśli wystąpią jakiekolwiek błędy.

Następująca klasa Main::
```
public class Main {
  
  public static void main(String[] args) {
    Calc c = new Calc();
    String wynik = c.doCalc(args[0]);
    System.out.println(wynik);
  }
}
```
po uruchomieniu winna wyprowadzić na konsolę wynik obliczenia (np. jesli podano jako argument wiersza poleceń "1 / 2" , to wynikiem powinine być napis 0.5.

Jeśli liczba wynikowa nie ma dokładnej reprezentacji (jak np. wynik dzielenia 1/3), to wynik powinien być pokazany z dokładnością co najmniej 7 miejsc dziesiętnych.

Uwaga : W zadnej z klas programu nie wolno używać instrukcji if, ani switch, ani operatora warunkowego, ani instrukcji for, ani isntrukcji while.

## Zad 2

Zdefiniować klasę JavaBean o nazwie Purchase z trzema właściwościami: prod (String), data (typu String) i price (typu Double). Własciwość prod jest prosta, właściwości data i price są związane (bounded), włąsciwośc price jest dodatkowo ograniczane (constrained). Za pomoca mechanizmu nasłuchu i wetowania zmian właściwości umożliwić: wypisywanie na konsoli wszystkich zmian dat i cen, kontrolę poprawności zmian: nie można zmienić ceny na liczbę mniejszą od 1000.

Program powinien wypisać na konsoli:

```
Purchase [prod=komputer, data=nie ma promocji, price=3000.0]
Change value of: data from: nie ma promocji to: w promocji
Change value of: price from: 3000.0 to: 2000.0
Purchase [prod=komputer, data=w promocji, price=2000.0]
Price change to: 500.0 not allowed
Purchase [prod=komputer, data=w promocji, price=2000.0]
```

