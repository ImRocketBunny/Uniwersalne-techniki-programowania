package zad2;

import java.util.function.Function;

public interface Join<T,R> extends Function<T, R> {
    R call(T src) throws NullPointerException;
    @Override
    default R apply(T wejscie){
        try{
            call(wejscie);
        }catch (NullPointerException e){
            System.out.println("Join: Pusta wartosc pointera : NullPointerException");
        }
        return null;
    }
}
