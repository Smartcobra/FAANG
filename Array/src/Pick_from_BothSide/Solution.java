package Pick_from_BothSide;

public class Solution {

    public static int solve(int[] arr, int B){

        int left=0;
        int right=arr.length-1;
        int leftSum=0;
        int rightSum=0;
        int maxSum=0;
        int n=arr.length;

        while(right>=n-B){   //if b=3 and arr.length=5 right sum should contain index 2+3+4;
            rightSum+=arr[right];
            right--;
        }
        maxSum=rightSum;
        right++;


        while(left<B){
            leftSum +=arr[left++];
            rightSum -=arr[right++];
            maxSum=Math.max(maxSum,leftSum+rightSum);


        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[]= {5,-2,3,1,2};
        System.out.println(solve(arr,3));
    }
}
