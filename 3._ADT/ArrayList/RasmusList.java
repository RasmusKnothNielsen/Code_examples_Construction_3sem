package ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class RasmusList<T> implements AbstractRasmusList<T>, Iterable {

    Object[] list = new Object[0];


    @Override
    public void add(T type) {
        int currentLength = this.size();
        list = Arrays.copyOf(list, currentLength + 1);

        list[currentLength] = type;
    }

    @Override
    public void set(int index, T element) {
        list[index] = element;
    }

    @Override
    public void removeObjects(T type) {

        while (indexOf(type) > -1) {
            remove(indexOf(type));
        }

    }

    @Override
    public void remove(int index) {
        if (index >= list.length) {
            System.out.println("Index out of bound");
        } else {
            Object[] newList = new Object[list.length - 1];
            for (int i = 0; i < list.length; i++) {
                if (i < index) {
                    newList[i] = list[i];
                } else if (i > index) {
                    newList[i - 1] = list[i];
                }
            }
            list = newList;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) list[index];
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
    public int indexOf(T type) {
        int index = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(type)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void clear() {
        list = new Object[0];
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
    public RasmusList<T> clone() {
        int size = this.size();
        RasmusList<T> newRasmusList = new RasmusList<>();
        if (size > 0) {
            for (int j = 0; j < size; j++) {
                newRasmusList.add(this.get(j));
            }
        }
        return newRasmusList;

    }

    public Iterator<T> iterator() {
        return new RasmusListIterator();
    }

    // inner class
    private class RasmusListIterator implements java.util.Iterator<T> {

        private int current = 0;

        public boolean hasNext() {
            return current < size();
        }

        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return (T) list[current++];
        }

    }

    public String toString() {
        return Arrays.toString(list);
    }
}

