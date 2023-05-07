package Largest_Continuous_Sequence_Zero_Sum;

import java.util.ArrayList;
import java.util.HashMap;

public class LargestContinuousZeroSum {
    public static ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int n = A.size();
        int start = 0;
        int end = 0;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] pf = new int[A.size()];
        pf[0] = A.get(0);
        map.put(0, -1);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + A.get(i);
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(pf[i])) {
                int curLen = i - map.get(pf[i]);
                // maxLen=Math.max(maxLen,curLen);
                if (maxLen < curLen) {
                    maxLen = curLen;
                    end = i;
                    start = map.get(pf[i]);
                }
            } else {
                map.put(pf[i], i);
            }
        }

        for (int i = start+1; i <= end; i++) {
            result.add(A.get(i));
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

