package Interface;

// An example of a simple Java interface
public interface FirstInterface {

    // Interfaces can have fields
    String fieldString = "I am a variable in FirstInterface!";

    // And interfaces can have methods
    void methodFromFirstInterface();

    // Static methods must be implemented
    static void staticMethod() {
        System.out.println("I am a static method!");
    }

    // Using the "default" keyword, methods can be implemented.
    // This is not typical, but can be practical in some cases. (See notes)
    default void methodUsingDefault() {
        System.out.println("This is the default implementation.");
    }

}
