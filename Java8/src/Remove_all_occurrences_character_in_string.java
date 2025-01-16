
import java.util.stream.Collectors;
public class Remove_all_occurrences_character_in_string {
    public static void main(String[] args) {
        String str = "hello world";
        char charToRemove = 'l';

        String result = str.chars()
                .filter(c -> c != charToRemove)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Original string: " + str);
        System.out.println("String after removing '" + charToRemove + "': " + result);
    }
}
