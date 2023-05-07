import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfChars {


    public static void main(String[] args) {
        String input ="aassccvffaabbbbbdd";
        Map<String, List<String>> map1 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(s -> s));

        System.out.println(map1); //{a=[a, a, a, a], b=[b, b, b, b, b], c=[c, c], s=[s, s], d=[d, d], f=[f, f], v=[v]}

        Map<String, Long> map2 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map2);////{a=4, b=5, c=2, s=2, d=2, f=2, v=1}

    }
}
