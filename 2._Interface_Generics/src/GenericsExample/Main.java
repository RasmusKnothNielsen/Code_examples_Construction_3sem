package GenericsExample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Test 1: ");

        String s = "Dette er en String";
        Integer i = 10;

        Test test1 = new Test(s, i);
        test1.print();
        System.out.println(test1.object1.getClass());
        System.out.println(test1.object2.getClass());



        System.out.println("\nTest 2: ");

        List<Boolean> l = new ArrayList<>();
        l.add(true);

        Test test2 = new Test(l, test1);
        test2.print();
        System.out.println(test2.object1.getClass());
        System.out.println(test2.object2.getClass());

    }

    public static Object method1(Object o) {
        return null;
    }

    public static Test method2(Object o) {
        return null;
    }

}
