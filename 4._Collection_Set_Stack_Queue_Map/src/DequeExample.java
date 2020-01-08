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
        deque.addFirst("Element 2 (Added to head)");    // From LinkedList
        deque.addLast("Element 3 (Added to tail)");     // From LinkedList
        deque.push("Element 4 (Added to head)");        // Stack Equivalent to Deque addFirst
        deque.offer("Element 5 (Added to tail)");       // This method comes from the Queue interface
        deque.offerFirst("Element 6 (Added to head)");  // Deque specific
        deque.offerLast("Element 7 (Added to tail)");   // Deque specific

        // Print out the deque by using
        // java.util.AbstractCollection' toString method.
        // which the LinkedList inherits.
        System.out.println("Printing Deque:");
        System.out.println(deque + "\n");

        // Use the iterator method to iterate through the deque
        System.out.println("Standard Iterator:");
        Iterator iterator = deque.iterator(); // could also use enhanced for loop / for each / lambda
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        System.out.println();

        // Enhanced For loop
        System.out.println("Using Enhanced For loop:");
        for(String string : deque) {
            System.out.println("\t" + string);
        }
        System.out.println();

        // Lambda expression
        System.out.println("Using Lambda expression:");
        deque.stream().forEach(S -> System.out.println("\t" + S));
        System.out.println();


        // Remove the head with a pop
        System.out.println("Deque before pop = " + deque);
        deque.pop();
        System.out.println("Deque after pop = " + deque);

        // See if a deque contains a specific entry
        System.out.println("Deque contains element 4 = " + deque.contains("Element 4 (Added to head)"));

    }
}