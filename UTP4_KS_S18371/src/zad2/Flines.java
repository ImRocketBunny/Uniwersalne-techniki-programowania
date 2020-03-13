package zad2;

import java.io.IOException;
import java.util.function.Function;
@FunctionalInterface
public interface Flines<T,R> extends Function<T, R> {
    R call(T src) throws IOException;

    @Override
    default R apply(T wejscie) {
        try {
            return call(wejscie);
        } catch (IOException e) {
            System.out.println("Flines: Błąd odczytu pliku LamComFile.txt : NoSuchFileException");

        }
        return null;
    }
}
