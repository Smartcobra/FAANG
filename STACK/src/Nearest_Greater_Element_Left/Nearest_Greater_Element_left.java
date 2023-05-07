package Nearest_Greater_Element_Left;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Nearest_Greater_Element_left {
    public static ArrayList<Integer> prevGreater_Right(ArrayList<Integer> A) {
        int n= A.size();
        ArrayList<Integer> result= new ArrayList<>(Collections.nCopies(n,-1));
        Stack<Integer> stack= new Stack<>();

        for(int i=0;i<n;i++){

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
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(prevGreater_Right(list));
        // System.out.println(prevSmaller(list));
    }
}
