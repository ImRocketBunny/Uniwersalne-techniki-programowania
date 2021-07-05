package zad1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Letters extends Thread{
    List<Thread> watki = new ArrayList<>();
    String abcd;
    public Letters(){

    }
    public Letters(String abcd){
        for(int i = 0; i < abcd.length(); i++) {
            String litera = String.valueOf(abcd.charAt(i));
            Runnable myThread = () -> {
                while (true) {
                    try {
                        System.out.print(litera);
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        break;
                    }
                }
            };
            watki.add(new Thread(myThread, "Thread " + litera));
        }
    }
    public List<Thread> getThreads(){
        return watki;
    }

}
