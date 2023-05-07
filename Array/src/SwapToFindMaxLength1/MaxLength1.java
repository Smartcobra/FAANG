package SwapToFindMaxLength1;

public class MaxLength1 {
    // Length of longest consecutive ones by at most one swap in a Binary String

    //Given a Binary String of length N . It is allowed to do at most one swap between any 0 and 1.
    // The task is to find the length of the longest consecutive 1’s that can be achieved.

    public static int solve(String str) {
        int n = str.length();
        int count_1 = 0;
        int max_count = 0;
        int tmp = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int flag = 0;

        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '1') {
                count_1++;
                tmp++;
            }
        }

        //left
        if (str.charAt(0) == '1') {
            left[0] = 1;
        } else {
            left[0] = 0;
        }

        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == '1') {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }///left end

        //right
        if (str.charAt(n - 1) == '1') {
            right[n - 1] = 1;
        } else {
            left[n - 1] = 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }///right end

        //
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            if (str.charAt(i) == '0') {
                int sum = left[i - 1] + right[i + 1];
                if (sum < count_1) {
                    max_count = Math.max(max_count, sum + 1);
                } else {
                    max_count = Math.max(max_count, sum);

                }
            }
            flag = 1;
        }
        if (flag == 0) {
            max_count = count_1;
        }
        return max_count;
    }

    public static void main(String[] args) {
       // String str = "010100110101";
        //String str="1101001100101110";
         String str="01";
        //String str="010100110101";
        // String str="111000";
        //  String str="000000111";
        System.out.println(solve(str));
    }
}
