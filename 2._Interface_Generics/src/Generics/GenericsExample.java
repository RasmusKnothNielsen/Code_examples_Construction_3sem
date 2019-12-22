package Generics;

import java.util.*;

public class GenericsExample {

    public static void main(String[] args) {

        // Without generics you can add any "Object" to a list.
        List nonGen = new ArrayList();
        nonGen.add(8);
        nonGen.add("Test");
        nonGen.add(new GenericsExample());

        // But then you would have to typecast everything
        Integer integer = (Integer) nonGen.get(0);
        String string = (String) nonGen.get(1);
        GenericsExample g = (GenericsExample) nonGen.get(2);


        // Using generics you can set the type of the collection to limit what kind of object are allowed
        List<String> gen = new ArrayList<>(); //Using diamond notation
        gen.add("Only");
        gen.add("accepting");
        gen.add("Strings");

        // Now typecasting is no longer needed
        String string1 = gen.get(0);
        String string2 = gen.get(1);
        String string3 = gen.get(2);

        // Now you can even use a foreach-loop to iterate
        for (String s : gen) {
            System.out.println(s);
        }

        // ... and all of this works exactly the same for any generified class - Sets, Maps, etc...
        Set<String> set = new HashSet<>();
        Map<Integer, String> map = new HashMap<>();
    }

}