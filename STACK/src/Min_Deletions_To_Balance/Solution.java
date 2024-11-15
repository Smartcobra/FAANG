package Min_Deletions_To_Balance;

import java.util.Stack;

public class Solution {
    public static int minDeletionsToBalance(String brackets) {
        Stack<Character> stack = new Stack<>();
        int open =0;
        int close=0;

        for(Character ch : brackets.toCharArray()){
            if(ch.equals('(')){
                stack.push(ch);
            }else if(ch.equals(')')) {
                if (!stack.isEmpty() && stack.peek().equals('(')) {
                    stack.pop();
                } else {
                    close++;
                }
            }
        }

        open = stack.size();

        return close+open;
    }

    public static void main(String[] args) {
        String brackets = "(()))(";
        System.out.println("Minimum deletions to balance: " + minDeletionsToBalance(brackets));
    }
}
