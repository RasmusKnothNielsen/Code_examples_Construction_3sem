package Abstract;

import java.util.Iterator;

public class RasmusListExample {

    public static void main(String[] args) {

        RasmusList<String> stringArray = new RasmusList<>();

        // Add elements
        stringArray.add("Rasmus");
        stringArray.add("Niki");
        stringArray.add("Thomas");
        stringArray.add("Knud");
        stringArray.add("Rasmus");

        stringArray.removeObjects("Rasmus");
        System.out.println(stringArray);


        stringArray.remove(2);

        System.out.println(stringArray + "\n");

        // Check if ArrayList is empty
        System.out.println("ArrayList is empty: " + stringArray.isEmpty());

        // Clear the ArrayList
        System.out.println("Clearing the Array...");
        stringArray.clear();
        System.out.println("Is ArrayList empty now: " + stringArray.isEmpty() + "\n");

        // Add some elements to our ArrayList
        stringArray.add("Programming");
        stringArray.add("is");
        stringArray.add("exciting");

        // Replace an index with another object
        stringArray.set(2, "fun");

        // Clone our ArrayList
        RasmusList<String> newStringArray = stringArray.clone();

        // Check weather it is the same object or not
        System.out.println("String Array: " + stringArray);
        System.out.println("Identity Hash Code: " + System.identityHashCode(stringArray) + "\n");

        System.out.println("New String Array: " + newStringArray);
        System.out.println("Identity Hash Code: " + System.identityHashCode(newStringArray));

        // Use the defined iterator from our ArrayList to iterate through the objects in the ArrayList
        Iterator iterator = stringArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

        // Since our ArrayList implements Iterable, we can also do a For Each loop, more simple.
        for (Object object : stringArray) {
            System.out.println(object);
        }
    }
}
