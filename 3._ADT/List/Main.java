package List;

public class Main {

    public static void main(String[] args) {

        // Initialise a list to hold strings and populate it
        ExampleList<String> stringList = new ExampleList<String>();
        stringList.add("The");
        stringList.add("quick");
        stringList.add("brown");
        stringList.add("fox");
        System.out.println(stringList);

        // Clear the list
        stringList.clear();
        System.out.println(stringList);
        // Add them again
        stringList.add("The");
        stringList.add("quick");
        stringList.add("brown");
        stringList.add("fox");

        // Initialise the list to hold Integers and populate it
        ExampleList<Integer> integerList = new ExampleList<Integer>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(7);
        System.out.println(integerList);

        // Get the size
        System.out.println(integerList.size());

        // Get the Integer at index 2
        System.out.println(integerList.get(2));

        // Remove the Integer at index 2
        integerList.remove(2);
        System.out.println(integerList);

        System.out.println("The type of the second entry in integerList is: " + TypeTester.typeCheck(integerList.get(1)));

        System.out.println("The type of the third entry in stringList is: " + TypeTester.typeCheck(stringList.get(2)));

        // Now, lets try to make an List with objects, and put different objects in it
        ExampleList<Object> objectList = new ExampleList<>();
        objectList.add("String");
        objectList.add(new Integer(2));
        objectList.add(new Double(11));
        objectList.add(true);

        // Test the types of the objects in our objectArray.
        for(Object object : objectList) {
            System.out.println(TypeTester.typeCheck(object));
        }



    }
}