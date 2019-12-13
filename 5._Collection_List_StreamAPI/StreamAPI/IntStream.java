package StreamAPI;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class IntStream {

    static List<Integer> numbers = Arrays.asList(1,4,5,6,7,7,8,9,10,12,12);

    public static void main(String[] args) {

        // Print out each number
        numbers.forEach(number -> System.out.println(number));

        System.out.println("Squared list:");
        List<Integer> squaredNumbers = numbers.stream().map(number -> number*number).collect(Collectors.toList());
        System.out.println(squaredNumbers + "\n");

        System.out.println("Unique squared list:");
        List<Integer> squaredNumbersUnique = numbers.stream().map(number -> number*number).distinct()
                .collect(Collectors.toList());
        System.out.println(squaredNumbersUnique + "\n");

        System.out.println("Even number list:");
        Integer[] evenNumbers = numbers.stream().filter(number -> number%2==0).toArray(Integer[]::new);
        System.out.println(Arrays.toString(evenNumbers) + "\n");

        IntSummaryStatistics stats = numbers.stream().mapToInt(number -> number).summaryStatistics();

        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());

    }
}
