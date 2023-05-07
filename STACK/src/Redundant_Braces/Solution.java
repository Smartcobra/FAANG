package Redundant_Braces;

import java.util.Stack;

public class Solution {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        int n = A.length();
        boolean ans = false;

        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);

            if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    ans = true;
                }
                while (stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/') {
                    stack.pop();
                }
                stack.pop();
            }
        }

        return ans ? 1 : 0;
    }

    public static void main(String[] args) {

    }
}
