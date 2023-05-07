package Noble_Integers_Array;

/*
*     Sort the Array arr[] in ascending order. This step takes (O(nlogn)).
    Iterate through the array. Compare the value of index i to the number of elements after index i.
    * If arr[i] equals the number of elements after arr[i], it is a noble Integer. Condition to check: (A[i] == length-i-1). This step takes O(n).*/

import java.util.Arrays;

public class Solution2 {

    public static int nobleInteger(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        for(int i=0;i<n-1;i++){
            //duplicate checking
            if(arr[i]==arr[i+1]) continue;

            if(arr[i] == n-1-i) return arr[i];
        }
        //boundary condition if last element is 0  /// for negetive case
        if(arr[n-1]==0){
            return arr[n-1];
        }


        return -1;
    }

    public static void main(String[] args) {
      ///  int [] arr = {10, 3, 20, 40, 2};
       // int [] arr = {5, 6, 2};

        int [] arr = {-4, -2, 0, -1, -6};



        int res = nobleInteger(arr);
        if (res != -1)
            System.out.println("The noble integer is "+ res);
        else
            System.out.println("No Noble Integer Found");
    }

}
