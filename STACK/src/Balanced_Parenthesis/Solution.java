package Balanced_Parenthesis;

import java.util.Stack;

public class Solution {
    public static int solve(String str) {
        Stack<Character> stack = new Stack<>();
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return ans;
                } else {
                    if (str.charAt(i) == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else {
                            break;
                        }
                    } else if (str.charAt(i) == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else {
                            break;
                        }
                    } else if (str.charAt(i) == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else {
                            break;

                        }
                    }

                }
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        String str = "))))))))";

        System.out.println(solve(str));

    }
}
