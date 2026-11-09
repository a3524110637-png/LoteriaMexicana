import java.util.Iterator;

public interface SetADT<T> {
    void add(T element);

    T remove(T element);

    boolean contains(T target);

    boolean isEmpty();

    int size();

    Iterator<T> iterator();

    String toString();
}