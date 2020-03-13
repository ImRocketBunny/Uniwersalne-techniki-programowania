package zad2;

import java.util.function.Function;

public interface Sum<T,R> extends Function<T, R> {
    R call(T src) throws NullPointerException;
    @Override
    default R apply(T wejscie){
        try{
            call(wejscie);
        }catch(NullPointerException e){
            System.out.println("Sum: Pusta wartosc pointera ! : NullPointerException");
            System.exit(1);
        }
        return null;
    }

}
