package TwoSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B) {

            HashMap<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> result = new ArrayList<>();

            for (int i = 0; i < A.size(); i++) {
                int k = B - A.get(i);
                if (map.containsKey(k)) {
                    result.add(map.get(k));
                    result.add(i + 1);
                    return result;

                } else if (!map.containsKey(A.get(i))) {  // If there are multiple solutions with the minimum index2, choose the one with minimum index1 out of them.
                    map.put(A.get(i), i + 1);
                }
            }
            return result;

        }

        public static void main (String[]args){
            int[] arr = {4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
            int B = -3;

            List<Integer> list = new ArrayList<Integer>(arr.length);
            for (int i : arr) {
                list.add(i);
            }

            ArrayList<Integer> integers = twoSum(list, B);
            integers.forEach(System.out::println);


        }
    }
