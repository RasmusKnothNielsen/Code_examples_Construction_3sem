import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        // Instantiating a Queue as a LinkedList
        Queue<Integer> q = new LinkedList<>();

        // add elements to the queue - throws exception if over capacity
        System.out.println("Adding 0, 1, 2, 3, 4 into the Queue");
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }

        //Print all elements of the queue
        System.out.println("Printing the entire Queue:\n" + q);
        System.out.println();

        // Returns and remove the head of the queue
        System.out.println("Removing the head of the queue with the poll() method");
        q.poll();

        //Print all elements of the queue
        System.out.println(q + "\n");

        // Throws exception if queue is empty
        q.remove();

        //Retrieves the head of the queue without removing it
        System.out.println("Head of the Queue is: \n" + q.peek() + "\n");

        // Throws exception if queue is empty
        q.element();

        //Inserts an element if there is capacity for it and throws the element away if there is no capacity left.
        System.out.println("Adding an element (8) to the tail with the offer() method");
        q.offer(8);

        //Prints the Queue
        System.out.println("Queue is now: \n" + q);

    }
}