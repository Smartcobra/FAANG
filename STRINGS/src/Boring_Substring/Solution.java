package Boring_Substring;

import java.util.Arrays;

/////https://www.scaler.com/academy/mentee-dashboard/class/29549/assignment/problems/5550?navref=cl_tt_nv
public class Solution {
    ///
    public static int boringString(String str) {
        int n = str.length();
        String odd = "";
        String even = "";

        /////////////decreases performance
//        for(Character s:str.toCharArray()){
//            if((s&1)==0){
//                even+=s;
//            }else{
//                odd+=s;
//            }
//        }

        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c % 2 == 0)
                odd += c;
            else
                even += c;
        }

        char[] oddArray = odd.toCharArray();
        Arrays.sort(oddArray);
        odd = String.valueOf(oddArray);
        System.out.println("odd--" + odd);

        char[] evenArray = even.toCharArray();
        Arrays.sort(evenArray);
        even = String.valueOf(evenArray);
        System.out.println("even--" + even);

        if (check(odd + even)) return 1;

        if (check(even + odd)) return 1;

        return 0;

    }

    public static boolean check(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) == 1) {
                return false;
            }
        }
        return true;
    }
//    public boolean check(String s) {
//        boolean ok = true;
//        for (int i = 0; i + 1 < s.length(); ++i)
//            ok &= (Math.abs(s.charAt(i) - s.charAt(i + 1)) != 1);
//        return ok;
//    }

    public static void main(String[] args) {
        System.out.println(boringString("gbedggcjac"));
    }
}
