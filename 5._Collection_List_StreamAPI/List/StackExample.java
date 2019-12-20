package List;

import java.util.Iterator;
import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {


        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        stack1.add("The Fox");
        stack1.add("Jumps Over");
        stack1.add("Lazy Dog");
        System.out.println(stack1);

        stack1.add(2, "The");
        System.out.println(stack1);

        // Get String at index 3
        System.out.println(stack1.get(3));

        // Replace String in index 0 with the provided
        stack1.set(0, "Red Riding Hood");
        System.out.println(stack1);

        // Add Strings to another Stack and add it to the first Stack
        stack2.add("Yet Another");
        stack2.add("Fairy Tale");
        stack2.add("Is Upon Us");
        stack1.addAll(2, stack2);
        System.out.println(stack1);

        // Iterate through an LinkedList with for each
        System.out.println("Iterate using for each: ");
        for (String sentence : stack1) {
            System.out.print(sentence + " ");
        }
        System.out.println();

        // Iterate through using the built in Iterator
        System.out.println("Iterate using Iterator: ");
        Iterator iterator1 = stack1.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();

        stack1.remove(2);
        stack1.remove("Fairy Tale");
        System.out.println(stack1);
    }
}
