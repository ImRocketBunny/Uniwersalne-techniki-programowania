/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    List<String> wyraz;
    List<List> wszystkie;
    List<String> tmp;
    List<String> tmp2;
    File file;
    char[] t1;
    char[] t2;
    public Anagrams(String words){
        wyraz=new ArrayList<String>();
        String line="";
        file =new File(words);
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file));
            while((line = br1.readLine())!=null){
                String[] words2 = line.split(" ");
                for(int i =0; i < words2.length;i++){
                    wyraz.add(words2[i]);
                }
            }

        }catch(Exception e){
            e.printStackTrace();

        }
    }

    public List<List> getSortedByAnQty() {
        wszystkie=new ArrayList<List>();
        tmp = new ArrayList<String>();
        for(int i = 0; i < wyraz.size();i++){
            if(!tmp.contains(wyraz.get(i))){
                tmp2=new ArrayList<String>();
                for(int j = 0; j < wyraz.size();j++){
                    t1 = wyraz.get(i).toCharArray();
                    t2 = wyraz.get(j).toCharArray();
                    Arrays.sort(t1);
                    Arrays.sort(t2);
                    if(Arrays.equals(t1,t2)){
                        tmp.add(wyraz.get(j));
                        tmp2.add(wyraz.get(j));
                    }
                }
                wszystkie.add(tmp2);
            }
        }
        wszystkie.sort((o1,o2)->o2.size()-o1.size());
        return wszystkie;
    }

    public String  getAnagramsFor(String next) {
        for(int i = 0; i < wszystkie.size();i++){
            tmp = new ArrayList<String>(wszystkie.get(i));
            for(int j = 0; j<tmp.size();j++){
                if(tmp.get(j).equals(next)) {
                    tmp.remove(j);
                    return next+": " + tmp;
                }
            }
        }
        return "";
    }

}
