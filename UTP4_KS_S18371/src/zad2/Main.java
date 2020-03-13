/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad2;


import zad1.InputConverter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*<-- niezbędne import */

public class Main {
  public static void main(String[] args) throws IOException {
    Flines<String,List<String>> flines = e -> Files.readAllLines(Paths.get(e));
    Function<List<String>,String> join = e->{
      StringBuilder sb = new StringBuilder();
      Iterator iterator= e.iterator();
      while(iterator.hasNext()) {
        String stringTmp = (String)iterator.next();
        sb.append(stringTmp);
      }
      return sb.toString();
    };

    Function<List<Integer>,Integer> sum = e->{
      int s = 0;
      for(int i = 0;i<e.size();i++){
        s+=e.get(i);
      }
      return s;
    };
    CollectInts<String, List<Integer>> collectInts = e-> {
      List<Integer> listaTym = new ArrayList();
      Pattern pt1 = Pattern.compile("\\d+");
      Matcher mc1 = pt1.matcher(e);

      while(mc1.find()){
        listaTym.add(Integer.valueOf(mc1.group()));
      }
      return listaTym;
    };

    /*<--
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

    // Zadania badawcze:
    // Operacja flines zawiera odczyt pliku, zatem może powstac wyjątek IOException
    // Wymagane jest, aby tę operację zdefiniowac jako lambda-wyrażenie
    // Ale z lambda wyrażeń nie możemy przekazywac obsługi wyjatków do otaczającego bloku
    // I wobec tego musimy pisać w definicji flines try { } catch { }
    // Jak spowodować, aby nie było to konieczne i w przypadku powstania wyjątku IOException
    // zadziałała klauzula throws metody main
  }
}
