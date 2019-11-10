package inheritance;

public class MainInheritance {

    public static void main(String[] args) {

        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();

        System.out.println("superClass.methodOne()");
        superClass.methodOne();

        System.out.println("\nsuperClass.methodTwo()");
        superClass.methodTwo();

        System.out.println("\nsubClass.methodOne()");
        subClass.methodOne();

        System.out.println("\nsubClass.methodTwo()");
        subClass.methodTwo();

        System.out.println("\nsubClass.methodThree()");
        subClass.methodThree();
    }
}
