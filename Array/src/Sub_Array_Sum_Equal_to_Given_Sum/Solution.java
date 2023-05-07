package Sub_Array_Sum_Equal_to_Given_Sum;

/*
 * Given an unsorted array arr of non negative integers and an integer sum,
 * find a continuous subarray which adds to a given sum. There may be more than one subarrays with sum as the given sum, print first such subarray.
 * */

public class Solution {
    public static void findSubArray(int[] arr,int target) {
        int n = arr.length;
        int sum = 0;
        //int start=0;
       // int end=0;
        for (int i = 0; i <n; i++) {
            sum=arr[i];
            for(int j=i+1;j<=n;j++){  //j<=n because we move i till n-1
                if(sum>target ||j==n) break;
                sum +=arr[j];

                if(sum==target){
                   int start=i;
                   int end=j;
                    System.out.println(start +"-"+end);
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
        int n = arr.length;
        int sum = 23;
        findSubArray(arr,sum);

    }
}
