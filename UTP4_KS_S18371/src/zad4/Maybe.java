package zad4;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe<T> {
    private T t;

    public Maybe() {
        super();
    }

    public Maybe(T x) {
        super();
        this.t = x;
    }

    public static <T> Maybe<T> of(T t) {
        Maybe<T> maybe = new Maybe<T>(t);
        return maybe;
    }

    public void ifPresent(Consumer<T> cons) {
        if (isPresent())
            cons.accept(t);
    }

    public <R> Maybe<R> map(Function<T, R> func) {
        if (t != null) {
            return new Maybe<R>(func.apply(t));
        } else {
            return new Maybe<R>();
        }
    }

    public T get() {
        if (isPresent())
            return t;
        else
            throw new NoSuchElementException("maybe is empty");
    }

    public boolean isPresent() {
        if (t != null)
            return true;
        else
            return false;
    }

    public T orElse(T defVal) {
        if (t != null)
            return t;
        else
            return defVal;
    }

    public Maybe<T> filter(Predicate<T> pred) {
        if (t == null) {
            return this;
        } else {
            if (pred.test(t))
                return new Maybe<T>(t);
            else
                return new Maybe<T>();
        }
    }

    @Override
    public String toString() {

        if(!isPresent()) {

            return "Maybe is empty";
        }else {
            try {
                this.get();
            }catch(NoSuchElementException e) {
                System.out.print(" :maybe is empty");
            }
        }

        return "Maybe has value " + t;
    }

}
