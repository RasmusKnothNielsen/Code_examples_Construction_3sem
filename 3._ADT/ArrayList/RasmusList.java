package ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class RasmusList<T> extends AbstractRasmusList implements Iterable {

    T type;

    T[] list = (T[]) new Object[0];


    @Override
    public void add(Object type) {
        int currentLength = this.size();
        list = Arrays.copyOf(list, currentLength+1);
        try {
            list[currentLength] = (T) type;
        } catch(Exception exception) {
            throw(exception);
        }
    }

    @Override
    public void set(int index, Object element) {
        list[index] = (T) element;
    }

    @Override
    public RasmusList<T> removeAll(Object type) {
        RasmusList<T> list2 = new RasmusList<T>();
        for(int i=0;i<list.length;i++){
            if(!list[i].equals(type)){
                list2.add(list[i]);
            }
        }
        return list2;
    }

    @Override
    public void remove(int index) {
        if (index >= list.length) {
            System.out.println("Index out of bound");
        } else {
            T[] newList = (T[]) new Object[0];
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
    public boolean contains(Object type) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(type)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(Object type) {
        int index = -1;
        for(int i=0;i<list.length;i++){
            if(list[i].equals(type)){
                index = i;
            }
        }
        return index;
    }

    @Override
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

    @Override
    public RasmusList clone() {
        int i = this.size();
        RasmusList<T> newRasmusList = new RasmusList<>();
        if (i > 0) {
            for (int j = 0; j < i; j++) {
                newRasmusList.add(this.get(j));
            }
        }
        return newRasmusList;

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

        public void remove() {
            RasmusList.this.remove(--current); // reference the outer class
        }
    }

    public String toString() {
        return Arrays.toString(list);
    }
}

