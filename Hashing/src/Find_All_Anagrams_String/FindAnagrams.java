package Find_All_Anagrams_String;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

///https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAnagrams {
    public static List<Integer> findAnagrams(String source, String pattern) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int plen = pattern.length();
        int slen = source.length();

        if (plen > slen) return result;


        for (int i = 0; i < plen; i++) {
            char ch = pattern.charAt(i);
            pmap.put(ch, pmap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < plen; i++) {
            char ch = source.charAt(i);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
        }

        int i = pattern.length();
        while (i < source.length()) {
            //if (smap.equals(pmap)) { // use this method rather than comapre . compare failing for some test case
            if (comapre(smap,pmap)) {
                result.add(i - plen);
            }

            char ch1 = source.charAt(i);
            smap.put(ch1, smap.getOrDefault(ch1, 0) + 1);

            char ch2 = source.charAt(i - plen);
            if (smap.get(ch2) == 1) {
                smap.remove(ch2);
            } else {
                smap.put(ch2, smap.get(ch2) - 1);
            }

            i++;
        }
        if (smap.equals(pmap)) {
            result.add(i - plen);
        }

        return result;

    }

    public static boolean comapre(HashMap<Character, Integer> m1, HashMap<Character, Integer> m2) {

        for (char c : m1.keySet()) {
            if (m1.getOrDefault(c, 0) != m2.get(c)) {
                return false;
            }
        }
        return true;   /// using this method failing some test case
    }

    public static void main(String[] args) {
//        String s = "cbaebabacd";
//        String p = "abc";
//        System.out.println(findAnagrams(s, p));

        String s1="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String s2="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(findAnagrams(s1, s2));
    }
}
