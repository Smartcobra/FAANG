package Palindromic_Substrings_count;

public class BruteForce {
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

    public static boolean isPalindrome(String s, int i, int j){
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(countPalindrome("a"));
    }
}
