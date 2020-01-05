/* An example of an implementation of the abstract data type Queue.
Software Construction, 3. semester, Data Science, KEA.
 */

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample1 {

    public static void main(String[] args) {

        // Initialise the Queue to hold integer objects.
        // We use LinkedList to construct the Queue object,
        // since LinkedList is a class that implements Queue interface.
        Queue<Integer> queue = new LinkedList<>();

        // Add five elements to the Queue
        for (int i = 1; i<6; i++) {
            queue.add(i);
        }

        // Display the content of the entire queue by using
        // java.util.AbstractCollection' toString method,
        // which the LinkedList inherits.
        System.out.println("Content of the queue = " + queue);

        // If you want to remove an element, you remove it from the front.
        int removedElement = queue.remove();
        System.out.println("Removed element = " + removedElement);
        System.out.println("Queue after the first element is removed = " + queue);

        // If you want to add an element, you add it to the end.
        queue.add(new Integer(6));
        System.out.println("Queue after adding another element = " + queue);

        // Check to see if the queue is empty
        boolean isEmpty = queue.isEmpty();
        System.out.println("Is the queue empty? = " + isEmpty);

        int sizeOfQueue = queue.size();
        System.out.println("Size of the queue = " + sizeOfQueue);

        // Peek to see the first element in the queue, without removing it.
        int firstElement = queue.peek();
        System.out.println("First element of the queue is = " + firstElement);

    }

}
