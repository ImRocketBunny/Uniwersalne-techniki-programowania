package zad1;


import java.util.concurrent.Callable;

public class Consumer implements Runnable {
    Buffer b;
    int licznik=0;
    double waga = 0.0;
    public Consumer(Buffer b){
        this.b=b;
    }

    @Override
    public void run() {
        while (true){
            waga+=b.get().getWaga();
            licznik++;
            b.licznikP++;
            if(licznik%100==0){
                System.out.println("policzono wage "+licznik+" towarów");
            }
            //System.out.println(b.isDone==true&&b.licznikP==b.licznikU);
            if(b.isDone==true&&b.licznikP==b.licznikU){
                System.out.println("Waga wszytskich towarow: "+waga);
                break;
            }



        }




    }
}
