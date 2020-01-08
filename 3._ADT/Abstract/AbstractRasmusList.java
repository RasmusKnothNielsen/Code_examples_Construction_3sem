package Abstract;


public interface AbstractRasmusList<T> {

    void add(T type);

    void set(int index, T element);

    void removeObjects(T type);

    void remove(int index);

    T get(int i);

    boolean contains(T type);

    int indexOf(T type);

    void clear();

    boolean isEmpty();

    int size();

    AbstractRasmusList<T> clone();

}
