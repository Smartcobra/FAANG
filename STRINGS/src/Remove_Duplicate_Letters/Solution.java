package Remove_Duplicate_Letters;

import java.util.Stack;
///https://leetcode.com/problems/remove-duplicate-letters/description/

//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/description/
public class Solution {
    public String removeDuplicateLetters(String s) {
        int n= s.length();
        int[] lastOccurrence = new int[26];
        boolean[] taken = new boolean[26];
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++){
            lastOccurrence[s.charAt(i)-'a'] =i;
        }

        for(int i=0;i<n;i++){
            char currChar = s.charAt(i);
            int idx = currChar-'a';

            if(taken[idx]) continue;

            while(!stack.isEmpty() && stack.peek() > currChar && lastOccurrence[stack.peek()-'a'] >i) {
                taken[stack.pop()-'a'] =false;
            }

            stack.push(currChar);
            taken[idx] = true;
        }

        for(char c :stack){
            result.append(c);
        }

        return result.toString();
    }
}
