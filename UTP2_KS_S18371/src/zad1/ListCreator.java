/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;


import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {
    private List<T> lista;
    private List<T> listaTym;
    public ListCreator(List<T> lista2) {
        this.lista = lista2;
    }
    public static <T> ListCreator<T> collectFrom(List<T> lista3){
        ListCreator<T> listCreator = new ListCreator<>(lista3);
        return listCreator;
    }
    public ListCreator<T> when(Selector<T> t) {
        listaTym = new ArrayList<T>();

        for (int i = 0; i < lista.size(); i++) {
            if(t.select(lista.get(i))) {
                listaTym.add(lista.get(i));
            }
        }
        this.lista = listaTym;
        return this;
    }

    public List<T> mapEvery(Mapper m) {
        listaTym = new ArrayList<T>();
        for(int i = 0; i<lista.size();i++){
            listaTym.add((T)(m.map(lista.get(i))));
        }
        this.lista = listaTym;
        return lista;
    }

}
