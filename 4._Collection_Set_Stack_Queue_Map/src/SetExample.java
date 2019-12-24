import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

    // refer to all the inherited methods from the Collection Interface. Go to class: CollectionExample.
    // Biggest difference is that Set contains no duplicates

    public static void main(String[] args) {

        // Instantiating TreeSet and HashSet
        Set<String> hashSet = new HashSet<>();
        Set<String> treeSet = new TreeSet<>();

        // Adding elements to the HashSet Duplicate isn't inserted into the HashSet
        hashSet.add("Niki");
        hashSet.add("Rasmus");
        hashSet.add("Knud");
        hashSet.add("Thomas");

        // Adding elements to the TreeSet
        treeSet.add("Adam");
        treeSet.add("Rasmus");
        treeSet.add("Knud");
        treeSet.add("Thomas");

        System.out.println("HashSet size: " + hashSet.size());

        // Order is not guaranteed because Objects are inserted based on their hash code
        hashSet.add("Niki");
        System.out.println("Added a duplicate element to the HashSet to check if it inserted or ignored");

        System.out.println("HashSet size: " + hashSet.size());


        // null value is allowed in a Set, therefore no NullPointerException
        // (Depending on the implementation of course, but with this implementation it is allowed.
        hashSet.add(null);
        System.out.println("Added null element to the HashSet");

        // Print order not guaranteed
        // Varies from which kind of set
        System.out.println("HashSet: " + hashSet);

        // Print order is natural
        System.out.println("TreeSet: " + treeSet);


    }
}
