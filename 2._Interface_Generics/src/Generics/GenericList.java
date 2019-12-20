package Generics;

import java.util.Arrays;
import java.util.Objects;

// Implementation of the Listlike interface using Generics
public class GenericList<T> implements Listlike<T> {

    // Private fields
    private Object[] list;
    private int size;

    public GenericList() {
        this.list = new Object[0];
    }

    @Override
    public void add(T t) {
        list = Arrays.copyOf(list, ++size); // Copying into new array 1 element longer
        list[size - 1] = t; // Setting the element at the last index
    }

    @Override
    public void remove(int index) {
        Objects.checkIndex(index, size); // Checking if index is valid
        size--; // Removing an element reduces the size
        if (size > index) { // If removed element is not the last
            // Move the remaining elements together, leaving the last index free
            System.arraycopy(list, index + 1, list, index, size - index);
            //TODO - Also have loop-method
            //TODO - JavaDoc
        }
        list = Arrays.copyOf(list, size); // Copying into new array 1 element shorter
    }

    @Override
    public void set(int index, T element) {
        list[index] = element;
    }

    @Override
    public void clear() {
        list = new Object[0];
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) { // If the given object is null .equals() won't work
            for (Object obj : list) {
                if (obj == null) {
                    return true;
                }
            }
        } else {
            for (Object obj : list) {
                if (obj.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Objects.checkIndex(index, size); // Checking if index is valid
        return (T) list[index]; // Typecast and return element
    }

    @Override
    public String toString() {
        return Arrays.toString(list);
    }

}
