package rotateArray;

import java.util.Scanner;

public class RotateArrayByK {
    public static int[] rotateArrayStart_End(int arr[],int start,int end){

        while(start<=end){
            int tmp=arr[start];
            arr[start]=arr[end];
            arr[end]=tmp;
            start++;
            end--;
        }
        return arr;
    }

    public static int[] rotateArray(int[] arr, int k){
        if(k>arr.length){
            k=k%arr.length;
        }

        int[] arr1 =rotateArrayStart_End(arr,0,arr.length-1);
        int[] arr2 =rotateArrayStart_End(arr1,0,k-1);
        int []arr3=rotateArrayStart_End(arr2,k,arr.length-1);

        return arr3;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int a[] = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] result = rotateArray(a, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");

        }
    }
}
