package ChangeCharacter;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static int solve(String str, int b) {

        int[] frequency = new int[26];
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i) - 'a']++;
        }
        ArrayList<Integer> c = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                c.add(frequency[i]);
            }

        }
        Collections.sort(c);

        int ans = c.size();
        for (int i = 0; i < c.size(); i++) {
            if (c.get(i) <= b) {
                b -= c.get(i);
                ans--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve("abcabbccd", 3));
    }

}
