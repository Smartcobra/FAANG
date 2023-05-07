package LongestSubstringWithoutRepeatingCharacters;

public class BruteForce {
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();
        int result = 0;

        //iterate over the string
        //form substring from i, j
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checks(str, i, j)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    ////checking for duplicate string between i and j
    private boolean checks(String str, int start, int end) {
        int[] chars = new int[128];

        for (int i = start; i <= end; i++) {
            char c = str.charAt(i);
            chars[c]++;

            if (chars[c] > 1) {
                return false;
            }
        }

        return true;
    }
}
