package Shortest_Palindrome_214;

public class SolutionBruteForce {
    public String shortestPalindrome(String s) {
        int end = s.length() - 1;

        while (end >= 0) {
            if (isPalindrome(s, 0, end)) {
                break;
            }
            end--;
        }

        String sufix = s.substring(end + 1);
        String rSufix = new StringBuilder(sufix).reverse().toString();
        return rSufix + s;

    }

    private boolean isPalindrome(String s, int start, int end) {

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
