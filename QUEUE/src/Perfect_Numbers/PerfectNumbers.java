package Perfect_Numbers;

import java.util.LinkedList;
import java.util.Queue;
//https://www.scaler.com/academy/mentee-dashboard/class/35015/assignment/problems/3297/?navref=cl_pb_nv_tb
public class PerfectNumbers {
    public static  String solve(int A) {
        Queue<String> q= new LinkedList<>();
        q.add("11");
        q.add("22");

        while(A-1!=0){
          String var=q.peek();
          int len=var.length();
          String s1=var.substring(0,len/2);
          String s2=var.substring(len/2,len);

          q.add(s1+"11"+s2);
          q.add(s1+"22"+s2);

          q.remove();

            A--;
        }

        return q.peek();
    }

    public static void main(String[] args) {
        System.out.println(solve(3));
        System.out.println(solve(4));
        System.out.println(solve(5));
        System.out.println(solve(6));
        System.out.println(solve(7));
        System.out.println(solve(8));
        System.out.println(solve(9));
    }
}
