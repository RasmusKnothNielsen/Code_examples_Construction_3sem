package Singleton;

public class SingletonExample {

    public static void main(String[] args) {

        // ----------------- Class singleton -----------------
        System.out.println("Demonstrating Class-based singleton implementation");

        //ClassSingleton classSingleton = new ClassSingleton(); // The constructor ClassSingleton() is not visible
        ClassSingleton classSingleton1 = ClassSingleton.getInstance();

        System.out.println("classSingleton1: " +classSingleton1.getInfo()); //Initial class info

        //Attempting to create another instance, and setting the info to something different.
        ClassSingleton classSingleton2 = ClassSingleton.getInstance();
        classSingleton2.setInfo("New class info");

        //Showing that the "two instances" are both changed - because they are the same instance.
        System.out.println("classSingleton1: " + classSingleton1.getInfo()); //New class info
        System.out.println("classSingleton2: " + classSingleton2.getInfo()); //New class info


        // ----------------- Enum singleton -----------------
        System.out.println("\nDemonstrating Enum-based singleton implementation");

        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();

        System.out.println("enumSingleton1: " +enumSingleton1.getInfo()); //Initial enum info

        //Attempting to create another instance, and setting the info to something different.
        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");

        //Showing that the "two instances" are both changed - because they are the same instance.
        System.out.println("enumSingleton1: " +enumSingleton1.getInfo()); //New enum info
        System.out.println("enumSingleton2: " +enumSingleton2.getInfo()); //New enum info

    }

}
