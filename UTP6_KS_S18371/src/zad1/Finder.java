/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    List<String> slowa=new ArrayList<>();
    StringBuilder sb;
    String fname;
    int counterIF = 0;
    public Finder(String fname){
        this.fname=fname;
        String line="";
        File f1 = new File(fname);
        sb = new StringBuilder();

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            while ((line = br1.readLine()) != null) {
                if(!line.startsWith("//")){
                    Matcher m = Pattern.compile("\\bif\\b").matcher(line);
                    while(m.find()){
                        counterIF++;
                    }
                }
               sb.append(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getIfCount() throws IOException {
       /* int counter=0;
        String line2 ="";
        File f2 = new File(fname);
        BufferedReader br2 = new BufferedReader(new FileReader(f2));
        String sb2 = sb.toString();
        Matcher m = Pattern.compile("\\bif\\b").matcher(sb);
        while(m.find()){
            counter++;
        }*/
        return counterIF;
    }

    public int getStringCount(String wariant) {
        int counter=0;
        Matcher m = Pattern.compile("\\b"+wariant+"\\b|"+wariant).matcher(sb);
        while(m.find()){
            counter++;
        }

        return counter;
    }
}
