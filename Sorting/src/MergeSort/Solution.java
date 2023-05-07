package MergeSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void solve(List<Integer> A) {
        int s = 0;
        int e = A.size() - 1;
        mergeSort(A, s, e);
    }

    public static void mergeSort(List<Integer> A, int s, int e) {
        if (s == e) return;
        int m = (s + e) / 2;
        mergeSort(A, s, m);
        mergeSort(A, m + 1, e);
        merge(A, s, m, e);
    }

    public static void merge(List<Integer> A, int s, int m, int e) {
        int p1 = s;
        int p2 = m + 1;

        List<Integer> tmp = new ArrayList<>();

        while (p1 <= m && p2 <= e) {
            if (A.get(p1) <= A.get(p2)) {
                tmp.add(A.get(p1));
                p1++;

            } else {
                tmp.add(A.get(p2));
                p2++;
            }
        }

        while (p2 <= e) {
            tmp.add(A.get(p2));
            p2++;
        }

        while (p1 <= m) {
            tmp.add(A.get(p1));
            p1++;
        }

        for (int i = 0; i <= e - s; i++) {
            A.set(i + s, tmp.get(i));
        }

    }

    public static void main(String[] args) {
        List<Integer> l= Arrays.asList( 12, 11, 13, 5, 6, 7,100,4,3333333,5,6,23,0,-3,-77 );
        solve(l);
        l.forEach(s->System.out.print(s+" "));
    }
}
