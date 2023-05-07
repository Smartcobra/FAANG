package SubArrayLength;

//Return maximum size subarray of A having only non-negative elements. If there are more than one such subarrays,
//        return the one having earliest starting index in A.

/////wrong
public class PrintSubArray {
    public static void printSubArray(int[] arr) {
        int N = arr.length;
        int count = 0;
        int result = 0;
        int end = 0;
        int start=0;
        int length=0;
        int max=0;


        for (int i = 0; i < N; i++) {
            end = i;
            count = 0;
            while (end < N && arr[end] >= 0) {
                count++;
                end++;

            }
            if (result < count) {
                result = count;
                start=i;
                end = end - 1;
                length=end-start;
                max=Math.max(max,length+1);
                System.out.println(max);
                System.out.println(start + "--" + end);
            }

        }
    }

    public static void main(String[] args) {
        int[] A = {-5173778, -8176176, 1694510, 7089884, -1394259, 1146372, -2502339, 1544618, 6602022, 4330572};

        printSubArray(A);
    }


}
