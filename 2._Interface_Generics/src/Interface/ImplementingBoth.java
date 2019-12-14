package Interface;

// A class implementing multiple interfaces
public class ImplementingBoth implements FirstInterface, SecondInterface {

    // The class has to implement the methods from the interfaces
    @Override
    public void methodFromFirstInterface() {
        System.out.println("Method from first interface!");
    }

    @Override
    public void methodFromSecondInterface() {
        System.out.println("Method from second interface!");
    }

    // The default implementation can be overridden
    @Override
    public void methodUsingDefault() {
        System.out.println("Default implementation overridden.");
    }
}
