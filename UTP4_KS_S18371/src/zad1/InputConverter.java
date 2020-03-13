package zad1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class InputConverter<T> {
    public T source;
    public InputConverter(T source) {
        this.source=source;
    }

    public <T,R> R convertBy(Function... func){
        List fncs = new ArrayList();
        fncs.add(func[0].apply(source));
        for (int i = 1; i < func.length; i++) {
            fncs.add(func[i].apply(fncs.get(i-1)));
        }
        return (R) fncs.get(fncs.size()-1);
    }
}
