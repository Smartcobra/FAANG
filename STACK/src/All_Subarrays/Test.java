package All_Subarrays;

import java.util.Stack;

public class Test {
    static int maximumXor(int arr[], int n) {
        Stack<Integer> sForward = new Stack<Integer>(),
                sBackward = new Stack<Integer>();

        // To store the final answer
        int ans = -1;

        for (int i = 0; i < n; i++) {

            // forward traversal
            while (!sForward.isEmpty()
                    && arr[i] < arr[sForward.peek()]) {
                ans = Math.max(ans, arr[i] ^ arr[sForward.peek()]);
                sForward.pop();
            }
            sForward.add(i);

            // Backward traversal
            while (!sBackward.isEmpty()
                    && arr[n - i - 1] < arr[sBackward.peek()]) {
                ans = Math.max(ans, arr[n - i - 1] ^ arr[sBackward.peek()]);
                sBackward.pop();
            }

            sBackward.add(n - i - 1);
        }
        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {9, 8, 3, 5, 7};
        int n = arr.length;

        System.out.print(maximumXor(arr, n));

    }
}
