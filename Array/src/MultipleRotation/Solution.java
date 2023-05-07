package MultipleRotation;

import java.util.Arrays;

public class Solution {
    public static  int[][]  solve(int[] A, int[] B) {
        int [][] result=new int [B.length][];
        int index=0;
        int size=A.length;

        for(int i=0;i<B.length;i++){
            int k=B[i];
            k=k%size;
            int [] arr=A;
            reverseArray(arr,0,k-1);
            reverseArray(arr,k,size-1);
            reverseArray(arr,0,size-1);
            result[index]=arr;
            index++;

        }

        return result;
    }

    public static void reverseArray(int [] a, int s , int e){
        while(s<e){
            int tmp=a[s];
            a[s]=a[e];
            a[e]=tmp;
            s++;
            e--;
        }
    }




    public static void main(String[] args) {
        int  []A = {1, 2, 3, 4, 5};
        int []B = {2, 3};
        int[][] solve = solve(A, B);
        for(int i=0;i<solve.length;i++){
            System.out.println(Arrays.toString(solve[i]));
        }


    }

}
