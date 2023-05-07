package Co_PRIME;

public class CoPrime {
    public static int cpFact(int A, int B) {
        int index =1;
        for(int i=1;i<=A;i++){
            if(A%i==0 && gcd(i,B)==1)  index=i;
        }
        return index;
    }

    public static int gcd(int a ,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        int A=30;
        int B=12;

        System.out.println(cpFact(A,B));
    }
}
