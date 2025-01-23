import java.util.stream.Collectors;

public class Detect_special_character_String {
    public static void main(String[] args) {
        String str = "Hello@World!";

        String specialChars = str.chars()
                .filter(c -> !Character.isLetterOrDigit(c))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        System.out.println("Special characters in the string: " + specialChars);
    }
}
