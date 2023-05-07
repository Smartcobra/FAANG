package Reverse_Pairs;

public class Solution {
    public static int solve(int[] A) {
        int n = A.length;
        int s = 0;
        int e = n - 1;
        int count = mergeSort(A, s, e);

        return count;
    }

    public static int mergeSort(int[] arr, int s, int e) {
        if (s == e) return 0;

        int m = (s + e) / 2;
        int l = mergeSort(arr, s, m);
        int r = mergeSort(arr, m + 1, e);

        return l + r + merge(arr, s, m, e);
    }

    public static int merge(int[] arr, int s, int m, int e) {
        int[] tmp = new int[e - s + 1];
        int count = 0;
        int p1 = s;
        int p2 = m + 1;
        int p3 = 0;

        while (p1 <= m && p2 <= e) {
            if ((long) arr[p1] >  (2L * arr[p2])) {
                p2++;
                count += m - p1 + 1;
            } else {
                p1++;

            }
        }
        p1 = s;
        p2 = m + 1;
        while (p1 <= m && p2 <= e) {
            if (arr[p1] > arr[p2]) {
                tmp[p3] = arr[p2];
                p2++;
                p3++;
            } else {
                tmp[p3] = arr[p1];
                p1++;
                p3++;
            }
        }


        while (p2 <= e) {
            tmp[p3] = arr[p2];
            p2++;
            p3++;
        }

        while (p1 <= m) {
            tmp[p3] = arr[p1];
            p1++;
            p3++;
        }

        for (int i = 0; i <= e - s; i++) {
            arr[s + i] = tmp[i];
        }

        return count;
    }


    public static void main(String[] args) {
//        int A[] ={14046, 57239, 78362, 99387, 27609, 55100, 65536, 62099, 40820, 33056, 88380, 78549,
//                57512, 33137, 81212, 32365, 42276, 65368, 52459, 74924, 25355, 76044, 78056, 45190, 94365, 58869, 20611};
       // int A[] = {1, 3, 2, 3, 1};

        // int A[] ={2,4,3,1};
        int A[]={2000000000, 2000000000, -2000000000};


        System.out.println(solve(A));
    }
}
