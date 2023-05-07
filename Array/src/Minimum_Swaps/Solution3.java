package Minimum_Swaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution3 {

    public static int solve(ArrayList<Integer> A) {

        int res=0;
        int i=0,j=A.size();
        while(i<j){
            if(A.get(i)==i)
                i++;
            else{
                Collections.swap(A, i, A.get(i));
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
              //  Arrays.asList(1, 2, 3, 4, 0));
         Arrays.asList(2, 0, 1, 3));

        System.out.println(solve(arr));

    }
}
