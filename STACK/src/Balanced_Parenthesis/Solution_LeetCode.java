package Balanced_Parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
////https://leetcode.com/problems/valid-parentheses/description/
public class Solution_LeetCode {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack = new Stack<>();

        for(Character ch: s.toCharArray()){
            if(map.containsKey(ch)){  // if the character is a closing bracket check the stack
                if(stack.isEmpty() || !stack.pop().equals(map.get(ch))) return false;
            }else{  // the character is a open bracket push to stack.
                stack.push(ch);
            }
        }

        return stack.isEmpty();

    }
}
