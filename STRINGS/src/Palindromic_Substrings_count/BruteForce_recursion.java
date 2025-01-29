package Palindromic_Substrings_count;

public class BruteForce_recursion {
    public static int countPalindrome(String s){
        int n= s.length();
        int count=0;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        if(start>end){
            return true;
        }

        if(s.charAt(start) == s.charAt(end)){
            return isPalindrome(s,start+1,end-1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(countPalindrome("a"));
    }
}
