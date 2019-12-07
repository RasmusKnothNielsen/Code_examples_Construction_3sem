import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SetExample {

    // refer to all the inherited methods from the Collection Interface. Go to class: CollectionExample.
    // Biggest difference is that Set contains no duplicates

    public static void main(String[] args) {

        // Instantiating a Set as a HashSet
        Set<String> usernames = new HashSet<>();

        // Order is not guaranteed because Objects are inserted based on their hash code
        usernames.add("Niki");

        // Duplicate isn't inserted into the HashSet
        usernames.add("Niki");
        usernames.add("Rasmus");
        usernames.add("Knud");
        usernames.add("Thomas");

        // null value is allowed in a Set, therefore no NullPointerException
        // (Depending on the implementation of course, but with this implementation it is allowed.
        usernames.add(null);

        System.out.println(usernames);
    }
}
