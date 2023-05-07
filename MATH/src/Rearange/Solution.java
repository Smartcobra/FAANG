package Rearange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    public static int [] solve(int [] arr){
//
//        for(int i=0;i<arr.length;i++) {
//            arr[i]=arr[arr[i]];
//
//        }
//        return  arr;
//    }

    public static void arrange(ArrayList<Integer> list) {

        int n=list.size();
        for(int i=0;i<n;i++){
            list.set(i,list.get(i)*n);
        }

        for(int i=0;i<n;i++){
            int idx=list.get(i)/n;
            int val=list.get(idx)/n;
            list.set(i,list.get(i)+val);
        }
        for(int i=0;i<n;i++){
            list.set(i,list.get(i)%n);
        }

        for(int i=0;i<n;i++){
            System.out.print(list.get(i) +" ");
        }

    }

    public static void main(String[] args) {
        int []A ={ 4, 0, 2, 1, 3 };
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<A.length;i++){
            list.add(A[i]);
        }
        arrange(list);  //3 4 2 0 1
    }
}
