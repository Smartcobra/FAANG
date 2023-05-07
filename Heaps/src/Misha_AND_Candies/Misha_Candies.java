package Misha_AND_Candies;

import java.util.ArrayList;
import java.util.PriorityQueue;

///https://www.scaler.com/academy/mentee-dashboard/class/41002/homework/problems/1192?navref=cl_tt_lst_nm
public class Misha_Candies {


    public static int solve(ArrayList<Integer> A, int B) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(A);
        int total = 0;
        while (!minHeap.isEmpty()) {
            int val = minHeap.poll();
            if (val <= B) {
                int eat = (val / 2);
                int a_eat = (int) Math.floor(eat);
                total += a_eat;
                int remain = val - a_eat;
                if(!minHeap.isEmpty()){
                    minHeap.add(minHeap.poll() + remain);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input= new ArrayList<>();
        input.add(3);
        input.add(2);
        input.add(3);
        System.out.println(solve(input,4));

        ArrayList<Integer> input2= new ArrayList<>();
        input2.add(1);
        input2.add(2);
        input2.add(1);
        System.out.println(solve(input2,2));

        ArrayList<Integer> input3= new ArrayList<>();
        input3.add(705);
        System.out.println(solve(input3,895));

    }
}
