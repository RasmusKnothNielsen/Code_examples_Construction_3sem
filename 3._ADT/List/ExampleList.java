package List;

import List.AbstractExampleList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ExampleList<T> extends AbstractExampleList<T> implements Iterable{

    T type;

    T[] list = (T[]) new Object[0];


    @Override
    public void add(T type) {
        int currentLength = this.size();
        list = Arrays.copyOf(list, currentLength+1);
        try {
            list[currentLength] = (T) type;
        } catch(Exception exception) {
            throw(exception);
        }
    }

    @Override
    public void set(int index, T element) {
        list[index] = element;
    }

    @Override
    public ExampleList<T> remove(T type) {
        ExampleList<T> list2 = new ExampleList<>();
        for(int i=0;i<list.length;i++){
            if(!list[i].equals(type)){
                list2.add(list[i]);
            }
        }
        return list2;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(int index) {
        if (index >= list.length) {
            System.out.println("Index out of bound");
        } else {
            T[] newList = (T[]) new Object[list.length-1];
            for (int i=0; i<list.length;i++){
                if(i < index) {
                    newList[i] = list[i];
                } else if (i > index) {
                    newList[i] = list[i+1];
                }
            }
            list = newList;
        }
    }

    @Override
    public T get(int i) {
        return list[i];
    }

    @Override
    public boolean contains(T type) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(type)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(T type) {
        int index = -1;
        for(int i=0;i<list.length;i++){
            if(list[i].equals(type)){
                index = i;
            }
        }
        return index;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        list = (T[]) new Object[0];
    }

    @Override
    public boolean isEmpty() {
        return (list.length == 0);
    }

    @Override
    public int size() {
        return list.length;
    }


    public String toString() {
        return Arrays.toString(list);
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    // inner class
    private class ArrayListIterator implements java.util.Iterator<T> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        public T next() {
            if (!hasNext()) throw new java.util.NoSuchElementException();
            return list[current++];
        }
    }
}
