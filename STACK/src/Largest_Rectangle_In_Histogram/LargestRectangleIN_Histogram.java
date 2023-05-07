package Largest_Rectangle_In_Histogram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleIN_Histogram {
    public static int largestRectangleArea(ArrayList<Integer> A) {
        int n=A.size();
        ArrayList<Integer> left=nearSmallest_left(A);
        ArrayList<Integer> right=nearSmallest_Right(A);
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            int val=right.get(i)-left.get(i)-1;
             ans=Math.max(ans,val*A.get(i));
        }

        return ans;
    }

    public static ArrayList<Integer> nearSmallest_left(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                ans.set(i, stack.peek());
            }

            stack.push(i);
        }

        return ans;
    }

    public static ArrayList<Integer> nearSmallest_Right(ArrayList<Integer> A) {
        int n = A.size();
        int ele = A.get(n - 1);
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, n));
       // ans.add(n,ele);


        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.size() > 0) {
                ans.set(i, stack.peek());
            }

            stack.push(i);
        }

        return ans;

    }

    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();  //2, 1, 5, 6, 2, 3
//        list.add(2);
//        list.add(1);
//        list.add(5);
//        list.add(6);
//        list.add(2);
//        list.add(3);

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(nearSmallest_left(list));
        System.out.println(nearSmallest_Right(list));
        System.out.println(largestRectangleArea(list));
    }

}
