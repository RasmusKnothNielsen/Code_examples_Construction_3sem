package Singleton;

// Class-based implementation of the Singleton
public class ClassSingleton {

    // private static field containing the only instance
    private static ClassSingleton instance;
    private String info = "Initial class info";

    // private constructor
    private ClassSingleton() {}

    // public static factory method to obtain the instance
    public static ClassSingleton getInstance() {
        if (instance == null) { // Lazy initialization. Instance is not created until it is needed.
            instance = new ClassSingleton();
        }
        return instance;
    }

    // Accessor
    public String getInfo() {
        return info;
    }

    // Mutator
    public void setInfo(String info) {
        this.info = info;
    }

}