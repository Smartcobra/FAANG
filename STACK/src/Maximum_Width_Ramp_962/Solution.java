package Maximum_Width_Ramp_962;
//https://leetcode.com/problems/maximum-width-ramp/description/?envType=problem-list-v2&envId=monotonic-stack
import java.util.Stack;

public class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (st.isEmpty() || nums[st.peek()] >= nums[i]) {
                st.push(i);
            }
        }

        int ramp = 0;
        int j = n - 1;

        while (j >= 0) {

            while (!st.isEmpty() && nums[j] >= nums[st.peek()]) {
                int i = st.peek();
                ramp = Math.max(ramp, j - i);
                st.pop();
            }

            j--;

        }
        return ramp;

    }

}
