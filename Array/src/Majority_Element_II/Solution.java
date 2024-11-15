package Majority_Element_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

///https://leetcode.com/problems/majority-element-ii/
//https://www.youtube.com/watch?v=vwZj1K0e9U8
public class Solution {

    public List<Integer>  majorityElement(int[] nums) {
        int n= nums.length;
        List<Integer> result= new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();


        for (int num : nums) {
            int val = map.getOrDefault(num, 0);
            map.put(num, val+1);


            if (map.get(num)== n/3+1) {
                result.add(num);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[]  arr ={3,2,3};
        System.out.println(solution.majorityElement(arr));
    }
}
