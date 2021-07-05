/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad2;


import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class CustomersPurchaseSortFind {
    Purchase purchase;
    List<Purchase> listaAll=null;
    public CustomersPurchaseSortFind(){
        super();
    }
    public /*List<Purchase>*/ void readFile(String fname) {
        listaAll=new ArrayList<Purchase>();
        String line =  "";
        try {
            File fs = new File(fname);
            BufferedReader br1 = new BufferedReader(new FileReader(fs));
            while ((line=br1.readLine())!=null){
                String[] words2 = line.split(";| ");
                purchase=new Purchase(words2[0],words2[1],words2[2],words2[3],Double.parseDouble(words2[4]),Double.parseDouble(words2[5]),Double.parseDouble(words2[4]) * Double.parseDouble(words2[5]));
                listaAll.add(purchase);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return listaAll;
    }

    public void showSortedBy(String sortBy) {
        Comparator<Purchase> Nazwisko = Comparator.comparing(Purchase::getNazwisko).thenComparing(Purchase::getId_klienta);
        Comparator<Purchase> Koszty = Comparator.comparing(Purchase::getKoszt).thenComparing(Purchase::getId_klienta);
        Comparator<Purchase> pierwszy = Comparator.comparing(Purchase::getId_klienta);
        Comparator<Purchase> drugi = Comparator.comparing(Purchase::getKoszt);
        if(sortBy=="Nazwiska"){
            System.out.println(sortBy);
            listaAll.stream().sorted(Nazwisko).forEach(System.out::println);
        }
        if(sortBy=="Koszty"){
            List<Purchase> listaSort= new ArrayList<Purchase>();
            List<Purchase> listaSort2= new ArrayList<Purchase>();

            System.out.println(sortBy);
            listaAll.sort(pierwszy);
            for(int i = listaAll.size()-1; i >=0;i--){
                listaSort.add(listaAll.get(i));
            }
            listaSort.sort(drugi);
            for(int i = listaSort.size()-1; i >=0;i--){
                listaSort2.add(listaSort.get(i));
            }
            listaSort2.forEach(e->{
                System.out.println(e+" (koszt: "+e.getKoszt()+")");
            });

        }
        System.out.println();
    }

    public void showPurchaseFor(String id) {
        System.out.println("Klient "+id);
        listaAll.stream().filter(e->id.equals(e.getId_klienta())).forEach(System.out::println);
        System.out.println();
    }
}
