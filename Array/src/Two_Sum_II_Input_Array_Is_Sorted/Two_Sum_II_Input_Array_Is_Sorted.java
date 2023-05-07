package Two_Sum_II_Input_Array_Is_Sorted;

import java.util.HashMap;

///https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class Two_Sum_II_Input_Array_Is_Sorted {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];


        for (int i = 0; i < n; i++) {
            int val = target - numbers[i];
            if (map.containsKey(val) && i != map.get(val)) {
                result[0] = map.get(val)+1;   //one based index
                result[1] = i+1;  //one based index
            } else {
                map.put(numbers[i], i);
            }
        }

        return result;


    }
}
