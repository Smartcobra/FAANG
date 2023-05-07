package Container_With_Most_Water;

////https://leetcode.com/problems/container-with-most-water/
public class Container_With_Most_Water {
    public int maxArea(int[] A) {
        int n = A.length;

        int result = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(A[right], A[left]);

            int area = w * h;
            result = Math.max(area, result);

            if (A[left] < A[right]) {
                left++;
            } else if (A[right] < A[left]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return result;

    }

}
