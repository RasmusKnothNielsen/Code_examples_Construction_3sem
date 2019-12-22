import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        // Instantiating a Stack object
        Stack<String> stack = new Stack<>();

        // pushing elements onto the Stack
        stack.push("Rasmus");
        stack.push("Niki");
        stack.push("Thomas");
        stack.push("Knud");

        // peeking at the top element
        System.out.println("Top element: " + stack.peek() + "\n");

        // Returns and removes the top element of the Stack
        stack.pop();
        System.out.println("removed top element. Top element is now: " + stack.peek() + "\n");

        // returns a boolean to see if the Stack is empty
        System.out.println("Is the stack empty? " + stack.empty() + "\n");

        // returns the position of the given element (index starts at 1)
        System.out.println(stack.search("Rasmus") + "\n");
    }


}
