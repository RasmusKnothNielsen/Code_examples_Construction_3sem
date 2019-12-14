package Interface;

// A class implementing an interface
public class ImplementingFirst implements FirstInterface {

    // The class has to implement the methods from the interface
    @Override
    public void methodFromFirstInterface() {
        System.out.println("Implementation of methodFromFirstInterface()");
    }

    // but is not limited to only the implemented interface
    public void methodAddedByClass() {
        System.out.println("This is not from the interface.");
    }

}
