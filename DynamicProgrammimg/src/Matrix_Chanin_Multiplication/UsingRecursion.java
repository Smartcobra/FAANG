package Matrix_Chanin_Multiplication;

public class UsingRecursion {
    public int getMinMatrixChainOrder(int arr[], int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = getMinMatrixChainOrder(arr, i, k) + getMinMatrixChainOrder(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            if (count < min) {
                min = count;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        UsingRecursion ur= new UsingRecursion();
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println(
                "Minimum number of multiplications is "
                        + ur.getMinMatrixChainOrder(arr, 1, n - 1));
    }
}
