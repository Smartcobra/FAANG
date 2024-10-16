package Balanced_Parenthesis;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
////https://leetcode.com/problems/valid-parentheses/description/
public class Solution_Map {

    public static int balanced(String str){
        Map<Character,Character> map= new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Stack<Character> stack= new Stack<>();
        for(int i=0;i<str.length();i++){
            char cur_char=str.charAt(i);
            if(map.containsKey(cur_char)){
                if(stack.empty() || stack.pop() !=map.get(cur_char)) return 0;
            }else{
                stack.push(cur_char);
            }
        }
     return stack.empty() ?1:0;
    }

    public static void main(String[] args) {
        String str = "{([])}";

        System.out.println(balanced(str));
    }
}
