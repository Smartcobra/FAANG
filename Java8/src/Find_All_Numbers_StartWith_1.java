import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Find_All_Numbers_StartWith_1 {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);

        myList.stream().map(s -> s + " ")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());
    }
}
