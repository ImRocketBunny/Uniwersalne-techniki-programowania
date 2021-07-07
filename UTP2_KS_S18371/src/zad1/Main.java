/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;



import java.util.*;

public class Main {
  public Main() {
    List<Integer> src1 = Arrays.asList(/*3, 5, 6, 7, 12*/1, 7, 9, 11, 12);
    System.out.println(test1(src1));

    List<String> src2 = Arrays.asList(/*"55555", "1", "4444"*/"a", "zzzz", "vvvvvvv" );
    System.out.println(test2(src2));
  }

  public List<Integer> test1(List<Integer> src) {
    Selector sel = new Selector<Boolean>(){
        @Override
        public boolean select(Object o) {
            if((Integer)o > 10) {
                return false;
            }
            return true;

        }
    };
    Mapper  map = new Mapper<Integer,Integer>() {
        @Override
        public Integer map(Integer i) {
            int x = i;
            x += 10;
            return x;
        }
    };
    return    ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public List<Integer> test2(List<String> src) {
     Selector sel = new Selector<Boolean>() {

        @Override
        public boolean select(Object o) {
            String x = (String)o;
            if(x.length() < 3){
                return false;
            }
            return true;

        }
    };
    Mapper map = new Mapper<String, Integer>() {
        @Override
        public Integer map(String str) {
            int x = str.length() + 10;
            return x;
        }

    };
    return   ListCreator.collectFrom(src).when(sel).mapEvery(map);
  }

  public static void main(String[] args) {
    new Main();
  }
}
