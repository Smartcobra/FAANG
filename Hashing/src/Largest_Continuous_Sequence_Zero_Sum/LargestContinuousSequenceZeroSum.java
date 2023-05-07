package Largest_Continuous_Sequence_Zero_Sum;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousSequenceZeroSum {

    //  Given an array A of N integers.
    //Find the largest continuous sequence in a array which sums to zero.

    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        int i = -1;
        int sum = 0;
        int maxLen = 0;
        map.put(sum, i);
        int start = 0;
        int end = 0;

        while (i < A.size()-1) {
            i++;
            sum += A.get(i);
            if (map.containsKey(sum)) {
                int l = i - map.get(sum);
                if (maxLen < l) {
                     maxLen=l;
                    end = i;
                    start = map.get(sum);
                }
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(start+1 + " " + end);
        for(int j=start+1;j<=end;j++){
            result.add(A.get(j));
        }
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(-2);
//        list.add(4);
//        list.add(-4);

        list.add(1);
        list.add(2);
        list.add(-3);
        list.add(3);

        ArrayList<Integer> lszero = lszero(list);
        lszero.stream().forEach(System.out::println);
    }
}
