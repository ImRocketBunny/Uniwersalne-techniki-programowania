/**
 *
 *  @author Kruk Seweryn S18371
 *
 */

package zad1;


public interface Mapper<T, U> {
    public <U> Integer map(T t);
}
