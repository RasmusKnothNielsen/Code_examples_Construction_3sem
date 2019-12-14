package Generics;

// An interface in the style of the List interface - Only simpler.
public interface Listlike<T> {

    void add(T t);
    void remove(int index);
    void set(int index, T element);
    void clear();
    boolean isEmpty();
    int size();
    boolean contains(T element);
    T get(int index);

}
