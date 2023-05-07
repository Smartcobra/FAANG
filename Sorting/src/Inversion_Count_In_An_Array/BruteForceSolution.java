package Inversion_Count_In_An_Array;

public class BruteForceSolution {
    public static int solve(int[] A) {
       int n=A.length;
       int count=0;
       for(int i=0;i<n;i++){
           for(int j=i+1;j<n;j++){
               if(A[i]>A[j]) count++;
           }
       }
        return count;

    }

    public static void main(String[] args) {
        // int []A = {28, 18, 44, 49, 41, 14 };
        int [] A={1,3, 2, 3, 1};
        System.out.println(solve(A));
    }
}
