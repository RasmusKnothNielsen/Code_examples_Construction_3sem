package Interface;

public class InterfaceExample {

    public static void main(String[] args) {

        ImplementingFirst first = new ImplementingFirst();
        ImplementingBoth both = new ImplementingBoth();

        first.methodFromFirstInterface();

        both.methodFromFirstInterface();
        both.methodFromSecondInterface();

        first.methodUsingDefault();

    }

}
