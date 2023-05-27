import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Find_Max_Element {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        Integer max = myList.stream().max(Integer::compare).get();
        System.out.println(max);
    }
}
