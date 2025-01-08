package Count_Vowel_Strings_in_Ranges;
/////https://leetcode.com/problems/count-vowel-strings-in-ranges/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n= words.length;
        int [] prefix = new int[n+1];

        for(int i=0;i<n;i++){
            prefix[i+1] = prefix[i]+(isVowel(words[i])?1:0);
        }

        int [] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int r = queries[i][1];
            int l = queries[i][0];
            ans[i] = prefix[r+1]-prefix[l];

        }

        return ans;

    }

    public boolean isVowel(String s){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        char first = s.charAt(0);
        char last = s.charAt(s.length()-1);

        return vowels.contains(first) && vowels.contains(last);

    }
}