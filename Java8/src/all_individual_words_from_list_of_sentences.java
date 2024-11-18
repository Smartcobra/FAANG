import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class all_individual_words_from_list_of_sentences {
    public static void main(String[] args) {
        List<String> sentences = Arrays.asList("Hello world", "Java 8 Streams", "flatMap example");

        List<String> words = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());

        System.out.println(words);
// Output: [Hello, world, Java, 8, Streams, flatMap, example]
    }

}
