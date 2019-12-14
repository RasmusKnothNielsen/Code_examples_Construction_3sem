package Interface;

public class ImplementingBoth implements FirstInterface, SecondInterface {

    @Override
    public void methodFromFirstInterface() {
        System.out.println("Method from first interface!");
    }

    @Override
    public void methodFromSecondInterface() {
        System.out.println("Method from second interface!");
    }
}
