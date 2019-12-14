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

    }
}