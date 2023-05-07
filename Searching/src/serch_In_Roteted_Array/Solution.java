package serch_In_Roteted_Array;

public class Solution {
    public static int search(final int[] A, int B) {
        int ans = 0;
        int k = pivot(A);
      //  System.out.println(k);
        //0-k-1
        if (A[0] < A[A.length - 1]) {
            ans = binarySearch(A, 0, A.length - 1, B);
        } else if (B < A[0]) {
            ans = binarySearch(A, k, A.length - 1, B);
        } else {
            ans = binarySearch(A, 0, k - 1, B);
        }
        return ans;

    }

    public static int pivot(int[] A) {
        int k = 0;
        int l = 0;
        int h = A.length - 1;

        while (l <= h) {
            int mid = (l + h) / 2;
            if (A[mid] < A[0]) {   // pivot element is always greater than the first element
                /// if my current mid is less  than  A[0]  , this can be a potential ans and we can find less small than current mid towards left
                k = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }

    public static int binarySearch(int[] A, int start, int end, int B) {
        int l = start;
        int h = end;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (A[mid] == B) return mid;
            else if (A[mid] > B) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] A = {1, 7, 67, 133, 178};
//        int B = 1;
        int[] A={4, 5, 6, 7, 0, 1, 2, 3};
        int B=2;
        System.out.println(search(A, B));

    }
}
