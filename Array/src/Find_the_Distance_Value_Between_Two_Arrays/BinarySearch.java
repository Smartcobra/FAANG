package Find_the_Distance_Value_Between_Two_Arrays;

import java.util.Arrays;

public class BinarySearch {
    public static int   findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count=0;

        for(int val :arr1){
            if(notInRange(arr2,val-d,val+d)){
                count++;
            }
        }

        return count;
    }

    public static boolean notInRange(int[] arr, int from,int to){
        int s=0;
        int e=arr.length-1;

        while(s<=e){
            int mid = (s+e)/2;

            if(arr[mid]>=from && arr[mid]<=to){
                return false;
            }else if(arr[mid] <from){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1= {4,5,8};
        int[] arr2={10,9,1,8};
        int d=2;
        System.out.println(findTheDistanceValue(arr1,arr2,d));
    }
}
