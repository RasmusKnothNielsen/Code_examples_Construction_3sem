/*
How to use streams to filter out books that start with the letter "K"
 */

package StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BooksExample {

    public static void main(String[] args) {

        // Initialize ArrayList with books.
        ArrayList<String> books = new ArrayList<>();
        books.add("Kafka on the shore");
        books.add("The Stranger");
        books.add("Cyberpunk");
        books.add("Keeper");
        books.add("Animal farm");
        books.add("War and peace");
        books.add("Kid Kishore");

        // Print out the ArrayList
        System.out.println(books);

        // Use for each to iterate through the ArrayList
        System.out.println("Iterating using For Each:");
        for(String book : books) {
            if (book.startsWith("K")) {
                if (book.endsWith("e")) {
                    System.out.println(book);
                }
            }
        }
        System.out.println();


        // Use Stream to iterate through the ArrayList
        // book is a lambda expression, which relates to the current element.
        System.out.println("Iterating using Stream:");

        books.stream()
                .filter(book -> book.startsWith("K"))
                .filter(book -> book.endsWith("e"))
                .forEach(System.out::println);
        System.out.println();

        // We can also save the filtered stream directly to an ArrayList
        // by using a the method reference in our forEach operation.
        ArrayList<String> resultStream = new ArrayList<>();

        System.out.println("Iterating using Stream:");
        books.stream()
                .filter(book -> book.startsWith("K"))
                .filter(book -> book.endsWith("e"))
                .forEach(resultStream::add);

        System.out.println(resultStream);


        List<String> resultList = books.stream()
                .filter(book -> book.startsWith("K"))
                .collect(Collectors.toList());

        System.out.println(resultList);



    }
}
