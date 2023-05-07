package Noble_Integers_Array;

/*
* Noble integers in an array (count of greater elements is equal to value)

    Difficulty Level : Medium
    Last Updated : 13 Jun, 2022

Given an array arr[], find a Noble integer in it. An integer x is said to be Noble in arr[] if the number of integers greater than x is equal to x. If there are many Noble integers, return any of them. If there is no, then return -1.

Examples :

Input  : [7, 3, 16, 10]
Output : 3
Number of integers greater than 3
is three.

Input  : [-1, -9, -2, -78, 0]
Output : 0
Number of integers greater than 0
is zero.*/

public class Solution {

    public static int nobleInteger(int[] arr) {
        int n = arr.length;
        for (int k : arr) {
            int count = 0;
            for (int i : arr) {
                if (i > k) count++;
            }
            if (count == k) return k;
        }

        return -1;
    }

    public static void main(String[] args) {
        int [] arr = {10, 3, 20, 40, 2};
        int res = nobleInteger(arr);
        if (res != -1)
            System.out.println("The noble "
                    + "integer is "+ res);
        else
            System.out.println("No Noble "
                    + "Integer Found");
    }

}
