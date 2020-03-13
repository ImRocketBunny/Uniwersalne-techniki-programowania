package zad1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ListCreator<T> {
    private List<T> lista;
    private List<T> listTym;

    public ListCreator(List<T> list) {
        this.lista = list;
    }
    public static <T> ListCreator<T> collectFrom(List<T> destinations) {
        ListCreator<T> listc = new ListCreator<T>(destinations);
        return listc;
    }
    public ListCreator<T> when(Predicate<T> p) {
        listTym = new ArrayList<T>();

        for(int i = 0; i < lista.size(); i++) {
            if(p.test(lista.get(i))) {
                listTym.add(lista.get(i));
            }
        }
        this.lista = listTym;
        return this;
    }

    public <R> List<T> mapEvery(Function<T,R> u) {
        listTym = new ArrayList<T>();

        for (T e : lista) {
            listTym.add( (T) u.apply(e));
        }

        this.lista = listTym;
        return lista;
    }
}
