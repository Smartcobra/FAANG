package Inversion_Count_In_An_Array;

public class solution {
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
            if (arr[p2] < arr[p1]) {
                tmp[p3] = arr[p2];
                p2++;
                p3++;
                count += m - p1 + 1;
            } else {
                tmp[p3] = arr[p1];
                p1++;
                p3++;
            }
        }

        /*   we can use this also
        *
        while(p1<=m && p2<=e){
           if(arr[p1]<=arr[p2]){
               tmp[p3]=arr[p1];
               p1++;
               p3++;

           }else{
               tmp[p3]=arr[p2];
               p2++;
               p3++;
               count += (m-p1+1)%MOD;
           }
       }
        *
        *
        *
        *
        * */

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
       // int []A = {28, 18, 44, 49, 41, 14 };
        int [] A={1,3, 2, 3, 1};
        System.out.println(solve(A));
    }
}
