package Delete_One_GCD;

public class Solution {
    public static int solve(int[] A) {
        int n=A.length;
        int [] gcd_prefix= new int [n];
        int [] gcd_sufix= new int [n];

        gcd_prefix[0]=A[0];

        for(int i=1;i<n;i++){
            gcd_prefix[i]= gcd(gcd_prefix[i-1],A[i]);
        }

        gcd_sufix[n-1]=A[n-1];
        for(int i=n-2;i>=0;i--){
            gcd_sufix[i]= gcd(gcd_sufix[i+1],A[i]);
        }

        int ans= Math.max(gcd_prefix[n-1],gcd_sufix[0]);

        for(int i=1;i<n-1;i++){
            ans=Math.max(ans,gcd(gcd_prefix[i-1],gcd_sufix[i+1]));
        }

        return ans;
    }

    public static int gcd(int a,int b){
        if(b==0) return a;

        return gcd (b,a%b);
    }

    public static void main(String[] args) {
        int [] a= {21, 7, 3, 42, 63};
       System.out.println(solve (a));
       // System.out.println(gcd(42,63));
    }
}
