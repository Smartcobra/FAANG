package MAX_And_MIN;

import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public static int solve(int[] A) {
        //pre-compute all of this
        int[] prevSmall = prevSmallerIndex(A);
        int[] nextSmall = nextSmallerIndex(A);
        int[] prevGreater = prevGreaterIndex(A);
        int[] nextGreater = nextGreaterIndex(A);
        int mod = 1000 * 1000 * 1000 + 7;

        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            //subarray in which A[i] is min
            int p1 = prevSmall[i];
            int p2 = nextSmall[i];
            long prodMin = ((long) (i - p1) * (p2 - i)) % mod;
            long minContribution = (prodMin * A[i]) % mod;

            //subarray in which A[i] is max
            int p3 = prevGreater[i];
            int p4 = nextGreater[i];
            long prodMax = ((long) (i - p3) * (p4 - i)) % mod;
            long maxContribution = (prodMax * A[i]) % mod;

            //computing ans
            ans = (ans % mod) + ((maxContribution - minContribution) % mod);
            ans = ans % mod;
        }
        if (ans < 0) {
            ans = (ans + mod) % mod;
        }
        return (int) (ans % mod);
    }

    private static int[] prevSmallerIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextSmallerIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] prevGreaterIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    private static int[] nextGreaterIndex(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        Arrays.fill(ans, N); //edge case
        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] >= A[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347};
        System.out.println(Arrays.toString(prevSmallerIndex(A)));
        System.out.println(Arrays.toString(nextSmallerIndex(A)));
        System.out.println(Arrays.toString(prevGreaterIndex(A)));
        System.out.println(Arrays.toString(nextGreaterIndex(A)));

        System.out.println(solve(A));
    }
}
