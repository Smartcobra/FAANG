import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Find_2nd_Largest_in_List {


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
        Integer max2 = numbers.stream().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                        .get();

        System.out.println(max2);
    }

}
