package Reverse_Words_in_a_String;

public class Solution {
    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        int n = str.length;

        // Step 1: Reverse the entire string
        reverse(str, 0, n - 1);

        // Step 2: Reverse each word in place
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (str[end] == ' ') {
                reverse(str, start, end - 1);
                start = end + 1;
            }
        }
        // Reverse the last word
        reverse(str, start, n - 1);

        return new String(str);
    }

    // Helper function to reverse characters in a char array
    private static void reverse(char[] str, int left, int right) {
        while (left < right) {
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        System.out.println("Original: " + sentence);
        String reversed = reverseWords(sentence);
        System.out.println("Reversed: " + reversed);
    }

}
