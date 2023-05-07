package STRING_MATCHING.KMP;

public class Solution {
    public int solve(String A) {
        int n=A.length();
        int [] lps=new int[n];
        getLPS(A,lps);
        return n-lps[n-1];
    }

    public void getLPS(String A,int [] lps){
        int x;
        lps[0]=0;

        for(int i=1;i<lps.length;i++){
            x=lps[i-1];   //value at i-1
            while(A.charAt(i) !=A.charAt(x)){
                if(x==0) {
                    x=-1;
                    break;
                }
                x=lps[x-1];
            }
            lps[i]=x+1;
        }
    }
}
