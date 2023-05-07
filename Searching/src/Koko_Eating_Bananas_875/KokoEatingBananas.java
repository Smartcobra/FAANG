package Koko_Eating_Bananas_875;

import sun.security.mscapi.CPublicKey;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        //find max
        int max = Integer.MIN_VALUE;
        for (int p : piles) {
            max = Math.max(max, p);
        }

        if (h == piles.length) return max;

        ///binary search for other case
        int low = 0;
        int high = max;
        int speed = Integer.MAX_VALUE;

        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(isPossible(piles,mid,h)){
                speed =mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return speed;
    }

    public static boolean isPossible(int[] piles, int sp, int h) {
        int time = 0;    // time taken to finish all bananas in piles.

        for (int p : piles) {
            int eachPile = (int) Math.ceil(p * 1.0 / sp);   // time taken to finish each pile
            time = time + eachPile;
        }

        return time <= h;
    }

    public static void main(String[] args) {
       int[] piles = {3,6,7,11}; int h = 8;

        System.out.println(minEatingSpeed(piles,h));
    }
}
