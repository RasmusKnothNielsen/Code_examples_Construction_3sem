package Interface;

public class InterfaceExample {

    public static void main(String[] args) {

        // Accessing the FirstInterface's variable
        System.out.println(FirstInterface.fieldString);

        // Instantiating the two classes implementing the first and both interfaces
        ImplementingFirst first = new ImplementingFirst();
        ImplementingBoth both = new ImplementingBoth();

        // When a class implements an interface, it can be used to instance the interface
        // This can practical in some uses. (See notes)
        FirstInterface firstInterface = new ImplementingFirst();

        // The ImplementingFirst class has access to methods from FirstInterface
        first.methodFromFirstInterface();

        // and of course to the other methods within itself
        first.methodAddedByClass();

        // The ImplementingBoth class has access to methods from both interfaces
        both.methodFromFirstInterface();
        both.methodFromSecondInterface();

        //

        FirstInterface.staticMethod(first);
        FirstInterface.staticMethod(both);

        // When a method declared in an interface is given a "default" implementation,
        // the classes implementing the interface has that by default.
        first.methodUsingDefault();

        // This can be overridden.
        both.methodUsingDefault();


    }

}
