package Rearrange_Positive_Negative_0_intact_Place;

/*
*
*         Input:  [12 11 -13 -5 6 -7 5 -3 -6,0]
          Output: [-13 -5 -7 -3 -6 0 12 11 6 5]
          *
          * Time Complexity: O(n*window)
          Auxiliary Space: O(1), since no extra space has been taken.
* */
public class Solution {
    public static void rearrangePosNegWithOrder(int[] arr){
        int n=arr.length;
        int i=0;
        int j=0;

        while(j<n){
            if (arr[j] <= 0) {
                for (int k = j; k > i; k--) {
                    int tmp = arr[k];
                    arr[k] = arr[k - 1];
                    arr[k - 1] = tmp;
                }
                i++;
            }
            j++;
        }

        /*
        *
        * while(j<n){
            if(arr[j]>0){
                j++;
            }else {
                for(int k=j;k>i;k--){
                    int tmp=arr[k];
                    arr[k]=arr[k-1];
                    arr[k-1]=tmp;
                }
                i++;
                j++;
            }
        }*/
    }

    public static void main(String[] args) {
       // int[] arr = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
        int[] arr = { -12, 11, -13, -5, 6,7,-9,3,-22,45, -7, 5, -3, -6,0 };


        rearrangePosNegWithOrder(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
