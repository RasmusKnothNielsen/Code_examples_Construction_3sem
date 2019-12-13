package ArrayList;

import java.util.Arrays;

public class RasmusList<T> extends AbstractRasmusList {

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
    public RasmusList<T> remove(Object type) {
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

    //public String toString() {
    //    return Arrays.toString(list);
    //}
}

