package StreamAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class StringStream {

    public static void main(String[] args) {

        Collection<String> words = Arrays.asList("The", "Brown", "Fox", "Jumps", "The", "Lazy", "Dog");
        System.out.println(words);

        Collection<String> onlyWords = words.parallelStream().filter(word -> !word.isEmpty())
                .collect(Collectors.toList());
        System.out.println(onlyWords);

        String sentence = words.stream().filter(word -> !word.isEmpty()).collect(Collectors.joining(" ")) + ".";
        System.out.println(sentence);

        long vocabulary = words.stream().filter(word -> !word.isEmpty()).count();
        System.out.println(vocabulary);

        long distinctVocabulary = words.stream().filter(word -> !word.isEmpty()).distinct().count();
        System.out.println(distinctVocabulary);

    }
}
