package Singleton;

import java.lang.reflect.Constructor;

public class SingletonExample {

    public static void main(String[] args) {

        // ----------------- Class singleton -----------------

        //ClassSingleton classSingleton = new ClassSingleton(); // The constructor ClassSingleton() is not visible
        ClassSingleton classSingleton1 = ClassSingleton.getInstance();

        System.out.println(classSingleton1.getInfo()); //Initial class info

        ClassSingleton classSingleton2 = ClassSingleton.getInstance();
        classSingleton2.setInfo("New class info");

        System.out.println(classSingleton1.getInfo()); //New class info
        System.out.println(classSingleton2.getInfo()); //New class info

        // ----------------- Enum singleton -----------------

        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE.getInstance();

        System.out.println(enumSingleton1.getInfo()); //Initial enum info

        EnumSingleton enumSingleton2 = EnumSingleton.INSTANCE.getInstance();
        enumSingleton2.setInfo("New enum info");

        System.out.println(enumSingleton1.getInfo()); //New enum info
        System.out.println(enumSingleton2.getInfo()); //New enum info


        /*
        //TODO - Slet dette når du har vist det til de andre?
        System.out.println("\nExample of how Reflection can break the ClassSingleton:");
        try {
            Constructor constructor = classSingleton1.getClass().getDeclaredConstructor();
            constructor.setAccessible(true);
            ClassSingleton classSingleton = (ClassSingleton) constructor.newInstance();
            classSingleton.setInfo("Oh no...");

            System.out.println(classSingleton1.getInfo());
            System.out.println(classSingleton.getInfo());

        } catch (Exception ignored){}

         */
    }

}
