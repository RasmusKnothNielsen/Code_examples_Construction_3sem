import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {

        // Instantiating a Collection of Integers as an ArrayList, because Collection is an interface and cannot
        // be instantiated
        Collection<Integer> integerCollection = new ArrayList<>();

        // Instantiating a Collection of Strings as a LinkedList.
        Collection<String> stringCollection = new LinkedList<>();

        // add element to the collections
        integerCollection.add(1);
        integerCollection.add(2);
        integerCollection.add(3);

        stringCollection.add("Niki");
        System.out.println("After adding elements, Collection consists of: " + integerCollection + "\n");

        // Removes all elements in the Collection
        integerCollection.clear();
        System.out.println("After removing elements, Collection consists of: " + integerCollection + "\n");

        // Will return true if the Collection contains All of the elements in the Collection given as parameter.
        // Else return false
        System.out.println("Do these collections contain the same elements: " +
                integerCollection.containsAll(stringCollection) + "\n");

        // Compares the object given as parameter with Collection and returns a boolean value
        System.out.println("Is integerCollection and stringCollection equal to one another?: " +
                integerCollection.equals(stringCollection) + "\n");

        // Calls upon itself and checks if it's equal - will always return true.
        System.out.println("Is integerCollection equal to itself: " +
                integerCollection.equals(integerCollection) + "\n");

        // returns a boolean - if the element was removed as a result the return value will be true, else false.
        integerCollection.add(10);
        System.out.println("Is the element successfully removed from the Collection? " +
                integerCollection.remove(10));
        System.out.println("Is the element successfully removed from the Collection? " +
                integerCollection.remove(10) + "\n");

        // returns the size of the Collection (the amount of elements)
        System.out.println("The amount of elements in integerCollection is: "+ integerCollection.size());

        // saves the Collection in an object[] array - the length of the array equals the Collections size
        Object[] objectArray = integerCollection.toArray();

        integerCollection.add(1);
        integerCollection.add(2);
        integerCollection.add(3);
        integerCollection.add(10);

        // Different ways of iterating through a Collection - with a foreach loop
        for (Integer element : integerCollection) {
            System.out.println(element);
        }
        System.out.println();

        // Iterating through the Collection with Iterator
        Iterator<Integer> collection = integerCollection.iterator();
        while (collection.hasNext()) {
            System.out.println(collection.next());
        }
        System.out.println();

        // Iterating through the Collection with a forEach and a method reference
        integerCollection.forEach(System.out::println);




    }
}
