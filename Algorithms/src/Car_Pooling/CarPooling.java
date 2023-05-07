package Car_Pooling;

////https://leetcode.com/problems/car-pooling/
public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
//    trips[i] = [numPassengersi, fromi, toi]

        int lastDropLocation = -1;
        for (int[] trip : trips) {
            lastDropLocation = Math.max(lastDropLocation, trip[2]);
        }

        int[] highWay = new int[lastDropLocation + 1];

        for (int[] trip : trips) {
            if (trip[0] > capacity) {
                return false;
            } else {
                highWay[trip[1]] += trip[0];
                highWay[trip[2]] -= trip[0];
            }

            for (int i = 1; i <= lastDropLocation; i++) {
                highWay[i] += highWay[i - 1];
                if (highWay[i] > capacity) {
                    return false;
                }
            }


        }
        return true;
    }


    public static void main(String[] args) {
        int[][] trips = {{9, 0, 1}, {3, 3, 7}};
        //trips[i] = [numPassengersi, fromi, toi]
        System.out.println(carPooling(trips, 4));
    }
}
