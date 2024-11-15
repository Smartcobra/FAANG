import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Find_Nth_Highest_Salary {
    public static void main(String[] args) {


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

        Map.Entry<String, Integer> results = getNthHighestSalary(4, map1);
        System.out.println(results);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);
        System.out.println(getDynamicNthHighestSalary(2, map2));

    }

    public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {
        Map<Integer, List<Map.Entry<String, Integer>>> collect = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue));
        System.out.println(collect);
        //{1200=[ankit=1200, james=1200, bhavna=1200], 1300=[daniel=1300, tom=1300], 1000=[micael=1000, anil=1000]}
        /*
        *  See here  we got ::
        * 1200=[ankit=1200, james=1200, bhavna=1200]
        * 1300=[daniel=1300, tom=1300]
        * 1000=[micael=1000, anil=1000]
        *
        * */
        // we need key only
        Map<Integer, List<String>> collect1 = map.entrySet().stream().collect(Collectors.groupingBy
                (Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(collect1);

        /*
        *  {1200=[ankit, james, bhavna], 1300=[daniel, tom], 1000=[micael, anil]}
        * 1200=[ankit, james, bhavna]
        * 1300=[daniel, tom]
        * 1000=[micael, anil]
        * */


        ///for lowest
        Map.Entry<Integer, List<String>> lowestSalary = map.entrySet().stream().collect(Collectors.groupingBy
                        (Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList())
                .get(num - 1);


        Map.Entry<Integer, List<String>> highestSalary = map.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .collect(Collectors.toList())
                .get(num - 1);


        return highestSalary;
    }



    /*
    *
    *
    * Does not Handle Same salary for multiple employee
    *
    * */
    public static Map.Entry<String, Integer> getNthHighestSalary(int num, Map<String, Integer> map) {

        map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList())
                .get(num-1);   /// give you the nth smallest


        return map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toList())
                .get(num-1);

    }


}
