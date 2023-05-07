package Nearest_Greater_Element_Right;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
//https://www.scaler.com/academy/mentee-dashboard/class/35014/homework/problems/263/?navref=cl_pb_nv_tb
public class Solution {
    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        int n= A.size();
        ArrayList<Integer> result= new ArrayList<>(Collections.nCopies(n,-1));
        Stack<Integer> stack= new Stack<>();

        for(int i=n-1;i>=0;i--){

            while(stack.size()>0 && A.get(i) >= stack.peek()){
                stack.pop();
            }
            if(stack.size()>0){
                result.set(i,stack.peek());
            }

            stack.push(A.get(i));

        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();  //2, 1, 5, 6, 2, 3
//        list.add(2);
//        list.add(1);
//        list.add(5);
//        list.add(6);
//        list.add(2);
//        list.add(3);

        list.add(34);
        list.add(35);
        list.add(27);
        list.add(42);
        list.add(5);
        list.add(28);
        list.add(39);
        list.add(20);
        list.add(28); //35 42 42 -1 28 39 -1 28 -1

        ///34, 35, 27, 42, 5, 28, 39, 20, 28

//        list.add(1);
//        list.add(2);
//        list.add(3);
        System.out.println(nextGreater(list));
    }
}
