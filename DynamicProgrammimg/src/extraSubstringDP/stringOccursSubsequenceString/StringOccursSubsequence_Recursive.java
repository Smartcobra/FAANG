package extraSubstringDP.stringOccursSubsequenceString;

public class StringOccursSubsequence_Recursive {
    public static int countSubSequences(String str1,String str2){
       int m=str1.length();
       int n=str2.length();

        return countSubSequencesHelper(str1,str2,m,n);
    }

    private static int countSubSequencesHelper(String str1, String str2, int m, int n) {
        if(n==0){
            return 1;
        }

        if(m==0){
            return 0;
        }

        if(str1.charAt(m-1)==str2.charAt(n-1)){
            return countSubSequencesHelper(str1,str2,m-1,n-1)+countSubSequencesHelper(str1,str2,m-1,n);
        }else{
            return countSubSequencesHelper(str1,str2,m-1,n);
        }
    }

    public static void main(String[] args) {
        String str2 = "Gks";
        String str1 = "GeeksforGeeks";
        //String str1 = "subsequence";   // input string
        //String str2 = "sue";
        System.out.println(countSubSequences(str1,str2));
    }
}
