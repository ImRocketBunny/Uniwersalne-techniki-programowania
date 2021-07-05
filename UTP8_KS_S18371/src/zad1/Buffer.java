package zad1;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    boolean isDone;
    int licznikU,licznikP;
    List<Towar> lista;
    int s;
    long linie;
    public Buffer(){
        lista=new ArrayList<>();
        s=0;
        isDone=false;
        licznikP=0;
        licznikU=0;
        linie=0;
    }

    synchronized Towar get(){
        while(s==0){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        notify();
        Towar t1 = lista.get(0);
        lista.remove(0);
        s--;
        return t1;

    }

    synchronized void put(Towar t) {
        while(s>0){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        //System.out.println(6);
        notify();
        //System.out.println("dodalem");
        lista.add(t);
        s++;
        //System.out.println(lista.size());

    }

}
