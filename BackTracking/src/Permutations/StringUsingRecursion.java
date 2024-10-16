package Permutations;

import java.util.ArrayList;
import java.util.List;

public class StringUsingRecursion {

    public static void main(String[] args) {
        String str = "abcde";
        List<String> list = new ArrayList<>();
        permute(str, "", list);

        list.forEach(System.out::println);

    }

    public static void permute(String str, String tmp, List<String> l) {
        if (str.length() == 0) {
            l.add(tmp);
            return;
        }


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String before = str.substring(0, i);
            String after = str.substring(i + 1);
            String rem = before + after;

            permute(rem, tmp + c, l);
        }
    }
}

/**
 *  TC = n!
 *  SC = n!
 */