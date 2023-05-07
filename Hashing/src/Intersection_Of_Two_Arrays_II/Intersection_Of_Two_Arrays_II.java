package Intersection_Of_Two_Arrays_II;

import java.util.*;

///https://leetcode.com/problems/intersection-of-two-arrays-ii/
public   class Intersection_Of_Two_Arrays_II {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(int n :nums1){
            map.put(n,map.getOrDefault(n,0)+1);
        }



        for(int n :nums2){
            if(map.containsKey(n) && map.get(n)>0){
                list.add(n);
                map.put(n,map.get(n)-1);
            }
        }

        int i=0;
        int[] ans = new int[list.size()];
        for(int n :list){
            ans[i++]=n;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(Arrays.toString(intersect(nums1, nums2)));


    }
}
