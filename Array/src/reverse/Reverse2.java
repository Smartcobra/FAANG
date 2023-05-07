package reverse;

public class Reverse2 {
    public int[] reverse(int[] arr) {
        int n = arr.length;
        int l = 0;
        int h = n - 1;

        while (l <= h) {
            swap(l, h, arr);
            l++;
            h--;
        }
        return arr;
    }

    public void swap(int i, int j, int[] arr) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
