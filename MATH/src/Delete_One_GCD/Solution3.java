package Delete_One_GCD;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution3 {
    //Gcd formula
    public static int  gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

    public static int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int gcdNum = 0;
        int index = 0;

//capture which value giving small gcd and catch that
        for (int i = 0; i < A.size(); i++) {
            gcdNum = gcd(gcdNum, A.get(i));
            if (gcdNum < min) {
                min = gcdNum;
                index = i;
            }
        }
        System.out.println("min--"+min);  ///1
        System.out.println("index--"+index);  //3
        int newGcd = 0;

//Dont consider that  element which giving small gcd
        for (int i = 0; i < A.size(); i++) {
            if (i != index) {
                newGcd = gcd(newGcd, A.get(i));
            }
        }

        return newGcd;
    }

        public static void main(String[] args) {
            //int [] A=;
            ArrayList<Integer> arr = new ArrayList<Integer>(
                    Arrays.asList(3, 9, 6, 8, 3));
            // Arrays.asList(1, 12, 10, 3, 14, 10, 5));
            System.out.println(solve(arr));
        }

//
//    min--1
//    index--3
//            3

}
