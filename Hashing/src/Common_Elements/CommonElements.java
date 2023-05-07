package Common_Elements;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonElements {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> countMap = A.stream().mapToInt(n -> n).boxed().collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));
        //System.out.println(countMap);
        for (int num : B) {
            if (countMap.containsKey(num) && countMap.get(num) != 0) { //checking the element is present in the array
                result.add(num); // adding to resulting list
                countMap.merge(num, -1, Integer::sum); // decreasing the count in the map
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(2);
        list2.add(2);
        list2.add(3);
        list2.add(3);
       solve(list1,list2);
    }
}
