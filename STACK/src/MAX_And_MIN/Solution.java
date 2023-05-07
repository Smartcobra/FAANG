package MAX_And_MIN;

import java.util.*;

public class Solution {
    public static int solve(List<Integer> A) {
        int MOD = 1000 * 1000 * 1000 + 7;
        int n = A.size();
        long ans = 0;
        List<Integer> left_small_index = nearSmallest_Index_left(A);
        List<Integer> right_small_index = nearSmallest_Index_Right(A);
        List<Integer> left_greater_index = nearGreater_Index_left(A);
        List<Integer> right_greater_index = nearGreater_Index_right(A);

        for (int i = 0; i < n; i++) {
            int p1 = left_small_index.get(i);
            int p2 = right_small_index.get(i);
            long prodmin = ((long) (i - p1) * (p2 - i)) % MOD;
            long min_contribution = (A.get(i) * prodmin) % MOD;

            int p3 = left_greater_index.get(i);
            int p4 = right_greater_index.get(i);
            long prodmax = ((long) (i - p3) * (p4 - i)) % MOD;

            long max_contribution = (A.get(i) * prodmax) % MOD;

            ans = (ans % MOD) + ((max_contribution - min_contribution) % MOD);
            ans = ans % MOD;
        }
        if (ans < 0) {
            ans = (ans + MOD) % MOD;
        }
        return (int) (ans % MOD);

    }


    ////smaller left
    public static List<Integer> nearSmallest_Index_left(List<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                result.set(i, stack.peek());
            }

            stack.push(i);
        }

        return result;
    }

    //smaller right    if right fill with n
    public static List<Integer> nearSmallest_Index_Right(List<Integer> A) {
        int n = A.size();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, n));
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (stack.size() > 0 && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                result.set(i, stack.peek());
            }

            stack.push(i);
        }
        return result;
    }

    // greater left
    public static List<Integer> nearGreater_Index_left(List<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && A.get(i) >= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                result.set(i, stack.peek());
            }

            stack.push(i);
        }

        return result;
    }

    //// greater right
    public static List<Integer> nearGreater_Index_right(List<Integer> A) {
        int n = A.size();
        List<Integer> result = new ArrayList<>(Collections.nCopies(n, n));
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (stack.size() > 0 && A.get(i) >= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                result.set(i, stack.peek());
            }

            stack.push(i);

        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347);
        System.out.println(nearSmallest_Index_left(list));
        System.out.println(nearSmallest_Index_Right(list));
        System.out.println(nearGreater_Index_left(list));
        System.out.println(nearGreater_Index_right(list));
        System.out.println(solve(list));
    }
}
