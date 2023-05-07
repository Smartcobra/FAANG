package No_Of_Distinct_Elemnts;

/*
*
* Problem Description
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.
*
* */

import java.util.HashSet;

public class Solution1 {
    public static void count_distinct_Elements(int [] arr,int k){
        int n= arr.length;
        for(int i=0;i<=n-k;i++){
            HashSet<Integer> set= new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(arr[j]);
            }
            System.out.println(set.size());
        }
    }

    public static void main(String[] args) {
        int [] A={1, 2, 1, 3, 4, 3};
        int k = 3;
        count_distinct_Elements(A,k);
    }
}

//o(n^2)
