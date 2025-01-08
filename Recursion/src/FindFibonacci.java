public class FindFibonacci {

    public int getFbn(int n){

        if (n==0 || n==1){
            return n;
        }

        return getFbn(n-1)+getFbn(n-2);

    }
    ///TC => 2^n
}
