package uvg.edu.gt;

public interface Stack<T> {
    void push(T value);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
}
