package All_Subarrays;

import java.util.ArrayList;
import java.util.Stack;

public class AllSubarrays {
    public static int solve(ArrayList<Integer> A) {
        int n=A.size();
        int ans=-1;
        Stack<Integer> fStack= new Stack<>();
        Stack<Integer> bStack= new Stack<>();

        for(int i=0;i<n;i++){

            while(!fStack.isEmpty() && A.get(i)<A.get(fStack.peek())){
                ans= Math.max(ans, A.get(i)^A.get(fStack.peek()));
                fStack.pop();
            }
            fStack.add(i);

            while(!bStack.isEmpty() && A.get(n-i-1)<A.get(bStack.peek())){
                ans= Math.max(ans, A.get(n-i-1)^A.get(bStack.peek()));
                bStack.pop();
            }
            bStack.add(n-i-1);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A= new ArrayList<>();
        A.add(8);
        A.add(1);
        A.add(2);


        ArrayList<Integer> B= new ArrayList<>();
        B.add(9);
        B.add(8);
        B.add(3);
        B.add(5);
        B.add(7);

        System.out.print(solve(B));
    }
}
