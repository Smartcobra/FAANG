package LongestSubstringWithoutRepeatingCharacters;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class Longest_Substring_Without_Repeating_Characters {

    public static int getLongestSubstringUnqChars(String str){

        int j=0;
        int i=0;
        int max=Integer.MIN_VALUE;
        Map<Character, Integer> map= new HashMap<>();

        while(j<str.length()){
            map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);

//            if(map.size()>j-i+1){    /// this condition will not ever statisfy for unique chars
//                j++;
//            }
            if(map.size()==j-i+1){
                max=Math.max(max,j-i+1);
                j++;
            }else if(map.size()<j-i+1){
                while(map.size()<j-i+1){  // here map size is less than window size that means in the window one or more char repeated
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);

                    if(map.get(str.charAt(i))==0){
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str="abcbbcbb";
        System.out.println(getLongestSubstringUnqChars(str));

    }
}
