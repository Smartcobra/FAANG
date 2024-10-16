package Longest_Valid_Parentheses;

//https://leetcode.com/problems/longest-valid-parentheses/
/*
 *  initially pushed -1 to stack
 *  pop if it is a closed ")" --> once you pop insert its index
 * push if open "("
 * */

import java.util.Stack;

//push ")" closed parenthesis
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); /// if input stats with close ')'
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int len = i - stack.peek();
                    max = Math.max(max, len);
                }
            }
        }

        return max;

    }

}
