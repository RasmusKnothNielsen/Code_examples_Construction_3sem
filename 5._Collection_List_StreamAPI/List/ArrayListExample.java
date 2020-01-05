package Interface;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

    public static void main(String[] args) {

        // Initialize two ArrayLists
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();

        // Add entries to first ArrayList
        arrayList1.add("The Fox");
        arrayList1.add("Jumps Over");
        arrayList1.add("Lazy Dog");

        // Add entry at specific index
        arrayList1.add(2, "The");
        System.out.println(arrayList1);

        // Get String at index 3
        System.out.println(arrayList1.get(3));

        // Replace String in index 0 with the provided
        arrayList1.set(0, "Red Riding Hood");
        System.out.println(arrayList1);

        // Add Strings to another ArrayList and add it to the first ArrayList
        arrayList2.add("Yet Another");
        arrayList2.add("Fairy Tale");
        arrayList2.add("Is Upon Us");
        arrayList1.addAll(4, arrayList2);
        System.out.println(arrayList1);

        // Iterate through an ArrayList with for each
        System.out.println("Iterate using for each: ");
        for (String sentence : arrayList1) {
            System.out.print(sentence + " ");
        }
        System.out.println();

        // Iterate through using the built in Iterator
        System.out.println("Iterate using Iterator: ");
        Iterator iterator1 = arrayList1.iterator();
        while(iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }






    }
}
