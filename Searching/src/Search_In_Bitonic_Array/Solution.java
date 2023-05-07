package Search_In_Bitonic_Array;


import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int solve(List<Integer> A, int B) {

        int ansL = 0;
        int ansR = 0;
        int k = bitonicIndex(A);
//        System.out.println(k);
//        System.out.println(A.get(k));


        ansL = binarySearchLeft(A, 0, k - 1, B);
        ansR = binarySearchRight(A, k + 1, A.size() - 1, B);
        if (A.get(k) == B) {
            return k;
        } else {
            return Math.max(ansL, ansR);
        }


    }

    public static int binarySearchRight(List<Integer> A, int start, int end, int B) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) > B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchLeft(List<Integer> A, int start, int end, int B) {
        int low = start;
        int high = end;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bitonicIndex(List<Integer> A) {
        int low = 0;
        int high = A.size() - 1;
        int k = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                k = mid;
                break;
            } else if (A.get(mid) < A.get(mid - 1)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }

    public static void main(String[] args) {

//        // int B= 20;
       // List<Integer> places = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11);
      //  int B = 12;
        List<Integer> places = Arrays.asList(1, 2, 3, 4, 5, 10, 9, 8, 7, 6);
        int B = 5;
//
//        System.out.println(solve(places, B));

        // List<Integer> places = Arrays.asList(1, 7, 67, 133, 178);
        //int B = 1;
//       List<Integer> places = Arrays.asList(4, 5, 6, 7, 0, 1, 2, 3);
//        int B=2;
        System.out.println(solve(places, B));
    }
}
