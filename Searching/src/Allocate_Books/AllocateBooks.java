package Allocate_Books;

public class AllocateBooks {
    public static int books(int[] A, int B) {


        int n = A.length;
        int end = 0;  // end is the sum of the all element
        int start = Integer.MAX_VALUE; // start is the min of the arry
        int result = 0;
        if (n < B) return -1;

        for (int i = 0; i < n; i++) end += A[i];

        for (int j : A) {
            start = Math.min(start, j);
        }


        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(A, mid, B)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int[] A, int mid, int B) {

        int no_Student = 1;
        int curr_sum = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            if (A[i] > mid) return false;

            if (A[i] + curr_sum > mid) {
                no_Student++;
                curr_sum = A[i];
                if (no_Student > B) return false;
            } else {
                curr_sum += A[i];
            }
        }
        return true;
}

    public static void main(String[] args) {
        int[] A = {12, 34, 67, 90};
        int B = 2;
        System.out.println(books(A, B));

    }
}
