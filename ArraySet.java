import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArraySet<T> implements SetADT<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private static final int NOT_FOUND = -1;

    private int count;
    private T[] contents;

    @SuppressWarnings("unchecked")
    public ArraySet() {
        count = 0;
        contents = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArraySet(int initialCapacity) {
        count = 0;
        contents = (T[]) new Object[initialCapacity];
    }

    @Override
    public void add(T element) {
        if (!contains(element)) {
            if (size() == contents.length) {
                expandCapacity();
            }
            contents[count] = element;
            count++;
        }
    }

    @Override
    public T remove(T target) {
        int search = NOT_FOUND;
        for (int i = 0; i < count && search == NOT_FOUND; i++) {
            if (contents[i].equals(target)) {
                search = i;
            }
        }
        if (search == NOT_FOUND) {
            throw new NoSuchElementException();
        }
        T result = contents[search];
        contents[search] = contents[count - 1];
        contents[count - 1] = null;
        count--;
        return result;
    }

    // Este es el que usa Loteria para sacar aleatoria
    public T removeRandom() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Random rand = new Random();
        int choice = rand.nextInt(count);
        T result = contents[choice];
        contents[choice] = contents[count - 1];
        contents[count - 1] = null;
        count--;
        return result;
    }

    @Override
    public boolean contains(T target) {
        for (int i = 0; i < count; i++) {
            if (contents[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(contents, count);
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < count; i++) {
            result = result + contents[i].toString() + "\n";
        }
        return result;
    }

    private void expandCapacity() {
        @SuppressWarnings("unchecked")
        T[] larger = (T[]) new Object[contents.length * 2];
        for (int i = 0; i < contents.length; i++) {
            larger[i] = contents[i];
        }
        contents = larger;
    }
}