package Equilibrium_Index_Of_An_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int solve(ArrayList<Integer> A) {
        int size=A.size();

        int [] prefix_Arr= new int[size];
        int [] suffix_Arr= new int[size];

        prefix_Arr[0]=A.get((0));
        for(int i=1;i<size;i++){
            prefix_Arr[i]=prefix_Arr[i-1]+A.get(i);
        }

        suffix_Arr[size-1]=A.get((size-1));
        for(int i=size-2;i>=0;i--){
            suffix_Arr[i]=suffix_Arr[i+1]+A.get(i);
        }

        for(int i=0;i<size;i++){
            if(suffix_Arr[i]==prefix_Arr[i]){
              return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr= {-7, 1, 5, 2, -4, 3, 0};
        ArrayList<Integer> list= new ArrayList();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }

        System.out.println(solve(list));

    }
}
