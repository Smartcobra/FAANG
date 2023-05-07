package SUBARRAY_OR;

import java.util.ArrayList;

public class SubArray_OR2 {
    public static int solve(ArrayList<Integer> A) {
        int n=A.size();
        long ans = 0;
        int totalNoSubArr= (n*(n+1))/2;
        int MOD=1000000007;

       // long zeroSum=0; //// how many subarrays have OR==0;
      //  long count=0;  // will count continious zero  11100011001100 /// here no of zero= 3+2+2=7
        long oneSum=0;
        for(int i=0;i<32;i++){
            long zeroSum=0;
            long count=0;
             for(int j=0;j<n;j++){
                 if(((A.get(j)>>i)&1)!=1){  //check ith bit ==0 or not
                     count++;
                 }else{
                     // if not zero count the no of subarrays form due to this zero   // we encounter with 1
                     zeroSum=zeroSum+ (count*(count+1))/2;
                     count=0;
                 }
             }
            zeroSum=zeroSum+ (count*(count+1))/2;  // for zeros at last if there is no 1's
            oneSum=totalNoSubArr-zeroSum;   /// total no of element contributing if ith palce is zero;
            ans=(ans+(oneSum*(1<<i)))%MOD;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);

        System.out.println(solve(A));
    }
}
