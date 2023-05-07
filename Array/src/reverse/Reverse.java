package reverse;

import java.util.Scanner;

public class Reverse {
    public static int[] solve(final int[] A) {

        int start=0;
        int end=A.length-1;

        while(start<=end){
            int tmp=A[start];
            A[start]=A[end];
            A[end]=tmp;
        }
        return A;
    }


    public static void main (String [] args){
        Scanner sc= new Scanner(System.in);
        int size=sc.nextInt();
        int [] arr= new int[size];

        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }

        int [] result= solve(arr);

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }


    }
}
