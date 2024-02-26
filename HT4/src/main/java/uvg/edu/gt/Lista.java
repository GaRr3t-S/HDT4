package uvg.edu.gt;

public interface Lista<T> {
    void add(T value);

    T get(int index);

    void remove(int index);

    int size();

    boolean isEmpty();
}
