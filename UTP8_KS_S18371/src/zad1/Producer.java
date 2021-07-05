package zad1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Producer implements Runnable {
    File file1= new File("..//Towary.txt");
    Buffer b;
    int licznik=0;

    public Producer(Buffer b){
        this.b=b;
    }
    @Override
    public void run() {
        String line = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            b.linie=Files.lines(Paths.get("..//Towary.txt")).count();
            while ((line=br1.readLine())!=null){
                String[]words = line.split(" ");
                Towar t = new Towar(Integer.parseInt(words[0]),Double.parseDouble(words[1]));
                b.put(t);
                licznik++;
                b.licznikU++;
                if(licznik%200==0){
                    System.out.println("utworzono "+licznik+" obiektow");
                }
                if(b.licznikU==b.linie){
                    b.isDone=true;
                }

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //b.isDone=true;

        //System.out.println(b.isDone);



    }
}
