package Seats;

import java.util.ArrayList;

public class SeatsBetter {
    public static int seats_Better(String A) {
        int n=A.length();
        int MOD=1000*1000*1000+7;
        int ans=0;
        int start=0;
        int end=0;
        int mid=0;
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(A.charAt(i)=='x'){
                arr.add(i);
            }
        }
        mid=arr.size()/2;
        for(int i=0;i<arr.size();i++){
            start=arr.get(i);
            end=arr.get(mid)-mid+i;
            ans=ans+Math.abs(end-start);
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "....x..xx...x..";
        System.out.println(seats_Better(s));
    }
}
