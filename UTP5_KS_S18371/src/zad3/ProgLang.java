package zad3;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgLang<K, V> {
    Map<K, V> mapaJez;
    List<K> lista;
    List<List> listaAll;
    //String pliki;
    Map<K,List<V>> mapaProg;
    //Map<K,Programista> mapaProgramistow;
    Map<K,V> mapaProgramistow2;

    public ProgLang(String pliki)  {
        mapaJez= new LinkedHashMap<K,V>();
        try{
            BufferedReader bf = new BufferedReader(new FileReader(pliki));
            String line = "";
            while((line=bf.readLine())!=null){
                String[] splity = line.split("\\t");
                lista = new ArrayList<K>();
                for(int i = 1; i < splity.length;i++){
                    if(!lista.contains(splity[i])) {
                        lista.add((K)splity[i]);
                    }
                }
                mapaJez.put((K)splity[0],(V)lista);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<K,V> getLangsMap() {
        return (Map<K, V>) mapaJez;
    }

    public Map<K, List<V>> getProgsMap() {
        mapaProg=new LinkedHashMap<K, List<V>>();
        for (K klucz : mapaJez.keySet()) {
            for(V nazwa:(List<V>)mapaJez.get(klucz)){
                if(mapaProg.containsKey(nazwa)){
                    mapaProg.get(nazwa).add((V)klucz);

                }
                else{
                    List<V> jezyki = new ArrayList<>();
                    jezyki.add((V)klucz);
                    mapaProg.put((K)nazwa, jezyki);
                }
            }
        }
        //System.out.println(mapaProg.toString());
        return  mapaProg;
    }




    public Map<K,V> getLangsMapSortedByNumOfProgs() {
        Map<K,V> map = new LinkedHashMap<>();
            map= sorted(this.mapaJez,((e1,e2) -> {
            List<V> l1 = (List<V>) e1.getValue();
            List<V> l2 = (List<V>) e2.getValue();
            Integer s1 = l1.size();
            Integer s2 = l2.size();
            return s2.compareTo(s1);
        }));
        return map;
    }


    public Map<K,List<V>> getProgsMapSortedByNumOfLangs() {
        Map<K,List<V>> map = new LinkedHashMap<>();
        map =sorted(this.mapaProg,(e1,e2)->{
            List<V> l1 = e1.getValue();
            List<V> l2 = e2.getValue();
            Integer i1 = l1.size();
            Integer i2=l2.size();
            return i2.compareTo(i1);
        });
        return map;

    }



    public Map<K,List<V>> getProgsMapForNumOfLangsGreaterThan(int i) {
        Map<K, List<V>> map = new LinkedHashMap<>();
                map = filtered(this.mapaProg,e->(e.getValue().size()>i));
        return map;

    }


    public <K, V>Map<K, V> sorted(Map<K, V> map, Comparator<Map.Entry<K,V>> comparator) {
        return map.entrySet().stream().sorted(comparator).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public <K, V> Map<K, V> filtered(Map<K, V> map, Predicate<Map.Entry<K, V>> predicate) {
        return map.entrySet().stream().filter(predicate).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }




}
