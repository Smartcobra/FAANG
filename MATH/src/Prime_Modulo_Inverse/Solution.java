package Prime_Modulo_Inverse;


//ax+by=gcd(a,b)


class Triplet{
    int x;
    int y;
    int gcd;
}

public class Solution {
    Triplet extendedEuclid(int A,int B){
        Triplet ans= new Triplet();
        if(B==0){
            ans.x=1;
            ans.gcd=A;
            ans.y=0;
            return ans;
        }

        Triplet smallAns= extendedEuclid(B,A%B);
        ans.x=smallAns.y;
        ans.gcd=smallAns.gcd;
        ans.y= smallAns.x-(A/B)*smallAns.y;

        return ans;
    }
    public int solve(int A, int B) {
        Triplet tmp=extendedEuclid(A,B);


        if (tmp.x<0){
            return (tmp.x+B)%B;
        }
        return tmp.x;
    }
}

