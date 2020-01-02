import java.util.*;

public class MapExample {

    public static void main(String[] args) {

        // TreeMap below:
        // instantiating a TreeMap
        TreeMap<Integer, String> treeMapUsers  = new TreeMap<>();

        // The order of the keys does not matter as it will insert it in the natural order
        treeMapUsers.put(3, "Niki");

        // Overwrites the value in the given key.
        treeMapUsers.put(3, "Peter");
        treeMapUsers.put(5, "Thomas");
        treeMapUsers.put(1, "Knud");
        treeMapUsers.put(2, "Rasmus");
        treeMapUsers.put(4, "Mikkel");
        treeMapUsers.put(4, null); // null value are allowed

        // treeMapUsers.put(null, "Niels"); null key not allowed in TreeMap

        // TreeMap entries is inserted in natural order - println to demonstrate
        System.out.println("TreeMap is in natural order: " + treeMapUsers + "\n");

        // returns the entry that is higher than the given key (Dictionary)
        System.out.println("Showing entries with keys > 3: " + treeMapUsers.tailMap(3) + "\n");

        // returns the entry that is lower than the given key (useful for e.g. salaries lower than)
        System.out.println("Showing entries with keys <= 3: " + treeMapUsers.headMap(3, true) + "\n");

        System.out.println("Showing the lowest key in the map: " + treeMapUsers.firstKey() + "\n");

        System.out.println("Reversing the key order: " + treeMapUsers.descendingKeySet() + "\n");

        // returns a boolean depending if the Map contains the given key or value
        System.out.println("Does the TreeMap contain the key 1? " + treeMapUsers.containsKey(1) + "\n");
        System.out.println("Does the TreeMap contain the value \"Niels\"? " + treeMapUsers.containsValue("Niels") + "\n");

        System.out.println("Showing all values in the TreeMap: " + treeMapUsers.values() + "\n\n");

        // HashMap below:
        // instantiating a HashMap
        HashMap<String, String> hashMapUsers = new HashMap<>();

        // Order is not guaranteed due to hashing the keys
        hashMapUsers.put("A", null);
        hashMapUsers.put("B", null); // infinite null values are allowed
        hashMapUsers.put(null, "Per"); // one null key is allowed
        hashMapUsers.put("C", "Niki");
        hashMapUsers.put("D", "Peter");
        hashMapUsers.put("E", "Rasmus");
        hashMapUsers.put("F", "Thomas");
        hashMapUsers.put("G", "Knud");

        // Printing all entries in the HashMap
        hashMapUsers.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // Testing HashMap vs TreeMap runtime efficiency
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Random rand = new Random();

        // Populating the Maps with 1m entries
        for (int i = 0; i < 1_000_000; i++) {
            hashMap.put(i, i);
            treeMap.put(i, i);
        }

        // Searching for a random entry in the hashMap
        long startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            int entry = rand.nextInt(1_000_000);
            hashMap.get(entry);
        }
        long elapsedTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("Time elapsed for searching 1.000.000 entries in HashMap: " +elapsedTime + " miliseconds");


        // Searching for a random entry in the hashMap
        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            int entry = rand.nextInt(1_000_000);
            treeMap.get(entry);
        }
        elapsedTime = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("Time elapsed for searching 1.000.000 entries in TreeMap: " + elapsedTime + " miliseconds");

    }

}
