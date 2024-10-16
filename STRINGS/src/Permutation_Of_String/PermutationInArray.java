package Permutation_Of_String;

import java.util.ArrayList;
import java.util.List;

public class PermutationInArray {


    public static void swap(char[] arr, int idx, int idx2) {
        char temp = arr[idx];
        arr[idx] = arr[idx2];
        arr[idx2] = temp;
    }

    private static void solve(char[] arr, int idx, List<String> result) {
        if (idx == arr.length - 1) { // Base condition of recursion
            result.add(String.valueOf(arr));
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            solve(arr, idx + 1, result);
            swap(arr, idx, i); // Backtracking: reverting all the elements to their original places
        }
    }


    public static String[] getAllPermutations(char[] arr) {
        List<String> result = new ArrayList<>();
        solve(arr, 0, result);
        return result.toArray(new String[0]);
    }


    public static void main(String[] args) {
        // Example input
        char[] arr = {'A', 'B', 'C'};

        // Get all permutations as an array of strings
        String[] permutations = getAllPermutations(arr);

        // Print all permutations
        System.out.println("All permutations:");
        for (String perm : permutations) {
            System.out.print(perm + " ");
        }
    }
}
