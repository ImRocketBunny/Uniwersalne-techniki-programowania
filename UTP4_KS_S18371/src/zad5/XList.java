package zad5;

import zad2.CollectInts;


import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class XList<T> extends ArrayList<T> {

        public XList() {
            super();
        }

        public XList(T...args) {
            super(Arrays.asList(args));
        }

        public XList(Collection<T> c) {
            super(c);
        }

        public static<T> XList<T> of(T... args) {
            return new XList<T>(args);
        }

        public static<T> XList<T> of(Collection<T> c) {
            return new XList<T>(c);
        }

        public static <T> XList<T> charsOf(String string) {
            List returnList  = new ArrayList<>();
            for (int i = 0; i < string.length(); i++) {
                returnList.add(String.valueOf(string.charAt(i)));
            }
            return new XList<T>(returnList);
        }

        public static <T> XList<T> tokensOf(String... string) {
            List returnList = null;
            if(string.length == 1) {
                returnList = new ArrayList<String>(Arrays.asList(string[0].split("\\s")));
            }else {
                returnList = new ArrayList<String>(Arrays.asList(string[0].split(string[string.length - 1])));
            }
            return new XList<T>(returnList);
        }

        public XList<T> union(T... args) {
            List<T> returnList = this;

            returnList.addAll(Arrays.asList(args));
            return new XList(returnList);
        }

        public XList<T> union(Collection<T> c) {
            List<T> returnList = this;

            returnList.addAll(c);
            return new XList(returnList);
        }

        public XList<T> diff(Collection<T> c) {
            List<T> returnList = this;
            this.removeAll(c);
            return new XList<T>(returnList);
        }

        public XList<T> unique() {
            List<T> returnList = this.stream().distinct().collect(Collectors.toList());
            return new XList<T>(returnList);
        }

        public <T> XList<XList<T>> combine() {
            List<Integer> inty = new ArrayList<Integer>();
            inty.add(1);
            for(int i=0; i<this.size(); i++) {
                inty.add(inty.get(i)*((List<T>)this.get(i)).size());
            }
            List<XList<T>> lista1 = new ArrayList<XList<T>>();
            for(int i=0; i<inty.get(inty.size()-1); i++) {
                lista1.add(new XList<T>());
            }
            for(int i=0; i<this.size(); i++) {
                int licznik = 0;
                int index = 0;
                for(int j=0; j<lista1.size(); j++) {
                    if(licznik>=inty.get(i)) {
                        licznik = 0;
                        index++;
                    }
                    lista1.get(j).add(((List<T>)this.get(i)).get(index%((List<T>)this.get(i)).size()));
                   licznik++;
                }
            }
            XList<XList<T>> x = new XList<XList<T>>(lista1);
            return x;
        }


        public <R> XList<R> collect(Function<T, R> f) {
            List<R> returnList = new ArrayList<R>();
            for (R r : returnList) {
                returnList.add(f.apply((T) r));
            }
            return new XList<R>(returnList);
        }
        public String join(String string) {
            StringBuilder sB = new StringBuilder();
            for (T t : this) {
                sB.append(t.toString() + string);
            }
            return sB.toString();
        }

        public String join() {
            return join("");
        }

        public void forEachWithIndex(BiConsumer<T,Integer> c) {
            for (int i = 0; i < this.size(); i++) {
                c.accept(this.get(i), i);
            }
        }
    }



