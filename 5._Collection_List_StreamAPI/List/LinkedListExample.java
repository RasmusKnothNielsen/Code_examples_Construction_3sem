package List;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

    public static void main(String[] args) {

        LinkedList<String> linkedList1 = new LinkedList<>();
        LinkedList<String> linkedList2 = new LinkedList<>();

        linkedList1.add("The Fox");
        linkedList1.add("Jumps Over");
        linkedList1.add("Lazy Dog");
        System.out.println(linkedList1);

        linkedList1.add(2, "The");
        System.out.println(linkedList1);

        // Get String at index 3
        System.out.println(linkedList1.get(3));

        // Replace String in index 0 with the provided
        linkedList1.set(0, "Red Riding Hood");
        System.out.println(linkedList1);

        // Add Strings to another LinkedList and add it to the first LinkedList
        linkedList2.add("Yet Another");
        linkedList2.add("Fairy Tale");
        linkedList2.add("Is Upon Us");
        linkedList1.addAll(2, linkedList2);
        System.out.println(linkedList1 + "\n");

        // Iterate through an LinkedList with for each
        System.out.println("Iterate using enhanced for loop: ");
        for (String sentence : linkedList1) {
            System.out.print(sentence + " ");
        }
        System.out.println("\n");

        // Iterate through using the built in Iterator
        System.out.println("Iterate using Iterator: ");
        Iterator iterator1 = linkedList1.iterator();
        while(iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println("\n");

        // Iterate through using forEach and Lambda
        System.out.println("Iterate using forEach and Lambda: ");
        linkedList1.stream().forEach(S -> System.out.print(S + " "));
        System.out.println();
    }
}

