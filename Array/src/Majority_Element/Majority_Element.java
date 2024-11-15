package Majority_Element;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

///https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
public class Majority_Element {

    public static int majorityElement(int[] nums) {
        int max = 0;
        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums) {
            if (!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                int val = map.get(a);
                map.put(a, val + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }


        return result;

    }

    /**
     *
     *
     *
     *
     *
     *
     * HashMap<Integer, Integer> mpp = new HashMap<>();
     *
     *         //storing the elements with its occurnce:
     *         for (int i = 0; i < n; i++) {
     *             int value = mpp.getOrDefault(v[i], 0);
     *             mpp.put(v[i], value + 1);
     *         }
     *
     *         //searching for the majority element:
     *         for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
     *             if (it.getValue() > (n / 2)) {
     *                 return it.getKey();
     *             }
     *         }
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(arr));
    }

}
