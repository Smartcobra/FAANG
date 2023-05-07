package VeryLargePower;

public class Solution {
    public int solve(int A, int B) {
        // long MOD=1000000007;
        long mod = 1000000007;
        long r=raisedPower(B);
        long pow=power(A,r,mod);

        return (int)(pow);

    }
    public long raisedPower(int B){
        long mod=1000000006;
        long ans=1;
        for(int i=1;i<=B;i++){
            ans= ((ans%mod)*(i%mod))%mod;
        }

        return ans;
    }

    public long power(int A,long r,long M){

        if(r==0){
            return 1;
        }
        if(r==1){
            return A%M;
        }
        long p=  power(A,r/2,M);
        if((r&1)==0){
            return (p%M*p%M)%M;
        }else {
            return (A%M*p%M*p%M)%M;
        }
    }
}
