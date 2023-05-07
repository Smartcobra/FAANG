package Boring_Substring;

public class FunSolution {
        public int solve (String str){
            int n = str.length();

            int[] count = new int[26];
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                count[c - 'a']++;
            }

            for (int i = 0; i < 25; i++) {
                if (count[i] + count[i + 1] > (n + 1) / 2) return 0;
            }
            return 1;
        }

    public static void main(String[] args) {

    }
}
