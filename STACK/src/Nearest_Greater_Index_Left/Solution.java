package Nearest_Greater_Index_Left;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> nearGreater_Index_left(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));

//        for (int i = 0; i < n; i++) {
//            while (stack.size() > 0 && A.get(i) >= A.get(stack.peek())) {
//                stack.pop();
//            }
//            if (stack.size() > 0) {
//                ans.set(i, stack.peek());
//            }
//
//            stack.push(i);
//        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(i) >= A.get(stack.peek())){
                stack.pop();
            }
            if (!stack.isEmpty()){
                ans.set(i, stack.peek());
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();  //2, 1, 5, 6, 2, 3
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(6);
        list.add(2);
        list.add(3);

        System.out.println(nearGreater_Index_left(list));
    }
}
