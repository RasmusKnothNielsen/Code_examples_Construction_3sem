package Singleton;

//This solution is shown because it is inherently threadsafe

// Enum-based implementation of the Singleton
public enum EnumSingleton {

    //Enum constant calling the constructor with "Initial enum info"
    INSTANCE("Initial enum info");

    private String info;

    //Enum constructors are always private.
    EnumSingleton(String info) {
        this.info = info;
    }

    // public method to obtain the instance
    public EnumSingleton getInstance(){
        return INSTANCE;
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
