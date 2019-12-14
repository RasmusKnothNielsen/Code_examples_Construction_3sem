package Interface;

public interface FirstInterface {

    void methodFromFirstInterface();

    default void methodUsingDefault() {
        System.out.println("This is the default implementation.");
    }

}
