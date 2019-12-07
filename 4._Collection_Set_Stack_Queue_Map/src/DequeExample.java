import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {

        // Instantiate the deque to hold String objects.
        // We use LinkedList to construct the Deque object,
        // since LinkedList is a class that implements Deque interface.
        Deque<String> deque = new LinkedList<>();

        // Add elements in different ways to the head or tail of the deque
        deque.add("Element 1 (Added to tail)");     // This method comes from the Queue interface
        deque.addFirst("Element 2 (Added to head)");
        deque.addLast("Element 3 (Added to tail)");
        deque.push("Element 4 (Added to head)");
        deque.offer("Element 5 (Added to tail)");   // This method comes from the Queue interface
        deque.offerFirst("Element 6 (Added to head)");
        deque.offerLast("Element 7 (Added to tail)");

        // Print out the deque by using
        // java.util.AbstractCollection' toString method.
        // which the LinkedList inherits.
        System.out.println("Printing Deque:");
        System.out.println(deque + "\n");

        // Use the iterator method to iterate through the deque
        System.out.println("Standart Iterator:");
        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        System.out.println();

        // Remove the head with a pop
        System.out.println("Deque before pop = " + deque);
        deque.pop();
        System.out.println("Deque after pop = " + deque);

        // See if a deque contains a specific entry
        System.out.println("Deque contains element 4 = " + deque.contains("Element 4 (Added to head)"));

    }
}