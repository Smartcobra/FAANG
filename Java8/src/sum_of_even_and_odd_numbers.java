import java.util.Arrays;
import java.util.List;

public class sum_of_even_and_odd_numbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfEvens = numbers.stream()
                .filter(num -> num % 2 == 0) // Filter even numbers
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum();

        int sumOfOdds = numbers.stream()
                .filter(num -> num % 2 != 0) // Filter odd numbers
                .mapToInt(Integer::intValue) // Convert to IntStream
                .sum();

        System.out.println("Sum of Even Numbers: " + sumOfEvens);
        System.out.println("Sum of Odd Numbers: " + sumOfOdds);
    }
}
