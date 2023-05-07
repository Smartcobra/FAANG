package Matrix_Median;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int findMedian(List<List<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (List<Integer> integers : A) {
            min = Math.min(min, integers.get(0));
            max = Math.max(max, integers.get(m - 1));
        }

//        System.out.println(min);
//        System.out.println(max);
        int high=max;
        int low=min;

        while(low<=high){
            int mid=(low+high)/2;

            ///check how many numbers are less than or equal to current mid  ==count
            //if the count <= n*m/2
        }

        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2,3,5);
        List<Integer> list2 = Arrays.asList(2, 3, 4);
        List<Integer> list3 = Arrays.asList(1,7,9);
        List<List<Integer>> list= new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println(findMedian(list));
    }
}
