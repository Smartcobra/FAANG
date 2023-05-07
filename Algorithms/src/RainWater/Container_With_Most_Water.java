package RainWater;

public class Container_With_Most_Water {
    public int trap(final int[] A) {
        int n = A.length;
        int res = 0;

        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        int[] W = new int[n];

        int left = 0;
        for (int i = 0; i < n; i++) {
            int curr = A[i];
            leftmax[i] = left;
            left = Math.max(left, curr);
        }

        int right = 0;
        for (int i = n - 1; i >= 0; i--) {
            int curr = A[i];
            rightmax[i] = right;
            right = Math.max(right, curr);
        }


        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(leftmax[i], rightmax[i]);
            if (A[i] < minHeight) {
                W[i] = minHeight - A[i];
            } else {
                W[i] = 0;
            }
            res += W[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Container_With_Most_Water cw= new Container_With_Most_Water();
        int []arr={1,8,6,2,5,4,8,3,7};
        System.out.println(cw.trap(arr));

    }
}
