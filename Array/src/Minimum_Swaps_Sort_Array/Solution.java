package Minimum_Swaps_Sort_Array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static int solve(ArrayList<Integer> A) {
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        int n = A.size();
        int count = 0;

        for (int i = 0; i < n; i++) {
            list.add(new Pair<>(A.get(i), i));
        }
        Collections.sort(A);

        for (int i = 0; i < n; i++) {
            if (list.get(i).getValue() == i) {
                continue;
            } else {
                count++;
                swap(list.get(i), list.get(list.get(i).getKey()));
                i--;
            }

        }
        return count;

    }

    public static void swap(Pair p, Pair s) {
        Pair t = p;
        p = s;
        s = t;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
                Arrays.asList(2, 1, 5, 6, 3));
        // Arrays.asList(1, 12, 10, 3, 14, 10, 5));
        int k = 3;

       // System.out.println(solve(arr, k));

    }
}
