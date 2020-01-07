package Generics;

public class GenericListExample {

    public static void main(String[] args) {

        Listlike<String> g = new GenericList<>();
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";

        // It doesn't matter what kind of objects are used. Because of Generics everything is supported.
        /*
        Listlike<Integer> g = new GenericList<>();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        */

        /*
        Listlike<Map<String,Long>> g = new GenericList<>();
        Map<String, Integer> a = new HashMap<>();
        Map<String, Integer> b = new HashMap<>();
        Map<String, Integer> c = new TreeMap<>();
        Map<String, Integer> d = new TreeMap<>();
        a.put("A",1);
        b.put("B",2);
        c.put("C",3);
        d.put("D",4);
         */

        System.out.println("\nIs list empty? " + g.isEmpty());

        System.out.println("Adding 3 elements");
        g.add(a);
        g.add(b);
        g.add(c);

        System.out.println("Printing the list: " + g);

        System.out.println("Is list empty? " + g.isEmpty());

        System.out.println("Get 0: " + g.get(0));
        System.out.println("Get 1: " + g.get(1));
        System.out.println("Get 2: " + g.get(2));

        System.out.println("Size: " + g.size());

        System.out.println("Removing an element from the list");
        g.remove(1);

        System.out.println("Size: " + g.size());

        System.out.println("Setting 0'th element to " + d);
        g.set(0,d);

        System.out.println("Get 0: " + g.get(0));

        System.out.println("Contains " + a + "? " + g.contains(a));
        System.out.println("Contains " + d + "? " + g.contains(d));

        System.out.println("Clearing the list");
        g.clear();
        System.out.println("Size: " + g.size());

    }

}
