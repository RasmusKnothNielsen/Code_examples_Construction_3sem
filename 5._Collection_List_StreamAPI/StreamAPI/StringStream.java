package StreamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StringStream {

    public static void main(String[] args) {

        // Create a Collection of words and print them out
        Collection<String> words = Arrays.asList("The", "Brown", " ", "Fox", "Jumps", "Over", "The", "Lazy", "Dog");
        System.out.println(words);

        // Save only nonBlank entries from words and print them out
        Collection<String> onlyWords = words.parallelStream()
                .filter(word -> !word.isBlank())
                .collect(Collectors.toList());
        System.out.println(onlyWords);

        // Join all entries into a string with space in between and add a period at the end
        String sentence = words.stream()
                .filter(word -> !word.isBlank())
                .collect(Collectors.joining(" ")) + ".";
        System.out.println(sentence);

        // Count the number of words in the collection
        long vocabulary = words.stream().filter(word -> !word.isBlank()).count();
        System.out.println(vocabulary);

        // Count the number of distinct words in the collection
        long distinctVocabulary = words.stream().filter(word -> !word.isBlank()).distinct().count();
        System.out.println(distinctVocabulary);
    }
}
