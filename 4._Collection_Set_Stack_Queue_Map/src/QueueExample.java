import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        // Instantiating a Queue as a LinkedList
        Queue<Integer> q = new LinkedList<>();

        // add elements to the queue
        System.out.println("Adding 0, 1, 2, 3, 4 into the Queue");
        for (int i = 0; i < 5; i++) {
            q.add(i);
        }

        //Print all elements of the queue
        System.out.println("Printing the entire Queue:\n" + q);
        System.out.println();

        //Remove the head of the queue
        System.out.println("Removing the head of the queue with the poll() method");
        q.poll();

        //Print all elements of the queue
        System.out.println(q + "\n");

        //Printing the specific index using the LinkedList method indexOf();
        System.out.println("Printing the element at index 3: \n" + ((LinkedList<Integer>) q).indexOf(3) + "\n");

        //Removes a specific index using the LinkedList method remove();
        ((LinkedList<Integer>) q).remove(3);
        System.out.println("Printing the entire Queue: \n" + q + "\n");

        //Retrieves the head of the queue without removing it
        System.out.println("Head of the Queue is: \n" + q.element() + "\n");


        //Inserts an element if there is capacity for it and throws the element away if there is no capacity left.
        System.out.println("Adding an element (8) to the tail with the offer() method");
        q.offer(8);

        //Prints the Queue
        System.out.println("List is now: \n" + q);

    }
}