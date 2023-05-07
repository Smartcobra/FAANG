package First_Missing_Integer;

import java.util.HashSet;

public class Solution {

    public static int firstMissingPositive(int[] A) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i <n; i++) {
            set.add(A[i]);
        }

        for (int i = 1; i <= A.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        int [] a={1};
        System.out.println(firstMissingPositive(a));
    }
}
