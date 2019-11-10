package List;

public abstract class AbstractExampleList<T> {

    public abstract void add(T type);

    public abstract void set(int index, T element);

    public abstract ExampleList<T> remove(T type);

    public abstract void remove(int index);

    public abstract T get(int i);

    public abstract boolean contains(T type);

    public abstract int indexOf(T type);

    public abstract void clear();

    public abstract boolean isEmpty();

    public abstract int size();

}
