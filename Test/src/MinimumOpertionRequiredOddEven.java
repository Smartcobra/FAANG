import java.util.Arrays;

public class MinimumOpertionRequiredOddEven {

    public static int minOperations(int arr[]) {
        int n= arr.length;
        // Two variables to count number of operations
        int result1 = 0, result2 = 0;
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            if (i % 2 == 0) {
                if (element % 2 == 0)
                    continue;
                else {
                    while (element % 2 == 1) {
                        element /= 2;
                        result1++;
                    }
                }
            }

            // For odd indices
            else {
                // If element is already odd
                if (element % 2 == 1)
                    continue;
                else {
                    while (element % 2 == 0) {
                        element /= 2;
                        result1++;
                    }
                }
            }
        }

        // For array starting from odd element
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            if (i % 2 == 0) {
                if (element % 2 == 1)
                    continue;
                else {
                    while (element % 2 == 0) {
                        element /= 2;
                        result2++;
                    }
                }
            }

            // For odd indices
            else {
                if (element % 2 == 0)
                    continue;
                else {
                    while (element % 2 == 1) {
                        element /= 2;
                        result2++;
                    }
                }
            }
        }
        return Math.min(result1, result2);
    }


    public static void main(String[] args) {
        int[] arr = { 6,5,9,7,3 };

        // Function call
        System.out.print(minOperations(arr));
    }
}
