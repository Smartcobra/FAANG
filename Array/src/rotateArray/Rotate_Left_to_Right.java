package rotateArray;


import java.util.Arrays;

/*
*
* Input:
        arr[] = {1, 2, 3, 4, 5, 6, 7}, d = 2
        Output: 3 4 5 6 7 1 2

        Input: arr[] = {3, 4, 5, 6, 7, 1, 2}, d=2
        Output: 5 6 7 1 2 3 4
        *
 */
public class Rotate_Left_to_Right {

    public int[] leftRotate(int[] arr, int d) {
        int n = arr.length;

        if (d > n) {
            d = d % n;
        }

        reverse(arr, 0, n - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1 - d);

        return arr;
    }

    public void reverse(int[] arr, int i, int j) {
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;

        Rotate_Left_to_Right lr= new Rotate_Left_to_Right();
        System.out.println(Arrays.toString(lr.leftRotate(arr, d)));
    }
}
