package uvg.edu.gt;

public class ListaSimple<T> implements Lista<T> {
    private Nodo<T> head;
    private  int size;

    public ListaSimple(){
        head = null;
        size = 0;
    }

    @Override
    public void add(T value){
        Nodo<T> newNode= new Nodo<T>(value);
        if (head == null){
            head = newNode;
        }else {
            Nodo<T> current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }
    @Override
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("ERROR: El índice está fuera de rango");
        }
        Nodo<T> current = head;
        for (int i = 0; i < index; i++){
            current = current.getNext();
        }
        return current.getValue();
    }
    @Override
    public void remove(int index){
        if (index < 0 || index>= size){
            throw new IndexOutOfBoundsException("ERROR: El índice está fuera de rango");
        }
        if (index==0){
            head = head.getNext();
        } else {
            Nodo<T> current = head;
            for (int i =0; i < index -1; i++){
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public  boolean isEmpty(){
        return size ==0;
    }
}
