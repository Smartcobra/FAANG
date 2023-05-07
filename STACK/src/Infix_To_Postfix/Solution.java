package Infix_To_Postfix;

import java.util.Stack;

public class Solution {
    public String solve(String A) {

        Stack<Character> stack= new Stack<>();
        int n=A.length();
        StringBuilder result= new StringBuilder();

        for(int i=0;i<n;i++){
            char c=A.charAt(i);

            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }else if(c=='('){
                stack.push(c);
            }else if(c==')'){
                while(!stack.isEmpty() && stack.peek() !='('){
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && checkPrec(c)<=checkPrec(stack.peek())){
                    result.append(stack.peek());
                    stack.pop();
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            result.append(stack.peek());
            stack.pop();
        }
        return result.toString();

    }

    public int checkPrec(char c){
        switch(c){
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}
