package Nearest_Smaller_Index_left;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> nearSmallest_Index_left(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                ans.set(i, stack.peek());
            }

            stack.push(i);
        }

        return ans;
    }
}
