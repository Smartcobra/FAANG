package Permutation_With_Spaces;


//https://practice.geeksforgeeks.org/problems/permutation-with-spaces3627/1

import java.util.ArrayList;
import java.util.List;

public class PermutationWithSpaces {

    public static List<String> getSpaceString(String str) {
        //Base condition


        //for output
        List<String> strs = new ArrayList<>();

        if (str.length() == 1) {
            strs.add(str);
            return strs;
        }

        // to take first char
        List<String> spaceString = getSpaceString(str.substring(1, str.length()));

        for (int i = 0; i < spaceString.size(); i++) {

            strs.add(str.charAt(0) +
                    spaceString.get(i));
            strs.add(str.charAt(0) + " " +
                    spaceString.get(i));
        }


        return strs;

    }

    public static void main(String[] args) {
       // getSpaceString("ABCD");
          List<String> patterns = getSpaceString("ABCD");

        // Print patterns
        for (String s : patterns)
        {
            System.out.println(s);
        }

    }
}
