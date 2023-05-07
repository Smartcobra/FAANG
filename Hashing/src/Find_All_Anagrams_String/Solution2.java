package Find_All_Anagrams_String;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=G8xtZy0fDKg
public class Solution2 {

    public static List<Integer> findAnagrams2(String source, String pattern) {
        List<Integer> result = new ArrayList<Integer>();
        int[] count = new int[26];

        for (char c : pattern.toCharArray()) {
            count[c - 'a']++;
        }

        for(int l=0,r=0;r<source.length();r++){
            char c= source.charAt(r);
            count[c-'a']--;

            while(count[c-'a']<0){
                count[source.charAt(l)-'a']++;
                l++;
            }

            if(r-l+1==pattern.length()){
                result.add(l);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams2(s, p));
    }
}
