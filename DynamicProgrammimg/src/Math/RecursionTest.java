package Math;

public class RecursionTest {
    public int getSum(int n){
        if(n==0 || n==1){
            return 2;
        }
        int sum=0;
        for (int i=1;i<n;i++){
            sum= sum+(2*getSum(i)*getSum(i-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        RecursionTest dt = new RecursionTest();
        System.out.println(dt.getSum(3));
    }
}
