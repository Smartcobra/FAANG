package prefixsum;

/*
* Given an array, arr[] of size N, the task is to find the count
*  of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
*
*
*
*Input 1:

A=[2, 1, 6, 4]

Input 2:

A=[1, 1, 1]



Example Output

Output 1:

1

Output 2:

3

*
*
*
*  */


import java.util.Scanner;

public class Solution {
    public static int solve(int[] A) {
        int n=A.length;
        int Teven=0;
        int Tood=0;
        int[] prefix_evenSum=prefix_even(A);
        int[] prefix_oddSum=prefix_odd(A);
        int count=0;

        for(int i=0;i<n;i++){
            if(i==0){
                Tood=prefix_evenSum[n-1]-prefix_evenSum[i];
                Teven=prefix_oddSum[n-1]-prefix_oddSum[i];  // if we remove 0th index then each index will shift one
                                                            ///       even index after removing "0th" index is equal to odd index with out removing zero

            }else{
                Teven=prefix_evenSum[i-1]+prefix_oddSum[n-1]-prefix_oddSum[i];
                Tood=prefix_oddSum[i-1]+prefix_evenSum[n-1]-prefix_evenSum[i];
            }
            if(Teven==Tood){
                count++;
            }
        }

        return count;
    }

    public static  int[] prefix_even(int[] arr){

        int n=arr.length;

        int [] even_Array= new int [n];
        even_Array[0]=arr[0];

        for(int i=1;i<n;i++){
            if(i%2==0){
                even_Array[i]=even_Array[i-1]+arr[i];
            }else{
                even_Array[i]=even_Array[i-1];
            }

        }

        return even_Array;
    }

    public static  int[] prefix_odd(int[] arr){

        int n=arr.length;

        int [] odd_Array= new int [n];
        odd_Array[0]=0;
        odd_Array[1]=arr[1];

        for(int i=2;i<n;i++){
            if(i%2==1){
                odd_Array[i]=odd_Array[i-1]+arr[i];
            }else{
                odd_Array[i]=odd_Array[i-1];
            }

        }

        return odd_Array;
    }


    /////main class;
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();

        int []arr= new int[size];

        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }

        System.out.println(solve(arr));
    }
}
