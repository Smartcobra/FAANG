
//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class Maximum_Number_Vowels_In_Substring_Given_Length {

    public int maxVowels(String s, int k) {
        int n = s.length();
        int count = 0;
        int maxCount = Integer.MIN_VALUE;

        int j = 0;
        int i = 0;
        while (j < n) {
            if (isVowel(s.charAt(j))) {
                count++;
            }

            if (j - i + 1 == k) {
                maxCount = Math.max(maxCount, count);
                if (isVowel(s.charAt(i))) {
                    count--;
                }
                i++;
            }
            j++;

        }
        return maxCount;
    }

    private boolean isVowel(char c) {

        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }


}
