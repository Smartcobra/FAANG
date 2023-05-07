package Longest_Palindrome_Subsequence;

public class LPS_Recursive {

    public static int getLPS( String str, int i, int j){

        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }

        if(str.charAt(i)==str.charAt(j)){
            return 2+getLPS(str,i+1,j-1);
        }else{
            return Math.max(getLPS(str,i,j-1),getLPS(str,i+1,j));
        }

    }

    public static void main(String[] args) {
        String X = "aedbcbea";
        int n = X.length();

        System.out.print("The length of the longest palindromic subsequence is "
                + getLPS(X, 0, n - 1));
    }
}
