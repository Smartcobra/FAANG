package strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {


    }
    // Question 1: Counting Characters
    //Input Example: iFollowMilindMehta
    //
    //Expected Result: {a=1,t=1,d=1,e=1,F=1,w=1,h=1,i=1,M=1,n=1,o=1}
    public static Map<Character, Long> countCharacters(String str) {
        return str.chars() // Convert string to a stream of char values (int)
                .mapToObj(c -> (char) c) // Convert int values back to chars
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    //Question 2: Finding Duplicates
    //Input Example: iFollowMilindMehta
    //
    //Expected Result: i,l,M,o
    public static Map<Character, Long> findDuplicates(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    //Question 3: Finding the First Unique Character
    //Input Example: iFollowMilindMehta
    //Expected Result: F
//Using LinkedHashMap to maintain insertion order helps find the first unique character.
    public static Character findFirstUnique(String str) {
        return str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    //Question 4: Second Highest Number in an Array
    //Input Example: {5,8,2,13,42,56,24,36}
    //
    //Expected Result: 42
    //Justification: Converts the array to a stream, sorts in reverse order, skips the first element, and retrieves the second.
    public static Integer findSecondHighest(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);
    }

    //Question 5: Finding the Longest String in an Array
    //Input Example: {“Milind”,”Mehta”,”follow”,”java8",”Microservice”,”Springboot”}
    //
    //Expected Result: Microservice
    public static String findLongestString(String[] strings) {
        return Arrays.stream(strings)
                .reduce((str1, str2) -> str1.length() > str2.length() ? str1 : str2)
                .orElse(null);
    }

    //Question 6: Finding Elements that Start with a Specific Digit
    //Input Example: {1,2,11,21,31,42,56,23,16}
    //
    //Expected Result: {“1”,”11",”16"}
//Justification: Converts numbers to strings and filters those that start with the digit 1.
    public static List<String> findElementsStartingWithOne(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .filter(str -> str.startsWith("1"))
                .collect(Collectors.toList());
    }

}
