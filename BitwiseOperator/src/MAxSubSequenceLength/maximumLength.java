package MAxSubSequenceLength;

public class maximumLength {
    public static int maximumLength(int arr[], int N) {
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            int length = 0;

            for (int i = 0; i < N; i++) {
                //  if ((arr[i] & (1 << bit)) > 1) {
                if (((arr[i] >> bit) & 1) == 1) {
                    length++;
                }
            }
            ans = Math.max(ans, length);
        }

        return ans;
    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {3, 1, 6, 2, 2};
        int N = arr.length;
        System.out.println(maximumLength(arr, N));
    }
}

