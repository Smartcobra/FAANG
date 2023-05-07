package GrayCode;

import java.util.ArrayList;

public class Solution2 {
    public static ArrayList<Integer> grayCode(int a) {
        ArrayList<Integer> result= new ArrayList<>();

        if(a==1){
            result.add(0);
            result.add(1);
            return result;
        }
        ArrayList<Integer> pre= grayCode(a-1);
        result.addAll(pre);

        for(int i = pre.size() - 1; i >= 0; i--) {
            result.add(pre.get(i) + (1 << (a-1)));
        }

        return result;
    }

    public static void main(String[] args) {
      //  grayCode(4).forEach(System.out::println);

        System.out.println(1<<3);
    }
}
