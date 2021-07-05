/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args){
    Buffer buff=new Buffer();

    List<Thread> a1=new ArrayList<>();
    a1.add(new Thread(new Producer(buff)));
    a1.add(new Thread((new Consumer(buff))));
    for(Thread t:a1){
      t.start();
    }
  }
}
