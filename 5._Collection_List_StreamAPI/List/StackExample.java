package List;

import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        // Instantiating a Stack object
        Stack<Integer> stack = new Stack<>();

        // pushing elements onto the Stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // peeking at the top element
        System.out.println("\nTop element: " + stack.peek() + "\n");

        // Removes the top element of the Stack
        stack.pop();
        System.out.println("removed top element. Top element is now: " + stack.peek() + "\n");

        // returns a boolean to see if the Stack is empty
        System.out.println("Is the stack empty? " + stack.empty() + "\n");

        // returns the 1-based position of the given element
        System.out.println(stack.search(1) + "\n");
    }


}
