package Maximum_Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximumRectangle_Array {

    public static int solve(int[][] A) {
        int R = A.length;
        int C = A[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] col_prefixArr = new int[R][C];


        for (int i = 0; i < C; i++) {
            col_prefixArr[0][i] = A[0][i];
            for (int j = 1; j < R; j++) {
                if (A[j][i] != 0) {
                    col_prefixArr[j][i] = A[j][i] + col_prefixArr[j - 1][i];
                }
            }
        }
//        for (int i = 0; i < R; i++) {
//            for (int j = 0; j < C; j++) {
//                System.out.print(col_prefixArr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < R; i++) {
            int cur_ans = largestRectangleArea(col_prefixArr[i]);
            ans = Math.max(ans, cur_ans);
        }


        return ans;
    }

    public static int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] left = nearSmallest_left(A);
        int[] right = nearSmallest_Right(A);
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int val = right[i] - left[i] - 1;
            ans = Math.max(ans, val * A[i]);
        }

        return ans;
    }

    public static int[] nearSmallest_left(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    public static int[] nearSmallest_Right(int[] A) {
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = n;
        }


        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() > 0) {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;

    }


    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1, 1}};

        System.out.println(solve(arr));

    }


}
