package LittlePonnyandMaximumElement;

import java.util.Scanner;

public class Solve {
    public static int solve(int[] arr, int B) {
        int count=0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>B){
                count++;
            }else{
                count=-1;
            }
        }

        return count;
    }
    public static void main(String [] args){
//        Scanner sc= new Scanner(System.in);
//        int size= sc.nextInt();
//        int [] arr= new int[size];
//        for(int i=0;i<size;i++){
//            arr[i]=sc.nextInt();
//        }
//        int B= sc.nextInt();
 int []arr= {24, 33, 13, 11, 30, 28, 19, 8, 30, 25, 42, 6, 30, 49, 3, 49, 24, 13, 3, 50};
 int B=13;
        int result=solve(arr,B);
        System.out.println(result);
    }

}
