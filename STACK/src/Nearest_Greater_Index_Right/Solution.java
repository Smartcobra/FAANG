package Nearest_Greater_Index_Right;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> nearGreater_Index_Right(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, n));
        // ans.add(n,ele);


        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && A.get(i)>= A.get(stack.peek())) {
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
